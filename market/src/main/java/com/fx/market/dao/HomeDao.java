package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.HomeDto;
import com.fx.market.dto.ItemDto;

public class HomeDao {
	private Connection con;
	
	public HomeDao() {
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
			ps.setString(7,saled_id);
			ps.executeUpdate();
			System.out.println("DB 저장 완료");
			
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<HomeDto> getItemAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HomeDto> allItem = new ArrayList<>();
		
		// 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
		String sql = "select title,address,price,recommends,created_at from goods";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				HomeDto item = new HomeDto();
				item.setItemName(rs.getString("title"));
				item.setAddress(rs.getString("address"));
				item.setPrice(String.valueOf(rs.getInt("price")));
				item.setDate(String.valueOf(rs.getDate("created_at")));
				item.setRecommend(rs.getInt("recommends"));
				
				allItem.add(item);
			}
			con.close();
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return allItem;
		
	}
}
