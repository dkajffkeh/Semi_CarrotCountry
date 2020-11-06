package com.javachip.carrotcountry.userinfoBoardNg.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyReport;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.RepPageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class UserInfoBoardDaoNg {

	private Properties prop = new Properties();
	
	public UserInfoBoardDaoNg() {
		
		String fileName = UserInfoBoardDaoNg.class.getResource("/sql/userinfoBoardNg/userinfoBoardNg.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// 마이페이지 나의 신고 전체 수 조회
	public int selectRepListCount(Connection conn, int memNo) {
		// SELECT문 => (수)한 행
		
		int repListCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRepListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				repListCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return repListCount;
	}
	
	public ArrayList<MyReport> selectRepList(Connection conn, RepPageInfo pi, int memNo){
		// SELECT문 => 여러행
		ArrayList<MyReport> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRepList");
		
		try {
			
			int repStartRow = (pi.getRepCurrentPage() - 1) * pi.getRepBoardLimit() + 1;
			int repEndRow = repStartRow + pi.getRepBoardLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, repStartRow);
			pstmt.setInt(3, repEndRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new MyReport(rset.getInt("RNUM"),
						 			  rset.getInt("REPORT_NO"),
						 			  rset.getString("POST_NAME"),
						 			  rset.getString("REPORT_TYPE_NAME"),
						 			  rset.getString("REPORT_REASON"),
						 			  rset.getString("MEM_NICKNAME"),
						 			  rset.getDate("REPORT_DATE"),
						 			  rset.getString("REPORT_CHECK"),
						 			  rset.getString("REPORT_CONTENT"),
						 			  rset.getInt("REPORT_POST_NO")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int updateRep(Connection conn, int memNo, int reportNo, String reportContent) {
		// UPDATE문 => result
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateRep");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reportContent);
			pstmt.setInt(2, memNo);
			pstmt.setInt(3, reportNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;

	}
	
	
	
	
	
}
