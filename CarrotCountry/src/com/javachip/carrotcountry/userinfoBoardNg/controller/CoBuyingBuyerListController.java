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
 * Servlet implementation class CoBuyingBuyerListController
 */
@WebServlet("/buyerList.co.ng")
public class CoBuyingBuyerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoBuyingBuyerListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 페이징 처리 --> RepPageInfo 사용
		int repListCount;	// 공동구매 총 갯수
		int repCurrentPage;	// 현재 페이지
		int repPageLimit;	// 하단에 보여질 페이지 최대 갯수(5)
		int repBoardLimit; 	// 한 페이지에 보열질 공동구매 최대 갯수(10)
		
		int repMaxPage;		// 가장 마지막 페이지
		int repStartPage;	// 페이징바의 시작페이지
		int repEndPage;		// 페이징바의 끝페이지
		
		// 나의 공동구매 구매한 회원 리스트 총 수
		repListCount = new UserInfoBoardServiceNg().buyerListCount(bno);	
		
		// 현재 페이지
		repCurrentPage = Integer.parseInt(request.getParameter("repCurrentPage"));
		
		// 하단에 페이지 최대 갯수
		repPageLimit = 5;
		
		// 한페이지 게시글 최대 갯수
		repBoardLimit = 10;
		
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
		
		ArrayList<MyPurchaseInfo> list = new UserInfoBoardServiceNg().buyerList(pi, bno);

		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/userinfoBoard/ng/coBuyingBuyerList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}











