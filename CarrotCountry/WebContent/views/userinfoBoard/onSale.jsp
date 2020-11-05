<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/userinfoBoard/onSale.css">

</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>

	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">




	<!-- # 판매중 body영역-------------------------->

    <div class="outer">
        <br>
        <h2>판매중</h2>
        <hr color="gray">
        <br>
        <!-- 메뉴선택 버튼 -->
        <div class="navWrap">
            <div class="menu" align ="center"><a href="<%= contextPath %>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>">판매중</a></div>
            <div class="menu" align ="center"><a href="<%= contextPath %>/completedSales.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>">판매완료</a></div>
        </div>
        <br>
        <!-- 검색필터 드롭다운 -->
        <div class="container">
            <div class="dropdown">
                <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">
                등록일순
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="">등록일순</a>
                    <a class="dropdown-item" href="">진행상태순</a>
                    <a class="dropdown-item" href="">상품명순</a>
                </div>
            </div>

        </div>
        <br>
        <!-- 상품 내용 -->
        <div id="content">
            <!-- form태그 진행상태값 받아와야해서 넣음 -->
            <form action="" method="post" id="saleStatus">
                <table id="saleStatusTable">
                    <tr align="center">
                        <th></th>
                        <th><b>상품정보</b></th>
                        <th></th>
                        <th><b>진행상태</b></th>
                        <th></th>
                        <th><b>등록일</b></th>
                    </tr>
                    <tr align="center">
                        <th rowspan="2">1</th>
                        <td id="saleImage"  onClick = " location.href='' "rowspan="2"><img src="../../Common/images/3.jpg" alt="" style= "width:200px; height:150px; border-radius: 20px;" ></td>
                        <td>상품명</td>
                        <td>예약중</td>
                        <td><button type="button" class="btn btn-dark btn-sm" data-toggle="modal" data-target="#updateState">수정</button></td>
                        <td>xxxx-xx-xx</td>
                        <td id="button1">
                            <button type="button" class="btn btn-secondary btn-sm">끌어올리기</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deletePost">삭제</button>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" valign="top">xxxx원</td>
                    </tr>
                    <tr align="center">
                        <th rowspan="2">2</th>
                        <td id="saleImage" onClick = " location.href='' " rowspan="2"><img src="../../Common/images/맥북.jpg" alt="" style= "width:200px; height:150px; border-radius: 20px;"></td>
                        <td>상품명</td>
                        <td>판매중</td>
                        <td><button type="button" class="btn btn-dark btn-sm" data-toggle="modal" data-target="#updateState">수정</button></td>
                        <td>xxxx-xx-xx</td>
                        <td id="button1">
                            <button type="button" class="btn btn-secondary btn-sm">끌어올리기</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deletePost">삭제</button>
                        </td>
                    </tr>
                    <tr>
               
                        <td align="center" valign="top"">xxxx원</td>
                    </tr>
                    <tr align="center">
                        <th rowspan="2">3</th>
                        <td id="saleImage"  onClick = " location.href='' " rowspan="2"><img src="../../Common/images/1.jpg" alt="" style= "width:200px; height:150px; border-radius: 20px;" ></td>
                        <td>상품명</td>
                        <td>거래완료</td>
                        <td><button type="button" class="btn btn-dark btn-sm" data-toggle="modal" data-target="#updateState">수정</button></td>
                        <td>xxxx-xx-xx</td>
                        <td id="button1">
                            <button type="button" class="btn btn-secondary btn-sm" >끌어올리기</button>
                            <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deletePost">삭제</button>
                        </td>
                    </tr>
                    <tr>
                    
                        <td align="center" valign="top">xxxx원</td>
                    </tr>
                </table>

            </form>


        </div>

    </div>




<!--------------------------수정 버튼 클릭시 보여질 modal----------------------------------------->


<div class="modal" id="updateState">
    <div class="modal-dialog">
    <div class="modal-content">
    
        <!-- Modal Header -->
        <div class="modal-header">
        <h4 class="modal-title">진행상태 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body" align="center">
            
            <form action="" method="post">
             
           
                <input id="radioC" type="radio" name="salesStatus" value="판매완료" checked> <label for="radioC">판매완료</label><br><br>
                <input id="radioO" type="radio" name="salesStatus" value="판매중" > <label for="radioO">판매중</label><br><br>
                <input id="radioR" type="radio" name="salesStatus" value="예약중" > <label for="radioR">예약중</label><br><br>
                <br>
            </form>

        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
            <button type="submit" class="btn btn-primary" data-dismiss="modal">변경하기</button>
        </div>
          
        
    </div>
    </div>
</div>

<!-- ============================================================================================ -->



<!----------------------삭제버튼 클릭시 보여질 modal---------------------------------------->


<div class="modal" id="deletePost">
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