package com.example.fxproject.sample.layouts;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Quiz5 extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane border = new BorderPane();
		
		ArrayList<Label> labels = new ArrayList<Label>();
		labels.add(new Label("메뉴"));
		labels.add(new Label("홈"));
		labels.add(new Label("로그인"));
		
		FlowPane flowTop = new FlowPane();
		flowTop.setHgap(100);
		flowTop.setStyle("-fx-background-color: pink");
		flowTop.setAlignment(Pos.CENTER);
		flowTop.setPadding(new Insets(15));
		flowTop.getChildren().addAll(labels);
		border.setTop(flowTop);
		
		ListView<String> lv = new ListView<String>();
		lv.getItems().addAll("아이템1", "아이템2", "아이템3");
		lv.setPrefSize(80,100);
		FlowPane flowLeft = new FlowPane();
		flowLeft.getChildren().add(lv);
		flowLeft.setPrefWidth(100);
		border.setLeft(flowLeft);
		
		FlowPane flowCenter = new FlowPane();
		flowCenter.getChildren().add(new Button("내용 들어가는 곳"));
		border.setCenter(flowCenter);
		
		Button buttonId = new Button("아이디 입력");
		Button buttonPw = new Button("비밀번호 입력");
		Button buttonLogin = new Button("로그인");
		buttonId.setPrefSize(120, 20);
		buttonPw.setPrefSize(120, 20);
		buttonLogin.setPrefSize(90, 45);
		
		GridPane gridRight = new GridPane();
		gridRight.add(buttonId, 0, 0);
		gridRight.add(buttonPw, 0, 1);
		gridRight.add(buttonLogin, 1, 0, 1, 2);
		gridRight.setPadding(new Insets(20));
		border.setRight(gridRight);
		
		FlowPane flowBottom = new FlowPane();
		flowBottom.setPrefHeight(40);
		flowBottom.setAlignment(Pos.CENTER);
		flowBottom.getChildren().add(new Button("바닥글 들어가는 곳"));
		border.setBottom(flowBottom);
		
		ImageView image = new ImageView("/img/quiz.jpg");
		
		StackPane stack = new StackPane();
		stack.getChildren().addAll(image, border);
		primaryStage.setTitle("Quiz5");
		primaryStage.setScene(new Scene(stack, 500,250));
		primaryStage.show();
	}

}




