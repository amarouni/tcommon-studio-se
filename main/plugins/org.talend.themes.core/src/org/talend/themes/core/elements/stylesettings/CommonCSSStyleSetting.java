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
package org.talend.themes.core.elements.stylesettings;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.geometry.Insets;

/**
 * created by cmeng on Jan 30, 2015 Detailled comment
 *
 */
public class CommonCSSStyleSetting {

    public static void copyBorderSetting(Border from, Border to) {
        Insets toInsets = to.getInsets(null);
        Insets fromInsets = from.getInsets(null);
        toInsets.top = fromInsets.top;
        toInsets.bottom = fromInsets.bottom;
        toInsets.left = fromInsets.left;
        toInsets.right = fromInsets.right;
    }
}
