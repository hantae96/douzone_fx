package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonEx02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ToggleButton tb1  = new ToggleButton();
		ToggleButton tb2  = new ToggleButton();
		ToggleButton tb3  = new ToggleButton();
		
		ToggleGroup group = new ToggleGroup();
		tb1.setToggleGroup(group);
		tb2.setToggleGroup(group);
		tb3.setToggleGroup(group);
		
		tb1.setGraphic(new ImageView("/img/magi.png"));
		tb2.setGraphic(new ImageView("/img/rogue.png"));
		tb3.setGraphic(new ImageView("/img/warrior.png"));
		
		HBox box = new HBox();
		box.getChildren().addAll(tb1, tb2, tb3);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		primaryStage.setTitle("ToggleButtonEx2");
		primaryStage.setScene(new Scene(box, 400, 200));
		primaryStage.show();
		
	}
	
	
}
