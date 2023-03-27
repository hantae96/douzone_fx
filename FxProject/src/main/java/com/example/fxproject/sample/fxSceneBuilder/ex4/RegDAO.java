package com.example.fxproject.sample.fxSceneBuilder.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegDAO {
	private Connection con;

	public RegDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void regProc(RegDTO reg) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "INSERT INTO javafx VALUES(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reg.getId());
			ps.setString(2, reg.getPw());
			ps.setString(3, reg.getName());
			ps.setString(4, reg.getGender());
			ps.setString(5, reg.getHobbys());
			ps.setString(6, reg.getAgeGroup());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
