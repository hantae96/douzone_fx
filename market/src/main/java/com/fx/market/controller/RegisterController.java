package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.fx.market.common.Viewer;
import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.service.RegisterService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable {
	RegisterService registerService;

	@FXML
	private TextField name;

	@FXML
	private TextField price;

	@FXML
	private TextField context;

	@FXML
	private TextField address;
	@FXML
	Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.registerService = new RegisterService(new RegisterDao());
		checkPrice(price);
	}

	@FXML
	private void onRegsistButtonClick() {
		registerService.saveItemData(
				new ItemDto(name.getText(), Long.valueOf(price.getText()), context.getText(), address.getText()));
	}

	@FXML
	private void onCancelButtonClick() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}

	private void checkPrice(TextField price) {
		// 가격 입력값 유효성검사
		price.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\d*")) {
				price.setText(oldValue);
				price.setStyle("-fx-text-fill: red;");
				price.setPromptText("가격");
			} else {
				price.setStyle("-fx-text-fill: black;");
				price.setPromptText("");
			}
		});
	}
}
