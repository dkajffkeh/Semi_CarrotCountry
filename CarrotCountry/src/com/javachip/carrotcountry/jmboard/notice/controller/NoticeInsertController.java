package com.javachip.carrotcountry.jmboard.notice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.jmboard.notice.model.service.NoticeService;
import com.javachip.carrotcountry.jmboard.notice.model.vo.Notice;
import com.javachip.carrotcountry.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no.jm")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=UTF-8");
		
		Member member = (Member) request.getSession().getAttribute("loginMember");
		
		PrintWriter writer = response.getWriter();
		
		if (member == null) {
			
			writer.println("<script>alert('로그인 후 이용 가능합니다.'); location.href = '" + request.getContextPath() + "';</script>");
		
		} else if(!"Y".equals(member.getManagerCheck())) {	
			
			writer.println("<script>alert('권한이 없습니다.'); location.href = '" + request.getContextPath() + "';</script>");
		
		} else {
		
		
			if (ServletFileUpload.isMultipartContent(request)) {
				int maxSize = 10 * 1024 * 1024;
				String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
						new MyFileRenamePolicy());
				
				String noticeTitle = multiRequest.getParameter("title");
				String noticeContent = multiRequest.getParameter("content");
				String noticeWriter = multiRequest.getParameter("memNo");
				String fileOrigin = multiRequest.getOriginalFileName("upfile");
				String fileModify = multiRequest.getFilesystemName("upfile");
				String filePath = "resources/notice_upfiles/";
				
				Notice n = new Notice(noticeWriter, noticeTitle, noticeContent, 
						 filePath, fileModify, fileOrigin);
				
				int result = new NoticeService().insertNotice(n);
				
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "게시글 등록 성공!");
					response.sendRedirect(request.getContextPath() + "/list.no.jm?currentPage=1");
					
					
				}else {
					if(n.getFileOriginName() != null) {
						File failedFile = new File(savePath + n.getFileModifyName());
						failedFile.delete();
						
					}
					request.setAttribute("errorMsg", "공지시항 등록 실패.");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
					
				}
				
				
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
