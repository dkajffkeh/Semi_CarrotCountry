package com.javachip.carrotcountry.shMarketBoard.townMarket.model.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

public class TownMarketDao {
	
	
Properties prop = new Properties();
	
	public TownMarketDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(TownMarketDao.class.getResource("/sql/shMarket/shMarket.xml").getPath()));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public ArrayList<CategoryHY> CategorySelector(Connection conn) {
		
		ArrayList<CategoryHY> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("CategorySelector");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryHY c = new CategoryHY(rs.getString("CATEGORY_NAME"));
				
				list.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}
	

	public int selectListCount(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("BOARD_COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<PostBoard> mainArticleSelector(Connection conn,ShmarketPageInfo sp) {
		
		ArrayList<PostBoard> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startNum = (sp.getCurrentPage()-1)*sp.getBoardLimit()+1;
		int endRow = startNum + sp.getBoardLimit() -1;
		
		String sql = prop.getProperty("MainArticleSelector");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostBoard pb = new PostBoard(rs.getInt("POST_NO")
											,rs.getInt("MEM_NO")
											,rs.getString("LOCATION")
											,rs.getString("POST_NAME")
											,rs.getString("CATEGORY_NAME")
											,rs.getString("THUMBNAIL_PATH")
											,rs.getString("THUMBNAIL_FILENAME")
											,rs.getString("THUMBNAIL_LOADPATH")
											,rs.getInt("POST_VIEWS")
											,rs.getInt("POST_LIKES")
											,rs.getInt("PROD_PRICE"));
				list.add(pb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}


	public int increaseBoardViews(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseBoardViews");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	public PostBoard PostBoardDetailSelector(Connection conn, int bno) {
		
		
		PostBoard pb = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("PostBoardDetailSelector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pb = new PostBoard();
				
				pb.setPostNo(rs.getInt("POST_NO"));
				pb.setCategoryNo(Integer.toString(rs.getInt("CATEGORY_NO")));
				pb.setMemNo(rs.getInt("MEM_NO"));
				pb.setLocalNo(rs.getString("LOCATION"));
				pb.setMemNickname(rs.getString("MEM_NICKNAME"));
				pb.setPostName(rs.getString("POST_NAME"));
				pb.setPostContent(rs.getString("POST_COMMENT"));
				pb.setCategoryName(rs.getString("CATEGORY_NAME"));
				pb.setProdStatus(rs.getString("PROD_STATUS"));
				pb.setDealType(rs.getString("DEAL_TYPE"));
				pb.setSite(rs.getString("site"));
				pb.setThumbnailPath(rs.getString("THUMBNAIL_PATH"));
				pb.setThumbnailFilename(rs.getString("THUMBNAIL_FILENAME"));
				pb.setThumbnailLoadPath(rs.getString("THUMBNAIL_LOADPATH"));
				pb.setPostViews(rs.getInt("post_views"));
				pb.setPostLikes(rs.getInt("post_likes"));
				pb.setProdPrice(rs.getInt("prod_price"));
				pb.setEnrollDate(rs.getDate("POST_ENROLL_DATE"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return pb;
	}

	
	public ArrayList<CommentHY> marketCommentSelector(Connection conn, int bno){
		
		ArrayList<CommentHY> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("marketCommentSelector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CommentHY c = new CommentHY(rs.getInt("comm_no")
										   ,rs.getString("user_nickname")
										   ,rs.getDate("ent_date")
										   ,rs.getString("content")
										   ,rs.getString("private")
										   ,rs.getInt("post_no")
										   );
				list.add(c);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list ;
	}


	public int shBoardInsertComment(Connection conn, CommentHY c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shBoardInsertComment");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getUserNickName());
			pstmt.setString(2, c.getContent());
			pstmt.setString(3, c.getSecretCheck());
			pstmt.setInt(4, c.getPostNo());
			pstmt.setInt(5, c.getMemNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int shMarketBoardInsert(Connection conn, PostBoard pb, ArrayList<PhotoBoardVo> list) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shMarketBoardInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
		    pstmt.setInt(1, Integer.parseInt(pb.getCategoryNo()));
		    pstmt.setInt(2, pb.getMemNo());
		    pstmt.setString(3, pb.getMemNickname());
		    pstmt.setString(4, pb.getPostName());
		    pstmt.setString(5, pb.getPostContent());
		    pstmt.setInt(6,Integer.parseInt(pb.getCategoryNo()));
		    pstmt.setString(7, list.get(0).getPhotoPath());
		    pstmt.setString(8, list.get(0).getPhotoFileName());
		    pstmt.setString(9, list.get(0).getPhotoLoadPath());
		    pstmt.setInt(10, pb.getProdPrice());
		    
		    result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} close (pstmt);
		
		
		return result;
	}

	public int shMarketBordConditionInsert(Connection conn,PostBoard pb) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shMarketBordConditionInsert");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pb.getProdStatus());
			pstmt.setInt(2, pb.getProdPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		 } finally { 
			 close(pstmt);
		 }
		
		return result;
	}
	
	
	
	public int shMarketPhotoInsert(Connection conn, ArrayList<PhotoBoardVo> list) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shMarketPhotoInsert");
		
		try {
			
		for(PhotoBoardVo pbv : list) {	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pbv.getPhotoPath());
			pstmt.setString(2, pbv.getPhotoFileName());
			pstmt.setString(3, pbv.getPhotoLoadPath());
			
			result = pstmt.executeUpdate();
			
			if(result==0) {
				return 0;
			}
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int townMarketDeleteForm(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("townMarketDeleteForm");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	public ArrayList<PhotoBoardVo> shMarketPhotoSelector(int bno, Connection conn) {
		
		ArrayList<PhotoBoardVo> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("shMarketPhotoSelector");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PhotoBoardVo pbv = new PhotoBoardVo();
				pbv.setPhotoPath(rs.getString("PHOTO_PATH"));
				pbv.setPhotoFileName(rs.getString("PHOTO_FILENAME"));
				
				list.add(pbv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}


	public int postStatusUpdate(Connection conn, int bno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("postStatusUpdate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
				
		return result;
	}


	public int dibsCheck(Connection conn, int bno, int userNo) {
		
		int checking = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("dibsCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checking = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return checking;
	}


	public int insertLike(Connection conn, int bno, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}


	public ArrayList<Integer> likeCountSelector(Connection conn, ShmarketPageInfo sp) {
		
		ArrayList<Integer> likeCount = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("likeCountSelector");
		
		int startNum = (sp.getCurrentPage()-1)*sp.getBoardLimit()+1;
		int endRow = startNum + sp.getBoardLimit() -1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endRow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				likeCount.add(rs.getInt("LIKECOUNT"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return likeCount;
	}


	public int insertPostBoardLike(Connection conn, int bno, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPostBoardLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public CommentHY shMarketBoardCommentSelector(Connection conn, CommentHY c) {
		
		CommentHY newc = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("shMarketBoardCommentSelector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getMemNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				newc = new CommentHY();
				newc.setUserNickName(rs.getString("USER_NICKNAME"));
				newc.setEnrollDate(rs.getDate("ENT_DATE"));
				newc.setContent(rs.getString("CONTENT"));
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return newc;
	}
	
}
