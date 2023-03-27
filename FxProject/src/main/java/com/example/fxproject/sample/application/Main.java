package com.example.fxproject.sample.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Label label = new Label();
			label.setText("출력할 내용");
			
			Font font = new Font(30);
			label.setFont(font);
			
			Scene scene = new Scene(label, 400, 300);
			
//			Toolkit tk = Toolkit.getDefaultToolkit();
//			Dimension screenSize = tk.getScreenSize();
//			System.out.println("width : " + screenSize.width);
//			System.out.println("height : " + screenSize.height);
//			int x = screenSize.width;
//			int y = screenSize.height;
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("아무거나");
			primaryStage.setX(500/2 - 200);
			primaryStage.setY(500/2 - 150);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}







