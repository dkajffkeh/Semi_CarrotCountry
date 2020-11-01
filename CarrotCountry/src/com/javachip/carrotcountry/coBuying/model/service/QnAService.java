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
	
	
	public int insertQuestion(QnA qa) {
		
		Connection conn = getConnection();
		
		int result = new QnADao().insertQuestion(conn, qa);

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	
	public int increaseQnACount(int qno) {
		Connection conn = getConnection();
		
		int result = new QnADao().increaseQnACount(conn, qno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	
	public QnA selectQnADetail(int qno) {
		
		Connection conn = getConnection();
		
		QnA qa = new QnADao().selectQnADetail(conn, qno);
		
		close(conn);
		return qa;
		
		
	}

	
	
	
	
}
