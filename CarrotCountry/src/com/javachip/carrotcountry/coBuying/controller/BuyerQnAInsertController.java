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
 * Servlet implementation class BuyerQnAInsertController
 */
@WebServlet("/buyerinsert.qna.jy")
public class BuyerQnAInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerQnAInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		int bno = Integer.parseInt(request.getParameter("Bbno"));
		String userNo = request.getParameter("userNo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		QnA qa = new QnA();
		qa.setPostNo(bno);
		qa.setMemNo(userNo);
		qa.setGqTitle(title);
		qa.setGqContent(content);
		
		int result = new QnAService().insertQuestion(qa);
		
		if(result > 0) { // 성공 => 질문리스트 띄워주기
			
			request.getSession().setAttribute("alertMsg", "성공적으로 질문이 등록됐습니다!");
			
			response.sendRedirect(request.getContextPath() + "/buyerlist.qna.jy?currentPage=1&bno="+bno);
			
		}else { // 실패
			
			request.setAttribute("errorMsg", "질문등록에 실패하였습니다!");
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
