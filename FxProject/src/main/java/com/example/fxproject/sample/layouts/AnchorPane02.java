package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPane02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> lv = new ListView<>();
		lv.getItems().addAll("아이템1", "아이템2", "아이템3");
		lv.setPrefSize(100, 70);
		lv.setLayoutX(90);
		lv.setLayoutY(50);
		
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().add(lv);
		
		Scene scene = new Scene(anchor, 300, 200);
		primaryStage.setTitle("AnchorPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}





