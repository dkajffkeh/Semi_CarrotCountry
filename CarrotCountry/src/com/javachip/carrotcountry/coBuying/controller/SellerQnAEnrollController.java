package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.QnAServiceHY;
import com.javachip.carrotcountry.coBuying.model.vo.QnAHY;
/**
 * Servlet implementation class SellerQnAAnswerController
 */
@WebServlet("/sellerenroll.qna.jy")
public class SellerQnAEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerQnAEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		QnAHY qa = new QnAServiceHY().qnaSelector(qno);
		
		request.setAttribute("qa", qa);
		request.getRequestDispatcher("views/coBuying/sellerQnAEnrollAnswer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
