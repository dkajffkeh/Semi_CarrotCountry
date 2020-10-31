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

@WebServlet("/userList.sb")
public class UserSelectFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSelectFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AdminMember> list = new AdminMemberService().userSelectAll();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/adminBoard/userSelectForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
