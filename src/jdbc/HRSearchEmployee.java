package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmployee {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			
			Scanner sc = new Scanner(System.in);
			String name3 = sc.next();
			
			sc.close();
			
			
			// 1 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 connection 생성
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(dbURL, "hr", "hr");

			System.out.println("연결성공><");

			// 3 statement 생성
			stmt = con.createStatement();
			
		
			// 4 sql문 날리기
			String sql = "select first_name, last_name, email, phone_number, hire_date from employees where first_name like '%" + name3 + "%' or last_name like '%" + name3 + "%'";
			
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			
			// 5 결과 출력
			while(rs.next()){
				
				
				String name = rs.getString(1);
				
				String name2 = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String hire_date = rs.getString(5);
				
				System.out.println(name + " " + name2+ " " + email+ " " + phone+ " " + hire_date);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("oracle jdbc library가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// 자원정리
			try {
				if(rs != null){
					rs.close();
				}
				
				if(stmt != null){
					stmt.close();
				}
				
				if(con != null){
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
