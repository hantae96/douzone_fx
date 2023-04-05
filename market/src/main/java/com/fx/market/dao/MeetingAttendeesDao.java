package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.MeetingAttendeesDto;

public class MeetingAttendeesDao {
	
	private Connection con;
	
	public MeetingAttendeesDao() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertAttendMeeting(MeetingAttendeesDto meetingAttendDto) {
		String sql = "insert into meeting_attendees values(?, ?)";
		
		PreparedStatement ps = null;
		
		int result = 0;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, meetingAttendDto.getBoardId());
			ps.setString(2, meetingAttendDto.getAccountId());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public List<MeetingAttendeesDto> selectMeetingAttendList(String boardId) {
		String sql = "SELECT ma.accounts_id, a.name, a.address, p.path "
				+ "FROM meeting_attendees ma "
				+ "JOIN accounts a ON ma.accounts_id = a.accounts_id "
				+ "LEFT JOIN photos p ON a.accounts_id = p.photos_id "
				+ "WHERE ma.boards_id = ?";
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, boardId);
					
					rs = ps.executeQuery();
					
					List<MeetingAttendeesDto> meetingAttendDtos = new ArrayList<MeetingAttendeesDto>();
					
					while(rs.next()) {
						MeetingAttendeesDto meetingAttendDto = new MeetingAttendeesDto(); 
						meetingAttendDto.setAccountId(rs.getString("accounts_id"));
						meetingAttendDto.setName(rs.getString("name"));
						meetingAttendDto.setAddress(rs.getString("address"));
						meetingAttendDto.setPath(rs.getString("path"));
						
						meetingAttendDtos.add(meetingAttendDto);
					}
					
					return meetingAttendDtos;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return null;
			}
}
