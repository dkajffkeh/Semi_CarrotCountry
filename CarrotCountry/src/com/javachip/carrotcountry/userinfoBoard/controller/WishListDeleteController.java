package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;

/**
 * Servlet implementation class WishListDeleteController
 */
@WebServlet("/delete.wish.jw")
public class WishListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("wishList"));
		
		String[]wishLists = request.getParameterValues("wishList");
				
		
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int result1 = new UserInfoBoardService().deleteWishList(wishLists);
		int result2 = new UserInfoBoardService().deletePostBoardLike(wishLists);
		
		
		
		if(result1 * result2 >0) {
			
			response.sendRedirect(request.getContextPath()+"/wishList.jw?memNo="+memNo+"&currentPage=1");
			
				
			}else {
				
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
