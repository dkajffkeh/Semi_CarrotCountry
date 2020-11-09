package com.javachip.carrotcountry.coBuying.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.coBuying.model.service.ProductService;
import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;

@WebServlet("/buyerPurchase.pro.jy")
public class BuyerPurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyerPurchaseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		int optionNo = Integer.parseInt(request.getParameter("option"));
		
		Product p = new ProductService().selectProduct(bno);
		PostBoard pb = new ProductService().selectPostBoard(bno);
		ArrayList<Option> optionList = new ProductService().selectOption(bno);
		ArrayList<Account> accountList = new ProductService().selectAccount(bno);
		ArrayList<ShippingLocation> shippingList = new UserInfoBoardService().selectShippingLocation(memNo);		
		
		request.setAttribute("p", p);
		request.setAttribute("pb", pb);
		request.setAttribute("optionNo", optionNo);
		request.setAttribute("optionList", optionList);
		request.setAttribute("accountList", accountList);
		request.setAttribute("shippingList", shippingList);
		
		request.getRequestDispatcher("views/coBuying/buyerPurchaseForm.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
