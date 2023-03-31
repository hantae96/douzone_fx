package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.MyPageDto;

public class MyPageDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//생성자
	public MyPageDao() {
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
	
	//내 정보 불러오기
	public MyPageDto getMyInfo(String id) {
		String sql = "select name, temperature, TO_CHAR(created_at, 'YYYYMMDD') from accounts where accounts_id=?";
		MyPageDto dto = new MyPageDto();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(id);
				dto.setName(rs.getString("name"));
				dto.setTemp(Float.toString(rs.getFloat("temperature")));
				dto.setCreated_at(rs.getString(3));
			}
			sql = "select count(*) as rating_num from comments where accounts_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);;
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setRating_num(rs.getInt("rating_num"));
			}
			sql = "select count(*) as favor_num from favorites where accounts_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);;
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setFavor_num(rs.getInt("favor_num"));
			}
			sql = "select count(*) as sell_num from goods where accounts_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);;
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setSell_num(rs.getInt("sell_num"));
			}
			sql = "select count(*) as buy_num from goods where saled_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);;
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setBuy_num(rs.getInt("buy_num"));
			}
			sql = "select count(*) as document_num from boards where accounts_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);;
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setDocument_num(rs.getInt("document_num"));
			}
			sql = "select path from photos where photos_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setPhoto(rs.getString("path"));
				return dto;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//삭제할 계정의 사진 경로 불러오기
	public String getMyPhoto(String id) {
		String sql = "select path from photos where photos_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("path");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Accounts, Photos delete;
	public void deleteAccount(String id) {
		String sql = "update accounts set deleted_at=SYSDATE where accounts_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
