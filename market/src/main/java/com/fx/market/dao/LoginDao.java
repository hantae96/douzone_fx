package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.LoginDto;

public class LoginDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
		
	public LoginDao() {
		String user = "douzone";
		String password = "1234";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public LoginDto idCheck(String id,String pw) {
		LoginDto logindto=null;
		String sql = "select accounts_id, address from accounts where accounts_id = ? and pw =?";
		String address=""; String accounts_id="";
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();
				if(rs.next()) {
					logindto = new LoginDto();
					logindto.setAccounts_id(rs.getString(accounts_id));
					logindto.setAddress(rs.getString(address));
					return logindto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return logindto;
		}
}
