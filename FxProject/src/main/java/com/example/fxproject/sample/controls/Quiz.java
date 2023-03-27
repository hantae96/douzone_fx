package com.example.fxproject.sample.controls;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Quiz extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane border =  new BorderPane();
		
		ArrayList<Label> topLabel = new ArrayList<Label>();
		topLabel.add(new Label("홈"));
		topLabel.add(new Label("사회"));
		topLabel.add(new Label("경제"));
		topLabel.add(new Label("국제"));
		topLabel.add(new Label("문화"));
		
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		top.setSpacing(30);
		top.setPadding(new Insets(20));

		top.getChildren().addAll(topLabel);
		border.setTop(top);
		
		ArrayList<Label> leftLabel = new ArrayList<Label>();
		leftLabel.add(new Label("카테고리"));
		leftLabel.add(new Label("노트북/PC"));
		leftLabel.add(new Label("자동차용품"));
		leftLabel.add(new Label("휴대폰"));
		leftLabel.add(new Label("캠핑/낚시"));
		
		VBox left = new VBox();
		left.setSpacing(20);
		left.setPadding(new Insets(10));
		left.setPrefWidth(100);
		
		left.getChildren().addAll(leftLabel);
		border.setLeft(left);
		
		
		VBox center = new VBox();
		
		HBox idBox = new HBox();
		Label idLabel = new Label("ID");
		idLabel.setPadding(new Insets(5, 5, 0, 0));
		
		idBox.getChildren().add(idLabel);
		idBox.getChildren().add(new TextField());
		idBox.setSpacing(15);
		center.getChildren().add(idBox);
		
		HBox pwBox = new HBox();
		Label pwLabel = new Label("PW");
		pwLabel.setPadding(new Insets(5, 0, 0, 0));
		
		pwBox.getChildren().add(pwLabel);
		pwBox.getChildren().add(new PasswordField());
		pwBox.setSpacing(15);
		center.getChildren().add(pwBox);

		HBox radioBox = new HBox();
		RadioButton woman = new RadioButton("여");
		RadioButton man = new RadioButton("남");
		ToggleGroup genderGroup = new ToggleGroup();
		woman.setToggleGroup(genderGroup);
		man.setToggleGroup(genderGroup);
		radioBox.getChildren().addAll(woman, man);
		radioBox.setSpacing(15);
		center.getChildren().add(radioBox);
		
		HBox checkBox = new HBox();
		CheckBox game = new CheckBox("게임");
		CheckBox study = new CheckBox("공부");
		checkBox.getChildren().addAll(game, study);
		checkBox.setSpacing(15);
		center.getChildren().add(checkBox);
		
		HBox sayBox = new HBox();
		sayBox.getChildren().add(new Label("하고 싶은 말"));
		center.getChildren().add(sayBox);
		
		HBox areaBox = new HBox();
		TextArea area = new TextArea();
		area.setPrefSize(170, 50);
		areaBox.getChildren().add(area);
		center.getChildren().add(areaBox);
		
		center.setSpacing(15);
		center.setPadding(new Insets(10));
		center.setMaxWidth(190);
		border.setCenter(center);
		
		/* RIGHT */
		TextField idFld = new TextField();
		PasswordField pwFld = new PasswordField();
		
		VBox idPw = new VBox();
		idPw.getChildren().addAll(idFld, pwFld);
		idPw.setSpacing(5);
		
		VBox login = new VBox();
		Button loginButton = new Button("로그인");
		loginButton.setPrefSize(70, 50);
		login.getChildren().add(loginButton);
		
		HBox right = new HBox();
		right.getChildren().addAll(idPw, login);
		right.setSpacing(5);
		right.setPadding(new Insets(10));
		border.setRight(right);
		
		primaryStage.setTitle("Quiz");
		primaryStage.setScene(new Scene(border, 550, 300));
		primaryStage.show();
	}
}