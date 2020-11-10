package com.javachip.carrotcountry.coBuying.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.coBuying.model.service.ProductService;
import com.javachip.carrotcountry.coBuying.model.vo.Account;
import com.javachip.carrotcountry.coBuying.model.vo.Option;
import com.javachip.carrotcountry.coBuying.model.vo.Product;
import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.Photo;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class SellerInsertProductController
 */
@WebServlet("/insert.pro.jy")
public class SellerInsertProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerInsertProductController() {
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
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/images/coBuying/");
			
			MultipartRequest multiRequest =  new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			
			// 1. post
			String category = multiRequest.getParameter("category");
			int memNo = Integer.parseInt(multiRequest.getParameter("memNo"));
			String memNick = multiRequest.getParameter("memNick");
			String postName = multiRequest.getParameter("postName");
			String postComment = multiRequest.getParameter("content");
			String thumbnailFileName = multiRequest.getParameter("file1");
			String dealType ="C";
			String site ="서울특별시";
			int prodPrice = 1;
			
			PostBoard pb = new PostBoard(); 
			pb.setCategoryNo(category);
			pb.setMemNo(memNo);
			pb.setMemNickname(memNick);
			pb.setPostName(postName);
			pb.setPostContent(postComment);
			pb.setThumbnailFilename(thumbnailFileName);
			pb.setThumbnailPath("resources/images/coBuying/");
			pb.setThumbnailLoadPath("resources/images/coBuying/");
			
			
			
			
			// 2. group_purchase
			String gpDeadline = multiRequest.getParameter("gpDeadline");
			int gpMinPeople = Integer.parseInt(multiRequest.getParameter("gpMinPeople"));
			int gpPrice = Integer.parseInt(multiRequest.getParameter("gpPrice"));
			int gpDRate = Integer.parseInt(multiRequest.getParameter("gpDRate"));
			int gpDPrice = Integer.parseInt(multiRequest.getParameter("gpDPrice"));
			String gpRefund = multiRequest.getParameter("refund");
			
			Product pd = new Product();
			pd.setGpDeadline(gpDeadline);
			pd.setGpMinPeople(gpMinPeople);
			pd.setGpPrice(gpPrice);
			pd.setGpDRate(gpDRate);
			pd.setGpDPrice(gpDPrice);
			pd.setGpRefund(gpRefund);
			
			
			
			// 3. location
			String localGu = multiRequest.getParameter("gu");
			String localDong = multiRequest.getParameter("dong");
			
			Location lo = new Location();
			lo.setLocal_gu(localGu);
			lo.setLocal_dong(localDong);
			
			
			// 4. option
			String[] option = multiRequest.getParameterValues("option"); 

			
			// 5. account
			String[] account = multiRequest.getParameterValues("account"); 


			// 6. photo
			ArrayList<Photo> pList = new ArrayList<>();
			
			for(int i=2; i<=6; i++) {
				
				String key = "file" + i ;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					Photo pt = new Photo();
					pt.setPhotoPath("resources/images/coBuying/");
					pt.setPhotoFileName(multiRequest.getFilesystemName(key));
					pt.setPhotoLoadPath("resources/images/coBuying/");
					
					pList.add(pt);
					
				}
				
			}
			
			
			int result = new ProductService().insertProduct(pb, pd, lo, option, account, pList);
			
			
			
			if(result > 0) { // 성공 
				
				request.getSession().setAttribute("alertMsg", "공동구매가  성공적으로 등록되었습니다");
				response.sendRedirect(request.getContextPath() + "/mainpage.co.jy?currentPage=1");
			
			}else { // 실패 => 업로드 된 파일 찾아 삭제 => 에러문구 담은 후 에러페이지로 포워딩
				
				for(Photo pt : pList) {
					new File(savePath + pt.getPhotoFileName()).delete();
				}
				
				request.setAttribute("errorMsg", "공동구매 등록에 실패하였습니다");
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
