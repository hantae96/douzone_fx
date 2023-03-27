package com.example.fxproject.sample.fxSceneBuilder.ex3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginForm.fxml"));
		Parent loginForm = loader.load();

		Scene scene = new Scene(loginForm);
		primaryStage.setTitle("로그인 화면");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}
}





