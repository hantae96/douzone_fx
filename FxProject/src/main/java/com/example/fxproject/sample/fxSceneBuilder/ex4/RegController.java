package com.example.fxproject.sample.fxSceneBuilder.ex4;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegController implements Initializable{
	@FXML TextField id;
	@FXML TextField name;
	@FXML PasswordField pw;
	@FXML PasswordField confirm;
	@FXML RadioButton manRadio;
	@FXML RadioButton womanRadio;
	@FXML ComboBox<String> ageCombo;
	@FXML CheckBox musicCheck;
	@FXML CheckBox sportCheck;
	@FXML CheckBox movieCheck;
	private RegService service;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new RegService();
		
	}
	// 회원 가입 버튼 
	public void regProc() {
		RegDTO reg = new RegDTO();
	
		reg.setId(id.getText());
		reg.setName(name.getText());
		reg.setPw(pw.getText());
		reg.setConfirm(confirm.getText());
		reg.setAgeGroup(ageCombo.getValue());
		
		if(manRadio.isSelected())
			reg.setGender("남");
		else if(womanRadio.isSelected())
			reg.setGender("여");
		
		String tmp = "";
		if(musicCheck.isSelected())	tmp += "음악";
		if(movieCheck.isSelected())	tmp += " 영화";
		if(sportCheck.isSelected())	tmp += " 스포츠";
		
		reg.setHobbys(tmp);
		service.regProc(reg);
		
		/*
		 javafx 테이블에 age_group 컬럼을 추가
		 regService.regProc() Method
		  - 데이터 전달
		  - 입력 데이터 검증, 아이디 중복 체크
		 regDAO.regProc() Method
		  - javafx 테이블에 데이터 입력
		 */
	}
	
	// 회원 화면에서 취소 버튼
	public void regCancelProc() {
		
	}


}
