package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	private LoginService service;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();
	}
	// 로그인 버튼 
	public void loginProc(){	
		service.loginProc(id.getText(), pw.getText());

		String result = service.loginCheck(id.getText());
		if(result != null && result.equals("Y")){
		}
		/*
		 LoginService Class를 생성하고, Method를 loginProc을 구현하세요.
		 LoginDAO Class를 생성하고, Method를 LoginProc을 구현하세요.
		 DAO는 데이터베이스 접근
		 Service는 데이터(입력 값) 검증
		 
		 출력 : 로그인 성공 또는 실패 Alert를 출력하기
		 Table Name : javaFx
		 Column Name : id, pw, name, gender(성별), hobbys(취미)
		 */
	}
	
	// 취소 버튼
	public void cancelProc(){
		id.clear();
		pw.clear();
		id.requestFocus();
	}
	
	// 가입 버튼
	public void regProc(){
	}


}
