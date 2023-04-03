package com.fx.market.service;

import com.fx.market.common.CommonService;
import com.fx.market.common.Session;
import com.fx.market.dao.LoginDao;
import com.fx.market.dao.UpdateAccountDao;
import com.fx.market.dto.LoginDto;
import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.UpdateDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UpdateAccountService {

	private LoginDao logindao = new LoginDao();
	private UpdateAccountDao updateaccountdao = new UpdateAccountDao();
	private CommonService cs = new CommonService();
	

	//정보 수정 비밀번호 확인 
	public int confirmAccount(String id, String pw) {
		LoginDto dbUser = logindao.idCheck(id, pw); 
		
		if(pw.isEmpty()) {
			cs.msg(AlertType.WARNING, "알림", "비밀번호를 입력하세요.");
			
			return 0;
			}else if(dbUser == null) {
				cs.msg(AlertType.ERROR, "알림", "비밀번호를 확인하세요.");
				
			}else{ 
				return 1;
			}
		return 0;
	}

	//정보 변경
	public int buttonUpdateMethod(String id, String pw, String name, String address,String email) {
		LoginDto user = new LoginDto();
//		Session session = Session.getInstance(); 
//		if(address.equals("")) {
//			address = session.getaddress();
//		}
		user.setAccounts_id(id);
		user.setPw(pw);
		user.setName(name);
		user.setAddress(address);
		user.setEmail(email);
		
		if(pw.isBlank() || name.isBlank() || address.isBlank() || email.isBlank()) { 
			cs.msg(AlertType.ERROR, "알림", "빈 칸 모두 입력해주세요");
			return 0;
		}else if(checkAddress(address) == false) {
			cs.msg(AlertType.WARNING, "알림", "주소의 형식이 올바르지 않습니다.\n(ex ~시 ~구 형식으로 입력해주세요)");
			return 0;
		}else if(checkEmail(email) == false) {
			cs.msg(AlertType.WARNING, "알림", "이메일 형식이 올바르지 않습니다.");
			return 0;
		}
		
		int change = updateaccountdao.buttonUpdateMethod(user);
		
		if(change != 0 ) {		
			cs.msg(AlertType.INFORMATION, "알림", "변경 완료");
			
		}else {
			cs.msg(AlertType.ERROR, "알림", "변경 실패");	
		}
		return change;
	}
	
	 //주소 형식 확인 메서드
    public boolean checkAddress(String a) {
		String[] b = a.split(" ");
		if(b.length==2) {
			if(b[0].contains("시")&&b[1].contains("구")) {
				return true;
			}
		}
		return false;
    }
    
    //이메일 형식 확인 메서드
    public boolean checkEmail(String a) {
    	String[] b = a.split("[@\\.]");
    	if(b.length==3) {
    		return true;
    	}
    	return false;
    }
	
	
	public UpdateDto accountInfo(String id) {
		return updateaccountdao.accountInfo(id);
	}
	
	public String photoInfo(String id) {
		return updateaccountdao.photoInfo(id);
	}
	
	// 정보변경 photos update
		public void photosUpdate(PhotoDto dto) {
			updateaccountdao.photosUpdate(dto);
		}
	
	



}