package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;

/**
 * Servlet implementation class CompletedSalesDeleteController
 */
@WebServlet("/completedSalesDelete.jw")
public class CompletedSalesDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletedSalesDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));
	
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int result = new UserInfoBoardService().deleteCompletedSales(bno);
		
		if(result >0) {
			
			response.sendRedirect(request.getContextPath()+"/completedSales.me.jw?memNo="+memNo+"&currentPage=1");
			
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
