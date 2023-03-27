package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz3 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	public Pane getPane(double width, double height, String color) {
		Pane p = new Pane();
		p.setPrefSize(width, height);
		p.setStyle("-fx-background-color: " + color);
		return p;
	}
	public HBox getHbox() {
		HBox hBox = new HBox();
		hBox.getChildren().add(getPane(100, 100, "red"));
		hBox.getChildren().add(getPane(100, 100, "orange"));
		hBox.getChildren().add(getPane(100, 100, "black"));
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(20));
		return hBox;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox vBox = new VBox();
		vBox.getChildren().add(getHbox());
		vBox.getChildren().add(getHbox());
		vBox.getChildren().add(getHbox());
		vBox.setSpacing(10);
		
		primaryStage.setTitle("Quiz2");
		primaryStage.setScene(new Scene(vBox, 500, 400));
		primaryStage.show();
	}

}




