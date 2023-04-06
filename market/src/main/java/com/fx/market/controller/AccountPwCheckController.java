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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AccountPwCheckController implements Initializable{
	@FXML PasswordField pw;
	@FXML private ImageView photo;

	
	private UpdateAccountService updateservice;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateservice = new UpdateAccountService();
		String photodto = updateservice.photoInfo(Session.getInstance().getAccountId());
		
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
    	
    	//저장된 이미지 파일 불러오기
    			String imagePath = "file:" + System.getProperty("user.dir") + "/"+photodto;
    			Image image = new Image(imagePath);
    			photo.setImage(image);
		
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
		
		//정보 확인 취소 버튼 클릭
				@FXML
				private void cancelAccount() {
		
				Viewer viewer = new Viewer();
				viewer.setViewCenter("myDouzone");
					}
			}

