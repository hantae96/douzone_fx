package com.example.fxproject.sample.fxSceneBuilder.ex4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("regForm.fxml"));
		Parent regForm = loader.load();
		
		ComboBox<String> ageBox = (ComboBox<String>)regForm.lookup("#ageCombo");
		ageBox.getItems().addAll("10대", "20대", "30대", "40대");
		
		Scene scene = new Scene(regForm);
		primaryStage.setTitle("회원가입 화면");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}
}





