package com.javachip.carrotcountry.coBuying.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;

import com.javachip.carrotcountry.coBuying.model.dao.PurchaseInfoDao;
import com.javachip.carrotcountry.coBuying.model.vo.PurchaseInfo;

public class PurchaseInfoService {

	public int insertPurchaseInfo(PurchaseInfo pi) {
		
		Connection conn = getConnection();
		
		int result = new PurchaseInfoDao().insertPurchaseInfo(conn, pi);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
