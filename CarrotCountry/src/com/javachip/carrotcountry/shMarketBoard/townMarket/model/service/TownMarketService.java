package com.javachip.carrotcountry.shMarketBoard.townMarket.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.model.TownMarketDao;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY;

public class TownMarketService {
	

	public ArrayList<CategoryHY> CategorySelector() {
		
		Connection conn = getConnection();
		ArrayList<CategoryHY> list = new TownMarketDao().CategorySelector(conn);
		
		
		return list;
	}

	public ArrayList<PostBoard> MainArticleSelector() {
		
		Connection conn = getConnection();
		ArrayList<PostBoard> boardList = new TownMarketDao().MainArticleSelector(conn);
		
		
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

}
