package com.dncs.fileView.read;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.objects.QBP511CC;

import javafx.scene.control.TreeItem;

public class ReadQBP511CC {

    private TreeItem<FileRecord> rootTI;
    private FileRecord lvl1FR;
    private FileRecord lvl2FR;
    private FileRecord lvl3FR;

    private TreeItem<FileRecord> lvl1TI;
    private TreeItem<FileRecord> lvl2TI;
    private TreeItem<FileRecord> lvl3TI;

    private BufferedInputStream reader;
    private Boolean eof;

    public void processFile(File file) {

        FileInputStream fis;

        rootTI = new TreeItem<>(new FileRecord());
        lvl1FR = new FileRecord();
        lvl2FR = new FileRecord();
        lvl3FR = new FileRecord();

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
        }

    }

    private void readFile() throws Exception {

        StringBuilder charSB = new StringBuilder();
        StringBuilder hexSB = new StringBuilder();

        try {
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
            // Integer lrecl = Integer.parseInt(intToHex(lrecl1) + intToHex(lrecl2), 16);

            System.out.println(" ");
            System.out.println("lrecl = " + lrecl);
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

            System.out.println(hexRecord);
            QBP511CC qbp511CC = new QBP511CC(hexRecord, charRecord);

            if (qbp511CC.getLvl1()) {
                //lvl1FR = new FileRecord();
                lvl2FR = new FileRecord();
                lvl3FR = new FileRecord();
                if (!StringUtils.equals(lvl1FR.getCompareValue(), qbp511CC.getLevelFR().getCompareValue())) {
                    this.lvl1FR = qbp511CC.getLevelFR();
                    this.lvl1TI = new TreeItem<>(lvl1FR);
                    this.rootTI.getChildren().add(lvl1TI);
                }
                if (qbp511CC.getSubRecFR() != null) {
                    this.lvl1TI.getChildren().add(new TreeItem<>(qbp511CC.getSubRecFR()));
                    this.lvl1TI.setExpanded(true);
                }
            } else if (qbp511CC.getLvl2()) {
                lvl1FR = new FileRecord();
                //lvl2FR = new FileRecord();
                lvl3FR = new FileRecord();
                if (!StringUtils.equals(lvl2FR.getCompareValue(), qbp511CC.getLevelFR().getCompareValue())) {
                    this.lvl2FR = qbp511CC.getLevelFR();
                    this.lvl2TI = new TreeItem<>(lvl2FR);
                    this.rootTI.getChildren().add(lvl2TI);
                }
                if (qbp511CC.getSubRecFR() != null) {
                    this.lvl2TI.getChildren().add(new TreeItem<>(qbp511CC.getSubRecFR()));
                    this.lvl2TI.setExpanded(true);
                }
            } else if (qbp511CC.getLvl3()) {
                lvl1FR = new FileRecord();
                lvl2FR = new FileRecord();
                //lvl3FR = new FileRecord();
                if (!StringUtils.equals(lvl3FR.getCompareValue(), qbp511CC.getLevelFR().getCompareValue())) {
                    this.lvl3FR = qbp511CC.getLevelFR();
                    this.lvl3TI = new TreeItem<>(lvl3FR);
                    this.rootTI.getChildren().add(lvl3TI);
                }
                if (qbp511CC.getSubRecFR() != null) {
                    this.lvl3TI.getChildren().add(new TreeItem<>(qbp511CC.getSubRecFR()));
                    this.lvl3TI.setExpanded(true);
                }
            }

        } catch (IOException e) {
        }

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
