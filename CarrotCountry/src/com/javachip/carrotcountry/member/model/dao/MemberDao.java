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
		// select문 ==> ResultSet 한 행
		
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
	
	
}
