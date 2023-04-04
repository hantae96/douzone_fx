package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.dto.MeetingAttendeesDto;
import com.fx.market.service.BoardService;
import com.fx.market.service.MeetingAttendeesService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MeetingBoardDetailController implements Initializable{
	
	@FXML private Label mainCategoryLabel;
	@FXML private Label subCategoryLabel;
	@FXML private Label stateLabel;
	@FXML private Label titleLabel;
	@FXML private Label ageLabel;
	@FXML private Label genderLabel;
	@FXML private Label meetingDateLabel;
	@FXML private Label meetingTimeLabel;
	@FXML private Label placeLabel;
	@FXML private Label contentLabel;
	
	@FXML private Label attendLabel;
	@FXML private Label leaderIdLabel;
	@FXML private Label leaderAddressLabel;
	@FXML private Button attendBtn;
	@FXML private VBox attendAccountsVBox;
	
	@FXML private Button menuBtn;
	@FXML private ContextMenu menuContextMenu;
	@FXML private MenuItem meetingEndMenuItem;
	@FXML private MenuItem meetingModifyMenuItem;
	@FXML private MenuItem meetingDeleteMenuItem;

	private BoardService boardService;
	private MeetingAttendeesService meetingAttendService;
	private List<MeetingAttendeesDto> meetingAttendDtos;
	
	private BoardDto board;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			
		    if (event.getButton() == MouseButton.PRIMARY) {
		    	menuContextMenu.show(menuBtn, event.getScreenX(), event.getScreenY());
		    }
		    
        });


		boardService = new BoardService();
		
		board = boardService.boardDetail(Session.getInstance().getTempId());
		
		mainCategoryLabel.setText(board.getMainCategory());
		subCategoryLabel.setText(board.getSubCategory());
		stateLabel.setText(board.getState());
		titleLabel.setText(board.getTitle());
		ageLabel.setText(board.getAge());
		genderLabel.setText(board.getGender());
		meetingDateLabel.setText(board.getMeetingDateFormat());
		meetingTimeLabel.setText(board.getMeetingTime());
		placeLabel.setText(board.getPlace());
		contentLabel.setText(board.getContent());
		
		
		BorderWidths borderWitdths = new BorderWidths(0, 0, 1, 0); // bottom border width = 1
		BorderStroke borderStroke = new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, borderWitdths);
		Border border = new Border(borderStroke);
		attendLabel.setBorder(border);
		leaderIdLabel.setText(board.getAccountId());
		leaderAddressLabel.setText(board.getAddress());
		
		System.out.println("true : "+board.getAccountId().equals(Session.getInstance().getAccountId()));
		System.out.println(board.getAccountId());
		System.out.println(Session.getInstance().getAccountId());
//		
		if(board.getAccountId().equals(Session.getInstance().getAccountId())) {
			menuBtn.setVisible(true);
		}
		
		if(board.getState().equals("모집종료") || board.getAccountId().equals(Session.getInstance().getAccountId())) {
			attendBtn.setDisable(true);
		}
		
		meetingAttendService = new MeetingAttendeesService();
		meetingAttendDtos = meetingAttendService.getMeetingAttendList(board.getBoardId());
		
		for(MeetingAttendeesDto meeting : meetingAttendDtos) {
			BorderPane attendPane = new BorderPane();
			attendPane.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 1, 1, 1))));
			attendPane.setPadding(new Insets(2, 2, 2, 4));
			
			Image attendImage = new Image("file:"+meeting.getPath());
			ImageView attendImageView = new ImageView(attendImage);
			attendImageView.setFitWidth(40);
			attendImageView.setFitHeight(40);
			
			
			VBox attendCenter = new VBox();
			
			Label attendName = new Label(meeting.getName());
			attendName.setPrefHeight(20);
			attendName.setPadding(new Insets(0, 0, 0, 5));
			Label attendAddress = new Label(meeting.getAddress());
			attendAddress.setPrefHeight(20);
			attendAddress.setPadding(new Insets(0, 0, 0, 5));
			attendCenter.getChildren().addAll(attendName, attendAddress);
			
			attendPane.setLeft(attendImageView);
			attendPane.setCenter(attendCenter);
			attendAccountsVBox.getChildren().add(attendPane);
			
			if(meeting.getAccountId().equals(Session.getInstance().getAccountId())) {
				attendBtn.setDisable(true);
				attendBtn.setText("참여완료");
			}
		}
	}
	
	public void meetingEndMenuItemClick() {
		boardService.updateMeetingState(board.getBoardId());
	}
	
	public void meetingModifyMenuItemClick() {
		Session.getInstance().setTempId(board.getBoardId());
		Viewer.setView("meetingBoardModifyForm");
	}
	
	public void meetingDeleteMenuItemClick() {
		
	    Optional<ButtonType> result = CommonService.msgShowAndWait(AlertType.CONFIRMATION, "게시글 삭제", "이 게시글를 삭제하시겠습니까?", "삭제한 게시글은 복구할 수 없습니다.");
	    if (result.isPresent() && result.get() == ButtonType.OK){
			boardService = new BoardService();
	    	boardService.deleteBoard(board.getBoardId());
	    	
	    }
	    
	}
	
	public void backBtnClick() {
		Viewer.setView("meetingBoardListForm");
	}
	
	
	public void attendBtnClick() {
		meetingAttendService = new MeetingAttendeesService();
		Session.getInstance().setTempId(board.getBoardId());
		meetingAttendService.attendMeeting(new MeetingAttendeesDto(
				board.getBoardId(),						// 게시글 ID
				Session.getInstance().getAccountId()	// 계정 ID
		));
	}
}