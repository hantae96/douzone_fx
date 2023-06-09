package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.HomeDto;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.ItemUserDto;

public class ItemDao {
	private Connection con;

	public ItemDao() {
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

	public ItemDto getItemById(String goodsId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemDto item = new ItemDto();

		// 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
		String sql = "select title,content,created_at,views,recommends,price,address from goods where goods_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsId);
			rs = ps.executeQuery();

			while (rs.next()) {
				item.setItemName(rs.getString("title"));
				item.setItemContext(rs.getString("content"));
				item.setDate(String.valueOf(rs.getDate("created_at")));
				item.setView(rs.getInt("views"));
				item.setRecommend(rs.getInt("recommends"));
				item.setItemPrice(String.valueOf(rs.getInt("price")));
				item.setItemLocal(rs.getString("address"));
				item.setItemId(goodsId);
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public ItemUserDto getUserById(String goodsId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemUserDto user = new ItemUserDto();

		// 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
		String sql = "SELECT a.name, a.temperature, a.address " + "FROM accounts a "
				+ "INNER JOIN goods g ON a.accounts_id = g.accounts_id " + "WHERE g.goods_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, goodsId);
			rs = ps.executeQuery();

			while (rs.next()) {
				// 나중에 포토 테이블이랑 연결하면 추가
				user.setUserName(rs.getString("name"));
				user.setTemperature(String.valueOf(rs.getDouble("temperature")));
				user.setAddress(rs.getString("address"));
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	
	public void updateSaled(String accountId, String itemId, int grade) {
		PreparedStatement ps = null;

	    // 필요한 정보 : 상품 제목, 위치, 가격, 올린시간, 좋아요
	    String sql = "update goods set saled_id = ?, sale = ?, grade= ? where goods_id = ?";
	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, accountId);
	        ps.setString(2, "TRUE");
	        ps.setInt(3, grade);
	        ps.setString(4, itemId);
	        ps.executeQuery();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public String getPhoto(String itemId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String photoPath = null;

		String sql = "select path from photos where photos_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, itemId);
			rs = ps.executeQuery();

			while (rs.next()) {
				photoPath = rs.getString("path");
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return photoPath;
	}
	
		/*goods 작성자 select (혜성 추가)*/
	public String goodsSeller(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select accounts_id from goods where goods_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("accounts_id");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
