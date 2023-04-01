package com.fx.market.service;

import java.util.List;

import com.fx.market.dao.MySellListDao;
import com.fx.market.dto.MySellListDto;

public class MySellListService {

	private MySellListDao dao = new MySellListDao();
	
	//프로필 사진
	public String getMyPhoto(String id) {
		return dao.getMyPhoto(id);
	}
	
	//게시글 출력
	public List<MySellListDto> getMySellList(String id) {
		return dao.getMySellList(id);
	}
	
}
