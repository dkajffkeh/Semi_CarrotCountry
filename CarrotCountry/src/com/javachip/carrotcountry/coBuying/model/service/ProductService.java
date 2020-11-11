package com.javachip.carrotcountry.coBuying.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.coBuying.model.dao.ProductDao;
import com.javachip.carrotcountry.coBuying.model.dao.QnADao;
import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;
import com.javachip.carrotcountry.coBuying.model.vo.PostBoardJY;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.model.TownMarketDao;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

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

			int result1 = new ProductDao().insertProductPost(conn, pb, lo);
			int result2 = new ProductDao().insertProductGroupPurchase(conn, pd);
			//int result3 = new ProductDao().insertProductLocation(conn, lo);
			int result4 = new ProductDao().insertProductOption(conn, option);
			int result5 = new ProductDao().insertProductAccount(conn, account);
			int result6 = new ProductDao().insertProductPhoto(conn, pList);
			
			

			System.out.println(result1);
			System.out.println(result2);
			//System.out.println(result3);
			System.out.println(result4);
			System.out.println(result5);
			System.out.println(result6);
			
			
			if(result1 > 0 && result2 > 0 && result4 > 0 && result5 > 0 && result6 > 0 ) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result1 * result2 * result4 * result5 * result6;
		}
		
		
	public int updateWishList(PostBoardJY pb) {
			
			Connection conn = getConnection();
			
			int result = new ProductDao().updateWishList(conn, pb);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
	
	
	public int reportCheck(int bno, int memNo) {
		
		Connection conn = getConnection();
		
		int repCheck = new ProductDao().reportCheck(conn, bno, memNo);
				
		close(conn);
		
		return repCheck;
	}
	
	
	
	public int reportProduct(int bno) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().reportProduct(conn, bno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<PostBoardJY> mainCategoryAjax(String cName, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<PostBoardJY> list = new ProductDao().mainCategoryAjax(conn,cName,pi);
		
		close(conn);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Product> selectMainProductList1(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectMainProductList1(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	public ArrayList<Product> selectMainProductList2(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectMainProductList2(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	public ArrayList<Product> selectMainProductList3(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectMainProductList3(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	public ArrayList<Product> selectMainProductList4(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectMainProductList4(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	
	public ArrayList<Product> sortCategory(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory30(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory30(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory40(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory40(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory50(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory50(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory60(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory60(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory70(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory70(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory80(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory80(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory90(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory90(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory100(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory100(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory110(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory110(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory120(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory120(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory130(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory130(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	public ArrayList<Product> sortCategory140(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().sortCategory140(conn, pi);
		
		close(conn);
		return pList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Product> searchKeyword(PageInfo pi, String keyword){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().searchKeyword(conn, pi, keyword);
		
		close(conn);
		return pList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Product> selectRegionProduct(PageInfo pi, String localGu, String localDong){
		Connection conn = getConnection();
		
		ArrayList<Product> pList = new ProductDao().selectRegionProduct(conn, pi, localGu, localDong);
		
		close(conn);
		return pList;
		
		
	}
	
	
	
	
	public ArrayList<PostBoardJY> mainSearchAjax(PageInfo pi, String keyword) {
		Connection conn = getConnection();
		ArrayList<PostBoardJY> bList = new ProductDao().mainSearchAjax(conn,pi,keyword);
		
		close(conn);
		
		return bList;
	}
	
	
	

}
