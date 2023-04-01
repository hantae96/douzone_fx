package com.fx.market.service;

import java.util.Date;

import com.fx.market.dao.FavoritesDao;
import com.fx.market.dao.ItemDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.ItemUserDto;

public class ItemService {

	public ItemDto getItemById(String itemId) {
		ItemDao dao = new ItemDao();
		return dao.getItemById(itemId);
	}
	
	public ItemUserDto getUserById(String itemId) {
		ItemDao dao = new ItemDao();
		ItemUserDto dto =dao.getUserById(itemId);
		return dto;
	}

	public void addLike(String accountsId,String goodsId) {
		FavoritesDao dao = new FavoritesDao();
		dao.addFavorites(accountsId,goodsId);
	}
}
