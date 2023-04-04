package com.fx.market.common;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class CommonService {
	
	public static void msg(AlertType alertType, String title, String headerText, String contentText) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle(title);
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);
	    alert.show();
	    
	}
	
	public static Optional<ButtonType> msgShowAndWait(AlertType alertType, String title, String headerText, String contentText) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle(title);
	    alert.setHeaderText(headerText);
	    alert.setContentText(contentText);
	    
	    
	    return alert.showAndWait();
	}
	
}
