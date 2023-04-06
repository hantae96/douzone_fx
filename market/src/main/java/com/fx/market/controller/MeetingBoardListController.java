package com.fx.market.controller;

import java.net.URL;
import java.time.Duration;
import java.time.Instant;
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
import javafx.scene.control.TextField;
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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MeetingBoardListController implements Initializable{

	@FXML private Label addressLabel;
	@FXML private VBox main;
	@FXML private VBox writeMenu;
	@FXML private ScrollPane scrollPane; 
	@FXML private HBox listBottomBox;
	@FXML private AnchorPane anchorPane;
	@FXML private Button writeBtn;
	@FXML private ContextMenu contextMenu;
	@FXML private MenuItem meetingWriteBtn;
	@FXML private MenuItem townWriteBtn;
	@FXML private TextField searchTextField;
	
	private BoardService boardService;
	private PhotoService photoService;
	
	private boolean writeMenuVisible = false;
	
	public void anchorPaneClick() {	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		boardService = new BoardService();
		
		addressLabel.setText(Session.getInstance().getAddress());
		
		printAllItem();
		
		writeBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
//		    	contextMenu.show(writeBtn, event.getScreenX(), event.getScreenY());
				if (writeMenuVisible) {
					writeMenu.setVisible(false);
					writeMenuVisible = false;
				} else {
					writeMenu.setVisible(true);
					writeMenuVisible = true;
				}
		    	
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
		
		anchorPane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
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
			
			Label mainCategoryLabel = new Label(board.getMainCategory());
			
			mainCategoryLabel.setPadding(new Insets(3,3,3,3));
	        mainCategoryLabel.setFont(Font.font("System", FontWeight.BOLD, 9));
	        mainCategoryLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	        BorderPane section = new BorderPane();
	        section.setBorder(new Border(
	                new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        Label titleLabel = new Label(board.getTitle());
	        titleLabel.setPadding(new Insets(5,0,0,0));
	        titleLabel.setFont(Font.font("System", FontWeight.NORMAL, 15));
	        
		     // 현재 시간과 비교할 시간을 밀리초로 구합니다.
	        long currentTimeMillis = Instant.now().toEpochMilli();
	        long pastTimeMillis = board.getCreatedAt().getTime();

	        // Duration 객체를 사용하여 밀리초를 분, 시, 일 등으로 변환합니다.
	        Duration duration = Duration.ofMillis(currentTimeMillis - pastTimeMillis);
	        long days = duration.toDays();

	        String createdAt = null;
	        if(days == 0) {
	        	createdAt = "오늘";
	        }else
	        	createdAt = days+"일전";
	        
	        VBox centerBox = new VBox(10); 
	        centerBox.setSpacing(5);
	        
	        HBox etcHbox = new HBox();
	        Label addressLabel = new Label(board.getAddress());
	        addressLabel.setPadding(new Insets(0,4,0,0));
	        Label createdAtLabel = new Label(createdAt);
	        
	        
	        if(board.getMainCategory().equals("같이해요")) {
		        HBox personHbox = new HBox();
		        Image personImage = new Image("file:src/main/java/com/fx/market/source/image/person.png");
		        ImageView personImageView = new ImageView(personImage);
		        personImageView.setFitWidth(14);
		        personImageView.setFitHeight(14);
		        Label ageLabel = new Label(board.getAge());
		        ageLabel.setPadding(new Insets(0,4,0,4));
		        Label genderLabel = new Label(board.getGender());
		        personHbox.getChildren().addAll(personImageView, ageLabel, genderLabel);
		        
		        HBox calendarHbox = new HBox();
		        Image calendarImage = new Image("file:src/main/java/com/fx/market/source/image/calendar.png");
		        ImageView calendarImageView = new ImageView(calendarImage);
		        calendarImageView.setFitWidth(12);
		        calendarImageView.setFitHeight(12);
		        Label meetingDateLabel = new Label(board.getMeetingDateFormat());
		        meetingDateLabel.setPadding(new Insets(0,4,0,4));
		        Label meetingTimeLabel = new Label(board.getMeetingTime());
		        calendarHbox.getChildren().addAll(calendarImageView, meetingDateLabel, meetingTimeLabel);
		        
		        etcHbox.getChildren().addAll(addressLabel, createdAtLabel);
		       
//		        section.setBottom(etcHbox);
		        centerBox.getChildren().addAll(titleLabel, personHbox, calendarHbox, etcHbox);
	        }else {
	        	Label contentLabel = new Label(board.getContent());
	        	centerBox.getChildren().addAll(titleLabel, contentLabel);
	        	
	        	BorderPane bottomPane = new BorderPane();
	        	
	        	Label viewLabel = new Label("조회수 "+String.valueOf(board.getViews()));
	        	etcHbox.getChildren().addAll(addressLabel, createdAtLabel, viewLabel);
	        	
	        	bottomPane.setBottom(etcHbox);
	        	((Region)bottomPane.getBottom()).setPrefWidth(360);
	        	
	        	if(board.getRecommends() > 0) {
			        HBox recommendHbox = new HBox();
			        Image recommendImage = new Image("file:src/main/java/com/fx/market/source/image/like.png");
			        ImageView recommendImageView = new ImageView(recommendImage);
			        Label recommendLabel = new Label(String.valueOf(board.getRecommends()));
			        recommendHbox.getChildren().addAll(recommendImageView, recommendLabel);
	        		bottomPane.setRight(recommendHbox);
	        	}
	        	
	        	section.setBottom(bottomPane);
	        	
	        }
	        


	        
			section.resize(257, 500);
			section.setTop(mainCategoryLabel);
			section.setCenter(centerBox);

	        section.setPadding(new Insets(10));
	        section.setOnMouseClicked(event -> {
          
	        	// 상세 페이지 구현중
	    		// item 정보를 받아서 뷰에서 뿌리면 됨.
	    		// viewer 에서 상세 페이지를 작성하자
	    		if(board.getMainCategory().equals("동네생활")) {
	    			Session session =Session.getInstance();
		    		session.setTempId(board.getBoardId());
		    		
		    		Viewer.setView("detailBulletin");
		    		
	    		}else {

	    		Session session =Session.getInstance();
	    		session.setTempId(board.getBoardId());
	    		
	    		
	    		
	    		Viewer.setView("meetingBoardDetailForm");
	    		}
        	});
	        
	        
	        
	        VBox rightVbox = new VBox();
	        
	        Image photoImage = new Image("file:" + photo.getPath());
	        ImageView photoImageView = new ImageView();
    	    photoImageView.setFitWidth(60);
    	    photoImageView.setFitHeight(60);
    	    photoImageView.setImage(photoImage);

	        rightVbox.getChildren().add(photoImageView);
	        
	        section.setRight(rightVbox);
	        
	        main.getChildren().add(section);
	  
	    }
		
	    
	}
	
	public void meetingWriteBtnClick() {
		Viewer.setView("meetingBoardWriteForm");
	}
	
	public void townWriteBtnClick() {
		Viewer.setView("main_Bulletin");
	}
	
	public void meetingWriteMenuClick() {
	}
	
	public void homeNavClick() {
		Viewer.setView("home");
	}
	
	public void boardNavClick() {
		Viewer.setView("meetingBoardListForm");
	}
	
	
	public void myPageNavClick() {
		Viewer.setView("home");
		Viewer.setViewCenter("myDouzone");
	}

	public void searchBtnClick() {
		main.getChildren().clear();
		printSearchItem(searchTextField.getText());
	}
	
	public void printSearchItem(String searchStr) {
		boardService = new BoardService();
		List<BoardDto> boards = boardService.searchBoardList(searchStr);
		
		for (BoardDto board : boards) {
			photoService = new PhotoService();
			PhotoDto photo = photoService.getPhoto(board.getBoardId());
			
			if(photo == null)
				photo = new PhotoDto();
			
			Label mainCategoryLabel = new Label(board.getMainCategory());
			
			mainCategoryLabel.setPadding(new Insets(3,3,3,3));
	        mainCategoryLabel.setFont(Font.font("System", FontWeight.BOLD, 9));
	        mainCategoryLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	        BorderPane section = new BorderPane();
	        section.setBorder(new Border(
	                new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

	        Label titleLabel = new Label(board.getTitle());
	        titleLabel.setPadding(new Insets(5,0,0,0));
	        titleLabel.setFont(Font.font("System", FontWeight.NORMAL, 15));
	        
		     // 현재 시간과 비교할 시간을 밀리초로 구합니다.
	        long currentTimeMillis = Instant.now().toEpochMilli();
	        long pastTimeMillis = board.getCreatedAt().getTime();

	        // Duration 객체를 사용하여 밀리초를 분, 시, 일 등으로 변환합니다.
	        Duration duration = Duration.ofMillis(currentTimeMillis - pastTimeMillis);
	        long days = duration.toDays();

	        String createdAt = null;
	        if(days == 0) {
	        	createdAt = "오늘";
	        }else
	        	createdAt = days+"일전";
	        
	        VBox centerBox = new VBox(10); 
	        centerBox.setSpacing(5);
	        
	        HBox etcHbox = new HBox();
	        Label addressLabel = new Label(board.getAddress());
	        addressLabel.setPadding(new Insets(0,4,0,0));
	        Label createdAtLabel = new Label(createdAt);
	        
	        
	        if(board.getMainCategory().equals("같이해요")) {
		        HBox personHbox = new HBox();
		        Image personImage = new Image("file:src/main/java/com/fx/market/source/image/person.png");
		        ImageView personImageView = new ImageView(personImage);
		        personImageView.setFitWidth(14);
		        personImageView.setFitHeight(14);
		        Label ageLabel = new Label(board.getAge());
		        ageLabel.setPadding(new Insets(0,4,0,4));
		        Label genderLabel = new Label(board.getGender());
		        personHbox.getChildren().addAll(personImageView, ageLabel, genderLabel);
		        
		        HBox calendarHbox = new HBox();
		        Image calendarImage = new Image("file:src/main/java/com/fx/market/source/image/calendar.png");
		        ImageView calendarImageView = new ImageView(calendarImage);
		        calendarImageView.setFitWidth(12);
		        calendarImageView.setFitHeight(12);
		        Label meetingDateLabel = new Label(board.getMeetingDateFormat());
		        meetingDateLabel.setPadding(new Insets(0,4,0,4));
		        Label meetingTimeLabel = new Label(board.getMeetingTime());
		        calendarHbox.getChildren().addAll(calendarImageView, meetingDateLabel, meetingTimeLabel);
		        
		        etcHbox.getChildren().addAll(addressLabel, createdAtLabel);
		       
		        section.setBottom(etcHbox);
		        centerBox.getChildren().addAll(titleLabel, personHbox, calendarHbox);
	        }else {
	        	Label contentLabel = new Label(board.getContent());
	        	centerBox.getChildren().addAll(titleLabel, contentLabel);
	        	
	        	BorderPane bottomPane = new BorderPane();
	        	
	        	Label viewLabel = new Label("조회수 "+String.valueOf(board.getViews()));
	        	etcHbox.getChildren().addAll(addressLabel, createdAtLabel, viewLabel);
	        	
	        	bottomPane.setBottom(etcHbox);
	        	((Region)bottomPane.getBottom()).setPrefWidth(360);
	        	
	        	if(board.getRecommends() > 0) {
			        HBox recommendHbox = new HBox();
			        Image recommendImage = new Image("file:src/main/java/com/fx/market/source/image/like.png");
			        ImageView recommendImageView = new ImageView(recommendImage);
			        Label recommendLabel = new Label(String.valueOf(board.getRecommends()));
			        recommendHbox.getChildren().addAll(recommendImageView, recommendLabel);
	        		bottomPane.setRight(recommendHbox);
	        	}
	        	
	        	section.setBottom(bottomPane);
	        	
	        }
	        


	        
			section.resize(357, 500);
			section.setTop(mainCategoryLabel);
			section.setCenter(centerBox);

	        section.setPadding(new Insets(10));
	        section.setOnMouseClicked(event -> {
          
	        	// 상세 페이지 구현중
	    		// item 정보를 받아서 뷰에서 뿌리면 됨.
	    		// viewer 에서 상세 페이지를 작성하자
	    		if(board.getMainCategory().equals("동네생활")) {
	    			Session session =Session.getInstance();
		    		session.setTempId(board.getBoardId());
		    		
		    		Viewer.setView("detailBulletin");
		    		
	    		}else {

	    		Session session =Session.getInstance();
	    		session.setTempId(board.getBoardId());
	    		
	    		
	    		
	    		Viewer.setView("meetingBoardDetailForm");
	    		}
        	});
	        
	        
	        
	        VBox rightVbox = new VBox();
	        
	        Image photoImage = new Image("file:" + photo.getPath());
	        ImageView photoImageView = new ImageView();
    	    photoImageView.setFitWidth(60);
    	    photoImageView.setFitHeight(60);
    	    photoImageView.setImage(photoImage);

	        rightVbox.getChildren().add(photoImageView);
	        
	        section.setRight(rightVbox);
	        
	        main.getChildren().add(section);
	  
	    }
	}
	
}