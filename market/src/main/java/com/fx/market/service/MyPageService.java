package com.fx.market.service;

import com.fx.market.dao.MyPageDao;
import com.fx.market.dto.MyPageDto;


public class MyPageService {

	private MyPageDao dao = new MyPageDao();
	
	//마이페이지 정보 불러오기
	public MyPageDto getMyInfo(String id) {
		return dao.getMyInfo(id);
	}
	

}
