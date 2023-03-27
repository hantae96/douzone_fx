package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldEx extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		
		text1.setMaxSize(180, 60);
		text2.setMaxSize(180, 60);
		
		text1.setText("아이디");
		text2.setText("이름");
		
		System.out.println("text1 : " + text1.getText());
		System.out.println("text2 : " + text2.getText());
		
		VBox box = new VBox();
		box.getChildren().addAll(text1, text2);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		primaryStage.setTitle("TextFieldEx");
		primaryStage.setScene(new Scene(box, 300, 200));
		primaryStage.show();
		
	}
	
	
}
