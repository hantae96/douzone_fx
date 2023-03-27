package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz2 extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane p1 = new Pane();
		Pane p2 = new Pane();
		Pane p3 = new Pane();
		Pane p4 = new Pane();
		Pane p5 = new Pane();
		Pane p6 = new Pane();
		
		p1.setStyle("-fx-background-color: red");
		p2.setStyle("-fx-background-color: orange");
		p3.setStyle("-fx-background-color: black");
		p4.setStyle("-fx-background-color: red");
		p5.setStyle("-fx-background-color: orange");
		p6.setStyle("-fx-background-color: black");
		
		// double.....
		p1.setPrefSize(100.0, 100.0);
		p2.setPrefSize(100.0, 100.0);
		p3.setPrefSize(100.0, 100.0);
		p4.setPrefSize(100.0, 100.0);
		p5.setPrefSize(100.0, 100.0);
		p6.setPrefSize(100.0, 100.0);
		
		HBox hBox1 = new HBox();
		hBox1.getChildren().add(p1);
		hBox1.getChildren().add(p2);
		hBox1.getChildren().add(p3);
		hBox1.setSpacing(10);
		hBox1.setPadding(new Insets(20));
		
		HBox hBox2 = new HBox();
		hBox2.getChildren().addAll(p4, p5, p6);
		hBox2.setSpacing(10);
		hBox2.setPadding(new Insets(20));
		
		VBox vBox = new VBox();
		vBox.getChildren().add(hBox1);
		vBox.getChildren().add(hBox2);
//		vBox.setSpacing(10);
		
		primaryStage.setTitle("Quiz2");
		primaryStage.setScene(new Scene(vBox, 500, 400));
		primaryStage.show();
	}

}




