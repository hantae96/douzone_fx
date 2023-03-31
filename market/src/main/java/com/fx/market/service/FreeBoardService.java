package com.fx.market.service;

import com.fx.market.dao.TownDao;
import com.fx.market.dto.town.TownDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FreeBoardService {
	private TownDao townDao;
	private TownDto townDto;


	
	public void boardClick(String middle_category,String title, String content){
		townDao = new TownDao();
		townDto = new TownDto();
		Alert alert = new Alert(AlertType.INFORMATION);
		System.out.println(middle_category);
		System.out.println(title);
		System.out.println(content);
	//	content.isBlank();
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
			townDto.setMiddle_category(middle_category);
			townDto.setTitle(title);
			townDto.setContent(content);
<<<<<<< Updated upstream
//			townDao.insertFreeBoard(townDto);
=======
			//townDao.insertFreeBoard(townDto);
>>>>>>> Stashed changes
			alert.setHeaderText("게시물이 등록되었습니다");
			alert.show();
		}

	}	
}
