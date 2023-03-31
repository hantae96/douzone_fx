package com.fx.market.service;

import com.fx.market.dao.ItemDao;
import com.fx.market.dto.ItemDto;

public class ItemService {

	public ItemDto getItemById(String itemId) {
		ItemDao dao = new ItemDao();
		return dao.getItemById(itemId);
	}
}
