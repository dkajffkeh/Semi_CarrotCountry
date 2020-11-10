package com.javachip.carrotcountry.coBuying.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.javachip.carrotcountry.common.JDBCtemplate.close;

import com.javachip.carrotcountry.coBuying.model.vo.PurchaseInfo;

public class PurchaseInfoDao {
	
	private Properties prop = new Properties();
	
	public PurchaseInfoDao() {
		
		String fileName = PurchaseInfoDao.class.getResource("/sql/coBuying/purchaseInfo-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int insertPurchaseInfo(Connection conn, PurchaseInfo pi) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertPurchaseInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pi.getPostNo());
			pstmt.setInt(2, pi.getMemNo());
			pstmt.setInt(3, pi.getShippingNo());
			pstmt.setInt(4, pi.getOptionNo());
			pstmt.setString(5, pi.getDepositor());
			pstmt.setInt(6, pi.getPurchasePrice());
			pstmt.setString(7, "");
			pstmt.setString(8, "");
			pstmt.setString(9, pi.getRequests());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int increasePeople(Connection conn, int postNo) {

		int gpPeople = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increasePeople");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setInt(1, postNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return gpPeople;
	}

}
