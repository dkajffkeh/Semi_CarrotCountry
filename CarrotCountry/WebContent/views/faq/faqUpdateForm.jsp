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
.CS_content{
       width:700px;
       height:800px;
       margin:auto;
       margin-top:50px;
}

</style>
</head>
<body>

	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="CS_content">
      <h5>FAQ수정하기</h5>
      <hr>

      
    <form action="<%=contextPath %>update.fa.jm">
      <table>
        <tr>
          <td>제목 :</td>
          <td><input type="text" value="<%=f.getFaqTitle() %>" name="title"></td>
        </tr>
      </table>
      
      <br>
      <div class="form-group" align="center">
        <textarea class="border border-warning" cols="95" rows="20" id="comment" name="content" style="resize: none"><%=f.getFaqContent() %></textarea>
      </div>
      <div align="center">
        <input type="submit" value="업데이트" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <input type="button" value="뒤로가기" class="btn btn-warning btn-sm">
      </div>
    </form>
      
      
  </div>
</body>
</html>