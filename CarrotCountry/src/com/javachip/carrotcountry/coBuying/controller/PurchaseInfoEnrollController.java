package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.javachip.carrotcountry.coBuying.model.service.PurchaseInfoService;
import com.javachip.carrotcountry.coBuying.model.vo.PurchaseInfo;
import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;

@WebServlet("/purchaseInfo.pro.jy")
public class PurchaseInfoEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseInfoEnrollController() {
        super();
    }
    
    HttpSession httpSession;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		httpSession = request.getSession();
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int postNo = Integer.parseInt(request.getParameter("bno"));
		
		int shippingNo = 0;
		
		if (StringUtils.isEmpty(request.getParameter("shippingNo"))) {
			
			String address = request.getParameter("shippingAddress");
			String userName = request.getParameter("userName");
			String phone = request.getParameter("buyerPhone");
			
			ShippingLocation sl = new ShippingLocation(memNo, address, userName, phone, "N");
			
			int result = new UserInfoBoardService().insertAddress(sl);
			
			if (result > 0) {
				ArrayList<ShippingLocation> list = new UserInfoBoardService().selectShippingLocation(memNo);
				for (int i = 0; i < list.size(); i++) {
					shippingNo = list.get(list.size() - 1).getShippingNo();
				}
			} else {
				
			}
		} else {
			shippingNo = Integer.parseInt(request.getParameter("shippingNo"));
		}
		
		String depositor = request.getParameter("depositor");
		int purchasePrice = Integer.parseInt(request.getParameter("purchasePrice"));
		int optionNo = Integer.parseInt(request.getParameter("optionNo"));
		String reqeusts = request.getParameter("selbox");

		
		String reqeustsText = request.getParameter("requests");
		if(reqeusts.equals("direct")) {
			reqeusts = reqeustsText; 
		}
		 
		PurchaseInfo pi = new PurchaseInfo(postNo, memNo, shippingNo, optionNo, depositor, purchasePrice, reqeusts);
		
		int result = new PurchaseInfoService().insertPurchaseInfo(pi);
		
		if (result > 0) {
			
			int gpPeople = new PurchaseInfoService().increasePeople(postNo);
			
			request.getRequestDispatcher("views/coBuying/purchaseComplete.jsp").forward(request, response);
		} else {
			PrintWriter printWriter = new PrintWriter(response.getWriter());
			printWriter.print("<script>alert('다시하셈;;;');</script>");
			request.getRequestDispatcher("views/coBuying/buyerPurchaseForm.jsp?bno=" + postNo).forward(request, response);			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
