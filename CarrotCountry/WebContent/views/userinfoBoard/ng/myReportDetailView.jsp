<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoardNg.model.vo.*, java.util.ArrayList" %>
    
<%
	RepPageInfo pi = (RepPageInfo)request.getAttribute("pi");
	ArrayList<MyReport> list = (ArrayList)request.getAttribute("list");
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
		        
		        <br><br><br><br><br>
				
				
				
				<div class=""></div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th width="80px">신고번호</th>
							<th>게시글 명</th>
							<th>신고유형</th>
							<th>신고사유</th>
							<th>신고받은사람</th>
							<th>신고일</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
					<% if(list.isEmpty()){ %>
						<tr align="center">
							<td colspan="7">신고 내역이 존재하지 않습니다.</td>
						</tr>
					<%}else{ %>
						<%for(MyReport rep : list){ %>
							<tr>
								<td><%= rep.getReportNo() %></td>
								<td><%= rep.getPostName() %></td>
								<td><%= rep.getReportTypeName() %></td>
								<td><%= rep.getReportReason() %></td>
								<td><%= rep.getReportNickName() %></td>
								<td><%= rep.getReportDate() %></td>
								<td><%= rep.getReportCheck() %></td>
							</tr>	
						<%} %>
					<%} %>
					</tbody>
				</table>
				</div>
				<p align="center" style="font-weight:900; font-size:20px"><%= pi.getRepCurrentPage() %>page</p>
				<div class="myReportBottom">
				
				<% if(!list.isEmpty()){ %>
					<% if(pi.getRepCurrentPage() != 1){ %>
						<a href="<%= contextPath %>/reportDetail.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= pi.getRepCurrentPage() -1 %>" class="btn btn-warning" style="color:white;">&lt;&nbsp;&nbsp;PREV</a>				
					<% } %>
					
					
					<% for(int i = pi.getRepStartPage(); i<=pi.getRepEndPage(); i++){ %>
						<a href="<%= contextPath %>/reportDetail.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= i %>" class="btn btn-secondary btn-sm" style="color:white;"><%= i %></a>
					<% } %>
						
					<% if(pi.getRepCurrentPage() != pi.getRepMaxPage()){ %>
						<a href="<%= contextPath %>/reportDetail.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= pi.getRepCurrentPage() +1 %>" class="btn btn-warning" style="color:white;">NEXT&nbsp;&nbsp;&gt;</a>																			
					<% } %>
				<% } %>
			
			</div>
		</div>
	</div>

		<!-- footerbar -->
		<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>