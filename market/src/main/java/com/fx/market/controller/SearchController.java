package com.fx.market.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.fx.market.common.Session;
import com.fx.market.common.Util;
import com.fx.market.common.Viewer;
import com.fx.market.dto.HomeDto;
import com.fx.market.dto.ItemDto;
import com.fx.market.service.HomeService;
import com.fx.market.service.ItemService;
import com.fx.market.service.SearchService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// initalize 는 fxml 로더가 fx 변수를 모두 파싱한다음에 호출됨
// 컨트롤러 단에 놓지 않으면 ex) 컨트롤러로 선언되지 않은 다른 클래스에 놓으면 실행순서가 보장되지 않기때문에
// fx : id 로 지정된 변수들이 메모리에 로드 되지 않아서 npe 가 발생한다.

public class SearchController implements Initializable {

	@FXML Pane main;
	@FXML Button close;
	@FXML TextField searchField;
	
	ItemService itemService;
	SearchService searchService;
	HomeService homeService;
	Viewer viewer;
	String keyword;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchService = new SearchService();
		itemService = new ItemService();
		Session session = Session.getInstance();
		inputSearchField(searchField);
	}
	
	public void inputSearchField(TextField searchField) {
		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			printSearchItem(newValue);
		});
			
	}

	private void openItemDetails(HomeDto item) {
		ItemDto clickedItem = itemService.getItemById(item.getItemId());
		Session session =Session.getInstance();
		session.setModel(clickedItem);
		Viewer.setView("item");
	}
	
	public void printSearchItem(String keyword) {
	    List<HomeDto> items = searchService.searchKeyword(keyword);

	    for (HomeDto item : items) {
	        Label name = new Label(item.getItemName());
	        name.setPadding(new Insets(5,0,10,10));
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
	        section.setStyle("-fx-background-color: white;");
	        section.setBorder(new Border(
	                new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        // 상품이름
	        // 사진
	        String photoPath = itemService.getPhotoPath(item.getItemId());		
			String imagePath = "file:" + System.getProperty("user.dir") +"/".concat(photoPath);
	        ImageView imageView = new ImageView(imagePath);
	        imageView.setFitWidth(80);
	        imageView.setFitHeight(80);
	        imageView.setPreserveRatio(true); // 이미지 비율 유지
	        section.setLeft(imageView);
	        section.getLeft().setStyle("-fx-border-color: grey;");

	        // 주소 + 날짜를 같이 넣기 위해 HBox 넣기
	        // 주소
	        Label address = new Label(item.getAddress());
	        address.setPadding(new Insets(10,0,0,10));
	        
	        //가격
	        Label price = new Label(Util.priceAddComma(item.getPrice()).concat(" 원"));


	        // 날짜
	        Label date = new Label("•".concat(String.valueOf(calculateDate(item))).concat("일 전"));
	        date.setPadding(new Insets(10,0,0,10));
	        
	        section.setCenter(address);

			HBox centerBox = new HBox(10); // 간격 조정을 위해 10의 간격으로 생성
			centerBox.getChildren().addAll(address, date);
			VBox vBox = new VBox();
			vBox.getChildren().addAll(name,centerBox,price);
			section.setCenter(vBox);
	        
	        // 가격
	        price.setPadding(new Insets(10,0,0,10)); // 모든 방향에 대해 10px의 패딩 적용
	        price.setFont(Font.font("System", FontWeight.BOLD, 16));

	        // 추천
	        section.setRight(recommand);
	        
	        section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
	        section.setOnMouseClicked(event -> {
	        									openItemDetails(item);
	        	}); // 클릭 이벤트 핸들러 등록
	        main.getChildren().add(section);
	    }
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
	
	public void onCancelButtonClick() {
		Viewer.setView("home");
	}
}



	