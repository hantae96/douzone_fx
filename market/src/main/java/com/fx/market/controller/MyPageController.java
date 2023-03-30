package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.MyPageDto;
import com.fx.market.service.MyPageService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MyPageController implements Initializable {

	// initalize 는 fxml 로더가 fx 변수를 모두 파싱한다음에 호출됨
	// 컨트롤러 단에 놓지 않으면 ex) 컨트롤러로 선언되지 않은 다른 클래스에 놓으면 실행순서가 보장되지 않기때문에
	// fx : id 로 지정된 변수들이 메모리에 로드 되지 않아서 npe 가 발생한다.

		Viewer viewer;
		@FXML private ImageView photo;
		@FXML private Label name;
		@FXML private Label id;
		@FXML private Label temp;
		@FXML private Label tempAnnotation;
		@FXML private Label created_at;
		@FXML private Label rating_num;
		@FXML private Label favor_num;
		@FXML private Label sell_num;
		@FXML private Label buy_num;
		@FXML private Label document_num;
		@FXML private Label text;
		
		private MyPageService service;

		//마이페이지 이동시 내 정보 불러오기
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			service = new MyPageService();
			showMyPage();
		}
	
		// 매너온도 설명 출력
		@FXML
		private void showAnnotation(Event event) {
			if(text.isVisible()) {
				text.setVisible(false);
				tempAnnotation.setVisible(true);
			}else {				
				text.setVisible(true);
				tempAnnotation.setVisible(false);				
			}
			
		}
		
		//마이 페이지 도달시 출력
		public void showMyPage() {
			String id = Session.getInstance().getAccountId();
			MyPageDto dto = service.getMyInfo(id);
			
			name.setText(dto.getName());
			this.id.setText(id);
			temp.setText(dto.getTemp());
			created_at.setText(dto.getCreated_at());

		}
		
		
		
		
		
}
