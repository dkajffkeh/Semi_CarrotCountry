<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<!--  mypageMenubar -->
	
<div class="outer">


	
	<br><br>
	<h4>공지사항 등록</h4>
	<hr>
	<form action="<%= contextPath %>/insert.no.jm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
	    <ul>
	        <li>

	           	<div style="width:400px;">
	           	<label for="title">
	               	 제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            </label>
	           	<input type="text" class="form-control" name="title" id="title" maxlength="20" required>
	           	</div>
	            
	        </li>
	    </ul>
	    <ul>
	        <li>
	            <label for="file">
	              	파일첨부&nbsp;&nbsp;
	            </label>
	            <input type="file" name="upfile" id="file">
	            
	        </li>
	        <small>파일 총 용량이 10MB 미만인 경우만 등록 가능합니다 (등록가능파일:jpg,gif,bmp)</small>
	    </ul>
	    <ul>
	        <li>
	            <label for="content">내용</label>
	            <br>
	            <textarea name="content" class="form-control" id="content" cols="60" rows="10" style="resize: none" required></textarea>
	        </li>
	    </ul>
	    
	    
	    
	    <div id="replyArea">
        	<table border="1" align="center">
        		<thead>
        			<tr>
        				<th>댓글작성</th>
        				<% if(loginMember == null){ // 로그인 전 %>
	        				<td>
	        					<textarea cols="50" rows="2" style="resize:none" readonly>로그인후 이용가능한 서비스입니다.</textarea>
	        				</td>
	        				<td><button disabled>댓글등록</button></td>
        				<%}else{ // 로그인 후 %>
	        				<td>
	        					<input type="hidden" value="<%= loginMember.getMemNo() %>" id="userNo">
	        					<textarea cols="50" rows="2" style="resize:none" id="replyContent"></textarea>
	        				</td>
	        				<td><button onclick="addReply();">댓글등록</button></td>
        				<%} %>
        			</tr>
        		</thead>
        		<tbody>
        			
        		</tbody>
        	</table>
        </div>
	    
	    
	    
	    
	    
        <div align="center">
          <input type="submit" value="작성하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
          <input type="button" value="뒤로가기" class="btn btn-warning btn-sm" onclick="history.back();">
        </div>
	
	</form>
	<br><br><br><br><br>
        
</div>
</body>
</html>