package com.javachip.carrotcountry.coBuying.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

public class ProductDao {

private Properties prop = new Properties();
	
	public ProductDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(QnADao.class.getResource("/sql/coBuying/coBuying.xml").getPath()));
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int increaseCount(Connection conn, int bno) {
		
				int result = 0;
				
				PreparedStatement pstmt = null;
				
				String sql = prop.getProperty("increaseCount");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, bno);
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
				}
				
				return result;
				}
	
	
	
	
	public Product selectProduct(Connection conn, int bno) {
		// select문 => 한 행 
		Product p = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				p = new Product(rs.getInt("post_no"),
							  rs.getDate("post_enroll_date"),
							  rs.getDate("gp_deadline"),
							  rs.getInt("gp_minpeople"),
							  rs.getInt("gp_people"),
							  rs.getInt("gp_dprice"),
							  rs.getString("post_comment"),
							  rs.getString("post_refund"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return p;
		
	}
	
	
	
	public ArrayList<Option> selectOption(Connection conn, int bno){
			// select문 => 여러행
			ArrayList<Option> oList = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = prop.getProperty("selectOption");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, bno);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Option o = new Option();
					o.setOptionName(rs.getString("option_name"));
					oList.add(o);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return oList;
			
			
		}
		

	
	public ArrayList<Account> selectAccount(Connection conn, int bno){
		// select문 => 여러행
		ArrayList<Account> aList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectAccount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Account a = new Account();
				a.setAccount(rs.getString("account"));
				aList.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return aList;
		
		
	}
	
	
	
	public PostBoard selectThumbnail(Connection conn, int bno) {
		// select문 => 한 행 
		PostBoard pb = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pb = new PostBoard(rs.getInt("post_no"),
							  rs.getString("thumbnail_path"),
							  rs.getString("thumbnail_filename"),
							  rs.getString("thumbnail_loadpath"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return pb;
		
	}
	
	
	
	public ArrayList<Photo> selectPhoto(Connection conn, int bno){
		// select문 => 여러행
		ArrayList<Photo> ptList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectPhoto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Photo pt = new Photo();
				pt.setPostNo(rs.getInt("post_no"));
				pt.setPhotoPath(rs.getString("photo_path"));
				pt.setPhotoFileName(rs.getString("photo_filename"));
				pt.setPhotoLoadPath(rs.getString("photo_loadpath"));
				
				ptList.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return ptList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}