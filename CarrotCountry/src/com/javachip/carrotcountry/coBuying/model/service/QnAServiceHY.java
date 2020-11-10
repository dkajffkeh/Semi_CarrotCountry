package com.javachip.carrotcountry.coBuying.model.service;
import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;

import com.javachip.carrotcountry.coBuying.model.dao.QnADaoHY;
import com.javachip.carrotcountry.coBuying.model.vo.QnAHY;

public class QnAServiceHY {

	public int SellerQnAInsert(int qno, String content) {
		
		Connection conn = getConnection();
		
		int result = new QnADaoHY().SellerQnAInsert(conn,qno,content);
		
		if(result>0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);			
		}
		
		close(conn);
		
		return result;
	}

	public QnAHY qnaSelector(int qno) {
		
		Connection conn = getConnection();
		
		QnAHY q= new QnADaoHY().qnaSelector(conn,qno);
		
		
		close(conn);
		
		return q;
	}

}
