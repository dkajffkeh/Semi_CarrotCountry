package com.javachip.carrotcountry.jmboard.oneTo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminPageInfoService;
import com.javachip.carrotcountry.adminBoard.model.service.AdminReportService;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminReport;

/**
 * Servlet implementation class OneToSearchListController
 */
@WebServlet("/search.on.jm")
public class OneToSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int listCount = new AdminPageInfoService().selectListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 10;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		AdminPageInfo pi = new AdminPageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		String category = request.getParameter("searchCategory");
		String search = request.getParameter("search");
		
		ArrayList<AdminReport> list = new AdminReportService().reportSearchList(pi, category, search);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
