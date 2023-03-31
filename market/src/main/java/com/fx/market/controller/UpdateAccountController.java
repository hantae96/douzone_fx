package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.UpdateDto;
import com.fx.market.service.UpdateAccountService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UpdateAccountController implements Initializable{
	@FXML PasswordField pw;
	@FXML TextField name;
	@FXML TextField address;
	@FXML TextField email;
	
	private UpdateAccountService updateservice;
	private String beforePw;
	private String beforeName;
	private String beforeAddress;
	private String beforeEmail;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateservice = new UpdateAccountService();
		
		UpdateDto updatedto = updateservice.accountInfo(Session.getInstance().getAccountId());
		pw.setText(updatedto.getPw());
		name.setText(updatedto.getName());
		address.setText(updatedto.getAddress());
		email.setText(updatedto.getEmail());
		beforePw = updatedto.getPw();
		beforeName = updatedto.getName();
		beforeAddress = updatedto.getAddress();
		beforeEmail = updatedto.getEmail();
		//세션에서 id 가져와서 서비스 -> dao통해서 그 계정에 해당하는 비밀번호 이름 주소 이메일 가져오기(select로 가져오기)
		//pw.setText(가져온 것들 담아주기);
	}
	
	
	
	
	
	//정보 수정 완료 버튼
	@FXML
	private void updateAccount() {
		Session session = Session.getInstance(); 
		int change = updateservice.buttonUpdateMethod(session.getAccountId(),pw.getText(),name.getText(),address.getText(),email.getText());
		
		if(change == 1) {
		Viewer viewer = new Viewer();
		viewer.setViewCenter("myDouzone");//이동해서 -> 확인
		}
	}
	
	//이름 입력칸 리스너
    @FXML
    private void checkNameLength() {
    	int maxLength = 5; // 최대 입력 길이
    	name.textProperty().addListener((observable, oldValue, newValue) -> {
    	if (newValue.length() > maxLength) 
    	{name.setText(oldValue);}
    	});}
    
    //비밀번호 입력칸 리스너
    @FXML
    protected void checkPwLength(Event e) {
    	int maxLength = 15; // 최대 입력 길이
    	pw.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pw.setText(oldValue);}
    	});}
    
    //주소 확인 입력칸 리스너
    @FXML
    protected void checkAddressLength(Event e) {
    	int maxLength = 20; // 최대 입력 길이
    	address.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {address.setText(oldValue);}
    	});}
    
    //이메일 확인 입력칸 리스너
    @FXML
    protected void checkEmailLength(Event e) {
    	int maxLength = 30; // 최대 입력 길이
    	email.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {email.setText(oldValue);}
    	});}
	
    //취소
	@FXML
	private void updateCancel() {
		pw.setText(beforePw);
		name.setText(beforeName);
		address.setText(beforeAddress);
		email.setText(beforeEmail);

		pw.requestFocus();
	}
			
//	//회원 탈퇴
//	@FXML
//	private void deleteAccount(Event event) {
//				
//		}

}
