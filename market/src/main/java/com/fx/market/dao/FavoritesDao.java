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
		
		String sql = "insert into favorites (favorites_id,accounts_id,goods_id) values (concat('f',favorites_seq.nextval),?,?)";		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, accountsId);
			ps.setString(2, goodsId);
			ps.executeUpdate();
			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
