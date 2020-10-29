package com.javachip.carrotcountry.jmboard.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.faq.model.service.FaqService;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqInsertController
 */
@WebServlet("/insert.fa.jm")
public class FaqInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		
		String faqWriter = request.getParameter("userNo");
		String faqContent = request.getParameter("faqContent");
		String faqTitle = request.getParameter("faqTitle");
		String category = request.getParameter("category");
	
		Faq f = new Faq();
		
		f.setMemNo(faqWriter);
		f.setFaqTitle(faqTitle);
		f.setFaqTitle(faqTitle);
		f.setCategory(category);
		
		
		int result = new FaqService().insertFaq(f);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
