<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="navWrap">
        <div id="menuTitle">관리페이지</div>
        <table class="navMenu table-hover">
            <tr>
                <th>회원 관리</th>
            </tr>
            <tr>
                <td><a href="carrot/userSelect.sb">회원조회</a></td>
            </tr>
                <td><a href="carrot/blackList.sb">블랙리스트관리</a></td>
            <tr>
                <th>게시물관리</th>
            </tr>
            <tr>
                <td><a href="carrot/postSelect.sb">게시물조회</a></td>
            </tr>
            <tr>
                <td><a href="carrot/blindList.sb">블라인드게시물 관리</a></td>
            </tr>
            <tr>
                <th>신고관리</th>
            </tr>
            <tr>
                <td><a href="carrot/reqortSelect.sb">신고조회</a></td>
            </tr>
            <tr>
                <th>공지사항관리</th>
            </tr>
        </table>
    </div>
</body>
</html>