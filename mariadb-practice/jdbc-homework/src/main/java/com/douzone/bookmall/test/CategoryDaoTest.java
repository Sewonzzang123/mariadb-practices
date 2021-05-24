package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		insertCategory();
//		displayAllCategory();
//		updateCategory();
		deleteCategory();
	}

	private static void deleteCategory() {
		new CategoryDao().delete(8L);
		
	}

	private static void updateCategory() {
		CategoryVo vo = new CategoryVo();
		vo.setNo(7L);
		vo.setName("역사");
		new CategoryDao().update(vo);
		
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
