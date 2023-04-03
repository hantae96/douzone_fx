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

	public int insertMeetingBoard(BoardDto boardDto) {
		String insertBoardSql = "insert into boards(boards_id, accounts_id, main_category, sub_category, title, content, address) "
				+ "values (concat('b', boards_seq.nextval), ?, ?, ?, ?, ?, ?)";

	    String insertMeetingSql = "INSERT INTO meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age) "
	    		+ "VALUES (concat('b', boards_seq.currval), ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    PreparedStatement boardPs = null;
	    PreparedStatement meetingPs = null;
	    int result = 0;
		
		try {
			con.setAutoCommit(false);
			
			boardPs = con.prepareStatement(insertBoardSql);
			
			boardPs.setString(1, boardDto.getAccountId());
			boardPs.setString(2, boardDto.getMainCategory());
			boardPs.setString(3, boardDto.getSubCategory());
			boardPs.setString(4, boardDto.getTitle());
			boardPs.setString(5, boardDto.getContent());
			boardPs.setString(6,  boardDto.getAddress());
			result = boardPs.executeUpdate();
			
	        meetingPs = con.prepareStatement(insertMeetingSql);
	        meetingPs.setString(1, boardDto.getPerson());
	        meetingPs.setDate(2, boardDto.getMeetingDate());
	        meetingPs.setString(3, boardDto.getMeetingTimeAmpm());
	        meetingPs.setString(4, boardDto.getMeetingTimeHour());
	        meetingPs.setString(5, boardDto.getMeetingTimeMinute());
	        meetingPs.setString(6, boardDto.getPlace());
	        meetingPs.setString(7, boardDto.getGender());
	        meetingPs.setString(8, boardDto.getAge());
	        
	        meetingPs.executeUpdate();

	        con.commit(); // 트랜잭션 성공
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}

	public List<BoardDto> findByMeetingBoardList() {
		String sql = "SELECT DISTINCT b.*, m.* "
				+ "FROM boards b "
				+ "LEFT JOIN meetings m "
				+ "ON b.boards_id = m.boards_id order by b.created_at desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<BoardDto> boards = new ArrayList<>();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setBoardId(rs.getString("boards_id"));
				board.setAccountId(rs.getString("accounts_id"));
				board.setMainCategory(rs.getString("main_category"));
				board.setSubCategory(rs.getString("sub_category"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setGender(rs.getString("gender"));
				board.setAge(rs.getString("age"));
				board.setMeetingDate(rs.getDate("meeting_date"));
				board.setMeetingTimeAmpm(rs.getString("meeting_time_ampm"));
				board.setMeetingTimeHour(rs.getString("meeting_time_hour"));
				board.setMeetingTimeMinute(rs.getString("meeting_time_minute"));
				System.out.println(board.getBoardId());
				boards.add(board);
			}
			
			return boards;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public BoardDto findByMeetingBoardDetail(String boardId) {
		String sql = "SELECT b.*, m.* "
				+ "FROM boards b "
				+ "INNER JOIN meetings m ON b.boards_id = m.boards_id where b.boards_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardId);
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				BoardDto board = new BoardDto();
				board.setBoardId(rs.getString("boards_id"));
				board.setAccountId(rs.getString("accounts_id"));
				board.setMainCategory(rs.getString("main_category"));
				board.setSubCategory(rs.getString("sub_category"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setAddress(rs.getString("address"));
				board.setRecommends(rs.getInt("recommends"));
				board.setViews(rs.getInt("views"));
				board.setCreatedAt(rs.getDate("created_at"));
				board.setState(rs.getString("state"));
				board.setPerson(rs.getString("person"));
				board.setMeetingDate(rs.getDate("meeting_date"));
				board.setMeetingTimeAmpm(rs.getString("meeting_time_ampm"));
				board.setMeetingTimeHour(rs.getString("meeting_time_hour"));
				board.setMeetingTimeMinute(rs.getString("meeting_time_minute"));
				board.setPlace(rs.getString("place"));
				board.setGender(rs.getString("gender"));
				board.setAge(rs.getString("age"));
		
				return board;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public int deleteBoard(String boardId, String accountId) {
		
		String sql = "delete from boards where boards_id = ? and accounts_id = ?";

	    PreparedStatement ps = null;
	    int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, boardId);
			ps.setString(2, accountId);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}


	public int updateMeetingBoard(BoardDto boardDto) {
		
		System.out.println(boardDto.getBoardId() +"/" +boardDto.getAccountId());
		String updateBoardSql = "update boards "
				+ "set sub_category = ?, title = ?, content = ?, address = ? "
				+ "where boards_id = ? and accounts_id = ?";

	    String updateMeetingSql = "update meetings "
	    		+ "set person = ?, meeting_date = ?, meeting_time_ampm = ?, meeting_time_hour = ?, "
	    		+ "meeting_time_minute = ?, place = ?, gender = ?, age = ?"
	    		+ "where boards_id = ?";
	    
	    PreparedStatement boardPs = null;
	    PreparedStatement meetingPs = null;
	    int result = 0;
		
		try {
//			con.setAutoCommit(false);
			
			boardPs = con.prepareStatement(updateBoardSql);
			boardPs.setString(1, boardDto.getSubCategory());
			boardPs.setString(2, boardDto.getTitle());
			boardPs.setString(3, boardDto.getContent());
			boardPs.setString(4, boardDto.getAddress());
			boardPs.setString(5, boardDto.getBoardId());
			boardPs.setString(6, boardDto.getAccountId());
	
			result = boardPs.executeUpdate();
			System.out.println(result);
			
	        meetingPs = con.prepareStatement(updateMeetingSql);
	        meetingPs.setString(1, boardDto.getPerson());
	        meetingPs.setDate(2, boardDto.getMeetingDate());
	        meetingPs.setString(3, boardDto.getMeetingTimeAmpm());
	        meetingPs.setString(4, boardDto.getMeetingTimeHour());
	        meetingPs.setString(5, boardDto.getMeetingTimeMinute());
	        meetingPs.setString(6, boardDto.getPlace());
	        meetingPs.setString(7, boardDto.getGender());
	        meetingPs.setString(8, boardDto.getAge());
	        meetingPs.setString(9, boardDto.getBoardId());
	        
	        meetingPs.executeUpdate();

	        con.commit(); // 트랜잭션 성공
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
}
