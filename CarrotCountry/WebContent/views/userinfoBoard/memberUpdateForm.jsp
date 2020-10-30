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
         #myPageTable td{
        width:200px;
        height:50px;
            }
        #myPageForm table{
        margin:auto;
         }
        #updateButton{width:1500px;}
</style>
</head>
<body>


    <div class="outer">
        <br>
        <h2>회원 정보 수정</h2>
         <hr color="gray">
         <form action="" method="post" id="myPageForm">
            <table id="myPageTable">
                <tr>
                    <td>* 아이디</td>
                    <td><input type="text" name="userId" maxlength="12" required value="로그인한사용자의아이디" readonly></td>
                </tr>
                <tr>
                    <td>* 성함</td>
                    <td><input type="text" name="userName" maxlength="5" required value="로그인한사용자의이름"></td>
                </tr>
                <tr>
                    <td>성별</td>
                    <td>
                    <input type="radio" name="gender" id="man" value="남자" ><label for="man">&nbsp;&nbsp;남</label>&nbsp;&nbsp;
                    <input type="radio" name="gender" id="woman" value="여자"><label for="woman">&nbsp;&nbsp;여</label>&nbsp;&nbsp;
                    </td>
                
                </tr>
                <tr>
                    <td>생년월일</td>
                    <td><input type="text" name="birthdate" maxlength="6" value="로그인한사용자의생년월일"></td>
                </tr>
                <tr>
                    <td>닉네임</td>
                    <td><input type="text" name="nickname" required value="로그인한사용자의닉네임"></td>
                </tr>
                <tr>
                    <td>연락처</td>
                    <td><input type="text" name="phone" placeholder="(-포함)" value="로그인한사용자의전번"></td> 
                </tr>
                <tr>
                    <td>주소</td>
                    <td>
                        <select style="width:180px;" id="Address_1">
                            <option value=''>선택하세요</option>
                            <option value='서울특별시'>서울특별시</option>
                            <option value='광주광역시'>경기도</option>
                            <option value='인천광역시'>인천광역시</option>
                            </select>
                        </td><br><br>
                        <td>
                            <select style="width:180px;" id="Address_2">
                                <option value=''>선택하세요</option>
                                <option value='강북구'>강북구</option>
                                <option value='성북구'>성북구</option>
                                <option value='성북구'>강남구</option>
                                </select>
                        </td>
                    <td><input style="width:300px;" type="text"></td>
                </tr>
                <tr>
                    <td>E-Mail</td>
                    <td><input type="email" name="email" value="로그인한사용자의이메일"></td>
                </tr>
            </table>
          
        </form>
        <br>
    
        <div id="updateButton" align="center">
        
            <button type="submit" class="btn btn-primary ">확인</button>
           
    
        </div>
    </div>
    <br><br><br>
	


</body>
</html>