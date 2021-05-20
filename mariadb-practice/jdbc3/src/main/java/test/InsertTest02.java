package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest02 {
	//preparedStatement
	public static void main(String[] args) {
		insertDepartment("영업");
		insertDepartment("개발");
		insertDepartment("기획");
	}
		
	
	
	public static boolean insertDepartment(String name) {	
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			// maven-dependencies에 없을 경우 classNotFound
			Class.forName("org.mariadb.jdbc.Driver");

			// tcp,ip연결
			String url = "jdbc:mysql://192.168.80.112:3307/employees";
			String id = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, id, password);

			// sql문 준비 (sql문 안에 ?로 비워둠)
			String sql = "insert "
					+ " into dept "
					+ " values(null,?)";
			pstmt = conn.prepareStatement(sql);
			
			// binding ( ? 값이 name으로 채워짐)
			pstmt.setString(1, name);
			
			// sql 실행		
			int count = pstmt.executeUpdate();
			
			result = (count == 1);
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error " + e);
		} finally {
			try {

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error " + e);
			}
		}
		return result;
	}

}
