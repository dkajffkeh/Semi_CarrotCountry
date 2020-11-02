<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminReport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AdminPageInfo pi = (AdminPageInfo)request.getAttribute("pi");
	ArrayList<AdminReport> list = (ArrayList<AdminReport>)request.getAttribute("list");
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

	<!-- content 영역 -->
	<div class="wrap">
		<div id="content">
			<div id="content1">
				<!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp" %>
			</div>
			<div id="content2">
				<!-- 페이지 제목 -->
				<div id="pageName">
					<h3>신고조회</h3>
				</div>
				<div id="pageContent">
					<!-- search -->
					<form action="<%= contextPath %>/reportSearchList.sb" class="form-inline my-2 my-lg-0" id="search">
                    	<input type="hidden" name="currentPage" value=1>
						<select name="searchCategory" id="searchCategory">
						  <option value="post_name">작성자</option>
						</select>
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
					<!-- 신고자 리스트 -->
					<div id="board">
						<form action="">
							<table class="table table-sm table-hover">
								<thead class="thead">
									<tr class="d-flax">
										<th width="70">신고번호</th>
										<th width="100">신고일</th>
										<th width="100">글번호</th>
										<th width="100">글유형</th>
										<th width="200">신고사유</th>
										<th width="100">작성자</th>
										<th width="50">비고</th>
									</tr>
								</thead>
								<tbody>
									<% if (list.isEmpty()) { %>
										<tr>
											<th colspan="7">조회된 리스트가 없습니다.</th>
										</tr>
									<% } else { %>
										<% for (AdminReport ar : list) { %>
											<tr>
												<td><%= ar.getReportNo() %></td>
												<td><%= ar.getReportDate() %></td>
												<td><%= ar.getReportTypeNo() %></td>
												<td><%= ar.getReportNo() %></td>
												<td><%= ar.getReportReason() %></td>
												<td><%= ar.getMemNo() %></td>
												<td></td>
											</tr>
										<% } %>
									<% } %>
								</tbody>
							</table>
						</form>
					</div>
					<!-- 페이지 번호 -->
					<div id="boardNum" align="center">
						<% if (pi.getCurrentPage() != 1) { %>
				            <a href="<%= contextPath %>/reportSelect.sb?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
						<% } %>
			
						<% for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            <a href="<%= contextPath %>/reportSelect.sb?currentPage=<%= p %>"><%= p %></a>
						<% } %>
			
						<% if (pi.getCurrentPage() != pi.getMaxPage()) { %>
				            <a href="<%= contextPath %>/reportSelect.sb?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt;</a>
						<% } %>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer 영역 -->
    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>