package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        FXMLLoader PurchasefxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/purchaseView.fxml"));
        Scene purchase = new Scene(PurchasefxmlLoader.load(), 370, 650);
        stage.setTitle("구매");
        stage.setScene(purchase);
        
        
//        FXMLLoader fxmlLoaderH = new FXMLLoader(HelloApplication.class.getResource("views/signUp.fxml"));
//        Scene hyesong = new Scene(fxmlLoaderH.load(), 360, 700);
//        stage.setTitle("hyesong");
//        stage.setScene(hyesong);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}