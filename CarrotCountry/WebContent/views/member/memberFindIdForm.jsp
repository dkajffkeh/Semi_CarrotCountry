<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	}
	.wrap input[type="text"], input[type="password"], input[type="email"]{
	    border:1px solid gray;
	    width:250px;
	    margin-bottom:30px;
	}
	#idFindForm{
	    margin-left:50px;
	}
	.btn-warning{
	    margin-left:80px;
	    color:white;
	}
</style>
</head>
<body>
	<%@ include file = "../common/commonNavbar.jsp" %>
	
	<div class="img">

        <div class="imgId">
                <img src="<%= contextPath %>/resources/images/member/id.png" width="50%" height="100%">
        </div>
        <div class="imgPwd" onclick="location.href=''">
                <img src="<%= contextPath %>/resources/images/member/password.png" width="50%" height="100%">
        </div>
    </div>
    
    <div class="wrap">

        <h1>아이디 찾기</h1>
        <br>
        <br>
            <form action="findId.me.ng" method="post" id="idFindForm">
                <br>
                <label for="userName">이름</label>
                <br>
                <input type="text" name="userName" id="userName" required minlength="2" maxlength="6">
                <br>
                <label for="birthday">생년월일(숫자 6자리)</label>
                <br>
                <input type="text" name="birthday" id="birthday" required minlength="6" maxlength="6">
                <br>
                <label for="phone">전화번호(-포함 입력)</label>
                <br>
                <input type="text" name="phone" id="phone" required minlength="13" maxlength="13">
                <br>
                <a href="" class="btn btn-secondary">취소</a>
                <button type="submit" class="btn btn-warning">아이디찾기</button>
            </form>
        <br>
        <br>
    </div>
	
	<%@ include file = "../common/footerbar.jsp" %>
</body>
</html>