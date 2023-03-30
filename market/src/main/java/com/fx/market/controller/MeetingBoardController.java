package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.service.BoardService;

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MeetingBoardController implements Initializable{

	@FXML VBox main;
	BoardService boardService;
	
	Viewer viewer;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();
		printAllItem();
	}
	
	public void printAllItem() {
		List<BoardDto> boards = boardService.selectMeetingBoardList();
		Viewer viewer = new Viewer();
		System.out.println("Aa");
		for (BoardDto board : boards) {
			
			System.out.println(board.getBoardId());
			Label name = new Label(board.getTitle());
			name.setPadding(new Insets(10));
			// 폰트 크기 변경
			name.setFont(new Font(16));
			// 굵기 변경
			name.setFont(Font.font("System", FontWeight.BOLD, 16));
			Label address = new Label(board.getAddress());
//			address.setPadding(new Insets(10));
//			Label price = new Label(item.getPrice());
//			price.setPadding(new Insets(0, 0, 5, 20));

			Label recommand;

//			if (board.getRecommend() != 0) {
//				recommand = new Label("♡".concat(String.valueOf(item.getRecommend())));
//			} else {
//				recommand = new Label("");
//			}

			BorderPane section = new BorderPane();
			section.setBorder(new Border(
					new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

			section.setTop(name);
			section.setLeft(new Label("photo"));
			section.getLeft().setStyle("-fx-border-color: black;");

//			section.setCenter(price);
//			BorderPane.setAlignment(price, Pos.CENTER_LEFT);

			section.setBottom(address);
//			section.setRight(recommand);

			section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
			
			section.setOnMouseClicked(event->{
				System.out.println(board.getBoardId());
				viewer.setViewCenter("meetingBoardDetailForm");	
			});

			main.getChildren().add(section);

		}

	    Button wrtieButton = new Button("글쓰기");
	    wrtieButton.setPrefSize(370, 100);
	    wrtieButton.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-font-weight: bold;");
	    wrtieButton.setAlignment(Pos.CENTER);
	    
	    
	    wrtieButton.setOnAction(event -> {
	    	System.out.print("aa");
//	        // 버튼을 클릭했을 때 실행될 코드를 여기에 작성합니다.	        

			viewer.setView("meetingBoardWriteForm");			
//			
	    });
	    
	    main.getChildren().add(wrtieButton);
	}

}
