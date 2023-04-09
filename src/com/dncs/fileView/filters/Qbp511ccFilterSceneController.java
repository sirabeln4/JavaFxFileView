package com.dncs.fileView.filters;

import java.util.Map;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

/**
 * FXML Controller class
 *
 * @author noels
 */
public class Qbp511ccFilterSceneController {

    @FXML
    private TableView<RecTypeFilter> recTypeTV;

    @FXML
    private TableColumn<RecTypeFilter, CheckBox> checkBoxTC;

    @FXML
    private TableColumn<RecTypeFilter, String> recTypeCdTC;

    @FXML
    private TableColumn<RecTypeFilter, String> recTypeDescTC;

    @FXML
    private TableColumn<RecTypeFilter, Integer> recTypeCntTC;

    @FXML
    private ComboBox<String> invoiceCB;

    @FXML
    private ComboBox<String> itemIdCB;

    @FXML
    private Button applyButton;

    private Stage stage;
    private Qbp511ccFilter qbp511ccFilter;
    private CheckBox selecteAllCheckBox;
    private Boolean checkBoxListener;
    private Boolean applyFilter;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {

        checkBoxTC.setCellValueFactory(new PropertyValueFactory<>("selectedCB"));
        recTypeCdTC.setCellValueFactory(new PropertyValueFactory<>("recTypeCd"));
        recTypeDescTC.setCellValueFactory(new PropertyValueFactory<>("recTypeDesc"));
        recTypeCntTC.setCellValueFactory(new PropertyValueFactory<>("recTypeCnt"));

        selecteAllCheckBox = new CheckBox();
        selecteAllCheckBox.setAllowIndeterminate(true);
        selecteAllCheckBox.setSelected(true);

        checkBoxTC.setGraphic(selecteAllCheckBox);
        checkBoxTC.setSortable(false);

        addListeners();
        checkBoxListener = true;
        applyFilter = false;

    }

    public void initScene(Qbp511ccFilter qbp511ccFilter) {

        this.qbp511ccFilter = qbp511ccFilter;
        this.recTypeTV.setItems(qbp511ccFilter.getRecTypeFilterList());
        for (RecTypeFilter rtf : this.recTypeTV.getItems()) {

            rtf.getSelectedCB().selectedProperty().addListener((
                    ov, old_val, new_val) -> {

                if (!checkBoxListener) {
                    return;
                }

                checkBoxListener = false;
                //System.out.println("check box = " + new_val);
                Integer selectCnt = 0;
                Integer totalCnt = this.recTypeTV.getItems().size();
                for (RecTypeFilter rtf2 : this.recTypeTV.getItems()) {
                    CheckBox cb = rtf2.getSelectedCB();
                    if (cb.isSelected()) {
                        selectCnt++;
                    }
                }

                applyButton.setDisable(false);
                if (selectCnt == 0) {
                    selecteAllCheckBox.setSelected(false);
                    selecteAllCheckBox.setIndeterminate(false);
                    applyButton.setDisable(true);
                } else if (selectCnt.equals(totalCnt)) {
                    selecteAllCheckBox.setSelected(true);
                    selecteAllCheckBox.setIndeterminate(false);
                } else {
                    selecteAllCheckBox.setSelected(false);
                    selecteAllCheckBox.setIndeterminate(true);
                }

                checkBoxListener = true;

            });
        }

        Set<String> keySet = qbp511ccFilter.invoiceItemMap.keySet();
        keySet.remove("All");
        if (keySet.size() != 1) {
            invoiceCB.getItems().add("All");
            invoiceCB.getItems().addAll(1, keySet);
        } else {
            invoiceCB.getItems().addAll(0, keySet);
        }
        invoiceCB.getSelectionModel().selectFirst();

    }

    private void addListeners() {

        selecteAllCheckBox.indeterminateProperty().addListener((
                ov, old_val, new_val) -> {
            //System.out.println("select all indeterminate = " + new_val
            //        + " Indeterminate = " + selecteAllCheckBox.isIndeterminate()
            //        + " checkBoxListener = " + checkBoxListener);
            if (!checkBoxListener) {
                return;
            }

            if (selecteAllCheckBox.isIndeterminate()) {
                selecteAllCheckBox.setSelected(true);
                selecteAllCheckBox.setIndeterminate(false);
            }

        });

        selecteAllCheckBox.selectedProperty().addListener((
                ov, old_val, new_val) -> {
            if (!checkBoxListener) {
                return;
            }
            checkBoxListener = false;
            //System.out.println("select all check box = " + new_val
            //        + " Indeterminate = " + selecteAllCheckBox.isIndeterminate());

            for (RecTypeFilter rtf : this.recTypeTV.getItems()) {
                rtf.getSelectedCB().setSelected(new_val);
            }
            if (new_val) {
                applyButton.setDisable(false);
            } else {
                applyButton.setDisable(true);
            }

            checkBoxListener = true;

        });

        invoiceCB.getSelectionModel().selectedItemProperty().addListener((
                obs, oldSelection, selectedInvoice) -> {

            //System.out.println("Select Invoice = " + selectedInvoice);

            Map<String, String> itemMap
                    = qbp511ccFilter.getInvoiceItemMap().get(selectedInvoice);

            Set<String> keySet = itemMap.keySet();
            keySet.remove("All");
            if (keySet.size() != 1) {
                itemIdCB.getItems().add("All");
            }

            for (String itemId : keySet) {
                String itemDesc = itemMap.get(itemId);
                itemIdCB.getItems().add(itemId + " - " + itemDesc);
            }
            itemIdCB.getSelectionModel().selectFirst();

        });

    }

    @FXML
    public void cancelButtonOnAction() {
        stage.close();
    }

    @FXML
    public void applyButtonOnAction() {
        
        this.qbp511ccFilter.setSelectedRecTypes("All");
        this.qbp511ccFilter.setSelectedInvoice("All");
        this.qbp511ccFilter.setSelectedItem("All");
        
        StringBuilder selectedRecTypes = new StringBuilder();
        Integer selectCnt = 0;
        Integer totalCnt = this.recTypeTV.getItems().size();
        for (RecTypeFilter rtf2 : this.recTypeTV.getItems()) {
            CheckBox cb = rtf2.getSelectedCB();
            if (cb.isSelected()) {
                if (selectedRecTypes.length() > 0) {
                    selectedRecTypes.append(", ");
                }
                selectedRecTypes.append(rtf2.getRecTypeCd());
                selectCnt++;
            }
        }
        if (!selectCnt.equals(totalCnt)) {
            this.qbp511ccFilter.setSelectedRecTypes(
                    selectedRecTypes.toString());
        }
        
        if (this.invoiceCB.getItems().size() > 1) {
            this.qbp511ccFilter.setSelectedInvoice(this.invoiceCB.getValue());
        }
        
        if (this.itemIdCB.getItems().size() > 1) {
            String itemId = StringUtils.substringBefore(
                    this.itemIdCB.getValue(), " - ");
            this.qbp511ccFilter.setSelectedItem(itemId);
        } 
        
        applyFilter = true;
        stage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Boolean getApplyFilter() {
        return applyFilter;
    }

}
