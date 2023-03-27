package com.example.fxproject.sample.fxSceneBuilder.ex4;

import com.example.fxproject.sample.fxSceneBuilder.ex3.CommonService;
import com.example.fxproject.sample.fxSceneBuilder.ex3.LoginDAO;
import ex3.CommonService;
import ex3.LoginDAO;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegService {
	public void regProc(RegDTO reg) {

		// 정보 출력
		System.out.println("아이디 : " + reg.getId());
		System.out.println("이름 : " + reg.getName());
		System.out.println("비밀번호 : " + reg.getPw());
		System.out.println("비밀번호 확인 : " + reg.getConfirm());
		System.out.println("성별 : " + reg.getGender());
		System.out.println("연령구분 : " + reg.getAgeGroup());
		System.out.println("좋아하는 것 : " + reg.getHobbys());
		
		// 아이디 중복 검증
		LoginDAO loginDao = new LoginDAO();
		String dbPw = loginDao.loginProc(reg.getId());
		if(dbPw != null) {
			CommonService.msg("아이디가 사용 중 입니다.");
			return;
		}
		
		if(reg.getPw().equals(reg.getConfirm()) == false){
			CommonService.msg("입력한 비밀번호가 다릅니다.");
			return;
		}
		
		// 회원 가입
		RegDAO regDao = new RegDAO();
		regDao.regProc(reg);
		
	}
}
