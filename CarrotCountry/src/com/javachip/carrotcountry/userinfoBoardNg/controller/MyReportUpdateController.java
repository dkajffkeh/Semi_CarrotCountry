package com.javachip.carrotcountry.userinfoBoardNg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.userinfoBoardNg.model.service.UserInfoBoardServiceNg;

/**
 * Servlet implementation class MyReportUpdateController
 */
@WebServlet("/reportUpdate.re.ng")
public class MyReportUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReportUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		String reportContent = request.getParameter("reportContent");
		
		int result = new UserInfoBoardServiceNg().updateRep(memNo, reportNo, reportContent);
		
		if(result > 0) {
			
			request.setAttribute("resultMsg", "변경 완료!");
			response.sendRedirect(request.getContextPath() + "/reportDetail.ng?memNo=" + memNo + "&repCurrentPage=1");  
		}else {
			request.setAttribute("resultMsg", "변경 실패!");
			response.sendRedirect(request.getContextPath() + "/reportDetail.ng?memNo=" + memNo + "&repCurrentPage=1");
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
