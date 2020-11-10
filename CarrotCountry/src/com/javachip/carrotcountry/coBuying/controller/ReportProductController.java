package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.ProductService;
import com.javachip.carrotcountry.coBuying.model.vo.PostBoardJY;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;

/**
 * Servlet implementation class ReportProductController
 */
@WebServlet("/report.pro.jy")
public class ReportProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("bno"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String checkReport = "이미 신고한 게시글입니다.";
		
		
		int repCheck = new ProductService().reportCheck(bno, memNo);
		
		if(repCheck > 0) {
			out.print(checkReport);
		}else {
			int result = new ProductService().reportProduct(bno);
			
			if(result>0) {
				response.getWriter().print("success");
			} 
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
