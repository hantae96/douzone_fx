package com.fx.market.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.MySellListDto;
import com.fx.market.service.HomeService;
import com.fx.market.service.ItemService;
import com.fx.market.service.MySellListService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MySellListController implements Initializable{

	@FXML private VBox main;
	@FXML private ImageView photo;
	@FXML private Label where;
	@FXML private Button writeButton;
	
	private MySellListService service;
	private HomeService homeService;
	private ItemService itemService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new MySellListService();
		homeService = new HomeService();
		itemService = new ItemService();
		if(Session.getInstance().getWhereToGo().equals("MyGradeList")) {
			getMyGrade();
		}else {
			getMyList();
		}
	}
	
	@FXML
	protected void writeButtonClick() {
		String whereToGo = Session.getInstance().getWhereToGo();
		if(whereToGo.equals("MySellList")) {
			Viewer.setView("register");
		}
		if(whereToGo.equals("MyBoardList")) {
			Viewer.setView("meetingBoardListForm");			
		}
	}
	
	//클릭한 메뉴의 세션에 따라 다르게 출력
	protected void getMyList() {
		//세션에 저장한 메뉴
		String whereToGo = Session.getInstance().getWhereToGo();
		//프로필 사진
		String myId = Session.getInstance().getAccountId();
		String PhotoPath = service.getMyPhoto(myId);
		if(!PhotoPath.isEmpty()) {
			String imagePath = "file:" + System.getProperty("user.dir") + "/"+PhotoPath;
			Image image = new Image(imagePath);
			photo.setImage(image);
		}
		
		//게시글 출력
		List<MySellListDto> items = new ArrayList<>();
		
		//세션에 따른 결과
		if(whereToGo.equals("MySellList")) {
			where.setText("나의 판매 목록");
			writeButton.setDisable(false);
			writeButton.setVisible(true);
			writeButton.setText("글쓰기");
			items = service.getMySellList(myId);
		}else if(whereToGo.equals("MyBuyList")) {
			where.setText("나의 구매 목록");			
			writeButton.setDisable(true);
			writeButton.setVisible(false);
			items = service.getMyBuyList(myId);
		}else if(whereToGo.equals("MyBoardList")) {
			where.setText("나의 작성글 목록");			
			writeButton.setDisable(false);
			writeButton.setVisible(true);
			writeButton.setText("글쓰러가기");
			items = service.getMyBoardList(myId);
		}else if(whereToGo.equals("MyFavorList")) {
			where.setText("나의 관심글 목록");			
			writeButton.setDisable(true);
			writeButton.setVisible(false);
			items = service.getMyFavorList(myId);
		}
		
		
		if(items.size()<1) {
			Label announce = new Label();
			announce.setText("\n\n           글이 존재하지 않습니다.");
			main.getChildren().add(announce);
		}
		
		for(MySellListDto item : items) {
			
			BorderPane bord = new BorderPane();
			bord.setStyle("-fx-border-color: lightgray;");
			bord.setMaxHeight(100);
			bord.setMinWidth(360);
			bord.setPadding(new Insets(0, 30, 0, 0));
			
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
			
			if(whereToGo.equals("MyBoardList")) {
				bord.setRight(sellImage);				
			}else {
				bord.setLeft(sellImage);
			}
			
			if(whereToGo.equals("MyBoardList")) {
				bord.setOnMouseClicked(event -> {
					if(item.getGoodsPrice().equals("동네생활")) {
						Session session =Session.getInstance();
						session.setTempId(item.getGoods_id());	
						Viewer.setView("detailBulletin"); 		
					}else {
						Session session =Session.getInstance();
						session.setTempId(item.getGoods_id());
						Viewer.setView("meetingBoardDetailForm");
					}
				});
			}else {
				bord.setOnMouseClicked(event -> {
					openItemDetails(item);
					homeService.addView(item.getGoods_id());
				}); // 클릭 이벤트 핸들러 등록
			}
			
			//제목,장소,가격,날짜
			VBox box = new VBox();
			box.setAlignment(Pos.CENTER_LEFT);
			box.setSpacing(4.0);
			box.setPadding(new Insets(0, 0, 0, 10));
			Label title = new Label(item.getGoodsTitle());
			Label address = new Label(item.getGoodsAddress());
			Label created_at = new Label(item.getGoodsCreated_at());
			String goodsPrice = item.getGoodsPrice();
			if(!whereToGo.equals("MyBoardList")) {
				goodsPrice += "원";
			}
			Label price = new Label(goodsPrice);
			box.getChildren().addAll(title,address,created_at,price);
			bord.setCenter(box);
			
			main.getChildren().add(bord);
		}
	}
	
	// 상세보기 이동
	private void openItemDetails(MySellListDto item) {
		ItemDto clickedItem = itemService.getItemById(item.getGoods_id());
		Session.getInstance().setModel(clickedItem);
		if(Session.getInstance().getWhereToGo().equals("MySellList")) {
			Viewer.setView("item");
		}
	}
	
	//받은 평가 이동
	protected void getMyGrade() {
		where.setText("받은 평가");
		
		// 프로필 사진
		String myId = Session.getInstance().getAccountId();
		String PhotoPath = service.getMyPhoto(myId);
		if (!PhotoPath.isEmpty()) {
			String imagePath = "file:" + System.getProperty("user.dir") + "/" + PhotoPath;
			Image image = new Image(imagePath);
			photo.setImage(image);
		}
		writeButton.setDisable(true);
		writeButton.setVisible(false);
		int[] things = service.getGradeNum(myId);
		int index = 5;
		
		for(int thing : things) {
		BorderPane bord = new BorderPane();
		bord.setPadding(new Insets(30, 0, 30, 80));
		bord.setMaxHeight(50);
		
		String constellation = "";
		for(int i=0; i<index; i++) {
			constellation += "★";
		}
		for(int i=0; i<5-index; i++) {
			constellation += "☆";			
		}
		index -=1;
		Label starGrade = new Label();
		starGrade.setFont(new Font(20));
		starGrade.setText(constellation);
		bord.setLeft(starGrade);
		
		Label people = new Label();
		people.setFont(new Font(20));
		String person = " 명";
		person = thing + person;
		people.setText(person);
		
		bord.setCenter(people);
		
		main.getChildren().add(bord);
		}
	}
	
}
