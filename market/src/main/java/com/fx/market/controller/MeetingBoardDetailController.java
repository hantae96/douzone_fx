package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MeetingBoardDetailController implements Initializable{
	
	@FXML private Label ageLabel;
	@FXML private Label titleLabel;
	@FXML private Button menuBtn;
	@FXML private ContextMenu menuContextMenu;
	@FXML private MenuItem meetingEndMenuItem;
	@FXML private MenuItem meetingModifyMenuItem;
	@FXML private MenuItem meetingDeleteMenuItem;

	private BoardService boardService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		menuBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			
		    if (event.getButton() == MouseButton.PRIMARY) {
		    	menuContextMenu.show(menuBtn, event.getScreenX(), event.getScreenY());
		    }
		    
        });


		boardService = new BoardService();
		
		BoardDto board = boardService.boardDetail(Session.getInstance().getTempId());
		

		
	}

	public void btnCLick() {

	}
	
	public void backBtnClick() {
		
	}
	
	public void meetingEndMenuItemClick() {
		System.out.println("종료");
	}
	
	public void meetingModifyMenuItemClick() {
		Viewer viewer = new Viewer();
		viewer.setView("meetingBoardModifyForm");
	}
	
	public void meetingDeleteMenuItemClick() {
		System.out.println("삭제");
	}
}
