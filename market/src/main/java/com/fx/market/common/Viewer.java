package com.fx.market.common;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Viewer {

	private static Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	

	public static void setView(String viewName) {
			FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
	        Parent menuForm = null;
	
	        try {
	            menuForm = loader.load();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	        primaryStage = Session.getInstance().getStage();
	
	        Scene scene = new Scene(menuForm);
	        primaryStage.setTitle("등록 화면");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}


	public static void setViewCenter(String viewName) {
			FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
	        Parent menuForm = null;
	
	        try {
	            menuForm = loader.load();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	        primaryStage = Session.getInstance().getStage();

	
	
	        BorderPane boarderPane = (BorderPane) menuForm;
	        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
	        ScrollPane sroot = (ScrollPane) root.getCenter();
	        sroot.lookup(".scroll-bar:vertical").setStyle("-fx-opacity: 0;");
	        sroot.lookup(".scroll-bar:horizontal").setStyle("-fx-opacity: 0;");
//	        sroot.setContent(null);
	        sroot.setContent(boarderPane);
	}

	//스크롤판 전환 스크롤 안숨김
	public void setViewCenterScroll(String viewName) {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
		Parent menuForm = null;
		
		try {
			menuForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.primaryStage = Session.getInstance().getStage();
		
		
		
		BorderPane boarderPane = (BorderPane) menuForm;
		BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
		ScrollPane sroot = (ScrollPane) root.getCenter();
		sroot.lookup(".scroll-bar:vertical").setStyle("-fx-opacity: 1;");
		sroot.setVvalue(0);	//맨위로 커서 이동
//		sroot.lookup(".scroll-bar:horizontal").setStyle("-fx-opacity: 0;");
//		sroot.setContent(null);
		sroot.setContent(boarderPane);
	}
	

}
