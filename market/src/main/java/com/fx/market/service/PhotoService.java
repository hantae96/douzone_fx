package com.fx.market.service;

import com.fx.market.dao.PhotoDao;
import com.fx.market.dto.PhotoDto;

public class PhotoService {

	private PhotoDao photoDao;
	
	

	public PhotoService() {
		photoDao = new PhotoDao();
	}



	public PhotoDto getPhoto(String boardId) {
		PhotoDto photo = photoDao.findByPhoto(boardId);
		
		return photo;
	}
	
	
}
