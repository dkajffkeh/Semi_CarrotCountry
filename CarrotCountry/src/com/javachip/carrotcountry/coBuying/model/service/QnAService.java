package com.javachip.carrotcountry.coBuying.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.coBuying.model.dao.QnADao;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class QnAService {
	
	public int selectQnAListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QnADao().selectQnAListCount(conn);
		
		close(conn);
		
		return listCount;
		
	}
	
	

	public ArrayList<QnA> selectQnAList(PageInfo pi){
			
			Connection conn = getConnection();
			
			ArrayList<QnA> list = new QnADao().selectQnAList(conn, pi);
			
			close(conn);
			
			return list;
			
		}
	
	
	

	
	
	
	
}
