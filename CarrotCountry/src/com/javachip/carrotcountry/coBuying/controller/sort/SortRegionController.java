package com.javachip.carrotcountry.coBuying.controller.sort;

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
 * Servlet implementation class SortLowPriceController
 */
@WebServlet("/sortRegion.pro.jy")
public class SortRegionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortRegionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String localGu = request.getParameter("gu");
		String localDong = request.getParameter("dong");
		
		// ---------------------------- 페이징 처리 -------------------------------------
		int listCount;				
		int currentPage;			
		int pageLimit;					
		int boardLimit;					
		int maxPage;					
		int startPage;					
		int endPage;				
		
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
		
		ArrayList<Product> pList = new ProductService().selectRegionProduct(pi, localGu, localDong);

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
