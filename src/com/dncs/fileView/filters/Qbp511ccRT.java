package com.dncs.fileView.filters;

/**
 *
 * @author noels
 */
public enum Qbp511ccRT {
    
    INVC(1, "00", "INVOICE MASTER"),
    ICNT(1, "20", "CONTACTS"),
    IMFE(1, "60", "INVOICE MASTER FEES"),
    IMTF(1, "65", "INVOICE TOTAL FEES"),
    IMLI(1, "80", "LICENSE NUMBERS"),
    IMLD(1, "85", "LICENSE DESC"),
    INVT(1, "99", "INVOICE TOTALS"),
    INVB(2, "00", "INVOICE BREAKER"),
    IBFE(2, "60", "INVOICE BREAKER FEES"),
    IVBT(2, "99", "INVOICE BREAK TOTALS"),
    ITEM(3, "00", "INVOICE DETAIL"),
    ITEX(3, "00", "ITEM EXCEPTION"),
    ITOR(3, "10", "ORIGINAL OF SUB"),
    ITAL(3, "20", "ITEM ALLOWANCES"),
    IRBT(3, "22", "ITEM REBATES"),
    ITSC(3, "30", "SHIPPER COMPONENTS"),
    ITWT(3, "40", "RANDOM WEIGHTS"),
    ITND(3, "50", "NDC CODES"),
    ITFE(3, "60", "ITEM FEES"),
    ITTX(3, "70", "ITEM TAXES"),
    UNKNOWN(0, "XX", "UNKNOWN");

    private Qbp511ccRT(Integer recKeyLvl, String recTypeNum, String desc) {

        this.recKeyLvl = recKeyLvl;
        this.recTypeNum = recTypeNum;
        this.desc = desc;

    }

    private final Integer recKeyLvl;
    private final String recTypeNum;
    private final String desc;

    public Integer getRecKeyLvl() {
        return recKeyLvl;
    }

    public String getRecTypeNum() {
        return recTypeNum;
    }

    public String getDesc() {
        return desc;
    }

}
