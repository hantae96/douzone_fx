package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MeetingBoardDetailController implements Initializable{
	
	@FXML private Label ageLabel;
	@FXML private Label titleLabel;

	private BoardService boardService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		boardService = new BoardService();
		
		BoardDto board = boardService.boardDetail(Session.getInstance().getTempId());
		
//		ageLabel.setText(board.getAge());
//		titleLabel.setText(board.getTitle());
		System.out.println(board.getAge());
		
	}

	public void btnCLick() {

	}
	
	public void goBackBtnClick() {
		
	}
}
