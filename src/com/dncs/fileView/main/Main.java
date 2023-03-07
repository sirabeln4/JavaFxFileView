package com.dncs.fileView.main;

import com.dncs.fileView.mainScene.MainSceneController;

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
			System.out.println("* context text = " + context.getTextValue());
			context.setTextValue("new text");
			context.setPrimaryStage(primaryStage);
			
			try {
				//set up the scene
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/dncs/fileView/mainScene/MainScene.fxml"));
	  			
				Parent root = loader.load();
	  			MainSceneController controller  = loader.getController();
	  			Scene scene = new Scene(root);
	  			
	  			// set up the stage
	  			primaryStage.setTitle("File Viewer");
	  			primaryStage.setWidth(1700);
	  			primaryStage.setHeight(800);
	  			primaryStage.setScene(scene);
	  			primaryStage.show();   
		 		
	  			controller.initScene();
	  			
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
				throw ex;
			}
			
  			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
