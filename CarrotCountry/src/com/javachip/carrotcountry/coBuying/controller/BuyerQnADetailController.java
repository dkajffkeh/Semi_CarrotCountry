package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.QnAService;
import com.javachip.carrotcountry.coBuying.model.service.QnAServiceHY;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;
import com.javachip.carrotcountry.coBuying.model.vo.QnAHY;

/**
 * Servlet implementation class BuyerQnADetailController
 */
@WebServlet("/detail.qna.jy")
public class BuyerQnADetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerQnADetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int qno = Integer.parseInt(request.getParameter("qno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = new QnAService().increaseQnACount(qno);
		
		if(result > 0) { // 유효한 게시글
			
			QnAHY qa = new QnAServiceHY().qnaSelector(qno);
			
			request.setAttribute("qa", qa);
			request.setAttribute("bno", bno);
			request.getRequestDispatcher("views/coBuying/buyerQnADetail.jsp").forward(request, response);
			
		}else { // 유효 X => 에러문구
			
			request.setAttribute("errorMsg", "유효한 게시글이 아닙니다. 또는 해당 게시글이 삭제되었을 수 있습니다.");
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
