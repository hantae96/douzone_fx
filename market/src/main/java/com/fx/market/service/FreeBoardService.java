package com.fx.market.service;



import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dao.FreeBoardDao;
import com.fx.market.dto.FreeBoardDto;
import com.fx.market.dto.PhotoDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FreeBoardService {
	private FreeBoardDao townDao = new FreeBoardDao();
	private FreeBoardDto townDto = new FreeBoardDto();

	public void photoInsert(PhotoDto photoDto) {
		
		townDao.photosInsert(photoDto);
		
	}
	
	public void boardClick(String main_category,String sub_category,String title, String content){
		Alert alert = new Alert(AlertType.INFORMATION);
		
		if(sub_category == null) {
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
			townDto.setMain_category(main_category);
			townDto.setAcount_Id(session.getAccountId());
			townDto.setSub(sub_category);
			townDto.setTitle(title);
			townDto.setContent(content);
			townDao.insertFreeBoard(townDto);
			
			String id = townDao.findBoardId(title);
			session.setTempId(id);
			
			alert.setHeaderText("게시물이 등록되었습니다");
			alert.show();
			
		}

	}
	

	public void updateboardClick(String sub_category,String title,String content, String board_id) {

		Alert alert = new Alert(AlertType.INFORMATION);
		
		if(sub_category == null) {
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
			townDto.setSub(sub_category);
			townDto.setTitle(title);
			townDto.setContent(content);
			townDto.setBoard_Id(board_id);
			townDao.updateFreeBoard(townDto);
		
			alert.setHeaderText("게시물이 수정되었습니다");
			alert.show();
			
		}
	}




	public FreeBoardDto selectAll(String board_Id) {
		System.out.println("service");
		return townDao.selectAll(board_Id);
	}




	public void deleteClick(String board_Id) {
		System.out.println("deleteClick");
		townDao.deleteClick(board_Id);
		

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("게시물이 삭제되었습니다");
		alert.show();
	}

	public String photoInfo(String board_Id) {
		System.out.println("photoInfo");
		
		return townDao.selectboard_Id(board_Id);
	}

	public void photoUpdate(PhotoDto photoDto) {
		townDao.photosUpdate(photoDto);
	}
}
