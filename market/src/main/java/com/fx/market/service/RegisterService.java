package com.fx.market.service;

import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;

public class RegisterService {
	
	RegisterDao goodsDao = new RegisterDao();


	public void saveItemData(ItemDto itemDto) {
    	System.out.println("!!");
    	
		goodsDao.saveItem(itemDto);
	}
}
