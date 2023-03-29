package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//
//        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("views/main.fxml"));
//        Scene main = new Scene(fxmlLoader1.load(), 320, 240);
//        stage.setTitle("main");
//        stage.setScene(main);

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("views/Main_Bulletin.fxml"));
        Parent regForm = fxmlLoader2.load();
        
        ComboBox<String> jujeBox = (ComboBox<String>)regForm.lookup("#jujeCombo");
        jujeBox.getItems().addAll("동네질문","동네사건사고","동네맛집","동네소식","생활정보","취미생활");
       
        Scene scene2 = new Scene(regForm);
        stage.setTitle("main");

        FXMLLoader PurchasefxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/purchaseView.fxml"));
        Scene purchase = new Scene(PurchasefxmlLoader.load(), 370, 650);
        stage.setTitle("구매");
        stage.setScene(purchase);
        
        System.out.println("git commit test");
//        FXMLLoader fxmlLoaderH = new FXMLLoader(HelloApplication.class.getResource("views/signUp.fxml"));
//        Scene hyesong = new Scene(fxmlLoaderH.load(), 360, 700);
//        stage.setTitle("hyesong");
//        stage.setScene(hyesong);

        stage.show();
        stage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
}