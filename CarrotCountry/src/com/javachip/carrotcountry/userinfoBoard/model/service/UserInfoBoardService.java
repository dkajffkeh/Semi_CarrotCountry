package com.javachip.carrotcountry.userinfoBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import com.javachip.carrotcountry.member.model.vo.Member;
import com.javachip.carrotcountry.userinfoBoard.model.dao.UserInfoBoardDao;
import com.javachip.carrotcountry.userinfoBoard.model.vo.Location;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;

import java.sql.Connection;
import java.util.ArrayList;


public class UserInfoBoardService {
	
	/**
	 * 1. 정보변경용 서비스
	 * @param m		변경할 내용들+변경요청한회원의아이디 가 담겨있는 객체
	 * @return		갱신된 회원 객체/null
	 */
	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new UserInfoBoardDao().updateMember(conn, m);
		
		Member updateMem = null;
		
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
	public ArrayList<ShippingLocation> selectShippingLocation(String memNo){
		
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
	public Location selectLocation(String memNo) {
		Connection conn = getConnection();
		Location lo = new UserInfoBoardDao().selectLocation(conn, memNo);
		close(conn);
		return lo;
		
	}
	
	
	

}
