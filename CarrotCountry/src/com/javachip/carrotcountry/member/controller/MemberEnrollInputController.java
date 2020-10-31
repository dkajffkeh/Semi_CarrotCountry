package com.javachip.carrotcountry.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.member.model.service.MemberService;
import com.javachip.carrotcountry.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollInputController
 */
@WebServlet("/enrollInput.me.ng")
public class MemberEnrollInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int localNo = Integer.parseInt(request.getParameter("local"));
		String memUserId = request.getParameter("userId");
		String memUserPwd = request.getParameter("userPwd");
		String memName = request.getParameter("userName");
		String memNickname = request.getParameter("nickName");
		String memBirthday = request.getParameter("birthday");
		String memGender = request.getParameter("gender");
		String memPhone = request.getParameter("phone");
		String memEmail = request.getParameter("email"); // ""
		
		Member m = new Member(localNo, memUserId, memUserPwd, memName, memNickname, 
							  memBirthday, memGender, memPhone, memEmail);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 회원가입 성공
			request.setAttribute("result","회원가입 성공!" );
			request.setAttribute("memUserId", memUserId);
			request.setAttribute("memName", memName);
			request.setAttribute("memNickname", memNickname);
			
			request.getRequestDispatcher("views/member/memberEnrollResult.jsp").forward(request, response);
			
			
			
		}else { // 회원가입 실패
			request.setAttribute("result", "회원가입 실패!");
			
			request.getRequestDispatcher("views/member/memberEnrollResult.jsp").forward(request, response);
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
