package com.javachip.carrotcountry.jmboard.notice.model.service;

import static com.javachip.carrotcountry.common.JDBCtemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.javachip.carrotcountry.adminBoard.model.dao.AdminMemberDao;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.jmboard.faq.model.dao.FaqDao;
import com.javachip.carrotcountry.jmboard.notice.model.dao.NoticeDao;
import com.javachip.carrotcountry.jmboard.notice.model.vo.Notice;
import com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo;

public class NoticeService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Notice> selectList(PageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn,pi);
		
		return list;
	}

	public int insertNotice(Notice n) {

		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn,n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int increaseCount(int nno) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseCount(conn,nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int nno) {
		
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, nno);
		
		close(conn);
		
		
		return n;
	}

	public int updateNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	public int deleteNotice(int nno) {
		
		Connection conn = getConnection();
		//System.out.println(nno);
		int result = new NoticeDao().deleteNotice(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Notice> noticeSearchList(PageInfo pi, String category, String search) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().noticeSearchList(conn, pi, category, search);
		
		close(conn);
		
		return list;
	}
	


}





















