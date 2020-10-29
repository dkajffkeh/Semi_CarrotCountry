package com.javachip.carrotcountry.coBuying.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.coBuying.model.vo.QnA;

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
	
	
	public ArrayList<QnA> selectQnAList(Connection conn){
		// select문 => 여러행 조회 => ArrayList
		ArrayList<QnA> list = new ArrayList<>(); // 텅빈상태
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectQnAList");
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
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
			close(stmt);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
