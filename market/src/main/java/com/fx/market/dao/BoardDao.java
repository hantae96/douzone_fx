package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fx.market.dto.BoardDto;

public class BoardDao {
	private Connection con;
	
	public BoardDao() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);a
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMeetingBoard(BoardDto boardDto) {
		String sql = "insert into boards(boards_id, accounts_id, main_category, middle_category, title, content) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "b0001");
			ps.setString(2, "a0001");
			ps.setString(3, boardDto.getMainCategory());
			ps.setString(4, boardDto.getMiddleCategory());
			ps.setString(5, boardDto.getTitle());
			ps.setString(6, boardDto.getContent());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
