package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;

public class CartDao {

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.112:3307/bookmall?charset=utf-8";
			String id = "bookmall";
			String password = "bookmall";
			conn = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		return conn;
	}

	public List<CartVo> findCart(Long memberNo) {
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select t1.no,t2.stock, (t2.stock*t1.price),t1.title " 
						+ "from book t1, cart t2, member t3 "
						+ "where t1.no = t2.book_no "
						+ "and t3.no = t2.member_no "
						+ "and t3.no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memberNo);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString(1);
				int stock = rs.getInt(2);
				int price = rs.getInt(3);
				String bookTitle = rs.getString(4);
				
				CartVo vo = new CartVo();
				vo.setBookNo(no);
				vo.setStock(stock);
				vo.setPrice(price);
				vo.setBookTitle(bookTitle);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		return result;
	}

	public boolean insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();
			String sql = "insert into cart values(?,?,?) ";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, vo.getStock());
			pstmt.setString(2, vo.getBookNo());
			pstmt.setString(3, vo.getMemberNo());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return result;
	}

	public List<CartVo> findCart(CartVo cartVo) {
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select t1.no,t2.stock, (t2.stock*t1.price),t1.title " 
						+ "from book t1, cart t2, member t3 "
						+ "where t1.no = t2.book_no "
						+ "and t3.no = t2.member_no "
						+ "and t2.member_no = ? "
						+ "and t2.book_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cartVo.getMemberNo());
			pstmt.setString(2, cartVo.getBookNo());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString(1);
				int stock = rs.getInt(2);
				int price = rs.getInt(3);
				String bookTitle = rs.getString(4);
				
				CartVo vo = new CartVo();
				vo.setBookNo(no);
				vo.setStock(stock);
				vo.setPrice(price);
				vo.setBookTitle(bookTitle);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		return result;
	}

	public boolean update(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();
			String sql = "update cart set stock=? where book_no=? and member_no=? ";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, vo.getStock());
			pstmt.setString(2, vo.getBookNo());
			pstmt.setString(3, vo.getMemberNo());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return result;
		
	}
}
