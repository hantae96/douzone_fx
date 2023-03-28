package com.fx.market.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    protected void idCheck() {
    	if(idInput.getText().equals("id")) {
    		idAlert.setText("*중복된 아이디 입니다!");
    	}else {
    		idAlert.setText("*사용가능한 아이디 입니다!");
    	}
    }
    
    @FXML
    protected void signUpExecute() {
    	if(pwInput.getText().isBlank()) {
    		pwAlert.setText("*비밀번호를 입력하세요!");
    	}else {
    		signUpButton.setStyle("-fx-background-color: white");
    	}
    }
    
    @FXML
    protected void cancelSignUp() {
    	
    }
    
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
   
    
}