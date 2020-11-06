package com.javachip.carrotcountry.jmboard.oneTo.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.jmboard.faq.model.dao.FaqDao;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;
import com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo;
import com.javachip.carrotcountry.jmboard.oneTo.model.dao.OneToDao;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;


public class OneToService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new OneToDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<OneTo> selectList(PageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<OneTo> list = new OneToDao().selectList(conn,pi);
		
		return list;
	}

	public int insertOneTo(OneTo o) {
		Connection conn = getConnection();

		int result = new OneToDao().insertOneTo(conn,o);
		
		if(result > 0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int answer(OneTo o) {
		Connection conn = getConnection();
		
		int result = new OneToDao().answer(conn,o);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int userModify(OneTo o) {
		
		Connection conn = getConnection();
		
		int result = new OneToDao().userModify(conn,o);
		
		
		
		return 0;
	}

	/*
	public Faq selectOneTo(int ono) {
		
		Connection conn = getConnection();
		
		OneTo o = new OneToDao().selectOneTo(conn, ono);
		
		close(conn);
		
		return o;
	}
	
*/
	
	
}
