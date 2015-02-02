// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.themes.core.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;

/**
 * created by cmeng on Jan 30, 2015 Detailled comment
 *
 */
public class AutoDisposeQueue extends UIJob {

    public static AutoDisposeQueue DEFAULT_INSTANCE = new AutoDisposeQueue();

    private HashSet<Resource> queue = new HashSet<Resource>();

    private Map<RGB, Color> colorMap = new HashMap<RGB, Color>();

    public AutoDisposeQueue() {
        super(Display.getDefault(), "Auto Dispose Queue");
        setSystem(true);
        setUser(false);
    }

    public void add(Resource r) {
        boolean added = false;
        synchronized (queue) {
            added = queue.add(r);
        }
        if (added) {
            schedule(10);
        }
    }

    public Color getColor(RGB rgb) {
        Color color = colorMap.get(rgb);
        if (color == null) {
            color = new Color(getDisplay(), rgb);
            colorMap.put(rgb, color);
            add(color);
        }
        return color;
    }

    @Override
    public IStatus runInUIThread(IProgressMonitor monitor) {
        Resource[] array = null;

        synchronized (queue) {
            array = queue.toArray(new Resource[queue.size()]);
            queue.clear();
        }

        colorMap.clear();

        if (array != null) {
            for (Resource each : array) {
                if (each != null && !each.isDisposed()) {
                    each.dispose();
                }
            }
        }

        return Status.OK_STATUS;
    }

}
