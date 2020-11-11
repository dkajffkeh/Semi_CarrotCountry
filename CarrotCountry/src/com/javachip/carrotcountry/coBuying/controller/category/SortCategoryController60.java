package com.javachip.carrotcountry.coBuying.controller.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.ProductService;
import com.javachip.carrotcountry.coBuying.model.vo.PageInfo;
import com.javachip.carrotcountry.coBuying.model.vo.Product;

/**
 * Servlet implementation class SortCategoryController
 */
@WebServlet("/sortcategory60.pro.jy")
public class SortCategoryController60 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortCategoryController60() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ---------------------------- 페이징 처리 -------------------------------------
		int listCount;					// 현재 일반게시판 총 갯수
		int currentPage;				// 사용자가 요청한 페이지 (즉, 현재 페이지)
		int pageLimit;					// 한 페이지 하단에 보여질 페이지 최대갯수
		int boardLimit;					// 한 페이지 내에 보여질 게시글 최대갯수
		
		int maxPage;					// 전체 페이지들 중에서 가장 마지막 페이지 수
		int startPage;					// 현재 사용자가 요청한 페이지에 하단에 보여질 페이징바의 시작수
		int endPage;					// 현재 사용자가 요청한 페이지에 하단에 보여질 페이징바의 끝수
		
		
		listCount = new ProductService().selectProductListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 5;
		
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
	
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Product> pList = new ProductService().sortCategory60(pi);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("pList", pList);
		
		request.getRequestDispatcher("views/coBuying/coBuyingMainPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
