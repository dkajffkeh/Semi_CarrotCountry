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
      <%if(o.getAnswerState().equals("Y")){ %>
      <div class="d-flex p-3">
        <div class="p-2">답변자 :</div>
        <div class="p-2"><%=o.getAnswererNo() %></div>
      </div>
      <p style="height:200px" class="border border-warning"><%=o.getAnswerContent() %></p>
      <%} %>
      <div align="center">
      
      
      
      	<!-- 관리자 -->
      	<%if(loginMember.getManagerCheck().equals("Y")){ %>
        <a href="<%= contextPath %>/answerForm.on.jm?ono=<%= o.getOneToNo() %>" class="btn btn-warning btn-sm">답변하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%} %>
        <!-- 사용자 -->
        <a href="<%= contextPath %>/modify.on.jm?ono=<%= o.getOneToNo() %>" class="btn btn-warning btn-sm">수정하기페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" value="뒤로가기" class="btn btn-warning btn-sm">
      </div>
      
  </div>
</body>
</html>