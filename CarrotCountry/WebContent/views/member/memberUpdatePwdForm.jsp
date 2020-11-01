<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String)request.getAttribute("result");
	String memUserId = (String)request.getAttribute("memUserId");
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
	    height:450px;
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
	.wrap input[type="password"]{
	    border:1px solid gray;
	    width:250px;
	}
	#pwdUpdateForm{
	    margin-left:50px;
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
</style>
</head>
<body>
	<%@ include file = "../common/commonNavbar.jsp" %>

	    <div class="img">
        <div class="imgId" onclick="location.href='<%= contextPath%>/findIdPage.me.ng'">
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
        <% if(memUserId != null){ %>
            <form action="updatePwd.me.ng" method="post">
		        <div id="pwdUpdateForm">
	            <input type="hidden" name="userId" value="<%= memUserId %>">
	               <br>
	               <label for="userPwd">비밀번호(8~16자 영문, 숫자, 특수문자)</label>
	               <br>
	               <input type="password" name="userPwd" id="userPwd" required minlength="8" maxlength="16" onfocusout="checkPwd();">
	               <p id="checkPwd">비밀번호를 입력해주세요</p>
	               <br>
	               <label for="userPwdCheck">비밀번호 확인</label>
	               <br>
	               <input type="password" id="userPwdCheck" required minlength="8" maxlength="16" onfocusout="checkPwdCheck();">
	               <p id="checkPwdCheck">비밀번호를 다시 입력해주세요</p>
	               <br>
		   		</div>
                <button type="submit" id="submit" class="btn btn-warning" disabled style="color:white; width:100%; margin-left:0px;">비밀번호 변경</button>
            </form>
        <% }else{ %>
        	<div align="center">
        		<label align="center"">일치하는 회원이 존재하지 않습니다.</label>
        		<br>
        		<label align="center">잠시후 다시 시도해주세요.</label>
            	<a href="<%= contextPath %>/loginPage.me.ng" class="btn btn-warning" style="width:100%; margin:180px 0px 0px 0px; color:white;">로그인페이지로 가기</a>
        	</div>
					
        <% } %>
        <br>
        <br>
    </div>

	<%@ include file = "../common/footerbar.jsp" %>
	
	<script>
        // 비밀번호변경버튼 활성화하기 위한 변수 (모두 true가 되면 버튼 활성화)
        var cPwd = false;
        var cPwdCheck = false;

        // 비밀번호변경버튼 활성화 or 비활성화 (모든 이벤트 발생시 해당 function 실행)
        function buttonAble(){
            if(cPwd === true && cPwdCheck === true){
                document.getElementById("submit").removeAttribute("disabled");
            }else{
                document.getElementById("submit").disabled ="true";
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
	</script>
	
</body>
</html>