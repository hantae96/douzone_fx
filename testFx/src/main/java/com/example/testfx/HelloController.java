package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Label money;
    public Button chat;
    public ToggleButton loveButton;
    @FXML
    private Label welcomeText;
    @FXML private VBox topBox;

    //    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("버튼 클릭!!");
    }

    MemoryRepository memoryRepository = new MemoryRepository();

    public void middleButtonClick(ActionEvent actionEvent) {
        System.out.println("출력입니다.");
        EventType actionEvent1 = actionEvent.getEventType();
        System.out.println("actionEvent1 = " + actionEvent1);
        money.setText("200000");
    }

    public void heartButtonClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Untitled.fxml"));
        try {
            Scene main = new Scene(fxmlLoader2.load(),1000,400);
            Stage stage = HelloApplication.getStage();
            stage.setScene(main);
            stage.setTitle("Main Title");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}