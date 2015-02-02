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
package org.talend.themes.core.elements.handlers;

import org.eclipse.draw2d.MarginBorder;
import org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.e4.ui.css.swt.helpers.CSSSWTColorHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.talend.themes.core.elements.adapters.TalendPaletteElement;
import org.talend.themes.core.elements.stylesettings.TalendPaletteCSSStyleSetting;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.css.CSSValueList;

/**
 * created by cmeng on Jan 30, 2015 Detailled comment
 *
 */
public class TalendPaletteCSSPropertyHandler implements ICSSPropertyHandler {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler#applyCSSProperty(java.lang.Object,
     * java.lang.String, org.w3c.dom.css.CSSValue, java.lang.String, org.eclipse.e4.ui.css.core.engine.CSSEngine)
     */
    @Override
    public boolean applyCSSProperty(Object element, String property, CSSValue value, String pseudo, CSSEngine engine)
            throws Exception {

        TalendPaletteElement paletteElement = (TalendPaletteElement) element;
        TalendPaletteCSSStyleSetting paletteSetting = paletteElement.getCSSStyleSetting();

        Composite paletteComposite = (Composite) paletteElement.getNativeWidget();

        boolean matched = false;
        if ("tPalette-mouseOver-forground-color1".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            // paletteSetting.setMouseOverForgroundColor1(new Color1(paletteComposite.getDisplay(), rgb));
            paletteSetting.setMouseOverForgroundColor1(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-mouseOver-forground-color2".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setMouseOverForgroundColor2(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-mouseOver-forground-color3".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setMouseOverForgroundColor3(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-mouseOver-background-color1".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setMouseOverBackgroundColor1(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-mouseOver-background-color2".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setMouseOverBackgroundColor2(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-mouseOver-background-color3".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setMouseOverBackgroundColor3(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-expanded-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setExpandedBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapsed-forground-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapsedForgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapsed-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapsedBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-list-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapsedBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-color-increment".equalsIgnoreCase(property)) {
            matched = true;
            Integer colorIncrement = null;
            try {
                colorIncrement = (int) ((CSSPrimitiveValue) value).getFloatValue(CSSPrimitiveValue.CSS_PX);
            } catch (Exception e) {
                // nothing to do
            }
            if (colorIncrement != null) {
                paletteSetting.setColorIncrement(colorIncrement);
            }
        } else if ("tPalette-x-offset".equalsIgnoreCase(property)) {
            matched = true;
            Integer xOffset = null;
            try {
                xOffset = (int) ((CSSPrimitiveValue) value).getFloatValue(CSSPrimitiveValue.CSS_PX);
            } catch (Exception e) {
                // nothing to do
            }
            if (xOffset != null) {
                paletteSetting.setxOffset(xOffset);
            }
        } else if ("tPalette-title-margin-border".equalsIgnoreCase(property)) {
            matched = true;
            if (value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
                CSSValueList valueList = (CSSValueList) value;
                boolean succeed = true;
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;
                try {
                    top = (int) ((CSSPrimitiveValue) valueList.item(0)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    left = (int) ((CSSPrimitiveValue) valueList.item(1)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    bottom = (int) ((CSSPrimitiveValue) valueList.item(2)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    right = (int) ((CSSPrimitiveValue) valueList.item(3)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                } catch (Exception e) {
                    succeed = false;
                }
                if (succeed) {
                    MarginBorder border = new MarginBorder(top, left, bottom, right);
                    paletteSetting.setTitleMarginBorder(border);
                }
            }
        } else if ("tPalette-scroll-pane-border".equalsIgnoreCase(property)) {
            matched = true;
            if (value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
                CSSValueList valueList = (CSSValueList) value;
                boolean succeed = true;
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;
                try {
                    top = (int) ((CSSPrimitiveValue) valueList.item(0)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    left = (int) ((CSSPrimitiveValue) valueList.item(1)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    bottom = (int) ((CSSPrimitiveValue) valueList.item(2)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    right = (int) ((CSSPrimitiveValue) valueList.item(3)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                } catch (Exception e) {
                    succeed = false;
                }
                if (succeed) {
                    MarginBorder border = new MarginBorder(top, left, bottom, right);
                    paletteSetting.setScrollPaneBorder(border);
                }
            }
        } else if ("tPalette-scroll-pane-list-border".equalsIgnoreCase(property)) {
            matched = true;
            if (value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
                CSSValueList valueList = (CSSValueList) value;
                boolean succeed = true;
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;
                try {
                    top = (int) ((CSSPrimitiveValue) valueList.item(0)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    left = (int) ((CSSPrimitiveValue) valueList.item(1)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    bottom = (int) ((CSSPrimitiveValue) valueList.item(2)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    right = (int) ((CSSPrimitiveValue) valueList.item(3)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                } catch (Exception e) {
                    succeed = false;
                }
                if (succeed) {
                    MarginBorder border = new MarginBorder(top, left, bottom, right);
                    paletteSetting.setScrollPaneListBorder(border);
                }
            }
        } else if ("tPalette-slider-palette-forground-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setSliderPaletteForgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-slider-palette-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setSliderPaletteBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-show-folder-image".equalsIgnoreCase(property)) {
            matched = true;
            Boolean showFolderImage = null;
            try {
                showFolderImage = Boolean.valueOf(((CSSPrimitiveValue) value).getStringValue());
            } catch (Exception e) {
                // nothing to do
            }
            if (showFolderImage != null) {
                paletteSetting.setShowFolderImage(showFolderImage);
            }
        } else if ("tPalette-entryEditPart-arrowWidth".equalsIgnoreCase(property)) {
            matched = true;
            Integer arrowWidth = null;
            try {
                arrowWidth = (int) ((CSSPrimitiveValue) value).getFloatValue(CSSPrimitiveValue.CSS_PX);
            } catch (Exception e) {
                // nothing to do
            }
            if (arrowWidth != null) {
                paletteSetting.setEntryEditPartArrowWidth(arrowWidth);
            }
        } else if ("tPalette-entryEditPart-listBorder".equalsIgnoreCase(property)) {
            matched = true;
            if (value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
                CSSValueList valueList = (CSSValueList) value;
                boolean succeed = true;
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;
                try {
                    top = (int) ((CSSPrimitiveValue) valueList.item(0)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    left = (int) ((CSSPrimitiveValue) valueList.item(1)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    bottom = (int) ((CSSPrimitiveValue) valueList.item(2)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    right = (int) ((CSSPrimitiveValue) valueList.item(3)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                } catch (Exception e) {
                    succeed = false;
                }
                if (succeed) {
                    MarginBorder border = new MarginBorder(top, left, bottom, right);
                    paletteSetting.setEntryEditPartListBorder(border);
                }
            }
        } else if ("tPalette-entryEditPart-iconBorder".equalsIgnoreCase(property)) {
            matched = true;
            if (value.getCssValueType() == CSSValue.CSS_VALUE_LIST) {
                CSSValueList valueList = (CSSValueList) value;
                boolean succeed = true;
                int top = 0;
                int left = 0;
                int bottom = 0;
                int right = 0;
                try {
                    top = (int) ((CSSPrimitiveValue) valueList.item(0)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    left = (int) ((CSSPrimitiveValue) valueList.item(1)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    bottom = (int) ((CSSPrimitiveValue) valueList.item(2)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                    right = (int) ((CSSPrimitiveValue) valueList.item(3)).getFloatValue(CSSPrimitiveValue.CSS_PX);
                } catch (Exception e) {
                    succeed = false;
                }
                if (succeed) {
                    MarginBorder border = new MarginBorder(top, left, bottom, right);
                    paletteSetting.setEntryEditPartIconBorder(border);
                }
            }
        } else if ("tPalette-entryEditPart-forground-disableColor".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setEntryEditPartToolEntryForgroundDisabledColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-entryEditPart-selected-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setEntryEditPartToolEntrySelectedBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-entryEditPart-hover-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setEntryEditPartToolEntryHoverBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-entryEditPart-borderFocus-forground-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setEntryEditPartToolEntryBorderFocusForgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-entryEditPart-borderFocus-background-color".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setEntryEditPartToolEntryBorderFocusBackgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-drawerFigure-baseColor".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setDrawerFigureBaseColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapse-topBorder-forground-lineColor1".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapseTopBorderForgroundLineColor1(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapse-topBorder-forground-lineColor2".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapseTopBorderForgroundLineColor2(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapse-expanded-forground-lineColor".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapseExpandedLineForgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        } else if ("tPalette-collapse-notExpanded-forground-lineColor".equalsIgnoreCase(property)) {
            matched = true;
            RGB rgb = CSSSWTColorHelper.getRGB(value);
            paletteSetting.setCollapseNotExpandedLineForgroundColor(new Color(paletteComposite.getDisplay(), rgb));
        }
        return matched;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.e4.ui.css.core.dom.properties.ICSSPropertyHandler#retrieveCSSProperty(java.lang.Object,
     * java.lang.String, java.lang.String, org.eclipse.e4.ui.css.core.engine.CSSEngine)
     */
    @Override
    public String retrieveCSSProperty(Object element, String property, String pseudo, CSSEngine engine) throws Exception {
        return null;
    }

}
