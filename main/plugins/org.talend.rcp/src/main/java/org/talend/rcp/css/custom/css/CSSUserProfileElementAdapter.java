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
package org.talend.rcp.css.custom.css;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.dom.CompositeElement;
import org.talend.core.ui.properties.tab.TalendTabbedPropertyList;
import org.talend.core.ui.properties.tab.TalendTabbedPropertyTitle;

/**
 * 
 * created by hcyi on Jan 30, 2015 Detailled comment
 *
 */
public class CSSUserProfileElementAdapter extends CompositeElement {

    public CSSUserProfileElementAdapter(TalendTabbedPropertyList composite, CSSEngine engine) {
        super(composite, engine);
    }

    public CSSUserProfileElementAdapter(TalendTabbedPropertyTitle composite, CSSEngine engine) {
        super(composite, engine);
    }
}