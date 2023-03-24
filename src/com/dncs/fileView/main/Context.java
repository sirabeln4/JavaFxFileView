package com.dncs.fileView.main;

import javafx.stage.Stage;

public class Context {

    private static Context context;
    private String textValue = "Text";
    private Stage primaryStage;
    private String versionNum = "V 0.2.0";

    public static synchronized Context getContext() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

}
