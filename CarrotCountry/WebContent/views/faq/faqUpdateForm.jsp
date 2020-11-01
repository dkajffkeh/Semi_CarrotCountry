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
.CS_content>div{
    width:100%;
    margin:auto;
    padding:100px;

}

</style>
</head>
<body>

	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="CS_content">
        <h2>FAQ수정하기</h2>
        <hr>
        <h5>제목</h5>
        <pre>작성자                                          작성일 xxxx-xx-xx</pre>
          
        <div class="form-group">
          <textarea class="border border-warning" cols="60" rows="20" id="comment" name="text" style="resize: none"></textarea>
        </div>
        <div align="center">
          <input type="submit" value="업데이트" class="btn btn-warning btn-sm">&nbsp;&nbsp;
          <input type="button" value="뒤로가기" class="btn btn-warning btn-sm">
        </div>

        
        
    </div>
</body>
</html>