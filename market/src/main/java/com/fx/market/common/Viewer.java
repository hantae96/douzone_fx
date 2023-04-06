package com.fx.market.common;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Viewer {

	private static Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	

	public static void setView(String viewName) {
			FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
	        Parent menuForm = null;
	
	       System.out.println("/com/fx/market/views/"+viewName+".fxml");
	        try {
	            menuForm = loader.load();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	        primaryStage = Session.getInstance().getStage();
	        Scene scene = new Scene(menuForm);
	        primaryStage.setTitle("감귤 마켓");
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
	public static void setViewCenterScroll(String viewName) {
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
		sroot.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sroot.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		sroot.lookup(".scroll-bar:vertical").setStyle("-fx-opacity: 0;");
		sroot.lookup(".scroll-bar:horizontal").setStyle("-fx-opacity: 0;");
        
		sroot.setVvalue(0);	//맨위로 커서 이동
		sroot.setContent(boarderPane);
	}
	
	public static void setViewCenter2(String viewName) {
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
        StackPane sroot = (StackPane) root.getCenter();
        ScrollPane ssroot = (ScrollPane)sroot.getChildren().get(0);
        AnchorPane ssroot2 = (AnchorPane)sroot.getChildren().get(1);
        ScrollPane scrollPane = new ScrollPane();
        sroot.getChildren().clear();
        
//        ssroot2.getChildren().clear();

//        sroot.setContent(null);
        scrollPane.setContent(boarderPane);
        
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        ssroot.lookup(".scroll-bar:vertical").setStyle("-fx-opacity: 0;");
        ssroot.lookup(".scroll-bar:horizontal").setStyle("-fx-opacity: 0;");
//		Node node = scrollPane.lookup(".scroll-bar:vertical");
//		if (node != null) {
//		    node.setStyle("-fx-opacity: 0;");
//		}
//		node = scrollPane.lookup(".scroll-bar:horizontal");
//		if (node != null) {
//		    node.setStyle("-fx-opacity: 0;");
//		}
        sroot.getChildren().add(scrollPane);

}
	

}
