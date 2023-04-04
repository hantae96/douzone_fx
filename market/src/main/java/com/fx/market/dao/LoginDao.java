package com.fx.market.dao;

import java.sql.Connection;
import java.sql.Date;
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
					logindto.setAccounts_id(rs.getString("accounts_id"));
					logindto.setAddress(rs.getString("address"));
					return logindto;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return logindto;
		}
	
	public Date deleteCheck(String id, String pw) {
		String sql = "select deleted_at from accounts where accounts_id = ? and pw =?";
		Date deleted_at; 
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				rs = ps.executeQuery();
				if(rs.next()) {
					deleted_at = rs.getDate("deleted_at");
					
					return deleted_at;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public int userCheck(String id, String email) {
		String sql = "select count(*) as count from accounts where accounts_id =? and email =?";
		int userCheck = 0;
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, email);
				rs = ps.executeQuery();
				if(rs.next()) {
					
					userCheck = rs.getInt("count");
					
					return userCheck;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return userCheck;
	}
	
	public void pwCheck(String id, String email, String pw) {
		String sql = "UPDATE accounts SET pw =? where accounts_id=? and email=?";
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, pw);
				ps.setString(2, id);
				ps.setString(3, email);
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	
	
	public String e_nameCheck(String name,String email) {
		String sql = "select accounts_id from accounts where name = ? and email=? ";
		String e_nameCheck = null;
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, email);
				rs = ps.executeQuery();
				if(rs.next()) {
					e_nameCheck = rs.getString("accounts_id");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return e_nameCheck;
		}
	
}