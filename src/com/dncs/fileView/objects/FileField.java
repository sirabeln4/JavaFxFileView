package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

public class FileField {

    private final Integer num;
    private final String nameTxt;
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

        Integer tempnum = 05;
        String tempName = nameTxt;

        String tempnumtxt = StringUtils.substring(nameTxt, 1, 3);
        //System.out.println(tempnumtxt);
        if (StringUtils.isNumeric(tempnumtxt)) {
            tempnum = Integer.parseInt(tempnumtxt);
            tempName = StringUtils.substring(nameTxt, 4);
        }

        this.num = tempnum;
        this.nameTxt = tempName;
        this.picClauseTxt = picTxt;
        this.startPos = startPos;
        this.endPos = endPos;
        this.keyLevel = keyLevel;

        this.keyField = false;
        this.displayField = true;
        this.recTypeValue = recTypeValue;

        this.fieldNameTxt = tempName;
        this.fieldValueTxt = recTypeValue;

    }

    public FileField(String nameTxt, String recTypeValue, String picTxt, Integer startPos, Integer endPos) {
        super();

        Integer tempnum = 05;
        String tempName = nameTxt;

        String tempnumtxt = StringUtils.substring(nameTxt, 1, 3);
        //System.out.println(tempnumtxt);
        if (StringUtils.isNumeric(tempnumtxt)) {
            tempnum = Integer.parseInt(tempnumtxt);
            tempName = StringUtils.substring(nameTxt, 4);
        }

        this.num = tempnum;
        this.nameTxt = tempName;
        this.picClauseTxt = picTxt;
        this.startPos = startPos;
        this.endPos = endPos;
        this.keyLevel = "";

        this.keyField = false;
        this.displayField = true;
        this.recTypeValue = recTypeValue;

        this.fieldNameTxt = tempName;
        this.fieldValueTxt = recTypeValue;

    }

    public FileField(Integer num, String nameTxt, String picTxt, Integer startPos, Integer endPos, Boolean keyField,
            Boolean displayField, String recTypeValue) {
        super();

        this.num = num;
        this.nameTxt = nameTxt;
        this.picClauseTxt = picTxt;
        this.startPos = startPos;
        this.endPos = endPos;
        this.keyLevel = "";
        this.keyField = keyField;
        this.displayField = displayField;
        this.recTypeValue = recTypeValue;

        this.fieldNameTxt = nameTxt;
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

    public Integer getNum() {
        return num;
    }

    public String getNameTxt() {
        return nameTxt;
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
