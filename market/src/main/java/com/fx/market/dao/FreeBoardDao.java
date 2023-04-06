package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fx.market.dto.FreeBoardDto;
import com.fx.market.dto.PhotoDto;


public class FreeBoardDao{
	private Connection con;

	
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
	public void photosUpdate(PhotoDto photoDto) {
		String sql = "UPDATE photos SET name=?, path=? where photos_id=?";
		System.out.println(photoDto.getPhotos_id());
		PreparedStatement ps = null;
		try {
				ps = con.prepareStatement(sql);
				ps.setString(1, photoDto.getName());
				ps.setString(2, photoDto.getPath());
				ps.setString(3, photoDto.getPhotos_id());
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	public void photosInsert(PhotoDto photo) {
		System.out.println(photo.getPhotos_id());
		System.out.println(photo.getName());
		System.out.println(photo.getPath());
		PreparedStatement ps = null;
		String sql = "INSERT INTO photos values(concat('b',boards_seq.currval),?,?,SYSDATE)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, photo.getName());
			ps.setString(2, photo.getPath());;
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public int insertFreeBoard(FreeBoardDto townDto) {
		
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO boards(boards_id, accounts_id, main_category, sub_category, title, content, address) values (concat('b', boards_seq.nextval),? , ?, ?, ?, ?, ?)";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, townDto.getAcount_Id());
			ps.setString(2, townDto.getMain_category());
			ps.setString(3,townDto.getSub());
			ps.setString(4, townDto.getTitle());
			ps.setString(5, townDto.getContent());
			ps.setString(6, townDto.getAddress());
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public FreeBoardDto selectAll(String board_Id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM boards WHERE boards_Id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board_Id);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("if");
				FreeBoardDto freeboard = new FreeBoardDto();
				freeboard.setBoard_Id(board_Id);
				freeboard.setSub(rs.getString("sub_category"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setContent(rs.getString("content"));
				freeboard.setAddress(rs.getString("address"));
				freeboard.setAcount_Id(rs.getString("accounts_id"));
				freeboard.setCreatedAt(String.valueOf(rs.getString("created_at")));
				ps.executeUpdate();
				
				return freeboard;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

	public void updateFreeBoard(FreeBoardDto freeboard) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "UPDATE boards set sub_category = ?, title = ?, content =? where boards_id =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, freeboard.getSub());
			ps.setString(2, freeboard.getTitle());
			ps.setString(3, freeboard.getContent());
			ps.setString(4,freeboard.getBoard_Id());
			
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
			
	}

	public void deleteClick(String board_Id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println("dao");
		String sql = "DELETE FROM boards WHERE boards_Id=?";
		try {
			System.out.println("try");
			ps = con.prepareStatement(sql);
			ps.setString(1, board_Id);
			
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}


	public String selectboard_Id(String board_Id) {
		String sql = "select path from photos where photos_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board_Id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("path");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String findBoardId(String title) {
		String sql = "select boards_id from boards where title = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("boards_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
