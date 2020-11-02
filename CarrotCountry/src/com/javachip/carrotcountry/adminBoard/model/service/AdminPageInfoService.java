package com.javachip.carrotcountry.adminBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminPageInfoDao;

public class AdminPageInfoService {
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminPageInfoDao().selectListCount(conn);
		
		if (listCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return listCount;
}

}
