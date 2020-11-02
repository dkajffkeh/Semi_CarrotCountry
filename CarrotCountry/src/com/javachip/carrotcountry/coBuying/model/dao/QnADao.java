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
						rs.getString("gq_title"),
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
	
	
	public int insertQuestion(Connection conn, QnA qa) {
		// insert문 => 처리된 행 수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQuestion");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qa.getGqTitle());
			pstmt.setString(2, qa.getGqContent());
			pstmt.setString(3, qa.getMemNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int increaseQnACount(Connection conn, int bno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseQnACount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public QnA selectQnADetail(Connection conn, int bno) {
		
		QnA qa = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectQnADetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qa = new QnA(rs.getInt("gq_no"),
							 rs.getString("gq_title"),
							 rs.getString("mem_name"),
							 rs.getDate("gq_enrolldate"),
							 rs.getString("gq_content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return qa;
	}
	
	
	public int updateBuyerQnA(Connection conn, QnA qa) {
		// update문 => 처리된 행 수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBuyerQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qa.getGqTitle());
			pstmt.setString(2, qa.getGqContent());
			pstmt.setInt(3, qa.getGqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	
	public int deleteBuyerQnA(Connection conn, int bno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBuyerQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
}
