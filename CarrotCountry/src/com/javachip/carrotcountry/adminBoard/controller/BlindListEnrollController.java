package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminBoardService;

@WebServlet("/blindEnroll.sb")
public class BlindListEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlindListEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String bCheck = request.getParameter("bCheck");
		
		int result = new AdminBoardService().blindListEnroll(postNo, bCheck);
		
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/boardSelect.sb?currentPage=1");
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('등록에 실패했습니다.');</script>");
			
			response.sendRedirect(request.getContextPath() + "/blindList.sb?currentPage=1");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
