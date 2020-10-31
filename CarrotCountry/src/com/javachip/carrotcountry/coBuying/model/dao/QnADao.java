package com.javachip.carrotcountry.coBuying.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class QnADao {
	
	private Properties prop = new Properties();
	
	public QnADao() {
		
		try {
			prop.loadFromXML(new FileInputStream(QnADao.class.getResource("/sql/coBuying/coBuying.xml").getPath()));
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int selectQnAListCount(Connection conn) {
		// select문 => int (총 갯수)
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectQnAListCount");
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {	
				listCount = rs.getInt("LISTCOUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}
	
	
	
	
	public ArrayList<QnA> selectQnAList(Connection conn, PageInfo pi){
		// select문 => 여러행 => ArrayList
		
		ArrayList<QnA> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectQnAList");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new QnA(rs.getInt("gq_no"),
						rs.getString("mem_userid"),
						rs.getString("gq_content"),
						rs.getInt("gq_views"),
						rs.getDate("gq_enrolldate")));
}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}