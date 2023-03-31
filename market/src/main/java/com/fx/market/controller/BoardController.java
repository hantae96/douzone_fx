package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BoardController implements Initializable{
	
	@FXML private TextField title;
	@FXML private ComboBox<String> middleCategory;
	@FXML private TextArea content;
	@FXML private TextField person;
	@FXML private DatePicker meetingDate;
	@FXML private ChoiceBox<String> ampm;
	@FXML private ChoiceBox<Integer> hour;
	@FXML private ChoiceBox<Integer> minute;
	@FXML private TextField	place;
	@FXML private RadioButton freeRadio;
	@FXML private RadioButton womanRadio;
	@FXML private RadioButton manRadio;
	@FXML private TextField age;
	
	private BoardService boardService;

	
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();
		
		middleCategory.setItems(FXCollections.observableArrayList("밥/카페", "산책", "러닝", "운동", "독서", "스터디", "취미", "반려동물", "육아", "기타"));
		ampm.setItems(FXCollections.observableArrayList("오전","오후"));
		hour.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		minute.setItems(FXCollections.observableArrayList(10, 20, 30, 40, 50));
		
	}
	
	public void meetingBoardWriteBtnClick() {
		
		System.out.println(title.getText());
		System.out.println(middleCategory.getValue());
		System.out.println(content.getText());
		System.out.println(person.getText());
		System.out.println(meetingDate.getValue());
		System.out.println(ampm.getValue()+" "+hour.getValue()+":"+minute.getValue());
		System.out.println(place.getText());
//		System.out.println(gender.getText());
		System.out.println(age.getText());
		
		String gender = null;
		
		if(freeRadio.isSelected())
			gender = "누구나";
		else if(manRadio.isSelected())
			gender = "남자만";
		else if(womanRadio.isSelected())
			gender = "여자만";
		
		boardService.meetingBoardWrite(new BoardDto(
				Session.getInstance().getAccountId(), 
				"함께해요", 
				middleCategory.getValue(), 
				title.getText(), 
				content.getText(),
				person.getText(), 
				meetingDate.getValue(),
				ampm.getValue(),
				hour.getValue(),
				minute.getValue(),
				place.getText(),
				gender,
				age.getText()
				));
		
		
	}
	
	
	
	public void goBackBtnClick() {
		
	}

}
