package com.fx.market.service;

import java.util.List;

import com.fx.market.dao.HomeDao;
import com.fx.market.dao.SearchDao;
import com.fx.market.dto.HomeDto;

public class SearchService {

	public List<HomeDto> searchKeyword(String keyword) {
		SearchDao dao = new SearchDao();
		List<HomeDto> items = dao.search(keyword);
		return items;
	}
}
