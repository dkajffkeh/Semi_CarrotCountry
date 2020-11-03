<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 /* 찜 css */
   			.outer{
                   margin-top:50px;
                   margin-left:50px;
                   width:1000px;
                   font-family: 'Do Hyeon', sans-serif; 
                   }
            #countWish p{
                color:gray;
                font-size:25px;
                }
            #countWish{margin-left:40px;}
         
            #content{
                padding:30px;
                font-size:20px;
                /* border:4px solid black; */
                width:100%;
                height:100%;
            }
            .content1{
                box-shadow:5px 5px 10px 5px rgb(247, 233, 205);
                border-bottom-right-radius:40px;
                width:20%;
                height:40%;
                float:left;
                margin:20px;
            }
            #content img{
                width:180px; 
                height:140px;  
            }
            #nosSelectAlert{font-size:20px;}
            .button{
                /* background-color:red; */
                text-align:center;
                height:10%;
                width:100%;
                float:right;
            }
            .button button {
                float:right;
                margin-right:100px;
            }
</style>
</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>

	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">
	<!-- # 찜 body영역 -->
	 <div class="outer">
	    <br>
	    <h1>찜 목록</h1>
	    <hr color="gray">
	    <br>
	    <!-- 찜한 개수 -->
	    <div id="countWish">
	        <p>찜한 상품 : 9 </p>
	    </div>
	    <!-- 물품 정보 -->
	    <div id="content">
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""> <br>
	            물품명 <br>
	            13,800
	
	        </div>
	     
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""><br>
	            물품명 <br>
	            13,800
	            
	        </div>
	
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""><br>
	            물품명 <br>
	            13,800
	            
	        </div>
	
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""><br>
	            물품명 <br>
	            13,800
	            
	        </div>
	
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""><br>
	            물품명 <br>
	            13,800
	            
	        </div>
	
	        <div class="content1">
	            <input style='zoom:2.0;' type="checkbox" name="wishList" value="">
	            <img src="../../Common/images/맥북.jpg" alt=""><br>
	            물품명 <br>
	            13,800
	            
	        </div>
	    </div>
	
	    <div class= "button">
	        <button type="button" class="btn btn-secondary btn-lg" data-toggle="modal" data-target="#deleteWishlist">관심상품 삭제</button>
	    </div>
	
	    <br>
	
	</div>
	
	
	
	<!-- 체크박스 선택 후 삭제버튼 클릭 시 뜨는 창 -->
	
	<div class="modal" id="deleteWishlist">
	    <div class="modal-dialog">
	    <div class="modal-content">
	    
	        <!-- Modal body -->
	        <div class="modal-body" align="center">
	           삭제하시겠습니까?
	           <br><br>
	           <button type="button" class="btn btn-primary">확인</button>
	           
	        </div>
	        
	    </div>
	    </div>
	</div>

	<!------------------------------------------------------------------------------------->
	
	</div>
	</div>
	
	<!-- footerbar -->
	<%@ include file="../common/footerbar.jsp" %>
	

</body>
</html>