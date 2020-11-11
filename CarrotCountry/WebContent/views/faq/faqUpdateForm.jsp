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

      
    <form action="<%=contextPath %>/update.fa.jm">
    <input type="hidden" name="fno" value="<%= f.getFaqNo() %>">
      <table>
        <tr>
          <td>제목 :</td>
          <td><input type="text" value="<%=f.getFaqTitle() %>" name="title"></td>
        </tr>
        <tr>
        <td width="80">카테고리 :</td>
          <td width="500">
            <select name="category" id="category">
              <option value="11">운영정책</option>
              <option value="22">계정/인증</option>
              <option value="33">중고구매/판매</option>
              <option value="44">거래품목</option>
              <option value="55">신고관련</option>
              <option value="66">공동구매/판매</option>
              <option value="77">이용 제재</option>
              <option value="88">블랙리스트관련</option>
              <option value="99">공구문의</option>
            </select>
          </td>
        </tr>
      </table>
      <br>
      <div class="form-group" align="center">
        <textarea class="border border-warning" cols="95" rows="20" id="comment" name="content" style="resize: none"><%=f.getFaqContent() %></textarea>
      </div>
      <div align="center">
        <input type="submit" value="업데이트" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <input type="button" value="뒤로가기" onclick="history.back();" class="btn btn-warning btn-sm">
      </div>
    </form>
      
      
  </div>
</body>
</html>