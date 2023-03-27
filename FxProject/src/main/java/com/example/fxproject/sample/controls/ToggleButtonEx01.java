package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonEx01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ToggleButton tb1 = new ToggleButton();
		ToggleButton tb2 = new ToggleButton();

		ToggleGroup group = new ToggleGroup();
		tb1.setToggleGroup(group);
		tb2.setToggleGroup(group);

		tb1.setText("눌림 버튼1");
		tb2.setText("눌림 버튼2");

		HBox box = new HBox();
		box.getChildren().addAll(tb1, tb2);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		primaryStage.setTitle("ToggleButtonEx1");
		primaryStage.setScene(new Scene(box, 200, 150));
		primaryStage.show();
		
	}
	
	
}
