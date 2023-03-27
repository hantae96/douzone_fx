package com.example.fxproject.sample.fxSceneBuilder.ex2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex1 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ex1.fxml"));
		Parent form = loader.load();
		
		TextField id = (TextField)form.lookup("#idField");
		PasswordField pw = (PasswordField) form.lookup("#pwField");
		Button loginButton = (Button)form.lookup("#loginButton");
		
		loginButton.setOnMouseClicked(e->{
			System.out.println("아이디 : " + id.getText());
			System.out.println("비밀번호 : " + pw.getText());
		});
		
		primaryStage.setScene(new Scene(form));
		primaryStage.setTitle("ex1");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}


