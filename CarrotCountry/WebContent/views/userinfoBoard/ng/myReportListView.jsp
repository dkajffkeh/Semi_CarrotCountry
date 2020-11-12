<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoardNg.model.vo.*, java.util.ArrayList" %>
    
<%
	RepPageInfo pi = (RepPageInfo)request.getAttribute("pi");
	ArrayList<MyReport> list = (ArrayList<MyReport>)request.getAttribute("list");
	
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
							<th width="8%">신고번호</th>
							<th width="34%">게시글 명</th>
							<th width="10%">신고유형</th>
							<th width="10%">신고사유</th>
							<th width="10%">신고받은사람</th>
							<th width="12%">신고일</th>
							<th width="8%">상태</th>
							<th width="8%">신고내용</th>
						</tr>
					</thead>
					<% if(list.isEmpty()){ %>
						<tr align="center">
							<td colspan="8">신고 내역이 존재하지 않습니다.</td>
						</tr>
					<% }else{ %>
					<tbody>
						<%for(MyReport rep : list){ %>
							<tr>
								<td><%= rep.getReportNo() %></td>
								<td><%= rep.getPostName() %></td>
								<td><%= rep.getReportTypeName() %></td>
								<td><%= rep.getReportReason() %></td>
								<td><%= rep.getReportNickName() %></td>
								<td><%= rep.getReportDate() %></td>
								<td><%= rep.getReportCheck().equals("N") ? "처리중" : "처리완료"%></td>
								<td>				
									<button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target=".re<%= rep.getReportNo() %>">
										보기
									</button>
								</td>
							</tr>
							
							<!-- 모달 -->
							<div class="modal fade re<%= rep.getReportNo() %>" id="myModal">
							  <div class="modal-dialog">
							    <div class="modal-content">
							
							      <!-- Modal Header -->
							      <div class="modal-header">
							        <h4 class="modal-title">신고 내용</h4> 
							      </div>
							
							      <form action="reportUpdate.re.ng" method="post">
								      <!-- Modal body -->
								      <div class="modal-body">
									      	<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
									      	<input type="hidden" name="reportNo" value="<%= rep.getReportNo() %>">
									      	<textarea cols="62" rows="10" style="resize:none;" name="reportContent">
									      		<%= rep.getReportContent() == null ? "신고내용을 입력해주세요." : rep.getReportContent() %>
									      	</textarea>
									  </div>
										
								      <!-- Modal footer -->
								      <div class="modal-footer">
							      	  <button type="submit"  class="btn btn-warning">수정하기</button> 	
								      <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
								      </div>
							
							      </form>
							    </div>
							  </div>
						    </div>
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
</div>

	<!-- footerbar -->
	<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>