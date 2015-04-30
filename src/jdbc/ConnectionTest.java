package jdbc;

import java.sql.*;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection con = null;
		try {

			// 1 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 connection 생성
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(dbURL, "hr", "hr");

			System.out.println("연결성공><");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("oracle jdbc library가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}
	}
}
