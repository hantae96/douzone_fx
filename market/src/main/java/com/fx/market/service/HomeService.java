package com.fx.market.service;

import java.util.List;

import com.fx.market.dao.HomeDao;
import com.fx.market.dto.HomeDto;

public class HomeService {

	public List<HomeDto> makeViewItem() {
		HomeDao homeDao = new HomeDao();
		List<HomeDto> items = homeDao.getItemAll();
		return items;
	}
	
	public void addView(String itemId) {
		HomeDao homeDao = new HomeDao();
		homeDao.addView(itemId);
	}
}
