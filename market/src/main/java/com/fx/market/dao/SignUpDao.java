package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.SignUpDto;

public class SignUpDao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//생성자
	public SignUpDao() {
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
	//아이디 중복확인
	public String idCheck(String id) {
		String sql = "select accounts_id from accounts where accounts_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("accounts_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//회원가입 Accounts Insert 실시
	public void accountsInsert(SignUpDto dto) {
		String sql = "insert into accounts values(?, ?, ?, ?, ?, '36.5', SYSDATE, null)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAccounts_id());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원가입 Photos Insert 실시
	public void photosInsert(PhotoDto dto) {
		String sql = "insert into photos values(?, ?, ?, SYSDATE)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPhotos_id());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPath());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
