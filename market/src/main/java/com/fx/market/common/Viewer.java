package com.fx.market.common;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Viewer {


	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void boardList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/signUp.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPrimaryStage(Session.getInstance().getStage());

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("메인 화면");
        primaryStage.setScene(scene);
        primaryStage.show();

		
	}

	public void aroundList() {
		  FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/purchaseView.fxml"));
	        Parent menuForm = null;

	        try {
	            menuForm = loader.load();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        Stage stage = new Stage();

	        Scene scene = new Scene(menuForm);
	        primaryStage.setTitle("메인 화면");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		
	}

	public void registList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/register.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BorderPane boarderPane = (BorderPane) menuForm;
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
        ScrollPane sroot = (ScrollPane) root.getCenter();
        sroot.setContent(null);
        sroot.setContent(boarderPane);
		
	}

	// 회원가입 페이지로 이동
	public void accountList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/signUp.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("메인 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
        
      Session session = Session.getInstance();
      session.setStage(primaryStage);
		
	}
	public void loginList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/login.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("로그인");
        primaryStage.setScene(scene);
        primaryStage.show();
        
      Session session = Session.getInstance();
      session.setStage(primaryStage);
		
	}

	// 판매목록 페이지로 이동
	public void homeList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/home.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("메인 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
        
      Session session = Session.getInstance();
      session.setStage(primaryStage);
		
	}

	// 마이페이지로 이동
	public void myPageList() {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/myDouzone.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPrimaryStage(Session.getInstance().getStage());

        BorderPane boarderPane = (BorderPane) menuForm;
        BorderPane root = (BorderPane) primaryStage.getScene().getRoot();
        ScrollPane sroot = (ScrollPane) root.getCenter();
        sroot.setContent(null);
        sroot.setContent(boarderPane);
		
	}
	
	

}
