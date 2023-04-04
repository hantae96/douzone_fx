package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.dto.MeetingAttendDto;
import com.fx.market.service.BoardService;
import com.fx.market.service.MeetingAttendService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
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
	@FXML private VBox attendAccounts;
	
	@FXML private Button menuBtn;
	@FXML private ContextMenu menuContextMenu;
	@FXML private MenuItem meetingEndMenuItem;
	@FXML private MenuItem meetingModifyMenuItem;
	@FXML private MenuItem meetingDeleteMenuItem;

	private BoardService boardService;
	private MeetingAttendService meetingAttendService;
	private List<MeetingAttendDto> meetingAttendDtos;
	
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
		
//		System.out.println("true : "+board.getAccountId().equals(Session.getInstance().getAccountId()));
//		System.out.println(board.getAccountId());
//		
//		if(board.getAccountId() == Session.getInstance().getAccountId()) {
//			menuBtn.setVisible(true);
//		}
		
//		if(board.getAccountId().equals(Session.getInstance().getAccountId()) || board.getState().equals("모집종료") ) {
//			attendBtn.setVisible(false);
//		}
		
		meetingAttendService = new MeetingAttendService();
		System.out.println("controller");
		meetingAttendDtos = meetingAttendService.getMeetingAttendList(board.getBoardId());
		
		for(MeetingAttendDto meeting : meetingAttendDtos) {
			System.out.println("Name : "+meeting.getName());
			System.out.println("path : "+meeting.getPath());
			System.out.println("address : "+meeting.getAddress());
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
		meetingAttendService = new MeetingAttendService();
		meetingAttendService.attendMeeting(
				new MeetingAttendDto(
						board.getBoardId(),
						Session.getInstance().getAccountId()
						)
				);
	}
}