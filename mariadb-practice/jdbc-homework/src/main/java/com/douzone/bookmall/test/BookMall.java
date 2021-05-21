package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.MemberVo;
import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("========== 회원 ==========");
		
		MemberDao memberDao = new MemberDao();
		MemberVo memberVo = new MemberVo();
		
//		memberVo = new MemberVo();
//		memberVo.setNo(null);
//		memberVo.setName("둘리");
//		memberVo.setEmail("dooly@gmail.com");
//		memberVo.setPassword("dooly");
//		memberDao.insert(memberVo);
//		
//		memberVo = new MemberVo();
//		memberVo.setNo(null);
//		memberVo.setName("또치");
//		memberVo.setEmail("ddochi@naver.com");
//		memberVo.setPassword("ddochi");
//		memberDao.insert(memberVo);
		
		List<MemberVo> memberList = memberDao.findAll();
		for(MemberVo vo : memberList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("========== 카테고리 ==========");
		CategoryDao categoryDao = new CategoryDao();
		CategoryVo categoryVo = new CategoryVo();
		
//		categoryVo.setNo(null);
//		categoryVo.setName("소설");
//		categoryDao.insert(categoryVo);
//		categoryVo = new CategoryVo();
//		categoryVo.setNo(null);
//		categoryVo.setName("수필");
//		categoryDao.insert(categoryVo);
//		categoryVo = new CategoryVo();
//		categoryVo.setNo(null);
//		categoryVo.setName("컴퓨터/IT");
//		categoryDao.insert(categoryVo);
		
	
		List<CategoryVo> list = categoryDao.findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo.toString());
		}
		
		System.out.println("========== 상품 ==========");		
		BookDao bookDao = new BookDao();
		BookVo bookVo = new BookVo();
//		
//		bookVo.setNo(null);
//		bookVo.setTitle("미드나잇 라이브러리");
//		bookVo.setPrice(14000);
//		bookVo.setCategoryNo("1");
//		bookDao.insert(bookVo);
//		
//		bookVo = new BookVo();
//		bookVo.setNo(null);
//		bookVo.setTitle("달러구트 꿈 백화점");
//		bookVo.setPrice(13800);
//		bookVo.setCategoryNo("1");
//		bookDao.insert(bookVo);
//		
//		bookVo = new BookVo();
//		bookVo.setNo(null);
//		bookVo.setTitle("작은 별이지만 빛나고 있어");
//		bookVo.setPrice(15000);
//		bookVo.setCategoryNo("2");
//		bookDao.insert(bookVo);
		
		List<BookVo> bookList = bookDao.findAll();
		for(BookVo vo : bookList) {
			System.out.println(vo.toString());
		}
		
		System.out.println("========== 카트 ==========");	
		CartDao cartDao = new CartDao();
		CartVo cartVo = new CartVo();
		boolean result = false;
		
		cartVo.setBookNo("3");
		cartVo.setStock(2);
		cartVo.setMemberNo("4");
		
		//동일내용이 있으면 update로 수량 변경
		result = insertOrUpdateCart(cartVo);
		if(result == true) {
			cartDao.update(cartVo);
		}else {
			cartDao.insert(cartVo);
		}
		
		cartVo.setBookNo("1");
		cartVo.setStock(6);
		cartVo.setMemberNo("4");
		
		//동일내용이 있으면 update로 수량 변경
		result = insertOrUpdateCart(cartVo);
		if(result == true) {
			cartDao.update(cartVo);
		}else {
			cartDao.insert(cartVo);
		}
		
	
		cartVo = new CartVo();
		cartVo.setBookNo("6");
		cartVo.setStock(3);
		cartVo.setMemberNo("4");	
		cartDao.insert(cartVo);
		result = insertOrUpdateCart(cartVo);
		if(result == true) {
			cartDao.update(cartVo);
		}else {
			cartDao.insert(cartVo);
		}
		
		
		System.out.println("회원번호가 4번인 회원의 카트 조회");
		List<CartVo> cartList = new CartDao().findCart(4L);
		for(CartVo vo: cartList) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("========== 주문 ==========");	
		System.out.println("4번이 카트의 책을 전체 주문");
		OrderDao orderDao = new OrderDao();
		OrderVo orderVo = new OrderVo();
		orderVo.setAddress("테스트 집주소");
		orderVo.setMemberNo("4");
		orderVo.setPrice(20000);
		orderDao.insertOrder(orderVo);
		
//		카트 선택한 책들이 order_book으로 이동
		OrderBookVo orderBookVo = new OrderBookVo();
		orderBookVo.setBookNo("1");
		orderBookVo.setCount(6);
		orderBookVo.setOrderNo("13");
		orderDao.insertOrderBook(orderBookVo);
		
		orderBookVo = new OrderBookVo();
		orderBookVo.setBookNo("6");
		orderBookVo.setCount(3);
		orderBookVo.setOrderNo("13");
		orderDao.insertOrderBook(orderBookVo);
		
		System.out.println("4번 주문 내역");
		Long orderNo = null;
		List<OrderVo> orderList = orderDao.displayMemberOrder(4L);
		
		for(OrderVo vo : orderList) {
			System.out.println(vo.toString());
			orderNo = vo.getNo();
		}
		
		System.out.println("주문내역에 따른 주문도서 내역");
		List<OrderBookVo> orderBookList = orderDao.findOrderBook(13L);
		for(OrderBookVo vo: orderBookList) {
			System.out.println(vo.toString());
		}
		// 주문번호에 등록된 책을 카트에서 제거
		cartList = orderDao.findOrderCart(orderNo);
		for(CartVo vo:cartList) {
			new OrderDao().deleteCart(vo);
		}
		
		System.out.println("회원번호가 4번인 회원의 카트 조회");
		cartList = new CartDao().findCart(4L);
		for(CartVo vo: cartList) {
			System.out.println(vo.toString());
		}
		
	}
	
	public static boolean insertOrUpdateCart(CartVo cartVo) {
		CartDao cartDao = new CartDao();
		boolean result = false;
		List<CartVo> CartList = new CartDao().findCart(cartVo);
		if(CartList.size()==1) {
			result = true;
		}
		
		return result;
	}
}
