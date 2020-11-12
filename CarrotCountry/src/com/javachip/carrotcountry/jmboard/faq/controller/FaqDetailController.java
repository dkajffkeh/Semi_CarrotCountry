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
 * Servlet implementation class FaqDetailController
 */
@WebServlet("/detail.fa.jm")
public class FaqDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**(오류중)DB수정하고 다시 확인
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			int fno = Integer.parseInt(request.getParameter("fno"));
		

			Faq f = new FaqService().selectFaq(fno);
			


			request.setAttribute("f", f);
			request.getRequestDispatcher("views/faq/faqDetailView.jsp").forward(request, response);


			

			

			

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
