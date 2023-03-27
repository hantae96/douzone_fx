package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordFieldEx extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		PasswordField text1 = new PasswordField();
		PasswordField text2 = new PasswordField();
		
		text1.setMaxWidth(200);
		text1.setPrefHeight(40);
		
		text1.setText("아이디");
		text2.setText("이름");
		
		System.out.println("text1 : " + text1.getText());
		System.out.println("text2 : " + text2.getText());
		
		VBox box = new VBox();
		box.getChildren().addAll(text1, text2);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		primaryStage.setTitle("PasswordFieldEx");
		primaryStage.setScene(new Scene(box, 300, 200));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
