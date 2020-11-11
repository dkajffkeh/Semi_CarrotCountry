package com.javachip.carrotcountry.jmboard.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.jmboard.notice.model.service.NoticeService;
import com.javachip.carrotcountry.jmboard.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.no.jm")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int nno = Integer.parseInt(multiRequest.getParameter("nno"));
			String noticeTitle = multiRequest.getParameter("title");
			String noticeContent = multiRequest.getParameter("content");
			
			
			//String fileOrigin = multiRequest.getOriginalFileName("reUpfile");
			//String fileModify = multiRequest.getFilesystemName("reUpfile");
			 String fileOrigin = null;
	         String fileModify = null;
			
			
			String filePath = "resources/notice_upfiles/";
			
			
			if(multiRequest.getOriginalFileName("reUpfile") != null){ // 새로운 첨부파일이 넘어왔을 경우

	            fileOrigin = multiRequest.getOriginalFileName("reUpfile");
	            fileModify = multiRequest.getFilesystemName("reUpfile");

	         }else{
	             fileOrigin = multiRequest.getParameter("originFileName");
	             fileModify = multiRequest.getParameter("modifyFileName");

	         }
			
			
			
			
			
			
			Notice n = new Notice(nno, noticeTitle, noticeContent, 
					 filePath, fileModify, fileOrigin);
			
			int result = new NoticeService().updateNotice(n);
	
			
			if(result > 0) {
				
				if(multiRequest.getParameter("modifyFileName") != null) {
					
					File deleteFile = new File(savePath + multiRequest.getParameter("modifyFileName"));
					deleteFile.delete();
					
				}
				
				request.getSession().setAttribute("alertMsg", "공지사항 수정 성공했습니다.");
				response.sendRedirect(request.getContextPath() + "/detail.no.jm?nno=" + nno);
				
			}else {
				
				request.setAttribute("errorPage", "공지사항 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
				
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
