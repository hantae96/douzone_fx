package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.MySellListDto;
import com.fx.market.service.MySellListService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MySellListController implements Initializable{

	@FXML private VBox main;
	@FXML private ImageView photo;
	
	private MySellListService service;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new MySellListService();
		getMySellList();
	}

	@FXML
	protected void writeButtonClick() {
		Viewer viewer = new Viewer();
		viewer.setView("register");
	}
	
	protected void getMySellList() {
		//프로필 사진
		String myId = Session.getInstance().getAccountId();
		String PhotoPath = service.getMyPhoto(myId);
		if(!PhotoPath.isEmpty()) {
			String imagePath = "file:" + System.getProperty("user.dir") + "/"+PhotoPath;
			Image image = new Image(imagePath);
			photo.setImage(image);
		}
		
		//게시글 출력
		List<MySellListDto> items = service.getMySellList(myId);
		
		for(MySellListDto item : items) {
			
			BorderPane bord = new BorderPane();
			bord.setStyle("-fx-border-color: lightgray;");
			
			//이미지
			String getPath = ""; 
			getPath = item.getGoodsPhoto();
			ImageView sellImage = new ImageView();
			sellImage.setFitWidth(100);
			sellImage.setFitHeight(100);
			try {
				String imagePath = "file:" + System.getProperty("user.dir") + "/"+getPath;
				Image image = new Image(imagePath);
				sellImage.setImage(image);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			bord.setLeft(sellImage);
			
			//제목,장소,가격,날짜
			VBox box = new VBox();
			Label title = new Label(item.getGoodsTitle());
			Label address = new Label(item.getGoodsAddress());
			Label created_at = new Label(item.getGoodsCreated_at());
			Label price = new Label(item.getGoodsPrice());
			box.getChildren().addAll(title,address,created_at,price);
			bord.setCenter(box);
			
			main.getChildren().add(bord);
		}
		
	}
	
}
