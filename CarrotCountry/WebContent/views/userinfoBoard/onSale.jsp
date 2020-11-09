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

<link rel="stylesheet" href="resources/css/userinfoBoard/onSale.css">

</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>

	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">




	<!-- # 판매중 body영역-------------------------->

<!-- # 판매중 body영역-------------------------->

<div class="outer">
    <br>
    <h2>판매중</h2>
    <hr color="gray">
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
                <a class="dropdown-item" href="">진행상태순</a>
                <a class="dropdown-item" href="">상품명순</a>
            </div>
        </div>

    </div>
    <br>
    <!-- 상품 내용 -->
    <div id="content">
        <!-- form태그 진행상태값 받아와야해서 넣음 -->
            <table id="saleStatusTable">
                <tr style="height:50px;">
                    <th colspan="3" style=" text-align: right">상품명</th>
                    <th style="text-align:center">가격</th>
                    <th colsapn="2" style=" text-align: right;"><b>등록일&nbsp;&nbsp;&nbsp;</b></th>
                </tr>
                
                
                <% if(list.isEmpty()) {%>
                
                 <tr>
                    <th colspan="6" style="text-align:center">판매중인 상품이 없습니다.</th>
                </tr>
                 <% } else { %>
                
                <% for( SaleProduct s : list) { %> 
               
               <input type="hidden" value="<%= s.getMemNo() %>" name="memNo">
                
        
                <!--  리스트 중 postNo이 해당 열에 속하는 no만 구해야되는데 아마도 여러개의 no이 나와서 java.lang.IndexOutOfBoundsException 발생?. 어떻게?  -->
                <tr align="center">
                    <th rowspan="2"><%=list.indexOf(s)+1%></th>
                    <td id="saleImage"  onClick = " location.href='<%= contextPathUserinfo %>/townMarketBoardDetail.sh?bno=<%=s.getPostNo() %>' "rowspan="2"><img src="<%=contextPath%>/<%=s.getThumbNailPath()%><%=s.getThumbNailFileName() %>" style= "width:100%; height:100%; border-radius: 20px;" ></td>
                    <td>
                    	<%= s.getPostName() %>    				
                    </td>
                    <td><%= s.getProdPrice() %> 원</tds>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;
                        <%= s.getPostEnrollDate() %>
                    </td>
                    <td id="button1">
                        <button type="button" class="btn btn-primary btn-sm"data-toggle="modal" data-target="#updatePost">판매완료</button>
                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deletePost">삭제</button>
                    </td>
                </tr>
                <tr></tr>
				
	          	<% } %>
			<%} %>
                    
            </table>

    </div>


    <div class="paging-area" align="center">
			
        <% if(pi.getCurrentPage() != 1){ %>			
            <a href="<%=contextPath%>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
        <% } %>
    
        <% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
        
            <a href="<%=contextPath%>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=<%= p %>"><%= p %></a>
            
        <% } %>
    
        <% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
            <a href="<%=contextPath%>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
        <% } %>
        
    	</div>



</div>

<!------------------------------------------------------------------------------------->
</div>
</div>

<!-- footerbar -->
	<%@ include file="../common/footerbar.jsp" %>
	
	
	 <% for( SaleProduct s : list) { %>
	<!----------------------삭제버튼 클릭시 보여질 modal---------------------------------------->

 		<div class="modal" id="deletePost">
		        <div class="modal-dialog">
		        <div class="modal-content">
		            
		            <!-- Modal body -->
		            <div class="modal-body" align="center">
		                
		               	삭제하시겠습니까?
							 <br><br>
		                <form action="<%= contextPath %>/onSalesDelete.jw" method="post">
						<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
						<input type="hidden" name="bno" value="<%= s.getPostNo() %>">
						
		                    <button type="submit" class="btn btn-primary">확인</button>
		                </form>
		
		            </div>
		            
		        </div>
		        </div>
		    </div>
    
    <!------------------------------------------------------------------------------------->
<!----------------------판매완료 클릭시 보여질 modal---------------------------------------->

 		<div class="modal" id="updatePost">
		        <div class="modal-dialog">
		        <div class="modal-content">
		            
		            <!-- Modal body -->
		            <div class="modal-body" align="center">
		                
		               	판매완료로 변경하시겠습니까?
							 <br><br>
		                <form action="<%= contextPath %>/onSalesUpdate.jw" method="post">
						<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
						<input type="hidden" name="bno" value="<%= s.getPostNo() %>">
						
		                    <button type="submit" class="btn btn-primary">확인</button>
		                </form>
		
		            </div>
		            
		        </div>
		        </div>
		    </div>
    
    <!------------------------------------------------------------------------------------->
		<%} %>


</body>
</html>