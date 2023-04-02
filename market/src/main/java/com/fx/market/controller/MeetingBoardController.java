package com.fx.market.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
import javafx.stage.Stage;

public class MeetingBoardController implements Initializable{

	@FXML VBox main;
	@FXML HBox listBottomBox;
	
	BoardService boardService;
	
	Viewer viewer;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();
		printAllItem();
	}
	
//	public void printAllItem() {
//	    Stage stage = Session.getInstance().getStage();
//	    BorderPane root = (BorderPane) stage.getScene().getRoot();
//	    ScrollPane sroot = (ScrollPane) root.getCenter();
//	    
//
//	    VBox vbox = new VBox();
//	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/fx/market/views/meetingBoardWriteForm.fxml"));
//	    System.out.println(getClass().getResource("/com/fx/market/views/meetingBoardWriteForm.fxml"));
//	    Pane pane = null;
//		try {
//			pane = loader.load();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        vbox.getChildren().add(pane);
////	    for (int i = 0; i < 5; i++) {
////	    	
////	        try {
////	            
////	        } catch (IOException e) {
////	            e.printStackTrace();
////	        }
////	    }
//
//	    sroot.setContent(vbox);
//	}

	
	public void printAllItem() {
		List<BoardDto> boards = boardService.selectMeetingBoardList();
		
		
		for (BoardDto board : boards) {
			Label name = new Label(board.getTitle());
	        name.setPadding(new Insets(10,0,10,55));
	        // 폰트 크기 변경
	        name.setFont(new Font(16));
	        // 굵기 변경
	        name.setFont(Font.font("System", FontWeight.BOLD, 16));
	        
	       
	        // 추천 
	        Label recommand;
	        if (board.getRecommends() != 0) {
	            recommand = new Label("♡ ".concat(String.valueOf(board.getRecommends())));
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
	        Label address = new Label(board.getAddress());
	        address.setPadding(new Insets(10,0,0,20));
	        
	        //가격
//	        Label price = new Label(board.getPrice().concat(" 원"));


	        // 날짜
	        
	        
//	        Label date = new Label("•".concat(String.valueOf(calculateDate(item))).concat("일 전"));
//	        date.setPadding(new Insets(10,0,0,10));
//
//	        section.setCenter(address);

			HBox centerBox = new HBox(10); // 간격 조정을 위해 10의 간격으로 생성
//			centerBox.getChildren().addAll(address, date);
			section.setCenter(centerBox);
	        
	        // 가격
//	        section.setBottom(price);
//	        price.setPadding(new Insets(10,0,0,55)); // 모든 방향에 대해 10px의 패딩 적용
//	        price.setFont(Font.font("System", FontWeight.BOLD, 16));

	        
	        
	        // 추천
	        section.setRight(recommand);
	        
	        section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
	        section.setOnMouseClicked(event -> {
	        	// 상세 페이지 구현중
	    		// item 정보를 받아서 뷰에서 뿌리면 됨.
	    		// viewer 에서 상세 페이지를 작성하자
	    		
	    		Session session =Session.getInstance();
	    		session.setTempId(board.getBoardId());
	    		Viewer viwer= new Viewer();
	    		viwer.setView("meetingBoardDetailForm");
	        	}); // 클릭 이벤트 핸들러 등록

	        main.getChildren().add(section);
	  
	    }
	    
	    Button wrtieButton = new Button("글쓰기");
	    wrtieButton.setPrefSize(370, 100);
	    wrtieButton.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
	    wrtieButton.setAlignment(Pos.CENTER);
	    
	    
	    wrtieButton.setOnAction(event -> {
	        // 버튼을 클릭했을 때 실행될 코드를 여기에 작성합니다.	        
			
			Viewer viewer = new Viewer();
			viewer.setView("meetingBoardWriteForm");
			
	    });
	    
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/section.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

	    
	    Stage stage = Session.getInstance().getStage();

		
//        BorderPane root = (BorderPane) stage.getScene().getRoot();
//        ScrollPane croot = (ScrollPane) root.getCenter();
//
//        VBox broot = (VBox) root.getBottom();
////        broot.setContent(null);
//        broot.getChildren().add(0, menuForm);
	    
	    main.getChildren().add(wrtieButton);
	}

}
