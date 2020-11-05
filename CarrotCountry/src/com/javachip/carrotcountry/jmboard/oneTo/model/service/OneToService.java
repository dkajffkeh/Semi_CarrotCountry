package com.javachip.carrotcountry.jmboard.oneTo.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

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
	

	
	
}
