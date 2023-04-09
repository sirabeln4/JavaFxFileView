package com.dncs.fileView.ini;

/**
 *
 * @author noels
 */
public class IniValues {
    
    private Double stageWidth;
    private Double stageHeight;
    private String initialDirectory;
    
    public IniValues() {
        
        this.initialDirectory = "H:\\";
        this.stageWidth = 1700D;
        this.stageHeight = 800D;
        
    }
    
    public void update(IniValues ini) {
        this.setStageWidth(ini.getStageWidth());
        this.setStageHeight(ini.getStageHeight());
        this.setInitialDirectory(ini.getInitialDirectory());
    }
    
    public Double getStageWidth() {
        return stageWidth;
    }

    public void setStageWidth(Double stageWidth) {
        this.stageWidth = stageWidth;
    }

    public Double getStageHeight() {
        return stageHeight;
    }

    public void setStageHeight(Double stageHeight) {
        this.stageHeight = stageHeight;
    }
    
    
    public String getInitialDirectory() {
        return initialDirectory;
    }

    public void setInitialDirectory(String initialDirectory) {
        this.initialDirectory = initialDirectory;
    }    
    
}
