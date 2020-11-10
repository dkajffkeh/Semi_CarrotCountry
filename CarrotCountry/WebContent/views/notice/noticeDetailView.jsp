<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.notice.model.vo.*" %>    
<%
	Notice n = (Notice)request.getAttribute("n");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>


    .outer{
        width:1000px;
        height:1000px;
        margin:auto;
        margin-top:50px;
    }
    
    </style>
</head>
<body>
		<!-- 성공적으로 삭제되었습니다 alert -->
	<% if(alertMsg != null){ %>
		<script>
			alert("<%= alertMsg %>");	
		</script>
		
		<%
			session.removeAttribute("alertMsg");
		%>
	<%} %>
	<%@ include file="../common/commonNavbar.jsp"%>
	<input type="hidden" name="nno" value="<%= n.getNoticeNo() %>">
	<div class="outer">

        <br>
        <h2 align="center">공지사항 상세보기</h2>
        <br>

        <table id="detail-area" align="center" border="1">
            <tr>
                <th width="150"><li>제목</li></th>
                <td width="300" colspan="5""><%= n.getNoticeTitle() %></td>
            </tr>
            <tr>
                <th><li>작성자</li></th>
                <td><%= n.getMemNo() %></td>
                <td width="300"></td>
                <th><li>작성일</li></th>
                <td>&nbsp;&nbsp;<%= n.getNoticeEnrollDate() %></td>
                <td width="200"></td>
                
            </tr>
            <tr>
                <th><li>내용</li></th>
                <td colspan="5">
                    <p style="height:800px" class="border border-warning"><%=n.getNoticeContent()%></p>
                </td>
            </tr>
            <tr>
                <th><li>첨부파일</li></th>
                <td colspan="5">
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
            <input type="button" value="공지사항바로가기" class="btn btn-warning btn-sm"  onclick='location.href="<%=contextPath%>/list.no.jm?currentPage=1"'>
		</div>

    </div>
	<br><br><br><br><br><br><br><br><br><br>
        
</div>
</body>
</html>