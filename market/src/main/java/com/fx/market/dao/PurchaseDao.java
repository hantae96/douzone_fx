package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fx.market.dto.ItemDto;

public class PurchaseDao {
	private Connection con;
	
	public PurchaseDao() {
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
	
	
	public void saveItem(ItemDto item) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//아직 회원가입 기능 미구현 account_id , saled_id는 여기서 입력
		String account_id = "a2";
		String saled_id = "a2";
		
		
		String sql = "insert into goods(goods_id,accounts_id,title,content,address,price,saled_id) values (?,?,?,?,?,?,?)";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1,item.getItemId());
			ps.setString(2,account_id);
			ps.setString(3,item.getItemName());
			ps.setString(4,item.getItemContext());
			ps.setString(5,item.getItemLocal());
			ps.setString(6,String.valueOf(item.getItemPrice()));
			ps.setString(6,saled_id);
			ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getItemAll() {
		
	}
}
