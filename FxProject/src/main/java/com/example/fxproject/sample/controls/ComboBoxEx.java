package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxEx extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("멍때리기", "침대와 혼연일체", "축구는 눈으로만 시청하기");
		combo.setValue("침대와 혼연일체");

		HBox box = new HBox();
		box.getChildren().add(combo);
		box.setAlignment(Pos.CENTER);

		Scene scene = new Scene(box, 400, 100);
		primaryStage.setTitle("ComboBoxEX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}
