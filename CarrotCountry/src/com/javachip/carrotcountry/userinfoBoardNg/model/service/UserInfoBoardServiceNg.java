package com.javachip.carrotcountry.userinfoBoardNg.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.userinfoBoardNg.model.dao.UserInfoBoardDaoNg;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyReport;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.RepPageInfo;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class UserInfoBoardServiceNg {

	
	public int selectRepListCount(int memNo) {
		Connection conn = getConnection();
		
		int repListCount = new UserInfoBoardDaoNg().selectRepListCount(conn, memNo);
		
		close(conn);
		
		return repListCount;
		
	}
	
	public ArrayList<MyReport> selectRepList(RepPageInfo pi, int memNo){
		Connection conn = getConnection();
		
		ArrayList<MyReport> list = new UserInfoBoardDaoNg().selectRepList(conn, pi, memNo);
		
		close(conn);
		
		return list;
		
	}
	
	
}
