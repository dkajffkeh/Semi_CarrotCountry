package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.ProductService;
import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;

/**
 * Servlet implementation class BuyerProductDetailController
 */
@WebServlet("/buyerdetail.pro.jy")
public class BuyerProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 1. 조회수 증가
		int result = new ProductService().increaseCount(bno);
		
		if(result > 0) { // 유효한 게시글

			
			// 대표사진, post정보 조회 (Thumbnail)
			PostBoard pb = new ProductService().selectPostBoard(bno);
			
			// group_purchase게시글 정보 조회 (Product)
			Product pd = new ProductService().selectProduct(bno);
			
			// 옵션리스트 조회 => 여러개
			ArrayList<Option> oList = new ProductService().selectOption(bno);
			
			// 계좌리스트 조회 => 여러개
			ArrayList<Account> aList = new ProductService().selectAccount(bno);
			
			// 상세사진 정보 조회 (Photo) => 여러개
			ArrayList<Photo> ptList = new ProductService().selectPhoto(bno);
			

			request.setAttribute("pb", pb);
			request.setAttribute("pd", pd);
			request.setAttribute("oList", oList);
			request.setAttribute("aList", aList);
			request.setAttribute("ptList", ptList);
			
			
			request.getRequestDispatcher("views/coBuying/buyerProductView.jsp").forward(request, response);
			
		}else { // 에러페이지로 포워딩
			
			request.setAttribute("errorMsg", "유효한 게시글이 아닙니다. 삭제된 게시글이거나 판매마감된 게시글 입니다.");
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
