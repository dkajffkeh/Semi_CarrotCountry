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
        height:1350px;
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
    .fail{
        color:red;
    }
    .success{
        color:orange;
    }
    .wrap p{
        font-size:12px;
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
    }
    #signupForm select{
        border:1px solid gray;
        width:80%;
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
        <form action="enrollInput.me.ng" method="post" id="signupForm">

            <label for="userId">아이디(4~12자 영문 소문자, 숫자)</label>
            <br>
            <input type="text" name="userId" id="userId" required minlength="4" maxlength="12" onfocusout="checkId();">
            <p id="checkId">필수입력</p>

            <br>
            <label for="userPwd">비밀번호(8~16자 영문, 숫자, 특수문자)</label>
            <br>
            <input type="password" name="userPwd" id="userPwd" required minlength="8" maxlength="16" onfocusout="checkPwd();">
            <p id="checkPwd">필수입력</p>

            <br>
            <label for="userPwdCheck">비밀번호 확인</label>
            <br>
            <input type="password" id="userPwdCheck" required minlength="8" maxlength="16" onfocusout="checkPwdCheck();">
            <p id="checkPwdCheck">필수입력</p>

            <br>
            <label for="userName">이름</label>
            <br>
            <input type="text" name="userName" id="userName" required minlength="2" maxlength="6" onfocusout="checkName();">
            <p id="checkName">필수입력</p>
            
            <br>
            <label for="nickName">닉네임</label>
            <br>
            <input type="text" name="nickName" id="nickName" required minlength="2" maxlength="8" onfocusout="checkNickName();">
            <p id="checkNickName">필수입력</p>

            <br>
            <label for="birthday">생년월일(숫자 6자리)</label>
            <br>
            <input type="text" name="birthday" id="birthday" required minlength="6" maxlength="6" onfocusout="checkBirthday();">
            <p id="checkBirthday">필수입력</p>

            <br>
            <label>성별</label>
            <br>
            <input type="radio" name="gender" id="M" value="남" required onclick="checkGenderM();">
            <label for="M" onclick="checkGenderM();">남</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" id="F" value="여" required onclick="checkGenderF();">
            <label for="F" onclick="checkGenderF();">여</label>
            <p id="checkGender">필수선택</p>
            
            <br>
            <label for="phone">전화번호(-포함 입력)</label>
            <br>
            <input type="text" name="phone" id="phone" required minlength="13" maxlength="13" onfocusout="checkPhone();">
            <p id="checkPhone">필수입력</p>

            <br>
            <label for="email">이메일</label>
            <br>
            <input type="email" name="email" id="email" maxlength="25">
            <br>
            <br>
            <label>지역</label>
            <br>
            <select name="local">
                <option value="1">서울특별시 송파구 오금동</option>
                <option value="2">서울특별시 송파구 오류동</option>
                <option value="3">서울특별시 송파구 상일동</option>
                <option value="4">서울특별시 강서구 화곡동</option>
                <option value="5">서울특별시 강서구 목동</option>
            </select>
            <br>

            <a onclick="history.back();" class="btn btn-outline-secondary button1">뒤로가기</a>
            <button type="reset" class="btn btn-outline-secondary button1" onclick="location.reload();">다시입력</button>
            &nbsp;
            <button type="submit" id="submit" class="btn btn-warning button2" disabled="true">회원가입</button>

        </form> 

        <br>
        <br>
    </div>

	<%@ include file = "../common/footerbar.jsp" %>
	
	<script>
        // 회원가입버튼 활성화하기 위한 변수 (모두 true가 되면 버튼 활성화)
        var cId = false;
        var cPwd = false;
        var cPwdCheck = false;
        var cName = false;
        var cNickName = false;
        var cBirthday = false;
        var cPhone = false;
        var cGender = false;

        // 회원가입버튼 활성화 or 비활성화 (모든 이벤트 발생시 해당 function 실행)
        function buttonAble(){
            if(cId === true && cPwd === true && cPwdCheck === true && cName === true && cNickName === true 
                && cBirthday === true && cGender === true && cPhone === true ){
                document.getElementById("submit").removeAttribute("disabled");
            }else{
                document.getElementById("submit").disabled ="true";
            }
        }

        // 아이디 유효성검사 / 중복확인
        function checkId(){
            var userId = document.getElementById("userId");
            var checkId = document.getElementById("checkId");
            var regExp = /^[a-z\d]{4,12}$/;

            if(!regExp.test(userId.value)){
                checkId.innerHTML = "<p class='fail'>4~12자 영문 소문자, 숫자만 사용가능합니다.<p>";
                cId = false;
                buttonAble();
            }else{
                $.ajax({
                	url:"idCheck.me.ng",
                	type:"get",
                	data:{userId:userId.value},
                	success:function(result){
                		if(result == "fail"){
                			checkId.innerHTML = "<p class='fail'>" + userId.value +" 사용중인 아이디입니다. <p>";
                			cId = false;
                			buttonAble();
                		}else{
                            checkId.innerHTML = "<p class='success'>" + userId.value + " 사용가능한 아이디입니다!<p>";
                            cId = true;
                            buttonAble();
                		}
                	}
                });
            }
        }

        // 비밀번호 유효성검사
        function checkPwd(){
            var userPwd = document.getElementById("userPwd");
            var checkPwd = document.getElementById("checkPwd");
            var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i

            if(!regExp.test(userPwd.value)){
                checkPwd.innerHTML = "<p class='fail'>8~16자 영문, 숫자, 특수문자만 사용가능합니다.<p>";
                cPwd = false;
                buttonAble();
            }else{
                checkPwd.innerHTML = "<p class='success'>안전한 비밀번호입니다!<p>";
                cPwd = true;
                buttonAble();
            }
        }

        // 비밀번호 확인 유효성검사
        function checkPwdCheck(){
            var userPwd = document.getElementById("userPwd");
            var userPwdCheck = document.getElementById("userPwdCheck");
            var checkPwdCheck = document.getElementById("checkPwdCheck");
            var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i

            if(!regExp.test(userPwdCheck.value)){
                checkPwdCheck.innerHTML = "<p class='fail'>8~16자 영문, 숫자, 특수문자만 사용가능합니다.<p>";
            }else{
                if(userPwd.value != userPwdCheck.value){
                    checkPwdCheck.innerHTML = "<p class='fail'>비밀번호가 일치하지 않습니다.<p>";
                    cPwdCheck = false;
                    buttonAble();
                }else{
                    checkPwdCheck.innerHTML = "<p class='success'>비밀번호가 일치합니다!<p>";
                    cPwdCheck = true;
                    buttonAble();
                }
            }
        }

        // 이름 유효성검사
        function checkName(){
            var userName = document.getElementById("userName");
            var checkName = document.getElementById("checkName");
            var regExp = /^[가-힇]{2,6}$/

            if(!regExp.test(userName.value)){
                checkName.innerHTML = "<p class='fail'>2~6자 한글만 가능합니다.<p>";
                cName = false;
                buttonAble();
            }else{
                checkName.innerHTML = "<p class='success'>" + userName.value + "님 반갑습니다!<p>";
                cName = true;
                buttonAble();
            }
        }

        // 닉네임 유효성검사 / 중복확인
        function checkNickName(){
            var nickName = document.getElementById("nickName")
            var checkNickName = document.getElementById("checkNickName");
            var regExp = /^[a-z가-힇\d]{2,8}$/i

            if(!regExp.test(nickName.value)){
                checkNickName.innerHTML = "<p class='fail'>2~8자 한글, 영문, 숫자만 사용가능합니다.<p>";
                cNickName = false;
                buttonAble();
            }else{
            	$.ajax({
            		url:"nickNameCheck.me.ng",
            		type:"get",
            		data:{nickName:nickName.value},
            		success:function(result){
            			if(result == "fail"){
                            checkNickName.innerHTML = "<p class='fail'>" + nickName.value + " 사용중인 닉네임입니다.<p>";
                            cNickName = false;
                            buttonAble();
            			}else{
            				checkNickName.innerHTML = "<p class='success'>" + nickName.value + " 사용가능한 닉네임입니다!<p>";
            				cNickName = true;
            				buttonAble();
            			}
            		}
            	})
            }
        }

        // 생일 유효성검사
        function checkBirthday(){
            var birthday = document.getElementById("birthday");
            var checkBirthday = document.getElementById("checkBirthday");
            var regExp = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;

            if(!regExp.test(birthday.value)){
                checkBirthday.innerHTML = "<p class='fail'>6자 숫자만 사용가능합니다.<p>";
                cBirthday = false;
                buttonAble();
            }else{
                checkBirthday.innerHTML = "<p class='success''>입력 완료되었습니다!<p>";
                cBirthday = true;
                buttonAble();
            }
        }

        // 성별
        function checkGenderM(){
            var checkGender = document.getElementById("checkGender");
            checkGender.innerHTML = "<p class='success''>'남' 선택 완료되었습니다!<p>";
            cGender = true;
            buttonAble();
        }
        function checkGenderF(){
            var checkGender = document.getElementById("checkGender");
            checkGender.innerHTML = "<p class='success''>'여' 선택 완료되었습니다!<p>";
            cGender = true;           
            buttonAble();
        }

        // 전화번호 유효성검사
        function checkPhone(){
            var phone = document.getElementById("phone");
            var checkPhone = document.getElementById("checkPhone");
            var regExp = /^\d{3}-\d{4}-\d{4}$/;

            if(!regExp.test(phone.value)){
                checkPhone.innerHTML = "<p class='fail'>'-', 숫자 포함한 13자만 사용가능합니다.<p>";
                cPhone = false;
                buttonAble();
            }else{
            	
            	$.ajax({
            		url:"phoneCheck.me.ng",
            		type:"get",
            		data:{phone:phone.value},
            		success:function(result){
            			if(result == "fail"){
                            checkPhone.innerHTML = "<p class='fail'>사용중인 전화번호입니다.<p>";
                            cPhone = false;
                            buttonAble();
            			}else{
			                checkPhone.innerHTML = "<p class='success''>사용가능한 전화번호입니다!<p>";
			                cPhone = true;
			                buttonAble();
            			}
            		}            		
            	})  
            }
        }

    </script>
</body>
</html>