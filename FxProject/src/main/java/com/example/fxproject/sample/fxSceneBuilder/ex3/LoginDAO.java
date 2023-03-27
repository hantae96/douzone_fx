package com.example.fxproject.sample.fxSceneBuilder.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
CREATE TABLE javafx(
id varchar2(10),
pw varchar2(10),
name varchar2(15),
gender varchar2(6),
hobbys varchar2(255),
PRIMARY Key(id)
);

INSERT INTO javafx VALUES
('admin', '1234', '관리자', '남여', '취미를 찾는 중인게 취미');
COMMIT;

SELECT * FROM javafx WHERE id='admin';
 */
public class LoginDAO {
	private Connection con;
	
	public LoginDAO() {
		String user = "douzone";
		String password = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loginProc(String id) {
		String sql = "SELECT pw FROM javafx WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pw = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pw;
	}
}
