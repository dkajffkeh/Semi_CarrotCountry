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

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me.jw")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String memName = request.getParameter("memName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		
		Member m = new Member(userId, memName, gender, birthday, nickName, phone, location, email);
		
		Member updateMem = new UserInfoBoardService().updateMember(m);
		
		if(updateMem == null) {
			
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem); // 동일한 키값으로 담으면 덮어씌워짐
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다!!");
			
			response.sendRedirect(request.getContextPath() + "/updateForm.me.jw");
	
			
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
