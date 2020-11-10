<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.oneTo.model.vo.*, java.util.ArrayList,com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo" %>

<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<OneTo> list = (ArrayList<OneTo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<%@ include file="../adminBoard/adminMenubar.jsp" %>
			</div>
			<div id="content2">
				<!-- 페이지 제목 -->
				<div id="pageName">
					<h3>문의조회</h3>
					<hr>
				</div>
				<div id="pageContent">
					<!-- search -->
					<!--  
					<form action="<%= contextPath %>/reportSearchList.sb" class="form-inline my-2 my-lg-0" id="search">
                    	<input type="hidden" name="currentPage" value=1>
						<select name="searchCategory" id="searchCategory">
						  <option value="mem_userid">작성자</option>
						  <option value="report_type_name">글유형</option>
						</select>
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    -->
					<!-- 신고자 리스트 -->
					<div id="board">

								<% if (list.isEmpty()) { %>
								<div align="center">
									<h2>문의사항이 없습니다.</h2>
								</div>
									
								<% } else { %>
									<table class="table table-sm table-hover list-area">
										<thead class="thead-dark table-fixed">
											<tr class="d-flax">
												<th width="60">문의번호</th>
												<th width="70">문의일</th>
												<th width="90">문의유형</th>
												<th width="200">문의제목</th>
												<th width="55">답변자</th>
												<th width="55">문의자</th>
												<th width="60">문의상태</th>
											</tr>
										</thead>
									<% for (OneTo o : list) { %>

										<tbody class="tbody">
										<tr>
											<td><%= o.getOneToNo() %></td>
											<td><%= o.getAnswerDate() %></td>
											<td><%= o.getOneToType() %></td>
											<td><%= o.getOneToName() %></td>
											<td><%= o.getWriterNo() %></td>
											<td><%= o.getWriterNo() %></td>
											<td><%= o.getAnswerState().equals("N")? "문의중" : "답변완료" %></td>
											
										</tr>
									<% } %>
								<% } %>
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
					
					
					
					
					
					<!-- 페이지 번호 -->
					<div id="boardNum" align="center">
						<% if (pi.getCurrentPage() != 1) { %>
				            <a href="<%= contextPath %>/adList.on.jm?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
						<% } %>
			
						<% for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            <a href="<%= contextPath %>/adList.on.jm?currentPage=<%= p %>"><%= p %></a>
						<% } %>
			
						<% if (pi.getCurrentPage() != pi.getMaxPage()) { %>
				            <a href="<%= contextPath %>/adList.on.jm?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt;</a>
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