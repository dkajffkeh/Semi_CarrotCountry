package com.javachip.carrotcountry.jmboard.notice.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.javachip.carrotcountry.jmboard.notice.model.vo.Notice;
import com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(NoticeDao.class.getResource("/sql/jmboard/notice-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return listCount;
	}

	public ArrayList<Notice> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getNoticeLimit() + 1;
			int endRow = startRow + pi.getNoticeLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO"),
									rset.getString("MEM_USERID"),
									rset.getString("NOTICE_TITLE"),
									rset.getDate("NOTICE_ENROLL_DATE"),
									rset.getInt("NOTICE_COUNT")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		
		return list;
	}

	public int insertNotice(Connection conn, Notice n) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(n.getMemNo()));
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4, n.getFilePath());
			pstmt.setString(5, n.getFileModifyName());
			pstmt.setString(6, n.getFileOriginName());
			
			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int increaseCount(Connection conn, int nno) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Notice selectNotice(Connection conn, int nno) {
		
		Notice n = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			// 제목 작성자 작성일 내용 첨부파일
			if(rset.next()) {
				n = new Notice(rset.getInt("NOTICE_NO"),
							   rset.getString("MEM_USERID"),
							   rset.getString("NOTICE_TITLE"),
							   rset.getString("NOTICE_CONTENT"),
							   rset.getString("FILE_PATH"),
							   rset.getDate("NOTICE_ENROLL_DATE"),
							   rset.getString("FILE_MODIFYNAME"),
							   rset.getString("FILE_ORIGINNAME"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			
		}
		
		return n;
		
	}

	public int updateNotice(Connection conn, Notice n) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getFilePath());
			pstmt.setString(4, n.getFileModifyName());
			pstmt.setString(5, n.getFileOriginName());
			pstmt.setInt(6, n.getNoticeNo());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int deleteNotice(Connection conn, int nno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
	    String sql = prop.getProperty("deleteNotice");
		
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













