package com.javachip.carrotcountry.shMarketBoard.townMarket.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.model.TownMarketDao;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

public class TownMarketService {
	

	public ArrayList<CategoryHY> CategorySelector() {
		
		Connection conn = getConnection();
		ArrayList<CategoryHY> list = new TownMarketDao().CategorySelector(conn);
		
		
		return list;
	}

	public ArrayList<PostBoard> mainArticleSelector(ShmarketPageInfo sp) {
		
		Connection conn = getConnection();
		ArrayList<PostBoard> boardList = new TownMarketDao().mainArticleSelector(conn,sp);
		
		
		return boardList;
	}

	public int increaseBoardViews(int bno) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().increaseBoardViews(conn,bno);
		
		if(result>0) {
			commit(conn);
			
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public PostBoard PostBoardDetailSelector(int bno) {
		
		Connection conn = getConnection();
		
		PostBoard pb = new TownMarketDao().PostBoardDetailSelector(conn,bno);
		
		close(conn);
		
		
		return pb;
	}

	public ArrayList<CommentHY> marketCommentSelector(int bno) {
		
		Connection conn = getConnection();
		ArrayList<CommentHY> list = new TownMarketDao().marketCommentSelector(conn,bno);
		
		close(conn);
		
		return list;
	}

	public int shBoardInsertComment(CommentHY c) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().shBoardInsertComment(conn,c);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int shMarketBoardInsert(PostBoard pb, ArrayList<PhotoBoardVo> list) {
		
		Connection conn = getConnection();
		
		int result1 = new TownMarketDao().shMarketBoardInsert(conn,pb,list);
		
		int result2 = new TownMarketDao().shMarketBordConditionInsert(conn,pb);
		
		int result3 = new TownMarketDao().shMarketPhotoInsert(conn,list);
		
		if(result1>0 && result2 >0 && result3>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public int townMarketDeleteForm(int bno) {
		
		Connection conn = getConnection();
		
		int result = new TownMarketDao().townMarketDeleteForm(conn,bno);
		
		if(result>0){
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<PhotoBoardVo> shMarketPhotoSelector(int bno) {
		
		Connection conn = getConnection();
		
		ArrayList<PhotoBoardVo> list = new TownMarketDao().shMarketPhotoSelector(bno,conn);	
		
		close(conn);
		
		return list;
	}

	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = 0;
		result = new TownMarketDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}

}
