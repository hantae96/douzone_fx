package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.dto.town.TownDto;
import com.fx.market.service.FreeBoardService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TownController implements Initializable{
	@FXML ComboBox<String> middle_category;
	@FXML TextField title;
	@FXML TextArea content;
	@FXML Button button1;
	@FXML Button button2;
	@FXML private ComboBox combo_box;
	
	private FreeBoardService freeboardService;  
 
    private ObservableList<String> list = FXCollections.observableArrayList("동네질문","동네사건사고","동네맛집","동네소식","생활정보","취미생활");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		middle_category.setItems(list);
		freeboardService = new FreeBoardService(); 
	}
	
	
	public void boardClick() {
	String Nmiddle_category = middle_category.getValue();
	String Ncontent = content.getText(); 
	String Ntitle = title.getText();
		freeboardService.boardClick(Nmiddle_category, Ntitle, Ncontent);
	}
//	public void insertFreeBoard(s) {
//		freeboardService.insertFreeBoard(middle_category.getValue(), title.getText(), content.getText());
//	}
//	
}
