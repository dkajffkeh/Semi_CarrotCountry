<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminMember"%>
<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo"%>
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

<link rel="stylesheet" href="resources/css/adminBoard/adminBoardStyle.css">

</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp" %>
	
	    <!-- content 영역 -->
    <div class="wrap">
        <div id="content">
            <div id="content1">
                <!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp" %>
            </div>
            <div id="content2">
                <div id="pageName">
                    <h3>블랙리스트 관리</h3>
                </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="" class="form-inline my-2 my-lg-0" id="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 블랙리스트회원 리스트 조회 -->
					<div id="board">
						<table class="table table-sm table-hover">
							<thead class="thead">
								<tr class="d-flax">
									<th width="50">번호</th>
									<th width="100">아이디</th>
									<th width="80">이름</th>
									<th width="150">연락처</th>
									<th width="200">이메일</th>
									<th width="100">신고횟수</th>
									<th width="200">사유</th>
									<th width="100">블랙</th>
								</tr>
							</thead>
							<tbody class="tbody">
							
								<% if (list.isEmpty()) { %>
									<tr>
										<th colspan="8">조회된 리스트가 없습니다.</th>
									</tr>
								<% } else { %>
									<% for (AdminMember am : list) { %>
										<tr>
											<td><%= am.getMemNo() %></td>
											<td><%= am.getMemUserId() %></td>
											<td><%= am.getMemName() %></td>
											<td><%= am.getMemPhone() %></td>
											<td><%= am.getMemEmail() %></td>
											<td><%= am.getReportCount() %></td>
											<td>욕설/비방에 따른 제재</td>
											<td>
												<!-- 클릭 시 블랙리스트 해제  -->
												<a href="<%= contextPath %>/blacklistEnroll.sb?&memNo=<%= am.getMemNo() %>&bList=N" class="btn btn-outline-danger btn-sm">해제</a>
											</td>
										</tr>
									<% } %>
								<% } %>

							</tbody>
						</table>
					</div>
					
					<!-- 페이지 번호 -->
                    <div id="boardNum" align="center">
						<% if (pi.getCurrentPage() != 1) { %>
				            <a href="<%= contextPath %>/blackList.sb?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
						<% } %>
			
						<% for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            <a href="<%= contextPath %>/blackList.sb?currentPage=<%= p %>"><%= p %></a>
						<% } %>
			
						<% if (pi.getCurrentPage() != pi.getMaxPage()) { %>
				            <a href="<%= contextPath %>/blackList.sb?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt;</a>
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