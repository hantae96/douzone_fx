package com.fx.market.controller;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.SignUpDto;
import com.fx.market.service.SignUpService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private Label idAlert;
    @FXML
    private Label nameAlert;
    @FXML
    private Label pwAlert;
    @FXML
    private Label addressAlert;
    @FXML
    private Label emailAlert;
    @FXML
    private TextField idInput;
    @FXML
    private TextField nameInput;
    @FXML
    private PasswordField pwInput;
    @FXML
    private PasswordField pwcInput;
    @FXML
    private TextField addressInput;
    @FXML
    private TextField emailInput;
    @FXML
    private Button signUpButton;
    @FXML
    private ImageView photo;
    
    private SignUpService service = new SignUpService();
    
    @FXML
    protected void idCheck() {
    	String accounts_id = idInput.getText();
    	if(accounts_id=="" || accounts_id==" ") {
    		idAlert.setText("아이디를 입력해주세요.");
    		 idAlert.setTextFill(Color.RED);
    	}else {
	    	int result = service.idCheck(accounts_id);
	    	switch(result) {
	    	case 0 : idAlert.setText("아이디를 생성하실 수 있습니다."); idAlert.setTextFill(Color.BLUE); break;
	    	case 1 : idAlert.setText("중복된 아이디입니다."); idAlert.setTextFill(Color.RED); break;
	    	}
    	}
    }
    
    @FXML
    protected void signUpButtonClick() {
    	if(idInput.getText().isBlank()) {
    		idAlert.setText("*아이디를 입력하세요!");
    	}else if(nameInput.getText().isBlank()){
    		nameAlert.setText("*이름을 입력하세요!");
    	}else if(pwInput.getText().isBlank()){
    		pwAlert.setText("*비밀번호를 입력하세요!");
    	}else if(pwcInput.getText().isBlank()){
    		pwAlert.setText("*비밀번호확인을 입력하세요!");
    	}else if(!pwInput.getText().equals(pwcInput.getText())){
    		pwAlert.setText("*비밀번호를 확인하세요!");
    	}else if(addressInput.getText().isBlank()){
    		addressAlert.setText("*주소를 입력하세요!");
    	}else if(emailInput.getText().isBlank()){
    		emailAlert.setText("*이메일을 입력하세요!");
    	}else{


    		service.signInsert(new SignUpDto(
    				idInput.getText(),			//아이디
    				nameInput.getText(),		//이름
    				pwInput.getText(),			//비밀번호
    				addressInput.getText(),		//주소
    				emailInput.getText()		//이메일

    				));
    		
    		Session session = Session.getInstance();
    		Stage stage = session.getStage();
    		
    		Viewer viewer = new Viewer();
    		viewer.setPrimaryStage(stage);
    		
    		viewer.loginList();
    		
    		
    	}
    }

    @FXML
    protected void cancelSignUp() {
    	Session session = Session.getInstance();
		Stage stage = session.getStage();
		
		Viewer viewer = new Viewer();
		viewer.setPrimaryStage(stage);
		
		viewer.loginList();
    }
    
    @FXML
    protected void selectPhoto() {
    	// 이미지 파일 경로
        String imagePath = "file:" + System.getProperty("user.dir") + "/src/main/java/com/fx/market/controller/logo.jpg";
        Image image = new Image(imagePath);
    	photo.setImage(image);
    }
   
    
}