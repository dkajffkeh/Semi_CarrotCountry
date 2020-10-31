package com.javachip.carrotcountry.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.member.model.service.MemberService;


/**
 * Servlet implementation class MemberFindIdController
 */
@WebServlet("/findId.me.ng")
public class MemberFindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memName = request.getParameter("userName");
		String memBirthday = request.getParameter("birthday");
		String memPhone = request.getParameter("phone");
		
		String findId = new MemberService().findIdMember(memName, memBirthday, memPhone);
		
		if(findId.equals("")) {
			request.setAttribute("result", "아이디찾기 실패!");
			request.getRequestDispatcher("views/member/memberFindIdView.jsp").forward(request, response);
			
		}else {
			request.setAttribute("result", "아이디찾기 성공!");
			request.setAttribute("findId", findId);
			request.setAttribute("memName", memName);
			request.getRequestDispatcher("views/member/memberFindIdView.jsp").forward(request, response);
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
