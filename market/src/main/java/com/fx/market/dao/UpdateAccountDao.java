package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.LoginDto;  //이거 dto바꿀까?> 일단 가져다 쓸까
import com.fx.market.dto.MyPageDto;
import com.fx.market.dto.UpdateDto;

	public class UpdateAccountDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
		
	public UpdateAccountDao() {
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
						System.out.println(updatedto.getPw());
						System.out.println(updatedto.getName());
						System.out.println(updatedto.getAddress());
						System.out.println(updatedto.getEmail());
						return updatedto;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return updatedto;
			}
		}


