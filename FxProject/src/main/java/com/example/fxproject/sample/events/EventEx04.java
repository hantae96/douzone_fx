package com.example.fxproject.sample.events;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventEx04 extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label("클릭");
		label.setFont(new Font(24));
		label.setLayoutX(120);
		label.setLayoutY(80);
		
		EventHandler<Event> eh;
		
		eh = (e) -> {
			label.setFont(new Font(40));
		};
		label.setOnMouseClicked(eh);
		
		eh = (e) -> {
			label.setFont(new Font(24));
		};
		label.setOnMouseExited(eh);
		
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().add(label);
		primaryStage.setTitle("EventEx2");
		primaryStage.setScene(new Scene(anchor, 300, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}






