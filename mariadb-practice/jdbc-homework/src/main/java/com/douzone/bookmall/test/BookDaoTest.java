package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertBooks();
//		displayAllBook();
//		updateBook();
		deleteBook();
	}

	private static void deleteBook() {
		new BookDao().deleteBook(13L);
		
	}

	private static void updateBook() {
		BookVo vo = new BookVo();
		vo.setNo(1L);
		vo.setTitle("달러구트 꿈 백화점");
		vo.setPrice(13800);
		vo.setCategoryNo("1");
		new BookDao().updateBook(vo);
		
	}

	private static void displayAllBook() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo.toString());
		}
		
	}

	private static void  insertBooks() {
		BookVo vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("미드나잇 라이브러리");
		vo.setPrice(14000);
		vo.setCategoryNo("1");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("달러구트 꿈 백화점");
		vo.setPrice(13800);
		vo.setCategoryNo("1");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("작은 별이지만 빛나고 있어");
		vo.setPrice(15000);
		vo.setCategoryNo("2");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("꽃을 보듯 너를 본다");
		vo.setPrice(10000);
		vo.setCategoryNo("2");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("Do it! 점프 투 파이썬");
		vo.setPrice(18800);
		vo.setCategoryNo("3");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("눈치껏 못 배웁니다");
		vo.setPrice(16000);
		vo.setCategoryNo("3");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("질서 너머");
		vo.setPrice(17800);
		vo.setCategoryNo("4");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("공간의 미래");
		vo.setPrice(16000);
		vo.setCategoryNo("4");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("매매의 기술");
		vo.setPrice(18000);
		vo.setCategoryNo("5");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("아들아 돈 공부해야 한다");
		vo.setPrice(15800);
		vo.setCategoryNo("5");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("내가 사랑한 화가들");
		vo.setPrice(16800);
		vo.setCategoryNo("6");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setNo(null);
		vo.setTitle("방구석 미술관");
		vo.setPrice(16800);
		vo.setCategoryNo("6");
		new BookDao().insert(vo);
	}

}
