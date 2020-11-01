package com.javachip.carrotcountry.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdatePwdController
 */
@WebServlet("/updatePwd.me.ng")
public class MemberUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memUserId = request.getParameter("userId");
		String memUserPwd = request.getParameter("userPwd");
		
		int result = new MemberService().updatePwdMember(memUserId, memUserPwd);
		
		if(result > 0) {
			request.setAttribute("result", "비밀번호변경 성공!");
			request.setAttribute("text", "비밀번호 변경이 완료외었습니다.");
			request.getRequestDispatcher("views/member/memberUpdatePwdView.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "비밀번호변경 실패!");
			request.setAttribute("text", "비빌번호 변경을 실패하였습니다.");
			request.getRequestDispatcher("views/member/memberUpdatePwdView.jsp").forward(request, response);
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
