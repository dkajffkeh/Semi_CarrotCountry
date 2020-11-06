package com.javachip.carrotcountry.userinfoBoard.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import com.javachip.carrotcountry.member.model.vo.Member;
import com.javachip.carrotcountry.userinfoBoard.model.vo.CobuyingPost;
import com.javachip.carrotcountry.userinfoBoard.model.vo.Location;
import com.javachip.carrotcountry.userinfoBoard.model.vo.PageInfo;
import com.javachip.carrotcountry.userinfoBoard.model.vo.SaleProduct;
import com.javachip.carrotcountry.userinfoBoard.model.vo.UserinfoMember;
import com.javachip.carrotcountry.userinfoBoard.model.vo.WishList;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;


public class UserInfoBoardDao {
	
	private Properties prop = new Properties();
	
	public UserInfoBoardDao() {
		
		String fileName = UserInfoBoardDao.class.getResource("/sql/userinfoBoard/userinfoBoard.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 회원정보수정
	public int updateMember(Connection conn, UserinfoMember m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getMemGender());
			pstmt.setString(3, m.getMemBirthday());
			pstmt.setString(4, m.getMemNickname());
			pstmt.setString(5, m.getMemPhone());
			pstmt.setString(6, m.getLocalNo());
			pstmt.setString(7, m.getMemEmail());
			pstmt.setString(8, m.getMemUserId());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public UserinfoMember selectMember(Connection conn, String userId) {
		UserinfoMember m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new UserinfoMember
						(rset.getInt("MEM_NO"),
						 rset.getString("LOCAL_NO"),
						 rset.getString("MEM_USERID"),
						 rset.getString("MEM_USERPWD"),
						 rset.getString("MEM_NAME"),
						 rset.getString("MEM_NICKNAME"),
						 rset.getString("MEM_BIRTHDAY"),
						 rset.getString("MEM_GENDER"),
						 rset.getString("MEM_PHONE"),
						 rset.getString("MEM_EMAIL"),
						 rset.getDate("MEM_ENROLL_DATE"),
						 rset.getString("B_LIST_CHECK"),
						 rset.getString("LEAVE_CHECK"),
						 rset.getString("MANAGER_CHECK"),
						 rset.getString("PROFILE_PATH"),
						 rset.getString("PROFILE_MODIFYNAME"),
						 rset.getString("PROFILE_ORIGNNAME"),
						 rset.getString("PROFILE_LOADNAME"),
						 rset.getString("LOCAL_SI"),
						 rset.getString("LOCAL_GU"),
						 rset.getString("LOCAL_DONG")
						);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
	// 회원 탈퇴
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	
	}
	
	public ArrayList<ShippingLocation> selectShippingLocation(Connection conn, int memNo) {
		
		ArrayList<ShippingLocation> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShippingLocation");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) { 
					ShippingLocation sl = new ShippingLocation();
					
					sl.setShippingNo(rset.getInt("shipping_no"));
					sl.setMemNo(rset.getInt("mem_no"));
					sl.setShippingAddress(rset.getString("shipping_address"));
					sl.setMemUserName(rset.getString("mem_username"));
					sl.setMemPhone(rset.getString("mem_phone"));
					sl.setShippingDefault(rset.getNString("shipping_default"));
				
					list.add(sl);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public Location selectLocation(Connection conn, int memNo) {
		
		Location lo = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLocation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				lo = new Location(rset.getString("local_no"),
								  rset.getString("local_si"),
								  rset.getString("local_gu"),
								  rset.getString("local_dong"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return lo;
	}
	
	// 공동구매 내게시글 조회
	public ArrayList<CobuyingPost> selectCobuyingList(Connection conn, PageInfo pi, int memNo){
		// select문 => 여러행 => ArrayList
		ArrayList<CobuyingPost> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCobuyingPostList");
		
		try {
			pstmt = conn.prepareStatement(sql); 
	
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new CobuyingPost(rset.getInt("POST_NO"),
								 		  rset.getString("POST_NAME"),
								 		  rset.getDate("GP_CREATEDATE"),
								 		  rset.getString("GP_STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int selectListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCobuyingListCount");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public ArrayList<WishList> selectWishList(Connection conn ,PageInfo pi, int memNo){
		
		ArrayList<WishList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectWihsiList");
		
		try {
			pstmt = conn.prepareStatement(sql); 
	
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				WishList w = new WishList();
				w.setMemNo(rset.getInt("MEM_NO"));
				w.setPostLikes(rset.getInt("POST_LIKES"));
				w.setPostName(rset.getString("POST_NAME"));
				w.setProdPrice(rset.getInt("PROD_PRICE"));
				w.setBlindCheck(rset.getString("BLIND_CHECK"));
				w.setThumbNailPath(rset.getString("BLIND_CHECK"));
				w.setThumbNailFileName(rset.getString("BLIND_CHECK"));
				w.setThumbNailLoadPath(rset.getString("BLIND_CHECK"));

				
				list.add(w);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
		
	}
	
	// 판매완료 조회
	public ArrayList<SaleProduct> selectCompletedSales(Connection conn, int memNo, PageInfo pi){

		ArrayList<SaleProduct> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCompletedSales");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) { 
					SaleProduct sp = new SaleProduct();
					
					sp.setPostNo(rset.getInt("POST_NO"));
					sp.setMemNo(rset.getInt("MEM_NO"));
					sp.setPostName(rset.getString("POST_NAME"));
					sp.setProdPrice(rset.getInt("PROD_PRICE"));
					sp.setProdStatus(rset.getString("PROD_STATUS"));
					sp.setPostEnrollDate(rset.getDate("POST_ENROLL_DATE"));
					sp.setThumbNailPath(rset.getString("THUMBNAIL_PATH"));
					sp.setThumbNailFileName(rset.getNString("THUMBNAIL_FILENAME"));
					
					list.add(sp);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	// 판매완료 삭제
	
	public int deleteCompletedSales(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCompletedSales");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}
	
	// 판매중 조회
	public ArrayList<SaleProduct> selectOnSales(Connection conn, int memNo, PageInfo pi){

		ArrayList<SaleProduct> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOnSales");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) { 
					SaleProduct sp = new SaleProduct();
					
					sp.setPostNo(rset.getInt("POST_NO"));
					sp.setMemNo(rset.getInt("MEM_NO"));
					sp.setPostName(rset.getString("POST_NAME"));
					sp.setProdPrice(rset.getInt("PROD_PRICE"));
					sp.setProdStatus(rset.getString("PROD_STATUS"));
					sp.setPostEnrollDate(rset.getDate("POST_ENROLL_DATE"));
					sp.setThumbNailPath(rset.getString("THUMBNAIL_PATH"));
					sp.setThumbNailFileName(rset.getNString("THUMBNAIL_FILENAME"));
					
					list.add(sp);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	//판매중 삭제
	
	public int deleteOnSales(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteOnSales");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}
	
	//판매중 변경
	
	public int updateOnSales(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateOnSales");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	
	}
	
	
	

}
