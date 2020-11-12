package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminBoardService;
import com.javachip.carrotcountry.adminBoard.model.service.AdminPageInfoService;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;

@WebServlet("/boardSearchList.sb")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int listCount = new AdminPageInfoService().selectListCount();
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit = 10;
		int boardLimit = 13;
		
		int maxPage = (int)Math.ceil((double)listCount/boardLimit);
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		AdminPageInfo pi = new AdminPageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		String category = request.getParameter("searchCategory");
		String search = request.getParameter("search");
		
		ArrayList<AdminBoard> list = new AdminBoardService().postSearchList(pi, category, search);

		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/adminBoard/boardSelectForm.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
