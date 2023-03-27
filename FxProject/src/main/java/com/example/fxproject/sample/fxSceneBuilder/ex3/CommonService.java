package com.example.fxproject.sample.fxSceneBuilder.ex3;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonService {

	public static void msg(String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");
		alert.setContentText(contentText);
		alert.show();
	}
}
