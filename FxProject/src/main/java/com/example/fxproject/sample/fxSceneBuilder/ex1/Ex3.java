package com.example.fxproject.sample.fxSceneBuilder.ex1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Ex3 extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ex3.fxml"));
		Parent form = loader.load();
		
		ListView<String> lv = (ListView<String>)form.lookup("#listView");
		lv.getItems().addAll("아이템1", "아이템2", "아이템3");
		
		Scene scene = new Scene(form);
		
		primaryStage.setTitle("Ex3");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}



