package com.javachip.carrotcountry.jmboard.faq.model.dao;

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

import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

public class FaqDao {

	private Properties prop = new Properties();
	
	public FaqDao() {
		
		try {
			prop.loadFromXML(new FileInputStream
			(FaqDao.class.getResource("/sql/faq/faq-mapper.xml").getPath()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * FAQ리스트 Dao입니다.
	 * @param conn 
	 * @return
	 */
	public ArrayList<Faq> selectFaqList(Connection conn) {
		
		ArrayList<Faq> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaqList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Faq(
						         rset.getInt("faq_no"),
						         rset.getString("faq_title"),
						         rset.getString("faq_content"),
						         rset.getString("faq_category"),
						         rset.getDate("faq_enroll_date"),
						         rset.getString("faq_writer"),
						         rset.getString("faq_status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
//FAQ추가 (Null에러)
	public int insertFaq(Connection conn, Faq f) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getFaqContent());
			pstmt.setString(3, f.getCategory()); // 숫자로 변경해야함
			pstmt.setString(4, f.getFaqWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
//카운트
	public int increaseCount(Connection conn, int nno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성된 sql
			
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
//게시판
	public Faq selectFaq(Connection conn, int nno) {

		Faq f = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				f = new Faq(rset.getInt("faq_no"),
						    rset.getString("faq_title"),
						    rset.getString("faq_content"),
						    rset.getString("mem_name"),
						    rset.getDate("faq_enroll_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return f;
		
		
		
	}
	//update
	public int updateFaq(Connection conn, Faq f) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getFaqContent());
			pstmt.setInt(3, f.getFaqNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
		
		
		
	}
	
	
	
	
//faq게시판 삭제
	public int deleteFaq(Connection conn, int nno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
	    String sql = prop.getProperty("delectFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}

	
	
	

	

}
