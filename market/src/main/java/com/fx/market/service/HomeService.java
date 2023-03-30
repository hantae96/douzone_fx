package com.fx.market.service;

import java.io.IOException;
import java.util.List;

import com.fx.market.HelloApplication;
import com.fx.market.dao.HomeDao;
import com.fx.market.dto.HomeDto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeService {
	public List<HomeDto> makeViewItem() {
		HomeDao dao = new HomeDao();
		List<HomeDto> items = dao.getItemAll();
		return items;
	}
	

	

}
