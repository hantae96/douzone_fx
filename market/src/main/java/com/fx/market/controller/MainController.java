package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Viewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable {
	
	private Viewer viewer;

	public void setViewer(Viewer viewer) {
		this.viewer = viewer;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void purchaseNavClick() {
		viewer.purchaseList();
	}
	
	public void boardNavClick() {
		viewer.boardList();
	}

	
	public void aroundNavClick() {
		viewer.aroundList();
	}

	public void accountNavClick() {
		viewer.accountList();
	}
	
	

}