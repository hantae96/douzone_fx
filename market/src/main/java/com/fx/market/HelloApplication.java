package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.fx.market.controller.HomeController;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    	        
// 홈 화면 테스트
		FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/home.fxml"));
		Scene home = new Scene(homeFxmlLoader.load(), 360, 750);
		stage.setTitle("홈 화면");
		stage.setScene(home);

    	HomeController homeController = new HomeController();
        stage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
}