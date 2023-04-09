package com.dncs.fileView.ini;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author noels
 */
public class IniHandler {

    private final ObjectMapper objectMapper;
    private File iniFile;
    private IniValues iniValues;

    public IniHandler() throws IOException {

        objectMapper = new ObjectMapper();
        iniValues = new IniValues();
        findIniFile();

        if (iniFile.exists() && !iniFile.isDirectory()) {
            iniValues = objectMapper.readValue(iniFile, IniValues.class);
        } else {
            iniValues = new IniValues();
            objectMapper.writeValue(iniFile, iniValues);
        }

    }

    private void findIniFile() {

        String fileName = System.getenv("FILE_VIEW_INI");
        if (fileName == null) {
            fileName = System.getProperty("user.home") + File.separator + "fileViewINI.json";
        }

        iniFile = new File(fileName);

    }

    public void writeIniFile() throws IOException {
        objectMapper.writeValue(iniFile, iniValues);
    }

    public void readIniFile() throws IOException {

        IniValues ini = objectMapper.readValue(iniFile, IniValues.class);
        iniValues.update(ini);

    }

    public IniValues getIniValues() {
        return iniValues;
    }

    public void setInitialDirectory(String initialDirectory) throws IOException {

        this.readIniFile();

        if (!StringUtils.equals(initialDirectory,
                 iniValues.getInitialDirectory())) {
            iniValues.setInitialDirectory(initialDirectory);
            this.writeIniFile();
        }
        
    }

}
