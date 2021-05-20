package bookshop.test;

import java.util.List;

import bookshop.dao.AuthorDao;
import bookshop.dao.BookDao;
import bookshop.vo.AuthorVo;
import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest();
//		findAllTest();
//		update(4L, "대여중");
	}
	public static void update(Long bookNo, String status) {		
		new BookDao().update(bookNo, status);
		
	}
	public static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo:list) {
			System.out.println(vo.toString());
		}
	}
	private static void insertTest() {
		BookVo vo = new BookVo();
		
		vo = new BookVo();
		vo.setAuthorNo(2L);
		vo.setTitle("트와일라잇");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(2L);
		vo.setTitle("뉴문");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(2L);
		vo.setTitle("이클립스");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(2L);
		vo.setTitle("브레이킹던");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(3L);
		vo.setTitle("아리랑");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(4L);
		vo.setTitle("젊은그들");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(5L);
		vo.setTitle("아프니까 청춘이다");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(6L);
		vo.setTitle("귀천");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(3L);
		vo.setTitle("태백산맥");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setAuthorNo(7L);
		vo.setTitle("풀하우스");
		vo.setStatus("대여가능");
		new BookDao().insert(vo);
	}

	
}
