package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertOrder();
//		displayAllOrder();
//		displayMemberOrder(4L);
//		insertOrderBook();
		findOrderCart();
//		deleteCart(); //findOrderCart안에 넣었음.
	}


	private static void findOrderCart() {
		Long orderNo = 9L;
		List<CartVo> cartList = new OrderDao().findOrderCart(orderNo);
		for(CartVo vo:cartList) {
			new OrderDao().deleteCart(vo);
		}
		
	}



	private static void insertOrderBook() {
		OrderBookVo vo = new OrderBookVo();
		vo.setOrderNo("9");
		vo.setBookNo("1");
		vo.setCount(2);
		new OrderDao().insertOrderBook(vo);
		
		vo.setOrderNo("9");
		vo.setBookNo("6");
		vo.setCount(3);
		new OrderDao().insertOrderBook(vo);
	}

	private static void insertOrder() {
		OrderVo vo = new OrderVo();
		vo.setAddress("테스트 집주소");
		vo.setMemberNo("4");
		vo.setPrice(20000);
		new OrderDao().insertOrder(vo);
	}

	private static void displayAllOrder() {
		List<OrderVo> orderList = new OrderDao().displayAllOrder();
		for(OrderVo vo : orderList) {
			System.out.println(vo.toString());
		}
		
	}

	private static void displayMemberOrder(Long memberNo) {
		List<OrderVo> orderList = new OrderDao().displayMemberOrder(memberNo);
		Long orderNo = null;
		for(OrderVo vo : orderList) {
			System.out.println(vo.toString());
			orderNo = vo.getNo();
		}
		List<OrderBookVo> orderBookList = new OrderDao().findOrderBook(orderNo);
		for(OrderBookVo vo: orderBookList) {
			System.out.println(vo.toString());
		}
		
	}
	
	

}
