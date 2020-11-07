package com.javachip.carrotcountry.userinfoBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import com.javachip.carrotcountry.member.model.vo.Member;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.model.TownMarketDao;
import com.javachip.carrotcountry.userinfoBoard.model.dao.UserInfoBoardDao;
import com.javachip.carrotcountry.userinfoBoard.model.vo.CobuyingPost;
import com.javachip.carrotcountry.userinfoBoard.model.vo.Location;
import com.javachip.carrotcountry.userinfoBoard.model.vo.PageInfo;
import com.javachip.carrotcountry.userinfoBoard.model.vo.SaleProduct;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;
import com.javachip.carrotcountry.userinfoBoard.model.vo.UserinfoMember;
import com.javachip.carrotcountry.userinfoBoard.model.vo.WishList;

import java.sql.Connection;
import java.util.ArrayList;


public class UserInfoBoardService {
	
	/**
	 * 1. 정보변경용 서비스
	 * @param m		변경할 내용들+변경요청한회원의아이디 가 담겨있는 객체
	 * @return		갱신된 회원 객체/null
	 */
	public UserinfoMember updateMember(UserinfoMember m) {
		
		Connection conn = getConnection();
		
		int result = new UserInfoBoardDao().updateMember(conn, m);
		
		UserinfoMember updateMem = null;
		
		if(result >0) {
			commit(conn);
			
			updateMem = new UserInfoBoardDao().selectMember(conn, m.getMemUserId());
		}else {
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
		
		
	}
	
	/**
	 * 2. 회원 탈퇴용 서비스
	 * @param userId	탈퇴요청한 회원의 아이디
	 * @param userPwd	탈퇴요청한 회원의 비밀번호
	 * @return			처리된 행수 
	 */
	
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new UserInfoBoardDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	/**
	 * 3. 배송지 조회
	 * @param memNo 	배송지 조회한 회원번호
	 * @return 			처리된 list
	 *
	 */
	public ArrayList<ShippingLocation> selectShippingLocation(int memNo){
		
		Connection conn = getConnection();
		ArrayList<ShippingLocation> list = new UserInfoBoardDao().selectShippingLocation(conn, memNo);
		close(conn);
		return list;
	
	}
	/**
	 * 4. 지역 조회
	 * @param memNo 	지역번호
	 * @return 			
	 *
	 */
	public Location selectLocation(int memNo) {
		Connection conn = getConnection();
		Location lo = new UserInfoBoardDao().selectLocation(conn, memNo);
		close(conn);
		return lo;
		
	}
	
	/**
	 * 5. 공동구매 게시글 조회
	 * @param 
	 * @return 			
	 *
	 */
		public ArrayList<CobuyingPost> selectCobuyingList(PageInfo pi, int memNo){
		
		Connection conn = getConnection();
		
		ArrayList<CobuyingPost> list = new UserInfoBoardDao().selectCobuyingList(conn, pi, memNo);
		
		close(conn);
		
		return list;
	
		}
		
		public int selectListCount() {
			
			Connection conn = getConnection();
			
			int listCount = new  UserInfoBoardDao().selectListCount(conn);
			
			close(conn);
			
			return listCount;
		}
	
		/**
		 * 6. 찜목록 조회
		 * @param 
		 * @return 			
		 *
		 */
		
		public ArrayList<WishList> selectWishList(PageInfo pi, int memNo){
			Connection conn = getConnection();
			
			ArrayList<WishList> list = new UserInfoBoardDao().selectWishList(conn, pi, memNo);
			
			close(conn);
			
			return list;
			
		}

		/**
		 * 7. 판매완료 조회
		 * @param 
		 * @return 			
		 *
		 */
		
		public ArrayList<SaleProduct> selectCompletedSales(int memNo, PageInfo pi){
			Connection conn = getConnection();
			
			ArrayList<SaleProduct> list = new UserInfoBoardDao().selectCompletedSales(conn, memNo, pi);
			
			close(conn);
			
			return list;
			
		}
		
		/**
		 * 8. 판매완료 삭제
		 * @param 
		 * @return 			
		 *
		 */
		
		public int deleteCompletedSales(int bno) {
			Connection conn = getConnection();
			
			int result = new UserInfoBoardDao().deleteCompletedSales(conn,bno);
			
			if(result>0){
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		/**
		 * 9.  판매중 조회
		 * @param 
		 * @return 			
		 *
		 */
		
		public ArrayList<SaleProduct> selectOnSales(int memNo, PageInfo pi){
			Connection conn = getConnection();
			
			ArrayList<SaleProduct> list = new UserInfoBoardDao().selectOnSales(conn, memNo, pi);
			
			close(conn);
			
			return list;
			
		}
		
		/**
		 * 10.  판매중 삭제
		 * @param 
		 * @return 			
		 *
		 */
		
		public int deleteOnSales(int bno) {
			Connection conn = getConnection();
			
			int result = new UserInfoBoardDao().deleteOnSales(conn,bno);
			
			if(result>0){
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		/**
		 * 11.  판매중 변경
		 * @param 
		 * @return 			
		 *
		 */
		
		public int updateOnSales(int bno) {
			Connection conn = getConnection();
			
			int result = new UserInfoBoardDao().updateOnSales(conn,bno);
			
			if(result>0){
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		/**
		 * 12. 배송지 추가
		 * @param 
		 * @return 			
		 *
		 */
		
		public int insertAddress(ShippingLocation sl) {
			Connection conn = getConnection();
			
			int result = new UserInfoBoardDao().insertAddress(conn, sl);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		/**
		 * 13. 배송지 삭제
		 * @param 
		 * @return 			
		 *
		 */
		public int deleteAddress(int sno) {
			Connection conn = getConnection();
			
			int result = new UserInfoBoardDao().deleteAddress(conn,sno);
			
			if(result>0){
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

}
