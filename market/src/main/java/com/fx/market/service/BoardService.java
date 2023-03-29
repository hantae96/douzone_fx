package com.fx.market.service;

import com.fx.market.dao.BoardDao;
import com.fx.market.dto.BoardDto;

public class BoardService {

	private BoardDao boardDao;
	
	
	public BoardService() {
		boardDao = new BoardDao();
	}



	public void meetingBoardWrite(BoardDto boardDto) {
		System.out.println("BoardService.title : "+boardDto.getTitle());
		
		boardDao.insertMeetingBoard(boardDto);
	}

}
