package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.fx.market.common.Viewer;
import com.fx.market.controller.MainController;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    	
    	
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/main.fxml"));
        System.out.println(HelloApplication.class.getResource("views/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        
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