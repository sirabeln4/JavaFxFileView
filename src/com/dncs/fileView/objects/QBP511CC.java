package com.dncs.fileView.objects;

import org.apache.commons.lang3.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QBP511CC {

    private Boolean lvl1;
    private Boolean lvl2;
    private Boolean lvl3;

    private FileRecord levelFR;
    private FileRecord subRecFR;

    private Integer currentIndex;

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
    private String l10_QBP511_IMLD_LICENSE_DESC_DATA; 	//OCCURS 14 TIMES.
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
    private String l10_QBP511_ITEM_ORIG_UPC;         //PIC S9(15) COMP_3.
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
    //     10 QBP511-ITEX-DEPT-BREAK  PIC  X(05).
    //     10 QBP511-ITEX-EXCP-DESC   PIC  X(30).
    //     10 QBP511-ITEX-SPCK        PIC S9(07) COMP-3.
    //     10 QBP511-ITEX-SIZE        PIC  X(15).
    //     10 QBP511-ITEX-OQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-AQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-SQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-IQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-OADJ        PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-BLL-NXT-AVL PIC  X(10).
    //     10 QBP511-ITEX-DSDT        PIC  X(10).
    //     10 QBP511-ITEX-SUBO        PIC  X(07).
    //     10 QBP511-ITEX-INV-DEPT    PIC  X(02).
    //     10 QBP511-ITEX-RTL-ZONE    PIC  X(04).
    //     10 QBP511-ITEX-ORIG-ITEM   PIC  X(07).
    //     10 QBP511-ITEX-CMP-ITEM    PIC  X(07).
    //     10 QBP511-ITEX-SUBS        PIC  X(01).
    //     10 QBP511-ITEX-DEFR-DT     PIC  9(08).
    //     10 QBP511-ITEX-GR-NET-INV  PIC  X(01).
    //     10 QBP511-ITEX-PLCD        PIC  X(01).
    //     10 QBP511-ITEX-PLT-QTY     PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-NBR-OF-PLTS PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-CASE-QTY    PIC S9(05) COMP-3.
    //     10 QBP511-ITEX-DEAL-CNTR   PIC S9(03) COMP-3.
    //     10 QBP511-ITEX-SHP-CPO-FL  PIC  X(01).
    //     10 QBP511-ITEX-BILL-AVG-FL PIC  X(01).
    //     10 QBP511-ITEX-RWI         PIC  X(01).
    //        88 QBP511-ITEX-RND-WEIGHTED        VALUE 'C'.
    //        88 QBP511-ITEX-AVG-WEIGHTED        VALUE 'I'.
    //     10 QBP511-ITEX-IWGT        PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITEX-CWGT        PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITEX-CUBE        PIC S9(6)V9(3) COMP-3.
    //     10 QBP511-ITEX-SCST        PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITEX-RTL-CRET    PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITEX-RTL-CFOR    PIC S9(3) COMP-3.
    //     10 QBP511-ITEX-GINA        PIC S9(6)V9(5) COMP-3.
    //     10 QBP511-ITEX-BSP-AMT     PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITEX-INVV        PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITEX-EXT-COST    PIC S9(7)V9(2) COMP-3.
    //     10 QBP511-ITEX-EXT-CATA    PIC S9(7)V9(2) COMP-3.
    //     10 QBP511-ITEX-TAX-AMT     PIC S9(7)V9(5) COMP-3.
    //     10 QBP511-ITEX-DLVRY-PCT   PIC S9(1)V9(4) COMP-3.
    //     10 QBP511-ITEX-PROF-PCT    PIC S9(5)V9(4) COMP-3.
    //     10 QBP511-ITEX-CSS-BUYR    PIC  X(03).
    //     10 QBP511-ITEX-VEND        PIC  X(07).
    //     10 QBP511-ITEX-WPHI        PIC S9(3) COMP-3.
    //     10 QBP511-ITEX-WPTI        PIC S9(3) COMP-3.
    //     10 QBP511-ITEX-INV-TYPE    PIC  X(01).
    //     10 QBP511-ITEX-SECTION     PIC  X(01).
    //     10 QBP511-ITEX-PGM-CTRL-ID PIC  X(06).
    //     10 QBP511-ITEX-RSTR-BUY-CD PIC  X(04).
    //     10 QBP511-ITEX-SHP-DT      PIC  9(08).
    //     10 QBP511-ITEX-SHP-TM      PIC  X(08).
    //     10 QBP511-ITEX-RLS-TM      PIC  X(08).
    //     10 QBP511-ITEX-SOURCE      PIC  X.
    //     10 QBP511-ITEX-SOLD-AT-COST PIC X.
    //     10 QBP511-ITEX-WILLCALL    PIC  X.
    //     10 QBP511-ITEX-HANDBILL    PIC  X.
    //     10 QBP511-ITEX-DIRECT-DLVRY PIC X.
    //     10 QBP511-ITEX-CMDTY       PIC  X(03).
    //     10 QBP511-ITEX-SUB-CMDTY   PIC  X(03).
    //     10 QBP511-ITEX-HAZ-IND     PIC  X.
    //     10 QBP511-ITEX-IVL-ORTP    PIC  X.
    //     10 QBP511-ITEX-SOT-AMT     PIC S9(6)V9(5) COMP-3.
    //     10 QBP511-ITEX-PALT        PIC  X(30).                                         
    //     10 QBP511-ITEX-BRAND       PIC X(20).                                          
    //     10 QBP511-ITEX-PALT2       PIC  X(30).                                         
    //     10 FILLER                  PIC X(20).                                          
    //     10 QBP511-ITEX-OASIS-CLASS PIC  X(01).
    //     10 QBP511-ITEX-OASIS-FACILITY PIC X(04).
    //     10 QBP511-ITEX-RLS-DT      PIC  9(08).
    //     10 QBP511-ITEX-ORIG-UPC    PIC S9(15) COMP-3.
    //     10 QBP511-ITEX-ORIG-UPC-IND PIC X(01).
    //     10 QBP511-ITEX-ALTERNATE-VENDOR PIC X(07).
    //     10 QBP511-ITEX-MPCK        PIC S9(07) COMP-3.
    //     10 QBP511-ITEX-CALL-NBR    PIC  X(04).
    //     10 FILLER                  PIC  X(66).
    //
    //******************************************************************
    //*      ITOR - ORIGINAL OF SUB       - LEVEL 3                    *
    //*********************************************************140BYTES*
    //************************************************GW02493  144BYTES*
    //01 QBP511-ITOR-DATA.
    //  05 QBP511-ITOR-FIELDS.
    //     10 QBP511-ITOR-ITEM        PIC  X(07).
    //     10 QBP511-ITOR-DESC        PIC  X(50).
    //     10 QBP511-ITOR-SUBO        PIC  X(07).
    //     10 QBP511-ITOR-MPCK        PIC S9(07) COMP-3.
    //     10 QBP511-ITOR-SIZE        PIC  X(15).
    //     10 QBP511-ITOR-OQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITOR-AQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITOR-SQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITOR-IQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITOR-OADJ        PIC S9(05) COMP-3.
    //     10 QBP511-ITOR-SCST        PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITOR-RTL-CFOR    PIC S9(03) COMP-3.
    //     10 QBP511-ITOR-RTL-CRET    PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITOR-NDC-DESC    PIC  X(30).
    //     10 QBP511-ITOR-NDCD        PIC  X(01).
    //     10 QBP511-ITOR-SQNC-NBR    PIC S9(07) COMP-3.
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
    //     10 QBP511-ITWT-IQTY        PIC S9(05) COMP-3.
    //     10 QBP511-ITWT-IWGT        PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITWT-SWGT        PIC S9(5)V9(2) COMP-3.
    //     10 QBP511-ITWT-SQNC-NBR    PIC S9(07) COMP-3.
    //
    //******************************************************************
    //*      ITND - NDC CODES             - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************57BYTES*
    //***********************************************GW02493    61BYTES*
    //01 QBP511-ITND-DATA.
    //  05 QBP511-ITND-FIELDS.
    //     10 QBP511-ITND-CODE        PIC  X(03).
    //     10 QBP511-ITND-DESC        PIC  X(30).
    //     10 QBP511-ITND-DESC-SHORT  PIC  X(15).
    //     10 QBP511-ITND-ABBR        PIC  X(04).
    //     10 QBP511-ITND-RSTR-BUY-CD PIC  X(04).
    //     10 QBP511-ITND-INV-LOC     PIC  X(01).
    //     10 QBP511-ITND-SQNC-NBR    PIC S9(07) COMP-3.
    //
    //******************************************************************
    //*      ITFE - ITEM FEES             - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************37BYTES*
    //***********************************************GW02493    41BYTES*
    //01 QBP511-ITFE-DATA.
    //  05 QBP511-ITFE-FIELDS.
    //     10 QBP511-ITFE-FEE-AMT     PIC S9(7)V9(5) COMP-3.
    //     10 QBP511-ITFE-FEE-PCT     PIC S9(7)V9(2) COMP-3.
    //     10 QBP511-ITFE-FEE-DESC    PIC  X(25).
    //     10 QBP511-ITFE-SQNC-NBR    PIC S9(07) COMP-3.
    //
    //******************************************************************
    //*      ITTX - ITEM TAXES            - LEVEL 3                    *
    //*             (MULTIPLE RECORDS PER ITEM)                        *
    //**********************************************************21BYTES*
    //***********************************************GW02493    25BYTES*
    //01 QBP511-ITTX-DATA.
    //  05 QBP511-ITTX-FIELDS.
    //     10 QBP511-ITTX-AMOUNT      PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITTX-TAX-EMBD    PIC  X(01).
    //     10 QBP511-ITTX-PERCENT     PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITTX-PCNT-COST   PIC S9(4)V9(5) COMP-3.
    //     10 QBP511-ITTX-PCNT-BASIS  PIC  X(01).
    //     10 QBP511-ITTX-STATE-LOC   PIC  X(01).
    //     10 QBP511-ITTX-COUNTY-LOC  PIC  X(01).
    //     10 QBP511-ITTX-CITY-LOC    PIC  X(01).
    //     10 QBP511-ITTX-OTHER-LOC   PIC  X(01).
    //     10 QBP511-ITTX-SQNC-NBR    PIC S9(07) COMP-3.
    //*

    //private final Integer lrecl;
    //QBP511CrecTypes rt;
    public QBP511CC(String hexString, String charString) throws Exception {
        super();

        this.lvl1 = false;
        this.lvl2 = false;
        this.lvl3 = false;

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
        this.l10_QBP511_KITM_TYPE = subString(charString, 2); //00 ITEM, 10 ITOR, 20 ITAL, 30 ITSC, 40 ITWT, 50 ITND, 60 ITFE, 70 ITTX, 99 IVBT
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

        System.out.println();
        if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "00")) {
            //00 INVC - INVOICE MASTER DATA								LEVEL 1	467 BYTES
            QBP511_INVC_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "20")) {
            //20 ICNT - CONTACTS FOR THE WAREHOUSE SHIP FROM ADDRESS	LEVEL 1 164 BYTES
            QBP511_ICNT_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "60")) {
            //60 IMFE - INVOICE MASTER FEES								LEVEL 1  37 BYTES
            QBP511_IMFE_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "65")) {
            //65 IMTF - INVOICE TOTAL FEES								LEVEL 1  37 BYTES
            QBP511_IMTF_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "80")) {
            //80 IMLI - LICENSE NUMBERS									LEVEL 1 360 BYTES
            QBP511_IMLI_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "85")) {
            //85 IMLD - LICENSE DESC									LEVEL 1 462 BYTES
            QBP511_IMLD_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVC_TYPE, "99")) {
            //99 INVT - INVOICE TOTALS									LEVEL 1 193 BYTES
            QBP511_INVT_DATA(dataHex, dataChar);
        } else if (StringUtils.equals(l10_QBP511_KNVB_TYPE, "00")) {
            //00 INVB - INVOICE BREAKER                                 LEVEL 2 134 BYTES
            QBP511_INVB_DATA(dataHex, dataChar);
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

            //00 ITEX - INVOICE DETAIL                                  LEVEL3  478 BYTES
            //QBP511_ITEX_DATA(dataHex, dataChar);
            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITEX = ");
            System.out.print(StringUtils.substring(charString, currentIndex));
            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "00 ITEX ITEM EXCEPTION", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "10")) {
            //10 ITOR - INVOICE DETAIL                                  LEVEL3  144 BYTES
            //QBP511_ITOR_DATA(dataHex, dataChar);

            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITOR = ");
            System.out.print(StringUtils.substring(charString, currentIndex));
            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "10 ITOR ORIGINAL OF SUB", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "20")) {
            //20 ITAL - ITEM ALLOWANCES                                  LEVEL3  95 BYTES
            QBP511_ITAL_DATA(dataHex, dataChar);

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "20 ITAL ITEM ALLOWANCES", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "30")) {
            //30 ITSC - SHIPPER COMPONENTS                                LEVEL3  74 BYTES
            QBP511_ITSC_DATA(dataHex, dataChar);

        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "40")) {
            //40 ITWT - RANDOM WEIGHTS                                    LEVEL3  15 BYTES
            //QBP511_ITWT_DATA(dataHex, dataChar);

            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITWT = ");
            System.out.print(StringUtils.substring(charString, currentIndex));
            System.out.print("   Sub Key = ");
            System.out.print(l15_QBP511_KTWT_SEQN + "|");

            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "40 ITWT RANDOM WEIGHTS", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "50")) {
            //50 ITND - NDC CODES                                       LEVEL3  61 BYTES
            //QBP511_ITND_DATA(dataHex, dataChar);

            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITND = ");
            System.out.print(StringUtils.substring(charString, currentIndex));

            System.out.print("   Sub Key = ");
            System.out.print(l15_QBP511_KTND_SEQN + "|");

            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "50 ITND NDC CODES", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "60")) {
            //60 ITFE - NDC CODES                                       LEVEL3  41 BYTES
            //QBP511_ITFE_DATA(dataHex, dataChar);

            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITFE = ");
            System.out.print(StringUtils.substring(charString, currentIndex));

            System.out.print("   Sub Key = ");
            System.out.print(l15_QBP511_KTFE_FEE_CODE + "|");
            System.out.print(l15_QBP511_KTFE_FEE_CUST + "|");

            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "60 ITFE ITEM FEES", dataChar);
        } else if (StringUtils.equals(l10_QBP511_KITM_TYPE, "70")) {
            //70 ITTX - ITEM TAXES                                       LEVEL3  25 BYTES
            //QBP511_ITTX_DATA(dataHex, dataChar);

            //displayLevel1();
            //displayLevel2();
            displayLevel3();
            getLevel3();

            System.out.print("* ITTX = ");
            System.out.print(StringUtils.substring(charString, currentIndex));
            System.out.print("   Sub Key = ");
            System.out.print(l15_QBP511_KTTX_LOCATION + "|");
            System.out.print(l15_QBP511_KTTX_TAX_TYPE + "|");
            System.out.print(l15_QBP511_KTTX_TAX_CODE + "|");
            System.out.println("");

            //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "70 ITTX ITEM TAXES", dataChar);
        } else {

            //rt = new QBP511CrecTypes("Unknown", "", "unknown", dataChar);
            //TODO: 
            displayLevel1();
            displayLevel2();
            displayLevel3();

            System.out.print(StringUtils.substring(charString, currentIndex));
            System.out.println("");
            throw new Exception("Unknow type");

        }

        //private String l10_QBP511_KITM_ITEM_EX_CD;	//PIC  X     VALUE SPACE.
        //  88 QBP511-KITM-ITEM-REC            VALUE 'I'.
        //  88 QBP511-KITM-EXCPT-REC           VALUE 'E'.
        //System.out.println("");
    }

    private void QBP511_INVC_DATA(String dataHex, String dataChar) {

        String frKey = "00 INVC INVOICE MASTER";
        StringBuilder frValue = new StringBuilder();

        getLevel1();
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

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));
        fileFieldList.add(new FileField("l10_QBP511_INVC_DDAY", this.l10_QBP511_INVC_DDAY, "9(01)", 1, 1));
        fileFieldList.add(new FileField("l10_QBP511_INVC_BNAM", this.l10_QBP511_INVC_BNAM, "X(30)", 2, 31));
        fileFieldList.add(new FileField("l10_QBP511_INVC_BAD1", this.l10_QBP511_INVC_BAD1, "X(30)", 32, 61));
        fileFieldList.add(new FileField("l10_QBP511_INVC_BAD2", this.l10_QBP511_INVC_BAD2, "X(30)", 62, 91));
        fileFieldList.add(new FileField("l10_QBP511_INVC_BPHN", this.l10_QBP511_INVC_BPHN, "X(20)", 92, 111));
        fileFieldList.add(new FileField("l10_QBP511_INVC_GINA", this.l10_QBP511_INVC_GINA, "S9(10)V9(5) COMP-3", 112, 119));
        fileFieldList.add(new FileField("l10_QBP511_INVC_DIVISION", this.l10_QBP511_INVC_DIVISION, "X(02)", 120, 121));
        fileFieldList.add(new FileField("l10_QBP511_INVC_SERV_FACL", this.l10_QBP511_INVC_SERV_FACL, "X(02)", 122, 123));
        fileFieldList.add(new FileField("l10_QBP511_INVC_CIGSTAMP", this.l10_QBP511_INVC_CIGSTAMP, "X(03)", 124, 126));
        fileFieldList.add(new FileField("l10_QBP511_INVC_DFRD_INVC", this.l10_QBP511_INVC_DFRD_INVC, "X(01)", 127, 127));
        fileFieldList.add(new FileField("l10_QBP511_INVC_EQUITYNBR", this.l10_QBP511_INVC_EQUITYNBR, "S9(04) COMP", 128, 129));
        fileFieldList.add(new FileField("l10_QBP511_INVC_RP_GROUP", this.l10_QBP511_INVC_RP_GROUP, "S9(04) COMP", 130, 131));
        fileFieldList.add(new FileField("l10_QBP511_INVC_VM_XDOCK_IND", this.l10_QBP511_INVC_VM_XDOCK_IND, "X(01)", 132, 132));
        fileFieldList.add(new FileField("l10_QBP511_INVC_NAME", this.l10_QBP511_INVC_NAME, "X(27)", 133, 159));
        fileFieldList.add(new FileField("l10_QBP511_INVC_STORE_DEA_NBR", this.l10_QBP511_INVC_STORE_DEA_NBR, "X(10)", 160, 169));
        fileFieldList.add(new FileField("l10_QBP511_INVC_ADDRESS", this.l10_QBP511_INVC_ADDRESS, "X(45)", 170, 214));
        fileFieldList.add(new FileField("l10_QBP511_INVC_CITY", this.l10_QBP511_INVC_CITY, "X(45)", 215, 259));
        fileFieldList.add(new FileField("l10_QBP511_INVC_STATE", this.l10_QBP511_INVC_STATE, "X(02)", 260, 261));
        fileFieldList.add(new FileField("l10_QBP511_INVC_ZIP_CODE", this.l10_QBP511_INVC_ZIP_CODE, "X(09)", 262, 270));
        fileFieldList.add(new FileField("l10_QBP511_INVC_FEE_GRP", this.l10_QBP511_INVC_FEE_GRP, "X(05)", 271, 275));
        fileFieldList.add(new FileField("l10_QBP511_INVC_DEPT_DESC", this.l10_QBP511_INVC_DEPT_DESC, "X(30)", 276, 305));
        fileFieldList.add(new FileField("l10_QBP511_INVC_TIME", this.l10_QBP511_INVC_TIME, "X(08)", 306, 313));
        fileFieldList.add(new FileField("l10_QBP511_INVC_DATA_CORP_NAME", this.l10_QBP511_INVC_DATA_CORP_NAME, "X(35)", 314, 348));
        fileFieldList.add(new FileField("l10_QBP511_INVC_WHSE_DEA_NBR", this.l10_QBP511_INVC_WHSE_DEA_NBR, "X(10)", 349, 358));
        fileFieldList.add(new FileField("l10_QBP511_INVC_XDOCK_DEA_NBR", this.l10_QBP511_INVC_XDOCK_DEA_NBR, "X(10)", 359, 368));
        fileFieldList.add(new FileField("l10_QBP511_INVC_XDOCK_ADDRESS", this.l10_QBP511_INVC_XDOCK_ADDRESS, "X(45)", 369, 413));
        fileFieldList.add(new FileField("l10_QBP511_INVC_XDOCK_CITY", this.l10_QBP511_INVC_XDOCK_CITY, "X(45)", 414, 458));
        fileFieldList.add(new FileField("l10_QBP511_INVC_XDOCK_STATE", this.l10_QBP511_INVC_XDOCK_STATE, "X(02)", 459, 460));
        fileFieldList.add(new FileField("l10_QBP511_INVC_XDOCK_ZIP_CODE", this.l10_QBP511_INVC_XDOCK_ZIP_CODE, "X(09)", 461, 469));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("INVC = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_ICNT_DATA(String dataHex, String dataChar) {

        String frKey = "20 ICNT CONTACTS";
        StringBuilder frValue = new StringBuilder();

        getLevel1();
        currentIndex = 0;

        this.l10_QBP511_ICNT_CONTACT = subString(dataChar, 10);	//PIC  X(10).
        this.l10_QBP511_ICNT_ADDRESS = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_ICNT_CITY = subString(dataChar, 45);	//PIC  X(45).
        this.l10_QBP511_ICNT_STATE = subString(dataChar, 2);		//PIC  X(02).
        this.l10_QBP511_ICNT_ZIP_CODE = subString(dataChar, 9);		//PIC  X(09).

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));
        fileFieldList.add(new FileField("l10_QBP511_ICNT_CONTACT", this.l10_QBP511_ICNT_CONTACT, "X(10)", 1, 10));
        fileFieldList.add(new FileField("l10_QBP511_ICNT_ADDRESS", this.l10_QBP511_ICNT_ADDRESS, "X(45)", 11, 55));
        fileFieldList.add(new FileField("l10_QBP511_ICNT_CITY", this.l10_QBP511_ICNT_CITY, "X(45)", 56, 100));
        fileFieldList.add(new FileField("l10_QBP511_ICNT_STATE", this.l10_QBP511_ICNT_STATE, "X(02)", 101, 102));
        fileFieldList.add(new FileField("l10_QBP511_ICNT_ZIP_CODE", this.l10_QBP511_ICNT_ZIP_CODE, "X(09)", 103, 111));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("ICNT = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IMFE_DATA(String dataHex, String dataChar) {

        String frKey = "60 IMFE INVOICE MASTER FEES";
        StringBuilder frValue = new StringBuilder();

        getLevel1();
        currentIndex = 0;

        this.l10_QBP511_IMFE_FEE_AMT = subStringComp3(dataHex, 7, 8, 5);	//PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IMFE_FEE_PCT = subStringComp3(dataHex, 5, 7, 2);	//PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_IMFE_FEE_DESC = subString(dataChar, 25);				//PIC  X(25).

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        fileFieldList.add(new FileField("l15_QBP511_KMFE_FEE_CODE", this.l15_QBP511_KMFE_FEE_CODE, "X(05)", 0, 0));
        fileFieldList.add(new FileField("l15_QBP511_KMFE_FEE_CUST", this.l15_QBP511_KMFE_FEE_CUST, "X(05)", 0, 0));
        fileFieldList.add(new FileField("l10_QBP511_IMFE_FEE_AMT", this.l10_QBP511_IMFE_FEE_AMT, "S9(7)V9(5) COMP-3", 1, 7));
        fileFieldList.add(new FileField("l10_QBP511_IMFE_FEE_PCT", this.l10_QBP511_IMFE_FEE_PCT, "S9(7)V9(2) COMP-3", 8, 12));
        fileFieldList.add(new FileField("l10_QBP511_IMFE_FEE_DESC", this.l10_QBP511_IMFE_FEE_DESC, "X(25)", 13, 37));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("IMFE = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IMTF_DATA(String dataHex, String dataChar) {

        String frKey = "65 IMTF INVOICE TOTAL FEES";
        StringBuilder frValue = new StringBuilder();

        getLevel1();
        currentIndex = 0;

        this.l10_QBP511_IMTF_FEE_AMT = subStringComp3(dataHex, 7, 8, 5);	//PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IMTF_FEE_PCT = subStringComp3(dataHex, 5, 5, 4);	//PIC S9(5)V9(4) COMP-3.
        this.l10_QBP511_IMTF_FEE_DESC = subString(dataChar, 25);			//PIC  X(25).

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));
        fileFieldList.add(new FileField("l15_QBP511_KMTF_FEE_CODE", this.l15_QBP511_KMTF_FEE_CODE, "X(05)", 0, 0));
        fileFieldList.add(new FileField("l10_QBP511_IMTF_FEE_AMT", this.l10_QBP511_IMTF_FEE_AMT, "S9(7)V9(5) COMP-3", 1, 7));
        fileFieldList.add(new FileField("l10_QBP511_IMTF_FEE_PCT", this.l10_QBP511_IMTF_FEE_PCT, "S9(7)V9(2) COMP-3", 8, 12));
        fileFieldList.add(new FileField("l10_QBP511_IMTF_FEE_DESC", this.l10_QBP511_IMTF_FEE_DESC, "X(25)", 13, 37));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("IMTF = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IMLI_DATA(String dataHex, String dataChar) {

        String frKey = "80 IMLI - LICENSE NUMBERS";
        StringBuilder frValue = new StringBuilder();

        getLevel1();

        currentIndex = 0;
        //this.l10_QBP511_IMLI_WHSE_LICENSE_DATA = subString(dataChar, 180);
        //this.l10_QBP511_IMLI_STR_LICENSE_DATA = subString(dataChar, 180);

        currentIndex = 0;

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();                           //TODO: need to fix the start and end numbers
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 1, 15));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 16, 18));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 19, 33));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 34, 36));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 37, 51));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 52, 54));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 55, 69));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 70, 72));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 73, 87));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 88, 90));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 91, 105));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 106, 108));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 109, 123));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 124, 126));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 127, 141));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 142, 144));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 145, 159));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 160, 162));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE", subString(dataChar, 15), "X(15)", 163, 177));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_WHSE_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 178, 180));

        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 181, 195));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 196, 198));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 199, 213));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 214, 216));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 217, 231));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 232, 234));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 235, 249));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 250, 252));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 253, 267));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 268, 270));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 271, 285));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 286, 288));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 289, 303));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 304, 306));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 307, 321));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 322, 324));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 325, 339));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 340, 342));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE", subString(dataChar, 15), "X(15)", 343, 357));
        fileFieldList.add(new FileField("l15_QBP511_IMLI_STR_LICENSE_TYPE", subString(dataChar, 3), "X(03)", 358, 360));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("IMLI = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IMLD_DATA(String dataHex, String dataChar) {

        String frKey = "85 IMLD - LICENSE DESC";
        StringBuilder frValue = new StringBuilder();

        getLevel1();

        currentIndex = 0;

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 1, 3));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 4, 33));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 34, 36));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 37, 66));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 67, 69));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 70, 99));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 100, 102));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 103, 132));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 133, 135));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 136, 165));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 166, 168));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 169, 198));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 199, 201));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 202, 231));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 232, 234));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 235, 264));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 265, 267));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 268, 297));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 298, 300));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 301, 330));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 331, 333));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 334, 363));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 364, 366));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 367, 396));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 397, 399));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 400, 429));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_TYPE", subString(dataChar, 3), "X(3)", 430, 432));
        fileFieldList.add(new FileField("l15_QBP511_IMLD_LICENSE_DESC", subString(dataChar, 30), "X(30)", 433, 462));
        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();
        System.out.print("IMLD = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_INVT_DATA(String dataHex, String dataChar) {

        String frKey = "99 INVT INVOICE TOTALS";
        StringBuilder frValue = new StringBuilder();

        getLevel1();
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

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        currentIndex = 1;
        fileFieldList.add(buildFileField("l10_QBP511_INVT_ENDING_INVC_NO", this.l10_QBP511_INVT_ENDING_INVC_NO, 4, "S9(7) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_BREAKER", this.l10_QBP511_INVT_BREAKER, 3, "9(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_STMNT_DT", this.l10_QBP511_INVT_STMNT_DT, 8, " 9(8)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_WEIGHT", this.l10_QBP511_INVT_WEIGHT, 4, "S9(5)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_CUBE", this.l10_QBP511_INVT_CUBE, 4, "S9(6)V9  COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_PALLET", this.l10_QBP511_INVT_PALLET, 2, "S9(3)    COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_PIECES", this.l10_QBP511_INVT_PIECES, 3, "S9(5)    COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_ORDERED", this.l10_QBP511_INVT_ORDERED, 3, "S9(5)    COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_SHIPPED", this.l10_QBP511_INVT_SHIPPED, 3, "S9(5)    COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_CIG_PIECES", this.l10_QBP511_INVT_CIG_PIECES, 5, "S9(9)    COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_MEAT", this.l10_QBP511_INVT_MEAT, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_GROCERY", this.l10_QBP511_INVT_GROCERY, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_FROZEN_FOOD", this.l10_QBP511_INVT_FROZEN_FOOD, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_STORE_SUPPLY", this.l10_QBP511_INVT_STORE_SUPPLY, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_STRE_SUPP_TAX", this.l10_QBP511_INVT_STRE_SUPP_TAX, 4, "S9(5)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_STRE_SUPP_ATCOST", this.l10_QBP511_INVT_STRE_SUPP_ATCOST, 4, "S9(5)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_GROSS_PROFITS", this.l10_QBP511_INVT_GROSS_PROFITS, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_SELL", this.l10_QBP511_INVT_SELL, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_COST", this.l10_QBP511_INVT_COST, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_RETAIL", this.l10_QBP511_INVT_RETAIL, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_PROD_COST", this.l10_QBP511_INVT_PROD_COST, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_RTL_PRICE", this.l10_QBP511_INVT_RTL_PRICE, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_N_ALLOW", this.l10_QBP511_INVT_N_ALLOW, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_REG_PROMO", this.l10_QBP511_INVT_REG_PROMO, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_REG_FRZ_PROMO", this.l10_QBP511_INVT_REG_FRZ_PROMO, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_PERF_ALLOW", this.l10_QBP511_INVT_PERF_ALLOW, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_OTHER_ALLOW", this.l10_QBP511_INVT_OTHER_ALLOW, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_FEES", this.l10_QBP511_INVT_FEES, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_DLV_FEES", this.l10_QBP511_INVT_DLV_FEES, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_HANDBILL_FEES", this.l10_QBP511_INVT_HANDBILL_FEES, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_OTHER_FEES", this.l10_QBP511_INVT_OTHER_FEES, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_PALLET_ALLOW", this.l10_QBP511_INVT_PALLET_ALLOW, 6, "S9(9)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_TOBACCO_TAX", this.l10_QBP511_INVT_TOBACCO_TAX, 5, "S9(7)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_TOBACCO_SALES", this.l10_QBP511_INVT_TOBACCO_SALES, 5, "S9(7)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_OASIS_CLASS", this.l10_QBP511_INVT_OASIS_CLASS, 1, "X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_OASIS_FACILITY", this.l10_QBP511_INVT_OASIS_FACILITY, 4, "X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_DEFERED_INDC", this.l10_QBP511_INVT_DEFERED_INDC, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVT_DIR_DELV_IND", this.l10_QBP511_INVT_DIR_DELV_IND, 1, "X"));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel1();

        System.out.print("INVT = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_INVB_DATA(String dataHex, String dataChar) {

        String frKey = "00 INVB - INVOICE BREAKER";
        StringBuilder frValue = new StringBuilder();
        getLevel2();
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

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        currentIndex = 1;
        fileFieldList.add(buildFileField("l10_QBP511_INVB_DDAT", this.l10_QBP511_INVB_DDAT, 8, "9(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_DDAY", this.l10_QBP511_INVB_DDAY, 1, "9(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_ROUT", this.l10_QBP511_INVB_ROUT, 4, "X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_STOP", this.l10_QBP511_INVB_STOP, 3, "X(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_SHP_DT", this.l10_QBP511_INVB_SHP_DT, 8, "9(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_SHP_TM", this.l10_QBP511_INVB_SHP_TM, 8, "X(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_RLS_TM", this.l10_QBP511_INVB_RLS_TM, 8, "X(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_ORTP_DESC", this.l10_QBP511_INVB_ORTP_DESC, 45, "X(45)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_FEE_GRP", this.l10_QBP511_INVB_FEE_GRP, 5, "X(05)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_SOURCE", this.l10_QBP511_INVB_SOURCE, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_SOLD_AT_COST", this.l10_QBP511_INVB_SOLD_AT_COST, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_WILLCALL", this.l10_QBP511_INVB_WILLCALL, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_HANDBILL", this.l10_QBP511_INVB_HANDBILL, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_DIRECT_DLVRY", this.l10_QBP511_INVB_DIRECT_DLVRY, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_DEPT_DESC", this.l10_QBP511_INVB_DEPT_DESC, 30, "X(30)"));
        fileFieldList.add(buildFileField("l10_QBP511_INVB_RLS_DT", this.l10_QBP511_INVB_RLS_DT, 8, "9(08)"));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel2();

        System.out.print("INVB = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IBFE_DATA(String dataHex, String dataChar) {

        String frKey = "60 IBFE INVOICE BREAKER FEES";
        StringBuilder frValue = new StringBuilder();
        getLevel2();
        currentIndex = 0;

        this.l10_QBP511_IBFE_FEE_AMT = subStringComp3(dataHex, 7, 7, 5);  //PIC S9(7)V9(5) COMP-3.
        this.l10_QBP511_IBFE_FEE_PCT = subStringComp3(dataHex, 5, 7, 2);  //PIC S9(7)V9(2) COMP-3.
        this.l10_QBP511_IBFE_FEE_DESC = subString(dataChar, 25);           //PIC  X(25).

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        currentIndex = 1;
        fileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_AMT", this.l10_QBP511_IBFE_FEE_AMT, 7, "S9(7)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_PCT", this.l10_QBP511_IBFE_FEE_PCT, 5, "S9(7)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IBFE_FEE_DESC", this.l10_QBP511_IBFE_FEE_DESC, 25, "X(25)"));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel2();

        System.out.print("IBFE = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_IVBT_DATA(String dataHex, String dataChar) {

        String frKey = "99 IVBT INVOICE BREAK TOTALS";
        StringBuilder frValue = new StringBuilder();
        getLevel2();
        currentIndex = 0;

        this.l10_QBP511_IVBT_DEPT_DESC = subString(dataChar, 30);            //PIC X(30).
        this.l10_QBP511_IVBT_ORDERED = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_SHIPPED = subStringComp3(dataHex, 3, 5, 0);   //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_NET = subStringComp3(dataHex, 7, 11, 2);  //PIC S9(11)V99 COMP-3.
        this.l10_QBP511_IVBT_RTL = subStringComp3(dataHex, 7, 11, 2);  //PIC S9(11)V99 COMP-3.
        this.l10_QBP511_IVBT_TO_WHS = subStringComp3(dataHex, 3, 5, 0);  //PIC S9(5)     COMP-3.
        this.l10_QBP511_IVBT_GROSS_PCT = subStringComp3(dataHex, 5, 5, 4);   //PIC S9(5)V9(4) COMP-3.

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));
        currentIndex = 1;
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_DEPT_DESC", this.l10_QBP511_IVBT_DEPT_DESC, 30, "X(30)"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_ORDERED", this.l10_QBP511_IVBT_ORDERED, 3, "S9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_SHIPPED", this.l10_QBP511_IVBT_SHIPPED, 3, "S9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_NET", this.l10_QBP511_IVBT_NET, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_RTL", this.l10_QBP511_IVBT_RTL, 7, "S9(11)V99 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_TO_WHS", this.l10_QBP511_IVBT_TO_WHS, 3, "S9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_IVBT_GROSS_PCT", this.l10_QBP511_IVBT_GROSS_PCT, 5, "S9(5)V9(4) COMP-3"));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel2();

        System.out.print("IVBT = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_ITEM_DATA(String dataHex, String dataChar) {

        String frKey = "00 ITEM INVOICE DETAIL";

        StringBuilder frValue = new StringBuilder();

        getLevel3();
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
        this.l10_QBP511_ITEM_ORIG_UPC = subStringComp3(dataHex, 8, 15, 0); //PIC S9(15) COMP_3.
        this.l10_QBP511_ITEM_ORIG_UPC_IND = subString(dataChar, 1);            //PIC X(01).
        this.l10_QBP511_ITEM_ALTERNATE_VENDOR = subString(dataChar, 7);            //PIC X(07).
        this.l10_QBP511_ITEM_CALL_NBR = subString(dataChar, 4);            //PIC X(04).
        this.l10_QBP511_ITEM_BIO_ENG = subString(dataChar, 1);            //PIC X(01).

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();
        fileFieldList.add(new FileField("l10_QBP511_DATA_LENGTH", this.l10_QBP511_DATA_LENGTH.toString(), "9(04) COMP", 0, 0));

        currentIndex = 1;

        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SQNC_NBR", this.l10_QBP511_ITEM_SQNC_NBR, 4, "S9(07) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DEP_BREAK", this.l10_QBP511_ITEM_DEP_BREAK, 5, " X(05)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_INV_DEPT", this.l10_QBP511_ITEM_INV_DEPT, 2, " X(02)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_ZONE", this.l10_QBP511_ITEM_RTL_ZONE, 4, " X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CNTRY_ORG", this.l10_QBP511_ITEM_CNTRY_ORG, 30, " X(30)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_ITEM", this.l10_QBP511_ITEM_ORIG_ITEM, 7, " X(07)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CMP_ITEM", this.l10_QBP511_ITEM_CMP_ITEM, 7, " X(07)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SUBO", this.l10_QBP511_ITEM_SUBO, 7, " X(07)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SUBS", this.l10_QBP511_ITEM_SUBS, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DEFR_DT", this.l10_QBP511_ITEM_DEFR_DT, 8, " 9(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_GR_NET_INV", this.l10_QBP511_ITEM_GR_NET_INV, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PLCD", this.l10_QBP511_ITEM_PLCD, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_MPCK", this.l10_QBP511_ITEM_MPCK, 4, "S9(07) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SPCK", this.l10_QBP511_ITEM_SPCK, 4, "S9(07) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SIZE", this.l10_QBP511_ITEM_SIZE, 15, " X(15)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_OQTY", this.l10_QBP511_ITEM_OQTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_AQTY", this.l10_QBP511_ITEM_AQTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SQTY", this.l10_QBP511_ITEM_SQTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_IQTY", this.l10_QBP511_ITEM_IQTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_OADJ", this.l10_QBP511_ITEM_OADJ, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PLT_QTY", this.l10_QBP511_ITEM_PLT_QTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_NBR_OF_PLTS", this.l10_QBP511_ITEM_NBR_OF_PLTS, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CASE_QTY", this.l10_QBP511_ITEM_CASE_QTY, 3, "S9(05) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DEAL_CNTR", this.l10_QBP511_ITEM_DEAL_CNTR, 2, "S9(03) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_CPO_FL", this.l10_QBP511_ITEM_SHP_CPO_FL, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BILL_AVG_FL", this.l10_QBP511_ITEM_BILL_AVG_FL, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RWI", this.l10_QBP511_ITEM_RWI, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_IWGT", this.l10_QBP511_ITEM_IWGT, 4, "S9(5)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CWGT", this.l10_QBP511_ITEM_CWGT, 4, "S9(5)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CUBE", this.l10_QBP511_ITEM_CUBE, 5, "S9(6)V9(3) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SCST", this.l10_QBP511_ITEM_SCST, 5, "S9(4)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_NET_SELL", this.l10_QBP511_ITEM_NET_SELL, 5, "S9(5)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_UNT_NET_SELL", this.l10_QBP511_ITEM_UNT_NET_SELL, 5, "S9(5)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_CRET", this.l10_QBP511_ITEM_RTL_CRET, 4, "S9(5)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_PRICE", this.l10_QBP511_ITEM_RTL_PRICE, 5, "S9(7)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_RTL_PRICE", this.l10_QBP511_ITEM_EXT_RTL_PRICE, 6, "S9(7)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RTL_CFOR", this.l10_QBP511_ITEM_RTL_CFOR, 2, "S9(3) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_GINA", this.l10_QBP511_ITEM_GINA, 6, "S9(6)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BSP_AMT", this.l10_QBP511_ITEM_BSP_AMT, 5, "S9(4)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_INVV", this.l10_QBP511_ITEM_INVV, 5, "S9(4)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_IDIS", this.l10_QBP511_ITEM_IDIS, 5, "S9(4)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_COST", this.l10_QBP511_ITEM_EXT_COST, 5, "S9(7)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_CATA", this.l10_QBP511_ITEM_EXT_CATA, 5, "S9(7)V9(2) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_EXT_NET_SELL", this.l10_QBP511_ITEM_EXT_NET_SELL, 6, "S9(7)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_FEES_AMT", this.l10_QBP511_ITEM_FEES_AMT, 7, "S9(8)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_ALWNC_AMT", this.l10_QBP511_ITEM_ALWNC_AMT, 6, "S9(6)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_TAX_AMT", this.l10_QBP511_ITEM_TAX_AMT, 7, "S9(7)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DLVRY_PCT", this.l10_QBP511_ITEM_DLVRY_PCT, 3, "S9(1)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PROF_PCT", this.l10_QBP511_ITEM_PROF_PCT, 5, "S9(5)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_GROSS_PCT", this.l10_QBP511_ITEM_GROSS_PCT, 5, "S9(5)V9(4) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DSDT", this.l10_QBP511_ITEM_DSDT, 8, " 9(8)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BUYR", this.l10_QBP511_ITEM_BUYR, 3, " X(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CSS_BUYR", this.l10_QBP511_ITEM_CSS_BUYR, 3, " X(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_VEND", this.l10_QBP511_ITEM_VEND, 7, " X(07)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_WPHI", this.l10_QBP511_ITEM_WPHI, 2, "S9(3) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_WPTI", this.l10_QBP511_ITEM_WPTI, 2, "S9(3) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_INV_TYPE", this.l10_QBP511_ITEM_INV_TYPE, 1, " X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SECTION", this.l10_QBP511_ITEM_SECTION, 1, "X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BLL_NXT_AVL", this.l10_QBP511_ITEM_BLL_NXT_AVL, 10, "X(10)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PGM_CTRL_ID", this.l10_QBP511_ITEM_PGM_CTRL_ID, 6, "X(06)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RSTR_BUY_CD", this.l10_QBP511_ITEM_RSTR_BUY_CD, 4, "X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_DT", this.l10_QBP511_ITEM_SHP_DT, 8, "9(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SHP_TM", this.l10_QBP511_ITEM_SHP_TM, 8, "X(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RLS_TM", this.l10_QBP511_ITEM_RLS_TM, 8, "X(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_FEE_GRP", this.l10_QBP511_ITEM_FEE_GRP, 5, "X(05)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SOURCE", this.l10_QBP511_ITEM_SOURCE, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SOLD_AT_COST", this.l10_QBP511_ITEM_SOLD_AT_COST, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_WILLCALL", this.l10_QBP511_ITEM_WILLCALL, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_HANDBILL", this.l10_QBP511_ITEM_HANDBILL, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_DIRECT_DLVRY", this.l10_QBP511_ITEM_DIRECT_DLVRY, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CMDTY", this.l10_QBP511_ITEM_CMDTY, 3, "X(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SUB_CMDTY", this.l10_QBP511_ITEM_SUB_CMDTY, 3, "X(03)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_HAZ_IND", this.l10_QBP511_ITEM_HAZ_IND, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_IVL_ORTP", this.l10_QBP511_ITEM_IVL_ORTP, 1, "X"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_SOT_AMT", this.l10_QBP511_ITEM_SOT_AMT, 6, "S9(6)V9(5) COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PALT", this.l10_QBP511_ITEM_PALT, 30, "X(30)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BRAND", this.l10_QBP511_ITEM_BRAND, 20, "X(20)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PALT2", this.l10_QBP511_ITEM_PALT2, 30, "X(30)"));
        fileFieldList.add(buildFileField("l10_FILLER", this.l10_FILLER, 20, "X(20)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_OASIS_CLASS", this.l10_QBP511_ITEM_OASIS_CLASS, 1, "X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_OASIS_FACILITY", this.l10_QBP511_ITEM_OASIS_FACILITY, 4, "X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_RLS_DT", this.l10_QBP511_ITEM_RLS_DT, 8, "9(08)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_PCT_MKUP", this.l10_QBP511_ITEM_PCT_MKUP, 5, "9(5)V9999 COMP-3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_UPC", this.l10_QBP511_ITEM_ORIG_UPC, 8, "S9(15) COMP_3"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_ORIG_UPC_IND", this.l10_QBP511_ITEM_ORIG_UPC_IND, 1, "X(01)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_ALTERNATE_VENDOR", this.l10_QBP511_ITEM_ALTERNATE_VENDOR, 7, "X(07)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_CALL_NBR", this.l10_QBP511_ITEM_CALL_NBR, 4, "X(04)"));
        fileFieldList.add(buildFileField("l10_QBP511_ITEM_BIO_ENG", this.l10_QBP511_ITEM_BIO_ENG, 1, "X(01)"));

        for (int i = 1; i < fileFieldList.size(); i++) {
            frValue.append(fileFieldList.get(i).getRecTypeValue()).append("|");
        }

        this.subRecFR = new FileRecord(frKey, frValue.toString(), "", fileFieldList, dataHex, dataChar);

        displayLevel3();

        System.out.print("ITEM = " + frValue.toString());
        System.out.println("");

    }

    private void QBP511_ITSC_DATA(String dataHex, String dataChar) {

        //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "30 ITSC SHIPPER COMPONENTS", dataChar);
        getLevel3();
        currentIndex = 0;

        //******************************************************************
        //*      ITSC - SHIPPER COMPONENTS    - LEVEL 3                    *
        //*             (MULTIPLE RECORDS PER ITEM)                        *
        //***********************************************GW02493    74BYTES*
        //01 QBP511-ITSC-DATA.
        //  05 QBP511-ITSC-FIELDS.
        this.l10_QBP511_ITSC_DESC = subString(dataChar, 30);          //PIC  X(30).
        this.l10_QBP511_ITSC_SIZE = subString(dataChar, 15);          //PIC  X(15).
        this.l10_QBP511_ITSC_QTY_UNT = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.
        this.l10_QBP511_ITSC_CST_UNT = subStringComp3(dataHex, 6, 6, 5); //PIC S9(6)V9(5) COMP-3.
        this.l10_QBP511_ITSC_RTL_MLT = subStringComp3(dataHex, 2, 3, 0); //PIC S9(03) COMP-3.
        this.l10_QBP511_ITSC_CPO_RTL = subStringComp3(dataHex, 4, 4, 3); //PIC S9(4)V9(3) COMP-3.
        this.l10_QBP511_ITSC_EXT_RTL_PRICE = subStringComp3(dataHex, 6, 7, 4); //PIC S9(7)V9(4) COMP-3.
        this.l10_QBP511_ITSC_SOURCE = subString(dataChar, 3);           //PIC  X(03).
        this.l10_QBP511_ITSC_SQNC_NBR = subStringComp3(dataHex, 4, 7, 0); //PIC S9(07) COMP-3.
        this.l10_QBP511_ITSC_BIO_ENG = subString(dataChar, 1);           //PIC  X(03).

        //displayLevel1();
        //displayLevel2();
        displayLevel3();

        System.out.print("ITSC = ");
        System.out.print(this.l10_QBP511_ITSC_DESC + "|"); //PIC  X(30).
        System.out.print(this.l10_QBP511_ITSC_SIZE + "|"); //PIC  X(15).
        System.out.print(this.l10_QBP511_ITSC_QTY_UNT + "|"); //PIC S9(07) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_CST_UNT + "|"); //PIC S9(6)V9(5) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_RTL_MLT + "|"); //PIC S9(03) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_CPO_RTL + "|"); //PIC S9(4)V9(3) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_EXT_RTL_PRICE + "|"); //PIC S9(7)V9(4) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_SOURCE + "|"); //PIC  X(03).
        System.out.print(this.l10_QBP511_ITSC_SQNC_NBR + "|"); //PIC S9(07) COMP-3.
        System.out.print(this.l10_QBP511_ITSC_BIO_ENG + "|"); //PIC  X(01).

        System.out.print("   Sub Key = ");
        System.out.print(l15_QBP511_KTSC_CPO_UPC + "|");
        System.out.print(l15_QBP511_KTSC_CPO_ITEM + "|");

        System.out.println("");

    }

    private void QBP511_ITAL_DATA(String dataHex, String dataChar) {

        //rt = new QBP511CrecTypes("        l3 KITM - INVOICE DETAIL/ITEM", getLevel3(), "20 ITAL ITEM ALLOWANCES", dataChar);
        getLevel3();
        currentIndex = 0;

        //******************************************************************
        //*      ITAL - ITEM ALLOWANCES       - LEVEL 3                    *
        //*             (MULTIPLE RECORDS PER ITEM)                        *
        //**********************************************************95BYTES*
        //***********************************************GW02493    99BYTES*
        //01 QBP511-ITAL-DATA.
        //  05 QBP511-ITAL-FIELDS.
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

        //displayLevel1();
        //displayLevel2();
        displayLevel3();

        System.out.print("ITAL = ");
        System.out.print(this.L10_QBP511_ITAL_AMOUNT + "|");       //PIC S9(4)V9(5) COMP-3.
        System.out.print(this.l10_QBP511_ITAL_PM_NET + "|");       //PIC S9(5)V9(4) COMP-3.
        System.out.print(this.l10_QBP511_ITAL_DESC_SHORT + "|");   //PIC  X(15).
        System.out.print(this.l10_QBP511_ITAL_DESC + "|");         //PIC  X(30).
        System.out.print(this.l10_QBP511_ITAL_N_CST + "|");        //PIC  X(01).
        System.out.print(this.l10_QBP511_ITAL_BUYER_ID + "|");     //PIC  X(03).
        System.out.print(this.l10_QBP511_ITAL_DEAL_NBR + "|");     //PIC  9(04)     COMP.
        System.out.print(this.l10_QBP511_ITAL_DEAL_TYPE + "|");    //PIC  X(01).
        System.out.print(this.l10_QBP511_ITAL_TYPE_EXP + "|");     //PIC  X(01).
        System.out.print(this.l10_QBP511_ITAL_PROMO_PGM + "|");    //PIC  X(01).
        System.out.print(this.l10_QBP511_ITAL_DEAL_AMT + "|");     //PIC S9(7)V9(2) COMP-3.
        System.out.print(this.l10_QBP511_ITAL_START_DT + "|");     //PIC  9(08).
        System.out.print(this.l10_QBP511_ITAL_END_DT + "|");       //PIC  9(08).
        System.out.print(this.l10_QBP511_ITAL_EXT_ALWNC + "|");    //PIC S9(8)V9(5) COMP-3.
        System.out.print(this.l10_QBP511_ITAL_PROMO_ID + "|");     //PIC  X(04).
        System.out.print(this.l10_QBP511_ITAL_SQNC_NBR + "|");     //PIC S9(07) COMP-3.
        System.out.print(this.l10_QBP511_ITAL_DEAL_CD + "|");      //PIC  X(07).
        System.out.print(this.l10_QBP511_ITAL_VEND + "|");         //PIC  X(07).                     
        System.out.print(this.l10_QBP511_ITAL_EXT_GRP_ID + "|");   //PIC  X(20).                     
        System.out.print(this.l10_QBP511_ITAL_EXT_ARB_ID + "|");   //PIC  X(20).                     
        System.out.print(this.l10_QBP511_ITAL_EXT_FEE_TYPE + "|"); //PIC X.                         
        System.out.print(this.l10_QBP511_ITAL_EXT_FEE_AMT + "|");  //PIC S9(5)V9(2) COMP-3.    

        System.out.print("   Sub Key = ");
        System.out.print(l15_QBP511_KTAL_ABBR + "|");
        System.out.print(l15_QBP511_KTAL_TS + "|");

        System.out.println("");

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
        Integer intValue = Integer.parseInt(hexValue, 16);

        return intValue.toString();

    }

    private String subStringComp3(String hexString, Integer length, Integer intLength, Integer decLength) {

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
        String decimalPoint = ".";
        if (decLength == 0) {
            decimalPoint = "";
        }
        //System.out.println(comp3 + "|" + whole + "|" + decimal + "|" + sign);
        //System.out.println("****************************");

        return sign + whole + decimalPoint + decimal;

    }

    private void displayLevel1() {

        System.out.print("KNVC(lvl1) = ");
        System.out.print(l10_QBP511_KNVC_IVNO + "|");
        System.out.print(l10_QBP511_KNVC_IVDT + "|");
        System.out.print(l15_QBP511_KNVC_FACL + "|");
        System.out.print(l15_QBP511_KNVC_WHSE + "|");
        System.out.print(l10_QBP511_KNVC_STOR + "|");
        System.out.print(l10_QBP511_KNVC_TYPE + "|");
        System.out.print(this.l10_QBP511_KNVC_ROUT + "|");
        System.out.print(this.l10_QBP511_KNVC_STOP + "|");
        System.out.print(this.l10_QBP511_KNVC_DDAT + "|");
        System.out.print(this.l10_QBP511_KNVC_CPY_CD + "|");
        System.out.print(this.l10_QBP511_KNVC_ROUT_PRC_FL + "|");
        System.out.print(this.l10_QBP511_KNVC_CPY_SRT_BY + "|");
        System.out.println("");

    }

    private void getLevel1() {

        this.lvl1 = true;

        String frKey = "L1 KNVC - INVOICE MASTER";
        StringBuilder frValue = new StringBuilder();
        StringBuilder frCompare = new StringBuilder();

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

        frCompare.append(this.l10_QBP511_KNVC_IVNO).append("|");
        frCompare.append(this.l10_QBP511_KNVC_IVDT).append("|");
        frCompare.append(this.l15_QBP511_KNVC_FACL).append("|");
        frCompare.append(this.l15_QBP511_KNVC_WHSE).append("|");
        frCompare.append(this.l10_QBP511_KNVC_STOR).append("|");
        //frCompare.append(this.l10_QBP511_KNVC_TYPE + "|");
        frCompare.append(this.l10_QBP511_KNVC_ROUT).append("|");
        frCompare.append(this.l10_QBP511_KNVC_STOP).append("|");
        frCompare.append(this.l10_QBP511_KNVC_DDAT).append("|");
        frCompare.append(this.l10_QBP511_KNVC_CPY_CD).append("|");
        frCompare.append(this.l10_QBP511_KNVC_ROUT_PRC_FL).append("|");
        frCompare.append(this.l10_QBP511_KNVC_CPY_SRT_BY).append("|");

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();

        fileFieldList.add(new FileField("l10_QBP511_KNVC_IVNO", l10_QBP511_KNVC_IVNO, "9(07)", 1, 7));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_IVDT", l10_QBP511_KNVC_IVNO, "9(08)", 8, 15));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_FWHS", l10_QBP511_KNVC_FWHS, "", 16, 19));
        fileFieldList.add(new FileField("l15_QBP511_KNVC_FACL", l15_QBP511_KNVC_FACL, "X(02)", 16, 17));
        fileFieldList.add(new FileField("l15_QBP511_KNVC_WHSE", l15_QBP511_KNVC_WHSE, "X(02)", 18, 19));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_STOR", l10_QBP511_KNVC_STOR, "9(05)", 20, 24));
        //fileFieldList.add(new FileField("l10_QBP511_KNVC_TYPE",      l10_QBP511_KNVC_TYPE,        "X(02)", 25, 26));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_ROUT", l10_QBP511_KNVC_ROUT, "X(04)", 27, 30));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_STOP", l10_QBP511_KNVC_STOP, "X(03)", 31, 33));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_DDAT", l10_QBP511_KNVC_DDAT, "9(08)", 34, 41));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_CPY_CD", l10_QBP511_KNVC_CPY_CD, "X(05)", 42, 46));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_ROUT_PRC_FL", l10_QBP511_KNVC_ROUT_PRC_FL, "X(01)", 47, 47));
        fileFieldList.add(new FileField("l10_QBP511_KNVC_CPY_SRT_BY", l10_QBP511_KNVC_CPY_SRT_BY, "X(03)", 48, 50));

        this.levelFR = new FileRecord(frKey, frValue.toString(), frCompare.toString(), fileFieldList, "", "");

    }

    private void displayLevel2() {

        System.out.print("KNVB(lvl2) = ");
        System.out.print(this.l10_QBP511_KNVB_ORNO + "|");
        System.out.print(this.l10_QBP511_KNVB_INV_BREAK + "|");
        System.out.print(this.l10_QBP511_KNVB_WDPT + "|");
        System.out.print(this.l10_QBP511_KNVB_ORTP + "|");
        System.out.print(this.l10_QBP511_KNVB_TYPE + "|");
        System.out.print(this.l10_filler1 + "|");
        System.out.print(this.l10_QBP511_KNVB_ORD_CLASS + "|");
        System.out.print(this.l10_QBP511_KNVB_TEXT + "|");
        System.out.println("");

    }

    private void getLevel2() {

        this.lvl2 = true;

        String frKey = "L2 KNVB - INVOICE BREAKER";
        StringBuilder frValue = new StringBuilder();
        StringBuilder frCompare = new StringBuilder();

        frValue.append(this.l10_QBP511_KNVB_ORNO).append("|");
        frValue.append(this.l10_QBP511_KNVB_INV_BREAK).append("|");
        frValue.append(this.l10_QBP511_KNVB_WDPT).append("|");
        frValue.append(this.l10_QBP511_KNVB_ORTP).append("|");
        frValue.append(this.l10_QBP511_KNVB_TYPE).append("|");
        frValue.append(this.l10_filler1).append("|");
        frValue.append(this.l10_QBP511_KNVB_ORD_CLASS).append("|");
        frValue.append(this.l10_QBP511_KNVB_TEXT).append("|");

        frCompare.append(this.l10_QBP511_KNVB_ORNO).append("|");
        frCompare.append(this.l10_QBP511_KNVB_INV_BREAK).append("|");
        frCompare.append(this.l10_QBP511_KNVB_WDPT).append("|");
        frCompare.append(this.l10_QBP511_KNVB_ORTP).append("|");
        //frCompare.append(this.l10_QBP511_KNVB_TYPE + "|");
        frCompare.append(this.l10_filler1).append("|");
        frCompare.append(this.l10_QBP511_KNVB_ORD_CLASS).append("|");
        frCompare.append(this.l10_QBP511_KNVB_TEXT).append("|");

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();

        fileFieldList.add(new FileField("l10_QBP511_KNVB_ORNO", l10_QBP511_KNVB_ORNO, "9(05)", 51, 55));
        fileFieldList.add(new FileField("l10_QBP511_KNVB_INV_BREAK", l10_QBP511_KNVB_INV_BREAK, "X(05)", 56, 60));
        fileFieldList.add(new FileField("l10_QBP511_KNVB_WDPT", l10_QBP511_KNVB_WDPT, "X(02)", 61, 62));
        fileFieldList.add(new FileField("l10_QBP511_KNVB_ORTP", l10_QBP511_KNVB_ORTP, "X(02)", 63, 64));
        //fileFieldList.add(new FileField("l10_QBP511_KNVB_TYPE",      l10_QBP511_KNVB_TYPE,      "X(02)", 65,  66));
        fileFieldList.add(new FileField("l10_FILLER", l10_filler1, "X(08)", 67, 74));
        fileFieldList.add(new FileField("l10_QBP511_KNVB_ORD_CLASS", l10_QBP511_KNVB_ORD_CLASS, "X(01)", 75, 75));
        fileFieldList.add(new FileField("l10_QBP511_KNVB_TEXT", l10_QBP511_KNVB_TEXT, "X(15)", 76, 90));

        this.levelFR = new FileRecord(frKey, frValue.toString(), frCompare.toString(), fileFieldList, "", "");

    }

    private void displayLevel3() {

        System.out.print("KITM(lvl3) = ");
        System.out.print(this.l10_QBP511_KITM_ITEM + "|");
        System.out.print(this.l10_QBP511_KITM_SUBN + "|");
        System.out.print(this.l10_QBP511_KITM_COMM + "|");
        System.out.print(this.l10_QBP511_KITM_SUBC + "|");
        System.out.print(this.l15_QBP511_KITM_UPC_PROD + "|");
        System.out.print(this.l15_QBP511_KITM_UPC_MANF + "|");
        System.out.print(this.l15_QBP511_KITM_UPC_VNDR_ITM + "|");
        System.out.print(this.l15_QBP511_KITM_UPC_ITEM + "|");
        System.out.print(this.l10_QBP511_KITM_SHP_FL + "|");
        System.out.print(this.l10_QBP511_KITM_ITEM_EX_CD + "|");
        //System.out.print(this.l10_QBP511_KITM_TYPE         + "|");
        System.out.print(this.l10_QBP511_KITM_RFRNC_CD + "|");
        System.out.print(this.l10_QBP511_KITM_SLOT + "|");
        System.out.print(this.l10_QBP511_KITM_DESC + "|");
        System.out.print(this.l10_QBP511_KITM_REF_DESC + "|");
        System.out.print(this.l10_QBP511_KITM_EX_NDC_CD + "|");
        System.out.print(this.l10_filler2 + "|");
        System.out.println("");

    }

    private void getLevel3() {

        this.lvl3 = true;

        String frKey = "l3 KITM - INVOICE DETAIL/ITEM";
        StringBuilder frValue = new StringBuilder();
        StringBuilder frCompare = new StringBuilder();

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
        //frValue.append(this.l10_filler2 + "|");

        frCompare.append(this.l10_QBP511_KITM_ITEM).append("|");
        frCompare.append(this.l10_QBP511_KITM_SUBN).append("|");
        frCompare.append(this.l10_QBP511_KITM_COMM).append("|");
        frCompare.append(this.l10_QBP511_KITM_SUBC).append("|");
        frCompare.append(this.l15_QBP511_KITM_UPC_PROD).append("|");
        frCompare.append(this.l15_QBP511_KITM_UPC_MANF).append("|");
        frCompare.append(this.l15_QBP511_KITM_UPC_VNDR_ITM).append("|");
        frCompare.append(this.l15_QBP511_KITM_UPC_ITEM).append("|");
        frCompare.append(this.l10_QBP511_KITM_SHP_FL).append("|");
        //frCompare.append(this.l10_QBP511_KITM_ITEM_EX_CD   + "|");
        //frCompare.append(this.l10_QBP511_KITM_TYPE         + "|");
        frCompare.append(this.l10_QBP511_KITM_RFRNC_CD).append("|");
        frCompare.append(this.l10_QBP511_KITM_SLOT).append("|");
        frCompare.append(this.l10_QBP511_KITM_DESC).append("|");
        frCompare.append(this.l10_QBP511_KITM_REF_DESC).append("|");
        frCompare.append(this.l10_QBP511_KITM_EX_NDC_CD).append("|");

        ObservableList<FileField> fileFieldList = FXCollections.observableArrayList();

        fileFieldList.add(new FileField("l10_QBP511_KITM_ITEM", l10_QBP511_KITM_ITEM, "9(07)", 91, 97));
        fileFieldList.add(new FileField("l10_QBP511_KITM_SUBN", l10_QBP511_KITM_SUBN, "X(02)", 98, 99));
        fileFieldList.add(new FileField("l10_QBP511_KITM_COMM", l10_QBP511_KITM_COMM, "9(05)", 100, 104));
        fileFieldList.add(new FileField("l10_QBP511_KITM_SUBC", l10_QBP511_KITM_SUBC, "9(05)", 105, 109));
        fileFieldList.add(new FileField("l10_QBP511_KITM_PUPC", l10_QBP511_KITM_PUPC, "X(15)", 110, 124));
        fileFieldList.add(new FileField("l10_FILLER", "", "", 110, 124));
        fileFieldList.add(new FileField("l15_QBP511_KITM_UPC_PROD", l15_QBP511_KITM_UPC_PROD, "X(01)", 110, 110));
        fileFieldList.add(new FileField("l15_QBP511_KITM_UPC_MANF", l15_QBP511_KITM_UPC_MANF, "X(05)", 111, 115));
        fileFieldList.add(new FileField("l15_QBP511_KITM_UPC_VNDR_ITM", l15_QBP511_KITM_UPC_VNDR_ITM, "X(04)", 116, 121));
        fileFieldList.add(new FileField("l15_QBP511_KITM_UPC_ITEM", l15_QBP511_KITM_UPC_ITEM, "X(05)", 120, 124));
        fileFieldList.add(new FileField("l10_QBP511_KITM_SHP_FL", l10_QBP511_KITM_SHP_FL, "X(01)", 125, 125));
        //fileFieldList.add(new FileField("l10_QBP511_KITM_ITEM_EX_CD",   l10_QBP511_KITM_ITEM_EX_CD,   "X(01)", 126, 128));
        //fileFieldList.add(new FileField("l10_QBP511_KITM_TYPE",         l10_QBP511_KITM_TYPE,         "X(02)", 127, 128));
        fileFieldList.add(new FileField("l10_QBP511_KITM_RFRNC_CD", l10_QBP511_KITM_RFRNC_CD, "X(50)", 129, 178));
        fileFieldList.add(new FileField("l10_QBP511_KITM_SLOT", l10_QBP511_KITM_SLOT, "X(06)", 179, 184));
        fileFieldList.add(new FileField("l10_QBP511_KITM_DESC", l10_QBP511_KITM_DESC, "X(21)", 185, 205));
        fileFieldList.add(new FileField("l10_QBP511_KITM_REF_DESC", l10_QBP511_KITM_REF_DESC, "X(15)", 206, 220));
        fileFieldList.add(new FileField("l10_QBP511_KITM_EX_NDC_CD", l10_QBP511_KITM_EX_NDC_CD, "X(01)", 221, 221));
        fileFieldList.add(new FileField("l10_FILLER", l10_filler2, "X(07)", 222, 228));

        this.levelFR = new FileRecord(frKey, frValue.toString(), frCompare.toString(), fileFieldList, "", "");
    }

    private FileField buildFileField(String nameTxt, String recTypeValue, Integer length, String picTxt) {

        Integer startPos = currentIndex;
        currentIndex = currentIndex + length;
        Integer endPos = (currentIndex - 1);

        return new FileField(nameTxt, recTypeValue, picTxt, startPos, endPos);
    }

    public Boolean getLvl1() {
        return lvl1;
    }

    public Boolean getLvl2() {
        return lvl2;
    }

    public Boolean getLvl3() {
        return lvl3;
    }

    public FileRecord getLevelFR() {
        return levelFR;
    }

    public FileRecord getSubRecFR() {
        return subRecFR;
    }

}
