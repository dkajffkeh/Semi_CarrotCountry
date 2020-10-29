package com.javachip.carrotcountry.coBuying.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.coBuying.model.dao.QnADao;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class QnAService {

	public ArrayList<QnA> selectQnAList(){
			
			Connection conn = getConnection();
			
			ArrayList<QnA> list = new QnADao().selectQnAList(conn);
			
			close(conn);
			
			return list;
			
		}
	
	
	
	
}
