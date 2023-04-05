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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MeetingBoardModifyController implements Initializable{
	
	@FXML private Label mainCategory;
	@FXML private TextField title;
	@FXML private ComboBox<String> subCategory;
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
	private BoardDto board;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		subCategory.setItems(FXCollections.observableArrayList("밥/카페", "산책", "러닝", "운동", "독서", "스터디", "취미", "반려동물", "육아", "기타"));
		ampm.setItems(FXCollections.observableArrayList("오전","오후"));
		hour.setItems(FXCollections.observableArrayList("1시", "2시", "3시", "4시", "5시", "6시", "7시", "8시", "9시", "10시", "11시", "12시"));
		minute.setItems(FXCollections.observableArrayList("5분", "10분", "15분", "20분", "25분", "30분", "35분", "40분", "45분", "50분", "55분"));
		
		boardService = new BoardService();
		board = boardService.findBoardById(Session.getInstance().getTempId());
		
		mainCategory.setText(board.getMainCategory());
		title.setText(board.getTitle());
		subCategory.setValue(board.getSubCategory());
		content.setText(board.getContent());
		person.setText(board.getPerson());
		meetingDate.setValue(board.getMeetingDateToLocalDate());
		ampm.setValue(board.getMeetingTimeAmpm());
		hour.setValue(board.getMeetingTimeHour());
		minute.setValue(board.getMeetingTimeMinute());
		place.setText(board.getPlace());
		
		if(board.getGender() == "누구나")
			freeRadio.setSelected(true);
		else if(board.getGender() == "여자만")
			womanRadio.setSelected(true);
		else
			manRadio.setSelected(true);
		
		age.setText(board.getAge());
		
		
		
	}

	
	public void cancelBtnClick() {
		Session.getInstance().setTempId(board.getBoardId());
		Viewer.setView("meetingBoardDetailForm");
	}
	
	public void updateBtnClick() {
		
		String gender = null;
		
		if(freeRadio.isSelected())
			gender = "누구나";
		else if(manRadio.isSelected())
			gender = "남자만";
		else if(womanRadio.isSelected())
			gender = "여자만";
		
		boardService.updateMeetingBoard(new BoardDto(
				Session.getInstance().getTempId(),		//게시글 ID
				Session.getInstance().getAccountId(), 	//계정 ID
				mainCategory.getText(), 				//게시판 메인 카테고리
				subCategory.getValue(), 				//게시판 서브 카테고리
				title.getText(), 						//게시판 제목
				content.getText(),						//게시판 내용
				Session.getInstance().getAddress(),		//계정 주소
				person.getText(), 						//모임 인원수
				meetingDate.getValue(),					//모임 일정
				ampm.getValue(),						//모임 시간 AM/PM
				hour.getValue(),						//모임 시간 시
				minute.getValue(),						//모임 시간 분
				place.getText(),						//모임 장소
				gender,									//모임 성별
				age.getText()							//모임 나이
				));
		
	}
	
	
}
