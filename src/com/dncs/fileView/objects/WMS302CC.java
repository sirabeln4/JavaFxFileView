package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WMS302CC {
	
	private FileRecord fileRecord;
	
	private String frKey;
	private StringBuilder frValue;
	private ObservableList<FileField> fileFieldList;
	private Integer currentIndex;
	
	public WMS302CC(String hexString, String charString) throws Exception {
		super();
		
		String WMS302_FACL;
		String WMS302_WHSE;
		String WMS302_ITEM_NUM;
		String WMS302_EXP_DATE;
		//String WMS302_UNIT_QTY;					// col  S9(7,0) COMP-3
		//String WMS302_AVG_DLY_MVMT; 			// col  S9(7,0) COMP-3
	//	String WMS302_DAYS_AVAIL_SHIP;			// col  S9(5,0) COMP-3
		//String WMS302_SELL_BY_DT_BEFORE_EXP;	// col  PIC X(08)
		//String WMS302_ADVANCE_DAYS_THRHOLD;		// col  S9(3,0) COMP-3
		
		frKey         = "Facl/Item/";
		frValue       = new StringBuilder();
		fileFieldList = FXCollections.observableArrayList();
		
		currentIndex = 0;
		
		//frValue.append(StringUtils.substring(charString, 0, 2) + " / ");
		//frValue.append(StringUtils.substring(charString, 2, 7));
		
		fileFieldList.add(new FileField("l05-WMS302-FACL",             subString(charString, 2),                   "X(02)",              1,     2));
		WMS302_FACL = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS302-WHSE",             subString(charString, 2),                   "X(02)",              3,     4));
		WMS302_WHSE = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS302-BUYR",             subString(charString, 3),                   "X(03)",              5,     7));
		fileFieldList.add(new FileField("l05-WMS302-VEND",             subString(charString, 7),                   "X(07)",              8,    14));
		fileFieldList.add(new FileField("l05-WMS302-SVEND",            subString(charString, 3),                   "X(03)",             15,    17));
		fileFieldList.add(new FileField("l05-WMS302-VEND-NAME",        subString(charString, 20),                  "X(20)",             18,    37));
		fileFieldList.add(new FileField("l05-WMS302-LOCATION",         subString(charString, 9),                   "X(09)",             38,    46));
		fileFieldList.add(new FileField("l05-WMS302-INV-DEPT",         subString(charString, 2),                   "X(02)",             47,    48));
		fileFieldList.add(new FileField("l05-WMS302-CASES",            subStringComp3(hexString, 4, 7, 0, true),   "S9(7) COMP-3",      49,    52));
		fileFieldList.add(new FileField("l05-WMS302-ITEM-NUM",         subString(charString, 7),                   "X(07)",             53,    59));
		WMS302_ITEM_NUM = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS302-ITEM-DESC",        subString(charString, 20),                  "X(20)",             60,   79));
		fileFieldList.add(new FileField("l05-WMS302-EXP-DATE-FL",      subString(charString, 4),                   "X(04)",             80,   83));
		fileFieldList.add(new FileField("l05-WMS302-EXP-DATE",         subStringDt(charString, 8),                 "X(08)",             84,   91));
		WMS302_EXP_DATE = fileFieldList.get(fileFieldList.size() - 1).getFieldValueTxt();
		fileFieldList.add(new FileField("l05-WMS302-DAYS-AVL-TO-SHIP", subStringComp3(hexString, 3, 5, 0, true),   "S9(5) COMP-3",      92,     94));
		fileFieldList.add(new FileField("l05-WMS302-AVG-DLY-MVMT",     subStringComp3(hexString, 4, 3, 4, true) ,  "S9(3)V9(4) COMP-3", 95,     98));
		fileFieldList.add(new FileField("l05-WMS302-WHS-SHELF-LIFE",  subStringComp3(hexString, 3, 5, 0, true),    "S9(05) COMP-3",     99,    101));
		fileFieldList.add(new FileField("l05-WMS302-STR-SHELF-LIFE",  subStringComp3(hexString, 3, 5, 0, true),    "S9(05) COMP-3",    102,    104));
		fileFieldList.add(new FileField("l05-WMS302-ADVNC-DAYS",      subStringComp3(hexString, 2, 3, 0, true),    "S9(03) COMP-3",    105,    106));
		fileFieldList.add(new FileField("l05-WMS302-SPCK",            subStringComp3(hexString, 4, 7, 0, true),    "S9(07) COMP-3",    107,    110));
		fileFieldList.add(new FileField("l05-WMS302-SIZE",            subString(charString, 10),                   "X(10)",            111,    120));
		fileFieldList.add(new FileField("l05-WMS302-LOAD-NUM",        subString(charString, 14),                   "X(14)",            121,    134));
		fileFieldList.add(new FileField("l05-WMS302-VM-FL",           subString(charString, 1),                    "X(01)",            135,    135));
		fileFieldList.add(new FileField("l05-WMS302-ELBL-FL",         subString(charString, 1),                    "X(01)",            136,    136));
		fileFieldList.add(new FileField("l05-WMS302-LIST-COST",       subStringComp3(hexString, 4, 5, 2, true),    "S9(5)V9(02) COMP-3", 137,  140));
		fileFieldList.add(new FileField("l05-WMS302-BUYER-NM",        subString(charString, 30),                   "X(30)",             141,   170));
		fileFieldList.add(new FileField("l05-WMS302-RECV-DATE",       subStringDt(charString, 8),                  "X(08)",             171,   178));
		fileFieldList.add(new FileField("l05-WMS302-ACTUAL-LIFE",     subStringComp3(hexString, 3, 5, 0, true),    "S9(05) COMP-3",     179,   181));
		fileFieldList.add(new FileField("l05-WMS302-CATMGR",          subString(charString, 3),                    "X(03)",             182,   184));
		fileFieldList.add(new FileField("l05-WMS302-CATMGR-NM",       subString(charString, 30),                   "X(30)",             185,   214));
		fileFieldList.add(new FileField("l05-WMS302-PO-NUM",          subStringComp3(hexString, 3, 5, 0, true),    "S9(5) COMP-3",      215,   217));
		fileFieldList.add(new FileField("l05-WMS302-DVRTD-FL",        subString(charString, 01),                   "X(01)",             218,   218));
		fileFieldList.add(new FileField("l05-WMS302-RSN-CD",          subString(charString, 2),                    "X(02)",             219,   220));
		fileFieldList.add(new FileField("l05-WMS302-RSN-DESC",        subString(charString, 30),                   "X(30)",             221,   250));
		fileFieldList.add(new FileField("l05-WMS302-VEND-REP",        subString(charString, 30),                   "X(30)",             251,   280));
		fileFieldList.add(new FileField("l05-WMS302-DAYS-TO-SELL",    subStringComp3(hexString, 3, 5, 0, true),    "S9(5) COMP-3",      281,   283));
		fileFieldList.add(new FileField("l05-WMS302-VNDR-SHLF-LFE",   subStringComp3(hexString, 3, 5, 0, true),    "S9(5) COMP-3",      284,   286));
		fileFieldList.add(new FileField("l05-WMS302-PRVT-LBL-CD",     subString(charString, 1),                    "X(01)",             287,   287));
		fileFieldList.add(new FileField("l05-WMS302-PRVT-LBL-TEXT",   subString(charString, 15),                   "X(15)",             288,   302));
		fileFieldList.add(new FileField("l05-WMS302-SHP-FL",          subString(charString, 01),                   "X(01)",             303,   303));
		fileFieldList.add(new FileField("l05-WMS302-SHELF-LIFE-DIFF", subString(charString, 05),                   "S9(5)",             304,   308));
		fileFieldList.add(new FileField("l05-WMS302-CASE-COST-BSP",   subStringComp3(hexString, 4, 5, 2, true),    "S9(5)V9(02) COMP-3", 309,  312));
		fileFieldList.add(new FileField("l05-WMS302-CASE-COST-INV",   subStringComp3(hexString, 4, 5, 2, true),    "S9(5)V9(02) COMP-3", 313,  316));
		fileFieldList.add(new FileField("l05-WMS302-INV-STATUS",      subString(charString, 20),                   "X(20)",              317,  336));
		fileFieldList.add(new FileField("l05-WMS302-PREBK-QTY",       subStringComp3(hexString, 4, 7, 0, true),    "S9(7) COMP-3",       337,  340));
		fileFieldList.add(new FileField("l05-WMS302-BYR-ORG-QTY",     subStringComp3(hexString, 4, 7, 0, true),    "S9(7) COMP-3",       341,  344));
		fileFieldList.add(new FileField("l05-WMS302-DEM-AMT",         subStringComp3(hexString, 5, 9, 0, true),    "S9(9) COMP-3",       345,  349));
		fileFieldList.add(new FileField("l05-WMS302-FILLER",          subString(charString, 1),                    "X(01)",              350,  350));
        
		frValue.append(" ");
		//frValue.append(    "" + WMS302_ADVANCE_DAYS_THRHOLD);	//col 441-442 S9(3,0) COMP-3
		//frValue.append("  / " + WMS302_DAYS_AVAIL_SHIP);		//col 426-428 S9(5,0) COMP-3
		//frValue.append("  / " + WMS302_SELL_BY_DT_BEFORE_EXP);	//col 429-436 PIC X(08)
		//frValue.append("  / " + WMS302_UNIT_QTY);				//col  35- 38 S9(7,0) COMP-3
		//frValue.append("  / " + WMS302_AVG_WKLY_MVMT);			//col 418-421 S9(7,0) COMP-3
			
		frKey = WMS302_FACL + " / " + WMS302_WHSE + " / " + WMS302_ITEM_NUM + " / " + WMS302_EXP_DATE;
		
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
		
		String date = StringUtils.substring(dateTime, 0, 2) + "-"
		            + StringUtils.substring(dateTime, 2, 4) + "-"
		            + StringUtils.substring(dateTime, 4, 8);
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
    
//    private String subStringComp(String hexString, Integer length) {
//		
//		Integer startIndex = currentIndex * 2;
//		currentIndex       = currentIndex + length;
//		Integer endIndex   = startIndex   + (length * 2); 
//		String hexValue    = StringUtils.substring(hexString, startIndex, endIndex);
//		Integer intValue   = Integer.parseInt(hexValue, 16);
//		
//		return intValue.toString();
//		
//	}
    
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
