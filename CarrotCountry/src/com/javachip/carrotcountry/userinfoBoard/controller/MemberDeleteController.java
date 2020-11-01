package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me.jw")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new UserInfoBoardService().deleteMember(userId, userPwd);
	
		if(result > 0 ) {
					HttpSession session = request.getSession();
					session.removeAttribute("loginUser");
					session.setAttribute("alertMsg", "성공적으로 회원탈퇴 되었습니다.");
					response.sendRedirect(request.getContextPath());
			}else {
				request.setAttribute("errorMsg", "회원탈퇴에 실패했습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
