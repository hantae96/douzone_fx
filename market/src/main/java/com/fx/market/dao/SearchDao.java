package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.HomeDto;
import com.fx.market.dto.ItemDto;

public class SearchDao{
	private Connection con;

	public SearchDao() {
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

	public List<HomeDto> search(String keyword) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<HomeDto> allItem = new ArrayList<>();

		// 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
		String sql = "select goods_id,title,content,created_at,views,recommends,price,address from goods "
				+ "where TITLE LIKE ?";

		try {
			ps = con.prepareStatement(sql);
			 ps.setString(1, "%"+keyword+"%");
			rs = ps.executeQuery();
			boolean result = rs.next();
			if(result == false) {
				
			}else {
			
			while (result) {
				HomeDto item = new HomeDto();
				item.setItemId(rs.getString("goods_id"));
				item.setItemName(rs.getString("title"));
				item.setAddress(rs.getString("address"));
				item.setPrice(String.valueOf(rs.getInt("price")));
				item.setDate(String.valueOf(rs.getDate("created_at")));
				item.setRecommend(rs.getInt("recommends"));

				allItem.add(item);
				result= rs.next();
			}
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allItem;
	}
}
