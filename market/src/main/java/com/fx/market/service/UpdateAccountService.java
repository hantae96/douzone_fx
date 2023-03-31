package com.fx.market.service;

import com.fx.market.common.Session;
import com.fx.market.dao.LoginDao;
import com.fx.market.dao.UpdateAccountDao;
import com.fx.market.dto.LoginDto;
import com.fx.market.dto.UpdateDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UpdateAccountService {

	private LoginDao logindao = new LoginDao();
	private UpdateAccountDao updateaccountdao = new UpdateAccountDao();
	
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

	//정보 변경
	public int buttonUpdateMethod(String id, String pw, String name, String address,String email) {
		LoginDto user = new LoginDto();
//		Session session = Session.getInstance(); 
//		if(address.equals("")) {
//			address = session.getaddress();
//		}
		user.setAccounts_id(id);
		user.setPw(pw);
		user.setName(name);
		user.setAddress(address);
		user.setEmail(email);
		
		int change = updateaccountdao.buttonUpdateMethod(user);
		
		if(change != 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("알림");
			alert.setContentText("변경 완료");
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("알림");
			alert.setContentText("변경 실패");
			alert.show();
		}
		
		return change;
	}
	
	public UpdateDto accountInfo(String id) {
		return updateaccountdao.accountInfo(id);
	}

}
