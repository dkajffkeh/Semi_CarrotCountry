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
	
	
	
}
