package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoardNg.model.service.UserInfoBoardServiceNg;

/**
 * Servlet implementation class CoBuyingBuyerUpdate
 */
@WebServlet("/buyingUpdate.co.ng")
public class CoBuyingBuyerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoBuyingBuyerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		int pNo = Integer.parseInt(request.getParameter("purchaseNo"));
		
		String co = request.getParameter("courier");
		
		long tNo = Long.parseLong(request.getParameter("trackingNo"));
		
		int result = new UserInfoBoardServiceNg().buyingBuyerUpdate(pNo ,co, tNo);

		if(result > 0) {
			
			response.sendRedirect(request.getContextPath() + "/buyerList.co.ng?bno=" + postNo + "&repCurrentPage=1");  
			
		}else {
			
			response.sendRedirect(request.getContextPath() + "/buyerList.co.ng?bno=" + postNo + "&repCurrentPage=1");  
		
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
