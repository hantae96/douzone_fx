package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.LoginDto;  //이거 dto바꿀까?> 일단 가져다 쓸까
import com.fx.market.dto.MyPageDto;
import com.fx.market.dto.PhotoDto;
import com.fx.market.dto.UpdateDto;

	public class UpdateAccountDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
		
	public UpdateAccountDao() {  //생성자
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
		//정보변경
		public int buttonUpdateMethod(LoginDto user) {
			String sql = "UPDATE accounts SET pw =?, name=?, address=?, email=? where accounts_id=?";
			int result =0;
			try {
					ps = con.prepareStatement(sql);
					ps.setString(1, user.getPw());
					ps.setString(2, user.getName());
					ps.setString(3, user.getAddress());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getAccounts_id());
					result = ps.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
		}
		
		//정보변경 시, 정보 불러오기
		public UpdateDto accountInfo(String id) {
			UpdateDto updatedto = new UpdateDto();
			String sql = "select pw, name, address, email from accounts where accounts_id = ?";
			try {
					ps = con.prepareStatement(sql);
					ps.setString(1, id);
					rs = ps.executeQuery();
					if(rs.next()) {
						updatedto = new UpdateDto();
						updatedto.setPw(rs.getString("pw"));
						updatedto.setName(rs.getString("name"));
						updatedto.setAddress(rs.getString("address"));
						updatedto.setEmail(rs.getString("email"));
						return updatedto;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return updatedto;
			}
		//정보 변경 시, 사진 불러오기
		public String photoInfo(String id) {
			String sql = "select path from photos where photos_id=?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString("path");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
//		public void photosUpdate(PhotoDto dto) {
//			String sql = "UPDATE photos SET name=?, path=? where photos_id=?";
//
//			try {
//					ps = con.prepareStatement(sql);
//					ps.setString(1, dto.getName());
//					ps.setString(2, dto.getPath());
//					ps.setString(3, dto.getPhotos_id());
//					ps.executeUpdate();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			
//		}
	}