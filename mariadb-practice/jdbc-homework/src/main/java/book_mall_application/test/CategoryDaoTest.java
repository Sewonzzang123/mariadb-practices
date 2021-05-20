package book_mall_application.test;

import java.util.List;

import book_mall_application.dao.CategoryDao;
import book_mall_application.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		insertCategory();
		displayAllCategory();
	}

	private static void displayAllCategory() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo.toString());
		}
		
	}

	private static void  insertCategory() {
		CategoryVo vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("소설");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("수필");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("컴퓨터/IT");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("인문");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("경제");
		new CategoryDao().insert(vo);
		
		vo = new CategoryVo();
		vo.setNo(null);
		vo.setName("예술");
		new CategoryDao().insert(vo);
		
	}

}
