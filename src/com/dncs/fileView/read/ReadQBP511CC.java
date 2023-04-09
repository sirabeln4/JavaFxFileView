package com.dncs.fileView.read;

import com.dncs.fileView.filters.Qbp511ccFilter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.objects.QBP511CC;

import javafx.scene.control.TreeItem;

public class ReadQBP511CC {

    private TreeItem<FileRecord> rootTI;
    private BufferedInputStream reader;
    private Boolean eof;
    private Integer recNum;
    private Qbp511ccFilter qbp511ccFilter;

    public void processFile(File file, Qbp511ccFilter qbp511ccFilter) throws Exception {

        this.qbp511ccFilter = qbp511ccFilter;
        recNum = 1;
        FileInputStream fis;

        rootTI = new TreeItem<>(new FileRecord());

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

        int lrecl1 = reader.read();
        if (lrecl1 == -1) {
            eof = true;
            return;
        }
        int lrecl2 = reader.read();
        if (lrecl2 == -1) {
            throw new Exception("The second byte of the lrecl is missing");
        }

        Integer lrecl = Integer.valueOf(intToHex(lrecl1) + intToHex(lrecl2), 16);

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

        QBP511CC qbp511CC = new QBP511CC(hexRecord, charRecord, recNum++, qbp511ccFilter);
        this.rootTI.getChildren().add(new TreeItem<>(qbp511CC.getSubRecFR()));

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
