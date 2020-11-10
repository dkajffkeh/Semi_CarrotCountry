<%@ page import="com.javachip.carrotcountry.userinfoBoard.model.vo.*"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import= "com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.*
			     ,com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<CobuyingPost> list = (ArrayList<CobuyingPost>)request.getAttribute("list");
	PostBoard pb = (PostBoard)request.getAttribute("pb");
%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 /* 내게시글 css */
        .outer{
           margin-top:50px;
           margin-left:50px;
           width:1000px;
           font-family: 'Do Hyeon', sans-serif;
         }
         .list-area{
            /* border:1px solid black; */
            text-align:center;
            width:900px;
            font-size:20px;

        }
        .list-area tbody>tr:hover{
            background:rgb(252, 177, 37);
            cursor:pointer;
        }
        .paging-area {
                width:1000px;
                height:100px;
                font-size:25px;
                font-weight:500;
                float:left;
                text-align:center;
                margin-top:60%;
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
	<!-- # 내게시글 body영역 -->
    <div class="outer">
        <br>
        <h1>내 게시글</h1>
        <hr color="gray">
        <br><br>
        <table class="list-area" align="center">
            <thead>
                <tr>
                    <th>번호</th>
                    <th width="300">제목</th>
                    <th width="200">작성일</th>
                    <th>조회수</th>
                    <th>Q&A 답변하기</th>
                </tr>
            </thead>
            <tbody>
			 <input type="hidden" value="<%= loginMember.getMemNo() %>">
			
			<% if(list.isEmpty()) { %>
                <!-- 1-1. 조회결과가 없을경우 -->
                <tr>
                    <td colspan="6">존재하는 게시글이 없습니다.</td>
                </tr> 
			<% }else { %>
                <!-- 1-2. 조회결과가 있을경우 -->
				<% for(CobuyingPost c : list){ %>
				
				
                <tr>
                    <td><%= c.getPostNo() %></td>
                    <td><%= c.getPostName() %></td>
                    <td><%= c.getPostEnrollDate()%> </td>
                    <td><%= c.getPostViews() %></td>
                    <td>
                        <a href="<%= contextPathUserinfo %>/sellerlist.qna.jy?bno=<%=c.getPostNo()%>&currentPage=1" class="btn btn-light "> Q&A 답변하기</a>
                    </td>
                </tr>
                
                <% } %>
             <% } %>   
                
               
            </tbody>
        </table>
    </div>
    

    
     <script>
        	$(function(){
        		$(".list-area>tbody>tr").click(function(){
        			location.href = "<%= contextPathUserinfo %>/buyerdetail.pro.jy?bno=" + $(this).children().eq(0).text();
        		});
        	});
     </script>
    
    
    
    
    
    <div class="paging-area" align="center">
			
    <% if(pi.getCurrentPage() != 1){ %>			
        <a href="<%=contextPath%>/coBuying.po.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
    <% } %>

    <% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
    
        <a href="<%=contextPath%>/coBuying.po.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%= p %>"><%= p %></a>
        
    <% } %>

    <% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
        <a href="<%=contextPath%>/coBuying.po.jw?memNo=<%= loginMember.getMemNo() %>&currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
    <% } %>
	</div>
    
    
    
    
    </div>
    
    </div>
    

	
</body>
</html>