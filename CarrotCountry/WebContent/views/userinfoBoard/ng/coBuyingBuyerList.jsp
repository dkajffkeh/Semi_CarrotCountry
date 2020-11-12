<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoardNg.model.vo.*, java.util.ArrayList" %>

<%
	RepPageInfo pi = (RepPageInfo)request.getAttribute("pi");
	ArrayList<MyPurchaseInfo> list = (ArrayList<MyPurchaseInfo>)request.getAttribute("list");

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
		       	<h1>내 게시글 (구매자 리스트)</h1>
		        <hr color="gray">
		        
				<div class="wrapReport">
				<table class="table table-striped table-hover" style="text-align:center">
					<thead>
						<tr style="background:gray; color:white;">
							<th width="8%">구매번호</th>
							<th width="34%">회원명</th>
							<th width="10%">구매일</th>
							<th width="8%">배송하기</th>
						</tr>
					</thead>
					<% if(list.isEmpty()){ %>
						<tr align="center">
							<td colspan="8">공동구매를 신청한 회원이 없습니다.</td>
						</tr>
					<% }else{ %>
					<tbody>
						<%for(MyPurchaseInfo mpi : list){ %>
							<tr>
								<td><%= mpi.getPurchaseNo() %></td>
								<td><%= mpi.getDepositor() %></td>
								<td><%= mpi.getPurchaseDate() %></td>
								<td>				
									<button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target=".re<%= mpi.getPurchaseNo() %>">
										<%= mpi.getCourier() == null && mpi.getTrackingNo() == 0 ? "배송하기" : "배송완료"%>
									</button>
								</td>
							</tr>
							
							<!-- 모달 -->
							<div class="modal fade re<%= mpi.getPurchaseNo() %>" id="myModal">
							  <div class="modal-dialog">
							    <div class="modal-content">
							
							      <!-- Modal Header -->
							      <div class="modal-header">
							        <h4 class="modal-title">배송 입력</h4> 
							      </div>
							
							      <form action="<%= contextPath %>/buyingUpdate.co.ng" method="post">
								      <!-- Modal body -->
								      <div class="modal-body">
								      		<input type="hidden" name="postNo" value="<%= mpi.getPostNo() %>">
									      	<input type="hidden" name="purchaseNo" value="<%= mpi.getPurchaseNo() %>">
									      	<p>택배사 입력을 해주세요</p>
									      	<input style="width:450px" type="text" name="courier" value="<%= mpi.getCourier() %>">

									      	<p>송장번호를 입력해 주세요(숫자만 입력)</p>
									      	<input style="width:450px" type="number" name="trackingNo" value="<%= mpi.getTrackingNo() %>">
									  </div>
										
								      <!-- Modal footer -->
								      <div class="modal-footer">
							      	  <button type="submit"  class="btn btn-warning"> <%= mpi.getCourier() == null && mpi.getTrackingNo() == 0 ? "배송하기" : "배송 수정하기"%> </button> 	
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
			<div align="center"><button class="btn btn-warning" onclick="history.back();">뒤로가기</button></div>
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