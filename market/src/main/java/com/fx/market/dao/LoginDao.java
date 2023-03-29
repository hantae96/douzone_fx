package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public String idCheck(String id) {
		String sql = "select pw from accounts where accounts_id=?";
		String pw = null;
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					pw = rs.getString("pw");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return pw;
		}
}
