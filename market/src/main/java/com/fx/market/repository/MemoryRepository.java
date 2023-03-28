package com.fx.market.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fx.market.Dto.ItemDto;

public class MemoryRepository {
	
	HashMap<Integer, ItemDto> repository;
	int id;
	
	
	public MemoryRepository() {
		this.repository = new HashMap<>();
	}


	public void save(ItemDto item) {
		repository.put(id++,item);
		System.out.println("저장이 완료 되었습니다.");
	}
	
	public List<ItemDto> findAll(){
		ArrayList<ItemDto> items = new ArrayList<>();
		for (Map.Entry<Integer, ItemDto> item: repository.entrySet()){
			items.add((ItemDto) item);
		}
		return items;
	}
	
}
