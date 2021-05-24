package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDao {
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

	public List<OrderVo> displayMemberOrder(Long memberNo) {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "  select  t1.order_no,t2.name,t2.email, t1.address,  t1.price,t1.no  "
						+ " from book_order t1, member t2 "
						+ " where t1.member_no = t2.no "
						+ " and t1.member_no =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, memberNo);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String orderNo = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String address = rs.getString(4);
				int price = rs.getInt(5);
				Long no = rs.getLong(6);
				
			
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderNo(orderNo);
				vo.setName(name);
				vo.setEmail(email);
				vo.setAddress(address);
				vo.setPrice(price);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}finally {
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

	public List<OrderVo> displayAllOrder() {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "  select  t1.order_no,t2.name,t2.email, t1.address,  t1.price ,t1.no "
						+ " from book_order t1, member t2 "
						+ " where t1.member_no = t2.no ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String orderNo = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String address = rs.getString(4);
				int price = rs.getInt(5);
				Long no = rs.getLong(6);
			
				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setName(name);
				vo.setEmail(email);
				vo.setAddress(address);
				vo.setPrice(price);
				vo.setNo(no);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}finally {
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

	public boolean insertOrder(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "insert into book_order "
					+ "values(null,?,?,?,concat(date_format(now(),'%Y%m%d%h%i%s'),?))" ;
				
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, orderVo.getAddress());
			pstmt.setString(2, orderVo.getMemberNo());
			pstmt.setInt(3, orderVo.getPrice());
			pstmt.setString(4, orderVo.getMemberNo());
			

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

	public boolean insertOrderBook(OrderBookVo orderBookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "insert into order_book "
					+ " values(?, ?, ?,(select price*? "
					+ "						from book "
					+ "                        where no=?)) " ;
	
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, orderBookVo.getOrderNo());
			pstmt.setString(2, orderBookVo.getBookNo());
			pstmt.setInt(3, orderBookVo.getCount());
			pstmt.setInt(4, orderBookVo.getCount());
			pstmt.setString(5, orderBookVo.getBookNo());
			
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

	public List<OrderBookVo> findOrderBook(Long orderNo) {
		List<OrderBookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "  select t1.book_no, t2.title, t1.count, t1.price "
						+ " from order_book t1, book t2 "
						+ " where t1.book_no = t2.no "
						+ " and t1.book_order_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderNo);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				int price = rs.getInt(4);
				
			
				OrderBookVo vo = new OrderBookVo();
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(price);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}finally {
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

	public boolean deleteCart(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "delete from cart where book_no=? and member_no=? " ;
			
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cartVo.getBookNo());
			pstmt.setString(2, cartVo.getMemberNo());
			
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

	public List<CartVo> findOrderCart(Long orderNo) {
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "  select t2.book_no, t1.member_no "
					+ "from book_order t1, order_book t2 "
					+ "where t1.no=t2.book_order_no "
					+ "and t1.no =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderNo);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String bookNo = rs.getString(1);
				String memberNo =rs.getString(2);
				
			
				CartVo vo = new CartVo();
				vo.setBookNo(bookNo);
				vo.setMemberNo(memberNo);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}finally {
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

	public List<OrderVo> displayTodayOrder(String today) {
		List<OrderVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "  select t1.no, t1.address, t1.member_no, t1.price, t1.order_no, t2.name, t2.email"
						+ " from book_order t1,member t2 "
						+ " where t1.member_no = t2.no "
						+ " and order_no like ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today+"%");
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Long no = rs.getLong(1);
				String address = rs.getString(2);
				String memberNo = rs.getString(3);
				int price = rs.getInt(4);
				String orderNo = rs.getString(5);
				String memberName = rs.getString(6);
				String email = rs.getString(7);
				
			
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setAddress(address);
				vo.setMemberNo(memberNo);
				vo.setPrice(price);
				vo.setOrderNo(orderNo);
				vo.setName(memberName);
				vo.setEmail(email);
				
				result.add(vo);
			}
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}finally {
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
