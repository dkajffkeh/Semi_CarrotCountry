package com.javachip.carrotcountry.coBuying.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.coBuying.model.dao.QnADao;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;
import com.javachip.carrotcountry.coBuying.model.vo.Product;

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
	
	
	public ArrayList<QnA> selectSellerQnAList(PageInfo pi, int bno){
		
		Connection conn = getConnection();
		
		ArrayList<QnA> list = new QnADao().selectSellerQnAList(conn, pi, bno);
		
		close(conn);
		
		return list;
		
	}
	
	
	public Product selectProductQnAList(int bno) {
		
		Connection conn = getConnection();
		
		Product pd = new QnADao().selectProductQnAList(conn, bno);
		
		close(conn);
		return pd;
		
		
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
	
	
	public int increaseQnACount(int bno) {
		Connection conn = getConnection();
		
		int result = new QnADao().increaseQnACount(conn, bno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	
	public QnA selectQnADetail(int bno) {
		
		Connection conn = getConnection();
		
		QnA qa = new QnADao().selectQnADetail(conn, bno);
		
		close(conn);
		return qa;
		
		
	}

	
	public int updateBuyerQnA(QnA qa) {
		
		Connection conn = getConnection();
		
		int result = new QnADao().updateBuyerQnA(conn, qa);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
			close(conn);
		
		return result;
	}
	
	
	
	public int deleteBuyerQnA(int bno) {
		
		Connection conn = getConnection();
		
		int result = new QnADao().deleteBuyerQnA(conn, bno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	
}
