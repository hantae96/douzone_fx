package com.example.fxproject.sample.events;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Quiz extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label search = new Label("Search", new ImageView("/img/search.png"));
		Label values = new Label("Values");
		Label texts = new Label("A label that nees to be warraped");

		search.setFont(new Font(24));
		search.setTextFill(Color.BLUE);
		
		values.setFont(new Font("Times New Roman",24));
		
		texts.setWrapText(true);
		texts.setPrefWidth(100);
		
		search.setOnMouseEntered(
			(e) -> {
				search.setScaleX(1.5);
				search.setScaleY(1.5);
			}
		);
		
		search.setOnMouseExited(
			(e) -> {
				search.setScaleX(1);
				search.setScaleY(1);
			}
		);
		
		values.setOnMouseEntered((e) -> {
			values.setScaleX(1.5);
			values.setScaleY(1.5);
			values.setRotate(270);
		});
		
		values.setOnMouseExited(
			(e) -> {
				values.setScaleX(1);
				values.setScaleY(1);
				values.setRotate(0);
			}
		);
		
		texts.setOnMouseEntered((e) -> {
			texts.setScaleX(1.5);
			texts.setScaleY(1.5);
		});
		
		texts.setOnMouseExited(
			(e) -> {
				texts.setScaleX(1);
				texts.setScaleY(1);
			}
		);
		HBox box = new HBox();
		box.getChildren().addAll(search, values, texts);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(50);
		primaryStage.setTitle("Quiz");
		primaryStage.setScene(new Scene(box, 500, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}






