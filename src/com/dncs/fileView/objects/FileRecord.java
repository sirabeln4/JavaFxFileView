package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.ObservableList;

public class FileRecord {

    private Integer recNum;
    private String  recType;
    private String fileKey;
    private String fileValue;
    private String compareValue;

    private String hexData0;
    private String hexData1;
    private String hexData2;
    private String charData;

    private final String invoiceId;
    private final String itemId;
    
    private ObservableList<FileField> fileFieldList;

    public FileRecord() {
        super();
        this.fileKey = "";
        this.fileValue = "";
        this.compareValue = "";
        this.fileFieldList = null;
        this.charData = "";
        this.hexData0 = "";
        this.hexData1 = "";
        this.hexData2 = "";
        this.recNum = 0;
        this.recType = "";
        this.invoiceId = "";
        this.itemId = "";
        
    }

    public FileRecord(String fileKey, String fileValue, String compareValue, 
            ObservableList<FileField> fileFieldList,
            String hexData, String charData, Integer recNum, String recType, 
            String invoiceId, String itemId) {
        super();
        this.fileKey = fileKey;
        this.fileValue = fileValue;
        this.compareValue = compareValue;
        this.fileFieldList = fileFieldList;
        this.charData = charData;
        this.hexData0 = hexData;
        this.recNum = recNum;
        this.recType = recType;
        this.invoiceId = invoiceId;
        this.itemId = itemId;
        
        StringBuilder h1 = new StringBuilder();
        StringBuilder h2 = new StringBuilder();

        for (int i = 0; i < hexData.length(); i += 2) {
            h1.append(StringUtils.substring(hexData, i, i + 1));
            h2.append(StringUtils.substring(hexData, i + 1, i + 2));
        }
        this.hexData1 = h1.toString();
        this.hexData2 = h2.toString();
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public String getFileValue() {
        return fileValue;
    }

    public void setFileValue(String fileValue) {
        this.fileValue = fileValue;
    }

    public String getCompareValue() {
        return compareValue;
    }

    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

    public ObservableList<FileField> getFileFieldList() {
        return fileFieldList;
    }

    public void setFileFieldList(ObservableList<FileField> fileFieldList) {
        this.fileFieldList = fileFieldList;
    }

    public String getHexData0() {
        return hexData0;
    }

    public void setHexData0(String hexData0) {
        this.hexData0 = hexData0;
    }

    public String getHexData1() {
        return hexData1;
    }

    public void setHexData1(String hexData1) {
        this.hexData1 = hexData1;
    }

    public String getHexData2() {
        return hexData2;
    }

    public void setHexData2(String hexData2) {
        this.hexData2 = hexData2;
    }

    public String getCharData() {
        return charData;
    }

    public void setCharData(String charData) {
        this.charData = charData;
    }

    public Integer getRecNum() {
        return recNum;
    }

    public void setRecNum(Integer recNum) {
        this.recNum = recNum;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getItemId() {
        return itemId;
    }

}
