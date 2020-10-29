package com.javachip.carrotcountry.jmboard.faq.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

public class FaqDao {

	private Properties prop = new Properties();
	
	public FaqDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(FaqDao.class.getResource("sql/faqBoard/faqBoard-mapper.xml").getPath()));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Faq(
						         rset.getInt("faq_no"),
						         rset.getString("mem_name"),
						         rset.getString("faq_title"),
						         rset.getString("faq_content"),
						         rset.getDate("faq_enroll_date"),
						         rset.getString("faq_category")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int insertFaq(Connection conn, Faq f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

	

}
