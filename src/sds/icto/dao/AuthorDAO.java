package sds.icto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sds.icto.vo.AuthorVO;

public class AuthorDAO {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dbURL, "icto55", "icto55");

		return con;
	}

	public List<AuthorVO> fetch() throws ClassNotFoundException, SQLException {

		List<AuthorVO> list = new ArrayList<AuthorVO>();

		//1 connection 생성
		Connection con = getConnection();
		
		// 2 statement 생성
		Statement stmt = con.createStatement();
		String sql = "select * from author";
	
		// rs 생성
		ResultSet rs =stmt.executeQuery(sql);

		// 결과처리 
		while (rs.next()) {

			Long id = rs.getLong(1);
			String name = rs.getString(2);
			String bio = rs.getString(3);

			AuthorVO vo = new AuthorVO();
			vo.setId(id);
			vo.setName(name);
			vo.setBio(bio);

			list.add(vo);

		}
		
		//자원정리
		if (rs != null) {
			rs.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (con != null) {
			con.close();
		}
		if (con != null) {
			con.close();
		}

		return list;
	}

	public void insert(AuthorVO vo) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		
		String sql = "insert into author values( seq_author.nextval, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getBio());

		pstmt.executeUpdate();


		if (pstmt != null) {
			pstmt.close();
		}

		if (con != null) {
			con.close();
		}
		if (con != null) {
			con.close();
		}

	}

}
