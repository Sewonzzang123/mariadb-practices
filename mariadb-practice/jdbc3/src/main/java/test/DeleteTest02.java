package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest02 {

	public static void main(String[] args) {
		Boolean result = delete(6L);
		System.out.println(result ? "성공":"실패");
	}
		
	
	
	public static boolean delete(Long no) {	
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
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
			
			//sql문을 실행
			String sql = "delete from dept where no="+no;
			
			int count = stmt.executeUpdate(sql);			
			result = (count == 1);
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error " + e);
		} finally {
			try {

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
		return result;
	}

}
