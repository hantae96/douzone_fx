package com.example.fxproject.sample.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPane02 extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label1 = new Label("아이디");
		Label label2 = new Label("비밀번호");

		TextField id = new TextField();
		PasswordField pw = new PasswordField();

		GridPane.setConstraints(label1, 0, 0);
		GridPane.setConstraints(label2, 0, 1);
		GridPane.setConstraints(id, 1, 0);
		GridPane.setConstraints(pw, 1, 1);

		GridPane grid = new GridPane();
		grid.getChildren().addAll(id, pw, label1, label2);
		grid.setVgap(20);
		grid.setHgap(40);
		//new Insets(30);
		// new Insets(TOP, RIGHT, BOTTOM, LEFT)
		grid.setPadding(new Insets(50, 0, 0, 30));

		FlowPane flow = new FlowPane();
		flow.getChildren().add(new Button("Merge col(0) row(2)"));
		flow.setPrefSize(250, 20);
		flow.setStyle("-fx-background-color: #6EE3F7");
		flow.setAlignment(Pos.CENTER);

		grid.add(flow, 0, 2, 2, 1);

		Scene scene = new Scene(grid, 300, 200);
		primaryStage.setTitle("GridPaneEx2");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}





