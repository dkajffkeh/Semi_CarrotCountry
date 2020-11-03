package com.javachip.carrotcountry.adminBoard.model.dao;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminReport;

public class AdminReportDao {
	
	private Properties prop = new Properties();
	
	public AdminReportDao() {
		
		String fileName = AdminReportDao.class.getResource("/sql/adminBoard/adminReport-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<AdminReport> reportListSelectAll(Connection conn, AdminPageInfo pi) {

		ArrayList<AdminReport> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reportListSelectAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				AdminReport ar = new AdminReport();
				
				ar.setReportNo(rset.getInt("report_no"));
				ar.setReportDate(rset.getDate("report_date"));
				ar.setReportTypeNo(rset.getString("report_type_name"));
				ar.setReportPostNo(rset.getString("report_post_no"));
				ar.setPostName(rset.getString("post_name"));
				ar.setReportReason(rset.getString("report_reason"));
				ar.setMemNo(rset.getString("mem_userid"));
				
				list.add(ar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<AdminReport> reportSearchList(Connection conn, AdminPageInfo pi, String category, String search) {

		ArrayList<AdminReport> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reportSearchList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, "mem_userid".equals(category) ? search : "");
			pstmt.setString(2, "report_type_name".equals(category) ? search : "");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				AdminReport ar = new AdminReport();
				
				ar.setReportNo(rset.getInt("report_no"));
				ar.setReportDate(rset.getDate("report_date"));
				ar.setReportTypeNo(rset.getString("report_type_name"));
				ar.setReportPostNo(rset.getString("report_post_no"));
				ar.setPostName(rset.getString("post_name"));
				ar.setReportReason(rset.getString("report_reason"));
				ar.setMemNo(rset.getString("mem_userid"));
				
				list.add(ar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
