package com.fx.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.UpdateDto;
import com.fx.market.service.UpdateAccountService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateAccountController implements Initializable{
	@FXML PasswordField pw;
	@FXML TextField name;
	@FXML TextField address;
	@FXML TextField email;
	
	@FXML private ImageView photo;
	
	private UpdateAccountService updateservice;
	private String beforePw;
	private String beforeName;
	private String beforeAddress;
	private String beforeEmail;
	private String beforePhoto;
	
	private String filePathSession;
    private String fileNameSession;
    
	private CommonService cs = new CommonService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateservice = new UpdateAccountService();
		
		UpdateDto updatedto = updateservice.accountInfo(Session.getInstance().getAccountId());
		String photodto = updateservice.photoInfo(Session.getInstance().getAccountId());
		
		pw.setText(updatedto.getPw());
		name.setText(updatedto.getName());
		address.setText(updatedto.getAddress());
		email.setText(updatedto.getEmail());
		
		//저장된 이미지 파일 불러오기(이 부분 photodto 써도 되는지 물어보기)
		String imagePath = "file:" + System.getProperty("user.dir") + "/"+photodto;
		Image image = new Image(imagePath);
		photo.setImage(image);
		
		beforePw = updatedto.getPw();
		beforeName = updatedto.getName();
		beforeAddress = updatedto.getAddress();
		beforeEmail = updatedto.getEmail();
		beforePhoto = imagePath;
		//세션에서 id 가져와서 서비스 -> dao통해서 그 계정에 해당하는 비밀번호 이름 주소 이메일 가져오기(select로 가져오기)
		//pw.setText(가져온 것들 담아주기);
	}
	
	//사진 선택 버튼 -> 여기서 다음을 모르겠음 실질적인 파일저장??
	@FXML  
	private void updatePhoto() {
		// 파일 선택
    	FileChooser fileChooser = new FileChooser();						//FileChooser 객체 생성
    	Stage stage = new Stage();											//Stage 객체 생성
    	File selectedFile = fileChooser.showOpenDialog(stage);				//stage에 fileChooser로 고른걸 selectedFile에 저장
    	String selectedFilePath = selectedFile.getAbsolutePath();			//selectedFile의 절대경로를 selectedFilePath에 저장
    	filePathSession = selectedFilePath;									//controller에 경로 임시 저장
    	fileNameSession = selectedFile.getName();							//controller에 이름 임시 저장
    	String imagePath = "file:"+selectedFilePath;						//image객체를 위한 경로 편집
    	Image image = new Image(imagePath);									//이미지 객체 생성
    	photo.setImage(image);												//이미지 출력
    	
	}
	
	
	
	
	
	//정보 수정 완료 버튼
	@FXML
	private void updateAccount() throws Exception {
		Session session = Session.getInstance(); 
		int change = updateservice.buttonUpdateMethod(session.getAccountId(),pw.getText(),name.getText(),address.getText(),email.getText());
		
		
		//파일 실질적인 저장
    	InputStream inputStream = new FileInputStream(filePathSession);								//경로를 inputStream에 저장
    	String outputName = session.getAccountId()+fileNameSession;										//중복 안되도록 이름 수정
    	String outputPass = "src/main/java/com/fx/market/source/image/"+outputName;					//파일 저장 경로
    	File outputFile = new File(outputPass);														//output할 파일의 경로를 지정해 File객체 생성
    	OutputStream outputStream = new FileOutputStream(outputFile);								//outputFile을 outputStream에 저장
    	
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = inputStream.read(buffer)) > 0) {
    	    outputStream.write(buffer, 0, length);
    	}

    	inputStream.close();
    	outputStream.close();
    	
    	//Photos Insert
    	updateservice.photosUpdate(new PhotoDto(
    			session.getAccountId(),		//photos_id = accounts_id
    			outputName,					//사진 파일 이름
    			outputPass,					//사진 파일 경로
    			null						//입력 날짜
    			));
    	

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
    protected void checkPwLength() {
    	int maxLength = 15; // 최대 입력 길이
    	pw.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {pw.setText(oldValue);}
    	});}
    
    //주소 확인 입력칸 리스너
    @FXML
    protected void checkAddressLength() {
    	int maxLength = 20; // 최대 입력 길이
    	address.textProperty().addListener((observable, oldValue, newValue) -> {
    		if (newValue.length() > maxLength) {address.setText(oldValue);}
    	});}
    
    //이메일 확인 입력칸 리스너
    @FXML
    protected void checkEmailLength() {
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
		
		Image image = new Image(beforePhoto);
		photo.setImage(image);
		pw.requestFocus();
	}
	


} 