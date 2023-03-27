package com.example.fxproject.sample.controls;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CheckBoxEx extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CheckBox check1 = new CheckBox("체크1");
		CheckBox check2 = new CheckBox("체크2");

		check1.setText("멍때리기");
		check2.setText("침대와 혼연일체");

		check2.setSelected(true);

		System.out.println("check1 : " + check1.isSelected());
		System.out.println("check2 : " + check2.isSelected());

		HBox box = new HBox(10);
		box.getChildren().addAll(check1, check2);
		box.setAlignment(Pos.CENTER);

		primaryStage.setTitle("CheckBoxEx");
		primaryStage.setScene(new Scene(box, 200, 100));
		primaryStage.show();
		
	}
	
	
}
