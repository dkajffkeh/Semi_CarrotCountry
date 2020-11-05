package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.member.model.service.MemberService;


/**
 * Servlet implementation class MyPwdUpdateController
 */
@WebServlet("/pwdUpdate.me.ng")
public class MyPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPwdUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId"); 		// 현재 로그인한 아이디
		String myPwd = request.getParameter("myPwd");			// 현재 비밀번호
		String updatePwd = request.getParameter("updatePwd");	// 변경할 비밀번호
		
		
		int result = new MemberService().myPwdUpdate(userId, myPwd, updatePwd);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/myPage.me.jw"); // 성공시 마이페이지로
			
		}else {
			request.setAttribute("errorMsg", "비밀번호 변경에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response); // 실패시 실패화면으로
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
