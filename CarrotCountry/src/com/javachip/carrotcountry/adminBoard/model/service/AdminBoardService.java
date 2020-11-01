package com.javachip.carrotcountry.adminBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminBoardDao;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;

public class AdminBoardService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminBoardDao().selectListCount(conn);
		
		if (listCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<AdminBoard> postSelectAll(AdminPageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<AdminBoard> list = new AdminBoardDao().postSelectAll(conn, pi);
		
		close(conn);

		return list;
	}

	public int blindListEnroll(int postNo, String bCheck) {
		
		Connection conn = getConnection();
		
		int result = new AdminBoardDao().blindListEnroll(conn, postNo, bCheck);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<AdminBoard> blindListSelectAll(AdminPageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminBoard> list = new AdminBoardDao().blindListSelectAll(conn, pi);
		
		close(conn);
		
		return list;
	}
	
}
