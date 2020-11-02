package com.javachip.carrotcountry.coBuying.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.coBuying.model.dao.ProductDao;
import com.javachip.carrotcountry.coBuying.model.dao.QnADao;
import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class ProductService {
	
	public int increaseCount(int bno) {
			
			Connection conn = getConnection();
			
			int result = new ProductDao().increaseCount(conn, bno);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			return result;
			
		}
	
	//
	
		
		public int selectProductListCount() {
			
			Connection conn = getConnection();
			
			int listCount = new ProductDao().selectProductListCount(conn);
			
			close(conn);
			
			return listCount;
			
		}
		
		

	//
	
	

	public Product selectProduct(int bno) {
		
		Connection conn = getConnection();
		Product p = new ProductDao().selectProduct(conn, bno);
		
		close(conn);
		
		return p;
		
	}
	
	
	public ArrayList<Option> selectOption(int bno){
		
		Connection conn = getConnection();
		ArrayList<Option> oList = new ProductDao().selectOption(conn, bno);
		
		close(conn);
		
		return oList;
		
	}
	
	
	public ArrayList<Account> selectAccount(int bno){
		
		Connection conn = getConnection();
		ArrayList<Account> aList = new ProductDao().selectAccount(conn, bno);
		
		close(conn);
		
		return aList;
		
	}
	
	public PostBoard selectThumbnail(int bno) {
		
		Connection conn = getConnection();
		PostBoard pb = new ProductDao().selectThumbnail(conn, bno);
		
		close(conn);
		
		return pb;
		
	}
	
	public ArrayList<Photo> selectPhoto(int bno){
		
		Connection conn = getConnection();
		ArrayList<Photo> ptList = new ProductDao().selectPhoto(conn, bno);
		
		close(conn);
		
		return ptList;
		
	}
	
	public ArrayList<Product> selectMainProductList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectMainProductList(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
