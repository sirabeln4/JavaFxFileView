package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QBP537CC {

    private final FileRecord fileRecord;

    private String frKey;
    private final StringBuilder frValue;
    private final ObservableList<FileField> fileFieldList;
    private Integer currentIndex;

    public QBP537CC(String hexString, String charString) throws Exception {
        super();

        frKey = "";
        frValue = new StringBuilder();
        fileFieldList = FXCollections.observableArrayList();

        currentIndex = 0;
        String recType = subString(charString, 1);

        fileFieldList.add(new FileField("l05-QBP537-RECORD-TYPE", recType, "X(01)", 1, 1));
        fileFieldList.add(new FileField("l05-QBP537-FACILITY", subString(charString, 2), "X(02)", 2, 3));
        fileFieldList.add(new FileField("l05-QBP537-WHSE", subString(charString, 2), "X(02)", 4, 5));
        fileFieldList.add(new FileField("l10-QBP537-DELIVERY-DT", subStringComp3(hexString, 5, 9, 0, false), "S9(9) COMP-3", 6, 10));
        fileFieldList.add(new FileField("l10-QBP537-STORE-NUMBER", subStringComp3(hexString, 3, 5, 0, false), "S9(5) COMP-3", 11, 13));
        fileFieldList.add(new FileField("l10-QBP537-ORDER-NUMBER", subString(charString, 5), "X(05)", 14, 18));
        fileFieldList.add(new FileField("l10-QBP537-EQUITY-NUMBER", subStringComp3(hexString, 3, 5, 0, false), "S9(5) COMP-3", 19, 21));

        String dealCntrTxt = subStringComp3(hexString, 2, 3, 0, false);
        Integer dealCntr = Integer.valueOf(dealCntrTxt);
        fileFieldList.add(new FileField("l10-QBP537-DEAL-CNTR", dealCntrTxt, "S9(03) COMP-3", 22, 23));
        fileFieldList.add(new FileField("l10-QBP53-RWI-CASE-SELL", subStringComp3(hexString, 4, 3, 4, true), "S9(3)V9(4) COMP-3", 24, 27));
        fileFieldList.add(new FileField("l10-FILLER", subString(charString, 5), "X(05)", 28, 32));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        String displayValueTxt = "";
        if (StringUtils.equals(recType, "D")) {
            frKey = "Detail";
            displayValueTxt = dtlRec(hexString, charString);
        } else if (StringUtils.equals(recType, "S")) {
            frKey = "Shipper Component";
            displayValueTxt = shpRec(hexString, charString);
        } else if (StringUtils.equals(recType, "T")) {
            frKey = "Total Record";
            displayValueTxt = totRec(hexString, charString);
        }

        for (int i = 0; i < dealCntr; i++) {
            displayValueTxt += dealRecArea(hexString, charString);
        }

        this.fileRecord = new FileRecord(frKey, frValue.toString(), "", fileFieldList, hexString, charString);

        //System.out.print(displayValueTxt);
        //System.out.println("");

    }

    private String dtlRec(String dataHex, String dataChar) {

        fileFieldList.add(new FileField("l05-QBP537-ITEM-DATA", "", "", 33, 310));

        fileFieldList.add(new FileField("l10-QBP537-PICKING-SLOT", subString(dataChar, 6), "X(6)", 33, 38));
        fileFieldList.add(new FileField("l10-QBP537-MAND-SUB-OR-DISC", subString(dataChar, 1), "X(1)", 39, 39));
        fileFieldList.add(new FileField("l10-QBP537-LINE-TYPE-AEIQ", subString(dataChar, 1), "X(1)", 40, 40));
        fileFieldList.add(new FileField("l10-QBP537-INVOICE-NUMBER", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 41, 44));

        String desc = subString(dataChar, 30);
        fileFieldList.add(new FileField("l10-QBP537-DESCRIPTION", desc, "X(30)", 45, 74));
        fileFieldList.add(new FileField("l10-QBP537-SIZE", subString(dataChar, 6), "X(6)", 75, 80));
        fileFieldList.add(new FileField("l10-QBP537-PACK", subStringComp3(dataHex, 3, 5, 0, false), "S9(5) COMP-3", 81, 83));
        fileFieldList.add(new FileField("l10-QBP537-PALLET-WEIGHT", subStringComp3(dataHex, 3, 3, 2, false), "S9(3)V99 COMP-3", 84, 86));
        fileFieldList.add(new FileField("l10-QBP537-PALLET-ALLOWANCE-INDC", subString(dataChar, 1), "X(1)", 87, 87));
        fileFieldList.add(new FileField("l10-QBP537-RWI", subString(dataChar, 1), "X(1)", 88, 88));
        fileFieldList.add(new FileField("l10-QBP537-CASE-COST", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 89, 92));
        fileFieldList.add(new FileField("l10-QBP537-CASE-SELL", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 93, 96));
        fileFieldList.add(new FileField("l10-QBP537-QTY-BILLED", subStringComp3(dataHex, 3, 5, 0, false), "S9(5) COMP-3", 97, 99));
        fileFieldList.add(new FileField("l10-QBP537-QTY-ORDERED", subStringComp3(dataHex, 3, 5, 0, false), "S9(5) COMP-3", 100, 102));
        fileFieldList.add(new FileField("l10-QBP537-RETAIL-CASE-PRICE", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 103, 106));
        fileFieldList.add(new FileField("l10-QBP537-EXTENDED-SALE", subStringComp3(dataHex, 5, 6, 2, true), "S9(6)V99 COMP-3", 107, 111));
        fileFieldList.add(new FileField("l10-QBP537-BILL-STMNT-DT", subStringComp3(dataHex, 5, 9, 0, false), "S9(9) COMP-3", 112, 116));
        fileFieldList.add(new FileField("l10-QBP537-UPC-CODE", subString(dataChar, 15), "X(15)", 117, 132));

        String itemCodeOrd = subStringComp3(dataHex, 4, 7, 0, false);
        String itemChkDigitOrd = subStringComp3(dataHex, 1, 1, 0, false);
        String item = itemCodeOrd + itemChkDigitOrd;
        fileFieldList.add(new FileField("l10-QBP537-ITEM-CODE-ORD", itemCodeOrd, "S9(7) COMP-3", 132, 135));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-CHK-DIGIT-ORD", itemChkDigitOrd, "S9 COMP-3", 136, 136));

        fileFieldList.add(new FileField("l10-QBP537-ITEM-CODE-BILLED", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 137, 140));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-CHKDGT-BILLED", subStringComp3(dataHex, 1, 1, 0, false), "S9 COMP-3", 141, 141));
        fileFieldList.add(new FileField("l10-QBP537-RESTRICTED-BUY-CODE", subString(dataChar, 4), "X(4)", 142, 145));
        fileFieldList.add(new FileField("l10-QBP537-RETAIL-PRICING-UNIT", subStringComp3(dataHex, 2, 3, 0, true), "S9(3) COMP-3", 146, 147));
        fileFieldList.add(new FileField("l10-QBP537-RETAIL-PRICE", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 148, 151));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-FREIGHT", subStringComp3(dataHex, 3, 3, 2, true), "S9(3)V9(2) COMP-3", 152, 154));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-ALWNC-AMT", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V9(2) COMP-3", 155, 158));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-EXCPT-DESC", subString(dataChar, 30), "X(30)", 159, 188));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-RFRNC-CD", subString(dataChar, 10), "X(10)", 189, 198));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-PALT", subString(dataChar, 12), "X(12)", 199, 210));

        String bioEng = subString(dataChar, 1);
        String tprFl = subString(dataChar, 1);

        fileFieldList.add(new FileField("l10-QBP537-ITEM-BIO-ENG", bioEng, "X(1)", 211, 211));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-TPR-Fl", tprFl, "X(1)", 212, 212));

        String kitmShpFl = subString(dataChar, 1);
        fileFieldList.add(new FileField("l10-QBP537-KITM-SHP-FL", kitmShpFl, "X(1)", 213, 213));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-EXT-RTL-PRICE", subStringComp3(dataHex, 6, 7, 4, true), "S9(7)V9(4) COMP-3", 214, 219));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-IDIS", subStringComp3(dataHex, 5, 4, 5, true), "S9(4)V9(5) COMP-3", 220, 224));
        fileFieldList.add(new FileField("l10-QBP537-UNIT-OF-MEAS", subString(dataChar, 2), "X(02)", 225, 226));
        fileFieldList.add(new FileField("l10-QBP537-CASE-ALLOWANCE", subStringComp3(dataHex, 3, 3, 2, true), "S9(3)V9(2) COMP-3", 227, 229));

        fileFieldList.add(new FileField("l10-QBP537-TAX-SEG", "", "", 230, 242));
        fileFieldList.add(new FileField("l15-QBP537-LOCATION", subString(dataChar, 6), "X(06)", 230, 235));
        fileFieldList.add(new FileField("l15-QBP537-TAX-TYPE", subString(dataChar, 3), "X(03)", 236, 238));
        fileFieldList.add(new FileField("l15-QBP53-TAX-AMT", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 239, 242));
        fileFieldList.add(new FileField("l10-QBP537-BLL-NXT-AVL-DT", subStringComp3(dataHex, 5, 8, 0, false), "S9(08) COMP-3", 243, 247));
        fileFieldList.add(new FileField("l10-QBP537-DSC-DT", subStringComp3(dataHex, 5, 8, 0, false), "S9(08) COMP-3", 248, 252));
        fileFieldList.add(new FileField("l10-QBP537-PO-NUMB", subString(dataChar, 22), "X(22)", 253, 274));
        fileFieldList.add(new FileField("l10-QBP537-CNTRY-OF-ORGN", subString(dataChar, 29), "X(29)", 275, 303));
        fileFieldList.add(new FileField("l10-QBP537-ORDER-TYPE", subString(dataChar, 2), "X(02)", 304, 305));
        fileFieldList.add(new FileField("l10-QBP537-ITEM-NET-SELL", subStringComp3(dataHex, 5, 5, 4, true), "S9(5)V9(4) COMP-3", 306, 310));

        return "D|" + item + "|" + desc + "|" + bioEng + "|" + tprFl + "|" + kitmShpFl;

    }

    private String shpRec(String dataHex, String dataChar) {

        fileFieldList.add(new FileField("l05-QBP537-SHIPPER-COMPONENT", "", "", 33, 310));
        fileFieldList.add(new FileField("l10-FILLER", "", "X(8)", 33, 41));
        currentIndex += 8;

        fileFieldList.add(new FileField("l10-QBP537-SHIP-INVOICE-NUMBER", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 42, 44));

        fileFieldList.add(new FileField("l10-FILLER", "", "X(36)", 45, 80));
        currentIndex += 36;

        fileFieldList.add(new FileField("l10-QBP537-ITEM", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 81, 84));
        fileFieldList.add(new FileField("l10-QBP537-UPC", subString(dataChar, 15), "X(15)", 85, 99));

        String item = subStringComp3(dataHex, 4, 7, 0, false);
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-ITEM", item, "S9(7) COMP-3", 100, 103));

        String desc = subString(dataChar, 30);
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-DESCRIPTION", desc, "X(30)", 104, 133));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-SIZE", subString(dataChar, 6), "X(6)", 134, 139));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-QTY", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 140, 143));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-UPC-CODE", subString(dataChar, 15), "X(15)", 144, 158));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-RETAIL-UNIT", subStringComp3(dataHex, 2, 3, 0, false), "S9(3) COMP-3", 159, 160));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-COST", subStringComp3(dataHex, 6, 7, 4, false), "S9(7)V9(4) COMP-3", 161, 166));

        String bioEng = subString(dataChar, 1);
        String tprFl = subString(dataChar, 1);
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-BIO-ENG", bioEng, "X(1)", 167, 167));
        fileFieldList.add(new FileField("l10-QBP537-SHIPPER-TPR-FL", tprFl, "X(1)", 168, 168));

        fileFieldList.add(new FileField("l10-FILLER", "", "X(142)", 169, 310));
        currentIndex += 142;

        return "S| " + item + "|" + desc + "|" + bioEng + "|" + tprFl;

    }

    private String totRec(String dataHex, String dataChar) {

        fileFieldList.add(new FileField("l05-QBP537-TOTAL-ACCUM-FIELDS", "", "", 33, 310));
        fileFieldList.add(new FileField("l10-FILLER", "", "X(1)", 33, 33));
        currentIndex += 1;

        fileFieldList.add(new FileField("l10-QBP537-TOTAL-BREAKER", subString(dataChar, 3), "9(03)", 34, 36));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-DELIVERY-CHARGE", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 37, 40));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-ENDING-INVOICE-NO", subStringComp3(dataHex, 4, 7, 0, false), "S9(7) COMP-3", 41, 44));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-STMNT-DT", subStringComp3(dataHex, 5, 9, 0, false), "S9(9) COMP-3", 45, 49));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-RETAIL", subStringComp3(dataHex, 5, 6, 2, true), "S9(6)V99 COMP-3", 50, 54));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-REGULAR-PROMO", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 55, 58));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-SELL", subStringComp3(dataHex, 5, 7, 2, true), "S9(7)V99 COMP-3", 59, 63));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-PALLET-ALLOW", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 64, 67));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-PERF-ALLOW", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 68, 71));
        fileFieldList.add(new FileField("l10-QBP537-TOTAL-HANDBILL-FEES", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", 72, 75));
        fileFieldList.add(new FileField("l10-FILLER", "", "X(235)", 76, 310));
        currentIndex += 235;

        return "";

    }

    private String dealRecArea(String dataHex, String dataChar) {

        Integer curIndex = currentIndex;

        fileFieldList.add(new FileField("l10-QBP537-SALE-DEAL-CODES", "", "", curIndex + 1, curIndex + 25));

        fileFieldList.add(new FileField("l15-QBP537-OFFER-CD", subString(dataChar, 7), "X(07)", curIndex + 1, curIndex + 7));
        fileFieldList.add(new FileField("l15-QBP537-DEAL-TYPE", subString(dataChar, 1), "X(01)", curIndex + 8, curIndex + 8));
        fileFieldList.add(new FileField("l15-QBP537-PROMOTION-PROGRAM", subString(dataChar, 1), "X(01)", curIndex + 9, curIndex + 9));
        fileFieldList.add(new FileField("l15-QBP537-START-DT", subStringComp(dataHex, 4), "9(08) COMP", curIndex + 10, curIndex + 13));
        fileFieldList.add(new FileField("l15-QBP537-END-DT", subStringComp(dataHex, 4), "9(08) COMP", curIndex + 14, curIndex + 17));
        fileFieldList.add(new FileField("l15-QBP537-TYPE-EXPENSE", subString(dataChar, 1), "X(01)", curIndex + 18, curIndex + 18));
        fileFieldList.add(new FileField("l10-QBP537-DEAL-AMOUNT", subStringComp3(dataHex, 4, 5, 2, true), "S9(5)V99 COMP-3", curIndex + 19, curIndex + 22));
        fileFieldList.add(new FileField("l15-QBP537-PROMO-ID", subString(dataChar, 3), "X(03)", curIndex + 23, curIndex + 25));

        //System.out.println(" ci = " + curIndex + "  ci = " + currentIndex);

        return "";

    }

    private String subString(String charString, Integer length) {

        Integer startIndex = currentIndex;
        Integer endIndex = currentIndex + length;
        currentIndex = endIndex;

        return StringUtils.substring(charString, startIndex, endIndex);

    }

    private String subStringComp(String hexString, Integer length) {

        Integer startIndex = currentIndex * 2;
        currentIndex = currentIndex + length;
        Integer endIndex = startIndex + (length * 2);
        String hexValue = StringUtils.substring(hexString, startIndex, endIndex);
        
        Integer intValue = Integer.valueOf(hexValue, 16);

        return intValue.toString();

    }

    private String subStringComp3(String hexString, Integer length, Integer intLength, Integer decLength, Boolean signed) {

        Integer startIndex = currentIndex * 2;
        currentIndex = currentIndex + length;
        Integer endIndex = startIndex + (length * 2);

        //System.out.println("****************************");
        //System.out.println("* startIndex = " + startIndex);
        //System.out.println("* endIndex   = " + endIndex);
        //System.out.println("* " + StringUtils.substring(hexString, startIndex, endIndex));
        //System.out.println("****************************");
        String comp3 = StringUtils.substring(hexString, startIndex, endIndex);
        String whole = StringUtils.substring(comp3, 0, intLength);
        String decimal = StringUtils.substring(comp3, intLength, intLength + decLength);
        String sign = "-";
        if (StringUtils.equalsIgnoreCase(StringUtils.substring(comp3, -1), "c")) {
            sign = "+";
        }
        if (!signed) {
            sign = "";
        }
        String decimalPoint = ".";
        if (decLength == 0) {
            decimalPoint = "";
        }
        //System.out.println(comp3 + "|" + whole + "|" + decimal + "|" + sign);
        //System.out.println("****************************");

        return sign + whole + decimalPoint + decimal;

    }

    public FileRecord getFileRecord() {
        return fileRecord;
    }

}
