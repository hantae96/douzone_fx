package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BoardController implements Initializable{
	
	@FXML private TextField title;
	@FXML private ComboBox<String> middleCategory;
	@FXML private TextArea content;
	@FXML private TextField person;
	@FXML private TextField meetingDate;
	@FXML private TextField meetingTime;
	@FXML private TextField	place;
	@FXML private TextField gender;
	@FXML private TextField age;
	
	private BoardService boardService;

	
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();
		
		ObservableList<String> middlCategoryList = FXCollections.observableArrayList("밥/카페", "산책", "러닝", "운동", "독서", "스터디", "취미", "반려동물", "육아", "기타");

		middleCategory.setItems(middlCategoryList);
		
	}
	
	public void meetingBoardWriteBtnClick() {
		
		System.out.println(title.getText());
		System.out.println(middleCategory.getValue());
		System.out.println(content.getText());
		System.out.println(person.getText());
		System.out.println(meetingDate.getText());
		System.out.println(meetingTime.getText());
		System.out.println(place.getText());
		System.out.println(gender.getText());
		System.out.println(age.getText());
		
		boardService.meetingBoardWrite(new BoardDto(
				"",
				"", 
				"", 
				middleCategory.getValue(), 
				title.getText(), 
				content.getText(),
				person.getText(), 
				meetingDate.getText(),
				meetingTime.getText(),
				place.getText(),
				gender.getText(),
				age.getText()
				));
		
	}
	
	public void goBackBtnClick() {
		
	}

}
