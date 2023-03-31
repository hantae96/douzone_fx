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
    private boolean[] signCheck;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	// 회원가입 버튼 활성화 트리거 0:아이디, 1:이름, 2:PW, 3:주소, 4:이메일
    	signCheck = new boolean[5];
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
    	signCheck[0]=false;signUpButton.setDisable(decisionDisable());
    	}else {
	    	String result = service.idCheck(accounts_id);
	    	idAlert.setText(result);
	    	if(result.length()>15) {idAlert.setTextFill(Color.BLUE);signCheck[0]=true;signUpButton.setDisable(decisionDisable());
	    	}else {idAlert.setTextFill(Color.RED);signCheck[0]=false;signUpButton.setDisable(decisionDisable());}
    	}
    }
    
    //회원가입 버튼
    @FXML
    protected void signUpButtonClick() {
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
    	idInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {idInput.setText(oldValue);}
    		if(idAlert.getTextFill().equals(Color.BLUE)) {
    			idAlert.setTextFill(Color.RED);
    			idAlert.setText("*필수 입력 항목");
    			signCheck[0]=false;
    			signUpButton.setDisable(decisionDisable());
    		}
    	});
    }
    
    //이름 입력칸 리스너
    @FXML
    protected void checkNameLength(Event e) {
    	int maxLength = 5; // 최대 입력 길이
    	nameInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {nameInput.setText(oldValue);}
    		if(newValue.length()> 0) {
    			signCheck[1]=true;
    			signUpButton.setDisable(decisionDisable());
    		}else {
    			signCheck[1]=false;    			
    			signUpButton.setDisable(decisionDisable());
    		}
    	});
    }
    
    //비밀번호 입력칸 리스너
    @FXML
    protected void checkPwLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
    	pwInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pwInput.setText(oldValue);}
    		if(newValue.length()<1) {
    			signCheck[2] = false;    			
    			signUpButton.setDisable(decisionDisable());
    		}else if(newValue.equals(pwcInput.getText())) {
    			signCheck[2] = true;
    			signUpButton.setDisable(decisionDisable());
    		}else {
    			signCheck[2] = false;    			    			
    			signUpButton.setDisable(decisionDisable());
    		}
    	});
    }
    
    //비밀번호 확인 입력칸 리스너
    @FXML
    protected void checkPwcLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
    	pwcInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pwcInput.setText(oldValue);}
    		if(newValue.length()<1) {
    			signCheck[2] = false;    			
    			signUpButton.setDisable(decisionDisable());
    		}else if(newValue.equals(pwInput.getText())) {
    			signCheck[2] = true;
    			signUpButton.setDisable(decisionDisable());
    		}else {
    			signCheck[2] = false;    			    			
    			signUpButton.setDisable(decisionDisable());
    		}
    	});
    }
    
    //주소 확인 입력칸 리스너
    @FXML
    protected void checkAddressLength(Event e) {
    	int maxLength = 20; // 최대 입력 길이
    	addressInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {addressInput.setText(oldValue);}
    		if(checkAddress(newValue)) {
    			signCheck[3] = true;
    			signUpButton.setDisable(decisionDisable());    			
    		}else {
    		signCheck[3] = false;
    		signUpButton.setDisable(decisionDisable());
    		}
    	});
    }
    
    //이메일 확인 입력칸 리스너
    @FXML
    protected void checkEmailLength(Event e) {
    	int maxLength = 30; // 최대 입력 길이
    	emailInput.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {emailInput.setText(oldValue);}
    		if(checkEmail(newValue)) {
    			signCheck[4] = true;
    			signUpButton.setDisable(decisionDisable());    			
    		}else {
    			signCheck[4] = false;
    			signUpButton.setDisable(decisionDisable());    			
    		}
    	});
    }
    
    //회원가입 버튼의 활성화 판단 메서드
    protected boolean decisionDisable() {
    	for(boolean x : signCheck) {
    		if(x==false) {
    			return true;}
    	}
    	return false;
    }
    
    //주소 형식 확인 메서드
    protected boolean checkAddress(String a) {
		String[] b = a.split(" ");
		if(b.length==2) {
			if(b[0].contains("시")&&b[1].contains("구")) {
				return true;
			}
		}
		return false;
    }
    
    //이메일 형식 확인 메서드
    protected boolean checkEmail(String a) {
    	String[] b = a.split("[@\\.]");
    	if(b.length==3) {
    		return true;
    	}
    	return false;
    }
}