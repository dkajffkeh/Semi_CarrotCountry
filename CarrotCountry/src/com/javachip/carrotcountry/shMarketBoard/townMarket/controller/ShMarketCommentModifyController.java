package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;

/**
 * Servlet implementation class ShMarketCommentModifyController
 */
@WebServlet("/modifybtn.sh.hy")
public class ShMarketCommentModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketCommentModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8"); 
		String userInput = request.getParameter("userInput");
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		CommentHY c = new CommentHY();
		c.setCommentNo(commentNo);
		c.setContent(userInput);
		c.setMemNo(memNo);
		
		CommentHY newc = new TownMarketService().shmarketCommentModifier(c);
		response.setContentType("application/json; charset=utf-8"); 
		if(newc!=null) {
			
			Gson gson = new Gson();
			gson.toJson(newc,response.getWriter());
			
		} else {
			
			Gson gson = new Gson();
			gson.toJson("로드에 실패했습니다.",response.getWriter());
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
