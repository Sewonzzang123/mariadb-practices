package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//maven-dependencies에 없을 경우 classNotFound
			Class.forName("org.mariadb.jdbc.Driver");
			
			//tcp,ip연결 
			String url = "jdbc:mysql://192.168.80.112:3307/webdb";
			String id = "webdb";
			String password = "webdb";
			conn = DriverManager.getConnection(url,id,password);
			//연결 성공
			System.out.println("ok "+conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+e);
		} catch (SQLException e) {
			System.out.println("error "+e);
		} finally {
			try {
			if(conn != null) {
				conn.close();
				} 
			}catch (SQLException e) {
				System.out.println("error "+e);
				}
			}

			
		}



	}


