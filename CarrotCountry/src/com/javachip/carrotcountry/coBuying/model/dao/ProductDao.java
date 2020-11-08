package com.javachip.carrotcountry.coBuying.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;
import com.javachip.carrotcountry.coBuying.model.vo.PostBoardJY;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;

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
				
				System.out.println(result);
				return result;
				}
	

	
	//
	public int selectProductListCount(Connection conn) {
		// select문 => int (총 갯수)
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProductListCount");
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {	
				listCount = rs.getInt("LISTCOUNT");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}
	

	
	//
	

	
	
	public PostBoard selectPostBoard(Connection conn, int bno) {
		// select문 => 한 행 
		PostBoard pb = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectPostBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pb = new PostBoard(rs.getInt("post_no"),
							  rs.getString("post_name"),
							  rs.getString("post_comment"),
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
	
	
	
	public Product selectProduct(Connection conn, int bno) {
		// select문 => 한 행 
		Product pd = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pd = new Product(rs.getInt("post_no"),
							  rs.getDate("POST_ENROLL_DATE"),
							  rs.getString("gp_deadline"),
							  rs.getInt("gp_minpeople"),
							  rs.getInt("gp_people"),
							  rs.getInt("gp_dprice"),
							  rs.getString("gp_refund"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return pd;
		
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
					o.setOptionNo(rs.getInt("option_no"));
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
				a.setAccount(rs.getString("bank"));
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
	
	
	public ArrayList<Product> selectMainProductList(Connection conn, PageInfo pi){
		// select문 => 여러행 조회
		ArrayList<Product> pList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMainProductList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pList.add(new Product(rs.getInt("post_no"),
										rs.getString("thumbnail_path"),
										rs.getString("thumbnail_filename"),
										rs.getString("thumbnail_loadpath"),
										rs.getString("post_name"),
										rs.getInt("gp_people"),
										rs.getInt("post_likes"),
										rs.getInt("gp_price"),
										rs.getInt("gp_drate"),
										rs.getInt("gp_dprice")));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
 		
		return pList;
		
	}
	
	
	

	// insert
	

	// 1. post
	public int insertProductPost(Connection conn, PostBoard pb) {
		// insert문 => 처리된 행 수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProductPost");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pb.getCategoryNo());
			pstmt.setInt(2, pb.getMemNo());
			pstmt.setString(3, pb.getMemNickname());
			pstmt.setString(4, pb.getPostName());
			pstmt.setString(5, pb.getPostContent());
			pstmt.setString(6, pb.getCategoryNo());
			pstmt.setString(7, pb.getThumbnailPath());
			pstmt.setString(8, pb.getThumbnailFilename());
			pstmt.setString(9, pb.getThumbnailLoadPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	// 2. group_purchase
	public int insertProductGroupPurchase(Connection conn, Product pd) {
		// insert문 => 처리된 행 수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProductGroupPurchase");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pd.getGpDeadline());
			pstmt.setInt(2, pd.getGpMinPeople());
			pstmt.setInt(3, pd.getGpPrice());
			pstmt.setInt(4, pd.getGpDRate());
			pstmt.setInt(5, pd.getGpDPrice());
			pstmt.setString(6, pd.getGpRefund());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
		// 3. location
		public int insertProductLocation(Connection conn, Location lo) {
			// insert문 => 처리된 행 수
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProductLocation");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, lo.getLocal_gu());
				pstmt.setString(2, lo.getLocal_dong());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
	
		
		// 4. option
		public int insertProductOption(Connection conn, String[] option) {
			// 여러번의 insert문 
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProductOption");
			
			try {
				
				for(int i=0; i<option.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, option[i]);
				result = pstmt.executeUpdate();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		// 5. account
		public int insertProductAccount(Connection conn, String[] account) {
			// 여러번의 insert문 
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProductAccount");
			
			try {
				
				for(int i=0; i<account.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account[i]);
				result = pstmt.executeUpdate();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
		// 6. photo
		public int insertProductPhoto(Connection conn, ArrayList<Photo> pList) {
			// 여러번의 insert문 
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProductPhoto");
			
			try {
				
				for(Photo pt : pList) {		
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, pt.getPhotoPath());
					pstmt.setString(2, pt.getPhotoFileName());
					pstmt.setString(3, pt.getPhotoLoadPath());
						
					result = pstmt.executeUpdate();
					
					if(result == 0) {
						return 0;
					}
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}finally {
				close(pstmt);
			}
			
			return result;
			
			
		}
		
		public int updateWishList(Connection conn, PostBoardJY pb) {
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("updateWishList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pb.getPostNo());

				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
			
		}

	
}
