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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int nno = Integer.parseInt(request.getParameter("nno"));
		
		int result = new FaqService().increaseCount(nno);
		
		if(result > 0) { // 유효한 공지사항 번호일 경우 => 해당공지사항상세조회한 후 => 상세페이지 띄우기
			
			Faq f = new FaqService().selectFaq(nno);
			
			request.setAttribute("f", f);
			request.getRequestDispatcher("views/faq/faqDetailView.jsp").forward(request, response);
			
		}else { // 유효한 공지사항이 아님 => 에러페이지 (에러문구 담아서)
			
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
