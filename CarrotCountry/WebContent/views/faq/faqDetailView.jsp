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
</head>
<body>

	
	<%@ include file="../common/commonNavbar.jsp"%>



    <br><br>
        
    <div class="container">
      <h2>제목</h2>
      <hr>
    <pre><%=f.getFaqWriter() %>                                                                 작성일 <%=f.getFaqEnrollDate() %></pre>
      
        <div class="form-group">
          <textarea class="border border-warning" cols="60" rows="20" id="comment" name="text" style="resize: none">test</textarea>
        </div>
    <div align="center">
        <input type="submit" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <input type="button" value="뒤로가기" class="btn btn-warning btn-sm">
    </div>

   </div>
        

        
        
    </div>
</body>
</html>