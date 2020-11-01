<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo"%>
<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AdminPageInfo pi = (AdminPageInfo)request.getAttribute("pi");
	ArrayList<AdminMember> list = (ArrayList<AdminMember>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<link rel="stylesheet"
	href="resources/css/adminBoard/adminBoardStyle.css">

</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp"%>

	<!-- content영역 -->
	<div class="wrap">
		<div id="content">
			<div id="content1">
				<!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp"%>
			</div>

			<div id="content2">
				<!-- 페이지 제목 -->
				<div id="pageName">
					<h3>회원조회</h3>
				</div>
				<div id="pageContent">
					<!-- search -->
					<form action="" class="form-inline my-2 my-lg-0" id="search">
						<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
					</form>
					<!-- 회원조회 리스트 -->
					<div id="board">
						<table class="table table-sm table-hover">
							<thead class="thead">
								<tr class="d-flax">
									<th width="80">회원번호</th>
									<th width="100">아이디</th>
									<th width="80">이름</th>
									<th width="150">연락처</th>
									<th width="150">이메일</th>
									<th width="100">생년월일</th>
									<th width="100">가입일</th>
									<th width="80">블랙 Y/N</th>
									<th width="100">블랙리스트</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<% for (AdminMember am : list) { %>
									<tr>
										<td><%= am.getMemNo() %></td>
										<td><%= am.getMemUserId() %></td>
										<td><%= am.getMemName() %></td>
										<td><%= am.getMemPhone() %></td>
										<td><%= am.getMemEmail() %></td>
										<td><%= am.getMemBirthday() %></td>
										<td><%= am.getMemEnrollDate() %></td>
										<td><%= am.getbListCheck() %></td>
										<!-- 블랙 Y/N이 Y일 경우 안보임 -->
										<td>
											<% if (am.getbListCheck().equals("N")) { %>
												<!-- 클릭 시 블랙리스트 등록  -->
												<a href="<%= contextPath %>/blacklistEnroll.sb?&memNo=<%= am.getMemNo() %>&bList=Y" class="btn btn-outline-danger btn-sm">등록</a>	
											<% } %>
										</td>
									</tr>
								<% } %>
							</tbody>
						</table>
					</div>
					<!-- 페이지 번호 -->
					<div id="boardNum" align="center">
						<% if (pi.getCurrentPage() != 1) { %>
				            <a href="<%= contextPath %>/userList.sb?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
						<% } %>
			
						<% for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            <a href="<%= contextPath %>/userList.sb?currentPage=<%= p %>"><%= p %></a>
						<% } %>
			
						<% if (pi.getCurrentPage() != pi.getMaxPage()) { %>
				            <a href="<%= contextPath %>/userList.sb?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt;</a>
						<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer 영역 -->
	<%@ include file="../common/footerbar.jsp"%>

</body>
</html>