<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminBoard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javachip.carrotcountry.adminBoard.model.vo.AdminPageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	AdminPageInfo pi = (AdminPageInfo)request.getAttribute("pi");
	ArrayList<AdminBoard> list = (ArrayList<AdminBoard>)request.getAttribute("list");
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
                <!-- 페이지 제목 -->
                <div id="pageName">
                    <h3>게시글 조회</h3>
                </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="<%= contextPath %>/boardSearchList.sb" class="form-inline my-2 my-lg-0" id="search">
                    	<input type="hidden" name="currentPage" value=1>
						<select name="searchCategory" id="searchCategory">
						  <option value="post_name">게시글명</option>
						  <option value="category_name">카테고리</option>
						  <option value="mem_userid">작성자</option>
						</select>
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 게시글 리스트 -->
                    <div id="board">
						<table class="table table-sm table-hover">
							<thead class="thead-dark">
								<tr>
									<th width="60">글번호</th>
									<th width="80">글종류</th>
									<th width="150">카테고리</th>
									<th width="200">글제목</th>
									<th width="80">작성자</th>
									<th width="100">작성일</th>
									<th width="60">조회수</th>
									<th width="100">블라인드Y/N</th>
									<th width="80">블라인드</th>
								</tr>
							</thead>
							<tbody class="tbody">
								<% if (list.isEmpty()) { %>
									<tr>
										<th colspan="8">조회된 리스트가 없습니다.</th>
									</tr>
								<% } else { %>
									<c:forEach items="${list}" var="ab">
										<tr>
											<td>${ab.postNo}</td>
											<c:choose>
												<c:when test="${ab.postType == 1}">
													<td>중고거래</td>
												</c:when>
												<c:otherwise>
													<td>공동구매</td>
												</c:otherwise>
											</c:choose>
											<td>${ab.categoryName}</td>
											<td>${ab.postName}</td>
											<td>${ab.memNo}</td>
											<td>${ab.postEnrollDate}</td>
											<td>${ab.postViews}</td>
											<td>${ab.blindCheck}</td>
											<!-- 블라인드 Y/N이 Y일 경우 안보임 -->
											<!-- 클릭시 게시물 블라인드 => 알림 -->
											<c:if test="${ab.blindCheck eq 'N'}">
												<td>
													<button onclick="registBlindList(${ab.postNo});" class="btn btn-outline-danger btn-sm">등록</button>
												</td>
											</c:if>
											<c:if test="${ab.blindCheck eq 'Y'}">
												<td></td>
											</c:if>
										</tr>
									</c:forEach>
								<% } %>
							</tbody>
						</table>
					</div>
                    <!-- 페이지 번호 -->
                    <div id="boardNum" align="center">
                        <% if (pi.getCurrentPage() != 1) { %>
				            <a href="<%= contextPath %>/boardSelect.sb?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
						<% } %>
			
						<% for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				            <a href="<%= contextPath %>/boardSelect.sb?currentPage=<%= p %>"><%= p %></a>
						<% } %>
			
						<% if (pi.getCurrentPage() != pi.getMaxPage()) { %>
				            <a href="<%= contextPath %>/boardSelect.sb?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt;</a>
						<% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
		function registBlindList(postNo) {
			const registYN = confirm('등록하시겠습니까?');
			const url = "<%= contextPath %>/blindEnroll.sb?&postNo=" + postNo + "&bCheck=Y";
			if(registYN){
				location.href = url;
			}
		}
	</script>
    <!-- footer 영역 -->
    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>