package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.FreeBoardDto;
import com.fx.market.service.FreeBoardService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class FreeBoardDetailController implements Initializable{
	@FXML Label sub_category;
	@FXML Label username;
	@FXML Label address;
	@FXML Label date;
	@FXML Label content;
	@FXML Circle profile;
	@FXML Label boardName;
	@FXML Label title;
	@FXML Button update;
	@FXML Button delete;
	@FXML Button close;
	@FXML private ImageView photo;
	@FXML private ImageView myphoto;
	
	private FreeBoardService freeboardService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		freeboardService = new FreeBoardService();
		Session session = Session.getInstance();
		String board_Id = session.getTempId();
		String user_name = session.getName();
		System.out.println("user_name" + user_name);
		String photodto = freeboardService.photoInfo(board_Id);
		FreeBoardDto freeboard = freeboardService.selectAll(board_Id);

		freeboardService.view(board_Id);

		String myphoto_Id = freeboardService.photoInfo(freeboard.getAcount_Id());
		sub_category.setText(freeboard.getSub());
		title.setText(freeboard.getTitle());
		content.setText(freeboard.getContent());
		username.setText(freeboard.getName());
		address.setText(freeboard.getAddress());
		date.setText(freeboard.getCreatedAt());
		
	
		String imagePath = "file:" + System.getProperty("user.dir") + "/"+photodto;
		System.out.println(imagePath);
		Image image = new Image(imagePath);
		photo.setImage(image);
		
		String myimagePath = "file:" + System.getProperty("user.dir") + "/"+myphoto_Id;
		System.out.println(imagePath);
		Image myimage = new Image(myimagePath);
		myphoto.setImage(myimage);
		

	}
	public void updateClick() {
		Viewer viewer = new Viewer();
		viewer.setView("updateBulletin");
		
	}
	
	public void deleteClick() {
		Session session = Session.getInstance();
		String board_Id = session.getTempId();
		freeboardService = new FreeBoardService();
		freeboardService.deleteClick(board_Id);
		Viewer viewer = new Viewer();
		viewer.setView("meetingBoardListForm");
	}
	public void closeClicked() {
		//나의 마켓에서 들어왔을 경우 나의 마켓으로 뒤로가기
			if(Session.getInstance().getWhereToGo().equals("MyBoardList")) {
//				Session.getInstance().setWhereToGo("");
				Viewer.setView("home");			
				Viewer.setViewCenterScroll("myDouzone");
				Viewer.setViewCenterScroll("mySellList");
			}else {
				Viewer.setView("meetingBoardListForm");
			}
	}
}
