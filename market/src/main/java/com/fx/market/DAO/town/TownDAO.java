package com.fx.market.dao.town;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TownDao implements ITownDao{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TownDao() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "douzone";
		String userPw = "1234";
		
		try {
			Class.forName("orcale.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,userId,userPw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
