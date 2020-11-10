package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoardNg.model.service.UserInfoBoardServiceNg;
import com.javachip.carrotcountry.userinfoBoardNg.model.vo.MyPurchaseInfo;

/**
 * Servlet implementation class MyGroupPurchaseDetailController
 */
@WebServlet("/groupPurchaseDetail.gp.ng")
public class MyGroupPurchaseDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGroupPurchaseDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int purchaseNo = Integer.parseInt(request.getParameter("purchaseNo"));

		MyPurchaseInfo mpi = new UserInfoBoardServiceNg().selectPurchase(memNo, purchaseNo);
		
		if(mpi != null) {
			request.setAttribute("mpi", mpi);
			
			request.getRequestDispatcher("views/userinfoBoard/ng/myGroupPurchaseDetailView.jsp").forward(request, response);
			
		}else {
			request.setAttribute("errorMsg", "오류가 발생하였습니다 잠시후 다시 시도해주세요.(DB문제)");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
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
