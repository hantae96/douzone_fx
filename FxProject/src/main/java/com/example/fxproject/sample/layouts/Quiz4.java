package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz4 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public Pane getPane(double width, double height, String color) {
		Pane p = new Pane();
		p.setPrefSize(width, height);
		p.setStyle("-fx-background-color: " + color);
		return p;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox1 = new VBox();
		vBox1.getChildren().add(getPane(200, 50, "red"));
		vBox1.getChildren().add(getPane(200, 50, "orange"));
		vBox1.setSpacing(10);
		
		VBox vBox2 = new VBox();
		vBox2.getChildren().add(getPane(100, 110, "black"));
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(vBox1, vBox2);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(30, 0, 0, 30));
		primaryStage.setTitle("Quiz2");
		primaryStage.setScene(new Scene(hBox, 400, 200));
		primaryStage.show();
	}

}




