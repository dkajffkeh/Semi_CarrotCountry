package com.javachip.carrotcountry.jmboard.oneTo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.oneTo.model.service.OneToService;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;

/**
 * Servlet implementation class OneToDetailController
 */
@WebServlet("/detail.on.jm")
public class OneToDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ono = Integer.parseInt(request.getParameter("ono"));
		

		OneTo o = new OneToService().selectOneTo(ono);
		

		request.setAttribute("o", o);
		
		
		
		
		/*
		System.out.println("detailController");
		System.out.print(o);
		*/
		request.getRequestDispatcher("views/oneTo/oneToDetailView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
