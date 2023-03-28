package service;

import dao.LoginDAO;

public class LoginService {
	private LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}
	
	public void loginProc(String id, String pw) {
		if(id.isEmpty() || pw.isEmpty()) {
			CommonService.msg("아이디 또는 비밀번호를 입력하세요.");
			return;
		}
		
		String dbPw = dao.loginProc(id);
		if(dbPw == null || dbPw.isEmpty()) {
			CommonService.msg("로그인 실패");
			return;
		}
		
		if(dbPw.equals(pw)) {
			dao.loginSuccess(id);
//			CommonService.msg("로그인 성공");
		}else {
			CommonService.msg("로그인 실패");
		}
	}

    public String loginCheck(String id) {
		return dao.loginCheck(id);
    }
}
