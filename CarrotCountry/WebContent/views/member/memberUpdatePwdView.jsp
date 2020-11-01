<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("result");
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
            border:5px solid darkgray;
        }
        .imgPwd{
            background:orange;
            border:5px solid darkgray;
        }
        .imgId:hover{
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
            color:white;
        }
</style>
</head>
<body>
	<%@ include file = "../common/commonNavbar.jsp" %>

	<div class="img">
	   <div class="imgId" onclick="location.href='<%=contextPath%>/findIdPage.me.ng'">
	            <img src="<%= contextPath %>/resources/images/member/id.png" width="50%" height="100%">
	    </div>
	    <div class="imgPwd">
	            <img src="<%= contextPath %>/resources/images/member/password.png" width="50%" height="100%">
	    </div>
	</div>
	<div class="wrap">
	    <h1><%= result %></h1>
	    <br>
	    <br>
	    <div align="center">
	    	<% if(result != null){ %>
	        <label>비밀번호 변경이 완료되었습니다.</label> 
			<% }else{ %>
	        <label style="margin:10px;">비밀번호 변경을 실패하였습니다.</label> 
	        <label style="margin:0px;">잠시 후 다시 시도해주세요.</label> 
			<%} %>
	    </div>
	
	    <br>
	    <a href="<%= contextPath %>/loginPage.me.ng" class="btn btn-warning">로그인페이지로 가기</a>
	</div>

	<%@ include file = "../common/footerbar.jsp" %>
</body>
</html>