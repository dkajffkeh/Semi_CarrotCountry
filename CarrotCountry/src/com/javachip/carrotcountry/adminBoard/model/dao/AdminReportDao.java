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
	
	public int selectListCount(Connection conn) {

		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if (rset.next()) {
				listCount = rset.getInt("listCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
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
