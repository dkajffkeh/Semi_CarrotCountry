package com.javachip.carrotcountry.adminBoard.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class AdminMemberDao {
	
	private Properties prop = new Properties();
	
	public AdminMemberDao() {
		
		String fileName = AdminMemberDao.class.getResource("/sql/adminBoard/adminMember-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<AdminMember> userSelectAll(Connection conn) {

		ArrayList<AdminMember> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("userSelectAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				AdminMember am = new AdminMember();
				am.setMemNo(rset.getInt("mem_no"));
				am.setMemUserId(rset.getString("mem_userid"));
				am.setMemName(rset.getString("mem_name"));
				am.setMemBirthday(rset.getString("mem_birthday"));
				am.setMemPhone(rset.getString("mem_phone"));
				am.setMemEmail(rset.getString("mem_email"));
				am.setMemEnrollDate(rset.getDate("mem_enroll_date"));
				am.setbListCheck(rset.getString("b_list_check"));
				
				list.add(am);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
