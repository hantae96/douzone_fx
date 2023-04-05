package com.fx.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.PhotoDto;
import com.fx.market.service.RegisterService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RegisterController implements Initializable {
	RegisterService registerService;

	@FXML ImageView photo;
	@FXML
	private TextField name;

	@FXML
	private TextField price;

	@FXML
	private TextField context;

	@FXML
	private TextField address;
	@FXML
	Button close;
	private Session session;
	
	private String filePathSession;
	private String fileNameSession;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.session = Session.getInstance();
		this.registerService = new RegisterService(new RegisterDao());
		checkPrice(price);
	}

	@FXML
	private void onRegsistButtonClick() {
		// 사진을 제외하고 먼저 데이터 저장
		
		// 시퀀스를 insert 한다음에 가져
		String itemId = registerService.saveItemData(
										new ItemDto(name.getText(), price.getText(), context.getText(), address.getText()));
	
		//파일 실질적인 저장 <회원가입 버튼메서드 내 구현>
        InputStream inputStream;

		try {
			inputStream = new FileInputStream(filePathSession);
	        String outputPass = "src/main/java/com/fx/market/source/image/"+itemId+".jpg";    //파일 저장 경로 <- 저장 ID로 생성
	        
	        System.out.println(outputPass);
	        
	        File outputFile = new File(outputPass);                        //output할 파일의 경로를 지정해 File객체 생성
	        OutputStream outputStream = new FileOutputStream(outputFile);            //outputFile을 outputStream에 저장

	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = inputStream.read(buffer)) > 0) {
	            outputStream.write(buffer, 0, length);
	        }

	        inputStream.close();
	        outputStream.close();
	        
	        registerService.photosInsert(new PhotoDto(
	                itemId,            //photos_id = accounts_id
	                itemId,                    //사진 파일 이름
	                outputPass,                    //사진 파일 경로
	                null                        //입력 날짜
	                ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            //경로를 inputStream에 저장
		
		Viewer.setView("home");
	}

	@FXML
	private void onCancelButtonClick() {
		Viewer.setView("home");
	}

	private void checkPrice(TextField price) {
		// 가격 입력값 유효성검사
		price.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) {
				price.setText(oldValue);
				price.setStyle("-fx-text-fill: red;");
				price.setPromptText("가격");
			} else {
				price.setStyle("-fx-text-fill: black;");
				price.setPromptText("");
			}
		});
	}
	
	@FXML
    protected void selectPhoto() throws Exception {
        // 파일 선택
        FileChooser fileChooser = new FileChooser();                //FileChooser 객체 생성
        Stage stage = new Stage();                            //Stage 객체 생성
        File selectedFile = fileChooser.showOpenDialog(stage);        //stage에 fileChooser로 고른걸 selectedFile에 저장
        String selectedFilePath = selectedFile.getAbsolutePath();        //selectedFile의 절대경로를 selectedFilePath에 저장
        filePathSession = selectedFilePath;                        //controller에 경로 임시 저장
        fileNameSession = selectedFile.getName();                    //controller에 이름 임시 저장
        String imagePath = "file:"+selectedFilePath;                //image객체를 위한 경로 편집
        Image image = new Image(imagePath);                        //이미지 객체 생성
        photo.setImage(image);                                //이미지 출력
    }
	
	
}
