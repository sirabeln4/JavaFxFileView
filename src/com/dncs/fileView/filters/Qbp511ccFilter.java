package com.dncs.fileView.filters;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author noels
 */
public class Qbp511ccFilter {

    Map<String, RecTypeFilter> recTypeHM;
    ObservableList<RecTypeFilter> recTypeFilterList;
    Map<String, Map<String, String>> invoiceItemMap;

    private String selectedRecTypes;
    private String selectedInvoice;
    private String selectedItem;

    public Qbp511ccFilter() {

        //System.out.println("Qbp511ccFilter constructor");

        selectedRecTypes = "All";
        selectedInvoice = "All";
        selectedItem = "All";

        recTypeHM = new HashMap<>();
        recTypeFilterList = FXCollections.observableArrayList();

        for (Qbp511ccRT rt : Qbp511ccRT.values()) {
            RecTypeFilter rtf = new RecTypeFilter(rt.toString(),
                    rt.getDesc());
            recTypeFilterList.add(rtf);
            recTypeHM.put(rt.toString(), rtf);
        }

        invoiceItemMap = new TreeMap<>();
        Map<String, String> itemMap = new TreeMap<>();
        itemMap.put("All", "");
        invoiceItemMap.put("All", itemMap);

    }

    public void clearLists() {

        Integer selectCnt = 0;
        for (RecTypeFilter rtf : recTypeFilterList) {
            rtf.clearRecTypeCnt();
            if (rtf.isSelected()) {
                selectCnt++;
            }
        }

        invoiceItemMap = new TreeMap<>();
        Map<String, String> itemMap = new TreeMap<>();
        itemMap.put("All", "");
        invoiceItemMap.put("All", itemMap);

        this.selectedInvoice = "All";
        this.selectedItem = "All";

        //System.out.println("Qbp511ccFilter clearLists - selectCnt = " + selectCnt);

    }

    public void addToRecTypeCnt(Qbp511ccRT rt) {
        RecTypeFilter rtf = recTypeHM.get(rt.toString());
        rtf.addToRecTypeCnt();
    }

    public void addInvoice(String invoiceId) {

        if (!invoiceItemMap.containsKey(invoiceId)) {
            Map<String, String> itemMap = new TreeMap<>();
            itemMap.put("All", "");
            invoiceItemMap.put(invoiceId, itemMap);
        }

    }

    public void addItem(String invoiceId, String itemId, String itemDesc) {

        this.addInvoice(invoiceId);

        Map<String, String> allMap = invoiceItemMap.get(invoiceId);
        Map<String, String> invoiceMap = invoiceItemMap.get(invoiceId);

        if (!allMap.containsKey(itemId)) {
            allMap.put(itemId, itemDesc);
        }
        if (!invoiceMap.containsKey(itemId)) {
            invoiceMap.put(itemId, itemDesc);
        }

    }

    public ObservableList<RecTypeFilter> getRecTypeFilterList() {
        return recTypeFilterList;
    }

    public Map<String, RecTypeFilter> getRecTypeHM() {
        return recTypeHM;
    }

    public Map<String, Map<String, String>> getInvoiceItemMap() {
        return invoiceItemMap;
    }

    public String getSelectedRecTypes() {
        return selectedRecTypes;
    }

    public void setSelectedRecTypes(String selectedRecTypes) {
        this.selectedRecTypes = selectedRecTypes;
    }

    public String getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(String selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

}
