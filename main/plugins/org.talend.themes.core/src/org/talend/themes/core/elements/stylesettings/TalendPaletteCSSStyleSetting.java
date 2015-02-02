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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.swt.graphics.Color;
import org.talend.themes.core.elements.interfaces.ICSSStylingChangedListener;

/**
 * created by cmeng on Jan 30, 2015 Detailled comment
 *
 */
public class TalendPaletteCSSStyleSetting extends CommonCSSStyleSetting {

    protected Map<Color, Color> needDisposedColors;

    protected ICSSStylingChangedListener stylingChangeListener;

    protected Color mouseOverForgroundColor1;

    protected Color mouseOverForgroundColor2;

    protected Color mouseOverForgroundColor3;

    protected Color mouseOverBackgroundColor1;

    protected Color mouseOverBackgroundColor2;

    protected Color mouseOverBackgroundColor3;

    protected Color expandedBackgroundColor;

    protected Color collapsedForgroundColor;

    protected Color collapsedBackgroundColor;

    protected Color listBackgroundColor;

    protected int colorIncrement;

    protected int xOffset;

    protected Border titleMarginBorder;

    protected Color fgColor;

    protected Border scrollPaneBorder;

    protected Border scrollPaneListBorder;

    protected Color sliderPaletteForgroundColor;

    protected Color sliderPaletteBackgroundColor;

    protected boolean showFolderImage;

    protected int entryEditPartArrowWidth;

    protected Border entryEditPartListBorder;

    protected Border entryEditPartIconBorder;

    protected Color entryEditPartToolEntryForgroundDisabledColor;

    protected Color entryEditPartToolEntrySelectedBackgroundColor;

    protected Color entryEditPartToolEntryHoverBackgroundColor;

    protected Color entryEditPartToolEntryBorderFocusForgroundColor;

    protected Color entryEditPartToolEntryBorderFocusBackgroundColor;

    protected Color drawerFigureBaseColor;

    protected Color collapseTopBorderForgroundLineColor1;

    protected Color collapseTopBorderForgroundLineColor2;

    protected Color collapseExpandedLineForgroundColor;

    protected Color collapseNotExpandedLineForgroundColor;

    public TalendPaletteCSSStyleSetting() {
        resetPaletteCSSStyle();
    }

    public void resetPaletteCSSStyle() {
        needDisposedColors = new HashMap<Color, Color>();

        mouseOverForgroundColor1 = new Color(null, ColorConstants.listForeground.getRGB());
        mouseOverForgroundColor2 = new Color(null, ColorConstants.listForeground.getRGB());
        mouseOverForgroundColor3 = new Color(null, ColorConstants.listForeground.getRGB());
        mouseOverBackgroundColor1 = new Color(null, ColorConstants.listBackground.getRGB());
        mouseOverBackgroundColor2 = new Color(null, ColorConstants.listBackground.getRGB());
        mouseOverBackgroundColor3 = new Color(null, ColorConstants.listBackground.getRGB());
        expandedBackgroundColor = new Color(null, ColorConstants.listBackground.getRGB());
        collapsedForgroundColor = new Color(null, ColorConstants.listForeground.getRGB());
        collapsedBackgroundColor = new Color(null, ColorConstants.listBackground.getRGB());
        colorIncrement = 15;
        xOffset = 17;
        titleMarginBorder = new MarginBorder(4, 10, 2, 2);
        fgColor = FigureUtilities.mixColors(ColorConstants.buttonDarker, ColorConstants.button);
        scrollPaneBorder = new MarginBorder(2, 2, 2, 2);
        scrollPaneListBorder = new MarginBorder(2, 0, 2, 0);

        sliderPaletteForgroundColor = new Color(null, ColorConstants.listForeground.getRGB());
        sliderPaletteBackgroundColor = new Color(null, ColorConstants.listBackground.getRGB());
        showFolderImage = false;

        entryEditPartArrowWidth = 9;
        int base = 5;
        entryEditPartIconBorder = new MarginBorder(4, base, 3, entryEditPartArrowWidth + base);
        entryEditPartListBorder = new MarginBorder(3, entryEditPartArrowWidth + base + 3, 4, 0);
        entryEditPartToolEntryForgroundDisabledColor = new Color(null, ColorConstants.gray.getRGB());
        entryEditPartToolEntrySelectedBackgroundColor = new Color(null, 207, 227, 250);
        entryEditPartToolEntryHoverBackgroundColor = new Color(null, 252, 228, 179);
        entryEditPartToolEntryBorderFocusForgroundColor = new Color(null, ColorConstants.red.getRGB());
        entryEditPartToolEntryBorderFocusBackgroundColor = new Color(null, ColorConstants.green.getRGB());

        drawerFigureBaseColor = new Color(null, (FigureUtilities.mixColors(ColorConstants.button, ColorConstants.listBackground,
                0.1)).getRGB());

        {
            // by default, maybe needn't draw those lines
            // collapseTopBorderForgroundLineColor1 = new Color(null, ColorConstants.buttonDarker.getRGB());
            // collapseTopBorderForgroundLineColor2 = new Color(null, ColorConstants.white.getRGB());
            // collapseExpandedLineForgroundColor = new Color(null, ColorConstants.buttonDarker.getRGB());
            // collapseNotExpandedLineForgroundColor = new Color(null, ColorConstants.white.getRGB());
        }
    }

    public void disposeRelatedColor(Color color) {
        Color oldColor = needDisposedColors.get(color);
        if (oldColor != null) {
            if (!oldColor.isDisposed()) {
                oldColor.dispose();
            }
            needDisposedColors.remove(color);
        }
    }

    public void disposeRelatedBothColors(Color oldColor, Color newColor) {
        Color needDisposedOldColor = null;
        if (oldColor != null) {
            needDisposedOldColor = needDisposedColors.get(oldColor);
        }
        if (needDisposedOldColor != null) {
            if (!needDisposedOldColor.isDisposed()) {
                oldColor.dispose();
            }
            if (!oldColor.isDisposed()) {
                oldColor.dispose();
            }
            needDisposedColors.remove(oldColor);
        } else {
            needDisposedColors.put(newColor, oldColor);
        }
    }

    /**
     * Getter for fgColor.
     * 
     * @return the fgColor
     */
    public Color getFgColor() {
        return this.fgColor;
    }

    /**
     * Sets the fgColor.
     * 
     * @param fgColor the fgColor to set
     */
    public void setFgColor(Color fgColor) {
        disposeRelatedBothColors(this.fgColor, fgColor);
        this.fgColor = fgColor;
    }

    /**
     * Getter for scrollPaneBorder.
     * 
     * @return the scrollPaneBorder
     */
    public Border getScrollPaneBorder() {
        return this.scrollPaneBorder;
    }

    /**
     * Sets the scrollPaneBorder.
     * 
     * @param scrollPaneBorder the scrollPaneBorder to set
     */
    public void setScrollPaneBorder(Border scrollPaneBorder) {
        copyBorderSetting(scrollPaneBorder, this.scrollPaneBorder);
    }

    public void setScrollPaneBorderInstance(Border scrollPaneBorder) {
        this.scrollPaneBorder = scrollPaneBorder;
    }

    /**
     * Getter for scrollPaneListBorder.
     * 
     * @return the scrollPaneListBorder
     */
    public Border getScrollPaneListBorder() {
        return this.scrollPaneListBorder;
    }

    /**
     * Sets the scrollPaneListBorder.
     * 
     * @param scrollPaneListBorder the scrollPaneListBorder to set
     */
    public void setScrollPaneListBorder(Border scrollPaneListBorder) {
        copyBorderSetting(scrollPaneListBorder, this.scrollPaneListBorder);
    }

    public void setScrollPaneListBorderInstance(Border scrollPaneListBorder) {
        this.scrollPaneListBorder = scrollPaneListBorder;
    }

    public Color getMouseOverForgroundColor1() {
        return this.mouseOverForgroundColor1;
    }

    public void setMouseOverForgroundColor1(Color mouseOverForgroundColor1) {
        disposeRelatedBothColors(this.mouseOverForgroundColor1, mouseOverForgroundColor1);
        this.mouseOverForgroundColor1 = mouseOverForgroundColor1;
    }

    public Color getMouseOverForgroundColor2() {
        return this.mouseOverForgroundColor2;
    }

    public void setMouseOverForgroundColor2(Color mouseOverForgroundColor2) {
        disposeRelatedBothColors(this.mouseOverForgroundColor2, mouseOverForgroundColor2);
        this.mouseOverForgroundColor2 = mouseOverForgroundColor2;
    }

    public Color getMouseOverForgroundColor3() {
        return this.mouseOverForgroundColor3;
    }

    public void setMouseOverForgroundColor3(Color mouseOverForgroundColor3) {
        disposeRelatedBothColors(this.mouseOverForgroundColor3, mouseOverForgroundColor3);
        this.mouseOverForgroundColor3 = mouseOverForgroundColor3;
    }

    public Color getMouseOverBackgroundColor1() {
        return this.mouseOverBackgroundColor1;
    }

    public void setMouseOverBackgroundColor1(Color mouseOverBackgroundColor1) {
        disposeRelatedBothColors(this.mouseOverBackgroundColor1, mouseOverBackgroundColor1);
        this.mouseOverBackgroundColor1 = mouseOverBackgroundColor1;
    }

    public Color getMouseOverBackgroundColor2() {
        return this.mouseOverBackgroundColor2;
    }

    public void setMouseOverBackgroundColor2(Color mouseOverBackgroundColor2) {
        disposeRelatedBothColors(this.mouseOverBackgroundColor2, mouseOverBackgroundColor2);
        this.mouseOverBackgroundColor2 = mouseOverBackgroundColor2;
    }

    public Color getMouseOverBackgroundColor3() {
        return this.mouseOverBackgroundColor3;
    }

    public void setMouseOverBackgroundColor3(Color mouseOverBackgroundColor3) {
        disposeRelatedBothColors(this.mouseOverBackgroundColor3, mouseOverBackgroundColor3);
        this.mouseOverBackgroundColor3 = mouseOverBackgroundColor3;
    }

    public Color getExpandedBackgroundColor() {
        return this.expandedBackgroundColor;
    }

    public void setExpandedBackgroundColor(Color expandedBackgroundColor) {
        disposeRelatedBothColors(this.expandedBackgroundColor, expandedBackgroundColor);
        this.expandedBackgroundColor = expandedBackgroundColor;
    }

    public Color getCollapsedForgroundColor() {
        return this.collapsedForgroundColor;
    }

    public void setCollapsedForgroundColor(Color collapsedForgroundColor) {
        disposeRelatedBothColors(this.collapsedForgroundColor, collapsedForgroundColor);
        this.collapsedForgroundColor = collapsedForgroundColor;
    }

    public Color getCollapsedBackgroundColor() {
        return this.collapsedBackgroundColor;
    }

    public void setCollapsedBackgroundColor(Color collapsedBackgroundColor) {
        disposeRelatedBothColors(this.collapsedBackgroundColor, collapsedBackgroundColor);
        this.collapsedBackgroundColor = collapsedBackgroundColor;
    }

    /**
     * Getter for listBackgroundColor.
     * 
     * @return the listBackgroundColor
     */
    public Color getListBackgroundColor() {
        return this.listBackgroundColor;
    }

    /**
     * Sets the listBackgroundColor.
     * 
     * @param listBackgroundColor the listBackgroundColor to set
     */
    public void setListBackgroundColor(Color listBackgroundColor) {
        disposeRelatedBothColors(this.listBackgroundColor, listBackgroundColor);
        this.listBackgroundColor = listBackgroundColor;
    }

    /**
     * Getter for colorIncrement.
     * 
     * @return the colorIncrement
     */
    public int getColorIncrement() {
        return this.colorIncrement;
    }

    /**
     * Sets the colorIncrement.
     * 
     * @param colorIncrement the colorIncrement to set
     */
    public void setColorIncrement(int colorIncrement) {
        if (this.colorIncrement == colorIncrement) {
            this.colorIncrement = colorIncrement;
            stylingChangeListener.applyChange(this);
        }
    }

    /**
     * Getter for titleMarginBorder.
     * 
     * @return the titleMarginBorder
     */
    public Border getTitleMarginBorder() {
        return this.titleMarginBorder;
    }

    /**
     * Sets the titleMarginBorder.
     * 
     * @param titleMarginBorder the titleMarginBorder to set
     */
    public void setTitleMarginBorder(Border titleMarginBorder) {
        copyBorderSetting(titleMarginBorder, this.titleMarginBorder);
    }

    public void setTitleMarginBorderInstance(Border titleMarginBorder) {
        this.titleMarginBorder = titleMarginBorder;
    }

    /**
     * Getter for xOffset.
     * 
     * @return the xOffset
     */
    public int getxOffset() {
        return this.xOffset;
    }

    /**
     * Sets the xOffset.
     * 
     * @param xOffset the xOffset to set
     */
    public void setxOffset(int xOffset) {
        if (this.xOffset != xOffset) {
            this.xOffset = xOffset;
            stylingChangeListener.applyChange(this);
        }
    }

    /**
     * Getter for stylingChangeListener.
     * 
     * @return the stylingChangeListener
     */
    public ICSSStylingChangedListener getStylingChangeListener() {
        return this.stylingChangeListener;
    }

    /**
     * Sets the stylingChangeListener.
     * 
     * @param stylingChangeListener the stylingChangeListener to set
     */
    public void setStylingChangeListener(ICSSStylingChangedListener stylingChangeListener) {
        this.stylingChangeListener = stylingChangeListener;
    }

    /**
     * Getter for sliderPaletteForgroundColor.
     * 
     * @return the sliderPaletteForgroundColor
     */
    public Color getSliderPaletteForgroundColor() {
        return this.sliderPaletteForgroundColor;
    }

    /**
     * Sets the sliderPaletteForgroundColor.
     * 
     * @param sliderPaletteForgroundColor the sliderPaletteForgroundColor to set
     */
    public void setSliderPaletteForgroundColor(Color sliderPaletteForgroundColor) {
        disposeRelatedBothColors(this.sliderPaletteForgroundColor, sliderPaletteForgroundColor);
        this.sliderPaletteForgroundColor = sliderPaletteForgroundColor;
    }

    /**
     * Getter for sliderPaletteBackgroundColor.
     * 
     * @return the sliderPaletteBackgroundColor
     */
    public Color getSliderPaletteBackgroundColor() {
        return this.sliderPaletteBackgroundColor;
    }

    /**
     * Sets the sliderPaletteBackgroundColor.
     * 
     * @param sliderPaletteBackgroundColor the sliderPaletteBackgroundColor to set
     */
    public void setSliderPaletteBackgroundColor(Color sliderPaletteBackgroundColor) {
        disposeRelatedBothColors(this.sliderPaletteBackgroundColor, sliderPaletteBackgroundColor);
        this.sliderPaletteBackgroundColor = sliderPaletteBackgroundColor;
    }

    /**
     * Getter for showFolderImage.
     * 
     * @return the showFolderImage
     */
    public boolean isShowFolderImage() {
        return this.showFolderImage;
    }

    /**
     * Sets the showFolderImage.
     * 
     * @param showFolderImage the showFolderImage to set
     */
    public void setShowFolderImage(boolean showFolderImage) {
        this.showFolderImage = showFolderImage;
    }

    /**
     * Getter for entryEditPartArrowWidth.
     * 
     * @return the entryEditPartArrowWidth
     */
    public int getEntryEditPartArrowWidth() {
        return this.entryEditPartArrowWidth;
    }

    /**
     * Sets the entryEditPartArrowWidth.
     * 
     * @param entryEditPartArrowWidth the entryEditPartArrowWidth to set
     */
    public void setEntryEditPartArrowWidth(int entryEditPartArrowWidth) {
        this.entryEditPartArrowWidth = entryEditPartArrowWidth;
    }

    /**
     * Getter for entryEditPartListBorder.
     * 
     * @return the entryEditPartListBorder
     */
    public Border getEntryEditPartListBorder() {
        return this.entryEditPartListBorder;
    }

    /**
     * Sets the entryEditPartListBorder.
     * 
     * @param entryEditPartListBorder the entryEditPartListBorder to set
     */
    public void setEntryEditPartListBorder(Border entryEditPartListBorder) {
        this.entryEditPartListBorder = entryEditPartListBorder;
    }

    /**
     * Getter for entryEditPartIconBorder.
     * 
     * @return the entryEditPartIconBorder
     */
    public Border getEntryEditPartIconBorder() {
        return this.entryEditPartIconBorder;
    }

    /**
     * Sets the entryEditPartIconBorder.
     * 
     * @param entryEditPartIconBorder the entryEditPartIconBorder to set
     */
    public void setEntryEditPartIconBorder(Border entryEditPartIconBorder) {
        this.entryEditPartIconBorder = entryEditPartIconBorder;
    }

    /**
     * Getter for entryEditPartToolEntryForgroundDisabledColor.
     * 
     * @return the entryEditPartToolEntryForgroundDisabledColor
     */
    public Color getEntryEditPartToolEntryForgroundDisabledColor() {
        return this.entryEditPartToolEntryForgroundDisabledColor;
    }

    /**
     * Sets the entryEditPartToolEntryForgroundDisabledColor.
     * 
     * @param entryEditPartToolEntryForgroundDisabledColor the entryEditPartToolEntryForgroundDisabledColor to set
     */
    public void setEntryEditPartToolEntryForgroundDisabledColor(Color entryEditPartToolEntryForgroundDisabledColor) {
        disposeRelatedBothColors(this.entryEditPartToolEntryForgroundDisabledColor, entryEditPartToolEntryForgroundDisabledColor);
        this.entryEditPartToolEntryForgroundDisabledColor = entryEditPartToolEntryForgroundDisabledColor;
    }

    /**
     * Getter for entryEditPartToolEntrySelectedBackgroundColor.
     * 
     * @return the entryEditPartToolEntrySelectedBackgroundColor
     */
    public Color getEntryEditPartToolEntrySelectedBackgroundColor() {
        return this.entryEditPartToolEntrySelectedBackgroundColor;
    }

    /**
     * Sets the entryEditPartToolEntrySelectedBackgroundColor.
     * 
     * @param entryEditPartToolEntrySelectedBackgroundColor the entryEditPartToolEntrySelectedBackgroundColor to set
     */
    public void setEntryEditPartToolEntrySelectedBackgroundColor(Color entryEditPartToolEntrySelectedBackgroundColor) {
        disposeRelatedBothColors(this.entryEditPartToolEntrySelectedBackgroundColor,
                entryEditPartToolEntrySelectedBackgroundColor);
        this.entryEditPartToolEntrySelectedBackgroundColor = entryEditPartToolEntrySelectedBackgroundColor;
    }

    /**
     * Getter for entryEditPartToolEntryHoverBackgroundColor.
     * 
     * @return the entryEditPartToolEntryHoverBackgroundColor
     */
    public Color getEntryEditPartToolEntryHoverBackgroundColor() {
        return this.entryEditPartToolEntryHoverBackgroundColor;
    }

    /**
     * Sets the entryEditPartToolEntryHoverBackgroundColor.
     * 
     * @param entryEditPartToolEntryHoverBackgroundColor the entryEditPartToolEntryHoverBackgroundColor to set
     */
    public void setEntryEditPartToolEntryHoverBackgroundColor(Color entryEditPartToolEntryHoverBackgroundColor) {
        disposeRelatedBothColors(this.entryEditPartToolEntryHoverBackgroundColor, entryEditPartToolEntryHoverBackgroundColor);
        this.entryEditPartToolEntryHoverBackgroundColor = entryEditPartToolEntryHoverBackgroundColor;
    }

    /**
     * Getter for entryEditPartToolEntryBorderFocusForgroundColor.
     * 
     * @return the entryEditPartToolEntryBorderFocusForgroundColor
     */
    public Color getEntryEditPartToolEntryBorderFocusForgroundColor() {
        return this.entryEditPartToolEntryBorderFocusForgroundColor;
    }

    /**
     * Sets the entryEditPartToolEntryBorderFocusForgroundColor.
     * 
     * @param entryEditPartToolEntryBorderFocusForgroundColor the entryEditPartToolEntryBorderFocusForgroundColor to set
     */
    public void setEntryEditPartToolEntryBorderFocusForgroundColor(Color entryEditPartToolEntryBorderFocusForgroundColor) {
        disposeRelatedBothColors(this.entryEditPartToolEntryBorderFocusForgroundColor,
                entryEditPartToolEntryBorderFocusForgroundColor);
        this.entryEditPartToolEntryBorderFocusForgroundColor = entryEditPartToolEntryBorderFocusForgroundColor;
    }

    /**
     * Getter for entryEditPartToolEntryBorderFocusBackgroundColor.
     * 
     * @return the entryEditPartToolEntryBorderFocusBackgroundColor
     */
    public Color getEntryEditPartToolEntryBorderFocusBackgroundColor() {
        return this.entryEditPartToolEntryBorderFocusBackgroundColor;
    }

    /**
     * Sets the entryEditPartToolEntryBorderFocusBackgroundColor.
     * 
     * @param entryEditPartToolEntryBorderFocusBackgroundColor the entryEditPartToolEntryBorderFocusBackgroundColor to
     * set
     */
    public void setEntryEditPartToolEntryBorderFocusBackgroundColor(Color entryEditPartToolEntryBorderFocusBackgroundColor) {
        disposeRelatedBothColors(this.entryEditPartToolEntryBorderFocusBackgroundColor,
                entryEditPartToolEntryBorderFocusBackgroundColor);
        this.entryEditPartToolEntryBorderFocusBackgroundColor = entryEditPartToolEntryBorderFocusBackgroundColor;
    }

    /**
     * Getter for drawerFigureBaseColor.
     * 
     * @return the drawerFigureBaseColor
     */
    public Color getDrawerFigureBaseColor() {
        return this.drawerFigureBaseColor;
    }

    /**
     * Sets the drawerFigureBaseColor.
     * 
     * @param drawerFigureBaseColor the drawerFigureBaseColor to set
     */
    public void setDrawerFigureBaseColor(Color drawerFigureBaseColor) {
        disposeRelatedBothColors(this.drawerFigureBaseColor, drawerFigureBaseColor);
        this.drawerFigureBaseColor = drawerFigureBaseColor;
    }

    /**
     * Getter for collapseTopBorderForgroundLineColor1.
     * 
     * @return the collapseTopBorderForgroundLineColor1
     */
    public Color getCollapseTopBorderForgroundLineColor1() {
        return this.collapseTopBorderForgroundLineColor1;
    }

    /**
     * Sets the collapseTopBorderForgroundLineColor1.
     * 
     * @param collapseTopBorderForgroundLineColor1 the collapseTopBorderForgroundLineColor1 to set
     */
    public void setCollapseTopBorderForgroundLineColor1(Color collapseTopBorderForgroundLineColor1) {
        disposeRelatedBothColors(this.collapseTopBorderForgroundLineColor1, collapseTopBorderForgroundLineColor1);
        this.collapseTopBorderForgroundLineColor1 = collapseTopBorderForgroundLineColor1;
    }

    /**
     * Getter for collapseTopBorderForgroundLineColor2.
     * 
     * @return the collapseTopBorderForgroundLineColor2
     */
    public Color getCollapseTopBorderForgroundLineColor2() {
        return this.collapseTopBorderForgroundLineColor2;
    }

    /**
     * Sets the collapseTopBorderForgroundLineColor2.
     * 
     * @param collapseTopBorderForgroundLineColor2 the collapseTopBorderForgroundLineColor2 to set
     */
    public void setCollapseTopBorderForgroundLineColor2(Color collapseTopBorderForgroundLineColor2) {
        disposeRelatedBothColors(this.collapseTopBorderForgroundLineColor2, collapseTopBorderForgroundLineColor2);
        this.collapseTopBorderForgroundLineColor2 = collapseTopBorderForgroundLineColor2;
    }

    /**
     * Getter for collapseExpandedLineForgroundColor.
     * 
     * @return the collapseExpandedLineForgroundColor
     */
    public Color getCollapseExpandedLineForgroundColor() {
        return this.collapseExpandedLineForgroundColor;
    }

    /**
     * Sets the collapseExpandedLineForgroundColor.
     * 
     * @param collapseExpandedLineForgroundColor the collapseExpandedLineForgroundColor to set
     */
    public void setCollapseExpandedLineForgroundColor(Color collapseExpandedLineForgroundColor) {
        disposeRelatedBothColors(this.collapseExpandedLineForgroundColor, collapseExpandedLineForgroundColor);
        this.collapseExpandedLineForgroundColor = collapseExpandedLineForgroundColor;
    }

    /**
     * Getter for collapseNotExpandedLineForgroundColor.
     * 
     * @return the collapseNotExpandedLineForgroundColor
     */
    public Color getCollapseNotExpandedLineForgroundColor() {
        return this.collapseNotExpandedLineForgroundColor;
    }

    /**
     * Sets the collapseNotExpandedLineForgroundColor.
     * 
     * @param collapseNotExpandedLineForgroundColor the collapseNotExpandedLineForgroundColor to set
     */
    public void setCollapseNotExpandedLineForgroundColor(Color collapseNotExpandedLineForgroundColor) {
        disposeRelatedBothColors(this.collapseNotExpandedLineForgroundColor, collapseNotExpandedLineForgroundColor);
        this.collapseNotExpandedLineForgroundColor = collapseNotExpandedLineForgroundColor;
    }

}
