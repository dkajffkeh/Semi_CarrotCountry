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
	    <div align="center">
	    <br>
        <h2>FAQ게시판작성하기</h2>
        <hr>
        <form action="<%=contextPath%>/insert.fa.jm" method="POST">
        <input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
            <table>
            <tr>
              <td width="55">제목:</td>&nbsp;
              <td><input type="text" class="form-control" name="faqTitle"></td>
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
        
         
        <div class="form-group">
          <textarea class="border border-warning" cols="60" rows="20" id="comment" name="faqContent" style="resize: none"></textarea>
        </div>
        <div align="center">
          <input type="submit" value="작성하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
          <input type="button" value="뒤로가기" class="btn btn-warning btn-sm" onclick="history.back();">
        </div>

        
        
    </div>

</body>
</html>