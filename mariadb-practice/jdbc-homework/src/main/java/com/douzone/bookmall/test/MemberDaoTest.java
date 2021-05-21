package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertMembers();
		displayAllMember();
	}

	private static void displayAllMember() {
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo.toString());
		}
		
	}

	private static void  insertMembers() {
		MemberVo vo = new MemberVo();
		vo.setNo(null);
		vo.setName("둘리");
		vo.setEmail("dooly@gmail.com");
		vo.setPassword("dooly");
		new MemberDao().insert(vo);
		
		vo = new MemberVo();
		vo.setNo(null);
		vo.setName("또치");
		vo.setEmail("ddochi@naver.com");
		vo.setPassword("ddochi");
		new MemberDao().insert(vo);
		
		vo = new MemberVo();
		vo.setNo(null);
		vo.setName("마이콜");
		vo.setEmail("may@gmail.com");
		vo.setPassword("may");
		new MemberDao().insert(vo);
		
		vo = new MemberVo();
		vo.setNo(null);
		vo.setName("희동이");
		vo.setEmail("heedong@naver.com");
		vo.setPassword("heedong");
		new MemberDao().insert(vo);
		
		vo = new MemberVo();
		vo.setNo(null);
		vo.setName("고길동");
		vo.setEmail("gildong@gmail.com");
		vo.setPassword("gildong");
		new MemberDao().insert(vo);
		
	}
}
