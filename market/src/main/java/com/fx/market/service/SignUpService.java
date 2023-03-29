package com.fx.market.service;

import com.fx.market.DAO.SignUpDao;

public class SignUpService {

	private SignUpDao dao = new SignUpDao();
	
	public int idCheck(String accounts_id) {
		String checkedId = dao.idCheck(accounts_id);
		if(checkedId==null || checkedId=="") {
			return 0;			
		}else {
			return 1;
		}
		
	}
	
}
