package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.service.UpdateAccountService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

public class UpdateAccountController implements Initializable{
	@FXML PasswordField pw;
	
	private UpdateAccountService updateservice;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateservice = new UpdateAccountService();
	}
	
	//정보 수정 버튼 클릭
	@FXML
	private void updateAccount() {
		Session session = Session.getInstance(); 
		int confirm = updateservice.confirmAccount(session.getAccountId(), pw.getText());
		
		if(confirm == 1) { 
		
		Viewer viewer = new Viewer();
		viewer.setViewCenter("update");//수정 버튼 누르면 -> 확인창 그리고 다시 이동해서 -> 계정변경창으로
		}
	}
			
//	//회원 탈퇴
//	@FXML
//	private void deleteAccount(Event event) {
//				
//		}

}
