package com.fx.market.service;

import java.io.IOException;
import com.fx.market.HelloApplication;
import com.fx.market.dao.HomeDao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeService {
	
	private Stage stage;
	@FXML VBox main;
	HomeDao dao = new HomeDao();
	
	public void view(Stage stage) {
		this.stage = stage;
		// 디비 객체들을 다 화면에 뿌리는 방법
		// 디비에커서를 돌면서 while
		// 반복문을 돌면서 버튼 객체를생성하고,
		// 미리 만들어놓은 fxml 안에 vBox 같은 객체에 자식 으로 넣는다.

		FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/home.fxml"));
		try {
			Scene home = new Scene(homeFxmlLoader.load(), 370, 650);
			// 나중에 로그인 화면 구현 되면 그걸로 스테이지 갈아끼우면됨
			stage.setTitle("홈 화면");
			stage.setScene(home);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllItem() {
		Label label = new Label();
		//main.getChildren().add(label);
		dao.getItemAll();
	}
	
}
