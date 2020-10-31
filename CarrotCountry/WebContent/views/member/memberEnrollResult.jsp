<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String result = (String)request.getAttribute("result"); // 성공문구 / 실패문구
	
	String userId = (String)request.getAttribute("memUserId"); // 성공시 아이디
	String userName = (String)request.getAttribute("memName"); // 성공시 이름
	String userNickname = (String)request.getAttribute("memNickname"); // 성공시 닉네임
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.img{
	    margin:auto;
	    margin-top:50px;
	    width:400px;
	    height:80px;
	}
	.img>div{
	    height:100%;
	    width:20%;
	    float:left;
	}
	.imgB{
	    margin:20px 0px 0px 20px;
	    width:50%;
	    height:50%;
	}
	.imgA{
	    width:100%;
	    height:100%;
	}
	.wrap{
	    border:5px solid darkgray;
	    width:400px;
	    height:500px;
	    margin:auto;
	    margin-bottom:100px;
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
	    font-size:20px;
	    color:gray;
	}
	.button1, .button2{
	    margin-top:90px;
	    height:35px;
	    width:80%;
	}
	.button2{
	    color:white;
	}
</style>
</head>
<body>
<%@ include file = "../common/commonNavbar.jsp" %>

<div class="img">
        <div><img src="<%= contextPath %>/resources/images/member/check.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/write.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/userPage.png" class="imgA"></div>
    </div>

    <div class="wrap">

        <h1><%= result %></h1>
        <br>
        <br>
        <table border="1px" width="100%">
        
			<% if(userId != null && userName != null && userNickname != null){ %>
			<tr align="center">
			    <td><label>아이디</label></td>
			    <td><label><%= userId %></label></td>
			</tr>
			<tr align="center">
			    <td><label>이&nbsp;&nbsp;&nbsp;&nbsp;름</label></td>
			    <td><label><%= userName %></label></td>
			</tr>
			<tr align="center">
			    <td><label>닉네임</label></td>
			    <td><label><%= userNickname %></label></td>
			</tr>
			<br><br><br>
			<% }else { %>
			<br><br><br>
			<label>회원가입을 실패하였습니다.</label> 
			<br><br>
			<label>잠시후 다시 회원가입을 시도해 주세요!</label>
			<% } %>
			<tr align="center" >
			    <td><a href="<%= contextPath %>" class="button1 btn btn-outline-secondary">홈으로</a></td>
			    <td><a href="<%= contextPath %>/loginPage.me.ng" class="button2 btn btn-warning">로그인하기</a></td>
			</tr>

        </table>
        <br>
        <br>
    </div>


<%@ include file = "../common/footerbar.jsp" %>
</body>
</html>