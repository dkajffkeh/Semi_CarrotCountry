package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;
import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;
import com.javachip.carrotcountry.userinfoBoard.model.vo.PageInfo;
import com.javachip.carrotcountry.userinfoBoard.model.vo.SaleProduct;

/**
 * Servlet implementation class CompletedSalesController
 */
@WebServlet("/completedSales.me.jw")
public class CompletedSalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletedSalesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount;			// 현재 일반 게시판 총 갯수
		int currentPage;		// 사용자가 요청한 페이지 (즉, 현재 페이지)
		int pageLimit;			// 한 페이지 하단에 보여질 페이지 최대갯수
		int boardLimit; 		// 한 페이지 내에 보여질 게시글 최대갯수
		
		int maxPage;			// 전체 페이지들 중에서 가장 마지막 페이지 수 
		int startPage;			// 현재 사용자가 요청한페이지에 하단에 보여질 페이징 바의 시작수
		int endPage;			// 현재 사용자가 요청한페이지에 하단에 보여질 페이징 바의 끝수
		
		listCount = new UserInfoBoardService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		boardLimit = 6;
		pageLimit=5;
		maxPage = (int)Math.ceil(((double)listCount/boardLimit));
		
		startPage =((currentPage-1)/pageLimit)*pageLimit+1; 
		
		endPage = startPage + pageLimit-1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		ArrayList<SaleProduct> list= new UserInfoBoardService().selectCompletedSales(memNo, pi);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("views/userinfoBoard/completedSales.jsp");
		view.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
