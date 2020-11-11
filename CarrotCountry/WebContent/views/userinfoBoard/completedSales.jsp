<%@ page import="com.javachip.carrotcountry.userinfoBoard.model.vo.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.*
 				,com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<%
		PostBoard pb = (PostBoard)request.getAttribute("pb");
		PageInfo pi = (PageInfo)request.getAttribute("pi");
		ArrayList<SaleProduct> list = (ArrayList<SaleProduct>)request.getAttribute("list");
	%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/userinfoBoard/completedSales.css">

</head>
<body>
		<!--  headerNavbar -->
		<%@ include file= "../common/commonNavbar.jsp"%>
	
		<div class="myPageWrapper">
		
		<!--  mypageMenubar -->
		<%@ include file= "./mypageMenubar.jsp" %>
		
		<div class="myPageWrapper_content">
		<!-- body -->
	    <div class="outer">
	        <br>
	        <h2>판매완료</h2>
	        <hr style="border:1px solid gray;"/>
	        <br>
	        <!-- 메뉴선택 버튼 -->
	        <div class="navWrap">
	            <div class="menu" align ="center"><a href="<%= contextPath %>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=1">판매중</a></div>
	            <div class="menu" align ="center"><a href="<%= contextPath %>/completedSales.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=1">판매완료</a></div>
	        </div>
	        <br>
	        <!-- 검색필터 드롭다운 -->
	        <div class="container">
	            <div class="dropdown">
	                <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">
	                등록일순
	                </button>
	                <div class="dropdown-menu">
	                    <a class="dropdown-item" href="">등록일순</a>
	                    <a class="dropdown-item" href="">상품명순</a>
	                </div>
	            </div>
	        </div>
	        <br>
	        <!-- 내용 -->
	        <div id="content">
	            
	                <table id="saleStatusTable">
	                
	                <tr align="center" style="height:50px;">
	                    <th colspan="3"  style=" text-align: right">상품명&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
	                    <th>가격</th>
	                    <th colspan="2"  style=" text-align: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록일</th>
	                </tr>
	                
	                <% if(list.isEmpty()) {%>
	                <!--  조회된 리스트가 없을 경우 -->
	                 <tr>
	                    <th colspan="5">판매완료된 상품이 없습니다.</th>
	                </tr>
	                <% } else { %>
	                
	                <% for( SaleProduct s : list) { %> 
	                
	                <input type="hidden" value="<%= s.getMemNo() %>">
	                
	                    <tr align="center">
	                        <th><%=list.indexOf(s)+1%></th>
	                        <td id="saleImage" onClick = " location.href='<%= contextPathUserinfo %>/townMarketBoardDetail.sh?bno=<%=s.getPostNo() %>'"><img src="<%=contextPath%>/<%=s.getThumbNailPath()%><%=s.getThumbNailFileName() %>" style= "width:100%; height:100%; border-radius: 20px;" ></td>
	                        <td><%= s.getPostName() %></td>
	                        <td><%= s.getProdPrice() %> 원</td>
	                        <td><%= s.getPostEnrollDate() %></td>
	                        <td>
	                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deletePost<%= s.getPostNo() %>">삭제</button>
	                        </td>
	                    </tr>
	
					<% } %>
				<%} %>
	                   
	                </table>
	           
	        </div>
	        
	        
	        <div class="paging-area" align="center">
				
		        <% if(pi.getCurrentPage() != 1){ %>			
		            <a href="<%=contextPath%>/completedSales.me.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
		        <% } %>
		    
		        <% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
		        
		            <a href="<%=contextPath%>/completedSales.me.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%= p %>"><%= p %></a>
		            
		        <% } %>
		    
		        <% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
		            <a href="<%=contextPath%>/completedSales.me.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
		        <% } %>
		        
	    	</div>
	    </div>
		</div>
		</div>
		<!-- footerbar -->
		<%@ include file="../common/footerbar.jsp" %>
		
		 <% for( SaleProduct s : list) { %>
		      <!----------------------삭제버튼 클릭시 보여질 알람창---------------------------------------->
			 <div class="modal" id="deletePost<%= s.getPostNo() %>">
			        <div class="modal-dialog">
			        <div class="modal-content">
			            
			            <!-- Modal body -->
			            <div class="modal-body" align="center">
			                
			               	삭제하시겠습니까?
								 <br><br>
			                <form action="<%= contextPath %>/completedSalesDelete.jw" method="post">
							<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
							 <input type="hidden" name="bno" value="<%= s.getPostNo() %>"> 
							
			                    <button type="submit" class="btn btn-primary">확인</button>
			                </form>
			
			            </div>
			            
			        </div>
			        </div>
			    </div>
			
			<!------------------------------------------------------------------------------------->
		<% } %>

</body>
</html>