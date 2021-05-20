package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// maven-dependencies에 없을 경우 classNotFound
			Class.forName("org.mariadb.jdbc.Driver");

			// tcp,ip연결
			String url = "jdbc:mysql://192.168.80.112:3307/employees";
			String id = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, id, password);

			// Statement 생성
			stmt = conn.createStatement();
			String sql = 
					"select emp_no, date_format(birth_date, '%Y-%m-%d'), first_name " 
					+ "from employees "
					+ "where first_name like 'pat%'";
			rs = stmt.executeQuery(sql);
			
			//결과 가져오기
			while(rs.next()) {
				Long empNo = rs.getLong(1);
				String birthDate = rs.getString(2);
				String firstName = rs.getString(3);
				
				System.out.println(empNo+" : "+birthDate+" : "+firstName);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}

	}

}
