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
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;

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
	

	public PostBoard selectPostBoard(int bno) {
		
		Connection conn = getConnection();
		PostBoard pb = new ProductDao().selectPostBoard(conn, bno);
		
		close(conn);
		
		return pb;
		
	}
		

	public Product selectProduct(int bno) {
		
		Connection conn = getConnection();
		Product pd = new ProductDao().selectProduct(conn, bno);
		
		close(conn);
		
		return pd;
		
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
	
	
	
	
	public int insertProduct(PostBoard pb, Product pd, Location lo, String[] option, String[] account, ArrayList<Photo> pList) {
			
			Connection conn = getConnection();

			int result1 = new ProductDao().insertProductPost(conn, pb);
			int result2 = new ProductDao().insertProductGroupPurchase(conn, pd);
			int result3 = new ProductDao().insertProductLocation(conn, lo);
			int result4 = new ProductDao().insertProductOption(conn, option);
			int result5 = new ProductDao().insertProductAccount(conn, account);
			int result6 = new ProductDao().insertProductPhoto(conn, pList);
			
			

			System.out.println(result1);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);
			System.out.println(result5);
			System.out.println(result6);
			
			
			if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0 && result6 > 0 ) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result1 * result2 * result3 * result4 * result5 * result6;
		}
		
		
		
	
	
	
	
	
	

}
