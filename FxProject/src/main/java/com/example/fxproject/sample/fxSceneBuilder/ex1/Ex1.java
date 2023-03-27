package com.example.fxproject.sample.fxSceneBuilder.ex1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex1 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println("현재 클래스 : " + getClass());
		System.out.println("어떤 대상의 위치 : " + getClass().getResource("ex1.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ex1.fxml"));
		Parent form = loader.load();
		primaryStage.setScene(new Scene(form));
		primaryStage.setTitle("ex1");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


