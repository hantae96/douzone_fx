package com.fx.market.service;

import java.util.List;

import com.fx.market.dao.HomeDao;
import com.fx.market.dto.HomeDto;

public class HomeService {
	public List<HomeDto> makeViewItem() {
		HomeDao dao = new HomeDao();
		List<HomeDto> items = dao.getItemAll();
		return items;
	}
}
