<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.javachip.carrotcountry.jmboard.oneTo.model.vo.*"%>
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
        height:550px;
        margin:auto;
        margin-top:50px;
    }
</style>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="outer">
        <!-- 개인정보 수집 및 이용동의칸 남겨둠 -->
        <h4>1:1문의</h4>
        <hr>
        <form id="update" action="<%= contextPath %>/modify.on.jm" method="post">
        <input type="hidden" name="ono" value="<%= o.getOneToNo() %>">
            <ul>
                <li>
                    <label for="">유형분류*</label>&nbsp;
                    <div class="form-check-inline">
                      <input type="radio" id="11" class="form-check-input" name="oneToType" value="11">
                        <label class="form-check-label" for="11">운영정책 </label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="22">
                        <label class="form-check-label">계정/인증</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="33">
                        <label class="form-check-label">중고구매/판매</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="44">
                        <label class="form-check-label">거래품목</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="55">
                        <label class="form-check-label">신고관련</label>
                      </div>
                      <br>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="66">
                        <label class="form-check-label">공동구매/판매</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="77">
                        <label class="form-check-label">이용제재</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="88">
                        <label class="form-check-label">블랙리스트관련</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="99">
                        <label class="form-check-label">공구문의</label>
                      </div>
                      <div class="form-check-inline">
                      <input type="radio" class="form-check-input" name="oneToType" value="100">
                        <label class="form-check-label">기타문의</label>
                      </div>
                      <script>
                        	$(function(){
                        		$("#update input[type=radio]").each(function(){
                        			if($(this).next().text() == "<%=o.getOneToType()%>"){
                        				$(this).attr("checked", true);
                        			}
                        		});
                        	});
                        </script>
                      
                </li>

                <li>
                    <label for="">제목*</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" class="border border-warning" name="oneToTitle" value="<%=o.getOneToName() %>" required>
                </li>

                <li>
                    <label for="">글작성*</label><br>
                    <textarea cols="100" rows="20" class="border border-warning" placeholder="내용을 입력하세요" name="oneToContent" style="resize: none;" required><%=o.getOneToContent() %></textarea>
                </li>

            </ul>
            <div align="center">
                <input type="submit" class="btn btn-warning btn-sm">
                <input type="reset" class="btn btn-warning btn-sm">
            </div>

        </form>
    </div>
</body>
</html>