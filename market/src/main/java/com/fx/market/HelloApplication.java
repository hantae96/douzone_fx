package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.fx.market.common.Viewer;
import com.fx.market.controller.HomeController;
import com.fx.market.controller.MainController;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    	
		FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/home.fxml"));
		Scene home = new Scene(homeFxmlLoader.load(), 370, 650);
		stage.setTitle("홈 화면");
		stage.setScene(home);
        
        Viewer viewer = new Viewer();
        viewer.setPrimaryStage(stage);
        
        MainController mainController = fxmlLoader.getController();
        mainController.setViewer(viewer);
        
        stage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
}