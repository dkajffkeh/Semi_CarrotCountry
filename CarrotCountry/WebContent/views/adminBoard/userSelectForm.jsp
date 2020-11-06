<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo"%>
<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminMember"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AdminPageInfo pi = (AdminPageInfo)request.getAttribute("pi");
	ArrayList<AdminMember> list = (ArrayList<AdminMember>)request.getAttribute("list");
%>

<title>관리자 페이지</title>

<link rel="stylesheet" href="resources/css/adminBoard/adminBoardStyle.css">

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp"%>

	<!-- content영역 -->
	<div class="wrap">
		<div id="content">
			<div id="content1">
				<!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp" %>
			</div>

			<div id="content2">
				<!-- 페이지 제목 -->
				<div id="pageName">
					<h3>회원조회</h3>
				</div>
				<div id="pageContent">
					<!-- search -->
					<form action="<%= contextPath %>/userSearchList.sb" class="form-inline my-2 my-lg-0" id="search">
						<input type="hidden" name="currentPage" value=1>
						<select name="searchCategory" id="searchCategory">
						  <option value="mem_name">회원명</option>
						  <option value="mem_userid">회원아이디</option>
						  <option value="mem_birthday">생년월일</option>
						  <option value="mem_phone">전화번호</option>
						</select>
						<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
						<button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
					</form>
					<!-- 회원조회 리스트 -->
					<div id="board">
						<table class="table table-sm table-hover">
							<thead class="thead-dark">
								<tr class="d-flax">
									<th width="80">회원번호</th>
									<th width="100">아이디</th>
									<th width="80">회원명</th>
									<th width="150">전화번호</th>
									<th width="150">이메일</th>
									<th width="100">생년월일</th>
									<th width="100">가입일</th>
									<th width="80">블랙 Y/N</th>
									<th width="100">블랙리스트</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<% if (list.isEmpty()) { %>
									<tr>
										<th colspan="9">조회된 리스트가 없습니다.</th>
									</tr>
								<% } else { %>
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
													<button onclick="registBlackList(<%= am.getMemNo() %>);" class="btn btn-outline-danger btn-sm">등록</button>
												<% } %>
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
	<script>
		function registBlackList(memNo) {
			const registYN = confirm('등록하시겠습니까?');
			const url = "<%= contextPath %>/blacklistEnroll.sb?&memNo=" + memNo + "&bList=Y";
			if(registYN){
				location.href = url;
			}
		}
	</script>
	<!-- footer 영역 -->
	<%@ include file="../common/footerbar.jsp"%>

</body>
</html>