package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DatePickerEx extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		DatePicker date = new DatePicker();

		HBox box = new HBox();
		box.getChildren().add(date);
		box.setAlignment(Pos.CENTER);

		Scene scene = new Scene(box, 200, 300);
		primaryStage.setTitle("DatePickerEX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
