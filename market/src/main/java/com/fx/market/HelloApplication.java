package com.fx.market;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene main = new Scene(fxmlLoader1.load(), 320, 240);
        stage.setTitle("main");
        stage.setScene(main);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}