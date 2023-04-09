package com.dncs.fileView.mainScene;

import com.dncs.fileView.filters.Qbp511ccFilter;
import com.dncs.fileView.filters.Qbp511ccFilterSceneController;
import com.dncs.fileView.filters.RecTypeFilter;
import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.main.Context;
import com.dncs.fileView.objects.FileField;
import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.read.ReadQBP511CC;
import com.dncs.fileView.read.ReadQBP537CC;
import com.dncs.fileView.read.ReadWMS302CC;
import com.dncs.fileView.read.ReadWMS320CC;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class MainSceneController {

    @FXML
    private TreeTableView<FileRecord> fileRecordTTV;
    @FXML
    private TreeTableColumn<FileRecord, String> fileKeyTTC;
    @FXML
    private TreeTableColumn<FileRecord, String> fileValueTTC;

    @FXML
    private TableView<FileField> fileFieldTV;
    @FXML
    private TableColumn<FileField, String> fieldNameTC;
    @FXML
    private TableColumn<FileField, String> fieldValueTC;
    @FXML
    private TableColumn<FileField, String> picTC;
    @FXML
    private TableColumn<FileField, Integer> startPosTC;
    @FXML
    private TableColumn<FileField, Integer> endPosTC;
    @FXML
    private TableColumn<FileField, String> keyLevelTC;

    @FXML
    private TextArea rowText;

    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem copyMenuItem;
    @FXML
    private MenuItem copyContextMenuItem;
    @FXML
    private MenuItem filterMenuItem;

    @FXML
    private Label filePositionLabel;
    @FXML
    private Label fileFormatLabel;
    @FXML
    private Label fileNameLabel;
    @FXML
    private Label versionLabel;
    @FXML
    private Label filterLabel;

    private final Context context = Context.getContext();

    TreeItem<FileRecord> fileTI;

    private Integer totalRecCnt;
    private File inputFile;
    private Qbp511ccFilter qbp511ccFilter;

    @FXML
    public void initialize() {

        //System.out.println("initialize()");
        qbp511ccFilter = new Qbp511ccFilter();
        totalRecCnt = 0;
        fileKeyTTC.setCellValueFactory(new TreeItemPropertyValueFactory<>("fileKey"));
        fileValueTTC.setCellValueFactory(new TreeItemPropertyValueFactory<>("fileValue"));

        fileFieldTV.getSelectionModel().setCellSelectionEnabled(true);
        fileFieldTV.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        fieldNameTC.setCellValueFactory(new PropertyValueFactory<>("fieldNameTxt"));
        fieldValueTC.setCellValueFactory(new PropertyValueFactory<>("fieldValueTxt"));
        picTC.setCellValueFactory(new PropertyValueFactory<>("picTxt"));
        startPosTC.setCellValueFactory(new PropertyValueFactory<>("startPos"));
        endPosTC.setCellValueFactory(new PropertyValueFactory<>("endPos"));
        keyLevelTC.setCellValueFactory(new PropertyValueFactory<>("keyLevel"));

        versionLabel.setText(context.getVersionNum());

        addListeners();

    }

    public void initScene() {

        //System.out.println("initScene()");
        //System.out.println("* context text = " + context.getTextValue());
    }

    private void addListeners() {

        fileRecordTTV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            rowText.setText("");
            ObservableList<FileField> emptyList = FXCollections.observableArrayList();
            fileFieldTV.setItems(emptyList);

            if (newSelection == null) {
                filePositionLabel.setText("rec: 0 of " + totalRecCnt);
                return;
            }

            Integer selectedItemNum = fileRecordTTV.getSelectionModel()
                    .getSelectedItem().getValue().getRecNum();

            filePositionLabel.setText("rec: " + selectedItemNum + " of " + totalRecCnt);

            FileRecord fr = newSelection.getValue();
            fileFieldTV.setItems(fr.getFileFieldList());

            StringBuilder sb = new StringBuilder();
            sb.append(fr.getCharData().replaceAll("\\P{Print}", ".")).append("\n")
                    .append(fr.getHexData1()).append("\n")
                    .append(fr.getHexData2()).append("\n");

            Integer selectedIndex = fileRecordTTV.getSelectionModel().getSelectedIndex();
            Integer size = fileRecordTTV.getRoot().getChildren().size();
            Integer cnt = selectedIndex + 1 + 10;
            if (cnt > size) {
                cnt = size;
            }
            Integer lineLength = fr.getCharData().length();
            //System.out.println("selectedIndex = " + selectedIndex + " size = " + size);

            for (Integer i = selectedIndex + 1; i < cnt; i++) {
                fr = fileRecordTTV.getRoot().getChildren().get(i).getValue();
                sb.append(StringUtils.rightPad("", lineLength, "=")).append("\n");
                sb.append(fr.getCharData().replaceAll("\\P{Print}", ".")).append("\n")
                        .append(fr.getHexData1()).append("\n")
                        .append(fr.getHexData2()).append("\n");
                lineLength = fr.getCharData().length();
            }
            //fileRecordTTV.getRoot().getChildren().size()
            rowText.setText(sb.toString());

        });

        fileFieldTV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newFileField) -> {

            copyMenuItem.setDisable(true);
            copyContextMenuItem.setDisable(true);
            rowText.deselect();
            if (newFileField == null) {
                return;
            }

            copyMenuItem.setDisable(false);
            copyContextMenuItem.setDisable(false);
            ObservableList<FileField> selectedItems = fileFieldTV.getSelectionModel().getSelectedItems();
            if (selectedItems.size() > 1) {
                return;
            }

            Integer startRange = newFileField.getStartPos() - 1;
            Integer endRange = newFileField.getEndPos();

            //System.out.println("range =  " + startRange + " " + endRange);
            rowText.selectRange(startRange, endRange);

        });

    }

    @FXML
    public void copyMenuItemOnAction() {

        ObservableList<TablePosition> posList = fileFieldTV.getSelectionModel().getSelectedCells();
        StringBuilder clipboardString = new StringBuilder();
        int old_r = -1;

        for (TablePosition p : posList) {
            int r = p.getRow();
            int c = p.getColumn();
            Object cell = fileFieldTV.getColumns().get(c).getCellData(r);
            if (cell == null) {
                cell = "";
            }
            if (old_r == r) {
                clipboardString.append('\t');
            } else if (old_r != -1) {
                clipboardString.append('\n');
            }
            clipboardString.append(cell);
            old_r = r;
        }
        final ClipboardContent content = new ClipboardContent();
        content.putString(clipboardString.toString());
        Clipboard.getSystemClipboard().setContent(content);

    }

    @FXML
    public void filterMenuItemOnAction() {

        try {
            if (StringUtils.equals(fileFormatLabel.getText(), "QBP511CC")) {
                showQbp511ccFilterScene();
            } else {

            }

        } catch (IOException e) {

            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("error occured with filter scene\n" + e.getMessage());
            a.show();

            String stacktrace = ExceptionUtils.getStackTrace(e);
            System.err.println(stacktrace);

        }
    }

    @FXML
    public void settingsMenuItemOnAction() {

    }

    @FXML
    public void closeMenuItemOnAction() {
        context.getPrimaryStage().close();
    }

    @FXML
    public void saveMenuItemOnAction() {

        File csvFile = saveCsvFileChooser();

        if (csvFile != null) {
            //System.out.println("AbsoluteFile = " + csvFile.getAbsoluteFile());

            try {
                try (BufferedWriter bwr = new BufferedWriter(new FileWriter(csvFile))) {
                    StringBuilder csvRec = new StringBuilder();
                    TreeItem<FileRecord> root = fileRecordTTV.getRoot();
                    Boolean addComma = false;
                    for (TreeItem<FileRecord> ti : root.getChildren()) {
                        FileRecord fr = ti.getValue();
                        for (FileField ff : fr.getFileFieldList()) {
                            if (addComma) {
                                csvRec.append(",");
                            } else {
                                addComma = true;
                            }
                            csvRec.append("\"").append(StringUtils.trim(ff.getFieldValueTxt())).append("\"");
                        }
                        csvRec.append(System.getProperty("line.separator"));
                        addComma = false;
                    }
                    bwr.write(csvRec.toString());
                    bwr.flush();
                }

            } catch (FileNotFoundException ex) {
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("error occured writing CSV file\n" + ex.getMessage());
                a.show();
            } catch (IOException ex) {
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("error occured writing CSV file\n" + ex.getMessage());
                a.show();
            }

        }

    }

    private File saveCsvFileChooser() {

        File inputDirectory = new File(inputFile.getParent());

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save CSV File");
        chooser.setInitialDirectory(inputDirectory);
        chooser.setInitialFileName(inputFile.getName());

        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("All files", "*.*")
        );

        return chooser.showSaveDialog(context.getPrimaryStage().getScene().getWindow());

    }

    @FXML
    public void openMenuItemOnAction() {

        try {
            File openFile = openFileChooser();

            if (openFile != null) {

                inputFile = openFile;
                //System.out.println("AbsoluteFile = " + inputFile.getAbsoluteFile());
                //System.out.println("AbsolutePath = " + inputFile.getAbsolutePath());
                //System.out.println("Name         = " + inputFile.getName());
                //System.out.println("path         = " + inputFile.getPath());
                //System.out.println("parent       = " + inputFile.getParent());
                //System.out.println("file format  = " + fileFormatLabel.getText());

                String formatTxt = fileFormatLabel.getText();
                fileNameLabel.setText(inputFile.getName());

                if (StringUtils.equals(formatTxt, "QBP511CC")) {
                    readQBP511CC(inputFile);
                } else if (StringUtils.equals(formatTxt, "QBP537CC")) {
                    readQBP537CC(inputFile);
                } else if (StringUtils.equals(formatTxt, "WMS302CC")) {
                    readWMS302CC(inputFile);
                } else if (StringUtils.equals(formatTxt, "WMS320CC")) {
                    readWMS320CC(inputFile);
                }

                Integer tiSize = fileTI.getChildren().size();
                //System.out.println("tiSize = " + tiSize);
                if (tiSize == 0) {
                    totalRecCnt = 0;
                } else {
                    FileRecord fr = fileTI.getChildren()
                            .get(tiSize - 1).getValue();
                    totalRecCnt = fr.getRecNum();
                }

                filePositionLabel.setText("rec: 0 of " + totalRecCnt);

                if (StringUtils.equals(formatTxt, "QBP511CC")) {
                    TreeItem<FileRecord> filteredTI = applyQbp511ccFilter();
                    fileRecordTTV.setRoot(filteredTI);
                } else {
                    fileRecordTTV.setRoot(fileTI);
                }

                context.getIniHandler().setInitialDirectory(inputFile.getParent());

                this.saveMenuItem.setDisable(false);

            }

        } catch (Exception e) {
            fileNameLabel.setText("Error during open");
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("error occured opening file\n" + e.getMessage());
            a.show();

            System.err.println(fileNameLabel.getText());
            String stacktrace = ExceptionUtils.getStackTrace(e);
            System.err.println(stacktrace);

        }

    }

    private File openFileChooser() throws IOException {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(checkInitialDirectory()));

        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("QBP511CC", "*.*"),
                new FileChooser.ExtensionFilter("QBP537CC", "*.*"),
                new FileChooser.ExtensionFilter("WMS302CC", "*.*"),
                new FileChooser.ExtensionFilter("WMS320CC", "*.*")
        );

        File filechoosen = chooser.showOpenDialog(context.getPrimaryStage().getScene().getWindow());
        if (filechoosen != null) {
            // clear out the last file opened
            saveMenuItem.setDisable(true);
            filterMenuItem.setDisable(true);
            filePositionLabel.setText("");
            fileFormatLabel.setText("N/A");
            fileNameLabel.setText("N/A");
            filterLabel.setText("");
            fileRecordTTV.getSelectionModel().clearSelection();
            fileRecordTTV.setRoot(null);
            totalRecCnt = 0;
            qbp511ccFilter.clearLists();

            FileChooser.ExtensionFilter selectedExtensionFilter = chooser.getSelectedExtensionFilter();
            fileFormatLabel.setText(selectedExtensionFilter.getDescription());

        }

        return filechoosen;

    }

    private void showQbp511ccFilterScene() throws IOException {

        Stage filterStage = new Stage();
        filterStage.initModality(Modality.WINDOW_MODAL);
        filterStage.initOwner(context.getPrimaryStage());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dncs/fileView/filters/Qbp511ccFilterScene.fxml"));
        AnchorPane filterPane = loader.load();

        Qbp511ccFilterSceneController filterSceneController = loader.getController();
        Scene filterScene = new Scene(filterPane);
        filterSceneController.setStage(filterStage);
        filterSceneController.initScene(qbp511ccFilter);

        filterStage.setTitle("QBP511CC Filter");
        filterStage.setWidth(375D);
        filterStage.setHeight(400D);
        filterStage.setScene(filterScene);

        filterStage.showAndWait();

        TreeItem<FileRecord> filteredTI = applyQbp511ccFilter();
        fileRecordTTV.setRoot(filteredTI);

    }

    private void readQBP511CC(File file) throws Exception {

        ReadQBP511CC rr = new ReadQBP511CC();

        rr.processFile(file, this.qbp511ccFilter);
        fileTI = rr.getRootTI();
        this.filterMenuItem.setDisable(false);

    }

    private void readQBP537CC(File file) throws Exception {

        ReadQBP537CC rr = new ReadQBP537CC();

        rr.processFile(file);
        fileTI = rr.getRootTI();

    }

    private void readWMS302CC(File file) throws Exception {

        ReadWMS302CC rr = new ReadWMS302CC();

        rr.processFile(file, 350);
        fileTI = rr.getRootTI();

    }

    private void readWMS320CC(File file) throws Exception {

        ReadWMS320CC rr = new ReadWMS320CC();

        rr.processFile(file, 500);
        fileTI = rr.getRootTI();

    }

    private String checkInitialDirectory() throws IOException {

        String returnDir = context.getIniValues().getInitialDirectory();

        if (dirExist(returnDir)) {
            //continue;
        } else if (dirExist("c:\\testData")) {
            returnDir = "c:\\testData";
        } else if (dirExist("h:\\")) {
            returnDir = "h:\\";
        } else {
            returnDir = "c:\\";
        }

        return returnDir;

    }

    private Boolean dirExist(String dirName) {
        File testDir = new File(dirName);
        return (testDir.exists() && testDir.isDirectory());
    }

    @FXML
    public void aboutMenuItemOnAction() {

        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("About");
        a.setHeaderText("File View " + context.getVersionNum());
        a.show();

    }

    private TreeItem<FileRecord> applyQbp511ccFilter() {

        TreeItem<FileRecord> filteredTI = new TreeItem<>(new FileRecord());
        Boolean addRecord;
        for (TreeItem<FileRecord> frTI : fileTI.getChildren()) {
            FileRecord fr = frTI.getValue();
            addRecord = true;

            //System.out.println("filter recNum = " + fr.getRecNum()
            //        + " rec type = " + fr.getRecType()
            //        + " invoice Id = " + fr.getInvoiceId()
             //       + " item Id = " + fr.getItemId());

            if (!StringUtils.equals(this.qbp511ccFilter.getSelectedRecTypes(), "All")) {
                if (this.qbp511ccFilter.getRecTypeHM().containsKey(fr.getRecType())) {
                    RecTypeFilter rtf = this.qbp511ccFilter.getRecTypeHM().get(fr.getRecType());
                    if (!rtf.isSelected()) {
                        addRecord = false;
                    }
                }
            }

            //System.out.println("addRecord = " + addRecord);
            if (addRecord
                    && !StringUtils.equals(this.qbp511ccFilter.getSelectedInvoice(), "All")
                    && StringUtils.isNotBlank(fr.getInvoiceId())
                    && !StringUtils.equals(fr.getInvoiceId(), this.qbp511ccFilter.getSelectedInvoice())) {
                addRecord = false;
            }

            //System.out.println("addRecord = " + addRecord
            //        + " filter item id = " + this.qbp511ccFilter.getSelectedItem()
            //        + " itemId = " + fr.getItemId());
            
            if (addRecord
                    && !StringUtils.equals(this.qbp511ccFilter.getSelectedItem(), "All")
                    && StringUtils.isNotBlank(fr.getItemId())
                    && !StringUtils.equals(fr.getItemId(), this.qbp511ccFilter.getSelectedItem())) {
                addRecord = false;
            }

            //System.out.println("addRecord = " + addRecord);
            if (addRecord) {
                filteredTI.getChildren().add(frTI);
            }
        }
        filterLabel.setText("Invoice : " + this.qbp511ccFilter.getSelectedInvoice()
                + " | Item Id : " + this.qbp511ccFilter.getSelectedItem()
                + " | Rec Type : " + this.qbp511ccFilter.getSelectedRecTypes());

        return filteredTI;
    }

}
