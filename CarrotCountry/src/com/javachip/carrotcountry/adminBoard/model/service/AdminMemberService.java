package com.javachip.carrotcountry.adminBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminMemberDao;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.common.JDBCtemplate;;

public class AdminMemberService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminMemberDao().selectListCount(conn);
		
		if (listCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<AdminMember> userSelectAll(AdminPageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new AdminMemberDao().userSelectAll(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public int blackListEnroll(String memNo, String bList) {
		
		Connection conn = getConnection();
		
		int result = new AdminMemberDao().blackListEnroll(conn, memNo, bList);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return 0;
	}

	public ArrayList<AdminMember> blackListSelectAll(AdminPageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new AdminMemberDao().blackListSelectAll(conn, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<AdminMember> userSearchList(AdminPageInfo pi, String category, String search) {
		
		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new AdminMemberDao().userSearchList(conn, pi, category, search);
		
		close(conn);
		
		return list;
	}

	public ArrayList<AdminMember> blackListSearch(AdminPageInfo pi, String category, String search) {

		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new AdminMemberDao().blackListSearch(conn, pi, category, search);
		
		close(conn);
		
		return list;
	}
	
}
