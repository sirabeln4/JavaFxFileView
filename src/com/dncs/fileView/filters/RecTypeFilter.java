package com.dncs.fileView.filters;

import javafx.scene.control.CheckBox;

/**
 *
 * @author noels
 */
public class RecTypeFilter {

    private final CheckBox selectedCB;
    private final String recTypeCd;
    private final String recTypeDesc;
    private Integer recTypeCnt;

    public RecTypeFilter(String recTypeCd, String recTypeDesc) {

        this.selectedCB = new CheckBox();
        this.selectedCB.setSelected(true);
        this.recTypeCd = recTypeCd;
        this.recTypeDesc = recTypeDesc;
        this.recTypeCnt = 0;

    }

    public Boolean isSelected() {
        return this.selectedCB.isSelected();
    }

    public CheckBox getSelectedCB() {
        return selectedCB;
    }

    public String getRecTypeCd() {
        return recTypeCd;
    }

    public String getRecTypeDesc() {
        return recTypeDesc;
    }

    public Integer getRecTypeCnt() {
        return recTypeCnt;
    }

    public void addToRecTypeCnt() {
        this.recTypeCnt++;
    }

    public void clearRecTypeCnt() {
        this.recTypeCnt = 0;
    }
    
}
