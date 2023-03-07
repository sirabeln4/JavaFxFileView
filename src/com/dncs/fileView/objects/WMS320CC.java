package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WMS320CC {

	private FileRecord fileRecord;
	
	private String frKey;
	private StringBuilder frValue;
	private ObservableList<FileField> fileFieldList;
	private Integer currentIndex;
	
	public WMS320CC(String hexString, String charString) throws Exception {
		super();
		
		String WMS320_FACL;
		String WMS320_ITEM_NUM;
		String WMS320_UNIT_QTY;//              col  35- 38 S9(7,0) COMP-3
		String WMS320_AVG_WKLY_MVMT;//         col 418-421 S9(7,0) COMP-3
		String WMS320_DAYS_AVAIL_SHIP;//       col 426-428 S9(5,0) COMP-3
		String WMS320_SELL_BY_DT_BEFORE_EXP;// col 429-436 PIC X(08)
		String WMS320_ADVANCE_DAYS_THRHOLD;//  col 441-442 S9(3,0) COMP-3
		
		frKey         = "Facl/Item/";
		frValue       = new StringBuilder();
		fileFieldList = FXCollections.observableArrayList();
		
		currentIndex = 0;
		
		//frValue.append(StringUtils.substring(charString, 0, 2) + " / ");
		//frValue.append(StringUtils.substring(charString, 2, 7));
		
		fileFieldList.add(new FileField("l05-WMS320-FACL",            subString(charString, 2),                   "X(02)",              1,    2));
		WMS320_FACL = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-ITEM-NUM",        subString(charString, 7),                   "X(07)",              3,    9));
		WMS320_ITEM_NUM = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-LOCATION",        subString(charString, 9),                   "X(09)",             10,   18));
		fileFieldList.add(new FileField("l05-WMS320-LOAD-NUM",        subString(charString, 14),                  "X(14)",             19,   32));
		fileFieldList.add(new FileField("l05-WMS320-DATE-CNTL-FL",    subString(charString, 1),                   "X(01)",             33,   33));
		fileFieldList.add(new FileField("l05-WMS320-EXP-DATE-FL",     subString(charString, 1),                   "X(01)",             34,   34));
		fileFieldList.add(new FileField("l05-WMS320-UNIT-QTY",        subStringComp3(hexString, 4, 7, 0, true),   "S9(7) COMP-3",      35,   38));
		WMS320_UNIT_QTY = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-EXP-DATE",        subStringDt(charString, 8),                 "X(08)",             39,   46));
		fileFieldList.add(new FileField("l05-WMS320-INV-DATE",        subStringDt(charString, 14),                "X(14)",             47,   60));
		fileFieldList.add(new FileField("l05-WMS320-FIFO-DATE",       subStringDt(charString, 14),                "X(14)",             61,   74));
		fileFieldList.add(new FileField("l05-WMS320-PART-FAM",        subString(charString, 10),                  "X(10)",             75,   84));
		fileFieldList.add(new FileField("l05-WMS320-COMM-CODE",       subString(charString, 2),                   "X(02)",             85,   86));
		fileFieldList.add(new FileField("l05-WMS320-PO-NUM",          subStringComp3(hexString, 3, 5, 0, true),   "S9(5) COMP-3",      87,   89));
		fileFieldList.add(new FileField("l05-WMS320-OVR-FL",          subString(charString, 1),                   "X(01)",             90,   90));
		fileFieldList.add(new FileField("l05-WMS320-SHELF-OVERFLG",   subString(charString, 1),                   "X(01)",             91,   91));
		fileFieldList.add(new FileField("l05-WMS320-DTCTL-REFUSED",   subString(charString, 1),                   "X(01)",             92,   92));
		fileFieldList.add(new FileField("l05-WMS320-DAYS-TO-SELL",    subStringComp3(hexString, 3, 5, 0, true),   "S9(5) COMP-3",      93,   95));
		fileFieldList.add(new FileField("l05-WMS320-INSERT-TS",       subStringDt(charString, 26),                "X(26)",             96,  121));
		fileFieldList.add(new FileField("l05-WMS320-DTCTL-SKP-FL",    subString(charString,  1),                  "X(01)",            122,  122));
		fileFieldList.add(new FileField("l05-WMS320-RCVKEY",          subString(charString, 15),                  "X(15)",            123,  137));
		fileFieldList.add(new FileField("l05-WMS320-RCVUSR",          subString(charString, 20),                  "X(20)",            138,  157));
		fileFieldList.add(new FileField("l05-WMS320-ADD-DATE",        subStringDt(charString, 14),                "X(14)",            158,  171));
		fileFieldList.add(new FileField("l05-WMS320-RECV-DATE",       subStringDt(charString, 14),                "X(14)",            172,  185));
		fileFieldList.add(new FileField("l05-WMS320-LSTMOV",          subStringDt(charString, 14),                "X(14)",            186,  199));
		fileFieldList.add(new FileField("l05-WMS320-LSTDTE",          subStringDt(charString, 14),                "X(14)",            200,  213));
		fileFieldList.add(new FileField("l05-WMS320-SUBNUM",          subString(charString, 30),                  "X(30)",            214,  243));
		fileFieldList.add(new FileField("l05-WMS320-DTLNUM",          subString(charString, 30),                  "X(30)",            244,  273));
		fileFieldList.add(new FileField("l05-WMS320-ORIGIN-CODE",     subString(charString, 20),                  "X(20)",            274,  293));
		fileFieldList.add(new FileField("l05-WMS320-LOT-NUMBER",      subString(charString, 20),                  "X(20)",            294,  313));
		fileFieldList.add(new FileField("l05-WMS320-INVSTS",          subString(charString, 4),                   "X(04)",            314,  317));
		fileFieldList.add(new FileField("l05-WMS320-ADV-SHIP-FL",     subString(charString, 1),                   "X(01)",            318,  318));
		fileFieldList.add(new FileField("l05-WMS320-INV-STATUS",      subString(charString, 1),                   "X(01)",            319,  319));
		fileFieldList.add(new FileField("l05-WMS320-REPORT-DATE",     subStringDt(charString, 8),                 "X(08)",            320,  327));
		fileFieldList.add(new FileField("l05-WMS320-DIVISION",        subString(charString, 2),                   "X(02)",            328,  329));
		fileFieldList.add(new FileField("l05-WMS320-WHSE",            subString(charString, 2),                   "X(02)",            330,  331));
		fileFieldList.add(new FileField("l05-WMS320-BUYER-NUM",       subString(charString, 3),                   "X(03)",            332,  334));
		fileFieldList.add(new FileField("l05-WMS320-VEND-NUM",        subString(charString, 7),                   "X(07)",            335,  341));
		fileFieldList.add(new FileField("l05-WMS320-VEND-NAME",       subString(charString, 30),                  "X(30)",            342,  371));
		fileFieldList.add(new FileField("l05-WMS320-INVENTORY-DEPT",  subString(charString, 2),                   "X(02)",            372,  373));
		fileFieldList.add(new FileField("l05-WMS320-ITEM-DESC-SHORT", subString(charString, 20),                  "X(20)",            374,  393));
		fileFieldList.add(new FileField("l05-WMS320-PACK",            subStringComp3(hexString, 4, 7, 0, true),   "S9(7) COMP-3",       394,  397));
		fileFieldList.add(new FileField("l05-WMS320-ITEM-SIZE",       subString(charString, 15),                  "X(15)",              398,  412));
		fileFieldList.add(new FileField("l05-WMS320-AWG-SELL",        subStringComp3(hexString, 5, 4, 5, true),   "S9(4)V9(05) COMP-3", 413,  417));
		fileFieldList.add(new FileField("l05-WMS320-AVG-WEEKLY-MVMT", subStringComp3(hexString, 4, 7, 0, true) ,  "S9(7) COMP-3",       418,  421));
		WMS320_AVG_WKLY_MVMT = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-TOTAL-ON-ORDER",  subStringComp3(hexString, 4, 7, 0, true),   "S9(7) COMP-3",       422,  425));
		fileFieldList.add(new FileField("l05-WMS320-DAYS-AVAIL-SHIP", subStringComp3(hexString, 3, 5, 0, true),   "S9(5) COMP-3",       426,  428));
		WMS320_DAYS_AVAIL_SHIP =  fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-SELL-BY-DT-BEFORE-EXP", subStringDt(charString, 8),           "X(08)",              429,  436));
		WMS320_SELL_BY_DT_BEFORE_EXP = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-WHS-SHELF-LIFE",  subStringComp(hexString, 2),                "S9(04) COMP-4",      437,  438));
		fileFieldList.add(new FileField("l05-WMS320-STR-SHELF-LIFE",  subStringComp(hexString, 2),                "S9(04) COMP-4",      439,  440));
		fileFieldList.add(new FileField("l05-WMS320-ADVANCE-DAYS-THRHOLD",  subStringComp3(hexString, 2, 3, 0, true), "S9(3) COMP-3",   441,  442));
		WMS320_ADVANCE_DAYS_THRHOLD = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS320-PRIVATE-LABEL",    subString(charString, 15),                  "X(15)",             443,  457));
		fileFieldList.add(new FileField("l05-WMS320-MILITARY-ONLY-FL", subString(charString, 01),                  "X(01)",             458,  458));
		fileFieldList.add(new FileField("l05-WMS320-PREBOOK-ONLY-FL",  subString(charString, 01),                  "X(01)",             459,  459));
		fileFieldList.add(new FileField("l05-WMS320-FILLER",           subString(charString, 41),                  "X(41)",             460,  500));
        
		frValue.append(    "" + WMS320_ADVANCE_DAYS_THRHOLD);	//col 441-442 S9(3,0) COMP-3
		frValue.append("  / " + WMS320_DAYS_AVAIL_SHIP);		//col 426-428 S9(5,0) COMP-3
		frValue.append("  / " + WMS320_SELL_BY_DT_BEFORE_EXP);	//col 429-436 PIC X(08)
		frValue.append("  / " + WMS320_UNIT_QTY);				//col  35- 38 S9(7,0) COMP-3
		frValue.append("  / " + WMS320_AVG_WKLY_MVMT);			//col 418-421 S9(7,0) COMP-3
		
		//if(Integer.parseInt(WMS320_ADVANCE_DAYS_THRHOLD) > 0 && Integer.parseInt(WMS320_ADVANCE_DAYS_THRHOLD) >= Integer.parseInt(WMS320_DAYS_AVAIL_SHIP) ) {
		//	frValue.append("   **************************");
		//}
				
		frKey = WMS320_FACL + " / " + WMS320_ITEM_NUM;
		
		this.fileRecord = new FileRecord(frKey, frValue.toString(), "", fileFieldList, hexString, charString);
		
	}
	
	private String subString(String charString, Integer length) {
		
		Integer startIndex = currentIndex;
		Integer endIndex   = currentIndex + length;
		currentIndex       = endIndex;
		
		return StringUtils.substring(charString, startIndex, endIndex);
		
	}
	
    private String subStringDt(String charString, Integer length) {
		
		Integer startIndex = currentIndex;
		Integer endIndex   = currentIndex + length;
		currentIndex       = endIndex;
		Integer padLength  = 10;
		
		if (length > 8) {
			padLength = 19;
		}
		String dateTime = StringUtils.substring(charString, startIndex, endIndex);
		if (StringUtils.isBlank(dateTime)) {
			return StringUtils.rightPad(dateTime, padLength);
		}
		
		String date = StringUtils.substring(dateTime, 0, 4) + "-"
		            + StringUtils.substring(dateTime, 4, 6) + "-"
		            + StringUtils.substring(dateTime, 6, 8);
		String time = "";
		
		if (length > 8) {
			time = " " + StringUtils.substring(dateTime,  8, 10) + ":"
		               + StringUtils.substring(dateTime, 10, 12) + ":"
				       + StringUtils.substring(dateTime, 12, 14);
		}
		
		//if (length > 14) {
		//	time = " " + StringUtils.substring(dateTime, 8,10) + ":"
		//               + StringUtils.substring(dateTime, 10, 12);
		//}
		
		return StringUtils.rightPad(date + time, padLength);
	}
    
    private String subStringComp(String hexString, Integer length) {
		
		Integer startIndex = currentIndex * 2;
		currentIndex       = currentIndex + length;
		Integer endIndex   = startIndex   + (length * 2); 
		String hexValue    = StringUtils.substring(hexString, startIndex, endIndex);
		Integer intValue   = Integer.parseInt(hexValue, 16);
		
		return intValue.toString();
		
	}
    
	private String subStringComp3(String hexString, Integer length, Integer intLength, Integer decLength, Boolean signed) {
		
		Integer startIndex = currentIndex * 2;
		currentIndex       = currentIndex + length;
		Integer endIndex   = startIndex   + (length * 2); 
		
		//System.out.println("****************************");
		//System.out.println("* startIndex = " + startIndex);
		//System.out.println("* endIndex   = " + endIndex);
		//System.out.println("* " + StringUtils.substring(hexString, startIndex, endIndex));
		//System.out.println("****************************");
		
		String comp3   = StringUtils.substring(hexString, startIndex, endIndex);
		String whole   = StringUtils.substring(comp3, 0, intLength);
		String decimal = StringUtils.substring(comp3, intLength, intLength + decLength);
		String sign    = "-";
		if (StringUtils.equalsIgnoreCase(StringUtils.substring(comp3, -1), "c")) {
			sign = "";
		}
		if (!signed) {
			sign = "";
		}
		String decimalPoint = ".";
		if (decLength == 0 ) {
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
