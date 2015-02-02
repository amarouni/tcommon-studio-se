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
package org.talend.themes.core.elements.interfaces;

import org.talend.themes.core.elements.stylesettings.CommonCSSStyleSetting;

/**
 * created by cmeng on Jan 30, 2015 Detailled comment
 *
 */
public interface ICSSStylingChangedListener {

    public void applyChange(CommonCSSStyleSetting setting);
}
