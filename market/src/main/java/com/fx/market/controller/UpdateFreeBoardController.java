package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Viewer;
import com.fx.market.dto.FreeBoardDto;
import com.fx.market.service.FreeBoardService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateFreeBoardController implements Initializable{
	@FXML ComboBox<String> sub;
	@FXML TextField main_category;
	@FXML TextField title;
	@FXML TextArea content;
	@FXML Button closebutton;
	@FXML Button imagebutton;
	@FXML private ComboBox combo_box;
	
	private FreeBoardService freeboardService;  
	private String boardId;
    private ObservableList<String> list = FXCollections.observableArrayList("동네질문","동네사건사고","동네맛집","동네소식","생활정보","취미생활");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sub.setItems(list);
		freeboardService = new FreeBoardService(); 
		
		FreeBoardDto freeboardDto = freeboardService.selectBoard("b43");
		boardId = "b43";
		sub.setValue(freeboardDto.getSub());
		title.setText(freeboardDto.getTitle());
		content.setText(freeboardDto.getContent());
	}
	
	
	public void boardClick() {

		
		
		freeboardService.updateboardClick(sub.getValue(), content.getText(), title.getText(), boardId);
		
	}
	public void closebtn() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
		
	}
	
	public void imagebtn() {
		System.out.println("imagebutton test");
	}
	
//	Session session = Session.getInstance();
	
}
