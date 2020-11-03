<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


<link rel="stylesheet" href="resources/css/userinfoBoard/myPage.css">

/* 
    .myPageWrapper{
            width:1200px;
            margin:auto;
            height:700px;
            
        }
    .myPageWrapper>div{
        height:100%; float:left;
    }
    .myPageWrapper_content{width:85%; padding:40px;}
    
	.myPageWrapper_content_1>h1{
       color:gray;
     }






		 
		 .myReportContent{
			 width:100%;
			 height:80%;
		 }
		 .myReportBottom{
			 text-align:center;
			 width:100%;
			 height:10%;
			 padding:12px;
		 } */
</style>
</head>
<body>
	<%@ include file="../../common/commonNavbar.jsp" %>
	


<div class="myPageWrapper">
        
	<%@ include file="../mypageMenubar.jsp" %>
        
	<div class="myPageWrapper_content">
	<div class="myPageWrapper_content_1">

        <h2>회원 비밀번호 변경</h2>
         <hr color="gray">

    </div>

	    <div class="myReportContent">
	        <table class="table table-striped table-hover">
	            <thead>
	                <tr>
	                    <th>신고번호</th>
	                    <th>거래유형</th>
	                    <th>물품명</th>
	                    <th>신고유형</th>
	                    <th>신고사유</th>
	                    <th>신고일</th>
	                    <th>상태</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr>
	                    <td>1</td>
	                    <td>공동 구매</td>
	                    <td>물품2</td>
	                    <td>물품 정보 부정확</td>
	                    <td>사유....</td>
	                    <td>2020.01.01</td>
	                    <td>완료</td>
	                </tr>
	                <tr>
	                    <td>2</td>
	                    <td>중고 거래</td>
	                    <td>물품1</td>
	                    <td>사기</td>
	                    <td>사유....</td>
	                    <td>2020.01.02</td>
	                    <td>처리중</td>
	                </tr>
	
	
	            </tbody>
	        </table>
	    </div>
	    
	    <div class="myReportBottom">
	        <button type="button" class="btn btn-warning">&lt;&nbsp;&nbsp;PREV</button>
	        <button type="button" class="btn btn-warning">NEXT&nbsp;&nbsp;&gt;</button>
	    </div>
	</div>
</div>


	<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>