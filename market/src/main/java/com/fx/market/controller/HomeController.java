package com.fx.market.controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.dao.HomeDao;
import com.fx.market.dto.HomeDto;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


// initalize 는 fxml 로더가 fx 변수를 모두 파싱한다음에 호출됨
// 컨트롤러 단에 놓지 않으면 ex) 컨트롤러로 선언되지 않은 다른 클래스에 놓으면 실행순서가 보장되지 않기때문에
// fx : id 로 지정된 변수들이 메모리에 로드 되지 않아서 npe 가 발생한다.

public class HomeController implements Initializable{
	
	@FXML VBox main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		printAllItem();
	}

	public void printAllItem() {
		HomeDao dao = new HomeDao();
		List<HomeDto> items = dao.getItemAll();
		for (HomeDto item : items) {
				Label label = new Label(item.getItemName());
				main.getChildren().add(label);
		}
	}

	@FXML
	private void purchaseNavClick(Event event) {

	}

	@FXML
	private void boardNavClick(Event event) {

	}

	@FXML
	private void aroundNavClick(Event event) {

	}

	@FXML
	private void accountNavClick(Event event) {

	}

	

}
