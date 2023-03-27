package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPane01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button[] buttons = new Button[5];
		String[] strings =  {"TOP", "LEFT", "CENTER", "RIGHT", "BOTTOM"};

		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(strings[i]);
		}
		
		buttons[0].setPrefHeight(100);
		buttons[4].setPrefWidth(400);
		BorderPane border = new BorderPane();
		
		border.setTop(buttons[0]);
		border.setLeft(buttons[1]);
		border.setCenter(buttons[2]);
		border.setRight(buttons[3]);
		border.setBottom(buttons[4]);
		
		primaryStage.setScene(new Scene(border, 400, 300));
		primaryStage.setTitle("BoderPaneEx");
		primaryStage.show();
	}



}





