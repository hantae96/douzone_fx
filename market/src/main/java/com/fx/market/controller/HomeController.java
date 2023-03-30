package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.HomeDto;
import com.fx.market.service.HomeService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// initalize 는 fxml 로더가 fx 변수를 모두 파싱한다음에 호출됨
// 컨트롤러 단에 놓지 않으면 ex) 컨트롤러로 선언되지 않은 다른 클래스에 놓으면 실행순서가 보장되지 않기때문에
// fx : id 로 지정된 변수들이 메모리에 로드 되지 않아서 npe 가 발생한다.

public class HomeController implements Initializable {

	@FXML VBox main;
	HomeService homeService;
	
	Viewer viewer;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		homeService = new HomeService();
		printAllItem();
	}
	@FXML
	private void writeButtonClicked(MouseEvent event) {
		
	}

	
	@FXML
	private void purchaseNavClick(Event event) {
		// 홈화면
	}

	@FXML
	private void boardNavClick(Event event) {
		viewer = new Viewer();
		viewer.boardList();
	}
	
	@FXML
	private void myPageNavClick(Event event) {
		viewer = new Viewer();
		viewer.myPageList();
	}

	@FXML
	private void aroundNavClick(Event event) {

	}

	@FXML
	private void accountNavClick(Event event) {
		
	}
	public void printAllItem() {
	    List<HomeDto> items = homeService.makeViewItem();

	    for (HomeDto item : items) {
	        Label name = new Label(item.getItemName());
	        name.setPadding(new Insets(10));
	        // 폰트 크기 변경
	        name.setFont(new Font(16));
	        // 굵기 변경
	        name.setFont(Font.font("System", FontWeight.BOLD, 16));
	        Label address = new Label(item.getAddress());
//	      address.setPadding(new Insets(10));
	        Label price = new Label(item.getPrice());
	        price.setPadding(new Insets(0, 0, 5, 20));

	        Label recommand;

	        if (item.getRecommend() != 0) {
	            recommand = new Label("♡".concat(String.valueOf(item.getRecommend())));
	        } else {
	            recommand = new Label("");
	        }

	        BorderPane section = new BorderPane();
	        section.setBorder(new Border(
	                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        section.setTop(name);
	        section.setLeft(new Label("photo"));
	        section.getLeft().setStyle("-fx-border-color: black;");

	        section.setCenter(price);
	        BorderPane.setAlignment(price, Pos.CENTER_LEFT);

	        section.setBottom(address);
	        section.setRight(recommand);

	        section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
	        

	        main.getChildren().add(section);
	  
	    }
	    
	    Button wrtieButton = new Button("글쓰기");
	    wrtieButton.setPrefSize(370, 100);
	    wrtieButton.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
	    wrtieButton.setAlignment(Pos.CENTER);
	    
	    
	    wrtieButton.setOnAction(event -> {
	        // 버튼을 클릭했을 때 실행될 코드를 여기에 작성합니다.
	        System.out.println("글쓰기 버튼이 클릭되었습니다.");
	    });
	    
	    main.getChildren().add(wrtieButton);
	}


}
