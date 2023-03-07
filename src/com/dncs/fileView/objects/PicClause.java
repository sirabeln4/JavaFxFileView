package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

public class PicClause {

    private final String picTxt;
    private Integer fieldLen;
    private Integer leftLen;
    private Integer rightLen;
    private String compType;
    private Boolean signed;

    public PicClause(String picClauseIn) {
        super();

        this.picTxt = StringUtils.upperCase(picClauseIn);
        this.leftLen = 0;
        this.rightLen = 0;
        this.compType = "";
        this.signed = false;

        if (StringUtils.startsWith(picTxt, "X")) {
            String lengthTxt;
            if (StringUtils.contains(picTxt, "(")) {
                lengthTxt = StringUtils.substring(picTxt, StringUtils.indexOf(picTxt, '(') + 1, StringUtils.indexOf(picTxt, ')'));
                leftLen = Integer.valueOf(lengthTxt);
            } else {
                leftLen = StringUtils.countMatches(picTxt, "X");
            }
            fieldLen = leftLen;
        } else if (StringUtils.contains(picTxt, "COMP-3")) {
            compType = "COMP-3";
            getSign();
            getComp3Size();
            Integer fullLen = leftLen + rightLen + 1;
            if (fullLen % 2 == 0) {
                fieldLen = fullLen / 2;
            } else {
                fieldLen = (fullLen + 1) / 2;
            }
        } else if (StringUtils.contains(picTxt, "COMP")) {
            compType = "COMP";
            getSign();
            leftLen = getLength(picTxt);
            if (leftLen > 9) {
                fieldLen = 8;
            } else if (leftLen > 4) {
                fieldLen = 4;
            } else {
                fieldLen = 2;
            }
        }

//		System.out.println("");
//		System.out.println(picTxt);
//		System.out.println(fieldLen);
//		System.out.println(leftLen); 
//		System.out.println(rightLen); 
//		System.out.println(compType); 
//		System.out.println(signed);
    }

    private void getSign() {
        if (StringUtils.startsWith(picTxt, "S")) {
            this.signed = true;
        }
    }

    private void getComp3Size() {

        String[] split = StringUtils.split(this.picTxt, "V");
        if (split.length == 0) {
            leftLen = getLength(picTxt);
        } else if (split.length == 1) {
            leftLen = getLength(split[0]);
        } else if (split.length == 2) {
            leftLen = getLength(split[0]);
            rightLen = getLength(split[1]);
        }

    }

    private Integer getLength(String txt) {

        Integer returnLength = 0;

        if (StringUtils.contains(txt, "(")) {
            String lengthTxt = StringUtils.substring(txt, StringUtils.indexOf(txt, '(') + 1, StringUtils.indexOf(txt, ')'));
            returnLength = Integer.parseInt(lengthTxt);
        } else {
            returnLength = StringUtils.countMatches(txt, "9");
        }

        //System.out.println(txt + " len = " + returnLength);
        return returnLength;

    }

    public String getPicTxt() {
        return picTxt;
    }

    public Integer getFieldLen() {
        return fieldLen;
    }

    public Integer getLeftLen() {
        return leftLen;
    }

    public Integer getRightLen() {
        return rightLen;
    }

    public String getCompType() {
        return compType;
    }

    public Boolean getSigned() {
        return signed;
    }

}
