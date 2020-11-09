package com.javachip.carrotcountry.jmboard.faq.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.faq.model.service.FaqService;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;
import com.javachip.carrotcountry.member.model.vo.Member;

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
		
		response.setContentType("text/html;charset=UTF-8");
		
		Member member = (Member) request.getSession().getAttribute("loginMember");
		
		PrintWriter writer = response.getWriter();
		
			if (member == null) {
				
				writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href = '" + request.getContextPath() + "';</script>");
			
			} else if(!"Y".equals(member.getManagerCheck())) {	
				
				writer.println("<script>alert('권한이 없습니다.'); location.href = '" + request.getContextPath() + "';</script>");
			
			} else {
			String faqWriter = request.getParameter("memNo");
			String faqTitle = request.getParameter("faqTitle");
			String faqContent = request.getParameter("faqContent");
			String category = request.getParameter("category");
		
			Faq f = new Faq(faqWriter, faqTitle, faqContent, category);
			
			int result = new FaqService().insertFaq(f);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "성공적으로 공지사항 등록됐습니다.");
				
				response.sendRedirect(request.getContextPath() + "/list.fa.jm");
			}else {
				
				request.setAttribute("errorMsg", "공지사항 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
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
