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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
		
		if(items.size()<1) {
			Label announce = new Label();
			announce.setText("판매글이 존재하지 않습니다.");
			main.getChildren().add(announce);
		}
		
		for(MySellListDto item : items) {
			
			BorderPane bord = new BorderPane();
			bord.setStyle("-fx-border-color: lightgray;");
			bord.setMaxHeight(100);
			
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
			box.setAlignment(Pos.CENTER_LEFT);
			box.setSpacing(4.0);
			box.setPadding(new Insets(0, 0, 0, 10));
			Label title = new Label(item.getGoodsTitle());
			Label address = new Label(item.getGoodsAddress());
			Label created_at = new Label(item.getGoodsCreated_at());
			String goodsPrice = item.getGoodsPrice()+"원";
			Label price = new Label(goodsPrice);
			box.getChildren().addAll(title,address,created_at,price);
			bord.setCenter(box);
			
			main.getChildren().add(bord);
		}
		
	}
	
}
