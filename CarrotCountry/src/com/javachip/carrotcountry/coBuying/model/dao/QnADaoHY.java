package com.javachip.carrotcountry.coBuying.model.dao;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.coBuying.model.vo.QnAHY;


public class QnADaoHY {

private Properties prop = new Properties();
	
	public QnADaoHY() {
		
		try {
			prop.loadFromXML(new FileInputStream(QnADao.class.getResource("/sql/coBuying/coBuyingHY.xml").getPath()));
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int SellerQnAInsert(Connection conn, int qno, String content) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("SellerQnAInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, qno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	
			close(pstmt);		
		}

		return result;
	}

	public QnAHY qnaSelector(Connection conn, int qno) {
		
		QnAHY qa = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("qnaSelector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				qa = new QnAHY(rs.getInt("GQ_NO")
						       ,rs.getInt("POST_NO")
						      ,rs.getString("GQ_TITLE")
						      ,rs.getString("MEM_NAME")
						      ,rs.getDate("GQ_ENROLLDATE")
						      ,rs.getString("GQ_CONTENT")
						      ,rs.getString("GQ_ANSWER")
						);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return qa;
	}
	
	
	
}
