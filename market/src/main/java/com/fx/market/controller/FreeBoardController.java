package com.fx.market.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.PhotoDto;
import com.fx.market.service.FreeBoardService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FreeBoardController implements Initializable{
	@FXML ComboBox<String> sub;
	@FXML TextField main_category;
	@FXML TextField title;
	@FXML TextArea content;
	@FXML Button closebutton;
	@FXML Button imagebutton;
	@FXML private ComboBox combo_box;
	@FXML private ImageView photo;
	private FreeBoardService freeboardService;  
	private String filePathSession;
	private String fileNameSession;
    private ObservableList<String> list = FXCollections.observableArrayList("동네질문","동네사건사고","동네맛집","동네소식","생활정보","취미생활");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sub.setItems(list);
		freeboardService = new FreeBoardService();
		
	}
	
	// 완료 버튼 눌렀을 떄
	public void boardClick() throws Exception{
	
		String Nsub = sub.getValue();
		String Ncontent = content.getText(); 
		String Ntitle = title.getText();
		String Nmain_category = main_category.getText();
	
		freeboardService.boardClick(Nmain_category,Nsub, Ntitle, Ncontent);
	
					// photo insert\
					if(filePathSession != null) {
					InputStream inputStream = new FileInputStream(filePathSession);								//경로를 inputStream에 저장
			    	String outputName = Session.getInstance().getTempId() + fileNameSession;														//중복 안되도록 이름 수정
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
			    	Session session = Session.getInstance();
			    	freeboardService.photoInsert(new PhotoDto(session.getTempId(),outputName,outputPass,null));
			    	Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("게시물이 등록되었습니다.");
					alert.show();
					
			    	Viewer viewer = new Viewer();
					viewer.setView("meetingBoardListForm");
					}
	}
	public void closebtn() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
		
	}
	
	
	 @FXML
	 protected void imagebtn() throws Exception {
        // 파일 선택
		 FileChooser fileChooser = new FileChooser();                //FileChooser 객체 생성
	        Stage stage = new Stage();                            //Stage 객체 생성
	        File selectedFile = fileChooser.showOpenDialog(stage);        //stage에 fileChooser로 고른걸 selectedFile에 저장
	        String selectedFilePath = selectedFile.getAbsolutePath();        //selectedFile의 절대경로를 selectedFilePath에 저장
	        filePathSession = selectedFilePath;                        //controller에 경로 임시 저장
	        fileNameSession = selectedFile.getName();                    //controller에 이름 임시 저장
	        String imagePath = "file:"+selectedFilePath;                //image객체를 위한 경로 편집
	        Image image = new Image(imagePath);                        //이미지 객체 생성
	        photo.setImage(image);
		

	        
	}	
		
}
