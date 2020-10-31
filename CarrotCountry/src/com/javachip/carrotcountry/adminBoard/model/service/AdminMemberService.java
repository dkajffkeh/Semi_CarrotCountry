package com.javachip.carrotcountry.adminBoard.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminMemberDao;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;
import com.javachip.carrotcountry.common.JDBCtemplate;;

public class AdminMemberService {

	public ArrayList<AdminMember> userSelectAll() {

		Connection conn = getConnection();
		
		ArrayList<AdminMember> list = new AdminMemberDao().userSelectAll(conn);
		
		close(conn);
		
		return list;
	}
	
}
