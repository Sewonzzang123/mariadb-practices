package book_mall_application.test;

import java.util.List;

import book_mall_application.dao.CartDao;
import book_mall_application.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertCart();
		displayAllCart();

	}

	private static void displayAllCart() {
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo: list) {
			System.out.println(vo.toString());
		}
	}

	private static void insertCart(String bookNo, int stock, String memberNo) {
		CartVo vo = new CartVo();
		vo.setNo(null);
		vo.setBookNo(bookNo);
		vo.setStock(stock);
		vo.setMemberNo(memberNo);
		
		
	}

}
