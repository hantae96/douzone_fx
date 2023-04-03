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
	
	public Boolean checkLike(String accountId, String itemId) {
		FavoritesDao dao = new FavoritesDao();
		if(dao.checkFavorites(accountId,itemId)) {
			// 참이면 이미 좋아요를 누른것
			return true;
		}else{
			addLike(accountId, itemId);
			return false;
		}
		
	}

	public Boolean clickLike(String accountId, String itemId) {
		FavoritesDao dao = new FavoritesDao();
		if(dao.checkFavorites(accountId,itemId)) {
			// 참이면 이미 좋아요를 누른것 -> 데이터삭제 쿼리를 다시 진행
			deleteLike(accountId,itemId);
			return true;
		}else{
			addLike(accountId, itemId);
			return false;
		}
		
	}
	public void deleteLike(String accountId,String itemId) {
		FavoritesDao dao = new FavoritesDao();
		dao.deleteFavorites(accountId,itemId);
	}

	public void buy(String accountId, String itemId, int grade) {
		ItemDao dao = new ItemDao();
		dao.updateSaled(accountId,itemId,grade);
	}
	
	public String getPhotoPath(String itemId) {
		ItemDao dao = new ItemDao();
		return dao.getPhoto(itemId);
	}
}
