package com.fx.market.service;

import com.fx.market.dao.SignUpDao;
import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.SignUpDto;

public class SignUpService {

	private SignUpDao dao = new SignUpDao();
	
	// 아이디 중복확인 버튼
	public String idCheck(String accounts_id) {
		String checkedId = dao.idCheck(accounts_id);
		if(checkedId==null || checkedId=="") {
			return "아이디를 생성하실 수 있습니다.";			
		}else {
			return "중복된 아이디입니다.";
		}
	}
	
	// 회원가입 accounts Insert
	public void accountsInsert(SignUpDto dto) {
		dao.accountsInsert(dto);
	}
	
	// 회원가입 photos Insert
	public void photosInsert(PhotoDto dto) {
		dao.photosInsert(dto);
	}
	
}
