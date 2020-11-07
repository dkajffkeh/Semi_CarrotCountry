package com.javachip.carrotcountry.jmboard.oneTo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo;
import com.javachip.carrotcountry.jmboard.oneTo.model.service.OneToService;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;

/**
 * Servlet implementation class OneToMyListView
 */
@WebServlet("/myList.on.jm")
public class OneToMyListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToMyListView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int listCount;
		int currentPage;
		int pageLimit;
		int oneToLimit;
		int maxPage;
		int startPage;
		int endPage;
		//
		listCount = new OneToService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		
		oneToLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/oneToLimit);
		
		startPage = (currentPage - 1)/pageLimit * pageLimit + 1;
		
		
		
		endPage = startPage + pageLimit -1; 
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, oneToLimit, maxPage, startPage, endPage);
		//
		ArrayList<OneTo> list = new OneToService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("views/userinfoBoard/ng/myOneToListView.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
