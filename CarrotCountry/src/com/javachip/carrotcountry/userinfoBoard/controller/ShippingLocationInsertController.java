package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javachip.carrotcountry.member.model.vo.Member;
import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;
import com.javachip.carrotcountry.userinfoBoard.model.vo.UserinfoMember;

/**
 * Servlet implementation class ShippingLocationInsertController
 */
@WebServlet("/insert.lo.jw")
public class ShippingLocationInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShippingLocationInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//유저조회랑 배송지값 추가를 같이 해야함
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String address = request.getParameter("address");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String defaultAddress = request.getParameter("defaultAddress");
		
		ShippingLocation sl = new ShippingLocation(memNo, address, userName, phone, defaultAddress);
		
		int result = new UserInfoBoardService().insertAddress(sl);
		if(result >0) {
			
			response.sendRedirect(request.getContextPath()+"/myPage.me.jw?memNo="+memNo+"&currentPage=1");
				
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
