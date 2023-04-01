package com.fx.market.common;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonService {
	
	public static void msg(AlertType alertType, String headerText, String contentText) {
	    Alert alert = new Alert(alertType);
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);
	    alert.show();
	}
	
}
