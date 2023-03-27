package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPane01 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button[] buttons = new Button[4];
		String[] texts = { "TOP", "LEFT", "RIGHT", "BOTTOM" };

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(texts[i]);
		}

		AnchorPane.setTopAnchor(buttons[0], 10.0);
		AnchorPane.setLeftAnchor(buttons[1], 50.0);
		AnchorPane.setRightAnchor(buttons[2], 30.0);
		AnchorPane.setBottomAnchor(buttons[3], 40.0);

		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().addAll(buttons[0], buttons[1], buttons[2], buttons[3]);

		Scene scene = new Scene(anchor, 300, 200);
		primaryStage.setTitle("AnchorPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}





