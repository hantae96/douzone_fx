package com.fx.market.controller;

import com.fx.market.service.SignUpService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
    	if(pwInput.getText().isBlank()) {
    		pwAlert.setText("*비밀번호를 입력하세요!");
    	}else {
    		signUpButton.setStyle("-fx-background-color: white");
    	}
    }
    
    @FXML
    protected void cancelSignUp() {
    	
    }
    
    @FXML
    protected void selectPhoto() {
    	// 이미지 파일 경로
        String imagePath = "file:" + System.getProperty("user.dir") + "/src/main/java/com/fx/market/controller/logo.jpg";
        Image image = new Image(imagePath);
    	photo.setImage(image);
    }
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
   
    
}