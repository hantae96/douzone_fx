package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.service.UpdateAccountService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class CheckPasswordController implements Initializable{
	@FXML PasswordField pw;

	
	private UpdateAccountService updateservice;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateservice = new UpdateAccountService();
		
		// 한글 입력은 받지 않도록 해주는 TextFormatter 생성
    	TextFormatter<String> passFormatter =  new TextFormatter<String>((UnaryOperator<TextFormatter.Change>) change -> {
    	    String newPass = change.getControlNewText();
    	    if (newPass.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣].*")) {
    	        return null;
    	    } else {
    	        return change;
    	    }
    	});
    	//TextFormatter 적용
    	pw.setTextFormatter(passFormatter);
		
	}

	//정보 확인 버튼 클릭
		@FXML
		private void checkAccount() {
			Session session = Session.getInstance(); 
			int confirm = updateservice.confirmAccount(session.getAccountId(), pw.getText());
			
			if(confirm == 1) { 
				Viewer viewer = new Viewer();
				viewer.setViewCenter("update");//이동해서 -> 계정변경창으로
			}
		}
}
