package com.javachip.carrotcountry.adminBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;
import static com.javachip.carrotcountry.common.JDBCtemplate.commit;
import static com.javachip.carrotcountry.common.JDBCtemplate.getConnection;
import static com.javachip.carrotcountry.common.JDBCtemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminReportDao;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminReport;

public class AdminReportService {

	public ArrayList<AdminReport> reportListSelectAll(AdminPageInfo pi) {
	
		Connection conn = getConnection();
		
		ArrayList<AdminReport> list = new AdminReportDao().reportListSelectAll(conn, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<AdminReport> reportSearchList(AdminPageInfo pi, String category, String search) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminReport> list = new AdminReportDao().reportSearchList(conn, pi, category, search);
		
		close(conn);
		
		return list;
	}
	
}
