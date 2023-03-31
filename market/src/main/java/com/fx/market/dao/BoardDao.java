package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.BoardDto;

public class BoardDao {
	private Connection con;
	
	public BoardDao() {
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

	public void insertMeetingBoard(BoardDto boardDto) {
		String insertBoardSql = "insert into boards(boards_id, accounts_id, main_category, middle_category, title, content) "
				+ "values (concat('b', boards_seq.nextval), ?, ?, ?, ?, ?)";

	    String insertMeetingSql = "INSERT INTO meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age) "
	    		+ "VALUES (concat('b', boards_seq.currval), ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    PreparedStatement boardPs = null;
	    PreparedStatement meetingPs = null;
	 
		
		try {
			con.setAutoCommit(false);
			
			boardPs = con.prepareStatement(insertBoardSql);
			
			boardPs.setString(1, "a0001");
			boardPs.setString(2, boardDto.getMainCategory());
			boardPs.setString(3, boardDto.getMiddleCategory());
			boardPs.setString(4, boardDto.getTitle());
			boardPs.setString(5, boardDto.getContent());
			boardPs.executeUpdate();
			
	        meetingPs = con.prepareStatement(insertMeetingSql);
	        meetingPs.setInt(1, boardDto.getPerson());
	        meetingPs.setDate(2, boardDto.getMeetingDate());
	        meetingPs.setString(3, boardDto.getMeetingTimeAmpm());
	        meetingPs.setInt(4, boardDto.getMeetingTimeHour());
	        meetingPs.setInt(5, boardDto.getMeetingTimeMinute());
	        meetingPs.setString(6, boardDto.getPlace());
	        meetingPs.setString(7, boardDto.getGender());
	        meetingPs.setString(8, boardDto.getAge());
	        
	        meetingPs.executeUpdate();

	        con.commit(); // 트랜잭션 성공
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public List<BoardDto> findByMeetingBoardList() {
		String sql = "SELECT b.boards_id, b.accounts_id, b.main_category, b.middle_category, b.title, b.content, m.meeting_date, m.meeting_time_ampm, m.meeting_time_hour, m.meeting_time_minute, m.place, m.gender, m.age "
				+ "FROM boards b "
				+ "INNER JOIN meetings m ON b.boards_id = m.boards_id";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<BoardDto> boards = new ArrayList<>();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setBoardId(rs.getString("boards_id"));
				board.setMainCategory(rs.getString("main_category"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setGender(rs.getString("gender"));
				board.setAge(rs.getString("age"));
				board.setMeetingDate(rs.getDate("meeting_date"));
				board.setMeetingTimeAmpm(rs.getString("meeting_time_ampm"));
				board.setMeetingTimeHour(rs.getInt("meeting_time_hour"));
				board.setMeetingTimeMinute(rs.getInt("meeting_time_minute"));
				System.out.println(board.getBoardId());
				boards.add(board);
			}
			
			return boards;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
