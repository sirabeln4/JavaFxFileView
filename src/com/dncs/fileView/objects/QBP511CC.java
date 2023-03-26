package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QBP511CC {

    private FileRecord levelFR;
    private FileRecord subRecFR;

    private Integer currentIndex;

    String fullHexString;
    String fullCharString;
    ObservableList<FileField> fullFileFieldList;

    //01 QBP511-RECORD.
    //  05 QBP511-IDENTIFIER.
    //******************************************************************
    //*      KNVC - INVOICE MASTER (LEVEL 1) KEY FIELDS                *
    //**********************************************************50BYTES*
    private final String l10_QBP511_KNVC_IVNO;		//PIC  9(07) VALUE 0.
    private final String l10_QBP511_KNVC_IVDT;		//PIC  9(08) VALUE 0.
    private final String l10_QBP511_KNVC_FWHS;		//REDEFINE
    private final String l15_QBP511_KNVC_FACL;		//PIC  X(02) VALUE SPACES.
    private final String l15_QBP511_KNVC_WHSE;		//PIC  X(02) VALUE SPACES.
    private final String l10_QBP511_KNVC_STOR;		//PIC  9(05) VALUE 0.
    private final String l10_QBP511_KNVC_TYPE;		//PIC  X(02) VALUE SPACES.
    //* ** POPULATE KNVC-TYPE WITH HIGH-VALUES FOR LOWER-LEVEL
    //* ** DATA RECORDS (INVOICE BREAKER, ITEM ETC.)
    //  88 QBP511-KNVC-TYPE-INVC           VALUE '00'.
    //  88 QBP511-KNVC-TYPE-ICNT           VALUE '20'.
    //  88 QBP511-KNVC-TYPE-IMFE           VALUE '60'.
    //  88 QBP511-KNVC-TYPE-IMTF           VALUE '65'.
    //  88 QBP511-KNVC-TYPE-IMLI           VALUE '80'.
    //  88 QBP511-KNVC-TYPE-IMLD           VALUE '85'.
    //  88 QBP511-KNVC-TYPE-INVT           VALUE '99'.
    private final String l10_QBP511_KNVC_ROUT;		//PIC  X(04) VALUE SPACES.
    private final String l10_QBP511_KNVC_STOP;		//PIC  X(03) VALUE SPACES.
    private final String l10_QBP511_KNVC_DDAT;		//PIC  9(08) VALUE 0.
    private final String l10_QBP511_KNVC_CPY_CD;		//PIC  X(05) VALUE SPACES.
    private final String l10_QBP511_KNVC_ROUT_PRC_FL;	//PIC  X(01) VALUE SPACES.
    private final String l10_QBP511_KNVC_CPY_SRT_BY;	//PIC  X(03) VALUE SPACES.        *  
    //******************************************************************
    //*      KNVB - INVOICE BREAKER (LEVEL 2) KEY FIELDS               *
    //**********************************************************40BYTES*
    private final String l10_QBP511_KNVB_ORNO;		//PIC  9(05) VALUE 0.
    private final String l10_QBP511_KNVB_INV_BREAK;	//PIC  X(05) VALUE SPACES.
    private final String l10_QBP511_KNVB_WDPT;		//PIC  X(02) VALUE SPACES.
    private final String l10_QBP511_KNVB_ORTP;		//PIC  X(02) VALUE SPACES.
    private final String l10_QBP511_KNVB_TYPE;		//PIC  X(02) VALUE SPACES.
    //* ** POPULATE KNVB-TYPE WITH HIGH-VALUES FOR LOWER-LEVEL
    //* ** DATA RECORDS (ITEM, ALLOWANCES, SHIPPERS ETC.)
    //  88 QBP511-KNVB-TYPE-INVB           VALUE '00'.
    //* 88 QBP511-KNVB-TYPE-IBFE           VALUE '60'.
    //* 88 QBP511-KNVB-TYPE-IVBT           VALUE '99'.
    private final String l10_filler1;					//PIC X(08) VALUE SPACES.         ML110311
    private final String l10_QBP511_KNVB_ORD_CLASS;	//PIC X(01) VALUE SPACES.
    private final String l10_QBP511_KNVB_TEXT;		//10 QBP511-KNVB-TEXT        PIC X(15) VALUE SPACES.
    //******************************************************************
    //*      KITM - INVOICE DETAIL/ITEM (LEVEL 3) KEY FIELDS           *
    //*********************************************************138BYTES*
    private final String l10_QBP511_KITM_ITEM;		//PIC  9(07) VALUE 0.
    private final String l10_QBP511_KITM_SUBN;		//PIC  X(02) VALUE SPACES.
    private final String l10_QBP511_KITM_COMM;		//PIC  9(05) VALUE 0.
    private final String l10_QBP511_KITM_SUBC;		//PIC  9(05) VALUE 0.
    private final String l10_QBP511_KITM_PUPC;		//PIC  X(15) VALUE SPACES.
    //REDEFINES QBP511-KITM-PUPC.
    private final String l15_QBP511_KITM_UPC_PROD;	//PIC  X(01).
    private final String l15_QBP511_KITM_UPC_MANF;	//PIC  X(05).
    private final String l15_QBP511_KITM_UPC_VNDR_ITM;//PIC X(04).
    private final String l15_QBP511_KITM_UPC_ITEM;	//PIC  X(05).
    private final String l10_QBP511_KITM_SHP_FL;		//PIC  X     VALUE SPACES.
    private final String l10_QBP511_KITM_ITEM_EX_CD;	//PIC  X     VALUE SPACE.
    //  88 QBP511-KITM-ITEM-REC            VALUE 'I'.
    //  88 QBP511-KITM-EXCPT-REC           VALUE 'E'.
    private final String l10_QBP511_KITM_TYPE;		//PIC  X(02) VALUE SPACES.
    //  88 QBP511-KITM-TYPE-ITEM           VALUE '00'.
    //  88 QBP511-KITM-TYPE-ITOR           VALUE '10'.
    //  88 QBP511-KITM-TYPE-ITAL           VALUE '20'.
    //  88 QBP511-KITM-TYPE-IRTB           VALUE '22'.
    //  88 QBP511-KITM-TYPE-ITSC           VALUE '30'.
    //  88 QBP511-KITM-TYPE-ITWT           VALUE '40'.
    //  88 QBP511-KITM-TYPE-ITND           VALUE '50'.
    //  88 QBP511-KITM-TYPE-ITFE           VALUE '60'.
    //  88 QBP511-KITM-TYPE-ITTX           VALUE '70'.
    //  88 QBP511-KITM-TYPE-IVBT           VALUE '99'.
    private final String l10_QBP511_KITM_RFRNC_CD;	//PIC  X(50).
    private final String l10_QBP511_KITM_SLOT;		//PIC  X(06).
    private final String l10_QBP511_KITM_DESC;		//PIC  X(21).
    private final String l10_QBP511_KITM_REF_DESC;	//PIC  X(15) VALUE SPACES.        
    private final String l10_QBP511_KITM_EX_NDC_CD;	//PIC  X     VALUE SPACE.         
    private final String l10_filler2;					//PIC  X(07) VALUE SPACES.        

    //******************************************************************
    //*      KSUB - SUB-KEY FIELDS (KEY TO SUB-LEVEL DATA RECORDS: FEES, ALLOWANCES, SHIPPER COMPONENTS, RANDOM WEIGHTS, NDCS
    //**********************************************************30BYTES*
    private final String l10_QBP511_KSUB_KEY;			//PIC  X(30) VALUE SPACES.
    //REDEFINES QBP511-KSUB-KEY.
    //  (KMFE - IVM FEE RECORD KEY)
    private final String l15_QBP511_KMFE_FEE_CODE;	//  PIC  X(05).
    private final String l15_QBP511_KMFE_FEE_CUST;	//  PIC  X(05).
    //  PIC  X(20).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KMTF - TOTAL FEES RECORD KEY)
    private final String l15_QBP511_KMTF_FEE_CODE;	//  PIC X(05).
    //  PIC  X(25).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KBFE - IVB FEE RECORD KEY)
    private final String l15_QBP511_KBFE_FEE_CODE;	//  PIC  X(05).
    private final String l15_QBP511_KBFE_FEE_CUST;	//  PIC  X(05).
    //  PIC  X(20).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTAL - ITEM ALLOWANCE RECORD KEY)
    //  PIC  X(03).
    private final String l15_QBP511_KTAL_ABBR;		//  PIC  X(04).
    private final String l15_QBP511_KTAL_TS;			//  PIC  X(26).
    //  PIC  X.
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTSC - SHIPPER COMPONENT RECORD KEY)
    private final String l15_QBP511_KTSC_CPO_UPC;		//  PIC  X(15).
    private final String l15_QBP511_KTSC_CPO_ITEM;	//  PIC  X(07).
    //  PIC  X(08).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTWT - RANDOM WEIGHT RECORD KEY)
    private final String l15_QBP511_KTWT_SEQN;		//  PIC  X(05).
    //  PIC  X(25).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTND - NDC CODE RECORD KEY)
    private final String l15_QBP511_KTND_SEQN;		//  PIC  9(04).
    //  PIC  X(26).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTFE - ITEM FEE RECORD KEY)
    private final String l15_QBP511_KTFE_FEE_CODE;	//  PIC  X(05).
    private final String l15_QBP511_KTFE_FEE_CUST;	//  PIC  X(05).
    //  PIC  X(20).
    //REDEFINES QBP511-KSUB-KEY.
    //  (KTTX - ITEM TAX RECORD KEY)
    private final String l15_QBP511_KTTX_LOCATION;	//  PIC  X(06).                     
    private final String l15_QBP511_KTTX_TAX_TYPE;	//  PIC  X(03).
    private final String l15_QBP511_KTTX_TAX_CODE;	//  PIC  X(03).
    //  PIC  X(18).                     
    //
    //******************************************************************
    //*                         DATA FIELDS                            *
    //*  CHGED OCCURS FROM 378 TO 478 FOR INV REDESIGN                 *
    //******************************************************************
    //  05 QBP511-DATA.
    private final Integer l10_QBP511_DATA_LENGTH;		//  PIC 9(04) COMP VALUE   1.
    //private String l10_QBP511_DATA_FIELDS;	//  
    //private String l15_QBP511_DATA_BYTE;		//  PIC X OCCURS 11 TO 478 TIMES
    //     DEPENDING ON QBP511-DATA-LENGTH.
    //
    //******************************************************************
    //*      INVC - INVOICE MASTER DATA - LEVEL 1                      *
    //*********************************************************467BYTES*
    //01 QBP511-INVC-DATA.
    //  05 QBP511-INVC-FIELDS.
    private String l10_QBP511_INVC_DDAY;           //PIC  9(01).
    private String l10_QBP511_INVC_BNAM;           //PIC  X(30).
    private String l10_QBP511_INVC_BAD1;           //PIC  X(30).
    private String l10_QBP511_INVC_BAD2;           //PIC  X(30).
    private String l10_QBP511_INVC_BPHN;           //PIC  X(20).
    private String l10_QBP511_INVC_GINA;           //PIC S9(10)V9(5) COMP-3.
    private String l10_QBP511_INVC_DIVISION;       //PIC  X(02).                    
    private String l10_QBP511_INVC_SERV_FACL;      //PIC  X(02).                    
    private String l10_QBP511_INVC_CIGSTAMP;       //PIC  X(03).
    private String l10_QBP511_INVC_DFRD_INVC;      //PIC  X(01).
    private String l10_QBP511_INVC_EQUITYNBR;      //PIC S9(04) COMP.
    private String l10_QBP511_INVC_RP_GROUP;       //PIC S9(04) COMP.
    private String l10_QBP511_INVC_VM_XDOCK_IND;   //PIC X(01).
    private String l10_QBP511_INVC_NAME;           //PIC  X(27).
    private String l10_QBP511_INVC_STORE_DEA_NBR;  //PIC  X(10).
    private String l10_QBP511_INVC_ADDRESS;        //PIC  X(45).
    private String l10_QBP511_INVC_CITY;           //PIC  X(45).
    private String l10_QBP511_INVC_STATE;          //PIC  X(02).
    private String l10_QBP511_INVC_ZIP_CODE;       //PIC  X(09).
    private String l10_QBP511_INVC_FEE_GRP;        //PIC  X(05).
    private String l10_QBP511_INVC_DEPT_DESC;      //PIC  X(30).
    private String l10_QBP511_INVC_TIME;           //PIC  X(08).
    private String l10_QBP511_INVC_DATA_CORP_NAME; //PIC  X(35).
    private String l10_QBP511_INVC_WHSE_DEA_NBR;   //PIC  X(10).
    private String l10_QBP511_INVC_XDOCK_DEA_NBR;  //PIC  X(10).
    private String l10_QBP511_INVC_XDOCK_ADDRESS;  //PIC  X(45).
    private String l10_QBP511_INVC_XDOCK_CITY;     //PIC  X(45).
    private String l10_QBP511_INVC_XDOCK_STATE;    //PIC  X(02).
    private String l10_QBP511_INVC_XDOCK_ZIP_CODE; //PIC  X(09).

    //******************************************************************
    //*  ICNT - CONTACTS FOR THE WAREHOUSE SHIP FROM ADDRESS LEVEL 1   *
    //*********************************************************164BYTES*
    //01 QBP511-ICNT-DATA.
    //  05 QBP511-ICNT-FIELDS.
    private String l10_QBP511_ICNT_CONTACT; 	//PIC  X(10).
    private String l10_QBP511_ICNT_ADDRESS; 	//PIC  X(45).
    private String l10_QBP511_ICNT_CITY;    	//PIC  X(45).
    private String l10_QBP511_ICNT_STATE;   	//PIC  X(02).
    private String l10_QBP511_ICNT_ZIP_CODE;	//PIC  X(09).

    //
    //******************************************************************
    //*      IMFE - INVOICE MASTER FEES - LEVEL 1                      *
    //*             (MULTIPLE RECORDS PER INVOICE)                     *
    //**********************************************************37BYTES*
    //01 QBP511-IMFE-DATA.
    //  05 QBP511-IMFE-FIELDS.
    private String l10_QBP511_IMFE_FEE_AMT;		//PIC S9(7)V9(5) COMP-3.
    private String l10_QBP511_IMFE_FEE_PCT;		//PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_IMFE_FEE_DESC;	//PIC  X(25).

    //
    //******************************************************************
    //*      IMTF - INVOICE TOTAL FEES  - LEVEL 1                      *
    //*             (MULTIPLE RECORDS PER INVOICE)                     *
    //**********************************************************37BYTES*
    //01 QBP511-IMTF-DATA.
    //  05 QBP511-IMTF-FIELDS.
    private String l10_QBP511_IMTF_FEE_AMT;		//PIC S9(7)V9(5) COMP-3.
    private String l10_QBP511_IMTF_FEE_PCT;		//PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_IMTF_FEE_DESC;	//PIC  X(25).
    //
    //******************************************************************
    //*      IMLI - LICENSE NUMBERS     - LEVEL 1                      *
    //*********************************************************360BYTES*
    //01 QBP511-IMLI-DATA.
    //  05 QBP511-IMLI-FIELDS.
    //private String l10_QBP511_IMLI_WHSE_LICENSE_DATA;	// OCCURS 10 TIMES.
    //       15  QBP511-IMLI-WHSE-LICENSE                PIC X(15).
    //       15  QBP511-IMLI-WHSE-LICENSE-TYPE           PIC X(03).
    //private String l10_QBP511_IMLI_STR_LICENSE_DATA; 	//OCCURS 10 TIMES.
    //       15  QBP511-IMLI-STR-LICENSE                 PIC X(15).
    //       15  QBP511-IMLI-STR-LICENSE-TYPE            PIC X(03).

    //******************************************************************
    //*      IMLD - LICENSE DESC        - LEVEL 1                      *
    //*********************************************************462BYTES*
    //01 QBP511-IMLD-DATA.
    //  05 QBP511-IMLD-FIELDS.
    //private String l10_QBP511_IMLD_LICENSE_DESC_DATA; 	//OCCURS 14 TIMES.
    //       15  QBP511-IMLD-LICENSE-TYPE                PIC X(03).
    //       15  QBP511-IMLD-LICENSE-DESC                PIC X(30).
    //******************************************************************
    //*      INVT - INVOICE TOTALS      - LEVEL 1                      *
    //*********************************************************193BYTES*
    //01 QBP511-INVT-DATA.
    //  05 QBP511-INVT-FIELDS.
    private String l10_QBP511_INVT_ENDING_INVC_NO;   //PIC S9(7) COMP-3.
    private String l10_QBP511_INVT_BREAKER;          //PIC 9(03).
    private String l10_QBP511_INVT_STMNT_DT;         //PIC  9(8).
    private String l10_QBP511_INVT_WEIGHT;           //PIC S9(5)V99 COMP-3.
    private String l10_QBP511_INVT_CUBE;             //PIC S9(6)V9  COMP-3.
    private String l10_QBP511_INVT_PALLET;           //PIC S9(3)    COMP-3.
    private String l10_QBP511_INVT_PIECES;           //PIC S9(5)    COMP-3.
    private String l10_QBP511_INVT_ORDERED;          //PIC S9(5)    COMP-3.
    private String l10_QBP511_INVT_SHIPPED;          //PIC S9(5)    COMP-3.
    private String l10_QBP511_INVT_CIG_PIECES;       //PIC S9(9)    COMP-3.
    private String l10_QBP511_INVT_MEAT;             //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_GROCERY;          //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_FROZEN_FOOD;      //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_STORE_SUPPLY;     //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_STRE_SUPP_TAX;    //PIC S9(5)V99 COMP-3.
    private String l10_QBP511_INVT_STRE_SUPP_ATCOST; //PIC S9(5)V99 COMP-3.
    private String l10_QBP511_INVT_GROSS_PROFITS;    //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_SELL;             //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_COST;             //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_RETAIL;           //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_PROD_COST;        //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_RTL_PRICE;        //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_INVT_N_ALLOW;          //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_REG_PROMO;        //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_REG_FRZ_PROMO;    //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_PERF_ALLOW;       //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_OTHER_ALLOW;      //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_FEES;             //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_DLV_FEES;         //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_HANDBILL_FEES;    //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_OTHER_FEES;       //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_PALLET_ALLOW;     //PIC S9(9)V99 COMP-3.
    private String l10_QBP511_INVT_TOBACCO_TAX;      //PIC S9(7)V99 COMP-3.
    private String l10_QBP511_INVT_TOBACCO_SALES;    //PIC S9(7)V99 COMP-3.
    private String l10_QBP511_INVT_OASIS_CLASS;      //PIC X(01).
    private String l10_QBP511_INVT_OASIS_FACILITY;   //PIC X(04).
    private String l10_QBP511_INVT_DEFERED_INDC;     //PIC X.
    private String l10_QBP511_INVT_DIR_DELV_IND;     //PIC X.
    private String l10_QBP511_INVT_EFF_REBATE;       //PIC S9(8)V9(5) COMP-3.  

    //
    //******************************************************************
    //*      INVB - INVOICE BREAKER     - LEVEL 2                      *
    //*********************************************************134BYTES*
    //01 QBP511-INVB-DATA.
    //  05 QBP511-INVB-FIELDS.
    private String l10_QBP511_INVB_DDAT;         //PIC  9(08).
    private String l10_QBP511_INVB_DDAY;         //PIC  9(01).
    private String l10_QBP511_INVB_ROUT;         //PIC  X(04).
    private String l10_QBP511_INVB_STOP;         //PIC  X(03).
    private String l10_QBP511_INVB_SHP_DT;       //PIC  9(08).
    private String l10_QBP511_INVB_SHP_TM;       //PIC  X(08).
    private String l10_QBP511_INVB_RLS_TM;       //PIC  X(08).
    private String l10_QBP511_INVB_ORTP_DESC;    //PIC  X(45).
    private String l10_QBP511_INVB_FEE_GRP;      //PIC  X(05).
    private String l10_QBP511_INVB_SOURCE;       //PIC  X.
    private String l10_QBP511_INVB_SOLD_AT_COST; //PIC  X.
    private String l10_QBP511_INVB_WILLCALL;     //PIC  X.
    private String l10_QBP511_INVB_HANDBILL;     //PIC  X.
    private String l10_QBP511_INVB_DIRECT_DLVRY; //PIC  X.
    private String l10_QBP511_INVB_DEPT_DESC;    //PIC  X(30).
    private String l10_QBP511_INVB_RLS_DT;       //PIC  9(08).

    //
    //******************************************************************
    //*      IBFE - INVOICE BREAKER FEES - LEVEL 2                     *
    //*             (MULTIPLE RECORDS PER INVOICE BREAKER)             *
    //**********************************************************37BYTES*
    //01 QBP511-IBFE-DATA.
    //  05 QBP511-IBFE-FIELDS.
    private String l10_QBP511_IBFE_FEE_AMT;     //PIC S9(7)V9(5) COMP-3.
    private String l10_QBP511_IBFE_FEE_PCT;     //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_IBFE_FEE_DESC;    //PIC  X(25).

    //
    //******************************************************************
    //*      IVBT - INVOICE BREAK TOTALS - LEVEL 2                     *
    //**********************************************************58BYTES*
    //01 QBP511-IVBT-DATA.
    //  05 QBP511-IVBT-FIELDS.
    private String l10_QBP511_IVBT_DEPT_DESC;   //PIC X(30).
    private String l10_QBP511_IVBT_ORDERED;     //PIC S9(5)     COMP-3.
    private String l10_QBP511_IVBT_SHIPPED;     //PIC S9(5)     COMP-3.
    private String l10_QBP511_IVBT_NET;         //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_IVBT_RTL;         //PIC S9(11)V99 COMP-3.
    private String l10_QBP511_IVBT_TO_WHS;      //PIC S9(5)     COMP-3.
    private String l10_QBP511_IVBT_GROSS_PCT;   //PIC S9(5)V9(4) COMP-3.

    //
    //******************************************************************
    //*      ITEM - INVOICE DETAIL (ITEM) - LEVEL 3                    *
    //*********************************************************478BYTES*
    //01 QBP511-ITEM-DATA.
    //  05 QBP511-ITEM-FIELDS.
    private String l10_QBP511_ITEM_SQNC_NBR;    //PIC S9(07) COMP-3.
    private String l10_QBP511_ITEM_DEP_BREAK;  //PIC  X(05).
    private String l10_QBP511_ITEM_INV_DEPT;    //PIC  X(02).
    private String l10_QBP511_ITEM_RTL_ZONE;    //PIC  X(04).
    private String l10_QBP511_ITEM_CNTRY_ORG;   //PIC  X(30).
    private String l10_QBP511_ITEM_ORIG_ITEM;   //PIC  X(07).
    private String l10_QBP511_ITEM_CMP_ITEM;    //PIC  X(07).
    private String l10_QBP511_ITEM_SUBO;        //PIC  X(07).
    private String l10_QBP511_ITEM_SUBS;        //PIC  X(01).
    private String l10_QBP511_ITEM_DEFR_DT;     //PIC  9(08).
    private String l10_QBP511_ITEM_GR_NET_INV;  //PIC  X(01).
    private String l10_QBP511_ITEM_PLCD;        //PIC  X(01).
    private String l10_QBP511_ITEM_MPCK;        //PIC S9(07) COMP-3.
    private String l10_QBP511_ITEM_SPCK;        //PIC S9(07) COMP-3.
    private String l10_QBP511_ITEM_SIZE;        //PIC  X(15).
    private String l10_QBP511_ITEM_OQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_AQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_SQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_IQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_OADJ;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_PLT_QTY;     //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_NBR_OF_PLTS; //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_CASE_QTY;    //PIC S9(05) COMP-3.
    private String l10_QBP511_ITEM_DEAL_CNTR;   //PIC S9(03) COMP-3.
    private String l10_QBP511_ITEM_SHP_CPO_FL;  //PIC  X(01).
    private String l10_QBP511_ITEM_BILL_AVG_FL; //PIC  X(01).
    private String l10_QBP511_ITEM_RWI;         //PIC  X(01).
    //        88 QBP511_ITEM_RND_WEIGHTED        VALUE 'C'.
    //        88 QBP511_ITEM_AVG_WEIGHTED        VALUE 'I'.
    private String l10_QBP511_ITEM_IWGT;        //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEM_CWGT;        //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEM_CUBE;        //PIC S9(6)V9(3) COMP-3.
    private String l10_QBP511_ITEM_SCST;        //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEM_NET_SELL;    //PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITEM_UNT_NET_SELL; //PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITEM_RTL_CRET;    //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEM_RTL_PRICE;   //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITEM_EXT_RTL_PRICE; //PIC S9(7)V9(4) COMP-3.
    private String l10_QBP511_ITEM_RTL_CFOR;    //PIC S9(3) COMP-3.
    private String l10_QBP511_ITEM_GINA;        //PIC S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITEM_BSP_AMT;     //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEM_INVV;        //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEM_IDIS;        //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEM_EXT_COST;    //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITEM_EXT_CATA;    //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITEM_EXT_NET_SELL; //PIC S9(7)V9(4) COMP-3.
    private String l10_QBP511_ITEM_FEES_AMT;    //PIC S9(8)V9(5) COMP-3.
    private String l10_QBP511_ITEM_ALWNC_AMT;   //PIC S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITEM_TAX_AMT;     //PIC S9(7)V9(5) COMP-3.
    private String l10_QBP511_ITEM_DLVRY_PCT;   //PIC S9(1)V9(4) COMP-3.
    private String l10_QBP511_ITEM_PROF_PCT;    //PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITEM_GROSS_PCT;   //PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITEM_DSDT;        //PIC  9(8).
    private String l10_QBP511_ITEM_BUYR;       ///PIC  X(03).
    private String l10_QBP511_ITEM_CSS_BUYR;    //PIC  X(03).
    private String l10_QBP511_ITEM_VEND;        //PIC  X(07).
    private String l10_QBP511_ITEM_WPHI;        //PIC S9(3) COMP-3.
    private String l10_QBP511_ITEM_WPTI;        //PIC S9(3) COMP-3.
    private String l10_QBP511_ITEM_INV_TYPE;    //PIC  X(01).
    //**     10 QBP511-ITEM-PROD-TYPE   PIC  X(01).
    //*                     B = BULK           F = POULTRY
    //*                     C = CIGARETTE      N = SNUFF
    //*                     D = CONTINUITY     S = STORE SUPPLY
    //*                     E = EGG            T = TOBACCO
    //**     10 QBP511-ITEM-SUB-PR-TYPE PIC  X(01).
    //**     10 QBP511-ITEM-CIG-CODE    PIC  X(04).
    private String l10_QBP511_ITEM_SECTION;         //PIC X(01).
    private String l10_QBP511_ITEM_BLL_NXT_AVL;     //PIC X(10).
    private String l10_QBP511_ITEM_PGM_CTRL_ID;     //PIC X(06).
    private String l10_QBP511_ITEM_RSTR_BUY_CD;     //PIC X(04).
    private String l10_QBP511_ITEM_SHP_DT;          //PIC 9(08).
    private String l10_QBP511_ITEM_SHP_TM;          //PIC X(08).
    private String l10_QBP511_ITEM_RLS_TM;          //PIC X(08).
    private String l10_QBP511_ITEM_FEE_GRP;         //PIC X(05).
    private String l10_QBP511_ITEM_SOURCE;           //PIC X.
    private String l10_QBP511_ITEM_SOLD_AT_COST;     //PIC X.
    private String l10_QBP511_ITEM_WILLCALL;         //PIC X.
    private String l10_QBP511_ITEM_HANDBILL;         //PIC X.
    private String l10_QBP511_ITEM_DIRECT_DLVRY;     //PIC X.
    private String l10_QBP511_ITEM_CMDTY;            //PIC X(03).
    private String l10_QBP511_ITEM_SUB_CMDTY;        //PIC X(03).
    private String l10_QBP511_ITEM_HAZ_IND;          //PIC X.
    private String l10_QBP511_ITEM_IVL_ORTP;         //PIC X.
    private String l10_QBP511_ITEM_SOT_AMT;          //PIC S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITEM_PALT;             //PIC X(30).                                     
    private String l10_QBP511_ITEM_BRAND;            //PIC X(20).                                     
    private String l10_QBP511_ITEM_PALT2;            //PIC X(30).                                     
    private String l10_FILLER;                       //PIC X(20).                                     
    private String l10_QBP511_ITEM_OASIS_CLASS;      //PIC X(01).
    private String l10_QBP511_ITEM_OASIS_FACILITY;   //PIC X(04).
    private String l10_QBP511_ITEM_RLS_DT;           //PIC 9(08).
    private String l10_QBP511_ITEM_PCT_MKUP;         //PIC 9(5)V9999 COMP-3.
    private String l10_QBP511_ITEM_ORIG_UPC;         //PIC S9(15) COMP-3.
    private String l10_QBP511_ITEM_ORIG_UPC_IND;     //PIC X(01).
    private String l10_QBP511_ITEM_ALTERNATE_VENDOR; //PIC X(07).
    private String l10_QBP511_ITEM_CALL_NBR;         //PIC X(04).
    private String l10_QBP511_ITEM_BIO_ENG;           //PIC X(01).
    //
    //******************************************************************
    //*      ITEX - ITEM EXCEPTION        - LEVEL 3                    *
    //* - ADDED QBP511-ITEX-PALT  FOR INV REDESIGN
    //* - ADDED QBP511-ITEX-PALT2 FOR INV REDESIGN
    //* - ADDED QBP511-ITEX-OASIS-CLASS FOR SOLO PROJECT     7/13/06
    //* - ADDED QBP511-ITEX-OASIS-FACILITY FOR SOLO PROJECT  7/13/06
    //* - INCREASED RECORD SIZE FROM 381 TO 386 FOR SOLO     7/13/06
    //* - REMOVED QBP511-ITEX-PROD-TYPE, QBP511-ITEX-SUB-PR-TYPE
    //*   AND QBP511-ITEX-CIG-CODE - NOT BEING USED.        11/15/06
    //* RLSDATE - ADDED RELEASE DATE FOR R101-BILLED-DT. CHG 386 TO 394
    //* 01/05/10  OMMEN     ADDED ORIG UPC TO ITEM AND ITEX
    //* 07/20/10  GARCIA    ADDED ORIG UPC IND, ALTERNATE-VENDOR AND
    //*                     QBP511-ITEX-MPCK TO ITEX ALONG WITH 76
    //*                     BYTES OF FILLER.
    //*********************************************************394BYTES*
    //01 QBP511-ITEX-DATA.
    //  05 QBP511-ITEX-FIELDS.
    private String l10_QBP511_ITEX_DEPT_BREAK;  //X(05).
    private String l10_QBP511_ITEX_EXCP_DESC;   //X(30).
    private String l10_QBP511_ITEX_SPCK;        //S9(07) COMP-3.
    private String l10_QBP511_ITEX_SIZE;        //X(15).
    private String l10_QBP511_ITEX_OQTY;        //S9(05) COMP-3.
    private String l10_QBP511_ITEX_AQTY;        //S9(05) COMP-3.
    private String l10_QBP511_ITEX_SQTY;        //S9(05) COMP-3.
    private String l10_QBP511_ITEX_IQTY;        //S9(05) COMP-3.
    private String l10_QBP511_ITEX_OADJ;        //S9(05) COMP-3.
    private String l10_QBP511_ITEX_BLL_NXT_AVL; //X(10).
    private String l10_QBP511_ITEX_DSDT;        //X(10).
    private String l10_QBP511_ITEX_SUBO;        //X(07).
    private String l10_QBP511_ITEX_INV_DEPT;    //X(02).
    private String l10_QBP511_ITEX_RTL_ZONE;    //X(04).
    private String l10_QBP511_ITEX_ORIG_ITEM;   //X(07).
    private String l10_QBP511_ITEX_CMP_ITEM;    //X(07).
    private String l10_QBP511_ITEX_SUBS;        //X(01).
    private String l10_QBP511_ITEX_DEFR_DT;     //9(08).
    private String l10_QBP511_ITEX_GR_NET_INV;  //X(01).
    private String l10_QBP511_ITEX_PLCD;        //X(01).
    private String l10_QBP511_ITEX_PLT_QTY;     //S9(05) COMP-3.
    private String l10_QBP511_ITEX_NBR_OF_PLTS; //S9(05) COMP-3.
    private String l10_QBP511_ITEX_CASE_QTY;    //S9(05) COMP-3.
    private String l10_QBP511_ITEX_DEAL_CNTR;   //S9(03) COMP-3.
    private String l10_QBP511_ITEX_SHP_CPO_FL;  //X(01).
    private String l10_QBP511_ITEX_BILL_AVG_FL; //X(01).
    private String l10_QBP511_ITEX_RWI;         //X(01).
    //        88 QBP511_ITEX_RND_WEIGHTED        VALUE 'C'.
    //        88 QBP511_ITEX_AVG_WEIGHTED        VALUE 'I'.
    private String l10_QBP511_ITEX_IWGT;        //S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEX_CWGT;        //S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEX_CUBE;        //S9(6)V9(3) COMP-3.
    private String l10_QBP511_ITEX_SCST;        //S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEX_RTL_CRET;    //S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITEX_RTL_CFOR;    //S9(3) COMP-3.
    private String l10_QBP511_ITEX_GINA;        //S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITEX_BSP_AMT;     //S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEX_INVV;        //S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITEX_EXT_COST;    //S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITEX_EXT_CATA;    //S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITEX_TAX_AMT;     //S9(7)V9(5) COMP-3.
    private String l10_QBP511_ITEX_DLVRY_PCT;   //S9(1)V9(4) COMP-3.
    private String l10_QBP511_ITEX_PROF_PCT;    //S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITEX_CSS_BUYR;    //X(03).
    private String l10_QBP511_ITEX_VEND;        //X(07).
    private String l10_QBP511_ITEX_WPHI;        //S9(3) COMP-3.
    private String l10_QBP511_ITEX_WPTI;        //S9(3) COMP-3.
    private String l10_QBP511_ITEX_INV_TYPE;    //X(01).
    private String l10_QBP511_ITEX_SECTION;     //X(01).
    private String l10_QBP511_ITEX_PGM_CTRL_ID; //X(06).
    private String l10_QBP511_ITEX_RSTR_BUY_CD; //X(04).
    private String l10_QBP511_ITEX_SHP_DT;      //9(08).
    private String l10_QBP511_ITEX_SHP_TM;      //X(08).
    private String l10_QBP511_ITEX_RLS_TM;      //X(08).
    private String l10_QBP511_ITEX_SOURCE;      //X.
    private String l10_QBP511_ITEX_SOLD_AT_COST; //X.
    private String l10_QBP511_ITEX_WILLCALL;    //X.
    private String l10_QBP511_ITEX_HANDBILL;    //X.
    private String l10_QBP511_ITEX_DIRECT_DLVRY; //X.
    private String l10_QBP511_ITEX_CMDTY;       //X(03).
    private String l10_QBP511_ITEX_SUB_CMDTY;   //X(03).
    private String l10_QBP511_ITEX_HAZ_IND;     //X.
    private String l10_QBP511_ITEX_IVL_ORTP;    //X.
    private String l10_QBP511_ITEX_SOT_AMT;     //S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITEX_PALT;        //X(30).                                         
    private String l10_QBP511_ITEX_BRAND;       //X(20).                                          
    private String l10_QBP511_ITEX_PALT2;       //X(30).                                         
    private String l10_QBP511_ITEX_FILLER1;                  //X(20).                                          
    private String l10_QBP511_ITEX_OASIS_CLASS; //X(01).
    private String l10_QBP511_ITEX_OASIS_FACILITY; //X(04).
    private String l10_QBP511_ITEX_RLS_DT;      //9(08).
    private String l10_QBP511_ITEX_ORIG_UPC;    //S9(15) COMP-3.
    private String l10_QBP511_ITEX_ORIG_UPC_IND; //X(01).
    private String l10_QBP511_ITEX_ALTERNATE_VENDOR; //X(07).
    private String l10_QBP511_ITEX_MPCK;        //S9(07) COMP-3.
    private String l10_QBP511_ITEX_CALL_NBR;    //X(04).
    private String l10_QBP511_ITEX_FILLER2;  //X(66).

    //
    //******************************************************************
    //*      ITOR - ORIGINAL OF SUB       - LEVEL 3                    *
    //*********************************************************140BYTES*
    //************************************************GW02493  144BYTES*
    //01 QBP511-ITOR-DATA.
    //  05 QBP511-ITOR-FIELDS.
    private String l10_QBP511_ITOR_ITEM;        //PIC  X(07).
    private String l10_QBP511_ITOR_DESC;       //PIC  X(50).
    private String l10_QBP511_ITOR_SUBO;        //PIC  X(07).
    private String l10_QBP511_ITOR_MPCK;        //PIC S9(07) COMP-3.
    private String l10_QBP511_ITOR_SIZE;        //PIC  X(15).
    private String l10_QBP511_ITOR_OQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITOR_AQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITOR_SQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITOR_IQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITOR_OADJ;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITOR_SCST;        //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITOR_RTL_CFOR;    //PIC S9(03) COMP-3.
    private String l10_QBP511_ITOR_RTL_CRET;    //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITOR_NDC_DESC;    //PIC  X(30).
    private String l10_QBP511_ITOR_NDCD;        //PIC  X(01).
    private String l10_QBP511_ITOR_SQNC_NBR;    //PIC S9(07) COMP-3.
    //
    //******************************************************************
    //*      ITAL - ITEM ALLOWANCES       - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************95BYTES*
    //***********************************************GW02493    99BYTES*
    //01 QBP511-ITAL-DATA.
    //  05 QBP511-ITAL-FIELDS.
    private String L10_QBP511_ITAL_AMOUNT;       //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITAL_PM_NET;       //PIC S9(5)V9(4) COMP-3.
    private String l10_QBP511_ITAL_DESC_SHORT;   //PIC  X(15).
    private String l10_QBP511_ITAL_DESC;         //PIC  X(30).
    private String l10_QBP511_ITAL_N_CST;        //PIC  X(01).
    private String l10_QBP511_ITAL_BUYER_ID;     //PIC  X(03).
    private String l10_QBP511_ITAL_DEAL_NBR;     //PIC  9(04)     COMP.
    private String l10_QBP511_ITAL_DEAL_TYPE;    //PIC  X(01).
    private String l10_QBP511_ITAL_TYPE_EXP;     //PIC  X(01).
    private String l10_QBP511_ITAL_PROMO_PGM;    //PIC  X(01).
    private String l10_QBP511_ITAL_DEAL_AMT;     //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITAL_START_DT;     //PIC  9(08).
    private String l10_QBP511_ITAL_END_DT;       //PIC  9(08).
    private String l10_QBP511_ITAL_EXT_ALWNC;    //PIC S9(8)V9(5) COMP-3.
    private String l10_QBP511_ITAL_PROMO_ID;     //PIC  X(04).
    private String l10_QBP511_ITAL_SQNC_NBR;     //PIC S9(07) COMP-3.
    private String l10_QBP511_ITAL_DEAL_CD;      //PIC  X(07).
    private String l10_QBP511_ITAL_VEND;         //PIC  X(07).                     
    private String l10_QBP511_ITAL_EXT_GRP_ID;   //PIC  X(20).                     
    private String l10_QBP511_ITAL_EXT_ARB_ID;   //PIC  X(20).                     
    private String l10_QBP511_ITAL_EXT_FEE_TYPE; //PIC X.                         
    private String l10_QBP511_ITAL_EXT_FEE_AMT;  //PIC S9(5)V9(2) COMP-3.   

    //  ******************************************************************
    //  *      IRBT - ITEM REBATES          - LEVEL 3                     
    //  *      ( ZERO TO MANY RECORDS PER ITEM )                          
    //  ******************************************************** 54 BYTES 
    //   01 QBP511-IRBT-DATA.                                             
    //      05 QBP511-IRBT-FIELDS.                                        
    private String l10_QBP511_IRBT_PROMO_ID;    //PIC  X(04).                     
    private String l10_QBP511_IRBT_DESC_SHORT;  //PIC  X(15).                     
    private String l10_QBP511_IRBT_DESC;        //PIC  X(30).                     
    private String l10_QBP511_IRBT_AMOUNT;      //PIC S9(4)V9(5) COMP-3.      
    //
    //******************************************************************
    //*      ITSC - SHIPPER COMPONENTS    - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //* - ADDED QBP511-ITSC-EXT-RTL-PRICE FOR INVOICE REDESIGN
    //**********************************************************70BYTES*
    //***********************************************GW02493    74BYTES*
    //01 QBP511-ITSC-DATA.
    //  05 QBP511-ITSC-FIELDS.
    private String l10_QBP511_ITSC_DESC;          //PIC  X(30).
    private String l10_QBP511_ITSC_SIZE;          //PIC  X(15).
    private String l10_QBP511_ITSC_QTY_UNT;       //PIC S9(07) COMP-3.
    private String l10_QBP511_ITSC_CST_UNT;       //PIC S9(6)V9(5) COMP-3.
    private String l10_QBP511_ITSC_RTL_MLT;       //PIC S9(03) COMP-3.
    private String l10_QBP511_ITSC_CPO_RTL;       //PIC S9(4)V9(3) COMP-3.
    private String l10_QBP511_ITSC_EXT_RTL_PRICE; //PIC S9(7)V9(4) COMP-3.
    private String l10_QBP511_ITSC_SOURCE;        //PIC  X(03).
    private String l10_QBP511_ITSC_SQNC_NBR;      //PIC S9(07) COMP-3.
    private String l10_QBP511_ITSC_BIO_ENG;       //PIC X(01).
    //
    //******************************************************************
    //*      ITWT - RANDOM WEIGHTS        - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************11BYTES*
    //***********************************************GW02493    15BYTES*
    //01 QBP511-ITWT-DATA.
    //  05 QBP511-ITWT-FIELDS.
    private String l10_QBP511_ITWT_IQTY;        //PIC S9(05) COMP-3.
    private String l10_QBP511_ITWT_IWGT;        //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITWT_SWGT;        //PIC S9(5)V9(2) COMP-3.
    private String l10_QBP511_ITWT_SQNC_NBR;    //PIC S9(07) COMP-3.

    //******************************************************************
    //*      ITND - NDC CODES             - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************57BYTES*
    //***********************************************GW02493    61BYTES*
    //01 QBP511-ITND-DATA.
    //  05 QBP511-ITND-FIELDS.
    private String l10_QBP511_ITND_CODE;        //PIC X(03).
    private String l10_QBP511_ITND_DESC;        //PIC X(30).
    private String l10_QBP511_ITND_DESC_SHORT;  //PIC X(15).
    private String l10_QBP511_ITND_ABBR;        //PIC X(04).
    private String l10_QBP511_ITND_RSTR_BUY_CD; //PIC X(04).
    private String l10_QBP511_ITND_INV_LOC;     //PIC X(01).
    private String l10_QBP511_ITND_SQNC_NBR;    //PIC S9(07) COMP-3.

    //******************************************************************
    //*      ITFE - ITEM FEES             - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************37BYTES*
    //***********************************************GW02493    41BYTES*
    //01 QBP511-ITFE-DATA.
    //  05 QBP511-ITFE-FIELDS.
    private String l10_QBP511_ITFE_FEE_AMT;     //PIC S9(7)V9(5) COMP-3.
    private String l10_QBP511_ITFE_FEE_PCT;     //PIC S9(7)V9(2) COMP-3.
    private String l10_QBP511_ITFE_FEE_DESC;    //PIC X(25).
    private String l10_QBP511_ITFE_SQNC_NBR;    //PIC S9(07) COMP-3.
    //
    //******************************************************************
    //*      ITTX - ITEM TAXES            - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************21BYTES*
    //***********************************************GW02493    25BYTES*
    //01 QBP511-ITTX-DATA.
    //  05 QBP511-ITTX-FIELDS.
    private String l10_QBP511_ITTX_AMOUNT;      //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITTX_TAX_EMBD;    //PIC X(01).
    private String l10_QBP511_ITTX_PERCENT;     //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITTX_PCNT_COST;   //PIC S9(4)V9(5) COMP-3.
    private String l10_QBP511_ITTX_PCNT_BASIS;  //PIC X(01).
    private String l10_QBP511_ITTX_STATE_LOC;   //PIC X(01).
    private String l10_QBP511_ITTX_COUNTY_LOC;  //PIC X(01).
    private String l10_QBP511_ITTX_CITY_LOC;    //PIC X(01).
    private String l10_QBP511_ITTX_OTHER_LOC;   //PIC X(01).
    private String l10_QBP511_ITTX_SQNC_NBR;    //PIC S9(07) COMP-3.
    //*

    public QBP511CC(String hexString, String charString) throws Exception {
        super();

        //System.out.println("charString len = " + charString.length()
        //        + " hexString len = " + hexString.length());

        this.fullHexString = hexString;
        this.fullCharString = charString;

        currentIndex = 0;

        //KNVC - INVOICE MASTER (LEVEL 1) KEY FIELDS - 50 bytes
        this.l10_QBP511_KNVC_IVNO = subString(charString, 7);
        this.l10_QBP511_KNVC_IVDT = subString(charString, 8);

        this.l10_QBP511_KNVC_FWHS = subString(charString, 4);
        this.l15_QBP511_KNVC_FACL = StringUtils.substring(l10_QBP511_KNVC_FWHS, 0, 2);
        this.l15_QBP511_KNVC_WHSE = StringUtils.substring(l10_QBP511_KNVC_FWHS, 2, 4);

        this.l10_QBP511_KNVC_STOR = subString(charString, 5);
        this.l10_QBP511_KNVC_TYPE = subString(charString, 2); //00 INVC, 20 ICNT, 60 IMFE, 65 IMTF, 80 IMLI, 85 IMLD, 99 INVT, HIGH VALUES
        this.l10_QBP511_KNVC_ROUT = subString(charString, 4);
        this.l10_QBP511_KNVC_STOP = subString(charString, 3);
        this.l10_QBP511_KNVC_DDAT = subString(charString, 8);
        this.l10_QBP511_KNVC_CPY_CD = subString(charString, 5);
        this.l10_QBP511_KNVC_ROUT_PRC_FL = subString(charString, 1);
        this.l10_QBP511_KNVC_CPY_SRT_BY = subString(charString, 3);

        //KNVB - INVOICE BREAKER (LEVEL 2) KEY FIELDS - 40 bytes
        this.l10_QBP511_KNVB_ORNO = subString(charString, 5);
        this.l10_QBP511_KNVB_INV_BREAK = subString(charString, 5);
        this.l10_QBP511_KNVB_WDPT = subString(charString, 2);
        this.l10_QBP511_KNVB_ORTP = subString(charString, 2);
        this.l10_QBP511_KNVB_TYPE = subString(charString, 2); //00 INVB, 60 IBFE, 99 IVBT
        this.l10_filler1 = subString(charString, 8);
        this.l10_QBP511_KNVB_ORD_CLASS = subString(charString, 1);
        this.l10_QBP511_KNVB_TEXT = subString(charString, 15);

        //KITM - INVOICE DETAIL/ITEM (LEVEL 3) KEY FIELDS - 138 bytes
        this.l10_QBP511_KITM_ITEM = subString(charString, 7);
        this.l10_QBP511_KITM_SUBN = subString(charString, 2);
        this.l10_QBP511_KITM_COMM = subString(charString, 5);
        this.l10_QBP511_KITM_SUBC = subString(charString, 5);

        this.l10_QBP511_KITM_PUPC = subString(charString, 15);
        this.l15_QBP511_KITM_UPC_PROD = StringUtils.substring(l10_QBP511_KITM_PUPC, 0, 1);
        this.l15_QBP511_KITM_UPC_MANF = StringUtils.substring(l10_QBP511_KITM_PUPC, 1, 6);
        this.l15_QBP511_KITM_UPC_VNDR_ITM = StringUtils.substring(l10_QBP511_KITM_PUPC, 6, 10);
        this.l15_QBP511_KITM_UPC_ITEM = StringUtils.substring(l10_QBP511_KITM_PUPC, 10, 15);

        this.l10_QBP511_KITM_SHP_FL = subString(charString, 1);
        this.l10_QBP511_KITM_ITEM_EX_CD = subString(charString, 1); //I ITEM, E EXCPT
        this.l10_QBP511_KITM_TYPE = subString(charString, 2); //00 ITEM, 10 ITOR, 20 ITAL, 22, IRTB 30 ITSC, 40 ITWT, 50 ITND, 60 ITFE, 70 ITTX, 99 IVBT
        this.l10_QBP511_KITM_RFRNC_CD = subString(charString, 50);
        this.l10_QBP511_KITM_SLOT = subString(charString, 6);
        this.l10_QBP511_KITM_DESC = subString(charString, 21);
        this.l10_QBP511_KITM_REF_DESC = subString(charString, 15);
        this.l10_QBP511_KITM_EX_NDC_CD = subString(charString, 1);
        this.l10_filler2 = subString(charString, 7);

        this.l10_QBP511_KSUB_KEY = subString(charString, 30);

        //KMFE - IVM FEE RECORD KEY
        this.l15_QBP511_KMFE_FEE_CODE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 5);
        this.l15_QBP511_KMFE_FEE_CUST = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 5, 10);
        //FILLER PIC X(20).

        //KMTF - TOTAL FEES RECORD KEY
        this.l15_QBP511_KMTF_FEE_CODE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 5);
        //FILLER PIC X(25);

        //KBFE - IVB FEE RECORD KEY
        this.l15_QBP511_KBFE_FEE_CODE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 5);
        this.l15_QBP511_KBFE_FEE_CUST = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 5, 10);
        //FILLER PIC X(20);

        //KTAL - ITEM ALLOWANCE RECORD KEY
        this.l15_QBP511_KTAL_ABBR = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 4);
        this.l15_QBP511_KTAL_TS = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 4, 30);

        //KTSC - SHIPPER COMPONENT RECORD KEY
        this.l15_QBP511_KTSC_CPO_UPC = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 15);
        this.l15_QBP511_KTSC_CPO_ITEM = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 15, 22);
        //FILLER PIC X(08)

        //KTWT - RANDOM WEIGHT RECORD KEY
        this.l15_QBP511_KTWT_SEQN = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 5);
        //FILLER PIC X(25)

        //KTND - NDC CODE RECORD KEY
        this.l15_QBP511_KTND_SEQN = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 4);
        //FILLER PIC X(26)

        //KTFE - ITEM FEE RECORD KEY
        this.l15_QBP511_KTFE_FEE_CODE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 5);
        this.l15_QBP511_KTFE_FEE_CUST = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 5, 10);
        //FILLER PIC X(20)

        //KTTX - ITEM TAX RECORD KEY
        this.l15_QBP511_KTTX_LOCATION = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 0, 6);
        this.l15_QBP511_KTTX_TAX_TYPE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 6, 9);
        this.l15_QBP511_KTTX_TAX_CODE = StringUtils.substring(this.l10_QBP511_KSUB_KEY, 9, 12);
        //FILLER PIC X(18)

        Integer hexIndex = currentIndex * 2;
        String hexValue = StringUtils.substring(hexString, hexIndex, hexIndex + 4);

        //l10_QBP511_DATA_LENGTH = Integer.parseInt(hexValue, 16);  I removed this line and replaced with next to eliminate the warning
        l10_QBP511_DATA_LENGTH = Integer.valueOf(hexValue, 16);

        currentIndex += 2;
        hexIndex += 4;

        String dataHex = StringUtils.substring(hexString, hexIndex);
        String dataChar = StringUtils.substring(charString, currentIndex);

        //System.out.println("Data Len = " + l10_QBP511_DATA_LENGTH
        //        + "  key = " + l10_QBP511_KNVC_TYPE + l10_QBP511_KNVB_TYPE + l10_QBP511_KITM_TYPE + l10_QBP511_KITM_ITEM_EX_CD);
        // System.out.println();
        if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "00")) {
            //00 INVC - INVOICE MASTER DATA								LEVEL 1	467 BYTES
            QBP511_INVC_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "20")) {
            //20 ICNT - CONTACTS FOR THE WAREHOUSE SHIP FROM ADDRESS	LEVEL 1 164 BYTES
            QBP511_ICNT_DATA(dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "60")) {
            //60 IMFE - INVOICE MASTER FEES								LEVEL 1  37 BYTES
            QBP511_IMFE_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "65")) {
            //65 IMTF - INVOICE TOTAL FEES								LEVEL 1  37 BYTES
            QBP511_IMTF_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "80")) {
            //80 IMLI - LICENSE NUMBERS									LEVEL 1 360 BYTES
            QBP511_IMLI_DATA(dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "85")) {
            //85 IMLD - LICENSE DESC									LEVEL 1 462 BYTES
            QBP511_IMLD_DATA(dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "99")) {
            //99 INVT - INVOICE TOTALS									LEVEL 1 193 BYTES
            QBP511_INVT_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVB_TYPE, "00")) {
            //00 INVB - INVOICE BREAKER                                 LEVEL 2 134 BYTES
            QBP511_INVB_DATA(dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVB_TYPE, "60")) {
            //60 IBFE - INVOICE BREAKER FEES                            LEVEL 2  37 BYTES
            QBP511_IBFE_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVB_TYPE, "99")) {
            //99 IVBT - INVOICE BREAK TOTALS                            LEVEL 2  58 BYTES     ?? LEVEL 2 134 BYTES
            QBP511_IVBT_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "00")
                && StringUtils.equalsIgnoreCase(l10_QBP511_KITM_ITEM_EX_CD, "I")) {
            //00 ITEM - INVOICE DETAIL                                  LEVEL3  478 BYTES
            QBP511_ITEM_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "00")
                && StringUtils.equalsIgnoreCase(l10_QBP511_KITM_ITEM_EX_CD, "E")) {
            //00 ITEX - ITEM EXCEPTION                                 LEVEL3  478 BYTES
            QBP511_ITEX_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "10")) {
            //10 ITOR - INVOICE DETAIL                                  LEVEL3  144 BYTES
            QBP511_ITOR_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "20")) {
            //20 ITAL - ITEM ALLOWANCES                                  LEVEL3  95 BYTES
            QBP511_ITAL_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "22")) {
            //22 IRTB - ITEM REBATES                                    LEVEL3 
            QBP511_IRTB_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "30")) {
            //30 ITSC - SHIPPER COMPONENTS                                LEVEL3  74 BYTES
            QBP511_ITSC_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "40")) {
            //40 ITWT - RANDOM WEIGHTS                                    LEVEL3  15 BYTES
            QBP511_ITWT_DATA(dataHex);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "50")) {
            //50 ITND - NDC CODES                                       LEVEL3  61 BYTES
            QBP511_ITND_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "60")) {
            //60 ITFE - NDC CODES                                       LEVEL3  41 BYTES
            QBP511_ITFE_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "70")) {
            //70 ITTX - ITEM TAXES                                       LEVEL3  25 BYTES
            QBP511_ITTX_DATA(dataHex, dataChar);
        } else {
            this.fullFileFieldList = FXCollections.observableArrayList();
            currentIndex = 1;
            this.fullLevelKey();
            this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));
            
            String frKey = "L? - unknown rec type";
            String frValue = this.frValueLevel1();
            
            this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);
        }

    }

    private void QBP511_INVC_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_INVC_DDAY = subString(dataChar, 1);	//PIC  9(01).
        this.l10_QBP511_INVC_BNAM = subString(dataChar, 30);	//PIC  X(30).
        this.l10_QBP511_INVC_BAD1 = subString(dataChar, 30);	//PIC  X(30).
        this.l10_QBP511_INVC_BAD2 = subString(dataChar, 30);	//PIC  X(30).
        this.l10_QBP511_INVC_BPHN = subString(dataChar, 20);	//PIC  X(20).
        this.l10_QBP511_INVC_GINA = subStringComp3(dataHex, 8, 10, 5); //PIC S9(10)V9(5) COMP-3.
        this.l10_QBP511_INVC_DIVISION = subString(dataChar, 2);	//PIC  X(02).                    
        this.l10_QBP511_INVC_SERV_FACL = subString(dataChar, 2);	//PIC  X(02).                    
        this.l10_QBP511_INVC_CIGSTAMP = subString(dataChar, 3);	//PIC  X(03).
        this.l10_QBP511_INVC_DFRD_INVC = subString(dataChar, 1);	//PIC  X(01).
        this.l10_QBP511_INVC_EQUITYNBR = subStringComp(dataHex, 2);	//PIC S9(04) COMP.
        this.l10_QBP511_INVC_RP_GROUP = subStringComp(dataHex, 2);	//PIC S9(04) COMP.
        this.l10_QBP511_INVC_VM_XDOCK_IND = subString(dataChar, 1);	//PIC X(01).
        this.l10_QBP511_INVC_NAME = subString(dataChar, 27);	//PIC  X(27).
        this.l10_QBP511_INVC_STORE_DEA_NBR = subString(dataChar, 10);  //PIC  X(10).
        this.l10_QBP511_INVC_ADDRESS = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_INVC_CITY = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_INVC_STATE = subString(dataChar, 2);	//PIC  X(02).
        this.l10_QBP511_INVC_ZIP_CODE = subString(dataChar, 9);	//PIC  X(09).
        this.l10_QBP511_INVC_FEE_GRP = subString(dataChar, 5);	//PIC  X(05).
        this.l10_QBP511_INVC_DEPT_DESC = subString(dataChar, 30);	//PIC  X(30).
        this.l10_QBP511_INVC_TIME = subString(dataChar, 8);	//PIC  X(08).
        this.l10_QBP511_INVC_DATA_CORP_NAME = subString(dataChar, 35);	//PIC  X(35).
        this.l10_QBP511_INVC_WHSE_DEA_NBR = subString(dataChar, 10);	//PIC  X(10).
        this.l10_QBP511_INVC_XDOCK_DEA_NBR = subString(dataChar, 10);	//PIC  X(10).
        this.l10_QBP511_INVC_XDOCK_ADDRESS = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_INVC_XDOCK_CITY = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_INVC_XDOCK_STATE = subString(dataChar, 2);	//PIC  X(02).
        this.l10_QBP511_INVC_XDOCK_ZIP_CODE = subString(dataChar, 9);	//PIC  X(09).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;

        this.fullLevelKey();

        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_DDAY", this.l10_QBP511_INVC_DDAY, 1, "9(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_BNAM", this.l10_QBP511_INVC_BNAM, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_BAD1", this.l10_QBP511_INVC_BAD1, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_BAD2", this.l10_QBP511_INVC_BAD2, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_BPHN", this.l10_QBP511_INVC_BPHN, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_GINA", this.l10_QBP511_INVC_GINA, 8, "S9(10)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_DIVISION", this.l10_QBP511_INVC_DIVISION, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_SERV_FACL", this.l10_QBP511_INVC_SERV_FACL, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_CIGSTAMP", this.l10_QBP511_INVC_CIGSTAMP, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_DFRD_INVC", this.l10_QBP511_INVC_DFRD_INVC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_EQUITYNBR", this.l10_QBP511_INVC_EQUITYNBR, 2, "S9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_RP_GROUP", this.l10_QBP511_INVC_RP_GROUP, 2, "S9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_VM_XDOCK_IND", this.l10_QBP511_INVC_VM_XDOCK_IND, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_NAME", this.l10_QBP511_INVC_NAME, 27, "X(27)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_STORE_DEA_NBR", this.l10_QBP511_INVC_STORE_DEA_NBR, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_ADDRESS", this.l10_QBP511_INVC_ADDRESS, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_CITY", this.l10_QBP511_INVC_CITY, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_STATE", this.l10_QBP511_INVC_STATE, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_ZIP_CODE", this.l10_QBP511_INVC_ZIP_CODE, 9, "X(09)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_FEE_GRP", this.l10_QBP511_INVC_FEE_GRP, 5, "X(05)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_DEPT_DESC", this.l10_QBP511_INVC_DEPT_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_TIME", this.l10_QBP511_INVC_TIME, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_DATA_CORP_NAME", this.l10_QBP511_INVC_DATA_CORP_NAME, 35, "X(35)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_WHSE_DEA_NBR", this.l10_QBP511_INVC_WHSE_DEA_NBR, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_XDOCK_DEA_NBR", this.l10_QBP511_INVC_XDOCK_DEA_NBR, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_XDOCK_ADDRESS", this.l10_QBP511_INVC_XDOCK_ADDRESS, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_XDOCK_CITY", this.l10_QBP511_INVC_XDOCK_CITY, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_XDOCK_STATE", this.l10_QBP511_INVC_XDOCK_STATE, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVC_XDOCK_ZIP_CODE", this.l10_QBP511_INVC_XDOCK_ZIP_CODE, 9, "X(09)"));

        String frKey = "L1 - 00 INVC - INVOICE MASTER";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ICNT_DATA(String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ICNT_CONTACT = subString(dataChar, 10);	//PIC  X(10).
        this.l10_QBP511_ICNT_ADDRESS = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_ICNT_CITY = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_ICNT_STATE = subString(dataChar, 2);    //PIC  X(02).
        this.l10_QBP511_ICNT_ZIP_CODE = subString(dataChar, 9); //PIC  X(09).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();

        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ICNT_CONTACT", this.l10_QBP511_ICNT_CONTACT, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ICNT_ADDRESS", this.l10_QBP511_ICNT_ADDRESS, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ICNT_CITY", this.l10_QBP511_ICNT_CITY, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ICNT_STATE", this.l10_QBP511_ICNT_STATE, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ICNT_ZIP_CODE", this.l10_QBP511_ICNT_ZIP_CODE, 9, "X(09)"));

        String frKey = "L1 - 20 ICNT - CONTACTS";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IMFE_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_IMFE_FEE_AMT = subStringComp3(dataHex, 7, 8, 5);	//PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IMFE_FEE_PCT = subStringComp3(dataHex, 5, 7, 2);	//PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_IMFE_FEE_DESC = subString(dataChar, 25);				//PIC  X(25).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        //this.fullFileFieldList.add(buildFileField("l15_QBP511_KMFE_FEE_CODE", this.l15_QBP511_KMFE_FEE_CODE, "X(05)", 0, 0));
        //this.fullFileFieldList.add(buildFileField("l15_QBP511_KMFE_FEE_CUST", this.l15_QBP511_KMFE_FEE_CUST, "X(05)", 0, 0));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMFE_FEE_AMT", this.l10_QBP511_IMFE_FEE_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMFE_FEE_PCT", this.l10_QBP511_IMFE_FEE_PCT, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMFE_FEE_DESC", this.l10_QBP511_IMFE_FEE_DESC, 25, "X(25)"));

        String frKey = "L1 - 60 IMFE - INVOICE MASTER FEES";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IMTF_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_IMTF_FEE_AMT = subStringComp3(dataHex, 7, 8, 5);	//PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IMTF_FEE_PCT = subStringComp3(dataHex, 5, 5, 4);	//PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_IMTF_FEE_DESC = subString(dataChar, 25);			//PIC  X(25).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        //fileFieldList.add(new FileField("l15_QBP511_KMTF_FEE_CODE", this.l15_QBP511_KMTF_FEE_CODE, "X(05)", 0, 0));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMTF_FEE_AMT", this.l10_QBP511_IMTF_FEE_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMTF_FEE_PCT", this.l10_QBP511_IMTF_FEE_PCT, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IMTF_FEE_DESC", this.l10_QBP511_IMTF_FEE_DESC, 25, "X(25)"));

        String frKey = "L1 - 65 IMTF - INVOICE TOTAL FEES";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IMLI_DATA(String dataChar) {

        currentIndex = 0;

        String l15_QBP511_IMLI_WHSE_LICENSE1 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE1 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE2 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE2 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE3 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE3 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE4 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE4 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE5 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE5 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE6 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE6 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE7 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE7 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE8 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE8 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE9 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE9 = subString(dataChar, 3);
        String l15_QBP511_IMLI_WHSE_LICENSE10 = subString(dataChar, 15);
        String l15_QBP511_IMLI_WHSE_LICENSE_TYPE10 = subString(dataChar, 3);

        String l15_QBP511_IMLI_STR_LICENSE1 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE1 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE2 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE2 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE3 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE3 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE4 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE4 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE5 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE5 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE6 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE6 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE7 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE7 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE8 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE8 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE9 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE9 = subString(dataChar, 3);
        String l15_QBP511_IMLI_STR_LICENSE10 = subString(dataChar, 15);
        String l15_QBP511_IMLI_STR_LICENSE_TYPE10 = subString(dataChar, 3);
        //******

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE1, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE1, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE2, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE2, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE3, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE3, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE4, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE4, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE5, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE5, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE6, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE6, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE7, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE7, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE8, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE8, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE9, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE9, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE", l15_QBP511_IMLI_WHSE_LICENSE10, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", l15_QBP511_IMLI_WHSE_LICENSE_TYPE10, 3, "X(03)"));

        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE1, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE1, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE2, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE2, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE3, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE3, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE4, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE4, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE5, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE5, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE6, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE6, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE7, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE7, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE8, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE8, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE9, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE9, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE", l15_QBP511_IMLI_STR_LICENSE10, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", l15_QBP511_IMLI_STR_LICENSE_TYPE10, 3, "X(03)"));

        String frKey = "L1 - 80 IMLI - LICENSE NUMBERS";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IMLD_DATA(String dataChar) {

        currentIndex = 0;

        String l15_QBP511_IMLD_LICENSE_TYPE_1 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_1 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_2 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_2 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_3 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_3 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_4 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_4 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_5 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_5 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_6 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_6 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_7 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_7 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_8 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_8 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_9 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_9 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_10 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_10 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_11 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_11 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_12 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_12 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_13 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_13 = subString(dataChar, 30);
        String l15_QBP511_IMLD_LICENSE_TYPE_14 = subString(dataChar, 3);
        String l15_QBP511_IMLD_LICENSE_DESC_14 = subString(dataChar, 30);

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_1", l15_QBP511_IMLD_LICENSE_TYPE_1, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_1", l15_QBP511_IMLD_LICENSE_DESC_1, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_2", l15_QBP511_IMLD_LICENSE_TYPE_2, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_2", l15_QBP511_IMLD_LICENSE_DESC_2, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_3", l15_QBP511_IMLD_LICENSE_TYPE_3, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_3", l15_QBP511_IMLD_LICENSE_DESC_3, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_4", l15_QBP511_IMLD_LICENSE_TYPE_4, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_4", l15_QBP511_IMLD_LICENSE_DESC_4, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_5", l15_QBP511_IMLD_LICENSE_TYPE_5, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_5", l15_QBP511_IMLD_LICENSE_DESC_5, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_6", l15_QBP511_IMLD_LICENSE_TYPE_6, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_6", l15_QBP511_IMLD_LICENSE_DESC_6, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_7", l15_QBP511_IMLD_LICENSE_TYPE_7, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_7", l15_QBP511_IMLD_LICENSE_DESC_7, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_8", l15_QBP511_IMLD_LICENSE_TYPE_8, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_8", l15_QBP511_IMLD_LICENSE_DESC_8, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_9", l15_QBP511_IMLD_LICENSE_TYPE_9, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_9", l15_QBP511_IMLD_LICENSE_DESC_9, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_10", l15_QBP511_IMLD_LICENSE_TYPE_10, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_10", l15_QBP511_IMLD_LICENSE_DESC_10, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_11", l15_QBP511_IMLD_LICENSE_TYPE_11, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_11", l15_QBP511_IMLD_LICENSE_DESC_11, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_12", l15_QBP511_IMLD_LICENSE_TYPE_12, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_12", l15_QBP511_IMLD_LICENSE_DESC_12, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_13", l15_QBP511_IMLD_LICENSE_TYPE_13, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_13", l15_QBP511_IMLD_LICENSE_DESC_13, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_TYPE_14", l15_QBP511_IMLD_LICENSE_TYPE_14, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_IMLD_LICENSE_DESC_14", l15_QBP511_IMLD_LICENSE_DESC_14, 30, "X(30)"));

        String frKey = "L1 - 85 IMLD - LICENSE DESC";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_INVT_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_INVT_ENDING_INVC_NO = subStringComp3(dataHex, 4, 7, 0);	//PIC S9(7) COMP-3.
        this.l10_QBP511_INVT_BREAKER = subString(dataChar, 3);				//PIC 9(03).
        this.l10_QBP511_INVT_STMNT_DT = subString(dataChar, 8);				//PIC  9(8).
        this.l10_QBP511_INVT_WEIGHT = subStringComp3(dataHex, 4, 5, 2);	//PIC S9(5)V99 COMP-3.
        this.l10_QBP511_INVT_CUBE = subStringComp3(dataHex, 4, 6, 1);	//PIC S9(6)V9  COMP-3.
        this.l10_QBP511_INVT_PALLET = subStringComp3(dataHex, 2, 3, 0);	//PIC S9(3)    COMP-3.
        this.l10_QBP511_INVT_PIECES = subStringComp3(dataHex, 3, 5, 0);	//PIC S9(5)    COMP-3.
        this.l10_QBP511_INVT_ORDERED = subStringComp3(dataHex, 3, 5, 0);	//PIC S9(5)    COMP-3.
        this.l10_QBP511_INVT_SHIPPED = subStringComp3(dataHex, 3, 5, 0);	//PIC S9(5)    COMP-3.
        this.l10_QBP511_INVT_CIG_PIECES = subStringComp3(dataHex, 5, 9, 0);	//PIC S9(9)    COMP-3.
        this.l10_QBP511_INVT_MEAT = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_GROCERY = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_FROZEN_FOOD = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_STORE_SUPPLY = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_STRE_SUPP_TAX = subStringComp3(dataHex, 4, 5, 2);	//PIC S9(5)V99 COMP-3.
        this.l10_QBP511_INVT_STRE_SUPP_ATCOST = subStringComp3(dataHex, 4, 5, 2);	//PIC S9(5)V99 COMP-3.
        this.l10_QBP511_INVT_GROSS_PROFITS = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_SELL = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_COST = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_RETAIL = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_PROD_COST = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_RTL_PRICE = subStringComp3(dataHex, 7, 11, 2);	//PIC S9(11)V99 COMP-3.
        this.l10_QBP511_INVT_N_ALLOW = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_REG_PROMO = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_REG_FRZ_PROMO = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_PERF_ALLOW = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_OTHER_ALLOW = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_FEES = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_DLV_FEES = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_HANDBILL_FEES = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_OTHER_FEES = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_PALLET_ALLOW = subStringComp3(dataHex, 6, 9, 2);	//PIC S9(9)V99 COMP-3.
        this.l10_QBP511_INVT_TOBACCO_TAX = subStringComp3(dataHex, 5, 7, 2);	//PIC S9(7)V99 COMP-3.
        this.l10_QBP511_INVT_TOBACCO_SALES = subStringComp3(dataHex, 5, 7, 2);	//PIC S9(7)V99 COMP-3.
        this.l10_QBP511_INVT_OASIS_CLASS = subString(dataChar, 1);				//PIC X(01).
        this.l10_QBP511_INVT_OASIS_FACILITY = subString(dataChar, 4);				//PIC X(04).
        this.l10_QBP511_INVT_DEFERED_INDC = subString(dataChar, 1);				//PIC X.
        this.l10_QBP511_INVT_DIR_DELV_IND = subString(dataChar, 1);				//PIC X.
        this.l10_QBP511_INVT_EFF_REBATE = subStringComp3(dataHex, 7, 8, 5);      //PIC S9(8)V9(5) COMP-3.  

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_ENDING_INVC_NO", this.l10_QBP511_INVT_ENDING_INVC_NO, 4, "S9(7) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_BREAKER", this.l10_QBP511_INVT_BREAKER, 3, "9(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_STMNT_DT", this.l10_QBP511_INVT_STMNT_DT, 8, " 9(8)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_WEIGHT", this.l10_QBP511_INVT_WEIGHT, 4, "S9(5)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_CUBE", this.l10_QBP511_INVT_CUBE, 4, "S9(6)V9  COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_PALLET", this.l10_QBP511_INVT_PALLET, 2, "S9(3)    COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_PIECES", this.l10_QBP511_INVT_PIECES, 3, "S9(5)    COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_ORDERED", this.l10_QBP511_INVT_ORDERED, 3, "S9(5)    COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_SHIPPED", this.l10_QBP511_INVT_SHIPPED, 3, "S9(5)    COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_CIG_PIECES", this.l10_QBP511_INVT_CIG_PIECES, 5, "S9(9)    COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_MEAT", this.l10_QBP511_INVT_MEAT, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_GROCERY", this.l10_QBP511_INVT_GROCERY, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_FROZEN_FOOD", this.l10_QBP511_INVT_FROZEN_FOOD, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_STORE_SUPPLY", this.l10_QBP511_INVT_STORE_SUPPLY, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_STRE_SUPP_TAX", this.l10_QBP511_INVT_STRE_SUPP_TAX, 4, "S9(5)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_STRE_SUPP_ATCOST", this.l10_QBP511_INVT_STRE_SUPP_ATCOST, 4, "S9(5)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_GROSS_PROFITS", this.l10_QBP511_INVT_GROSS_PROFITS, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_SELL", this.l10_QBP511_INVT_SELL, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_COST", this.l10_QBP511_INVT_COST, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_RETAIL", this.l10_QBP511_INVT_RETAIL, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_PROD_COST", this.l10_QBP511_INVT_PROD_COST, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_RTL_PRICE", this.l10_QBP511_INVT_RTL_PRICE, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_N_ALLOW", this.l10_QBP511_INVT_N_ALLOW, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_REG_PROMO", this.l10_QBP511_INVT_REG_PROMO, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_REG_FRZ_PROMO", this.l10_QBP511_INVT_REG_FRZ_PROMO, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_PERF_ALLOW", this.l10_QBP511_INVT_PERF_ALLOW, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_OTHER_ALLOW", this.l10_QBP511_INVT_OTHER_ALLOW, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_FEES", this.l10_QBP511_INVT_FEES, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_DLV_FEES", this.l10_QBP511_INVT_DLV_FEES, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_HANDBILL_FEES", this.l10_QBP511_INVT_HANDBILL_FEES, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_OTHER_FEES", this.l10_QBP511_INVT_OTHER_FEES, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_PALLET_ALLOW", this.l10_QBP511_INVT_PALLET_ALLOW, 6, "S9(9)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_TOBACCO_TAX", this.l10_QBP511_INVT_TOBACCO_TAX, 5, "S9(7)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_TOBACCO_SALES", this.l10_QBP511_INVT_TOBACCO_SALES, 5, "S9(7)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_OASIS_CLASS", this.l10_QBP511_INVT_OASIS_CLASS, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_OASIS_FACILITY", this.l10_QBP511_INVT_OASIS_FACILITY, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_DEFERED_INDC", this.l10_QBP511_INVT_DEFERED_INDC, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_DIR_DELV_IND", this.l10_QBP511_INVT_DIR_DELV_IND, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVT_EFF_REBATE", this.l10_QBP511_INVT_EFF_REBATE, 7, "S9(8)V9(5) COMP-3"));

        String frKey = "L1 - 99 INVT - INVOICE TOTALS";
        String frValue = this.frValueLevel1();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);
    }

    private void QBP511_INVB_DATA(String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_INVB_DDAT = subString(dataChar, 8);   //PIC  9(08).
        this.l10_QBP511_INVB_DDAY = subString(dataChar, 1);   //PIC  9(01).
        this.l10_QBP511_INVB_ROUT = subString(dataChar, 4);   //PIC  X(04).
        this.l10_QBP511_INVB_STOP = subString(dataChar, 3);   //PIC  X(03).
        this.l10_QBP511_INVB_SHP_DT = subString(dataChar, 8);   //PIC  9(08).
        this.l10_QBP511_INVB_SHP_TM = subString(dataChar, 8);   //PIC  X(08).
        this.l10_QBP511_INVB_RLS_TM = subString(dataChar, 8);   //PIC  X(08).
        this.l10_QBP511_INVB_ORTP_DESC = subString(dataChar, 45);  //PIC  X(45).
        this.l10_QBP511_INVB_FEE_GRP = subString(dataChar, 5);   //PIC  X(05).
        this.l10_QBP511_INVB_SOURCE = subString(dataChar, 1);   //PIC  X.
        this.l10_QBP511_INVB_SOLD_AT_COST = subString(dataChar, 1);   //PIC  X.
        this.l10_QBP511_INVB_WILLCALL = subString(dataChar, 1);   //PIC  X.
        this.l10_QBP511_INVB_HANDBILL = subString(dataChar, 1);   //PIC  X.
        this.l10_QBP511_INVB_DIRECT_DLVRY = subString(dataChar, 1);   //PIC  X.
        this.l10_QBP511_INVB_DEPT_DESC = subString(dataChar, 30);  //PIC  X(30).
        this.l10_QBP511_INVB_RLS_DT = subString(dataChar, 8);   //PIC  9(08).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_DDAT", this.l10_QBP511_INVB_DDAT, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_DDAY", this.l10_QBP511_INVB_DDAY, 1, "9(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_ROUT", this.l10_QBP511_INVB_ROUT, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_STOP", this.l10_QBP511_INVB_STOP, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_SHP_DT", this.l10_QBP511_INVB_SHP_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_SHP_TM", this.l10_QBP511_INVB_SHP_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_RLS_TM", this.l10_QBP511_INVB_RLS_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_ORTP_DESC", this.l10_QBP511_INVB_ORTP_DESC, 45, "X(45)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_FEE_GRP", this.l10_QBP511_INVB_FEE_GRP, 5, "X(05)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_SOURCE", this.l10_QBP511_INVB_SOURCE, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_SOLD_AT_COST", this.l10_QBP511_INVB_SOLD_AT_COST, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_WILLCALL", this.l10_QBP511_INVB_WILLCALL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_HANDBILL", this.l10_QBP511_INVB_HANDBILL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_DIRECT_DLVRY", this.l10_QBP511_INVB_DIRECT_DLVRY, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_DEPT_DESC", this.l10_QBP511_INVB_DEPT_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_INVB_RLS_DT", this.l10_QBP511_INVB_RLS_DT, 8, "9(08)"));

        String frKey = "L2 - 00 INVB - INVOICE BREAKER";
        String frValue = this.frValueLevel2();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IBFE_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_IBFE_FEE_AMT = subStringComp3(dataHex, 7, 7, 5);  //PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IBFE_FEE_PCT = subStringComp3(dataHex, 5, 7, 2);  //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_IBFE_FEE_DESC = subString(dataChar, 25);           //PIC  X(25).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_AMT", this.l10_QBP511_IBFE_FEE_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_PCT", this.l10_QBP511_IBFE_FEE_PCT, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_DESC", this.l10_QBP511_IBFE_FEE_DESC, 25, "X(25)"));

        String frKey = "L2 - 60 IBFE - INVOICE BREAKER FEES";
        String frValue = this.frValueLevel2();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);
    }

    private void QBP511_IVBT_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_IVBT_DEPT_DESC = subString(dataChar, 30);            //PIC X(30).
        this.l10_QBP511_IVBT_ORDERED = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_SHIPPED = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_NET = subStringComp3(dataHex, 7, 11, 2);  //PIC S9(11)V99 COMP-3.
        this.l10_QBP511_IVBT_RTL = subStringComp3(dataHex, 7, 11, 2);  //PIC S9(11)V99 COMP-3.
        this.l10_QBP511_IVBT_TO_WHS = subStringComp3(dataHex, 3, 5, 0);  //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_GROSS_PCT = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_DEPT_DESC", this.l10_QBP511_IVBT_DEPT_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_ORDERED", this.l10_QBP511_IVBT_ORDERED, 3, "S9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_SHIPPED", this.l10_QBP511_IVBT_SHIPPED, 3, "S9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_NET", this.l10_QBP511_IVBT_NET, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_RTL", this.l10_QBP511_IVBT_RTL, 7, "S9(11)V99 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_TO_WHS", this.l10_QBP511_IVBT_TO_WHS, 3, "S9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IVBT_GROSS_PCT", this.l10_QBP511_IVBT_GROSS_PCT, 5, "S9(5)V9(4) COMP-3"));

        String frKey = "L2 - 99 IVBT - INVOICE BREAK TOTALS";
        String frValue = this.frValueLevel2();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);
    }

    private void QBP511_ITEM_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITEM_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0);   //PIC S9(07) COMP-3.
        this.l10_QBP511_ITEM_DEP_BREAK = subString(dataChar, 5);             //PIC  X(05).
        this.l10_QBP511_ITEM_INV_DEPT = subString(dataChar, 2);             //PIC  X(02).
        this.l10_QBP511_ITEM_RTL_ZONE = subString(dataChar, 4);             //PIC  X(04).
        this.l10_QBP511_ITEM_CNTRY_ORG = subString(dataChar, 30);            //PIC  X(30).
        this.l10_QBP511_ITEM_ORIG_ITEM = subString(dataChar, 7);             //PIC  X(07).
        this.l10_QBP511_ITEM_CMP_ITEM = subString(dataChar, 7);             //PIC  X(07).
        this.l10_QBP511_ITEM_SUBO = subString(dataChar, 7);             //PIC  X(07).
        this.l10_QBP511_ITEM_SUBS = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITEM_DEFR_DT = subString(dataChar, 8);             //PIC  9(08).
        this.l10_QBP511_ITEM_GR_NET_INV = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITEM_PLCD = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITEM_MPCK = subStringComp3(dataHex, 4, 7, 0);   //PIC S9(07) COMP-3.
        this.l10_QBP511_ITEM_SPCK = subStringComp3(dataHex, 4, 7, 0);   //PIC S9(07) COMP-3.
        this.l10_QBP511_ITEM_SIZE = subString(dataChar, 15);            //PIC  X(15).
        this.l10_QBP511_ITEM_OQTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_AQTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_SQTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_IQTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_OADJ = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_PLT_QTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_NBR_OF_PLTS = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_CASE_QTY = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(05) COMP-3.
        this.l10_QBP511_ITEM_DEAL_CNTR = subStringComp3(dataHex, 2, 3, 0);   //PIC S9(03) COMP-3.
        this.l10_QBP511_ITEM_SHP_CPO_FL = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITEM_BILL_AVG_FL = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITEM_RWI = subString(dataChar, 1);             //PIC  X(01).
        //        88 QBP511_ITEM_RND_WEIGHTED        VALUE 'C'.                
        //        88 QBP511_ITEM_AVG_WEIGHTED        VALUE 'I'.                 
        this.l10_QBP511_ITEM_IWGT = subStringComp3(dataHex, 4, 5, 2);   //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEM_CWGT = subStringComp3(dataHex, 4, 5, 2);   //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEM_CUBE = subStringComp3(dataHex, 5, 6, 3);   //PIC S9(6)V9(3) COMP-3.
        this.l10_QBP511_ITEM_SCST = subStringComp3(dataHex, 5, 4, 5);   //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEM_NET_SELL = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITEM_UNT_NET_SELL = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITEM_RTL_CRET = subStringComp3(dataHex, 4, 5, 2);   //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEM_RTL_PRICE = subStringComp3(dataHex, 5, 7, 2);   //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITEM_EXT_RTL_PRICE = subStringComp3(dataHex, 6, 7, 4);   //PIC S9(7)V9(4) COMP-3.
        this.l10_QBP511_ITEM_RTL_CFOR = subStringComp3(dataHex, 2, 3, 0);   //PIC S9(3) COMP-3.
        this.l10_QBP511_ITEM_GINA = subStringComp3(dataHex, 6, 6, 5);   //PIC S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITEM_BSP_AMT = subStringComp3(dataHex, 5, 4, 5);   //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEM_INVV = subStringComp3(dataHex, 5, 4, 5);   //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEM_IDIS = subStringComp3(dataHex, 5, 4, 5);   //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEM_EXT_COST = subStringComp3(dataHex, 5, 7, 2);   //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITEM_EXT_CATA = subStringComp3(dataHex, 5, 7, 2);   //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITEM_EXT_NET_SELL = subStringComp3(dataHex, 6, 7, 4);   //PIC S9(7)V9(4) COMP-3.
        this.l10_QBP511_ITEM_FEES_AMT = subStringComp3(dataHex, 7, 8, 5);   //PIC S9(8)V9(5) COMP-3.
        this.l10_QBP511_ITEM_ALWNC_AMT = subStringComp3(dataHex, 6, 6, 5);   //PIC S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITEM_TAX_AMT = subStringComp3(dataHex, 7, 7, 5);   //PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_ITEM_DLVRY_PCT = subStringComp3(dataHex, 3, 1, 4);   //PIC S9(1)V9(4) COMP-3.
        this.l10_QBP511_ITEM_PROF_PCT = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITEM_GROSS_PCT = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITEM_DSDT = subString(dataChar, 8);             //PIC  9(8).
        this.l10_QBP511_ITEM_BUYR = subString(dataChar, 3);             //PIC  X(03).
        this.l10_QBP511_ITEM_CSS_BUYR = subString(dataChar, 3);             //PIC  X(03).
        this.l10_QBP511_ITEM_VEND = subString(dataChar, 7);             //PIC  X(07).
        this.l10_QBP511_ITEM_WPHI = subStringComp3(dataHex, 2, 3, 0);   //PIC S9(3) COMP-3.
        this.l10_QBP511_ITEM_WPTI = subStringComp3(dataHex, 2, 3, 0);   //PIC S9(3) COMP-3.
        this.l10_QBP511_ITEM_INV_TYPE = subString(dataChar, 1);             //PIC  X(01).
        //**     10 QBP511-ITEM-PROD-TYPE   PIC  X(01).
        //*                     B = BULK           F = POULTRY
        //*                     C = CIGARETTE      N = SNUFF
        //*                     D = CONTINUITY     S = STORE SUPPLY
        //*                     E = EGG            T = TOBACCO
        //**     10 QBP511-ITEM-SUB-PR-TYPE PIC  X(01).
        //**     10 QBP511-ITEM-CIG-CODE    PIC  X(04).
        this.l10_QBP511_ITEM_SECTION = subString(dataChar, 1);            //PIC X(01).
        this.l10_QBP511_ITEM_BLL_NXT_AVL = subString(dataChar, 10);           //PIC X(10).
        this.l10_QBP511_ITEM_PGM_CTRL_ID = subString(dataChar, 6);            //PIC X(06).
        this.l10_QBP511_ITEM_RSTR_BUY_CD = subString(dataChar, 4);            //PIC X(04).
        this.l10_QBP511_ITEM_SHP_DT = subString(dataChar, 8);            //PIC 9(08).
        this.l10_QBP511_ITEM_SHP_TM = subString(dataChar, 8);            //PIC X(08).
        this.l10_QBP511_ITEM_RLS_TM = subString(dataChar, 8);            //PIC X(08).
        this.l10_QBP511_ITEM_FEE_GRP = subString(dataChar, 5);            //PIC X(05).
        this.l10_QBP511_ITEM_SOURCE = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_SOLD_AT_COST = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_WILLCALL = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_HANDBILL = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_DIRECT_DLVRY = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_CMDTY = subString(dataChar, 3);            //PIC X(03).
        this.l10_QBP511_ITEM_SUB_CMDTY = subString(dataChar, 3);            //PIC X(03).
        this.l10_QBP511_ITEM_HAZ_IND = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_IVL_ORTP = subString(dataChar, 1);            //PIC X.
        this.l10_QBP511_ITEM_SOT_AMT = subStringComp3(dataHex, 6, 6, 5);  //PIC S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITEM_PALT = subString(dataChar, 30);           //PIC X(30).                                     
        this.l10_QBP511_ITEM_BRAND = subString(dataChar, 20);           //PIC X(20).                                     
        this.l10_QBP511_ITEM_PALT2 = subString(dataChar, 30);           //PIC X(30).                                     
        this.l10_FILLER = subString(dataChar, 20);           //PIC X(20).                                     
        this.l10_QBP511_ITEM_OASIS_CLASS = subString(dataChar, 1);            //PIC X(01).
        this.l10_QBP511_ITEM_OASIS_FACILITY = subString(dataChar, 4);            //PIC X(04).
        this.l10_QBP511_ITEM_RLS_DT = subString(dataChar, 8);            //PIC 9(08).
        this.l10_QBP511_ITEM_PCT_MKUP = subStringComp3(dataHex, 5, 5, 4);  //PIC 9(5)V9999 COMP-3.
        this.l10_QBP511_ITEM_ORIG_UPC = subStringComp3(dataHex, 8, 15, 0); //PIC S9(15) COMP-3.
        this.l10_QBP511_ITEM_ORIG_UPC_IND = subString(dataChar, 1);            //PIC X(01).
        this.l10_QBP511_ITEM_ALTERNATE_VENDOR = subString(dataChar, 7);            //PIC X(07).
        this.l10_QBP511_ITEM_CALL_NBR = subString(dataChar, 4);            //PIC X(04).
        this.l10_QBP511_ITEM_BIO_ENG = subString(dataChar, 1);            //PIC X(01).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SQNC_NBR", this.l10_QBP511_ITEM_SQNC_NBR, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DEP_BREAK", this.l10_QBP511_ITEM_DEP_BREAK, 5, " X(05)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_INV_DEPT", this.l10_QBP511_ITEM_INV_DEPT, 2, " X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_ZONE", this.l10_QBP511_ITEM_RTL_ZONE, 4, " X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CNTRY_ORG", this.l10_QBP511_ITEM_CNTRY_ORG, 30, " X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_ITEM", this.l10_QBP511_ITEM_ORIG_ITEM, 7, " X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CMP_ITEM", this.l10_QBP511_ITEM_CMP_ITEM, 7, " X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SUBO", this.l10_QBP511_ITEM_SUBO, 7, " X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SUBS", this.l10_QBP511_ITEM_SUBS, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DEFR_DT", this.l10_QBP511_ITEM_DEFR_DT, 8, " 9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_GR_NET_INV", this.l10_QBP511_ITEM_GR_NET_INV, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PLCD", this.l10_QBP511_ITEM_PLCD, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_MPCK", this.l10_QBP511_ITEM_MPCK, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SPCK", this.l10_QBP511_ITEM_SPCK, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SIZE", this.l10_QBP511_ITEM_SIZE, 15, " X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_OQTY", this.l10_QBP511_ITEM_OQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_AQTY", this.l10_QBP511_ITEM_AQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SQTY", this.l10_QBP511_ITEM_SQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_IQTY", this.l10_QBP511_ITEM_IQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_OADJ", this.l10_QBP511_ITEM_OADJ, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PLT_QTY", this.l10_QBP511_ITEM_PLT_QTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_NBR_OF_PLTS", this.l10_QBP511_ITEM_NBR_OF_PLTS, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CASE_QTY", this.l10_QBP511_ITEM_CASE_QTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DEAL_CNTR", this.l10_QBP511_ITEM_DEAL_CNTR, 2, "S9(03) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_CPO_FL", this.l10_QBP511_ITEM_SHP_CPO_FL, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BILL_AVG_FL", this.l10_QBP511_ITEM_BILL_AVG_FL, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RWI", this.l10_QBP511_ITEM_RWI, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_IWGT", this.l10_QBP511_ITEM_IWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CWGT", this.l10_QBP511_ITEM_CWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CUBE", this.l10_QBP511_ITEM_CUBE, 5, "S9(6)V9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SCST", this.l10_QBP511_ITEM_SCST, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_NET_SELL", this.l10_QBP511_ITEM_NET_SELL, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_UNT_NET_SELL", this.l10_QBP511_ITEM_UNT_NET_SELL, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_CRET", this.l10_QBP511_ITEM_RTL_CRET, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_PRICE", this.l10_QBP511_ITEM_RTL_PRICE, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_RTL_PRICE", this.l10_QBP511_ITEM_EXT_RTL_PRICE, 6, "S9(7)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_CFOR", this.l10_QBP511_ITEM_RTL_CFOR, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_GINA", this.l10_QBP511_ITEM_GINA, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BSP_AMT", this.l10_QBP511_ITEM_BSP_AMT, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_INVV", this.l10_QBP511_ITEM_INVV, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_IDIS", this.l10_QBP511_ITEM_IDIS, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_COST", this.l10_QBP511_ITEM_EXT_COST, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_CATA", this.l10_QBP511_ITEM_EXT_CATA, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_NET_SELL", this.l10_QBP511_ITEM_EXT_NET_SELL, 6, "S9(7)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_FEES_AMT", this.l10_QBP511_ITEM_FEES_AMT, 7, "S9(8)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_ALWNC_AMT", this.l10_QBP511_ITEM_ALWNC_AMT, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_TAX_AMT", this.l10_QBP511_ITEM_TAX_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DLVRY_PCT", this.l10_QBP511_ITEM_DLVRY_PCT, 3, "S9(1)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PROF_PCT", this.l10_QBP511_ITEM_PROF_PCT, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_GROSS_PCT", this.l10_QBP511_ITEM_GROSS_PCT, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DSDT", this.l10_QBP511_ITEM_DSDT, 8, " 9(8)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BUYR", this.l10_QBP511_ITEM_BUYR, 3, " X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CSS_BUYR", this.l10_QBP511_ITEM_CSS_BUYR, 3, " X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_VEND", this.l10_QBP511_ITEM_VEND, 7, " X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_WPHI", this.l10_QBP511_ITEM_WPHI, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_WPTI", this.l10_QBP511_ITEM_WPTI, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_INV_TYPE", this.l10_QBP511_ITEM_INV_TYPE, 1, " X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SECTION", this.l10_QBP511_ITEM_SECTION, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BLL_NXT_AVL", this.l10_QBP511_ITEM_BLL_NXT_AVL, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PGM_CTRL_ID", this.l10_QBP511_ITEM_PGM_CTRL_ID, 6, "X(06)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RSTR_BUY_CD", this.l10_QBP511_ITEM_RSTR_BUY_CD, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_DT", this.l10_QBP511_ITEM_SHP_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_TM", this.l10_QBP511_ITEM_SHP_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RLS_TM", this.l10_QBP511_ITEM_RLS_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_FEE_GRP", this.l10_QBP511_ITEM_FEE_GRP, 5, "X(05)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SOURCE", this.l10_QBP511_ITEM_SOURCE, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SOLD_AT_COST", this.l10_QBP511_ITEM_SOLD_AT_COST, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_WILLCALL", this.l10_QBP511_ITEM_WILLCALL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_HANDBILL", this.l10_QBP511_ITEM_HANDBILL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_DIRECT_DLVRY", this.l10_QBP511_ITEM_DIRECT_DLVRY, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CMDTY", this.l10_QBP511_ITEM_CMDTY, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SUB_CMDTY", this.l10_QBP511_ITEM_SUB_CMDTY, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_HAZ_IND", this.l10_QBP511_ITEM_HAZ_IND, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_IVL_ORTP", this.l10_QBP511_ITEM_IVL_ORTP, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_SOT_AMT", this.l10_QBP511_ITEM_SOT_AMT, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PALT", this.l10_QBP511_ITEM_PALT, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BRAND", this.l10_QBP511_ITEM_BRAND, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PALT2", this.l10_QBP511_ITEM_PALT2, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_FILLER", this.l10_FILLER, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_OASIS_CLASS", this.l10_QBP511_ITEM_OASIS_CLASS, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_OASIS_FACILITY", this.l10_QBP511_ITEM_OASIS_FACILITY, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_RLS_DT", this.l10_QBP511_ITEM_RLS_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_PCT_MKUP", this.l10_QBP511_ITEM_PCT_MKUP, 5, "9(5)V9999 COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_UPC", this.l10_QBP511_ITEM_ORIG_UPC, 8, "S9(15) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_UPC_IND", this.l10_QBP511_ITEM_ORIG_UPC_IND, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_ALTERNATE_VENDOR", this.l10_QBP511_ITEM_ALTERNATE_VENDOR, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_CALL_NBR", this.l10_QBP511_ITEM_CALL_NBR, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEM_BIO_ENG", this.l10_QBP511_ITEM_BIO_ENG, 1, "X(01)"));

        String frKey = "L3 - 00 ITEM - INVOICE DETAIL";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITEX_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITEX_DEPT_BREAK = subString(dataChar, 5);             //PIC  X(05).
        this.l10_QBP511_ITEX_EXCP_DESC = subString(dataChar, 30);   //X(30).
        this.l10_QBP511_ITEX_SPCK = subStringComp3(dataHex, 4, 7, 0);        //S9(07) COMP-3.
        this.l10_QBP511_ITEX_SIZE = subString(dataChar, 15);        //X(15).
        this.l10_QBP511_ITEX_OQTY = subStringComp3(dataHex, 3, 5, 0);        //S9(05) COMP-3.
        this.l10_QBP511_ITEX_AQTY = subStringComp3(dataHex, 3, 5, 0);        //S9(05) COMP-3.
        this.l10_QBP511_ITEX_SQTY = subStringComp3(dataHex, 3, 5, 0);        //S9(05) COMP-3.
        this.l10_QBP511_ITEX_IQTY = subStringComp3(dataHex, 3, 5, 0);        //S9(05) COMP-3.
        this.l10_QBP511_ITEX_OADJ = subStringComp3(dataHex, 3, 5, 0);        //S9(05) COMP-3.
        this.l10_QBP511_ITEX_BLL_NXT_AVL = subString(dataChar, 10); //X(10).
        this.l10_QBP511_ITEX_DSDT = subString(dataChar, 10);        //X(10).
        this.l10_QBP511_ITEX_SUBO = subString(dataChar, 7);        //X(07).
        this.l10_QBP511_ITEX_INV_DEPT = subString(dataChar, 2);    //X(02).
        this.l10_QBP511_ITEX_RTL_ZONE = subString(dataChar, 4);    //X(04).
        this.l10_QBP511_ITEX_ORIG_ITEM = subString(dataChar, 7);   //X(07).
        this.l10_QBP511_ITEX_CMP_ITEM = subString(dataChar, 7);    //X(07).
        this.l10_QBP511_ITEX_SUBS = subString(dataChar, 1);        //X(01).
        this.l10_QBP511_ITEX_DEFR_DT = subString(dataChar, 8);     //9(08).
        this.l10_QBP511_ITEX_GR_NET_INV = subString(dataChar, 1);  //X(01).
        this.l10_QBP511_ITEX_PLCD = subString(dataChar, 1);        //X(01).
        this.l10_QBP511_ITEX_PLT_QTY = subStringComp3(dataHex, 3, 5, 0);     //S9(05) COMP-3.
        this.l10_QBP511_ITEX_NBR_OF_PLTS = subStringComp3(dataHex, 3, 5, 0); //S9(05) COMP-3.
        this.l10_QBP511_ITEX_CASE_QTY = subStringComp3(dataHex, 3, 5, 0);    //S9(05) COMP-3.
        this.l10_QBP511_ITEX_DEAL_CNTR = subStringComp3(dataHex, 2, 3, 0);   //S9(03) COMP-3.
        this.l10_QBP511_ITEX_SHP_CPO_FL = subString(dataChar, 1);  //X(01).
        this.l10_QBP511_ITEX_BILL_AVG_FL = subString(dataChar, 1); //X(01).
        this.l10_QBP511_ITEX_RWI = subString(dataChar, 1);         //X(01).
        //        88 QBP511_ITEX_RND_WEIGHTED        VALUE 'C'.
        //        88 QBP511_ITEX_AVG_WEIGHTED        VALUE 'I'.
        this.l10_QBP511_ITEX_IWGT = subStringComp3(dataHex, 4, 5, 2);        //S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEX_CWGT = subStringComp3(dataHex, 4, 5, 2);        //S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEX_CUBE = subStringComp3(dataHex, 5, 6, 3);        //S9(6)V9(3) COMP-3.
        this.l10_QBP511_ITEX_SCST = subStringComp3(dataHex, 5, 4, 5);        //S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEX_RTL_CRET = subStringComp3(dataHex, 4, 5, 2);    //S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITEX_RTL_CFOR = subStringComp3(dataHex, 2, 3, 0);    //S9(3) COMP-3.
        this.l10_QBP511_ITEX_GINA = subStringComp3(dataHex, 6, 6, 5);        //S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITEX_BSP_AMT = subStringComp3(dataHex, 5, 4, 5);     //S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEX_INVV = subStringComp3(dataHex, 5, 4, 5);        //S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITEX_EXT_COST = subStringComp3(dataHex, 5, 7, 2);    //S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITEX_EXT_CATA = subStringComp3(dataHex, 5, 7, 2);    //S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITEX_TAX_AMT = subStringComp3(dataHex, 7, 7, 5);     //S9(7)V9(5) COMP-3.
        this.l10_QBP511_ITEX_DLVRY_PCT = subStringComp3(dataHex, 3, 1, 4);   //S9(1)V9(4) COMP-3.
        this.l10_QBP511_ITEX_PROF_PCT = subStringComp3(dataHex, 5, 5, 4);    //S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITEX_CSS_BUYR = subString(dataChar, 3);    //X(03).
        this.l10_QBP511_ITEX_VEND = subString(dataChar, 7);        //X(07).
        this.l10_QBP511_ITEX_WPHI = subStringComp3(dataHex, 2, 3, 0);        //S9(3) COMP-3.
        this.l10_QBP511_ITEX_WPTI = subStringComp3(dataHex, 2, 3, 0);        //S9(3) COMP-3.
        this.l10_QBP511_ITEX_INV_TYPE = subString(dataChar, 1);    //X(01).
        this.l10_QBP511_ITEX_SECTION = subString(dataChar, 1);     //X(01).
        this.l10_QBP511_ITEX_PGM_CTRL_ID = subString(dataChar, 6); //X(06).
        this.l10_QBP511_ITEX_RSTR_BUY_CD = subString(dataChar, 4); //X(04).
        this.l10_QBP511_ITEX_SHP_DT = subString(dataChar, 8);      //9(08).
        this.l10_QBP511_ITEX_SHP_TM = subString(dataChar, 8);      //X(08).
        this.l10_QBP511_ITEX_RLS_TM = subString(dataChar, 8);      //X(08).
        this.l10_QBP511_ITEX_SOURCE = subString(dataChar, 1);      //X.
        this.l10_QBP511_ITEX_SOLD_AT_COST = subString(dataChar, 1); //X.
        this.l10_QBP511_ITEX_WILLCALL = subString(dataChar, 1);    //X.
        this.l10_QBP511_ITEX_HANDBILL = subString(dataChar, 1);    //X.
        this.l10_QBP511_ITEX_DIRECT_DLVRY = subString(dataChar, 1); //X.
        this.l10_QBP511_ITEX_CMDTY = subString(dataChar, 3);       //X(03).
        this.l10_QBP511_ITEX_SUB_CMDTY = subString(dataChar, 3);   //X(03).
        this.l10_QBP511_ITEX_HAZ_IND = subString(dataChar, 1);     //X.
        this.l10_QBP511_ITEX_IVL_ORTP = subString(dataChar, 1);    //X.
        this.l10_QBP511_ITEX_SOT_AMT = subStringComp3(dataHex, 6, 6, 5);     //S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITEX_PALT = subString(dataChar, 30);        //X(30).                                         
        this.l10_QBP511_ITEX_BRAND = subString(dataChar, 20);       //X(20).                                          
        this.l10_QBP511_ITEX_PALT2 = subString(dataChar, 30);       //X(30).                                         
        this.l10_QBP511_ITEX_FILLER1 = subString(dataChar, 20);                  //X(20).                                          
        this.l10_QBP511_ITEX_OASIS_CLASS = subString(dataChar, 1); //X(01).
        this.l10_QBP511_ITEX_OASIS_FACILITY = subString(dataChar, 4); //X(04).
        this.l10_QBP511_ITEX_RLS_DT = subString(dataChar, 8);      //9(08).
        this.l10_QBP511_ITEX_ORIG_UPC = subStringComp3(dataHex, 8, 15, 0);    //S9(15) COMP-3.
        this.l10_QBP511_ITEX_ORIG_UPC_IND = subString(dataChar, 1); //X(01).
        this.l10_QBP511_ITEX_ALTERNATE_VENDOR = subString(dataChar, 7); //X(07).
        this.l10_QBP511_ITEX_MPCK = subStringComp3(dataHex, 4, 7, 0);        //S9(07) COMP-3.
        this.l10_QBP511_ITEX_CALL_NBR = subString(dataChar, 4);    //X(04).
        this.l10_QBP511_ITEX_FILLER2 = subString(dataChar, 66);  //X(66).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();

        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DEPT_BREAK", this.l10_QBP511_ITEX_DEPT_BREAK, 5, "X(05)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_EXCP_DESC", this.l10_QBP511_ITEX_EXCP_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SPCK", this.l10_QBP511_ITEX_SPCK, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SIZE", this.l10_QBP511_ITEX_SIZE, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_OQTY", this.l10_QBP511_ITEX_OQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_AQTY", this.l10_QBP511_ITEX_AQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SQTY", this.l10_QBP511_ITEX_SQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_IQTY", this.l10_QBP511_ITEX_IQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_OADJ", this.l10_QBP511_ITEX_OADJ, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_BLL_NXT_AVL", this.l10_QBP511_ITEX_BLL_NXT_AVL, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DSDT", this.l10_QBP511_ITEX_DSDT, 10, "X(10)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SUBO", this.l10_QBP511_ITEX_SUBO, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_INV_DEPT", this.l10_QBP511_ITEX_INV_DEPT, 2, "X(02)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RTL_ZONE", this.l10_QBP511_ITEX_RTL_ZONE, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_ORIG_ITEM", this.l10_QBP511_ITEX_ORIG_ITEM, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CMP_ITEM", this.l10_QBP511_ITEX_CMP_ITEM, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SUBS", this.l10_QBP511_ITEX_SUBS, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DEFR_DT", this.l10_QBP511_ITEX_DEFR_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_GR_NET_INV", this.l10_QBP511_ITEX_GR_NET_INV, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PLCD", this.l10_QBP511_ITEX_PLCD, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PLT_QTY", this.l10_QBP511_ITEX_PLT_QTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_NBR_OF_PLTS", this.l10_QBP511_ITEX_NBR_OF_PLTS, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CASE_QTY", this.l10_QBP511_ITEX_CASE_QTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DEAL_CNTR", this.l10_QBP511_ITEX_DEAL_CNTR, 2, "S9(03) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SHP_CPO_FL", this.l10_QBP511_ITEX_SHP_CPO_FL, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_BILL_AVG_FL", this.l10_QBP511_ITEX_BILL_AVG_FL, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RWI", this.l10_QBP511_ITEX_RWI, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_IWGT", this.l10_QBP511_ITEX_IWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CWGT", this.l10_QBP511_ITEX_CWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CUBE", this.l10_QBP511_ITEX_CUBE, 5, "S9(6)V9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SCST", this.l10_QBP511_ITEX_SCST, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RTL_CRET", this.l10_QBP511_ITEX_RTL_CRET, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RTL_CFOR", this.l10_QBP511_ITEX_RTL_CFOR, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_GINA", this.l10_QBP511_ITEX_GINA, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_BSP_AMT", this.l10_QBP511_ITEX_BSP_AMT, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_INVV", this.l10_QBP511_ITEX_INVV, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_EXT_COST", this.l10_QBP511_ITEX_EXT_COST, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_EXT_CATA", this.l10_QBP511_ITEX_EXT_CATA, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_TAX_AMT", this.l10_QBP511_ITEX_TAX_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DLVRY_PCT", this.l10_QBP511_ITEX_DLVRY_PCT, 3, "S9(1)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PROF_PCT", this.l10_QBP511_ITEX_PROF_PCT, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CSS_BUYR", this.l10_QBP511_ITEX_CSS_BUYR, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_VEND", this.l10_QBP511_ITEX_VEND, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_WPHI", this.l10_QBP511_ITEX_WPHI, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_WPTI", this.l10_QBP511_ITEX_WPTI, 2, "S9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_INV_TYPE", this.l10_QBP511_ITEX_INV_TYPE, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SECTION", this.l10_QBP511_ITEX_SECTION, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PGM_CTRL_ID", this.l10_QBP511_ITEX_PGM_CTRL_ID, 6, "X(06)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RSTR_BUY_CD", this.l10_QBP511_ITEX_RSTR_BUY_CD, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SHP_DT", this.l10_QBP511_ITEX_SHP_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SHP_TM", this.l10_QBP511_ITEX_SHP_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RLS_TM", this.l10_QBP511_ITEX_RLS_TM, 8, "X(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SOURCE", this.l10_QBP511_ITEX_SOURCE, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SOLD_AT_COST", this.l10_QBP511_ITEX_SOLD_AT_COST, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_WILLCALL", this.l10_QBP511_ITEX_WILLCALL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_HANDBILL", this.l10_QBP511_ITEX_HANDBILL, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_DIRECT_DLVRY", this.l10_QBP511_ITEX_DIRECT_DLVRY, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CMDTY", this.l10_QBP511_ITEX_CMDTY, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SUB_CMDTY", this.l10_QBP511_ITEX_SUB_CMDTY, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_HAZ_IND", this.l10_QBP511_ITEX_HAZ_IND, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_IVL_ORTP", this.l10_QBP511_ITEX_IVL_ORTP, 1, "X"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_SOT_AMT", this.l10_QBP511_ITEX_SOT_AMT, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PALT", this.l10_QBP511_ITEX_PALT, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_BRAND", this.l10_QBP511_ITEX_BRAND, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_PALT2", this.l10_QBP511_ITEX_PALT2, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_FILLER1", this.l10_QBP511_ITEX_FILLER1, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_OASIS_CLASS", this.l10_QBP511_ITEX_OASIS_CLASS, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_OASIS_FACILITY", this.l10_QBP511_ITEX_OASIS_FACILITY, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_RLS_DT", this.l10_QBP511_ITEX_RLS_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_ORIG_UPC", this.l10_QBP511_ITEX_ORIG_UPC, 8, "S9(15) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_ORIG_UPC_IND", this.l10_QBP511_ITEX_ORIG_UPC_IND, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_ALTERNATE_VENDOR", this.l10_QBP511_ITEX_ALTERNATE_VENDOR, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_MPCK", this.l10_QBP511_ITEX_MPCK, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_CALL_NBR", this.l10_QBP511_ITEX_CALL_NBR, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITEX_FILLER2", this.l10_QBP511_ITEX_FILLER2, 66, "X(66)"));

        String frKey = "L3 - 00 ITEX - ITEM EXCEPTION";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITOR_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITOR_ITEM = subString(dataChar, 7); //PIC  X(07).
        this.l10_QBP511_ITOR_DESC = subString(dataChar, 50); //PIC  X(50).
        this.l10_QBP511_ITOR_SUBO = subString(dataChar, 7); //PIC  X(07).
        this.l10_QBP511_ITOR_MPCK = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.
        this.l10_QBP511_ITOR_SIZE = subString(dataChar, 15); //PIC  X(15).
        this.l10_QBP511_ITOR_OQTY = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITOR_AQTY = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITOR_SQTY = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITOR_IQTY = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITOR_OADJ = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITOR_SCST = subStringComp3(dataHex, 5, 4, 5); //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITOR_RTL_CFOR = subStringComp3(dataHex, 2, 3, 0); //PIC S9(03) COMP-3.
        this.l10_QBP511_ITOR_RTL_CRET = subStringComp3(dataHex, 4, 5, 2); //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITOR_NDC_DESC = subString(dataChar, 30); //PIC  X(30).
        this.l10_QBP511_ITOR_NDCD = subString(dataChar, 1); //PIC  X(01).
        this.l10_QBP511_ITOR_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();

        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_ITEM", this.l10_QBP511_ITOR_ITEM, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_DESC", this.l10_QBP511_ITOR_DESC, 50, "X(50)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_SUBO", this.l10_QBP511_ITOR_SUBO, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_MPCK", this.l10_QBP511_ITOR_MPCK, 4, "PIC S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_SIZE", this.l10_QBP511_ITOR_SIZE, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_OQTY", this.l10_QBP511_ITOR_OQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_AQTY", this.l10_QBP511_ITOR_AQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_SQTY", this.l10_QBP511_ITOR_SQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_IQTY", this.l10_QBP511_ITOR_IQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_OADJ", this.l10_QBP511_ITOR_OADJ, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_SCST", this.l10_QBP511_ITOR_SCST, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_RTL_CFOR", this.l10_QBP511_ITOR_RTL_CFOR, 2, "S9(03) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_RTL_CRET", this.l10_QBP511_ITOR_RTL_CRET, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_NDC_DESC", this.l10_QBP511_ITOR_NDC_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_NDCD", this.l10_QBP511_ITOR_NDCD, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITOR_SQNC_NBR", this.l10_QBP511_ITOR_SQNC_NBR, 4, "PIC S9(07) COMP-3"));

        String frKey = "L3 - 10 ITOR - ORIGINAL OF SUB";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITAL_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.L10_QBP511_ITAL_AMOUNT = subStringComp3(dataHex, 5, 4, 5);   //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITAL_PM_NET = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_ITAL_DESC_SHORT = subString(dataChar, 15);            //PIC  X(15).
        this.l10_QBP511_ITAL_DESC = subString(dataChar, 30);            //PIC  X(30).
        this.l10_QBP511_ITAL_N_CST = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITAL_BUYER_ID = subString(dataChar, 3);             //PIC  X(03).
        this.l10_QBP511_ITAL_DEAL_NBR = subStringComp(dataHex, 2);          //PIC  9(04)     COMP.
        this.l10_QBP511_ITAL_DEAL_TYPE = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITAL_TYPE_EXP = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITAL_PROMO_PGM = subString(dataChar, 1);             //PIC  X(01).
        this.l10_QBP511_ITAL_DEAL_AMT = subStringComp3(dataHex, 5, 7, 2);   //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_ITAL_START_DT = subString(dataChar, 8);             //PIC  9(08).
        this.l10_QBP511_ITAL_END_DT = subString(dataChar, 8);             //PIC  9(08).
        this.l10_QBP511_ITAL_EXT_ALWNC = subStringComp3(dataHex, 7, 8, 5);   //PIC S9(8)V9(5) COMP-3.
        this.l10_QBP511_ITAL_PROMO_ID = subString(dataChar, 4);             //PIC  X(04).
        this.l10_QBP511_ITAL_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0);   //PIC S9(07) COMP-3.
        this.l10_QBP511_ITAL_DEAL_CD = subString(dataChar, 7);             //PIC  X(07).
        this.l10_QBP511_ITAL_VEND = subString(dataChar, 7);             //PIC  X(07).                     
        this.l10_QBP511_ITAL_EXT_GRP_ID = subString(dataChar, 20);            //PIC  X(20).                     
        this.l10_QBP511_ITAL_EXT_ARB_ID = subString(dataChar, 20);            //PIC  X(20).                     
        this.l10_QBP511_ITAL_EXT_FEE_TYPE = subString(dataChar, 1);             //PIC X.                         
        this.l10_QBP511_ITAL_EXT_FEE_AMT = subStringComp3(dataHex, 4, 5, 2);   //PIC S9(5)V9(2) COMP-3.    

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("L10_QBP511_ITAL_AMOUNT", this.L10_QBP511_ITAL_AMOUNT, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_PM_NET", this.l10_QBP511_ITAL_PM_NET, 5, "S9(5)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DESC_SHORT", this.l10_QBP511_ITAL_DESC_SHORT, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DESC", this.l10_QBP511_ITAL_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_N_CST", this.l10_QBP511_ITAL_N_CST, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_BUYER_ID", this.l10_QBP511_ITAL_BUYER_ID, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DEAL_NBR", this.l10_QBP511_ITAL_DEAL_NBR, 2, "9(04) COMP"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DEAL_TYPE", this.l10_QBP511_ITAL_DEAL_TYPE, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_TYPE_EXP", this.l10_QBP511_ITAL_TYPE_EXP, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_PROMO_PGM", this.l10_QBP511_ITAL_PROMO_PGM, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DEAL_AMT", this.l10_QBP511_ITAL_DEAL_AMT, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_START_DT", this.l10_QBP511_ITAL_START_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_END_DT", this.l10_QBP511_ITAL_END_DT, 8, "9(08)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_EXT_ALWNC", this.l10_QBP511_ITAL_EXT_ALWNC, 7, "S9(8)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_PROMO_ID", this.l10_QBP511_ITAL_PROMO_ID, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_SQNC_NBR", this.l10_QBP511_ITAL_SQNC_NBR, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_DEAL_CD", this.l10_QBP511_ITAL_DEAL_CD, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_VEND", this.l10_QBP511_ITAL_VEND, 7, "X(07)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_EXT_GRP_ID", this.l10_QBP511_ITAL_EXT_GRP_ID, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_EXT_ARB_ID", this.l10_QBP511_ITAL_EXT_ARB_ID, 20, "X(20)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_EXT_FEE_TYPE", this.l10_QBP511_ITAL_EXT_FEE_TYPE, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITAL_EXT_FEE_AMT", this.l10_QBP511_ITAL_EXT_FEE_AMT, 4, "S9(5)V9(2) COMP-3"));

        String frKey = "L3 - 20 ITAL - ITEM ALLOWANCES";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "", this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_IRTB_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_IRBT_PROMO_ID = subString(dataChar, 4);           //PIC  X(04).
        this.l10_QBP511_IRBT_DESC_SHORT = subString(dataChar, 15);          //PIC  X(15).
        this.l10_QBP511_IRBT_DESC = subString(dataChar, 30);          //PIC  X(30).
        this.l10_QBP511_IRBT_AMOUNT = subStringComp3(dataHex, 5, 4, 5); //PIC S9(4)V9(5) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_IRBT_PROMO_ID", this.l10_QBP511_IRBT_PROMO_ID, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IRBT_DESC_SHORT", this.l10_QBP511_IRBT_DESC_SHORT, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IRBT_DESC", this.l10_QBP511_IRBT_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_IRBT_AMOUNT", this.l10_QBP511_IRBT_AMOUNT, 5, "S9(4)V9(5) COMP-3"));

        String frKey = "L3 - 22 IRBT - ITEM REBATES";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITSC_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITSC_DESC = subString(dataChar, 30);          //PIC  X(30).
        this.l10_QBP511_ITSC_SIZE = subString(dataChar, 15);          //PIC  X(15).
        this.l10_QBP511_ITSC_QTY_UNT = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.
        this.l10_QBP511_ITSC_CST_UNT = subStringComp3(dataHex, 6, 6, 5); //PIC S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITSC_RTL_MLT = subStringComp3(dataHex, 2, 3, 0); //PIC S9(03) COMP-3.
        this.l10_QBP511_ITSC_CPO_RTL = subStringComp3(dataHex, 4, 4, 3); //PIC S9(4)V9(3) COMP-3.
        this.l10_QBP511_ITSC_EXT_RTL_PRICE = subStringComp3(dataHex, 6, 7, 4); //PIC S9(7)V9(4) COMP-3.
        this.l10_QBP511_ITSC_SOURCE = subString(dataChar, 3);           //PIC  X(03).
        this.l10_QBP511_ITSC_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.
        this.l10_QBP511_ITSC_BIO_ENG = subString(dataChar, 1);           //PIC  X(01).

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_DESC", this.l10_QBP511_ITSC_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_SIZE", this.l10_QBP511_ITSC_SIZE, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_QTY_UNT", this.l10_QBP511_ITSC_QTY_UNT, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_CST_UNT", this.l10_QBP511_ITSC_CST_UNT, 6, "S9(6)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_RTL_MLT", this.l10_QBP511_ITSC_RTL_MLT, 2, "S9(03) COMP-33"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_CPO_RTL", this.l10_QBP511_ITSC_CPO_RTL, 4, "S9(4)V9(3) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_EXT_RTL_PRICE", this.l10_QBP511_ITSC_EXT_RTL_PRICE, 6, "S9(7)V9(4) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_SOURCE", this.l10_QBP511_ITSC_SOURCE, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_SQNC_NBR", this.l10_QBP511_ITSC_SQNC_NBR, 4, "S9(07) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITSC_BIO_ENG", this.l10_QBP511_ITSC_BIO_ENG, 1, "X(01)"));

        String frKey = "L3 - 30 ITSC - SHIPPER COMPONENTS";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITWT_DATA(String dataHex) {

        currentIndex = 0;

        this.l10_QBP511_ITWT_IQTY = subStringComp3(dataHex, 3, 5, 0); //PIC S9(05) COMP-3.
        this.l10_QBP511_ITWT_IWGT = subStringComp3(dataHex, 4, 5, 2); //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITWT_SWGT = subStringComp3(dataHex, 4, 5, 2); //PIC S9(5)V9(2) COMP-3.
        this.l10_QBP511_ITWT_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITWT_IQTY", this.l10_QBP511_ITWT_IQTY, 3, "S9(05) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITWT_IWGT", this.l10_QBP511_ITWT_IWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITWT_SWGT", this.l10_QBP511_ITWT_SWGT, 4, "S9(5)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITWT_SQNC_NBR", this.l10_QBP511_ITWT_SQNC_NBR, 4, "S9(07) COMP-3"));

        String frKey = "L3 - 40 ITWT - RANDOM WEIGHTS";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITND_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITND_CODE = subString(dataChar, 03);              //PIC  X(03).
        this.l10_QBP511_ITND_DESC = subString(dataChar, 30);              //PIC  X(30).
        this.l10_QBP511_ITND_DESC_SHORT = subString(dataChar, 15);        //PIC  X(15).
        this.l10_QBP511_ITND_ABBR = subString(dataChar, 04);              //PIC  X(04).
        this.l10_QBP511_ITND_RSTR_BUY_CD = subString(dataChar, 04);       //PIC  X(04).
        this.l10_QBP511_ITND_INV_LOC = subString(dataChar, 1);            //PIC  X(01).
        this.l10_QBP511_ITND_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_CODE", this.l10_QBP511_ITND_CODE, 3, "X(03)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_DESC", this.l10_QBP511_ITND_DESC, 30, "X(30)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_DESC_SHORT", this.l10_QBP511_ITND_DESC_SHORT, 15, "X(15)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_ABBR", this.l10_QBP511_ITND_ABBR, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_RSTR_BUY_CD", this.l10_QBP511_ITND_RSTR_BUY_CD, 4, "X(04)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_INV_LOC", this.l10_QBP511_ITND_INV_LOC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITND_SQNC_NBR", this.l10_QBP511_ITND_SQNC_NBR, 4, "S9(07) COMP-3"));

        String frKey = "L3 - 50 ITND - NDC CODES";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITFE_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITFE_FEE_AMT = subStringComp3(dataHex, 7, 7, 5); //PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_ITFE_FEE_PCT = subStringComp3(dataHex, 5, 7, 2); //PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_ITFE_FEE_DESC = subString(dataChar, 25);        //PIC  X(25).
        this.l10_QBP511_ITFE_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITFE_FEE_AMT", this.l10_QBP511_ITFE_FEE_AMT, 7, "S9(7)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITFE_FEE_PCT", this.l10_QBP511_ITFE_FEE_PCT, 5, "S9(7)V9(2) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITFE_FEE_DESC", this.l10_QBP511_ITFE_FEE_DESC, 25, "X(25)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITFE_SQNC_NBR", this.l10_QBP511_ITFE_SQNC_NBR, 4, "S9(07) COMP-3"));

        String frKey = "L3 - 60 ITFE - ITEM FEES";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

    }

    private void QBP511_ITTX_DATA(String dataHex, String dataChar) {

        currentIndex = 0;

        this.l10_QBP511_ITTX_AMOUNT = subStringComp3(dataHex, 5, 4, 5);  //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITTX_TAX_EMBD = subString(dataChar, 1);          //PIC  X(01).
        this.l10_QBP511_ITTX_PERCENT = subStringComp3(dataHex, 5, 4, 5);  //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITTX_PCNT_COST = subStringComp3(dataHex, 5, 4, 5);  //PIC S9(4)V9(5) COMP-3.
        this.l10_QBP511_ITTX_PCNT_BASIS = subString(dataChar, 1);           //PIC  X(01).
        this.l10_QBP511_ITTX_STATE_LOC = subString(dataChar, 1);           //PIC  X(01).
        this.l10_QBP511_ITTX_COUNTY_LOC = subString(dataChar, 1);           //PIC  X(01).
        this.l10_QBP511_ITTX_CITY_LOC = subString(dataChar, 1);           //PIC  X(01).
        this.l10_QBP511_ITTX_OTHER_LOC = subString(dataChar, 1);           //PIC  X(01).
        this.l10_QBP511_ITTX_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.

        this.fullFileFieldList = FXCollections.observableArrayList();
        currentIndex = 1;
        this.fullLevelKey();
        this.fullFileFieldList.add(buildFileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), 2, "9(04) COMP"));

        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_AMOUNT", this.l10_QBP511_ITTX_AMOUNT, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_TAX_EMBD", this.l10_QBP511_ITTX_TAX_EMBD, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_PERCENT", this.l10_QBP511_ITTX_PERCENT, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_PCNT_COST", this.l10_QBP511_ITTX_PCNT_COST, 5, "S9(4)V9(5) COMP-3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_PCNT_BASIS", this.l10_QBP511_ITTX_PCNT_BASIS, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_STATE_LOC", this.l10_QBP511_ITTX_STATE_LOC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_COUNTY_LOC", this.l10_QBP511_ITTX_COUNTY_LOC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_CITY_LOC", this.l10_QBP511_ITTX_CITY_LOC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_OTHER_LOC", this.l10_QBP511_ITTX_OTHER_LOC, 1, "X(01)"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_ITTX_SQNC_NBR", this.l10_QBP511_ITTX_SQNC_NBR, 4, "S9(07) COMP-3"));

        String frKey = "L3 - 70 ITTX - ITEM TAXES";
        String frValue = this.frValueLevel3();

        this.subRecFR = new FileRecord(frKey, frValue, "",
                this.fullFileFieldList, this.fullHexString, this.fullCharString);

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

    private String subStringComp3(String hexString, Integer length, Integer intLength, Integer decLength) {

        Integer startIndex = currentIndex * 2;
        currentIndex = currentIndex + length;
        Integer endIndex = startIndex + (length * 2);

        ////System.out.println("****************************");
        ////System.out.println("* startIndex = " + startIndex);
        ////System.out.println("* endIndex   = " + endIndex);
        ////System.out.println("* " + StringUtils.substring(hexString, startIndex, endIndex));
        ////System.out.println("****************************");
        String comp3 = StringUtils.substring(hexString, startIndex, endIndex);
        String whole = StringUtils.substring(comp3, 0, intLength);
        String decimal = StringUtils.substring(comp3, intLength, intLength + decLength);
        String sign = "-";
        if (StringUtils.equalsIgnoreCase(StringUtils.substring(comp3, -1), "c")) {
            sign = "+";
        }
        String decimalPoint = ".";
        if (decLength == 0) {
            decimalPoint = "";
        }
        ////System.out.println(comp3 + "|" + whole + "|" + decimal + "|" + sign);
        ////System.out.println("****************************");

        return sign + whole + decimalPoint + decimal;

    }

    private String frValueLevel1() {

        StringBuilder frValue = new StringBuilder();

        frValue.append(this.l10_QBP511_KNVC_IVNO).append("|");
        frValue.append(this.l10_QBP511_KNVC_IVDT).append("|");
        frValue.append(this.l15_QBP511_KNVC_FACL).append("|");
        frValue.append(this.l15_QBP511_KNVC_WHSE).append("|");
        frValue.append(this.l10_QBP511_KNVC_STOR).append("|");
        frValue.append(this.l10_QBP511_KNVC_TYPE).append("|");
        frValue.append(this.l10_QBP511_KNVC_ROUT).append("|");
        frValue.append(this.l10_QBP511_KNVC_STOP).append("|");
        frValue.append(this.l10_QBP511_KNVC_DDAT).append("|");
        frValue.append(this.l10_QBP511_KNVC_CPY_CD).append("|");
        frValue.append(this.l10_QBP511_KNVC_ROUT_PRC_FL).append("|");
        frValue.append(this.l10_QBP511_KNVC_CPY_SRT_BY).append("|");

        return frValue.toString();

    }

    private String frValueLevel2() {

        StringBuilder frValue = new StringBuilder();

        frValue.append(this.l10_QBP511_KNVB_ORNO).append("|");
        frValue.append(this.l10_QBP511_KNVB_INV_BREAK).append("|");
        frValue.append(this.l10_QBP511_KNVB_WDPT).append("|");
        frValue.append(this.l10_QBP511_KNVB_ORTP).append("|");
        frValue.append(this.l10_QBP511_KNVB_TYPE).append("|");
        frValue.append(this.l10_filler1).append("|");
        frValue.append(this.l10_QBP511_KNVB_ORD_CLASS).append("|");
        frValue.append(this.l10_QBP511_KNVB_TEXT).append("|");

        return frValue.toString();

    }

    private String frValueLevel3() {

        StringBuilder frValue = new StringBuilder();

        frValue.append(this.l10_QBP511_KITM_ITEM).append("|");
        frValue.append(this.l10_QBP511_KITM_SUBN).append("|");
        frValue.append(this.l10_QBP511_KITM_COMM).append("|");
        frValue.append(this.l10_QBP511_KITM_SUBC).append("|");
        frValue.append(this.l15_QBP511_KITM_UPC_PROD).append("|");
        frValue.append(this.l15_QBP511_KITM_UPC_MANF).append("|");
        frValue.append(this.l15_QBP511_KITM_UPC_VNDR_ITM).append("|");
        frValue.append(this.l15_QBP511_KITM_UPC_ITEM).append("|");
        frValue.append(this.l10_QBP511_KITM_SHP_FL).append("|");
        frValue.append(this.l10_QBP511_KITM_ITEM_EX_CD).append("|");
        frValue.append(this.l10_QBP511_KITM_TYPE).append("|");
        frValue.append(this.l10_QBP511_KITM_RFRNC_CD).append("|");
        frValue.append(this.l10_QBP511_KITM_SLOT).append("|");
        frValue.append(this.l10_QBP511_KITM_DESC).append("|");
        frValue.append(this.l10_QBP511_KITM_REF_DESC).append("|");
        frValue.append(this.l10_QBP511_KITM_EX_NDC_CD).append("|");

        return frValue.toString();

    }

    private void fullLevelKey() {

        //Level 1
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_IVNO", l10_QBP511_KNVC_IVNO, 7, "9(07)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_IVDT", l10_QBP511_KNVC_IVDT, 8, "9(08)", "L1"));
        //this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_FWHS", l10_QBP511_KNVC_FWHS, "",,  "L1"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KNVC_FACL", l15_QBP511_KNVC_FACL, 2, "X(02)", "L1"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KNVC_WHSE", l15_QBP511_KNVC_WHSE, 2, "X(02)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_STOR", l10_QBP511_KNVC_STOR, 5, "9(05)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_TYPE", l10_QBP511_KNVC_TYPE, 2, "X(02)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_ROUT", l10_QBP511_KNVC_ROUT, 4, "X(04)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_STOP", l10_QBP511_KNVC_STOP, 3, "X(03)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_DDAT", l10_QBP511_KNVC_DDAT, 8, "9(08)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_CPY_CD", l10_QBP511_KNVC_CPY_CD, 5, "X(05)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_ROUT_PRC_FL", l10_QBP511_KNVC_ROUT_PRC_FL, 1, "X(01)", "L1"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVC_CPY_SRT_BY", l10_QBP511_KNVC_CPY_SRT_BY, 3, "X(03)", "L1"));

        //level 2
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_ORNO", l10_QBP511_KNVB_ORNO, 5, "9(05)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_INV_BREAK", l10_QBP511_KNVB_INV_BREAK, 5, "X(05)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_WDPT", l10_QBP511_KNVB_WDPT, 2, "X(02)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_ORTP", l10_QBP511_KNVB_ORTP, 2, "X(02)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_TYPE", l10_QBP511_KNVB_TYPE, 2, "X(02)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_FILLER", l10_filler1, 8, "X(08)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_ORD_CLASS", l10_QBP511_KNVB_ORD_CLASS, 1, "X(01)", "L2"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KNVB_TEXT", l10_QBP511_KNVB_TEXT, 15, "X(15)", "L2"));

        //level 3
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_ITEM", l10_QBP511_KITM_ITEM, 7, "9(07)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_SUBN", l10_QBP511_KITM_SUBN, 2, "X(02)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_COMM", l10_QBP511_KITM_COMM, 5, "9(05)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_SUBC", l10_QBP511_KITM_SUBC, 5, "9(05)", "L3"));
        //this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_PUPC", l10_QBP511_KITM_PUPC, 15, "X(15)",  "L3"));
        //this.fullFileFieldList.add(buildFileField("l10_FILLER", "", "", 110, 124,  "L3"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KITM_UPC_PROD", l15_QBP511_KITM_UPC_PROD, 1, "X(01)", "L3"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KITM_UPC_MANF", l15_QBP511_KITM_UPC_MANF, 5, "X(05)", "L3"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KITM_UPC_VNDR_ITM", l15_QBP511_KITM_UPC_VNDR_ITM, 4, "X(04)", "L3"));
        this.fullFileFieldList.add(buildFileField("l15_QBP511_KITM_UPC_ITEM", l15_QBP511_KITM_UPC_ITEM, 5, "X(05)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_SHP_FL", l10_QBP511_KITM_SHP_FL, 1, "X(01)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_ITEM_EX_CD", l10_QBP511_KITM_ITEM_EX_CD, 1, "X(01)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_TYPE", l10_QBP511_KITM_TYPE, 2, "X(02)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_RFRNC_CD", l10_QBP511_KITM_RFRNC_CD, 50, "X(50)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_SLOT", l10_QBP511_KITM_SLOT, 6, "X(06)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_DESC", l10_QBP511_KITM_DESC, 21, "X(21)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_REF_DESC", l10_QBP511_KITM_REF_DESC, 15, "X(15)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_QBP511_KITM_EX_NDC_CD", l10_QBP511_KITM_EX_NDC_CD, 1, "X(01)", "L3"));
        this.fullFileFieldList.add(buildFileField("l10_FILLER", l10_filler2, 7, "X(07)", "L3"));

        if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "60")) {
            //KMFE - IVM FEE RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KMFE_FEE_CODE", this.l15_QBP511_KMFE_FEE_CODE, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KMFE_FEE_CUST", this.l15_QBP511_KMFE_FEE_CUST, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 20, "X(20)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "65")) {
            //KMTF - TOTAL FEES RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KMTF_FEE_CODE", this.l15_QBP511_KMTF_FEE_CODE, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 25, "X(25)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KNVB_TYPE, "60")) {
            //KBFE - IVB FEE RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KBFE_FEE_CODE", this.l15_QBP511_KBFE_FEE_CODE, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KBFE_FEE_CUST", this.l15_QBP511_KBFE_FEE_CUST, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 20, "X(20)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "20")) {
            //KTAL - ITEM ALLOWANCE RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTAL_ABBR", this.l15_QBP511_KTAL_ABBR, 4, "X(04)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTAL_TS", this.l15_QBP511_KTAL_TS, 26, "X(26)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "30")) {
            //KTSC - SHIPPER COMPONENT RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTSC_CPO_UPC", this.l15_QBP511_KTSC_CPO_UPC, 15, "X(15)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTSC_CPO_ITEM", this.l15_QBP511_KTSC_CPO_ITEM, 7, "X(07)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 8, "X(08)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "40")) {
            //KTWT - RANDOM WEIGHT RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTWT_SEQN", this.l15_QBP511_KTWT_SEQN, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 25, "X(25)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "50")) {
            //KTND - NDC CODE RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTND_SEQN", this.l15_QBP511_KTND_SEQN, 4, "9(04)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 26, "X(26)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "60")) {
            //KTFE - ITEM FEE RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTFE_FEE_CODE", this.l15_QBP511_KTFE_FEE_CODE, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTFE_FEE_CUST", this.l15_QBP511_KTFE_FEE_CUST, 5, "X(05)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 20, "X(20)", "SK"));
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "70")) {
            //KTTX - ITEM TAX RECORD KEY
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTTX_LOCATION", this.l15_QBP511_KTTX_LOCATION, 6, "X(06)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTTX_TAX_TYPE", this.l15_QBP511_KTTX_TAX_TYPE, 3, "X(03)", "SK"));
            this.fullFileFieldList.add(buildFileField("l15_QBP511_KTTX_TAX_CODE", this.l15_QBP511_KTTX_TAX_CODE, 3, "X(03)", "SK"));
            this.fullFileFieldList.add(buildFileField("FILLER", "", 18, "X(18)", "SK"));
        } else {
            this.fullFileFieldList.add(buildFileField("l10_QBP511_KSUB_KEY", this.l10_QBP511_KSUB_KEY, 30, "X(30)", "SK"));
        }

    }

    private FileField buildFileField(String nameTxt, String recTypeValue, Integer length, String picTxt, String keyLevel) {

        Integer startPos = currentIndex;
        currentIndex = currentIndex + length;
        Integer endPos = (currentIndex - 1);

        return new FileField(nameTxt, recTypeValue, picTxt, startPos, endPos, keyLevel);
    }

    private FileField buildFileField(String nameTxt, String recTypeValue, Integer length, String picTxt) {

        Integer startPos = currentIndex;
        currentIndex = currentIndex + length;
        Integer endPos = (currentIndex - 1);

        return new FileField(nameTxt, recTypeValue, picTxt, startPos, endPos);
    }
    
    public FileRecord getLevelFR() {
        return levelFR;
    }

    public FileRecord getSubRecFR() {
        return subRecFR;
    }

}
