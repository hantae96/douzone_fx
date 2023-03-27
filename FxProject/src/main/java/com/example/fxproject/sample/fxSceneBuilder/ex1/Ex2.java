package com.example.fxproject.sample.fxSceneBuilder.ex1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex2 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ex2.fxml"));
		Parent form = loader.load();
		
		Scene scene = new Scene(form);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex2");
		primaryStage.show();
	}

}









