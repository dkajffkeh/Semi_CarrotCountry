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
 * Servlet implementation class OneToUserModifyController
 */
@WebServlet("/modify.on.jm")
public class OneToUserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToUserModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int ono = Integer.parseInt(request.getParameter("ono"));
		String type = request.getParameter("oneToType");
		String title = request.getParameter("oneToTitle");
		String content = request.getParameter("oneToContent");
	
		OneTo o = new OneTo(ono,type,title,content);
	
		int result = new OneToService().userModify(o);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 질문이 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.on.jm?ono=" + ono);
		}else {
			request.setAttribute("errorMsg", "FAQ 수정 실패.");
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
