package com.fx.market.service;



import com.fx.market.common.Session;
import com.fx.market.dao.TownDao;
import com.fx.market.dto.TownDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FreeBoardService {
	private TownDao townDao;
	private TownDto townDto;


	
	public void boardClick(String main_category,String middle_category,String title, String content){
		townDao = new TownDao();
		townDto = new TownDto();
		Alert alert = new Alert(AlertType.INFORMATION);
		
		if(middle_category == null) {
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
			 session.getAccountId();
			
			townDto.setMain_category(main_category);
			townDto.setAcount_Id(session.getAccountId());
			townDto.setMiddle_category(middle_category);
			townDto.setTitle(title);
			townDto.setContent(content);
			townDao.insertFreeBoard(townDto);
			alert.setHeaderText("게시물이 등록되었습니다");
			alert.show();
		}

	}	
}
