package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoardNg.model.service.UserInfoBoardServiceNg;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyReport;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.RepPageInfo;
/**
 * Servlet implementation class ReportDetailController
 */
@WebServlet("/reportDetail.ng")
public class ReportDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		// 신고 페이지
		int repListCount;		// 나의 신고 총 갯수
		int repCurrentPage;		// 현재 페이지
		int repPageLimit;		// 하단에 보여질 페이지 최대 갯수 (5)
		int repBoardLimit;		// 한 페이지에 보여질 게시글 최대 갯수 (10)
		
		int repMaxPage;			// 가장 마지막 페이지수
		int repStartPage;		// 페이징 바의 시작수	(1, 6, 11, 16, 21, 26...)
		int repEndPage;			// 페이징 바의 끝수	(5, 10, 15, 20, 25, 30...)
		
		// repListCount 내 신고 총 갯수
		repListCount = new UserInfoBoardServiceNg().selectRepListCount(memNo);
	
		// repCurrentPage 사용자가 요청한 페이지 (현재 페이지)
		repCurrentPage = Integer.parseInt(request.getParameter("repCurrentPage"));
	
		// repPageLimit 하단에 보여질 페이지 최대 갯수
		repPageLimit = 10;
	
		// repBoardLimit 한 페이지에 보여질 게시글 최대 갯수
		repBoardLimit = 5;
		
		// repMaxPage 가장 마지막 페이지수
		repMaxPage = (int)Math.ceil((double)repListCount / repBoardLimit);
	
		// repStartPage 요청한 페이지 페이징 바의 시작수
		repStartPage = (repCurrentPage - 1) / repPageLimit * repPageLimit + 1;
	
		// repEndPage 요청한 페이지 페이징 바의 끝수
		repEndPage = repStartPage + repPageLimit -1;
		
		if(repEndPage > repMaxPage) {
			repEndPage = repMaxPage;
		}
	
		RepPageInfo pi = new RepPageInfo(repListCount, repCurrentPage, repPageLimit, 
										 repBoardLimit, repMaxPage, repStartPage, repEndPage);
		
		ArrayList<MyReport> list = new UserInfoBoardServiceNg().selectRepList(pi, memNo);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/userinfoBoard/ng/myReportDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
