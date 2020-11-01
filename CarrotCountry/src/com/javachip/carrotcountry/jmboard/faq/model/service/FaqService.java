package com.javachip.carrotcountry.jmboard.faq.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.jmboard.faq.model.dao.FaqDao;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

public class FaqService {

	/**
	 * FAQ리스트 보기 
	 * @return list FAQ리스트 입니다.
	 */
	public ArrayList<Faq> selectFaqList() {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
		
		close(conn);
		
		return list;
	}

//faq게시판 작성하기
	public int insertFaq(Faq f) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().insertFaq(conn, f);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	// 카운트없지만 일단 만들어둠
	public int increaseCount(int nno) {
		Connection conn = getConnection();
		
		int result = new FaqDao().increaseCount(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
//faq게시판
	public Faq selectFaq(int nno) {
		Connection conn = getConnection();
		
		Faq f = new FaqDao().selectFaq(conn, nno);
		
		close(conn);
		
		return f;
	}
	//update
	public int updateFaq(Faq f) {
		
		Connection conn = getConnection();
		
		int result = new FaqService().updateFaq(f);
		
		
		if(result > 0) {
			
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	
	
	
	
	
//FAQ게시판 삭제
	public int delectFaq(int nno) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().deleteFaq(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}



	
	
	

}
