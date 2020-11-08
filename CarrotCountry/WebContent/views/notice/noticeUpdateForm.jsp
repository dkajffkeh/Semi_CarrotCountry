<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.notice.model.vo.*" %>    
<%
	Notice n = (Notice)request.getAttribute("n");
	//System.out.println(n);
//게시글번호, 	카테고리명, 제목, 내용, 작성자아이디, 작성일, 원본명, 실제서버에업로드된명, 저장경로, null
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


	
	<br><br>
	<h4>공지사항 등록</h4>
	<hr>
	<form action="<%= contextPath %>/update.no.jm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="nno" value="<%= n.getNoticeNo() %>">
	    <ul>
	        <li>
	            <label for="title">
	               	 제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            </label>
	            <input type="text" value="<%=n.getNoticeTitle() %>" name="title" id="title" required>
	        </li>
	    </ul>
	    
	    <ul>
	        <li>
			<% if(n.getFileOriginName() != null) { %>
			
				<%= n.getFileOriginName() %> <br>
				
				<input type="hidden" name="originFileName" value="<%= n.getFileModifyName() %>">
			
			<% } %>
			
			<input type="file" name="reUpfile">
	        </li>
	        <small>파일 총 용량이 10MB 미만인 경우만 등록 가능합니다 (등록가능파일:jpg,gif,bmp)</small>
	    </ul>
	    
	    <ul>
	        <li>
	            <label for="content">내용</label>
	            <br>
	            <textarea name="content" id="content" cols="60" rows="10" style="resize: none" required><%=n.getNoticeContent() %></textarea>
	        </li>
	    </ul>
	    
        <div align="center">
          <input type="submit" value="수정하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
          <input type="button" value="뒤로가기" class="btn btn-warning btn-sm" onclick="history.back();">
        </div>
	
	</form>
	<br><br><br><br><br>
        
</div>
</body>
</html>