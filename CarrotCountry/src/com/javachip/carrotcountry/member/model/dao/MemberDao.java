package com.javachip.carrotcountry.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import com.javachip.carrotcountry.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 로그인
	public Member loginMember(Connection conn, String memUserId, String memUserPwd) {
		// select문 => ResultSet 한 행
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memUserId);
			pstmt.setString(2, memUserPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member
						(rset.getInt("MEM_NO"),
						 rset.getInt("LOCAL_NO"),
						 rset.getString("MEM_USERID"),
						 rset.getString("MEM_USERPWD"),
						 rset.getString("MEM_NAME"),
						 rset.getString("MEM_NICKNAME"),
						 rset.getString("MEM_BIRTHDAY"),
						 rset.getString("MEM_GENDER"),
						 rset.getString("MEM_PHONE"),
						 rset.getString("MEM_EMAIL"),
						 rset.getString("MEM_LOCATION"),
						 rset.getDate("MEM_ENROLL_DATE"),
						 rset.getString("B_LIST_CHECK"),
						 rset.getString("LEAVE_CHECK"),
						 rset.getString("MANAGER_CHECK")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	// 아이디 중복체크
	public int idCheck(Connection conn, String userId) {
		// SELECT문 => 한 행 (count)
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	// 닉네임 중복체크
	public int nickNameCheck(Connection conn, String nickName) {
		// SELECT문 => 한 행 (count)
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nickNameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	// 전화번호 중복체크
	public int phoneCheck(Connection conn, String phone) {
		// SELECT문 => 한 행 (count)
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("phoneCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, phone);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return count;	
	}
	
	
	
	// 회원가입
	public int insertMember(Connection conn, Member m) {
		// INSERT문 => result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getLocalNo());
			pstmt.setString(2, m.getMemUserId());
			pstmt.setString(3, m.getMemUserPwd());
			pstmt.setString(4, m.getMemName());
			pstmt.setString(5, m.getMemNickname());
			pstmt.setString(6, m.getMemBirthday());
			pstmt.setString(7, m.getMemGender());
			pstmt.setString(8, m.getMemPhone());
			pstmt.setString(9, m.getMemEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 아이디 찾기
	public String findIdMember(Connection conn, String memName, String memBirthday, String memPhone) {
		// SELECT문 => 한 행
		String findId = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findIdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memName);
			pstmt.setString(2, memBirthday);
			pstmt.setString(3, memPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				findId = rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return findId;
		
	}
	
	public int findPwdMember(Connection conn, Member m) {
		// SELECT문 -> 한 행
		int memNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findPwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getMemUserId());
			pstmt.setString(3, m.getMemBirthday());
			pstmt.setString(4, m.getMemPhone());
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				memNo = rset.getInt("MEM_NO");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return memNo;
	}
	
	public int updatePwdMember(Connection conn, String memUserId, String memUserPwd) {
		// UPDATE문 => result
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memUserPwd);
			pstmt.setString(2, memUserId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int myPwdUpdate(Connection conn, String userId, String myPwd, String updatePwd) {
		// UPDATE문 => result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("myPwdUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, myPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
}
