package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

import javax.xml.stream.events.StartElement;

import com.fx.market.dao.PurchaseDao;
import com.fx.market.common.Viewer;
import com.fx.market.controller.HomeController;
import com.fx.market.controller.MainController;
import com.fx.market.controller.PurchaseController;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    	
// 구매 상세 페이지 테스트
//        FXMLLoader PurchasefxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/purchaseView.fxml"));
//        Scene purchase = new Scene(PurchasefxmlLoader.load(), 370, 650);
//        stage.setTitle("구매");
//        stage.setScene(purchase);
//        stage.show();
//        
// 홈 화면 테스트
    	HomeController homeController = new HomeController();
        homeController.viewHome(stage);
        stage.show();
    	
    }

    public static void main(String[] args) {
        launch();
    }
}