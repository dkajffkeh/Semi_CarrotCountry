package com.javachip.carrotcountry.adminBoard.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

}
