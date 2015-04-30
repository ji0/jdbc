package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HRSearchEmployee2 {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {

			
			Scanner sc = new Scanner(System.in);
			int min= sc.nextInt();
			int max = sc.nextInt();
			
			sc.close();
			
			
			// 1 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2 connection 생성
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(dbURL, "hr", "hr");

		//	System.out.println("연결성공><");

			// 3 statement 생성
			stmt = con.createStatement();
			
		
			// 4 sql문 날리기
			String sql = "select first_name, last_name, salary from employees where salary between " + min + " and " + max + "order by 3";
		
			
			rs = stmt.executeQuery(sql);
			
			// 5 결과 출력
			while(rs.next()){
				
				
				String name = rs.getString(1);
				
				String name2 = rs.getString(2);
				String salary = rs.getString(3);
				
				System.out.println(name + " " + name2+ " " + salary);
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
