package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.controller.HomeController;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    	        
// 홈 화면 테스트
		FXMLLoader homeFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/login.fxml"));
		Scene home = new Scene(homeFxmlLoader.load(), 360, 750);

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("views/Main_Bulletin.fxml"));
        Parent regForm = fxmlLoader2.load();
   
        
        Scene Town = new Scene(regForm);
        stage.setTitle("Town");
        stage.setScene(Town);
//        FXMLLoader PurchasefxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/purchaseView.fxml"));
//        Scene purchase = new Scene(PurchasefxmlLoader.load(), 370, 650);
//        stage.setTitle("구매");
//        stage.setScene(purchase);
        
      
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