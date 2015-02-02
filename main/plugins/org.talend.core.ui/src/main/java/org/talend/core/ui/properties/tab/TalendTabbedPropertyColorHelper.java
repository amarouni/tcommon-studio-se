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
package org.talend.core.ui.properties.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * created by Talend on Jan 30, 2015 Detailled comment
 *
 */
public class TalendTabbedPropertyColorHelper {

    private Color widgetForeground = null;

    private Color widgetBackground = null;

    private Color widgetNormalShadow = null;

    private Color widgetDarkShadow = null;

    private Color listBackground = null;

    private Color hoverGradientStart = null;

    private Color hoverGradientEnd = null;

    private Color defaultGradientStart = null;

    private Color defaultGradientEnd = null;

    private Color indentedDefaultBackground = null;

    private Color indentedHoverBackground = null;

    private Color navigationElementShadowStroke = null;

    private Color bottomNavigationElementShadowStroke1 = null;

    private Color bottomNavigationElementShadowStroke2 = null;

    private TabbedPropertySheetWidgetFactory factory;

    private boolean isVisibleBorder = true;

    RGB infoBackground = Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND).getRGB();

    RGB white = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE).getRGB();

    RGB black = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK).getRGB();

    // TalendTabbedPropertyTitle
    private Color titleForeground = null;

    private Color titleBackground = null;

    private Color titleBottomForegroundKeyline1 = null;

    private Color titleBottomForegroundKeyline2 = null;

    public TalendTabbedPropertyColorHelper(TabbedPropertySheetWidgetFactory factory) {
        this.factory = factory;
        initColours();
    }

    public Color getWidgetForeground() {
        return this.widgetForeground;
    }

    public void setWidgetForeground(Color widgetForeground) {
        this.widgetForeground = widgetForeground;
    }

    public Color getWidgetBackground() {
        return this.widgetBackground;
    }

    public void setWidgetBackground(Color widgetBackground) {
        this.widgetBackground = widgetBackground;
    }

    public Color getWidgetNormalShadow() {
        return this.widgetNormalShadow;
    }

    public void setWidgetNormalShadow(Color widgetNormalShadow) {
        this.widgetNormalShadow = widgetNormalShadow;
    }

    public Color getWidgetDarkShadow() {
        return this.widgetDarkShadow;
    }

    public void setWidgetDarkShadow(Color widgetDarkShadow) {
        this.widgetDarkShadow = widgetDarkShadow;
    }

    public Color getListBackground() {
        return this.listBackground;
    }

    public void setListBackground(Color listBackground) {
        this.listBackground = listBackground;
    }

    public Color getHoverGradientStart() {
        if (hoverGradientStart == null) {
            initGradient();
        }
        return this.hoverGradientStart;
    }

    public void setHoverGradientStart(Color hoverGradientStart) {
        this.hoverGradientStart = hoverGradientStart;
    }

    public Color getHoverGradientEnd() {
        if (hoverGradientEnd == null) {
            hoverGradientEnd = factory.getColors().createColor("TabbedPropertyList.hoverBackgroundGradientEnd", //$NON-NLS-1$
                    FormColors.blend(widgetNormalShadow.getRGB(), widgetBackground.getRGB(), 10));
        }
        return this.hoverGradientEnd;
    }

    public void setHoverGradientEnd(Color hoverGradientEnd) {
        this.hoverGradientEnd = hoverGradientEnd;
    }

    public Color getDefaultGradientStart() {
        if (defaultGradientStart == null) {
            initGradient();
        }
        return this.defaultGradientStart;
    }

    public void setDefaultGradientStart(Color defaultGradientStart) {
        this.defaultGradientStart = defaultGradientStart;
    }

    public Color getDefaultGradientEnd() {
        if (defaultGradientEnd == null) {
            initGradient();
        }
        return this.defaultGradientEnd;
    }

    public void setDefaultGradientEnd(Color defaultGradientEnd) {
        this.defaultGradientEnd = defaultGradientEnd;
    }

    public Color getIndentedDefaultBackground() {
        if (indentedDefaultBackground == null) {
            initGradient();
        }
        return this.indentedDefaultBackground;
    }

    public void setIndentedDefaultBackground(Color indentedDefaultBackground) {
        this.indentedDefaultBackground = indentedDefaultBackground;
    }

    public Color getIndentedHoverBackground() {
        if (indentedHoverBackground == null) {
            initGradient();
        }
        return this.indentedHoverBackground;
    }

    public void setIndentedHoverBackground(Color indentedHoverBackground) {
        this.indentedHoverBackground = indentedHoverBackground;
    }

    public Color getNavigationElementShadowStroke() {
        if (navigationElementShadowStroke == null) {
            initGradient();
        }
        return this.navigationElementShadowStroke;
    }

    public void setNavigationElementShadowStroke(Color navigationElementShadowStroke) {
        this.navigationElementShadowStroke = navigationElementShadowStroke;
    }

    public Color getBottomNavigationElementShadowStroke1() {
        if (bottomNavigationElementShadowStroke1 == null) {
            initGradient();
        }
        return this.bottomNavigationElementShadowStroke1;
    }

    public void setBottomNavigationElementShadowStroke1(Color bottomNavigationElementShadowStroke1) {
        this.bottomNavigationElementShadowStroke1 = bottomNavigationElementShadowStroke1;
    }

    public Color getBottomNavigationElementShadowStroke2() {
        if (bottomNavigationElementShadowStroke2 == null) {
            initGradient();
        }
        return this.bottomNavigationElementShadowStroke2;
    }

    public void setBottomNavigationElementShadowStroke2(Color bottomNavigationElementShadowStroke2) {
        this.bottomNavigationElementShadowStroke2 = bottomNavigationElementShadowStroke2;
    }

    public boolean isVisibleBorder() {
        return this.isVisibleBorder;
    }

    public void setVisibleBorder(boolean isVisibleBorder) {
        this.isVisibleBorder = isVisibleBorder;
    }

    public Color getTitleForeground() {
        if (titleForeground == null) {
            initTitleGradient();
        }
        return this.titleForeground;
    }

    public void setTitleForeground(Color titleForeground) {
        this.titleForeground = titleForeground;
    }

    public Color getTitleBackground() {
        if (titleBackground == null) {
            initTitleGradient();
        }
        return this.titleBackground;
    }

    public void setTitleBackground(Color titleBackground) {
        this.titleBackground = titleBackground;
    }

    public Color getTitleBottomForegroundKeyline1() {
        if (titleBottomForegroundKeyline1 == null) {
            initTitleGradient();
        }
        return this.titleBottomForegroundKeyline1;
    }

    public void setTitleBottomForegroundKeyline1(Color titleBottomForegroundKeyline1) {
        this.titleBottomForegroundKeyline1 = titleBottomForegroundKeyline1;
    }

    public Color getTitleBottomForegroundKeyline2() {
        if (titleBottomForegroundKeyline2 == null) {
            initTitleGradient();
        }
        return this.titleBottomForegroundKeyline2;
    }

    public void setTitleBottomForegroundKeyline2(Color titleBottomForegroundKeyline2) {
        this.titleBottomForegroundKeyline2 = titleBottomForegroundKeyline2;
    }

    private void initTitleGradient() {
        titleForeground = factory.getColors().getColor(IFormColors.TITLE);
        titleBottomForegroundKeyline1 = factory.getColors().getColor(IFormColors.H_BOTTOM_KEYLINE1);
        titleBottomForegroundKeyline2 = factory.getColors().getColor(IFormColors.H_BOTTOM_KEYLINE2);
    }

    private void initGradient() {
        /*
         * gradient in the default tab: start colour WIDGET_NORMAL_SHADOW 100% + white 20% + INFO_BACKGROUND 60% end
         * colour WIDGET_NORMAL_SHADOW 100% + INFO_BACKGROUND 40%
         */
        defaultGradientStart = factory.getColors().createColor("TabbedPropertyList.defaultTabGradientStart", //$NON-NLS-1$
                FormColors.blend(infoBackground, FormColors.blend(white, widgetNormalShadow.getRGB(), 20), 60));
        defaultGradientEnd = factory.getColors().createColor("TabbedPropertyList.defaultTabGradientEnd", //$NON-NLS-1$
                FormColors.blend(infoBackground, widgetNormalShadow.getRGB(), 40));

        navigationElementShadowStroke = factory.getColors().createColor("TabbedPropertyList.shadowStroke", //$NON-NLS-1$
                FormColors.blend(white, widgetNormalShadow.getRGB(), 55));
        bottomNavigationElementShadowStroke1 = factory.getColors().createColor("TabbedPropertyList.tabShadowStroke1", //$NON-NLS-1$
                FormColors.blend(black, widgetBackground.getRGB(), 10));
        bottomNavigationElementShadowStroke2 = factory.getColors().createColor("TabbedPropertyList.tabShadowStroke2", //$NON-NLS-1$
                FormColors.blend(black, widgetBackground.getRGB(), 5));

        /*
         * gradient in the hover tab: start colour WIDGET_BACKGROUND 100% + white 20% end colour WIDGET_BACKGROUND 100%
         * + WIDGET_NORMAL_SHADOW 10%
         */
        hoverGradientStart = factory.getColors().createColor("TabbedPropertyList.hoverBackgroundGradientStart", //$NON-NLS-1$
                FormColors.blend(white, widgetBackground.getRGB(), 20));

        indentedDefaultBackground = factory.getColors().createColor("TabbedPropertyList.indentedDefaultBackground", //$NON-NLS-1$
                FormColors.blend(white, widgetBackground.getRGB(), 10));
        indentedHoverBackground = factory.getColors().createColor("TabbedPropertyList.indentedHoverBackground", //$NON-NLS-1$
                FormColors.blend(white, widgetBackground.getRGB(), 75));
    }

    /**
     * Initialize the colours used in the list.
     */
    private void initColours() {
        /*
         * Colour 3 COLOR_LIST_BACKGROUND
         */
        listBackground = Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND);

        /*
         * Colour 13 COLOR_WIDGET_BACKGROUND
         */
        widgetBackground = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);

        /*
         * Colour 15 COLOR_WIDGET_DARK_SHADOW
         */
        widgetDarkShadow = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW);

        /*
         * Colour 16 COLOR_WIDGET_FOREGROUND
         */
        widgetForeground = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND);

        /*
         * Colour 19 COLOR_WIDGET_NORMAL_SHADOW
         */
        widgetNormalShadow = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_NORMAL_SHADOW);
    }
}
