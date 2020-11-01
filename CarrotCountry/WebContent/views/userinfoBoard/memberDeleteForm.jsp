<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  /* 회원탈퇴 css */
        .outer{
           margin-top:50px;
           margin-left:50px;
           width:1000px;
           font-family: 'Do Hyeon', sans-serif;
        }
    
        #outer_1{
        border:3px solid black;
        padding:10px;
        width: 800px;
        height:200px;
        margin-left:100px;
        }
        .outer>span{
            font-size:20px;
        }
        
        #button{
            float:right;
            margin-right:100px;
        }
</style>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>

	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">



	<div class="outer">
        <br>
        <h1>회원 탈퇴</h1>
         <hr color="gray">
         <br><br>
         <div id="outer_1" align="center">
             <br><br>
             <h2>그 동안 서비스를 이용해 주셔서 감사합니다.</h2>
             <br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;아래 내용을 잘 확인 하시고 탈퇴해주세요.
        </div>
        <br><br><br>
         <p>
            <h4>
             
                &nbsp;회원을 탈퇴 하시면 모든 정보의 복구가 불가능하며 해당 사이트를 더 이상 이용하실 수 없으며 또한 기존의 모든 개인정보내역이 사라지므로 신중히 결정하시기 바랍니다.<br><br>
            </h4>
                <h4 style="color:red"><b>재가입 하셔도 정보가 복구되지 않으니 참고바랍니다.</b></h4>
         </p>
        <br><br><br>


        
        <div id="button">
            <button type="button" class="btn btn-danger btn-lg" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
        </div>
    </div>
        <!------------------회원 탈퇴 버튼 클릭시 보여줄 Modal ----------------------------------------->


        
            <div class="modal" id="deleteForm">
              <div class="modal-dialog">
                <div class="modal-content">
                
                  <!-- Modal Header -->
                  <div class="modal-header">
                    <h4 class="modal-title">회원탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                  </div>
                  
                  <!-- Modal body -->
                  <div class="modal-body" align="center">
                
                    <b>
                        비밀번호를 입력해주세요. <br>
                    
                    </b><br>
    
                    <form action="" method="post">
                        
                        <input type="password" name="userPwd" required>
                        <br><br>
                        <button type="submit" class="btn btn-danger btn-sm">탈퇴하기</button>
                    </form>
    
                 </div>



                  
                </div>
              </div>
            </div>
 <!----------------------------------------------------------->
   </div>
	</div>

	<!-- footerbar -->
	<%@ include file="../common/footerbar.jsp" %>
            
            
            
</body>
</html>