package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminMemberService;
import com.javachip.carrotcountry.adminBoard.model.vo.AdminMember;

@WebServlet("/blackList.sb")
public class BlackListManagementFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlackListManagementFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AdminMember> list = new AdminMemberService().blackListSelectAll();
	
		request.getRequestDispatcher("views/adminBoard/blackListManagementForm.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}