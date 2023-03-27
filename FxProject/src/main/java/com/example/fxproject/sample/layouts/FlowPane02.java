package com.example.fxproject.sample.layouts;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPane02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane flow = new FlowPane();
		ArrayList<Button> buttons = new ArrayList<>();
		
		for(int i = 0; i < 15; i++) {
			buttons.add(new Button("버튼"+(i+1)));
			flow.getChildren().add(buttons.get(i));
		}

		primaryStage.setScene(new Scene(flow, 200, 150));
		primaryStage.show();
	}



}





