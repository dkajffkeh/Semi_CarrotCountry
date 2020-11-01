package com.javachip.carrotcountry.member.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import com.javachip.carrotcountry.member.model.dao.MemberDao;
import com.javachip.carrotcountry.member.model.vo.Member;

import java.sql.Connection;

public class MemberService {
		


	/** 로그인
	 * @param memUserId
	 * @param memUserPwd
	 * @return
	 */
	public Member loginMember(String memUserId, String memUserPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, memUserId, memUserPwd);
		
		close(conn);
		
		return m;
		
	}
		
	/** 아이디 중복체크
	 * @param userId
	 * @return
	 */
	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return count;
	}
	
	/** 닉네임 중복체크
	 * @param nickName
	 * @return
	 */
	public int nickNameCheck(String nickName) {
		Connection conn = getConnection();
		
		int count = new MemberDao().nickNameCheck(conn, nickName);
		
		close(conn);
		
		return count;
		
	}
	
	/** 전화번호 중복체크
	 * @param phone
	 * @return
	 */
	public int phoneCheck(String phone) {
		Connection conn = getConnection();
		
		int count = new MemberDao().phoneCheck(conn, phone);
		
		close(conn);
		
		return count;
		
	}
	
	/** 회원가입
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);			
		}
		
		close(conn);
		
		return result;
		
	}
	
	/** 아이디찾기
	 * @param memName
	 * @param memBirthday
	 * @param memPhone
	 * @return
	 */
	public String findIdMember(String memName, String memBirthday, String memPhone) {
		
		Connection conn = getConnection();
		
		String findId = new MemberDao().findIdMember(conn, memName, memBirthday, memPhone);
		
		close(conn);
		
		return findId;
		
	}
	
	/** 비밀번호 찾기1
	 *  정보 입력후 -> 비밀번호 수정을 위해 유저넘버 반환
	 * @param m
	 * @return
	 */
	public int findPwdMember(Member m) {
		Connection conn = getConnection();
		
		int memNo = new MemberDao().findPwdMember(conn, m);
		
		close(conn);
		
		return memNo;
	}
	
	/** 비밀번호 찾기2
	 *  반환된 정보를 통해 비밀번호 변경
	 * @param memUserId
	 * @param memUserPwd
	 * @return
	 */
	public int updatePwdMember(String memUserId, String memUserPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, memUserId, memUserPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
		
		
		
}
