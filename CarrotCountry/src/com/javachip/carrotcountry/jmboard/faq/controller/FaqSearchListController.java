package com.javachip.carrotcountry.jmboard.faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.faq.model.service.FaqService;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqSearchListController
 */
@WebServlet("/search.fa.jm")
public class FaqSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqSearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int type = Integer.parseInt(request.getParameter("type"));
	
		ArrayList<Faq> list = new FaqService().FaqSearchList(type);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/faq/faqListView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
