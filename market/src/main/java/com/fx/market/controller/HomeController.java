package com.fx.market.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import oracle.net.aso.s;

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
	private void onSeachButtonClicked() {
		// 찾기버튼 기능 구현중
	}

	
	@FXML
	private void purchaseNavClick(Event event) {
		// 홈화면
	}

	@FXML
	private void boardNavClick(Event event) {
		viewer = new Viewer();
		viewer.setViewCenter("meetingBoardListForm");
	}
	
	@FXML
	private void myPageNavClick(Event event) {
		viewer = new Viewer();
		viewer.setViewCenter("myDouzone");
	}

	@FXML
	private void aroundNavClick(Event event) {
	}

	@FXML
	private void accountNavClick(Event event) {
		
	}
	
	private void openItemDetails(HomeDto item) {
		System.out.println("상세 페이지 클");
	}
	public void printAllItem() {
	    List<HomeDto> items = homeService.makeViewItem();

	    for (HomeDto item : items) {
	        Label name = new Label(item.getItemName());
	        name.setPadding(new Insets(10,0,10,55));
	        // 폰트 크기 변경
	        name.setFont(new Font(16));
	        // 굵기 변경
	        name.setFont(Font.font("System", FontWeight.BOLD, 16));
	        
	       
	        // 추천 
	        Label recommand;
	        if (item.getRecommend() != 0) {
	            recommand = new Label("♡ ".concat(String.valueOf(item.getRecommend())));
	        } else {
	            recommand = new Label("");
	        }

	        BorderPane section = new BorderPane();
	        section.setBorder(new Border(
	                new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        // 상품이름
	        section.setTop(name);
	        section.setLeft(new Label("photo"));
	        section.getLeft().setStyle("-fx-border-color: grey;");

	        // 주소 + 날짜를 같이 넣기 위해 HBox 넣기

	        // 주소
	        Label address = new Label(item.getAddress());
	        address.setPadding(new Insets(10,0,0,20));
	        
	        //가격
	        Label price = new Label(item.getPrice().concat(" 원"));


	        // 날짜
	        
	        
	        Label date = new Label("•".concat(String.valueOf(calculateDate(item))).concat("일 전"));
	        date.setPadding(new Insets(10,0,0,10));

	        section.setCenter(address);

			HBox centerBox = new HBox(10); // 간격 조정을 위해 10의 간격으로 생성
			centerBox.getChildren().addAll(address, date);
			section.setCenter(centerBox);
	        
	        // 가격
	        section.setBottom(price);
	        price.setPadding(new Insets(10,0,0,55)); // 모든 방향에 대해 10px의 패딩 적용
	        price.setFont(Font.font("System", FontWeight.BOLD, 16));

	        
	        
	        // 추천
	        section.setRight(recommand);
	        
	        section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
	        section.setOnMouseClicked(event -> openItemDetails(item)); // 클릭 이벤트 핸들러 등록

	        main.getChildren().add(section);
	  
	    }
	    
	    Button wrtieButton = new Button("글쓰기");
	    wrtieButton.setPrefSize(370, 100);
	    wrtieButton.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
	    wrtieButton.setAlignment(Pos.CENTER);
	    
	    
	    wrtieButton.setOnAction(event -> {
	        // 버튼을 클릭했을 때 실행될 코드를 여기에 작성합니다.	        
			
			Viewer viewer = new Viewer();
			viewer.setView("register");
			
	    });
	    
	    main.getChildren().add(wrtieButton);
	}
	
	private long calculateDate(HomeDto item){        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long diff = 0;
        try {
            Date updateDate = sdf.parse(item.getDate());
            Date currentDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

            long diffInMillies = Math.abs(currentDate.getTime() - updateDate.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return diff;
	}
}



	