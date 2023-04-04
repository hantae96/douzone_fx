package com.fx.market.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fx.market.common.Session;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.PhotoDto;

public class RegisterDao {
	private Connection con;
	
	public RegisterDao(){
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
	
	
	public String saveItem(ItemDto item) {
		
		PreparedStatement ps = null;				
		String account_id = Session.getInstance().getAccountId();
		String saled_id = null;
		String itemId = null;
		
		String sql = "insert into goods(goods_id,accounts_id,title,content,address,price,saled_id) values (concat('g', goods_seq.nextval),?,?,?,?,?,?)";
		String getIdSql = "SELECT goods_seq.CURRVAL FROM dual";
	
		try {
			
			ps = con.prepareStatement(sql);
			Statement stmt2 = con.createStatement();
			ps.setString(1,account_id);
			ps.setString(2,item.getItemName());
			ps.setString(3,item.getItemContext());
			ps.setString(4,item.getItemLocal());
			ps.setString(5,String.valueOf(item.getItemPrice()));
			ps.setString(6,saled_id);
			ps.executeUpdate();
			
			stmt2.execute(getIdSql);
			try (ResultSet rs = stmt2.getResultSet()) {
		        if (rs.next()) {
		        	itemId = "g".concat(rs.getString(1));
		        }
		    }
			con.close();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return itemId;
	}

	public void savePhoto(PhotoDto dto) {
		String sql = "insert into photos values(?, ?, ?, SYSDATE)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPhotos_id());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getPath());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void getId() {
		// TODO Auto-generated method stub
		
	}

}
