<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoardNg.model.vo.*" %>
    
<%
	MyPurchaseInfo mpi = (MyPurchaseInfo)request.getAttribute("mpi");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
	   margin-top:50px;
	   margin-left:50px;
	   width:1000px;
	   font-family: 'Do Hyeon', sans-serif;
	   height:700px;
	}
    .gpDetailWrap{
        border:3px solid #ffa500;
        width:1000px;
        height:700px;
        border-radius:10px 10px 10px 10px;
        padding:20px;
    }
    .gpTop, .gpMid, .gpBottom{
        background:rgb(246, 247, 245);
        width:100%;
        height:20%;
        margin-bottom:30px;
        border-radius:10px 10px 10px 10px;
    }
    .gpTop>img{
        width:150px;
        height:100%;
        float:left;
        margin-left:10px;
        border-radius:30px 30px 30px 30px;
    }
    .gpDetailWrap table{
        margin:25px 0px 0px 10px;
        float:left;
        font-size:15px;
    }
    .gpDetailWrap th{
        text-align:left;
    }
    .gpDetailWrap td{
        color:gray;
    }
    .sRed{
        color:red;
    }
    .sOrange{
        color:#ffa500;
    }
	

		
</style>
</head>
<body>

	<!--  headerNavbar -->
	<%@ include file= "../../common/commonNavbar.jsp"%>
	
	<div class="myPageWrapper">
	
		<!--  mypageMenubar -->
		<%@ include file= "../mypageMenubar.jsp" %>
		
		<div class="myPageWrapper_content">
			<div class="outer">
		       	<br>
		       	<h1>공동구매 진행현황 (상세조회)</h1>
		        <hr color="gray">
		        
				<div class="gpWrap">
					<% if(mpi == null){ %>
						<br><br><br>
						<div align="center">
							공동구매 참여 내역이 존재하지 않습니다.
						</div>
					<% }else { %>
						
						    <div class="gpDetailWrap">
        <hr>
        <h2>상품 정보 <span class="sOrange">(<%= mpi.getGpStatus().equals("Y") ? "진행중" : "마감" %>)</span></h2>
        <div class="gpTop">
            <img src="<%= contextPath %>/<%= mpi.getThumbnailLoadpath() %>">
            <table>
                <tr>
                    <th width="70" height="30">상품명</th><td width="200px"><%= mpi.getPostName() %></td><th width="70" rowspan="2">진행자</th><td width="200px"><%= mpi.getMemNickname() %></td><th width="70"><% %>거래유형</th><td><%= mpi.getDealType().equals("C") ? "계좌이체 거래" : "계좌이체 거래" %></td>
                </tr>
                <tr>
                    <th height="30">상품가격</th><td><s><%= mpi.getGpPrice() %></s></td><td><%= mpi.getMemName() %>&nbsp;&nbsp;&nbsp;<%= mpi.getMemPhone() %></td><th>마감일</th><td><%= mpi.getGpDeadLine() %>&nbsp;&nbsp;&nbsp;<span class="sOrange"><%= mpi.getdDay()<0 ? "마감" : "D-day " + (mpi.getdDay() + 1)%></span></td>
                </tr>
                <tr>
                    <th height="30">할인가</th><td><span class="sRed"><%= mpi.getGpDrate()%>% &#10140; </span><span class="sOrange"><%= mpi.getGpDprice() %></span></td><th>계좌번호</th><td><%= mpi.getBank() %></td><th>인원</th><td><%= mpi.getGpMinpeople() %>/<% if(mpi.getGpMinpeople() > mpi.getGpPeople()){ %> <span class="sRed"> <%= mpi.getGpPeople() %> </span> <% }else{ %> <span class="rOrange"><%= mpi.getGpPeople() %></span> <% } %>  </td>
                </tr>
            </table>
        </div>
        <hr>
        <h2>구매정보</h2>
        <div class="gpMid">
            <table>
                <tr>
                    <th width="70" height="30">구매번호</th><td width="200px"><%= mpi.getPurchaseNo() %></td><th width="70">옵션</th><td width="200px"><%= mpi.getOptionName() %></td><th width="150">결제금액(배송비 포함)</th><td ><span class="sOrange"><%= mpi.getPurchasePrice() %></span></td>
                </tr>
                <tr>
                    <th height="30">구매일</th><td><%= mpi.getPurchaseDate() %></td><th rowspan="2">요청사항</th><td rowspan="2" colspan="3" width="400px" style="border:2px solid gray; font-size:13px;"><%= mpi.getRequests() == null ? "입력하신 요청사항이 없습니다." : mpi.getRequests().equals("1") ? "부재시 경비실에 맞겨주세요" : mpi.getRequests().equals("2") ? "배송 전 연락주세요" : mpi.getRequests() %></td>
                </tr>
                <tr>
                    <th height="30">입금자명</th><td><%= mpi.getDepositor() %></td>
                </tr>
            </table>
        </div>
        <hr>
        <h2>배송정보 <span class="sOrange"><!-- (<%= mpi.getSlStatus().equals("Y") ? "배송중" : "배송완료" %>) --></span></h2>

        
        <div class="gpBottom">
            <table>
                <tr>
                    <th width="70" height="30">수령인</th><td width="200"><%= mpi.getMyName() %></td><th width="70">택배사명</th><td width="200"><%= mpi.getCourier() == null ? "상품 배송 전입니다." : mpi.getCourier() %></td>
                </tr>
                <tr>
                	<th height="30">연락처</th><td><%= mpi.getMyPhone() %></td><th>운송장번호</th><td><%= mpi.getTrackingNo() == 0 ? "상품 배송 전입니다." : mpi.getTrackingNo() %></td>
                </tr>
                <tr>
                    <th height="30">배송지</th><td colspan="3"><%= mpi.getShippingAddress() %></td>
                </tr>
            </table>
        </div>
    </div>
    <br>
    <div align="center">
        <button class="btn btn-warning" onclick="history.back();">뒤로가기</button>
    </div>
					<% } %>
			    </div>
			</div>
		</div>
	</div>

		<!-- footerbar -->
		<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>