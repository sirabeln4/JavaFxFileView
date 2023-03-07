package com.dncs.fileView.read;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.dncs.fileView.objects.FileRecord;
import com.dncs.fileView.objects.QBP537CC;

import javafx.scene.control.TreeItem;

public class ReadQBP537CC {
	
	private TreeItem<FileRecord> rootTI;
	private BufferedInputStream reader;
	private Boolean eof;
	
	public void processFile(File file) {
		
		FileInputStream fis;
		rootTI = new TreeItem<>(new FileRecord());
		
		try {
			
			fis    = new FileInputStream(file);
			reader = new BufferedInputStream(fis);
			eof    = false;
			while (!eof)  {
				readFile();
			}
			
			reader.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	private void readFile() throws Exception {
		
		StringBuffer charSB = new StringBuffer();
		StringBuffer hexSB  = new StringBuffer();
		
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
			
			Integer lrecl = Integer.parseInt(intToHex(lrecl1) + intToHex(lrecl2), 16);
			
			//System.out.println("lrecl = " + lrecl);
			
			for (int i=0; i < lrecl; i++) {
				int nextByte = reader.read();
				if (nextByte < 0) {
					eof = true;
					break;
				}
				
				charSB.append((char)nextByte);
				hexSB.append(intToHex(nextByte));
				
			}
			
			String charRecord = StringUtils.rightPad(charSB.toString(), lrecl);
			String hexRecord  = StringUtils.rightPad(hexSB.toString(), lrecl*2, "00");
			
			QBP537CC qbp537CC = new QBP537CC(hexRecord, charRecord);
			
			this.rootTI.getChildren().add(new TreeItem<>(qbp537CC.getFileRecord()));
						
		} catch (IOException e) {
			e.printStackTrace();
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
