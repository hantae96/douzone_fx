 package com.fx.market.service;

import java.util.List;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
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
			CommonService.msg(AlertType.INFORMATION, "게시글 등록", "게시글이 등록되었습니다.", "");
		}
		
		Viewer.setView("meetingBoardListForm");
	}



	public List<BoardDto> selectMeetingBoardList() {
		
		return boardDao.findByMeetingBoardList();
	}



	public BoardDto boardDetail(String boardId) {
		return boardDao.findByMeetingBoardDetail(boardId);
	}



	public void deleteBoard(String boardId) {
		int result = boardDao.deleteBoard(boardId, Session.getInstance().getAccountId());
		if(result != 0) {
			CommonService.msg(AlertType.INFORMATION, "게시글 삭제", "게시글이 삭제되었습니다.","");
			Viewer.setView("meetingBoardListForm");
		}
		
	}


	public void updateMeetingBoard(BoardDto boardDto) {
		
		System.out.println("Service");
		int result = boardDao.updateMeetingBoard(boardDto);
		if(result != 0) {
			CommonService.msg(AlertType.INFORMATION, "게시글 수정", "게시글이 수정되었습니다.", "");
			Viewer.setView("meetingBoardListForm");
			
		}
	}



	public void updateMeetingState(String boardId) {
		int result = boardDao.updateMeetingState(boardId);
		if(result != 0) {
			CommonService.msg(AlertType.INFORMATION, "모집 종료", "모집이 종료되었습니다.", "");
			Session.getInstance().setTempId(boardId);
			Viewer.setView("meetingBoardDetailForm");
		}
		
	}



	public List<BoardDto> searchBoardList(String searchStr) {
		
		return boardDao.findByBoardList(searchStr);
	}
}