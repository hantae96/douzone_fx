package com.fx.market;

import java.io.IOException;

import com.fx.market.common.Session;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/login.fxml"));
		Scene home = new Scene(homeFxmlLoader.load(), 360, 750);
		
		
		stage.setTitle("홈 화면");
		stage.setScene(home);
		
		Session session = Session.getInstance();
	    session.setStage(stage);
        stage.show();
    	
    }
    	


    public static void main(String[] args) {
        launch();
    }
}