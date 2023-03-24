package com.dncs.fileView.mainScene;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.main.Context;
import com.dncs.fileView.objects.FileField;
import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.read.ReadQBP511CC;
import com.dncs.fileView.read.ReadQBP537CC;
import com.dncs.fileView.read.ReadWMS302CC;
import com.dncs.fileView.read.ReadWMS320CC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.FileChooser;

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
    private Button exitButton;
    @FXML
    private ChoiceBox<String> formatCB;
    @FXML
    private Button openButton;
    @FXML
    private Label fileNameLabel;
    @FXML
    private Button csvGenButton;
    @FXML
    private Label versionLabel;
    
    private final Context context = Context.getContext();
    
    @FXML
    private void initialize() {
        System.out.println("initialize()");
        
        ObservableList<String> formatList = FXCollections.observableArrayList();
        formatList.add("QBP511CC");
        formatList.add("QBP537CC");
        formatList.add("WMS302CC");
        formatList.add("WMS320CC");
        formatCB.setItems(formatList);
        formatCB.getSelectionModel().selectFirst();
        
        fileKeyTTC.setCellValueFactory(new TreeItemPropertyValueFactory<>("fileKey"));
        fileValueTTC.setCellValueFactory(new TreeItemPropertyValueFactory<>("fileValue"));
        
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
        
        System.out.println("initScene()");
        System.out.println("* context text = " + context.getTextValue());

//		PicClause pc = new PicClause("X(09)");
//		pc = new PicClause("S9(08) COMP");
//		pc = new PicClause("9(9) COMP-3");
//		pc = new PicClause("S9(9) COMP-3");
//		pc = new PicClause("S9(5)V99 COMP-3");
//		pc = new PicClause("S9(6)V99 COMP-3");
//		pc = new PicClause("S9(6)V9(04) COMP-3");
    }
    
    private void addListeners() {
        
        fileRecordTTV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            
            rowText.setText("");
            ObservableList<FileField> emptyList = FXCollections.observableArrayList();
            fileFieldTV.setItems(emptyList);
            
            if (newSelection == null) {
                return;
            }
            
            FileRecord fr = newSelection.getValue();
            fileFieldTV.setItems(fr.getFileFieldList());
            
            rowText.setText(fr.getCharData().replaceAll("\\P{Print}", ".") + "\n" + fr.getHexData1() + "\n" + fr.getHexData2());

            //System.out.println(fr.getFileValue());
        });
        
        fileFieldTV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newFileField) -> {
            
            rowText.deselect();
            if (newFileField == null) {
                return;
            }
            
            Integer startRange = newFileField.getStartPos() - 1;
            Integer endRange = newFileField.getEndPos();
            
            rowText.selectRange(startRange, endRange);
            
        });
        
    }
    
    @FXML
    public void exitButtonOnAction() {
        context.getPrimaryStage().close();
    }
    
    @FXML
    public void csvButtonOnAction() {

        //TODO: fix csv file
        StringBuilder scvRec = new StringBuilder();
        
        TreeItem<FileRecord> root = fileRecordTTV.getRoot();
        
        FileRecord frHeader = root.getChildren().get(0).getValue();
        for (FileField ffHeader : frHeader.getFileFieldList()) {
            if (scvRec.length() > 0) {
                scvRec.append(",");
            }
            scvRec.append(StringUtils.trim(ffHeader.getFieldNameTxt()));
        }
        System.out.println(scvRec.toString());
        
        for (TreeItem<FileRecord> ti : root.getChildren()) {
            FileRecord fr = ti.getValue();
            scvRec = new StringBuilder();
            for (FileField ff : fr.getFileFieldList()) {
                if (scvRec.length() > 0) {
                    scvRec.append(",");
                }
                scvRec.append("\"").append(StringUtils.trim(ff.getFieldValueTxt())).append("\"");
            }
            System.out.println(scvRec.toString());
        }
        
    }
    
    @FXML
    public void openButtonOnAction() {
        
        String formatTxt = formatCB.getValue();
        
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        chooser.setInitialDirectory(new File(checkInitialDirectory()));
        
        File file = chooser.showOpenDialog(context.getPrimaryStage().getScene().getWindow());
        
        fileNameLabel.setText("N/A");
        
        if (file != null) {
            System.out.println("AbsoluteFile = " + file.getAbsoluteFile());
            System.out.println("AbsolutePath = " + file.getAbsolutePath());
            System.out.println("Name         = " + file.getName());
            System.out.println("path         = " + file.getPath());
            fileNameLabel.setText(file.getPath());
            if (StringUtils.equals(formatTxt, "QBP511CC")) {
                readQBP511CC(file);
            } else if (StringUtils.equals(formatTxt, "QBP537CC")) {
                readQBP537CC(file);
            } else if (StringUtils.equals(formatTxt, "WMS302CC")) {
                readWMS302CC(file);
            } else if (StringUtils.equals(formatTxt, "WMS320CC")) {
                readWMS320CC(file);
            }
        }
        
    }
    
    private void readQBP511CC(File file) {
        
        ReadQBP511CC rr = new ReadQBP511CC();
        
        rr.processFile(file);
        fileRecordTTV.setRoot(rr.getRootTI());
        
    }
    
    private void readQBP537CC(File file) {
        
        ReadQBP537CC rr = new ReadQBP537CC();
        
        rr.processFile(file);
        fileRecordTTV.setRoot(rr.getRootTI());
        
    }
    
    private void readWMS302CC(File file) {
        
        ReadWMS302CC rr = new ReadWMS302CC();
        
        rr.processFile(file, 350);
        fileRecordTTV.setRoot(rr.getRootTI());
        
    }
    
    private void readWMS320CC(File file) {
        
        ReadWMS320CC rr = new ReadWMS320CC();
        
        rr.processFile(file, 500);
        fileRecordTTV.setRoot(rr.getRootTI());
        
    }
    
    private String checkInitialDirectory() {
        
        String returnDir = "c:\\";
        
        if (dirExist("c:\\testData")) {
            returnDir = "c:\\testData";
        } else if (dirExist("h:\\")) {
            returnDir = "h:\\";
        }
        
        return returnDir;
        
    }
    
    private Boolean dirExist(String dirName) {
        File testDir = new File(dirName);
        return (testDir.exists() && testDir.isDirectory());
    }
    
}
