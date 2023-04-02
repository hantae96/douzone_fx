package com.fx.market.service;

import java.util.List;

import com.fx.market.common.CommonService;
import com.fx.market.common.Viewer;
import com.fx.market.dao.BoardDao;
import com.fx.market.dto.BoardDto;

import javafx.scene.control.Alert.AlertType;

public class BoardService {

	private BoardDao boardDao;
	
	
	public BoardService() {
		boardDao = new BoardDao();
	}



	public void meetingBoardWrite(BoardDto boardDto) {
		System.out.println("BoardService.title : "+boardDto.getTitle());
		
		int result = boardDao.insertMeetingBoard(boardDto);
		
		if(result != 0) {
			CommonService.msg(AlertType.CONFIRMATION, "정보", "등록 성공");
		}
		
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}



	public List<BoardDto> selectMeetingBoardList() {
		
		return boardDao.findByMeetingBoardList();
	}



	public BoardDto boardDetail(String boardId) {
		System.out.println("service : "+boardId);
		return boardDao.findByMeetingBoardDetail(boardId);
	}

}