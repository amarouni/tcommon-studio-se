// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.osgi.hook;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.osgi.internal.hookregistry.BundleFileWrapperFactoryHook;
import org.eclipse.osgi.storage.BundleInfo.Generation;
import org.eclipse.osgi.storage.bundlefile.BundleEntry;
import org.eclipse.osgi.storage.bundlefile.BundleFile;
import org.eclipse.osgi.storage.bundlefile.BundleFileWrapper;
import org.eclipse.osgi.storage.bundlefile.FileBundleEntry;
import org.talend.osgi.hook.notification.JarMissingObservable;

/**
 * created by sgandon on 14 oct. 2014 Detailled comment
 *
 */
public class JarLoaderBundleFileWrapperFactory implements BundleFileWrapperFactoryHook {

    final String listOfBundlePrefixes = System.getProperty("org.talend.bundle.prefixes.for.jar.loader", //$NON-NLS-1$
            "org.talend,com.oaklandsw"); //$NON-NLS-1$

    Set<String> listOfBundlePrefixesSet = null;

    /**
     * created by sgandon on 17 oct. 2014 Detailled comment
     *
     */
    private final class TalendBundleFileWrapper extends BundleFileWrapper {

        private Generation generation;

        Set<String> missingJars;

        /**
         * DOC sgandon BundleFileWrapperExtension constructor comment.
         * 
         * @param bundleFile
         * @param generation
         */
        private TalendBundleFileWrapper(BundleFile bundleFile, Generation generation) {
            super(bundleFile);
            this.generation = generation;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.osgi.storage.bundlefile.BundleFileWrapper#getEntry(java.lang.String)
         */
        @Override
        public BundleEntry getEntry(String path) {
            // we are using te getEntry to trick equinox when a jar file is missing
            BundleEntry be = super.getEntry(path);
            if (be == null && path.endsWith(".jar") && !getMissingJars().contains(path + "/")) { //$NON-NLS-1$ //jar file that does not exists.
                // use the getFile to find the jar from the lib/java folder.
                File file = getFile(path, false);
                if (file != null) {
                    be = new FileBundleEntry(file, path);
                    MissingJarServices
                            .logDebugInfo("fake FileBundleEntry created for :" + generation.getRevision().getSymbolicName() + "/" + path); //$NON-NLS-1$//$NON-NLS-2$

                } else {
                    getMissingJars().add(path + "/");
                }
            } else {
                // check for a fake entry, that is a missing jar already check and create a specific bundle entry so
                // that the Wrapper factory can detect this is a missing jar entry
                if (getMissingJars().contains(path)) {
                    be = new MissingJarBundleEntry(path);
                    MissingJarServices
                            .logDebugInfo("MissingJarBundleEntry created for :" + generation.getRevision().getSymbolicName() + "/" + path); //$NON-NLS-1$//$NON-NLS-2$
                }
            }

            // else be is found or not a jar so don't care.
            return be;
        }

        /**
         * DOC sgandon Comment method "getMissingJars".
         * 
         * @return
         */
        private Set<String> getMissingJars() {
            if (missingJars == null) {
                missingJars = new HashSet<String>();
            }
            return missingJars;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.osgi.storage.bundlefile.BundleFileWrapper#getFile(java.lang.String, boolean)
         */
        @Override
        public File getFile(String path, boolean nativeCode) {
            File file = super.getFile(path, nativeCode);
            if (file == null && path.endsWith(".jar")) { //$NON-NLS-1$ //jar file that does not exists.
                File libJavaFolderFile = MissingJarServices.getLibJavaFolderFile();
                if (libJavaFolderFile != null) {
                    String jarName = new File(path).getName();
                    File jarFile = new File(libJavaFolderFile, jarName);
                    if (jarFile.exists()) {
                        return jarFile;
                    } else {// jar file not found in the lib/java folder
                        // notify any observable to get a chance for the lib to be installed
                        MissingJarServices.getJarMissingObservable()
                                .notifyObservers(
                                        new JarMissingObservable.JarMissingEvent(jarName, generation, libJavaFolderFile
                                                .getAbsolutePath()));
                        MissingJarServices
                                .logDebugInfo("MissingJar notification for :" + generation.getRevision().getSymbolicName() + "/" + path + " (" + MissingJarServices.getJarMissingObservable().countObservers() + " observers)."); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

                        // let's do another check to see if the bundle was installed during the above
                        // notification
                        if (jarFile.exists()) {
                            return jarFile;
                        } // else no jar found so return null
                    }
                }// else //no lib folder found so ignor missing lib
            }// else file found so return default value.
            return file;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.osgi.internal.hookregistry.BundleFileWrapperFactoryHook#wrapBundleFile(org.eclipse.osgi.storage.
     * bundlefile.BundleFile, org.eclipse.osgi.storage.BundleInfo.Generation, boolean)
     */
    @Override
    public BundleFileWrapper wrapBundleFile(BundleFile bundleFile, Generation generation, boolean base) {
        if (canHandleBundle(bundleFile.getBaseFile().getName())) {
            if (base) {// base bundle file so create a Talend wrapper in case one jar is missing
                return new TalendBundleFileWrapper(bundleFile, generation);
            } else {// inner jar or inner folder or missing jar bundle entry
                // only handle missing jar entry
                // we check by calling the getEntry that we have a missing jar
                BundleEntry entry = bundleFile.getEntry(""); //$NON-NLS-1$
                if (entry != null && entry instanceof MissingJarBundleEntry) {
                    String path = ((MissingJarBundleEntry) entry).path;
                    MissingJarServices
                            .logDebugInfo("MissingJarBundleFileWrapper creating for :" + generation.getRevision().getSymbolicName() + "/" + path); //$NON-NLS-1$//$NON-NLS-2$ 
                    return new MissingJarBundleFileWrapper(bundleFile, generation, path);

                }// else not the trick for proxying missign jars so do not create any wrapper.
            }
        }
        return null;// means we do not create any wrapper.
    }

    /**
     * DOC sgandon Comment method "canHandleBundle".
     * 
     * @param bundleSymbolicName
     * @return
     */
    private boolean canHandleBundle(String bundleSymbolicName) {
        if (listOfBundlePrefixesSet == null) {
            String[] prefixesArray = listOfBundlePrefixes.split(","); //$NON-NLS-1$
            listOfBundlePrefixesSet = new HashSet<String>(prefixesArray.length);
            Collections.addAll(listOfBundlePrefixesSet, prefixesArray);
        }
        for (String prefix : listOfBundlePrefixesSet) {
            if (bundleSymbolicName.startsWith(prefix)) {
                return true;
            }// else keep looking
        }
        return false;
    }

}
