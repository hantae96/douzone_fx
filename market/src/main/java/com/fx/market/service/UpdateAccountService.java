package com.fx.market.service;

import com.fx.market.dao.LoginDao;
import com.fx.market.dto.LoginDto;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UpdateAccountService {

	private LoginDao logindao = new LoginDao();

	
	//정보 수정 비밀번호 확인 
	public int confirmAccount(String id, String pw) {
		LoginDto dbUser = logindao.idCheck(id, pw); 
		
		if(pw.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("알림");
			alert.setContentText("비밀번호를 입력하세요.");
			alert.show();
			return 0;
			}else if(dbUser == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("알림");
				alert.setContentText("비밀번호를 확인하세요.");
				alert.show();
			}else{ 
				return 1;
			}
	return 0;
}

}
