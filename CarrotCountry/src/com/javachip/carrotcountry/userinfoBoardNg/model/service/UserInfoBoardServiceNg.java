package com.javachip.carrotcountry.userinfoBoardNg.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.userinfoBoardNg.model.dao.UserInfoBoardDaoNg;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyPurchaseInfo;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyReport;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.RepPageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class UserInfoBoardServiceNg {

	
	/** 1. 나의 신고 총 갯수
	 * @param memNo
	 * @return
	 */
	public int selectRepListCount(int memNo) {
		Connection conn = getConnection();
		
		int repListCount = new UserInfoBoardDaoNg().selectRepListCount(conn, memNo);
		
		close(conn);
		
		return repListCount;
		
	}
	
	/** 2. 나의 신고 리스트
	 * @param pi
	 * @param memNo
	 * @return
	 */
	public ArrayList<MyReport> selectRepList(RepPageInfo pi, int memNo){
		Connection conn = getConnection();
		
		ArrayList<MyReport> list = new UserInfoBoardDaoNg().selectRepList(conn, pi, memNo);
		
		close(conn);
		
		return list;
		
	}
	
	/** 3. 나의 신고 내용 수정
	 * @param memNo
	 * @param reportNo
	 * @param reportContent
	 * @return
	 */
	public int updateRep(int memNo, int reportNo, String reportContent) {
		Connection conn = getConnection();
		
		int result = new UserInfoBoardDaoNg().updateRep(conn, memNo, reportNo, reportContent);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}
	
	public int selectPurchaseCount(int memNo) {
		Connection conn = getConnection();
		
		int listCount = new UserInfoBoardDaoNg().selectPurchaseCount(conn, memNo);
		
		close(conn);
		
		return listCount;

	}
	
	public ArrayList<MyPurchaseInfo> selectPurchaseList(RepPageInfo pi, int memNo){
		Connection conn = getConnection();
		
		ArrayList<MyPurchaseInfo> list = new UserInfoBoardDaoNg().selectPurchaseList(conn, pi, memNo);
		
		close(conn);
		
		return list;
		
	}
	
	public MyPurchaseInfo selectPurchase(int memNo, int purchaseNo) {
		Connection conn = getConnection();
		
		MyPurchaseInfo mpi = new UserInfoBoardDaoNg().selectPurchase(conn, memNo, purchaseNo);
		
		close(conn);
		
		return mpi;
		
	}
	
	
	public int buyerListCount(int bno) {
		
		Connection conn = getConnection();
		
		int count = new UserInfoBoardDaoNg().buyerListCount(conn, bno);
		
		close(conn);
		
		return count;
		
	}
	
	public ArrayList<MyPurchaseInfo> buyerList(RepPageInfo pi, int bno){
		
		Connection conn = getConnection();
		
		ArrayList<MyPurchaseInfo> list = new UserInfoBoardDaoNg().buyerList(conn, pi, bno);
		
		close(conn);
		
		return list;
	}
	
	public int buyingBuyerUpdate(int pNo, String co, long tNo) {
		Connection conn = getConnection();
		
		int result = new UserInfoBoardDaoNg().buyingBuyerUpdate(conn, pNo, co, tNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}
