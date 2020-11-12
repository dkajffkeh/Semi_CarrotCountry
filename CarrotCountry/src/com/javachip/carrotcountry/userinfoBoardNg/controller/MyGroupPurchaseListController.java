package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoardNg.model.service.UserInfoBoardServiceNg;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyPurchaseInfo;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.RepPageInfo;

/**
 * Servlet implementation class MyGroupPurchaseListController
 */
@WebServlet("/groupPurchaseList.gp.ng")
public class MyGroupPurchaseListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGroupPurchaseListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
			
		// 페이징 처리 --> RepPageInfo 사용
		int repListCount;	// 공동구매 총 갯수
		int repCurrentPage;	// 현재 페이지
		int repPageLimit;	// 하단에 보여질 페이지 최대 갯수(5)
		int repBoardLimit; 	// 한 페이지에 보열질 공동구매 최대 갯수(6)
		
		int repMaxPage;		// 가장 마지막 페이지
		int repStartPage;	// 페이징바의 시작페이지
		int repEndPage;		// 페이징바의 끝페이지
		
		// 나의 공동구매 총 갯수
		repListCount = new UserInfoBoardServiceNg().selectPurchaseCount(memNo);	
		
		// 현재 페이지
		repCurrentPage = Integer.parseInt(request.getParameter("repCurrentPage"));
		
		// 하단에 페이지 최대 갯수
		repPageLimit = 5;
		
		// 한페이지 게시글 최대 갯수
		repBoardLimit = 4;
		
		// 가장 마지막수
		repMaxPage = (int)Math.ceil((double)repListCount / repBoardLimit);
		
		// 페이징 바의 시작수
		repStartPage = (repCurrentPage - 1) / repPageLimit * repPageLimit + 1;
		
		// 페이징 바의 끝수
		repEndPage = repStartPage + repPageLimit -1;
		
		if(repEndPage > repMaxPage) {
			repEndPage = repMaxPage;
		}
	
		RepPageInfo pi = new RepPageInfo(repListCount, repCurrentPage, repPageLimit, 
				 repBoardLimit, repMaxPage, repStartPage, repEndPage);
		
		ArrayList<MyPurchaseInfo> list = new UserInfoBoardServiceNg().selectPurchaseList(pi, memNo);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/userinfoBoard/ng/myGroupPurchaseListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
