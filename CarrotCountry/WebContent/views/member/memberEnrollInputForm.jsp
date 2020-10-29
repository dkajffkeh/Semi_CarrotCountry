<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #footerbar {
            position:static !important;
        }
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
        height:1150px;
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

    .button1, .button2{
        margin-top:50px;
        height:35px;
    }
    .button1{
        width:90px;
    }
    .button2{
        width:150px;
        color:white;
    }

    #signupForm{
        margin-top:20px;
    }
    #signupForm>label{
        font-weight:900;
        /* margin-top:20px; */
    }
    #signupForm input[type="text"], input[type="password"], input[type="email"]{
        border:1px solid gray;
        width:250px;
        margin-bottom:30px;
    }
    #signupForm select{
        border:1px solid gray;
        width:30%;
    }
    .button3{
        color:white;
    }
</style>
</head>
<body>
	
	<%@ include file="../common/commonNavbar.jsp" %>

	<div class="img">
        <div><img src="<%= contextPath %>/resources/images/member/check.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/writePage.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/user.png" class="imgA"></div>
    </div>
    <div class="wrap">

        <h1>회원정보 입력</h1>
        <br>
        <br>
        <form action="" method="post" id="signupForm">

            <label for="userId">*아이디(4~12자 영문 대 소문자, 숫자)</label>
            <br>
            <input type="text" name="userId" id="userId" required minlength="4" maxlength="12">&nbsp;&nbsp;<button type="button" class="btn btn-warning btn-sm button3">중복 확인</button>
            <br>
            <label for="userPwd">*비밀번호(8~16자 영문, 숫자, 특수문자)</label>
            <br>
            <input type="password" name="userPwd" id="userPwd" required minlength="8" maxlength="16">
            <br>
            <label for="userPwdCheck">*비밀번호 확인</label>
            <br>
            <input type="password" id="userPwdCheck" required minlength="8" maxlength="16">
            <br>
            <label for="userName">*이름</label>
            <br>
            <input type="text" name="userName" id="userName" required minlength="2" maxlength="5">
            <br>
            <label for="nickName">*닉네임</label>
            <br>
            <input type="text" name="nickName" id="nickName" required minlength="2" maxlength="8">
            <br>
            <label for="birthday">*생년월일(숫자 6자리)</label>
            <br>
            <input type="text" name="birthday" id="birthday" required minlength="6" maxlength="6">
            <br>
            <label>*성별</label>
            <br>
            <input type="radio" name="gender" id="M" required><label for="M">남성</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" id="F" required><label for="F">여성</label>
            <br><br>
            <label for="phone">*전화번호(-포함 입력)</label>
            <br>
            <input type="text" name="phone" id="phone" required minlength="13" maxlength="13">
            <br>
            <label for="email">&nbsp;&nbsp;이메일</label>
            <br>
            <input type="email" name="email" id="email" maxlength="25">
            <br>
            <label>&nbsp;&nbsp;지역</label>
            <br>
            <select name="si">
                <option value="서울특별시">서울시</option>
            </select>
            <select name="gu">
                <option value="용산구">용산구</option>
                <option value="광진구">광진구</option>
                <option value="송파구">송파구</option>
                <option value="강남구">강남구</option>
                <option value="서초구">서초구</option>
            </select>
            <select name="dong">
                <option value="xx동">xx동</option>
            </select>
            <br>
            <br>
            <a href="" class="btn btn-outline-secondary button1">뒤로가기</a>
            <button type="reset" class="btn btn-outline-secondary button1">다시입력</button>
            &nbsp;
            <button type="submit" class="btn btn-warning button2">회원가입</button>

        </form> 

        <br>
        <br>
    </div>

	<%@ include file = "../common/footerbar.jsp" %>
	
</body>
</html>