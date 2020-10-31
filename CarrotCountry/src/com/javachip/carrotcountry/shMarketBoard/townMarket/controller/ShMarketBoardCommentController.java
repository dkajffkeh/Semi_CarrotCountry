package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;

/**
 * Servlet implementation class ShMarketBoardCommentController
 */
@WebServlet("/insertComment.sh")
public class ShMarketBoardCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String sContent = request.getParameter("cContent");
		String cCheck = request.getParameter("sCheck");
		String userNick = request.getParameter("userNick");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		CommentHY c = new CommentHY();
		c.setContent(sContent);
		c.setSecretCheck(cCheck);
		c.setUserNickName(userNick);
		c.setPostNo(postNo);
		c.setMemNo(memNo);
		
		int count = new TownMarketService().shBoardInsertComment(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
