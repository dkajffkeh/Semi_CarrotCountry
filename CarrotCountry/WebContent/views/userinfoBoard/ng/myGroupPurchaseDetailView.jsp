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
		       	<h1>공동구매 진행현황</h1>
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
        <h2>상품 정보 <span class="sOrange">(<%= mpi.getGpStatus() %>)</span></h2>
        <div class="gpTop">
            <img src="<%= mpi.getThumbnailLoadpath() %>">
            <table>
                <tr>
                    <th width="100" height="30">상품명</th><td width="200px"><%= mpi.getPostName() %></td><th width="100">진행자</th><td width="200px"><%= mpi.getMemNickname() %></td>
                </tr>
                <tr>
                    <th height="30">상품가격</th><td><s><%= mpi.getGpPrice() %></s></td><th>최소/현재 인원</th><td><%= mpi.getGpMinpeople() %>/<% if(mpi.getGpMinpeople() > mpi.getGpPeople()){ %> <span class="sRed"> <%= mpi.getGpPeople() %> </span> <% }else{ %> <span class="rOrange"><%= mpi.getGpPeople() %></span> <% } %>  </td>
                </tr>
                <tr>
                    <th height="30">할인가</th><td><span class="sRed"><%= mpi.getGpDrate()%>% &#10140; </span><span class="sOrange"><%= mpi.getGpDprice() %></span></td><th>마감일</th><td><%= mpi.getGpDeadLine() %>&nbsp;&nbsp;&nbsp;<span class="sOrange"><%= mpi.getdDay()<0 ? "마감" : mpi.getdDay()%></span></td>
                </tr>
            </table>
        </div>
        <hr>
        <h2>구매정보</h2>
        <div class="gpMid">
            <table>
                <tr>
                    <th width="100" height="30">구매번호</th><td width="200px"><%= mpi.getPurchaseNo() %></td><th width="100">옵션</th><td width="200px"><%= mpi.getOptionName() %></td><th width="100">결제금액</th><td ><span class="sOrange"><%= mpi.getPurchasePrice() %></span></td>
                </tr>
                <tr>
                    <th height="30">구매일</th><td><%= mpi.getPurchaseDate() %></td><th>은행명</th><td><%= mpi.getBank() %></td><th rowspan="2">요청사항</th><td rowspan="2" width="200" style="border:2px solid black; font-size:13px;"><%= mpi.getRequests() %></td>
                </tr>
                <tr>
                    <th height="30">입금자명</th><td><%= mpi.getDepositor() %></td><th>계좌번호</th><td><%= mpi.getAccount() %>&nbsp;(<%= mpi.getMemName() %>)</td>
                </tr>
            </table>
        </div>
        <hr>
        <h2>배송정보 <span class="sOrange">(<%= mpi.getSlStatus().equals("Y") ? "배송중" : "배송완료" %>)</span></h2>

        
        <div class="gpBottom">
            <table>
                <tr>
                    <th height="30" width="100" >수령인</th><td width="200"><%= mpi.getMyName() %></td><th width="100">택배사명</th><td width="200"><%= mpi.getCourier() %></td>
                </tr>
                <tr>
                	<th height="30">연락처</th><td><%= mpi.getMyPhone() %></td><th>운송장번호</th><td><%= mpi.getTrackingNo() %></td>
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