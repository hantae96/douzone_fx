package com.fx.market.service;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;

import java.sql.Date;

import com.fx.market.dao.LoginDao;
import com.fx.market.dto.LoginDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginService {
	private LoginDao dao;
	private CommonService cs;
	
	public LoginService() {
	dao = new LoginDao();
	cs = new CommonService();
}
	public int buttonLoginMethod(String id, String pw) {
		LoginDto dbUser = dao.idCheck(id, pw); 
		Date deleted_at = dao.deleteCheck(id, pw);
		
		if(deleted_at == null) {
			if(id.isEmpty() || pw.isEmpty()) {
				cs.msg(AlertType.WARNING, "알림", "아이디 또는 비밀번호를 입력하세요.");
				
				return 0;
			}
			else if(dbUser == null ) {
		
			cs.msg(AlertType.ERROR, "알림", "아이디 또는 비밀번호를 확인하세요");
		
			return 0;
			}else{  //로그인 성공 시
			
			Session session = Session.getInstance();
			
			session.setLoginChk(1);
			session.setAccountId(dbUser.getAccounts_id());
			session.setAddress(dbUser.getAddress());
			return 1;
			}	
		}else{
			cs.msg(AlertType.ERROR, "알림", "탈퇴한 회원입니다.");
			return 0;
		}
	}
}