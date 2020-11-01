<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("result");
	
	String findId = (String)request.getAttribute("findId");
	String memName = (String)request.getAttribute("memName");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.img{
	     margin:auto;
	     margin-top:100px;
	     width:400px;
	     height:80px;
	 }
	 .img>div{
	     /* border:5px solid black; */
	     height:100%;
	     width:50%;
	     float:left;
	     text-align:center;
	 }
	 .imgId{
	     background:orange;
	     border:5px solid darkgray;
	 }
	 .imgPwd{
	     border:5px solid darkgray;
	 }
	
	 .imgPwd:hover{
	     background:orange;
	     border:5px solid darkgray;
	     cursor:pointer;
	 }
	 .wrap{
	     border:5px solid darkgray;
	     width:400px;
	     height:300px;
	     margin:auto;
	     margin-bottom:200px;
	     padding:20px;
	 }
	 .wrap>h1{
	     color:gray;
	     text-align:center;
	     font-size:30px;
	     font-weight:900;
	 }
	 .wrap label{
	     font-weight:900;
	     margin-bottom:50px;
	 }
	 .btn-warning{
	     margin:auto;
	     width:100%;
	 }
</style>
</head>
<body>

	<%@ include file = "../common/commonNavbar.jsp" %>

    <div class="img">
        <div class="imgId">
                <img src="<%= contextPath %>/resources/images/member/id.png" width="50%" height="100%">
        </div>
        <div class="imgPwd" onclick="location.href='<%= contextPath %>/findPwdPage.me.ng'">
                <img src="<%= contextPath %>/resources/images/member/password.png" width="50%" height="100%">
        </div>
    </div>
    
    <div class="wrap">
        <h1><%= result %></h1>
        <br>
        <br>

        <div align="center">
        	<% if(memName != null && findId != null){ %>
            	<label><%= memName %> 님의 아이디는 <u><%= findId %></u> 입니다.</label> 
            <% }else{ %>
            	<label>일치하는 아이디를 조회하지 못했습니다.<br> 잠시 후 다시 시도해주세요.</label> 
            <% } %>
        </div>

        <br>
        <a href="<%= contextPath %>/loginPage.me.ng" class="btn btn-warning" style="color:white;">로그인페이지로 가기</a>
    </div>
    
    <%@ include file="../common/footerbar.jsp" %>
    
</body>
</html>