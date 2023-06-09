package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fx.market.dto.MySellListDto;

public class MySellListDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//생성자
	public MySellListDao() {
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
	
	// 프로필 사진
	public String getMyPhoto(String id) {
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
	
	//판매글 출력
	public List<MySellListDto> getMySellList(String id) {
		List<MySellListDto> items = new ArrayList<>();
		String sql = "SELECT goods.title, goods.address, goods.price, TO_CHAR(goods.created_at, 'YYYYMMDD') as created_at, goods.goods_id, photos.path FROM goods LEFT JOIN photos ON goods.goods_id = photos.photos_id WHERE goods.accounts_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				MySellListDto dto = new MySellListDto();
				dto.setGoodsPhoto(rs.getString("path"));
				dto.setGoodsTitle(rs.getString("title"));
				dto.setGoodsAddress(rs.getString("address"));
				dto.setGoodsPrice(rs.getString("price"));
				dto.setGoodsCreated_at(rs.getString("created_at"));
				dto.setGoods_id(rs.getString("goods_id"));
				items.add(dto);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//구매글 출력
	public List<MySellListDto> getMyBuyList(String id) {
		List<MySellListDto> items = new ArrayList<>();
		String sql = "SELECT goods.title, goods.address, goods.price, TO_CHAR(goods.created_at, 'YYYYMMDD') as created_at, goods.goods_id, photos.path FROM goods LEFT JOIN photos ON goods.goods_id = photos.photos_id WHERE goods.saled_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				MySellListDto dto = new MySellListDto();
				dto.setGoodsPhoto(rs.getString("path"));
				dto.setGoodsTitle(rs.getString("title"));
				dto.setGoodsAddress(rs.getString("address"));
				dto.setGoodsPrice(rs.getString("price"));
				dto.setGoodsCreated_at(rs.getString("created_at"));
				dto.setGoods_id(rs.getString("goods_id"));
				items.add(dto);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//작성글 출력
	public List<MySellListDto> getMyBoardList(String id) {
		List<MySellListDto> items = new ArrayList<>();
		String sql = "SELECT boards.boards_id, boards.title, boards.address, boards.main_category, TO_CHAR(boards.created_at, 'YYYYMMDD') as created_at, photos.path FROM boards LEFT JOIN photos ON boards.boards_id = photos.photos_id WHERE boards.accounts_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				MySellListDto dto = new MySellListDto();
				dto.setGoods_id(rs.getString("boards_id"));
				dto.setGoodsPhoto(rs.getString("path"));
				dto.setGoodsTitle(rs.getString("title"));
				dto.setGoodsAddress(rs.getString("address"));
				dto.setGoodsPrice(rs.getString("main_category"));
				dto.setGoodsCreated_at(rs.getString("created_at"));
				items.add(dto);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//관심글 출력
	public List<MySellListDto> getMyFavorList(String id) {
		List<MySellListDto> items = new ArrayList<>();
		String sql = "SELECT goods.title, goods.address, goods.price, TO_CHAR(goods.created_at, 'YYYYMMDD') as created_at, goods.goods_id, photos.path "
				+ "FROM favorites "
				+ "JOIN accounts ON favorites.accounts_id = accounts.accounts_id "
				+ "JOIN goods ON favorites.goods_id = goods.goods_id "
				+ "JOIN photos ON favorites.goods_id = photos.photos_id "
				+ "WHERE accounts.accounts_id =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				MySellListDto dto = new MySellListDto();
				dto.setGoods_id(rs.getString("goods_id"));
				dto.setGoodsPhoto(rs.getString("path"));
				dto.setGoodsTitle(rs.getString("title"));
				dto.setGoodsAddress(rs.getString("address"));
				dto.setGoodsPrice(rs.getString("price"));
				dto.setGoodsCreated_at(rs.getString("created_at"));
				items.add(dto);
			}
			return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//받은 평가 갯수 select
	public int[] getGradeNum(String id) {
		String sql = "SELECT "
				+ "  SUM(CASE WHEN grade = 5 THEN 1 ELSE 0 END) AS grade_5,"
				+ "  SUM(CASE WHEN grade = 4 THEN 1 ELSE 0 END) AS grade_4,"
				+ "  SUM(CASE WHEN grade = 3 THEN 1 ELSE 0 END) AS grade_3,"
				+ "  SUM(CASE WHEN grade = 2 THEN 1 ELSE 0 END) AS grade_2,"
				+ "  SUM(CASE WHEN grade = 1 THEN 1 ELSE 0 END) AS grade_1 "
				+ "FROM goods "
				+ "WHERE accounts_id =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int[] gradeNum = {rs.getInt("grade_5"), rs.getInt("grade_2"), rs.getInt("grade_3"), rs.getInt("grade_4"), rs.getInt("grade_1")};
				return gradeNum;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
