<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  /* 회원 비밀번호 수정 css */
        .outer{
           margin-top:50px;
           margin-left:50px;
           width:1000px;
           font-family: 'Nanum Gothic', sans-serif; 
        }
        #myPageTable th{ 
             width:200px; 
             padding:15px;
        }
        #myPageTable td{
        width:900px;
        height:60px;
        padding:15px;
        }
        #myPageForm table{
        margin:auto;
        background-color:rgb(255, 244, 223);
        }
        #myPageForm table input{height:30px; width:250px;}
        #updateButton{width:1500px;}
        .success{
        	color:orange;
        }
        .fail{
        	color:red;
        }
</style>
</head>
<body>
	<!--  headerNavbar -->
	<%@ include file= "../../common/commonNavbar.jsp"%>
	
	<%
		String userId = loginMember.getMemUserId();
	%>
	
	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "../mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">
    <div class="outer">
        <br>
        <h2>회원 비밀번호 변경</h2>
         <hr color="gray">
         
         <form action="<%= contextPath %>/pwdUpdate.me.ng" method="post" id="myPageForm">
         <input type="hidden" name="userId" value="<%= userId %>">
            <table id="myPageTable">
                <tr>
                    <th>현재 비밀번호</th>
                    <td>
                    	<input type="password" name="myPwd" id="myPwd" onfocusout="checkMyPwd();" minlength="5" maxlength="16" required>
	                    <b style="color:red;" id="checkMyPwd">&nbsp;&nbsp;현재 비밀번호를 입력해주세요</b>
                    </td>
                </tr>
                <tr>
                    <th>변경할 비밀번호</th>
                    <td>
                    	<input type="password" name="updatePwd" id="updatePwd" onfocusout="checkPwd();" minlength="8" maxlength="16" required>
                    	<b style="color:red;" id="checkPwd">&nbsp;&nbsp;변경할 비밀번호를 입력해주세요</b>
					</td>
                   
                </tr>
                <tr>
                    <th>변경할 비밀번호 확인</th>
                    <td>
                    	<input type="password" id="updatePwdCheck" onfocusout="checkPwdCheck();" minlength="8" maxlength="16" required>
                    	<b style="color:red;" id="checkPwdCheck">&nbsp;&nbsp;변경할 비밀번호를 다시 입력해주세요</b>
                    </td>
                </tr>
            </table>
            
            <br>
            
            <div id="updateButton" align="center">
            	<button type="submit" id="submit" class="btn btn-primary" disabled>변경하기</button>
        	</div>
            
          
        </form>
        
    </div>
    </div>
    </div>
    
    <!-- footerbar -->
	<%@ include file="../../common/footerbar.jsp" %>
	

	<script>
	    // 비밀번호변경버튼 활성화하기 위한 변수 (모두 true가 되면 버튼 활성화)
	    var cMyPwd = false;
	    var cUpdatePwd = false;
	    var cUpdatePwdCheck = false;
	
	    // 비밀번호변경버튼 활성화 or 비활성화 (모든 이벤트 발생시 해당 function 실행)
	    function buttonAble(){
	        if(cMyPwd == true && cUpdatePwd === true && cUpdatePwdCheck === true){
	            document.getElementById("submit").removeAttribute("disabled");
	        }else{
	            document.getElementById("submit").disabled ="true";
	        }
	    }
	
	    // 현재 나의 비밀번호
	    function checkMyPwd(){
	    	var myPwd = document.getElementById("myPwd");
	    	var checkMyPwd = document.getElementById("checkMyPwd");
	        var regExp = /^[a-z\d!@#$%^&*]{5,16}$/i
	    	
	    	if(!regExp.test(myPwd.value)){
	    		checkMyPwd.innerHTML =  "<b class='fail'>&nbsp;&nbsp;현재 비밀번호를 입력해주세요</b>";
	    		cMyPwd = false;
	            buttonAble();
	    	}else{
	    		checkMyPwd.innerHTML = "<b class='success'>&nbsp;&nbsp;비밀번호 입력 완료!</b>";
	    		cMyPwd = true;
	            buttonAble();
	    	}
	    }
	    
	    
	    // 변경할 비밀번호 유효성검사
	    function checkPwd(){
	        var updatePwd = document.getElementById("updatePwd");
	        var checkPwd = document.getElementById("checkPwd");
	        var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i
	
	        if(!regExp.test(updatePwd.value)){
	            checkPwd.innerHTML = "<b class='fail'>&nbsp;&nbsp;8~16자 영문, 숫자, 특수문자만 사용 가능합니다.</b>";
	            cUpdatePwd = false;
	            buttonAble();
	        }else{
	            checkPwd.innerHTML = "<b class='success'>&nbsp;&nbsp;변경할 비밀번호 입력 완료!</b>";
	            cUpdatePwd = true;
	            buttonAble();
	        }
	    }
	
	    // 변경할 비밀번호 확인 유효성검사
	    function checkPwdCheck(){
	        var updatePwd = document.getElementById("updatePwd");
	        var updatePwdCheck = document.getElementById("updatePwdCheck");
	        var checkPwdCheck = document.getElementById("checkPwdCheck");
	        var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i
	
	        if(!regExp.test(updatePwdCheck.value)){
	            checkPwdCheck.innerHTML = "<b class='fail'>&nbsp;&nbsp;8~16자 영문, 숫자, 특수문자만 사용 가능합니다.<b>";
	        }else{
	            if(updatePwd.value != updatePwdCheck.value){
	                checkPwdCheck.innerHTML = "<b class='fail'>&nbsp;&nbsp;변경할 비밀번호와 일치하지 않습니다!</b>";
	                cUpdatePwdCheck = false;
	                buttonAble();
	            }else{
	                checkPwdCheck.innerHTML = "<b class='success'>&nbsp;&nbsp;변경할 비밀번호와 일치합니다!</b>";
	                cUpdatePwdCheck = true;
	                buttonAble();
	            }
	        }
	    }
	</script>
	

</body>
</html>