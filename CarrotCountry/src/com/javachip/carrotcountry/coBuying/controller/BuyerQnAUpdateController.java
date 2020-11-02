package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.QnAService;
import com.javachip.carrotcountry.coBuying.model.vo.QnA;

/**
 * Servlet implementation class BuyerQnAUpdateController
 */
@WebServlet("/buyerupdate.qna.jy")
public class BuyerQnAUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerQnAUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

request.setCharacterEncoding("utf-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String gqTitle = request.getParameter("title");
		String gqContent = request.getParameter("content");
		
		QnA qa = new QnA();
		
		qa.setGqNo(bno);
		qa.setGqTitle(gqTitle);
		qa.setGqContent(gqContent);
		
		int result = new QnAService().updateBuyerQnA(qa);
		
		if(result > 0) { // 성공 => 상세조회페이지 요청
			
			request.getSession().setAttribute("alertMsg", "성공적으로 수정을 완료했습니다");
			
			response.sendRedirect(request.getContextPath() + "/detail.qna.jy?bno=" + bno);
			
		}else { // 실패 => 에러문구 담아서 에러페이지 포워딩
			request.setAttribute("errorMsg", "수정을 완료하지 못했습니다");
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
