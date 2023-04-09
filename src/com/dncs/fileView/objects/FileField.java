package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

public class FileField {

    private final String picClauseTxt;
    private final Integer startPos;
    private final Integer endPos;
    private final String keyLevel;

    private Boolean keyField;
    private Boolean displayField;
    private String recTypeValue;

    private final String fieldNameTxt;
    private final String fieldValueTxt;

    public FileField(String nameTxt, String recTypeValue, String picTxt, Integer startPos, Integer endPos, String keyLevel) {
        super();

        String tempName = nameTxt;

        String tempnumtxt = StringUtils.substring(nameTxt, 1, 3);
        if (StringUtils.isNumeric(tempnumtxt)) {
            //tempnum = Integer.valueOf(tempnumtxt);
            tempName = StringUtils.substring(nameTxt, 4);
        }

        this.picClauseTxt = picTxt;
        this.startPos = startPos;
        this.endPos = endPos;
        this.keyLevel = keyLevel;

        this.keyField = false;
        this.displayField = true;
        this.recTypeValue = recTypeValue;

        this.fieldNameTxt = StringUtils.replace(tempName, 
                "_", "-");
        this.fieldValueTxt = recTypeValue;

    }

    public FileField(String nameTxt, String recTypeValue, String picTxt, Integer startPos, Integer endPos) {
        super();

        String tempName = nameTxt;

        String tempnumtxt = StringUtils.substring(nameTxt, 1, 3);
        if (StringUtils.isNumeric(tempnumtxt)) {
            tempName = StringUtils.substring(nameTxt, 4);
        }

        this.picClauseTxt = picTxt;
        this.startPos = startPos;
        this.endPos = endPos;
        this.keyLevel = "";

        this.keyField = false;
        this.displayField = true;
        this.recTypeValue = recTypeValue;

        this.fieldNameTxt = StringUtils.replace(tempName,
                "_", "-");
        this.fieldValueTxt = recTypeValue;

    }

    public Boolean getKeyField() {
        return keyField;
    }

    public void setKeyField(Boolean keyField) {
        this.keyField = keyField;
    }

    public Boolean getDisplayField() {
        return displayField;
    }

    public void setDisplayField(Boolean displayField) {
        this.displayField = displayField;
    }

    public String getRecTypeValue() {
        return recTypeValue;
    }

    public void setRecTypeValue(String recTypeValue) {
        this.recTypeValue = recTypeValue;
    }

    public String getPicTxt() {
        return picClauseTxt;
    }

    public Integer getStartPos() {
        return startPos;
    }

    public Integer getEndPos() {
        return endPos;
    }

    public String getPicClauseTxt() {
        return picClauseTxt;
    }

    public String getFieldNameTxt() {
        return fieldNameTxt;
    }

    public String getFieldValueTxt() {
        return fieldValueTxt;
    }

    public String getKeyLevel() {
        return keyLevel;
    }

}
