<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String contextPathAdmin = request.getContextPath();
%>

<link rel="stylesheet" href="resources/css/adminBoard/adminMenubar.css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">

<body>
    <div class="navWrap">
        <div id="menuTitle">관리페이지</div>
        <table class="navMenu table-hover">
            <tr>
                <th>회원 관리</th>
            </tr>
            <tr>
                <td><a href="<%= request.getContextPath() %>/userList.sb?currentPage=1">회원조회</a></td>
            </tr>
                <td><a href="<%= contextPathAdmin %>/blackList.sb?currentPage=1">블랙리스트관리</a></td>
            <tr>
                <th>게시물관리</th>
            </tr>
            <tr>
                <td><a href="<%= contextPathAdmin %>/boardSelect.sb?currentPage=1">게시물조회</a></td>
            </tr>
            <tr>
                <td><a href="<%= contextPathAdmin %>/blindList.sb?currentPage=1">블라인드게시물 관리</a></td>
            </tr>
            <tr>
                <th>신고관리</th>
            </tr>
            <tr>
                <td><a href="<%= contextPathAdmin %>/reportSelect.sb?currentPage=1">신고조회</a></td>
            </tr>
            
            <tr>
            	<th>1:1문의관리</th>
            </tr>
            <tr>
            	<td><a href="<%= contextPathAdmin %>/adList.on.jm?currentPage=1">문의조회</a>
            </tr>
            
            <tr>
                <th>공지사항관리</th>
            </tr>
        </table>
    </div>
</body>
</html>