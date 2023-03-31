package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fx.market.dto.FreeBoardDto;


public class FreeBoardDao{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public FreeBoardDao() {
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
	public int insertFreeBoard(FreeBoardDto townDto) {
//		TownDto town = new TownDto();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO boards(boards_id, accounts_id, main_category, middle_category, title, content) values (concat('b', boards_seq.nextval),? , ?, ?, ?, ?)";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, townDto.getAcount_Id());
			ps.setString(2, townDto.getMain_category());
			ps.setString(3,townDto.getMiddle_category());
			ps.setString(4, townDto.getTitle());
			ps.setString(5, townDto.getContent());
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public FreeBoardDto selectBoard(String boardsId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM boards WHERE boards_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardsId);
			rs = ps.executeQuery();
			if(rs.next()) {
				FreeBoardDto freeboard = new FreeBoardDto();
				freeboard.setBoard_Id(rs.getString("boards_id"));
				freeboard.setMiddle_category(rs.getString("middle_category"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setContent(rs.getString("content"));
				ps.executeUpdate();
				
				return freeboard;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
	public int updateFreeBoard(FreeBoardDto townDto) {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE boards SET middle_category=?, title=?, content=? WHERE boards_id=?";
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(4, townDto.getBoard_Id());
			ps.setString(1, townDto.getMiddle_category());
			ps.setString(2, townDto.getTitle());
			ps.setString(3, townDto.getContent());
			
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
//	public int updateBoard() {
//		
//	}
	
}
