package com.dncs.fileView.main;

import com.dncs.fileView.ini.IniHandler;
import com.dncs.fileView.ini.IniValues;
import com.dncs.fileView.mainScene.MainSceneController;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {

            Context context = Context.getContext();
            IniValues ini = context.getIniValues();
            context.setTextValue("new text");
            context.setPrimaryStage(primaryStage);

            //set up the scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dncs/fileView/mainScene/MainScene.fxml"));

            Parent root = loader.load();
            MainSceneController controller = loader.getController();
            Scene scene = new Scene(root);

            // set up the stage
            primaryStage.setTitle("File Viewer");
            primaryStage.setWidth(ini.getStageWidth());
            primaryStage.setHeight(ini.getStageHeight());
            primaryStage.setScene(scene);
            primaryStage.show();

            controller.initScene();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
