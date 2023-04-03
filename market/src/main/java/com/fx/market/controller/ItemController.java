package com.fx.market.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Util;
import com.fx.market.common.Viewer;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.ItemUserDto;
import com.fx.market.service.ItemService;
import com.fx.market.service.SignUpService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.StringConverter;

public class ItemController implements Initializable {

	@FXML
	ImageView photo;
	@FXML
	Circle profilePhoto;
	@FXML
	Label username;
	@FXML
	Label address;
	@FXML
	Label temperature;
	@FXML
	Label itemName;
	@FXML
	Label date;
	@FXML
	Label context;
	@FXML
	Label viewAndLike;
	@FXML
	Button close;
	@FXML
	Label title;
	@FXML
	Label recommandButton;
	@FXML
	Label price;
	@FXML
	Button submitButton;

	ItemDto item;
	ItemService itemService;
	ItemUserDto user;
	Session session;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.session = Session.getInstance();
		this.item = (ItemDto) session.getModel();
		this.itemService = new ItemService();
		this.user = itemService.getUserById(item.getItemId());
		checkLikeButton();
		setItemData();
		setUserData();
	}

	private void setItemData() {
		// DTO에들어있는 데이터를 라벨에 넣는다.
		itemName.setText(item.getItemName());
		context.setText(item.getItemContext());
		date.setText(item.getDate());
		price.setText(Util.priceAddComma(item.getItemPrice()).concat(" 원"));
		viewAndLike.setText("조회수 "
				.concat(String.valueOf(item.getView()).concat(" · 추천수 ").concat(String.valueOf(item.getRecommend()))));
		//사진
		
		String photoPath = itemService.getPhotoPath(item.getItemId());		
		String imagePath = "file:" + System.getProperty("user.dir") +"/".concat(photoPath);
		Image image = new Image(imagePath);
		photo.setImage(image);
	}

	private void setUserData() {
		username.setText(user.getUserName());
		address.setText(user.getAddress());
		temperature.setText(user.getTemperature().concat(" ℃"));
	}

	public void onCancelButtonClick() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}

	public void checkLikeButton() {
		String accountId = session.getAccountId();
		if (itemService.checkLike(accountId, item.getItemId())) {
			recommandButton.setText("♥");
		} else {
			recommandButton.setText("♡");
		}
	}

	public void LikeButtonClicked() {
		String accountId = session.getAccountId();
		// 해당 물품에 좋아요 버튼을 누르지 않앗으면 favorites 에 좋아요 정보를 업데이트하고 채운하트로 바꾼다.
		// 해당 물품에 좋아요 버튼을 누른 데이터가 있으면 채운하트로 출력한다. -> 다시 버튼을 누르면 하트를 빈하트로 바꾸고 좋아요 테이블에서
		// 데이터를 지운다.
		if (itemService.clickLike(accountId, item.getItemId())) {
			recommandButton.setText("♡");
		} else {
			recommandButton.setText("♥");
		}
	}
	
	public void submitButtonClicked() {
		String accountId = session.getAccountId();
		String itemId = item.getItemId();
		
		/*=============혜성 별점 추가==============*/
		// Slider를 생성하고 초기값 설정
		Slider slider = new Slider(1, 5, 1); // 최소값: 1, 최대값: 5, 초기값: 1
		slider.setMajorTickUnit(1); // 눈금 간격: 1
		slider.setMinorTickCount(0); // 부분 눈금 수: 0
		slider.setSnapToTicks(true); // 스냅(끌어맞춤) 적용: true
		slider.setShowTickLabels(true); // 눈금 라벨 표시: true
		slider.setShowTickMarks(true); // 눈금 마크 표시: true
		slider.setValue(3);

		//눈금 숫자를 별갯수로 편집
		slider.setLabelFormatter(new StringConverter<Double>() {
		    @Override
		    public String toString(Double value) {
		    	String stars ="";
		        for(int i=0; i<(int)Math.round(value); i++) {
		        	stars+="★";
		        }
		        return stars;
		    }

		    @Override
		    public Double fromString(String string) {
		        return null;
		    }
		});

		// Dialog를 생성하고 Slider를 추가
		Dialog<Double> dialog = new Dialog<>();
		dialog.setTitle("별점을 입력하세요.");
		dialog.setHeaderText(null);
		dialog.getDialogPane().setContent(slider);
		dialog.getDialogPane().setMinWidth(300);
		dialog.getDialogPane().setPadding(new Insets(0, 15, 0, 0));
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// OK 버튼을 클릭했을 때 Slider의 값을 반환
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == ButtonType.OK) {
		        return slider.getValue();
		    }
		    return null;
		});

		Optional<Double> result = dialog.showAndWait();
		if (result.isPresent()) {
		    double rating = result.get();
		    int grade = (int)Math.round(rating);
		    
		    SignUpService upService = new SignUpService();
		    upService.accountRating(itemId, grade);
		    
		    itemService.buy(accountId,itemId,grade);
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setContentText("구매가 완료 되었습니다.");
		    alert.showAndWait();
		    Viewer viewer = new Viewer();
		    viewer.setView("home");	
		
		} else {
		    
		}

		/*=========================================*/
		
	}
	
	
}
