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
 * Servlet implementation class OneToDetailController
 */
@WebServlet("/detail.on.jm")
public class OneToDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ono = Integer.parseInt(request.getParameter("ono"));
		

		OneTo o = new OneToService().selectOneTo(ono);
		

		if(o.getAnswerState() == null) {

			request.setAttribute("o", o);
			request.getRequestDispatcher("views/faq/faqDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("err+orMsg", "유효한 게시글이 아닙니다. 또는 해당 게시글이 삭제되었을 수 있습니다.");
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
