package com.fx.market.service;

import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;

public class RegisterService {
    RegisterDao registerDao;

    public RegisterService(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public void saveItemData(ItemDto itemDto) {
        registerDao.saveItem(itemDto);
    }
}
