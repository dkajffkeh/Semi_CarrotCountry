<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  /* 회원 정보 수정 css */
        .outer{
           margin-top:50px;
           margin-left:50px;
           width:1000px;
           font-family: 'Nanum Gothic', sans-serif; 
        }
        #myPageTable th{ 
             width:400px; 
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
        #myPageForm table input{height:30px;}
        #updateButton{width:1500px;}
</style>
</head>
<body>
	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>
	
	<%
	String userId = loginMember.getMemUserId();
	String memName = loginMember.getMemName();

	
	String gender = (loginMember.getMemGender() == null) ? "" : loginMember.getMemGender();
	String birthday = (loginMember.getMemBirthday() == null) ? "" : loginMember.getMemBirthday();
	String nickName = (loginMember.getMemNickname() == null) ? "" : loginMember.getMemNickname();
	String phone = (loginMember.getMemPhone() == null) ? "" : loginMember.getMemPhone();
	int localNo = loginMember.getLocalNo();
	String email = (loginMember.getMemEmail() == null) ? "" : loginMember.getMemEmail();

	
	%>
	
	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">
    <div class="outer">
        <br>
        <h2>회원 정보 수정</h2>
         <hr color="gray">
         <form action="<%= contextPath %>/update.me.jw" method="post" id="myPageForm">
            <input type="hidden" value="<%= userId %>" name="userId">
            <table id="myPageTable">
                <tr>
                    <th>* 아이디</th>
                    <td><input type="text" name="userid" id="userId" maxlength="12" required value="<%= userId %>"readonly></td>
                </tr>
                <tr>
                    <th>* 성함</th>
                    <td>
                    <input type="text" name="memName" id="memName" maxlength="6" required value="<%= memName %>">
                    <b style="color:red;">&nbsp;&nbsp;2-6자 한글</b>
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                    <input type="radio" name="gender" id="man" value="남" style="width:20px;height:20px">
                    <label for="man">&nbsp;&nbsp;남</label>&nbsp;&nbsp;
                    <input type="radio" name="gender" id="woman" value="여" style="width:20px;height:20px">
                    <label for="woman">&nbsp;&nbsp;여</label>&nbsp;&nbsp;
                    </td>
                
                </tr>
                <tr>
                    <th>생년월일</th>
 					<td colspan="2">
                        <input type="text" name="birthday" id="birthday" maxlength="6" value="<%= birthday %>">
                        <b style="color:red;">&nbsp;&nbsp;숫자 6자리</b>
                    </td>               
               </tr>
                <tr>
                    <th>닉네임</th>
                    <td>
                   		 <input type="text" name="nickName" id="nickName" maxlength="8" value="<%= nickName %>">
                   		 <b style="color:red;">&nbsp;&nbsp;2-8자 한글, 영문, 숫자</b>
                    </td>
                    
                	
                </tr>
                <tr>
                    <th>연락처</th>
                    <td colspan="3">
                        <input type="text" name="phone" id="phone" maxlength="13" value="<%= phone %>">
                        <b style="color:red;">&nbsp;&nbsp;  - 와 숫자를 포함한 13자 </b>
                    </td> 
                </tr>
                <tr>
                    <th>지역</th>
                    <td>
                    <select id="local"name = "local" value="<%= localNo%>">
		                <option value="1">서울특별시 송파구 오금동</option>
		                <option value="2">서울특별시 송파구 오류동</option>
		                <option value="3">서울특별시 송파구 상일동</option>
		                <option value="4">서울특별시 강서구 화곡동</option>
		                <option value="5">서울특별시 강서구 목동</option>
		            </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <th>E-Mail</th>
                    <td><input type="email" name="email" id="email" value="<%= email %>" style="width:300px;"></td>
                </tr>
            </table>
            
            <script>
            
            	$(function(){
            		// 성별값 가져오기
            		var gender = "<%= gender %>";
            		
            		$("input[type=radio]").each(function(){
            			
            			if(gender.search($(this).val()) != -1) {
            				$(this).attr("checked", true);
            			}
            		});
            	});
            </script>
            	
            	<script>
            	// 지역값 가져오기
    			
			     var local = "<%= localNo %>";
					$("#local").val("<%= localNo %>").prop("selected", true);
		
            	</script>
            	
            	
            	<script>
          
            		// 유효성 검사
            	function validate() {
            			
            		var userId = document.getElementById("userid");
                    var memName = document.getElementById("memName");
		            var birthday = document.getElementById("birthday");
                    var nickName = document.getElementById("nickName");
                    var phone = document.getElementById("phone");
                    var address = document.getElementById("address");

                    
        
                    // 이름 검사
                    var regExp = /^[가-힇]{2,6}$/;
                    
                    if(!regExp.test(memName.value)){
                        alert("유효한 이름을 입력하세요!");

                        userName.value="";
                        userName.focus();
                        return false;
                    }
                    
                    // 생일 검사
                    var regExp = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
                    
                    if(!regExp.test(birthday.value)){
                        alert("유효한 생일을 입력하세요!");

                        userName.value="";
                        userName.focus();
                        return false;
              		 }
                    
                    
                    
                    // 닉네임 검사
                    var regExp = /^[a-z가-힇\d]{2,8}$/i;
                   
                    if(!regExp.test(nickName.value)){
                        alert("유효한 닉네임을 입력하세요!");

                        nickname.value="";
                        nickname.focus();
                        return false;
                    }

                    // 전화번호 검사
                    var regExp = /^\d{3}-\d{4}-\d{4}$/;
					
                    if(!regExp.test(phone.value)){
                        alert("유효한 전화번호를 입력하세요!");

                        phone.value="";
                        phone.focus();
                        return false;
                    }
            	}
            		
          
            
    	
          
            </script>
            
            <br>
            
            <div id="updateButton" align="center">
            	<button type="submit" class="btn btn-primary ">변경하기</button>
        	</div>
            
          
        </form>
        
    </div>
    </div>
    </div>
    
    <!-- footerbar -->
	<%@ include file="../common/footerbar.jsp" %>
	
	


</body>
</html>