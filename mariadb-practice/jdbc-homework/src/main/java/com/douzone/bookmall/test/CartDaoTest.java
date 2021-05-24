package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
//		insertCart("7",1,"2");
		//updateCart();
		deleteCart();
		
//		boolean result = confirmCart();
//		System.out.println(result);
//		if(result == true) {
//			updateCart("1",5,"4");
//		}else {
//			insertCart("1",5,"4");
//		}
//		displayMyCart(4L);
	}

	private static void deleteCart() {
		CartVo cartVo = new CartVo();
		cartVo.setMemberNo("4");
		cartVo.setBookNo("3");
		new CartDao().deleteCart(cartVo);
	}

	private static boolean confirmCart() {
		boolean result = false;
		
		CartVo cartVo = new CartVo();
		cartVo.setMemberNo("4");
		cartVo.setBookNo("1");
		cartVo.setStock(3);
		List<CartVo> list = new CartDao().findCart(cartVo);
		if(list.size()==1) {
			result = true;
		}		
		return result;
	}
	//할수있으면 추가 만약 bookno,memberNo가 일치하는 항목이 있다면 update??

	private static List<CartVo> displayMyCart(Long memberNo) {
		List<CartVo> list = new CartDao().findCart(memberNo);
		for(CartVo vo: list) {
			System.out.println(vo.toString());
		}
		return list;
	}

	private static void insertCart(String bookNo, int stock, String memberNo) {
		CartVo vo = new CartVo();
		vo.setBookNo(bookNo);
		vo.setStock(stock);
		vo.setMemberNo(memberNo);
		
		new CartDao().insert(vo);		
	}
	
	private static void updateCart(String bookNo, int stock, String memberNo) {
		CartVo vo = new CartVo();
		vo.setBookNo(bookNo);
		vo.setStock(stock);
		vo.setMemberNo(memberNo);
		
		new CartDao().update(vo);	
		
	}

}
