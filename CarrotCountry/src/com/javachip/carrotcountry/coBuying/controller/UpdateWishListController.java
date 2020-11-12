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

/**
 * Servlet implementation class UpdateWishListController
 */
@WebServlet("/updatewish.jy")
public class UpdateWishListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWishListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		int likeCheck = new ProductService().likeCheck(bno, memNo);
		
		String alert = "찜목록에 추가되었습니다!";
		String already = "이미 추가되어있는 상품입니다!";
		String fail = "찜목록 추가에 실패하였습니다.";
		
		if(likeCheck == 0) {
			int result = new ProductService().insertLike(bno, memNo);
			
			if(result > 0) {
				out.print(alert);
			}else {
				out.print(fail);
			}
		}else {
			out.print(already);
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
