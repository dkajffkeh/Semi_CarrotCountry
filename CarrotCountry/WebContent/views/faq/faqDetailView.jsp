<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.faq.model.vo.Faq" %>
<%
	Faq f = (Faq)request.getAttribute("f");
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
    .border{
    	text-align: left;
    	
    }
    
    </style>
</head>
<body>

	
	<%@ include file="../common/commonNavbar.jsp"%>



    <br><br>

    <div class="outer">
    <h5><%=f.getFaqTitle() %></h5>
    <hr>
    <table>
    <tr>
    	<td width="500">작성자 :<%=f.getMemNo() %></td>
    	
    	<td width="200">작성일 :<%=f.getFaqEnrollDate() %></td>
    </tr>
    </table>
      
        <div class="form-group" align="center">
          <p style="height:500px;" class="border border-warning"><%=f.getFaqContent() %></p>
        </div>
        <div align="center">
			<% if(loginMember != null && loginMember.getMemUserId().equals(f.getMemNo())){ %>
	            <a href="<%= contextPath %>/updateForm.fa.jm?fno=<%= f.getFaqNo() %>" class="btn btn-warning btn-sm">수정하기페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <a href="<%= contextPath %>/delete.fa.jm?fno=<%= f.getFaqNo() %>" class="btn btn-danger btn-sm">삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <% } %>
            <input type="button" value="FAQ게시판" class="btn btn-warning btn-sm"  onclick='location.href="<%=contextPath%>/list.fa.jm"'>
		</div>
   </div>
        

        
        
</body>
</html>