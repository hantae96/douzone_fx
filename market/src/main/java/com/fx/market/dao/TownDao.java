package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.town.TownDto;

public class TownDao{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TownDao() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "douzone";
		String userPw = "1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,userId,userPw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertFreeBoard(TownDto townDto) {
//		TownDto town = new TownDto();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO boards VALUES(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,townDto.getMiddle_category());
			ps.setString(2, townDto.getTitle());
			ps.setString(3, townDto.getContent());
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
