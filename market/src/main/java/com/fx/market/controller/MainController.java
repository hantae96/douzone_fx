package com.fx.market.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button hantae;
    @FXML private Label testTitle;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    
    @FXML
    protected void hantaeClick() {
    	testTitle.setText("method 테스트");
    	System.out.println("test");

    	System.out.println("test!!");
    }

    
    @FXML
    protected void test() {
       System.out.println("create branch!!");
    }

}