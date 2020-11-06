<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.oneTo.model.vo.*, java.util.ArrayList, com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo" %>
    
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<OneTo> list = (ArrayList)request.getAttribute("list");
	String resultMsg = (String)request.getAttribute("resultMsg");
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
	   height:700px;
	}
	.outer>span{
	    font-size:20px;
	}
	.myReportBottom{
		text-align:center;
		width:100%;
		height:10%;
		padding:12px;
	}
	.wrapReport{
		width:100%;
		height:100%;
	}
</style>
</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../../common/commonNavbar.jsp"%>
	
	<div class="myPageWrapper">
	
		<!--  mypageMenubar -->
		<%@ include file= "../mypageMenubar.jsp" %>
		
		<div class="myPageWrapper_content">
			<div class="outer">
		       	<br>
		       	<h1>신고 내역</h1>
		        <hr color="gray">
		        
				<div class="wrapReport">
				<table class="table table-striped table-hover" style="text-align:center">
					<thead>
						<tr style="background:gray; color:white;">
							<th width="8%">문의번호</th>
							<th width="34%">문의 제목</th>
							<th width="10%">문의유형</th>
							<th width="10%">문의작성일</th>
							<th width="10%">문의상태</th>
						</tr>
					</thead>
					<% if(list.isEmpty()){ %>
						<tr align="center">
							<td colspan="5">신고 내역이 존재하지 않습니다.</td>
						</tr>
					<% }else{ %>
					<tbody>
						<%for(OneTo o : list){ %>
							<tr>
								<td><%= o.getOneToNo() %></td>
								<td><%= o.getOneToName() %></td>
								<td><%= o.getOneToType() %></td>
								<td><%= o.getAnswerDate() %></td>
								<td><%= o.getAnswerState().equals("N") ? "처리중" : "처리완료"%></td>
							</tr>
						<%} %>
					<%} %>
					</tbody>
				</table>
			</div>
			
			<script>
			$(function(){
				$(".list-area>tbody>tr").click(function(){
					location.href = "<%=contextPath%>/detail.on.jm?ono=" + $(this).children().eq(0).text();
				});
			});
			</script>
			
			
			
			
			<div>			

			
			<% if(pi.getCurrentPage() != 1){ %>			
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
			<% } %>

			<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
			
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%= p %>"><%= p %></a>
            	
            <% } %>

			<% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
			<% } %>

			</div>
		</div>
	</div>
</div>

	<!-- footerbar -->
	<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>