<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.oneTo.model.vo.*" %>
<%
	OneTo o = (OneTo)request.getAttribute("o");
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





	<%@ include file= "../common/commonNavbar.jsp"%>
    <div class="outer">
      <h5>상세보기</h5>
      <hr>

      
      <div class="d-flex p-3">
        <div class="p-2">제목 : </div>
        <div class="p-2"><%=o.getOneToName() %></div>
        <div class="p-2">카테고리 : </div>
        <div class="p-2"><%=o.getOneToType() %></div>
      </div>
      <div class="p-2">답변상태 : <%=o.getAnswerState().equals("N")?"문의중" : "답변완료" %></div>

      
      <br>
      <div class="form-group">
        <p style="height:200px" class="border border-warning"><%=o.getOneToContent() %></p>
      </div>
		<!-- 답변이 완료됬을때 -->
      <div class="d-flex p-3">
        <div class="p-2">답변자 :</div>
        <div class="p-2"><%=loginMember.getMemNickname()%></div>
      </div>
      <form action="<%= contextPath %>/answer.on.jm" method="post">
      <input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
      <input type="hidden" name="ono" value="<%= o.getOneToNo() %>">
      	<textarea name="content" id="content" cols="97" rows="10" style="resize: none" class="border border-warning" required></textarea>
      	<div align="center">
          <input type="submit" value="작성하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
          <input type="button" value="뒤로가기" class="btn btn-warning btn-sm" onclick="history.back();">
        </div>
      </form>

      
  </div>
</body>
</html>