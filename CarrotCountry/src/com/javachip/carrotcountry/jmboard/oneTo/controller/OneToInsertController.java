package com.javachip.carrotcountry.jmboard.oneTo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.oneTo.model.service.OneToService;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;

/**
 * Servlet implementation class OneToInsertController
 */
@WebServlet("/insert.on.jm")
public class OneToInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String oneToWriter = request.getParameter("memNo");
		String oneToType = request.getParameter("oneToType");
		String oneToTitle = request.getParameter("oneToTitle");
		String oneToContent = request.getParameter("oneToContent");
		
		OneTo o = new OneTo(oneToWriter,oneToType,oneToTitle,oneToContent);
		
		int result = new OneToService().insertOneTo(o);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항 등록됐습니다.");
			
			response.sendRedirect(request.getContextPath() + "/list.fa.jm");
		}else {
			
			request.setAttribute("errorMsg", "공지사항 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		
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
