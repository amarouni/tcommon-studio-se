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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.osgi.storage.bundlefile.BundleEntry;

/**
 * This class is created to tell the wrappper Factory that we have a missing Jar entry and that is should create a
 * MissingJarBundleFile.
 *
 */
class MissingJarBundleEntry extends BundleEntry {

    public final String path;

    /**
     * DOC sgandon MissingJarBundleEntry constructor comment.
     * 
     * @param path
     */
    public MissingJarBundleEntry(String path) {
        this.path = path.substring(0, path.length() - 1);
    }

    // all the following method shall never be used.
    @Override
    public long getTime() {
        return 0;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public URL getLocalURL() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public URL getFileURL() {
        return null;
    }
}
