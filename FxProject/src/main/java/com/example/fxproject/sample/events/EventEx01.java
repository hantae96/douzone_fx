package com.example.fxproject.sample.events;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventEx01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<>();
		
		Label label = new Label("클릭");
		label.setFont(new Font(24));
		label.setLayoutX(120);
		label.setLayoutY(80);
//		EventHandler eh = new EventHandler() {
//			@Override
//			public void handle(Event event) {
//				System.out.println("레이블 위에 마우스 포인터가 있다.");
//			}
//		};
		
		EventHandler<Event> eh = (e) -> {
			System.out.println("레이블 위에 마우스 포인터가 있다.");
		};
		
		label.setOnMouseEntered(eh);
//		label.setOnMouseClicked(eh);
		
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().add(label);
		primaryStage.setTitle("EventEx1");
		primaryStage.setScene(new Scene(anchor, 300, 200));
		primaryStage.show();
	}

}






