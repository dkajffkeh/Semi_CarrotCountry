package com.javachip.carrotcountry.jmboard.faq.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.jmboard.faq.model.dao.FaqDao;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

public class FaqService {

	/**
	 * FAQ리스트 보기 
	 * @return list FAQ리스트 입니다.
	 */
	public ArrayList<Faq> selectFaqList() {
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectFaqList(conn);
		
		close(conn);
		
		return list;
	}




	
	
	

}
