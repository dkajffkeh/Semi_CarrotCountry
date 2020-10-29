<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginFail = (String)request.getAttribute("loginFail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="../common/commonNavbar.jsp" %>
	<style>
        .wrap{
            border:5px solid darkgray;
            width:400px;
            height:550px;
            margin:auto;
            margin-top:100px;
            margin-bottom:100px;
            padding:20px;
        }


        .wrap>h1{
            color:gray;
            text-align:center;
            font-size:30px;
            font-weight:900;
        }
        #userId, #userPwd{
            width:100%;
            height:40px;
            border-bottom:1px solid gray;
        }

        #userCheck{
            margin-top:30px;
            width:15px;
            height:15px;
        }

        label[for="userCheck"]{
            font-weight:900;
        }
        
        #loginSubmit{
            margin:50px 0px 50px 0px;
            width:100%;
            height:40px;
            font-size:20px;
            color:white;
        }
        .button1, .button2, .button3{
            margin-top:5px;
            height:35px;
        }
        .button1, .button2{
            width:80%;
        }
        .button3{width:90%;}
        #p{font-size:12px; color:red;}
    </style>

    <div class="wrap">
        <h1>당근나라</h1>
        <br>
        <br>
       	
        <table border="1px" width="100%">
            <form action="<%= contextPath %>/login.me.ng" method="post">
                <tr>
                    <td colspan="2"><input type="text" name="userId" id="userId" placeholder="아이디"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="password" name="userPwd" id="userPwd" placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <!-- 로그인 오류시 출력문구 입력 -->
                    	<% if(loginFail != null){ %>
                    		<label id="p"><%= loginFail %><label>
                    	<% } %>
                    </td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="userCheck" id="userCheck"> <label for="userCheck">로그인 상태 유지</label></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" id="loginSubmit"  class="btn  btn-warning" value="로그인"></td>
                </tr>
            </form>    

            <tr align="center" >
                <td><a href="" class="button1 btn btn-outline-secondary">아이디 찾기</a></td>
                <td><a href="" class="button2 btn btn-outline-secondary">비밀번호 찾기</a></td>
            </tr>
            <tr align="center" >
                <td colspan="2"><a href="" class="button3 btn btn-outline-secondary">회원가입</a></td>
            </tr>
        </table>

        <br>
        <br>

    </div>
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>