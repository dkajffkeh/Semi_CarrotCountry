package com.javachip.carrotcountry.jmboard.faq.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

public class FaqDao {

	private Properties prop = new Properties();
	
	public FaqDao() {
		
		try {
			prop.loadFromXML(new FileInputStream
			(FaqDao.class.getResource("sql/faq/faq-mapper.xml").getPath()));
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


	
	
	

	

}
