package com.fx.market.common;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Viewer {


	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setViewCenter(String viewName) {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
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
	
	public void setView(String viewName) {
		FXMLLoader loader = new FXMLLoader(Viewer.class.getResource("/com/fx/market/views/"+viewName+".fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setPrimaryStage(Session.getInstance().getStage());

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("등록 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
	}


}
