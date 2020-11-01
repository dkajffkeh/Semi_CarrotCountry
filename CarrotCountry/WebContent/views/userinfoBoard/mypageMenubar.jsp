<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="resources/css/headerNavBar.css">
  <!-- 폰트 링크 -->
 <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
<style>
 		.myPageWrapper{
            width:1200px;
            margin:auto;
            height:1200px;
           
        }
        .myPageWrapper>div{
            height:100%; float:left;
            padding-bottom: 500px;
        }
        .myPageWrapper_content{width:85%;}

        /*----------myPageNavbar include 영역 시작----------*/
        .myPageWrapper_nav{
            /* margin-left:100px; */
            width:15%;
            /* 폰트 */
            font-family: 'Do Hyeon', sans-serif;
        }
        #myPageWrapper_nav_title{
         background:orange;
         width:100%;
         height:35%; 
         color:white;
         font-size:40px;
         font-weight:900;
         padding:30px 10px;
        }
        .myPageWrapper_nav th{
            background:lightgray;
            padding:5px;
            text-align:center;
            font-size:20px;
        }
        .myPageWrapper_nav td{
            text-align:center;
            padding:5px;
            border:1px solid lightgray;
            
        }
        #myPageWrapper_nav_table{
            width:100%;
            height:90%;
            border:1px solid lightgray;
        }
        .myPageWrapper_nav a{
            text-decoration:none;
            color:black;
            font-size:20px;
            display:block;
            width:100%;
            height:100%;
        }
        .myPageWrapper_nav a:hover{background:cornsilk;}
</style>

</head>
<body>

         <div class="myPageWrapper_nav">
             <div id="myPageWrapper_nav_title" align="center">
      		  <i class='fas fa-user-circle' style='font-size:120px'></i><br>
		       	 마이페이지
		     </div>
            
            <table id="myPageWrapper_nav_table">
            <tr>
                <th>회원 정보</th>
            </tr>
            <tr>
                <td><a href="">회원 정보 설정</a></td>
            </tr>
                <td><a href="">회원 탈퇴</a></td>
            <tr>
                <th>관심 상품</th>
            </tr>
            <tr>
                <td><a href="">찜</a></td>
            </tr>
            <tr>
                <td><a href="">최근 본 상품</a></td>
            </tr>
            <tr>
                <th>판매 이력 조회</th>
            </tr>
            <tr>
                <td><a href="">판매 현황</a></td>
            </tr>
            <tr>
                <th>공동구매</th>
            </tr>
            <tr>
                <td><a href="">내 게시글</a></td>
            </tr>
            <tr>
                <td><a href="">진행 현황</a></td>
            </tr>
            <tr>
                <th><a href="">신고내역</a></th>
            </tr>
            <tr>
                <th id="admin"><a href="" >관리자 페이지</a></th>
            </tr>
            </table>
        </div>

</body>
</html>