package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;

/**
 * Servlet implementation class TownMarKetBoardDetailController
 */
@WebServlet("/townMarketBoardDetail.sh")
public class TownMarKetBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TownMarKetBoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bno = Integer.parseInt(request.getParameter("bno"));		
		
		int result = new TownMarketService().increaseBoardViews(bno);
		
		if(result>0) {
			
			PostBoard pb = new TownMarketService().PostBoardDetailSelector(bno);
			
			request.setAttribute("pb", pb);
			
			request.getRequestDispatcher("views/shMarket/shMarketDetailPage.jsp").forward(request, response);
			
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
