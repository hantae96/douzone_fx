package com.fx.market.service;

import com.fx.market.dao.ItemDao;
import com.fx.market.dao.SignUpDao;
import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.SignUpDto;

public class SignUpService {

	private SignUpDao dao = new SignUpDao();
	private ItemDao idao = new ItemDao();
	
	// 아이디 중복확인 버튼
	public String idCheck(String accounts_id) {
		String checkedId = dao.idCheck(accounts_id);
		if(checkedId==null || checkedId=="") {
			return "아이디를 생성하실 수 있습니다.";			
		}else {
			return "중복된 아이디입니다.";
		}
	}
	
	// 회원가입 accounts Insert
	public void accountsInsert(SignUpDto dto) {
		dao.accountsInsert(dto);
	}
	
	// 회원가입 photos Insert
	public void photosInsert(PhotoDto dto) {
		dao.photosInsert(dto);
	}
	
	//구매시 평점
	public void accountRating(String goods_id, int grade) {
		//판매자 아이디
		String seller_id = idao.goodsSeller(goods_id);
		System.out.println("seller_id : "+seller_id);
		//판매자 온도
		float seller_temp = dao.selectTemp(seller_id);
		System.out.println("seller_temp : "+seller_temp);
		//평점에 따른 변화
		float addition = (float)(grade-3)/2;
		System.out.println("addition : "+addition);
		seller_temp += addition;
		System.out.println("seller_temp : "+seller_temp);
		//온도 업데이트
		dao.updateTemp(seller_id, seller_temp);
	}
	
}
