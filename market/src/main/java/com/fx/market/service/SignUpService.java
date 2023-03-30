package com.fx.market.service;
import com.fx.market.dao.SignUpDao;

public class SignUpService {

	private SignUpDao dao = new SignUpDao();
	
	// 아이디 중복확인 버튼
	public int idCheck(String accounts_id) {
		String checkedId = dao.idCheck(accounts_id);
		if(checkedId==null || checkedId=="") {
			return 0;			
		}else {
			return 1;
		}
	}
	
	// 회원가입 버튼
	public void signInsert(SignUpDto dto) {
		dao.signInsert(dto);
	}
	
	
}
