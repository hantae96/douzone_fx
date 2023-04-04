package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.FreeBoardDto;
import com.fx.market.service.FreeBoardService;
import com.fx.market.service.HomeService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	
	private FreeBoardService freeboardService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		freeboardService = new FreeBoardService();
		Session session = Session.getInstance();
		
		
		String board_Id = session.getTempId();
		
		FreeBoardDto freeboard = freeboardService.selectAll(board_Id);
		sub_category.setText(freeboard.getSub());
		title.setText(freeboard.getTitle());
		content.setText(freeboard.getContent());
		username.setText(freeboard.getAcount_Id());
		address.setText(freeboard.getAddress());
		date.setText(freeboard.getCreatedAt());
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
	}
	public void closeClicked() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}
}
