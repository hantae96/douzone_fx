package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	@FXML ImageView photo;
	private LoginService service;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();
		
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
		
		String imagePath = "file:" + System.getProperty("user.dir") + "/src/main/java/com/fx/market/source/image/giphy.gif";
      	Image image = new Image(imagePath);
    	photo.setImage(image); 

	}
		
	public void buttonLoginMethod() {
		int result = service.buttonLoginMethod(id.getText(),pw.getText());
		if(result == 1) {  //로그인 성공 시
		
		Viewer.setView("home");
		}
	}


	
	public void regClickedMethod() {
		
		Viewer viewer = new Viewer();
		viewer.setView("signUp");
	}
	
	public void pwClickedMethod() {
		Viewer viewer = new Viewer();
		viewer.setView("idConfirm");  
	}
	
	public void e_nameClickedMethod() {
		Viewer viewer = new Viewer();
		viewer.setView("e_nameCheck"); 
	}
	
	
	
}
