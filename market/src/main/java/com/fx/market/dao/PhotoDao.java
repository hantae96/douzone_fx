package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fx.market.dto.BoardDto;
import com.fx.market.dto.PhotoDto;

public class PhotoDao {

	private Connection con;
	
	public PhotoDao() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PhotoDto findByPhoto(String boardId) {
		System.out.println(boardId);
		String sql = "SELECT * "
				+ "FROM photos "
				+ "where photos_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardId);
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				PhotoDto photo = new PhotoDto();
				photo.setPhotos_id(rs.getString("photos_id"));
				photo.setName(rs.getString("name"));
				photo.setPath(rs.getString("path"));
				
				return photo;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
