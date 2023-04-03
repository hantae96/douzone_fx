package com.fx.market.service;



import com.fx.market.common.Session;
import com.fx.market.dao.FreeBoardDao;
import com.fx.market.dto.FreeBoardDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FreeBoardService {
	private FreeBoardDao townDao;
	private FreeBoardDto townDto;


	
	public void boardClick(String main_category,String sub,String title, String content){
		System.out.println("service");
		townDao = new FreeBoardDao();
		townDto = new FreeBoardDto();
		Alert alert = new Alert(AlertType.INFORMATION);
		
		if(sub == null) {
			alert.setHeaderText("주제를 입력해주세요.");
			alert.show();
		}else if(title.isBlank()) {
			alert.setHeaderText("제목을 입력해주세요.");
			alert.show();
		}else if(content.isBlank()) {
			alert.setHeaderText("내용을 입력해주세요.");
			alert.show();
		}
		else {
			 Session session = Session.getInstance();
			 session.getInstance().getaddress();
			 session.getAccountId();
			
			townDto.setAddress(session.getAddress());
			townDto.setMain_category(main_category);
			townDto.setAcount_Id(session.getAccountId());
			townDto.setSub(sub);
			townDto.setTitle(title);
			townDto.setContent(content);
			townDao.insertFreeBoard(townDto);
			alert.setHeaderText("게시물이 등록되었습니다");
			alert.show();
		}

	}

	public void updateboardClick(String sub,String title,String content, String board_id) {
		townDao = new FreeBoardDao();
		townDto = new FreeBoardDto();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		
		if(sub == null) {
			alert.setHeaderText("주제를 입력해주세요.");
			alert.show();
		}else if(title.isBlank()) {
			alert.setHeaderText("제목을 입력해주세요.");
			alert.show();
		}else if(content.isBlank()) {
			alert.setHeaderText("내용을 입력해주세요.");
			alert.show();
		}
		else {
			townDto.setSub(sub);
			townDto.setTitle(title);
			townDto.setContent(content);
			townDto.setBoard_Id(board_id);
			townDao.updateFreeBoard(townDto);
			alert.setHeaderText("게시물이 등록되었습니다");
			alert.show();
		}
	}

	public FreeBoardDto selectBoard(String boardsId) {
		townDao = new FreeBoardDao();
		
		return townDao.selectBoard(boardsId);
	}	
}
