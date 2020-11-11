package com.javachip.carrotcountry.userinfoBoard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.member.model.vo.Member;
import com.javachip.carrotcountry.userinfoBoard.model.service.UserInfoBoardService;
import com.javachip.carrotcountry.userinfoBoard.model.vo.Location;
import com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProfileUpdateController
 */
@WebServlet("/update.pro.jw")
public class ProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/userinfo_profile/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			int memNo = Integer.parseInt(request.getParameter("memNo"));
			int locNo = ((Member)request.getSession().getAttribute("loginMember")).getLocalNo();
			ArrayList<ShippingLocation> list = new UserInfoBoardService().selectShippingLocation(memNo);
			Location lo = new UserInfoBoardService().selectLocation(locNo);
			
			request.setAttribute("list", list);
			request.setAttribute("lo", lo);
			
			
			Member m = null;
			if(multiRequest.getOriginalFileName("reUpfile") != null) {
				m = new Member();
				m.setProfileOrignname(multiRequest.getOriginalFileName("reUpfile"));
				m.setProfileModifyname(multiRequest.getFilesystemName("reUpfile"));
				m.setProfilePath("resources/userinfo_profile/");
				m.setProfileLoadname("resources/userinfo_profile/"+ multiRequest.getFilesystemName("reUpfile"));
			}
			
			Member updateMem = new UserInfoBoardService().updateProfile(memNo,m);
			
			if(updateMem == null) {
				request.setAttribute("errorMsg", "사진 변경 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", updateMem); // 동일한 키값으로 담으면 덮어씌워짐
				response.sendRedirect(request.getContextPath() + "/myPage.me.jw?memNo=" + memNo);
				
			}
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
