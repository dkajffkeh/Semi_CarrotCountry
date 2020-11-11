package com.javachip.carrotcountry.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javachip.carrotcountry.member.model.service.MemberService;
import com.javachip.carrotcountry.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me.ng")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memUserId = request.getParameter("userId");
		String memUserPwd = request.getParameter("userPwd");
		
		
		Member loginMember = new MemberService().loginMember(memUserId, memUserPwd);
		
		if(loginMember == null) { 
			
			// 로그인 실패
			request.setAttribute("loginFail", "ID 혹은 비밀번호를 잘못 입력하셨거나 가입하지 않은 ID 입니다.");
			request.getRequestDispatcher("/views/member/memberLoginForm.jsp").forward(request, response);
			
		}else { 

			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			session.setMaxInactiveInterval(-1);
			response.sendRedirect(request.getContextPath());
			
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
