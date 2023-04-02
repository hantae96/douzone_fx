package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.collections.FXCollections;
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
	@FXML private ChoiceBox<String> hour;
	@FXML private ChoiceBox<String> minute;
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
		hour.setItems(FXCollections.observableArrayList("1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11", "12"));
		minute.setItems(FXCollections.observableArrayList("5분", "10분", "15분", "20분", "25분", "30분", "35분", "40분", "45분", "50분", "55분"));
		
	}
	
	public void meetingBoardWriteBtnClick() {
		
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
				Session.getInstance().getAddress(),
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
	
	public void cancelBtnClick() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}
	

}
