package com.fx.market.service;

import com.fx.market.dao.MyPageDao;
import com.fx.market.dto.MyPageDto;


public class MyPageService {

	private MyPageDao dao = new MyPageDao();
	
	//마이페이지 정보 불러오기
	public MyPageDto getMyInfo(String id) {
		return dao.getMyInfo(id);
	}
	
	//탈퇴할 계정의 사진 파일 경로 불러오기
	public String getMyPhoto(String id) {
		return dao.getMyPhoto(id);
	}
	
	//회원 탈퇴
	public void deleteAccount(String id) {
		dao.deleteAccount(id);
	}
	

}
