<%@page import="java.util.ArrayList"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoard.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.*
			     ,com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*" %>
 <%
 	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<WishList> list = (ArrayList<WishList>)request.getAttribute("list");
	ArrayList<MyPagePhoto> photolist= (ArrayList<MyPagePhoto>)request.getAttribute("photolist");
 	
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 			.outer{
                   margin-top:50px;
                   margin-left:50px;
                   width:1000px;
                   font-family: 'Do Hyeon', sans-serif; 
                   }
            #countWish p{
                color:gray;
                font-size:25px;
                }
            #countWish{margin-left:40px;}
         
            #content{
                padding:30px;
                font-size:20px;
                /* border:4px solid black; */
                width:1000px;
                height:500px;
                /* background-color:blue; */
            }
             #content > div :hover{
                background:rgb(255, 224, 166);
                cursor:pointer;
            }
            .content1{
                box-shadow:5px 5px 10px 5px rgb(247, 233, 205);
                border-bottom-right-radius:40px;
                width:20%;
                height:60%;
                float:left;
                margin:20px;
            }
            #content img{
                width:180px; 
                height:140px;  
            }
            #nosSelectAlert{font-size:20px;}
            .button{
                /* background-color:red; */
                text-align:center;
                height:10%;
                width:100%;
                float:right;
            }
            .button button {
                float:right;
                margin-right:100px;
            }

            .paging-area {
                width:1000px;
                height:100px;
                float:left;
                text-align:center;
                font-size:25px;
                font-weight:500;
                margin-top:10%;
               
            }

</style>
</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>

	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">
	<!-- # 찜 body영역 -->
	<div class="outer">
	
	 	<br>
	    <h1>찜 목록</h1>
	    <hr color="gray">
	    <br>
	    
	 <form action="<%= contextPath %>/delete.wish.jw" method="post" id="wishList">
	   <input type="hidden" value="<%= loginMember.getMemNo() %>" name="memNo">
	    
	    <!-- 찜한 개수 -->
	    <div id="countWish">
	        <p>찜한 상품 : <%= list.size() %> </p>
	    </div>
	    <!-- 물품 정보 -->
	    <div id="content">
	    
	     <div id="content1">
	    	 <% for(WishList w : list) { %>
	    	 	
			        <div class="content1">
						<input type="hidden" value="<%= w.getPostNo() %>" name="bno">
			            <input style='zoom:2.0;' type="checkbox" name="wishList" value="<%=w.getPostNo()%>">
			           <div class="img1">
			           	<img src="<%= contextPath %>/<%= w.getThumbNailPath() %><%= w.getThumbNailFileName() %>"> <br>
			           </div>
			           	 &nbsp; &nbsp;
			           	 <%= w.getPostName() %> <br>
			             &nbsp; &nbsp;&nbsp;
			             <%= w.getProdPrice() %>
			             &nbsp;원
	        		</div>
	     	  <%} %>
	 
	     
	     </div>

	    </div>
	    
	    <div class= "button">
	        <button type="submit" class="btn btn-secondary btn-lg">관심상품 삭제</button>
	 	</div>
	</form>
	
	   
	    <br>
	
	</div>

	<script>
        	$(function(){
        		$(".img1").click(function(){
        		location.href = "<%= contextPathUserinfo %>/townMarketBoardDetail.sh?bno=" + $(this).children().eq(0).val();
        		});
        	});
        		
        	
     </script>

	



	<!------------------------------------------------------------------------------------->
	
		<div class="paging-area" align="center">
			
			<% if(pi.getCurrentPage() != 1){ %>		
            	<a href="<%=contextPath%>/wishList.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
			<% } %>

			<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
			
            	<a href="<%=contextPath%>/wishList.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%= p %>"><%= p %></a>
            	
            <% } %>

			<% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
            	<a href="<%=contextPath%>/wishList.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
			<% } %>
        </div>
	
	
	
	
	
        
	</div>
	</div>
	
	<!-- footerbar -->
	<%@ include file="../common/footerbar.jsp" %>
	
	

</body>
</html>