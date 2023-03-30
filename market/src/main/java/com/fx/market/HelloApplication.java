package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.fx.market.common.Session;
import com.fx.market.controller.HomeController;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


		FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/login.fxml"));
		Scene home = new Scene(homeFxmlLoader.load(), 380, 750);


		stage.setTitle("홈 화면");
		stage.setScene(home);
		
		Session session = Session.getInstance();
	    session.setStage(stage);
	    
    	//HomeController homeController = new HomeController();
        stage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
}