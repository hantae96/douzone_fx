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

	public List<HomeDto> getItemAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HomeDto> allItem = new ArrayList<>();

		// 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
		String sql = "select goods_id,title,address,price,recommends,created_at from goods order by goods_id desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				HomeDto item = new HomeDto();
				item.setItemId(rs.getString("goods_id"));
				item.setItemName(rs.getString("title"));
				item.setAddress(rs.getString("address"));
				item.setPrice(String.valueOf(rs.getInt("price")));
				item.setDate(String.valueOf(rs.getDate("created_at")));
				item.setRecommend(rs.getInt("recommends"));

				allItem.add(item);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allItem;
	}
	
	public void addView(String itemId){
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "update goods set views = NVL(views,0)+1 where goods_id = ?";
		try {
			System.out.println(itemId);
			ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			
			int count = ps.executeUpdate();
			System.out.println(count + " 행 업데이트");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
