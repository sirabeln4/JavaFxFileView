package com.dncs.fileView.read;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.objects.WMS320CC;

import javafx.scene.control.TreeItem;

public class ReadWMS320CC {

    private TreeItem<FileRecord> rootTI;
    private BufferedInputStream reader;
    private Boolean eof;
    private Integer lrecl;
    private Integer recNum;
    
    public void processFile(File file, Integer lrecl) throws Exception {

        recNum = 1;
        FileInputStream fis;
        rootTI = new TreeItem<>(new FileRecord());
        this.lrecl = lrecl;

        try {

            fis = new FileInputStream(file);
            reader = new BufferedInputStream(fis);
            eof = false;

            while (!eof) {
                readFile();
            }

            reader.close();
            fis.close();

        } catch (Exception e) {
            throw e;
        }

    }

    private void readFile() throws Exception {

        StringBuilder charSB = new StringBuilder();
        StringBuilder hexSB = new StringBuilder();

        for (int i = 0; i < lrecl; i++) {
            int nextByte = reader.read();
            if (nextByte < 0) {
                eof = true;
                break;
            }

            charSB.append((char) nextByte);
            hexSB.append(intToHex(nextByte));

        }

        String charRecord = StringUtils.rightPad(charSB.toString(), lrecl);
        String hexRecord = StringUtils.rightPad(hexSB.toString(), lrecl * 2, "00");

        WMS320CC wms320CC = new WMS320CC(hexRecord, charRecord, recNum++);
        this.rootTI.getChildren().add(new TreeItem<>(wms320CC.getFileRecord()));

    }

    private String intToHex(int num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public TreeItem<FileRecord> getRootTI() {
        return rootTI;
    }

}
