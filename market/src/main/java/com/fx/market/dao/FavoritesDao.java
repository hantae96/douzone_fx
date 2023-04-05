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

import javafx.css.PseudoClass;

public class FavoritesDao {
	private Connection con;

	public FavoritesDao() {
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

	public void addFavorites(String accountsId,String goodsId) {
		// favorites 테이블
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String insertSql = "insert into favorites (favorites_id,accounts_id,goods_id) values (concat('f',favorites_seq.nextval),?,?)";		
		String updateSql = "update goods set recommends = NVL(recommends,0)+1 where goods_id = ?";
		try {
			// favorties 테이블에 좋아요 정보 추가
			ps = con.prepareStatement(insertSql);
			ps.setString(1, accountsId);
			ps.setString(2, goodsId);
			ps.executeUpdate();
			// 
			ps = con.prepareStatement(updateSql);
			ps.setString(1, goodsId);
			ps.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public Boolean checkFavorites(String accountId, String itemId) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			String checkId = null;
			String sql = "select FAVORITES_ID from favorites where accounts_id = ? AND goods_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, accountId);
				ps.setString(2,itemId);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					checkId = rs.getString("FAVORITES_ID");
				}
				
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(checkId);
			if(checkId != null) return true;
			else return false;
	}

	public void deleteFavorites(String accountId, String itemId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int check = 0;
		String sql = "delete from favorites where accounts_id = ? AND goods_id = ?";
		String updateSql = "update goods set recommends = NVL(recommends,0)-1 where goods_id = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, accountId);
			ps.setString(2,itemId);
			ps.executeUpdate();
			
			ps = con.prepareStatement(updateSql);
			ps.setString(1, itemId);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
