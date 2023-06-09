package com.fx.market.service;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
import com.fx.market.common.Viewer;

import java.sql.Date;

import com.fx.market.dao.LoginDao;
import com.fx.market.dto.LoginDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginService {
	private LoginDao dao;
	
	
	public LoginService() {
	dao = new LoginDao();
	
}
	public int buttonLoginMethod(String id, String pw) {
		LoginDto dbUser = dao.idCheck(id, pw); 
		Date deleted_at = dao.deleteCheck(id, pw);
		
		if(deleted_at == null) {
			if(id.isEmpty() || pw.isEmpty()) {
				CommonService.msg(AlertType.WARNING, "알림","", "아이디 또는 비밀번호를 입력하세요.");
				
				return 0;
			}
			else if(dbUser == null ) {
		
				CommonService.msg(AlertType.ERROR, "알림","",  "아이디 또는 비밀번호를 확인하세요");
		
			return 0;
			}else{  //로그인 성공 시
			
			Session session = Session.getInstance();
			
			session.setLoginChk(1);
			session.setAccountId(dbUser.getAccounts_id());
			session.setAddress(dbUser.getAddress());
			session.setWhereToGo("");
			return 1;
			}	
		}else{
			CommonService.msg(AlertType.ERROR, "알림","",  "탈퇴한 회원입니다.");
			return 0;
		}
	}
	
	public void userPwMethod(String id,String email,String pw,String pwC){
		int pwCheck = dao.userCheck(id, email);
		if(pwCheck == 0) {
			CommonService.msg(AlertType.ERROR, "알림","",  "등록되지 않은 회원입니다.");
		}else {
			if(pw.equals(pwC)) {
			dao.pwCheck(id,email,pw);
			CommonService.msg(AlertType.INFORMATION, "알림","",  " 비밀번호가 변경되었습니다.");
			Viewer.setView("login");
			}else {
				CommonService.msg(AlertType.ERROR, "알림","",  "비밀번호가 서로 맞지 않습니다.");
			}
		
		}
	
	}
	
	public int e_nameMethod(String name, String email) {
		String e_nameCheck = dao.e_nameCheck(name,email);
		if(e_nameCheck == null) {
			CommonService.msg(AlertType.ERROR, "알림","",  "등록되지 않은 회원입니다.");
		}else {
			CommonService.msg(AlertType.INFORMATION, "알림","",  " 아이디:  " +e_nameCheck);
			return 1;
		}
		return 0;
	}
}