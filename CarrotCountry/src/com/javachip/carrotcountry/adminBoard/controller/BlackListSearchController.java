package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminMemberService;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;

@WebServlet("/blackListSearch.sb")
public class BlackListSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlackListSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new AdminMemberService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));

		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		AdminPageInfo pi = new AdminPageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		String category = request.getParameter("searchCategory");
		String search = request.getParameter("search");
		System.out.println(search);
		
		ArrayList<AdminMember> list = new AdminMemberService().blackListSearch(pi, category, search);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/adminBoard/blackListManagementForm.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
