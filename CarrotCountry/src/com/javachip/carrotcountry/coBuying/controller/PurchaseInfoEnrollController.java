package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.PurchaseInfoService;
import com.javachip.carrotcountry.coBuying.model.vo.PurchaseInfo;

@WebServlet("/purchaseInfo.pro.jy")
public class PurchaseInfoEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseInfoEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int postNo = Integer.parseInt(request.getParameter("bno"));
		int shippingNo = Integer.parseInt(request.getParameter("shippingNo"));
		String depositor = request.getParameter("depositor");
		int purchasePrice = Integer.parseInt(request.getParameter("purchasePrice"));
		int optionNo = Integer.parseInt(request.getParameter("optionNo"));
		String reqeusts = request.getParameter("selbox");
		
		PurchaseInfo pi = new PurchaseInfo(postNo, memNo, shippingNo, optionNo, depositor, purchasePrice, reqeusts);
		
		int result = new PurchaseInfoService().insertPurchaseInfo(pi);
		
		if (result > 0) {
			
		} else {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
