package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminBoardService;
import com.javachip.carrotcountry.adminBoard.model.service.AdminMemberService;
import com.javachip.carrotcountry.adminBoard.model.service.AdminPageInfoService;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo;
import com.javachip.carrotcountry.member.model.vo.Member;

@WebServlet("/boardSelect.sb")
public class BoardSelectFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSelectFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Member member = (Member) request.getSession().getAttribute("loginMember");
		
		PrintWriter writer = response.getWriter();
		
		if(member == null) {
			
			writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href = '" + request.getContextPath() + "';</script>");
		
		} else if(!"Y".equals(member.getManagerCheck())) {			
			
			writer.println("<script>alert('권한이 없습니다.'); location.href = '" + request.getContextPath() + "';</script>");
		
		} else {
			
			int listCount = new AdminPageInfoService().selectListCount();
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int pageLimit = 10;
			int boardLimit = 13;
			
			int maxPage = (int)Math.ceil((double)listCount/boardLimit);
			int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
			int endPage = startPage + pageLimit - 1;
			
			if (endPage > maxPage) {
				endPage = maxPage;
			}
			
			AdminPageInfo pi = new AdminPageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
			
			ArrayList<AdminBoard> list = new AdminBoardService().postSelectAll(pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/adminBoard/boardSelectForm.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
