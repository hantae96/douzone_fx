package com.fx.market.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.dto.BoardDto;
import com.fx.market.dto.PhotoDto;
import com.fx.market.service.BoardService;
import com.fx.market.service.PhotoService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
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

public class MeetingBoardController implements Initializable{

	@FXML VBox main;
	@FXML VBox writeMenu;
	@FXML ScrollPane scrollPane; 
	@FXML HBox listBottomBox;
	@FXML AnchorPane anchorPane;
	@FXML Button writeBtn;
	@FXML ContextMenu contextMenu;
	@FXML MenuItem meetingWriteBtn;
	@FXML MenuItem townWriteBtn;
	
	private BoardService boardService;
	private PhotoService photoService;
	
	private boolean writeMenuVisible = false;
	
	public void anchorPaneClick() {	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();

		printAllItem();
		
		writeBtn.addEventFilter(MouseEvent.ANY, event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
//		    	contextMenu.show(writeBtn, event.getScreenX(), event.getScreenY());
				if (writeMenuVisible) {
					writeMenu.setVisible(false);
					writeMenuVisible = false;
				} else {
					writeMenu.setVisible(true);
					writeMenuVisible = true;
				}
		    	
		    	System.out.println(event.getTarget());
		    	
		    }
			
		});
		
		//anchorPane 스크롤 이벤트 scrollPane에게 전달
		anchorPane.addEventFilter(ScrollEvent.ANY, event -> {
		    scrollPane.fireEvent(event);
		});
		
	    scrollPane.setOnScroll(event -> {
	        double deltaY = event.getDeltaY(); // * event.getMultiplierY();
	        scrollPane.setVvalue(scrollPane.getVvalue() - deltaY);
	    });
		
		anchorPane.addEventFilter(MouseEvent.ANY, event -> {
			 scrollPane.fireEvent(event);
			 for (Node node : main.getChildren()) {
			    if (node instanceof BorderPane) {
			    	BorderPane section = (BorderPane) node;
		            Bounds boundsInScene = section.localToScene(section.getBoundsInLocal());
		            
		            if (boundsInScene.contains(event.getSceneX(), event.getSceneY())) {
		            	if (event.getSceneX() < 300 || event.getSceneX() > 360 || event.getSceneY() < 580 || event.getSceneY() > 640) {
		            		section.fireEvent(event);
			                break;
	            	    }
		            }
			    }
			}
		});
		
		Node node = scrollPane.lookup(".scroll-bar:vertical");
		if (node != null) {
		    node.setStyle("-fx-opacity: 0;");
		}
		node = scrollPane.lookup(".scroll-bar:horizontal");
		if (node != null) {
		    node.setStyle("-fx-opacity: 0;");
		}
		
	}
	
	public void printAllItem() {
		List<BoardDto> boards = boardService.selectMeetingBoardList();
		
		for (BoardDto board : boards) {
			photoService = new PhotoService();
			PhotoDto photo = photoService.getPhoto(board.getBoardId());
			
			if(photo == null)
				photo = new PhotoDto();
			
//			System.out.println(photo.getPhotos_id());
			System.out.println();
			
			Label mainCategoryLabel = new Label(board.getMainCategory());
			
			
			mainCategoryLabel.setPadding(new Insets(3,3,3,3));

			// 굵기 변경
	        mainCategoryLabel.setFont(Font.font("System", FontWeight.BOLD, 9));
	        
	        mainCategoryLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	        
	       
	        // 추천 
	        Label recommand;
	        if (board.getRecommends() != 0) {
	            recommand = new Label("♡ ".concat(String.valueOf(board.getRecommends())));
	        } else {
	            recommand = new Label("");
	        }

	        HBox section = new HBox();
	        section.setBorder(new Border(
	                new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        // Product name
	        section.setTop(mainCategoryLabel);
	        section.setRight(new Label("photo"));
	        section.getRight().setStyle("-fx-border-color: grey;");

	        // 주소 + 날짜를 같이 넣기 위해 HBox 넣기

	        // 주소
	        Label titleLabel = new Label(board.getTitle());
	        titleLabel.setPadding(new Insets(10,0,0,0));
	        titleLabel.setFont(Font.font("System", FontWeight.NORMAL, 15));
	        
	        //가격
//	        Label price = new Label(board.getPrice().concat(" 원"));
	        Label price = new Label("가격");
	        
      
	        


	        section.setCenter(titleLabel);

			HBox centerBox = new HBox(); // 간격 조정을 위해 10의 간격으로 생성
			centerBox.getChildren().addAll(titleLabel);
			section.setCenter(centerBox);
	        
	        // 가격
	        section.setBottom(price);
	        price.setPadding(new Insets(10,0,0,55)); // 모든 방향에 대해 10px의 패딩 적용
	        price.setFont(Font.font("System", FontWeight.BOLD, 16));

	        
	        
	        // 추천
//	        section.setRight(recommand);
	        section.resize(357, 500);
	        section.setPadding(new Insets(10)); // 모든 방향에 대해 10px의 패딩 적용
	        section.setOnMouseClicked(event -> {
	        	// 상세 페이지 구현중
	    		// item 정보를 받아서 뷰에서 뿌리면 됨.
	    		// viewer 에서 상세 페이지를 작성하자
	        	
	    		Session session =Session.getInstance();
	    		session.setTempId(board.getBoardId());
	    		
	        	if(board.getMainCategory() == "같이해요") {
	        	
	        		Viewer.setView("meetingBoardDetailForm");}
	        	else if(board.getMainCategory() == "동네생활") {
	        		Viewer.setView("meetingBoardDetailForm");
	        		
	        	}
	        	
        	}); // 클릭 이벤트 핸들러 등록
	        
	        
	    	String imagePath = "file:src/main/java/com/fx/market/source/image/default.jpg";
	        Image photoImage = null;
	
            photoImage = new Image("file:" + photo.getPath());
//            photoImage = new Image(imagePath);
	        System.out.println("file:"+photo.getPath());    

	    	ImageView photoImageView = null;
	    	
    		photoImageView = new ImageView();
    	    photoImageView.setFitWidth(50);
    	    photoImageView.setFitHeight(50);
    	    photoImageView.setImage(photoImage);
	    										
	        
	        VBox rightVbox = new VBox();
	        rightVbox.getChildren().addAll(photoImageView);
	        section.setRight(rightVbox);

	        main.getChildren().add(section);
	  
	    }
	    
	}
	
	public void meetingWriteBtnClick() {
		Viewer.setView("meetingBoardWriteForm");
	}
	
	public void townWriteBtnClick() {
		
	}
	
	public void meetingWriteMenuClick() {
	}
	
	public void homeNavClick() {
		Viewer.setView("home");
	}
	
	public void boardNavClick() {
		Viewer.setView("meetingBoardListForm");
	}
	
	public void arroundNavClick() {
		System.out.println("내 근처");
	}
	
	public void myPageNavClick() {
		Viewer.setViewCenter("myDouzone");
	}
	
}
