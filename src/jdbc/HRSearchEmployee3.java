package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmployee3 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Scanner sc = new Scanner(System.in);
			String name = sc.next();

			sc.close();

			// 1 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 connection 생성
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(dbURL, "hr", "hr");

			// System.out.println("연결성공><");

			// 3 statement 준비

			String sql = "select first_name, last_name, email, phone_number, hire_date from employees where first_name like ? or last_name like ?";

			pstmt = con.prepareStatement(sql);

			// 4 sql문 바인딩

			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");

			rs = pstmt.executeQuery();

			// 5 결과 출력
			while (rs.next()) {

				String name1 = rs.getString(1);

				String name2 = rs.getString(2);

				System.out.println(name1 + " " + name2);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("oracle jdbc library가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 자원정리
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}

	}
}
