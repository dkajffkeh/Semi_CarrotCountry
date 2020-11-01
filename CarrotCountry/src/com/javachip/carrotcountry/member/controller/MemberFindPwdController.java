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
 * Servlet implementation class MemberFindPwdController
 */
@WebServlet("/findPwd.me.ng")
public class MemberFindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String memName = request.getParameter("userName");
		String memUserId = request.getParameter("userId");
		String memBirthday = request.getParameter("birthday");
		String memPhone = request.getParameter("phone");
		
		Member m = new Member();
		m.setMemName(memName);
		m.setMemUserId(memUserId);
		m.setMemBirthday(memBirthday);
		m.setMemPhone(memPhone);

		int memNo = new MemberService().findPwdMember(m);
		
		if(memNo > 0) {
			request.setAttribute("result", "비밀번호 변경");
			//request.setAttribute("memNo", memNo); // 해당 유저의 유저번호 전달시 오류발생함...
			request.setAttribute("memUserId", memUserId); // 해당 유저 아이디 전달
			request.getRequestDispatcher("views/member/memberUpdatePwdForm.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "비밀번호찾기 실패!");
			request.getRequestDispatcher("views/member/memberUpdatePwdForm.jsp").forward(request, response);
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
