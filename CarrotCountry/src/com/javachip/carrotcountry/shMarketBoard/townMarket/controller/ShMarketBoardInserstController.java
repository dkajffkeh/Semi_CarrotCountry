package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ShMarketBoardInserstController
 */
@WebServlet("/shBoardEnrollForm.sh.hy")
public class ShMarketBoardInserstController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardInserstController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 15*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/images/shMarkt_upfiles/");
			
			MultipartRequest mr = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			String category = mr.getParameter("category");
			int memNo = Integer.parseInt(mr.getParameter("memNo"));
			String memNick = mr.getParameter("memNick");
			String postTitle = mr.getParameter("title");
			String userText = mr.getParameter("content");
			String pCondition = mr.getParameter("p_condition");
			//==주소에 들어가야함
			String province = mr.getParameter("province");
			String district = mr.getParameter("district");
			String town = mr.getParameter("town");
			//==주소 셋팅
			String dealType ="D";
			String site ="서울특별시";
			int price = Integer.parseInt(mr.getParameter("price"));
			
			Location l = new Location(province,district,town);
			PostBoard pb = new PostBoard(category,memNo,memNick,price,postTitle,userText,pCondition,dealType,site);
			
			ArrayList<PhotoBoardVo> list = new ArrayList();
			//사진파일 여기서 담음.
			for(int i = 1 ; i<=5 ; i++) {
				
				String key = "pictures"+i;
				
				if(mr.getOriginalFileName(key)!=null) {
					
					PhotoBoardVo pbv = new PhotoBoardVo();
					pbv.setPhotoPath("resources/images/shMarkt_upfiles/");
					pbv.setPhotoFileName(mr.getFilesystemName(key));
					pbv.setPhotoLoadPath("resources/images/shMarkt_upfiles/");
				
					list.add(pbv);
				}	
			}
			
			int result = new TownMarketService().shMarketBoardInsert(pb,list,l);
			
			if(result>0) {
				
				response.sendRedirect(request.getContextPath()+"/shMarketBoardMain.sh?currentPage=1");
				
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
