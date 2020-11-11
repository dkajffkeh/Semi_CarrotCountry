package com.javachip.carrotcountry.jmboard.faq.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.jmboard.faq.model.dao.FaqDao;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;
import com.javachip.carrotcountry.jmboard.oneTo.model.dao.OneToDao;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;

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

//faq게시판
	public Faq selectFaq(int fno) {
		Connection conn = getConnection();
		
		Faq f = new FaqDao().selectFaq(conn, fno);
		
		close(conn);
		
		return f;
	}

	//update
	public int updateFaq(Faq f) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().updateFaq(conn,f);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	
	
	
	
	
//FAQ게시판 삭제
	public int deleteFaq(int fno) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().deleteFaq(conn, fno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public ArrayList<Faq> FaqSearchList(int type) {
		
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectViewList(conn,type);
		
		return list;
	}



	
	
	

}
