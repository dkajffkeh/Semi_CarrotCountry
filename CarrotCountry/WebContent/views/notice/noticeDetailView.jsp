<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.notice.model.vo.*" %>    
<%
	Notice n = (Notice)request.getAttribute("n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>


    .outer{
        width:700px;
        height:800px;
        margin:auto;
        margin-top:50px;
    }
    
    </style>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
	
	<div class="outer">

        <br>
        <h2 align="center">일반게시판 상세보기</h2>
        <br>

        <table id="detail-area" align="center" border="1">
            <tr>
                <th width="70">제목</th>
                <td width="350"colspan="3"><%= n.getNoticeTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= n.getMemNo() %></td>
                <th>작성일</th>
                <td><%= n.getNoticeEnrollDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p style="height:200px"><%= n.getNoticeContent()%></p>
                </td>
            </tr>
            <tr>
                <th>첨부파일</th>
                <td colspan="3">
                	<% if(n.getFileOriginName() == null) { %>
                    	<!--첨부파일이 없을 경우-->
                    	첨부파일이 없습니다.
					<% }else{ %>
	                    <!--첨부파일이 있을 경우-->
	                    <a download="<%= n.getFileOriginName() %>" href="<%= contextPath %>/<%= n.getFilePath() + n.getFileModifyName() %>"><%= n.getFileOriginName() %></a>
                	<% } %>
                </td>
            </tr>
        </table>

        <br>

        <div align="center">
			<% if(loginMember != null && loginMember.getMemUserId().equals(n.getMemNo())){ %>
	            <a href="<%= contextPath %>/updateForm.no.jm?nno=<%= n.getNoticeNo() %>" class="btn btn-warning btn-sm">수정하기페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="<%= contextPath %>/delete.no.jm?nno=<%= n.getNoticeNo() %>" class="btn btn-danger btn-sm">삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <% } %>
            <input type="button" value="공지사항바로가기" class="btn btn-warning btn-sm"  onclick='location.href="<%=contextPath%>/list.no.jm?nno=1"'>
		</div>

    </div>
	<br><br><br><br><br>
        
</div>
</body>
</html>