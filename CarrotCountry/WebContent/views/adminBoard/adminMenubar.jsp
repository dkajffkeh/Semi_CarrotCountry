<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPathAdmin = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/adminBoard/adminMenubar.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="navWrap">
        <div id="menuTitle">관리페이지</div>
        <table class="navMenu table-hover">
            <tr>
                <th>회원 관리</th>
            </tr>
            <tr>
                <td><a href="<%= contextPathAdmin %>/userList.sb?currentPage=1">회원조회</a></td>
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
                <td><a href="<%= contextPathAdmin %>/reportSelect.sb">신고조회</a></td>
            </tr>
            <tr>
                <th>공지사항관리</th>
            </tr>
        </table>
    </div>
</body>
</html>