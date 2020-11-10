<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.notice.model.vo.*, java.util.ArrayList" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	String alertMsg = (String)session.getAttribute("alertMsg");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
    .outer{
        width:700px;
        height:800px;
        margin:auto;
        margin-top:50px;
        
    }
    .list-area{
        border:1px solid orange;
        text-align:center;
        }
    .list-area tbody>tr:hover{
            background:darkgray;
            cursor:pointer;
        }
    
    </style>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
	
		<!-- 성공적으로 삭제되었습니다 alert -->
	<% if(alertMsg != null){ %>
		<script>
			alert("<%= alertMsg %>");	
		</script>
		
		<%
			session.removeAttribute("alertMsg");
		%>
	<%} %>
	
	
	<div class="outer">
	    <h4>공지사항</h4>
	    <hr>
	<%if(loginMember != null && loginMember.getManagerCheck().equals("Y")){ %>
    <div align="right" style="width:850px">
	<a href="<%= contextPath %>/enrollForm.no.jm" class="btn btn-secondary btn-sm">글작성</a>
	<br><br>
	</div>
	<%} %> 
	
	<table class="table table-bordered center list-area" id="list-area">

	        <% if(list.isEmpty()) { %>
	        
	           <h5>존재하는 공지사항이 없습니다.</h5>
	        
	        <% } else { %>
	
	        <!--1_2. 공지사항이 있을경우(뭐라도 조회됏을경우)-->
	     <thead>
	        <tr>
                <th width="70">글번호</th>
                <th width="300">제목</th>
                <th width="100">작성자</th>
                <th width="70">조회수</th>
                <th width="100">작성일</th>
	        </tr>
	    </thead>
	    <tbody>
	        	<% for(Notice n : list) { %>
			        <tr>
			            <td><%=n.getNoticeNo() %></td>
			            <td><%=n.getNoticeTitle() %></td>
			            <td><%=n.getMemNo() %></td>
			            <td><%=n.getNoticeCount() %></td>
			            <td><%=n.getNoticeEnrollDate() %></td>
			        </tr>
	                <% } %>
               <% } %>
	    </tbody>
	</table>
	

	<!-- search -->
	<form action="<%= contextPath %>/noticeSearch.no.jm" class="form-inline my-2 my-lg-0" id="search">
		<input type="hidden" name="currentPage" value=1>
		<select name="searchCategory" id="searchCategory">
		  <option value="no_title">제목</option>
		  <option value="no_userid">작성자</option>
		  <option value="no_birthday">작성일</option>
		</select>
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
		<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
	</form>
	
	
	
	
	
		<script>
			$(function(){
				$(".list-area>tbody>tr").click(function(){
					location.href = "<%=contextPath%>/detail.no.jm?nno=" + $(this).children().eq(0).text();
				});
			});
		</script>

	<br><br>
	
	<div>
        <div class="paging-area" align="center">
			
			<% if(pi.getCurrentPage() != 1){ %>			
            	<a href="<%=contextPath%>/list.no.jm?currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
			<% } %>

			<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
			
            	<a href="<%=contextPath%>/list.no.jm?currentPage=<%= p %>"><%= p %></a>
            	
            <% } %>

			<% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
            	<a href="<%=contextPath%>/list.no.jm?currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
			<% } %>
        </div>
	</div>
<br><br><br><br><br><br>

</div>
<br><br>
</body>
</html>