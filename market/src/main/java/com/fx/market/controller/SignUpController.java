package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import com.fx.market.common.Viewer;
import com.fx.market.dto.SignUpDto;
import com.fx.market.service.SignUpService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class SignUpController implements Initializable{

    @FXML private Label idAlert;
    @FXML private Label nameAlert;
    @FXML private Label pwAlert;
    @FXML private Label addressAlert;
    @FXML private Label emailAlert;
    @FXML private TextField idInput;
    @FXML private TextField nameInput;
    @FXML private PasswordField pwInput;
    @FXML private PasswordField pwcInput;
    @FXML private TextField addressInput;
    @FXML private TextField emailInput;
    @FXML private Button signUpButton;
    @FXML private ImageView photo;
    
    private SignUpService service = new SignUpService();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// 영문과 숫자를 제외한 입력은 받지않도록 해주는 TextFormatter 생성
    	TextFormatter<String> textFormatter = new TextFormatter<String>((UnaryOperator<TextFormatter.Change>) change -> {
    	    String newText = change.getControlNewText();
    	    if (newText.matches("[a-zA-Z0-9]*")) {
    	        return change;
    	    } else {
    	        return null;
    	    }
    	});
    	// TextFormatter 적용
    	idInput.setTextFormatter(textFormatter);
    }
    
    //아이디 중복확인 버튼
    @FXML
    protected void idCheck() {
    	String accounts_id = idInput.getText();
    	if(accounts_id.length()<5) {idAlert.setText("5글자 이상의 아이디를 입력해주세요.");idAlert.setTextFill(Color.RED);
    	}else {
	    	String result = service.idCheck(accounts_id);
	    	idAlert.setText(result);
	    	if(result.length()>15) {idAlert.setTextFill(Color.BLUE);
	    	}else {idAlert.setTextFill(Color.RED);}
    	}
    }
    
    //회원가입 버튼
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

    		Viewer viewer = new Viewer();
    		viewer.setView("login");
    	}
    }
    
    //취소 버튼
    @FXML
    protected void cancelSignUp() {
		Viewer viewer = new Viewer();
		viewer.setView("login");
    }
    
    //사진 선택 버튼
    @FXML
    protected void selectPhoto() {
    	// 이미지 파일 경로
        String imagePath = "file:" + System.getProperty("user.dir") + "/src/main/java/com/fx/market/controller/logo.jpg";
        Image image = new Image(imagePath);
    	photo.setImage(image);
    }
   
    
    
    //아이디 입력칸 리스너
    @FXML
    protected void checkIdLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
//    	String target = service.eventHall(e.getTarget().toString());
    	idInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {idInput.setText(oldValue);}
    	});
    }
    
    //이름 입력칸 리스너
    @FXML
    protected void checkNameLength(Event e) {
    	int maxLength = 5; // 최대 입력 길이
    	nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {nameInput.setText(oldValue);}
    	});
    }
    
    //비밀번호 입력칸 리스너
    @FXML
    protected void checkPwLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
    	pwInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pwInput.setText(oldValue);}
    	});
    }
    
    //비밀번호 확인 입력칸 리스너
    @FXML
    protected void checkPwcLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
    	pwcInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pwcInput.setText(oldValue);}
    	});
    }
}