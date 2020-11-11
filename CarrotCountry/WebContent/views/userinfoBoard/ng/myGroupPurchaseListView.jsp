<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoardNg.model.vo.*, java.util.ArrayList" %>
    
<%
	RepPageInfo pi = (RepPageInfo)request.getAttribute("pi");
	ArrayList<MyPurchaseInfo> list = (ArrayList)request.getAttribute("list");
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
	.gpWrap{
		width:100%;
		height:100%
	}
	.outer>span{
	    font-size:20px;
	}
	.myReportBottom{
		text-align:center;
		width:100%;
		height:10%;
		padding:12px;
	}
    .gp{
        width:100%;
        height:180px;
        border:3px solid white;
        box-shadow:5px 5px 10px 5px rgb(247, 233, 205);
        margin: 20px;
        float: left;
        border-radius:10px 10px 10px 10px;
    }
    .gp div{
    	height:100%;
    	float:left;
    }
    .gpLeft{
    	width:20%;
    }
    .gpCenter{
    	margin-left:100px;
    	width:30%;
    }
    .gpRight{
    	margin-left:100px;
    	width:25%;
    }
    
    .gpCenter>table{
    	margin-top:20px;
    }
    .gpCenter td{
    	height:30px;
    	font-size:40px;
    }
    
    .gpLeft>img{
        width:100%;
        height:100%;
        border-radius:30px 30px 30px 30px;
    }

    .gp td{
        font-size:15px;
        font-weight:900;
    }
    .gp:hover{
        border:3px solid #ffa500;
    }
    .gpRight a{
    	padding-top:60px;
    	width:20%;
    	height:100%;
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
				<% if(list.isEmpty()){ %>
					<br><br><br>
					<div align="center">
						공동구매 참여 내역이 존재하지 않습니다.
					</div>
				<% }else { %>
				<% for(MyPurchaseInfo m : list){ %>
			    <div class="gp">
			    	<div class="gpLeft">
			        	<img src="<%= contextPath %>/<%= m.getThumbnailLoadpath() %>">
			    	</div>
			    	<div class="gpCenter">
			            <table>
			                <tr>
			                    <td colspan="2">상품명</td><td colspan="2">&nbsp;&nbsp;<%= m.getPostName() %></td>
			                </tr>

			                <tr>
			                    <td colspan="2">진행자</td><td colspan="2">&nbsp;&nbsp;<%= m.getMemNickname() %></td>
			                </tr>
			                <tr>
			                    <td colspan="2">최소인원/현재인원</td><td colspan="2">&nbsp;&nbsp;<%= m.getGpMinpeople() %>/<%= m.getGpPeople() %></td>
			                </tr>
			                <tr>
			                    <td colspan="2">마감일</td><td colspan="2">&nbsp;&nbsp;<%= m.getGpDeadLine() %></td>
			                </tr>
			                <tr>
			                	<td colspan="2">진행상태</td><td colspan="2">&nbsp;&nbsp;<%= m.getGpStatus().equals("Y") ? "진행중" : "마감" %></td>
			                </tr>
			            </table>
					</div>
					<div class="gpRight">
			                	<a href="<%= contextPath %>/buyerdetail.pro.jy?bno=<%= m.getPostNo() %>" class="btn btn-warning btn-sm" style="color:white;">상품조회</a>
			                	<a href="<%= contextPath %>/groupPurchaseDetail.gp.ng?memNo=<%= loginMember.getMemNo() %>&purchaseNo=<%= m.getPurchaseNo() %>" class="btn btn-warning btn-sm" style="color:white;">구매정보</a>
			                	<a href="<%= contextPath %>/buyerlist.qna.jy?currentPage=1&bno=<%= m.getPostNo() %>" class="btn btn-warning btn-sm" style="color:white;">문의하기</a>
			        </div>
			    </div>
				<% } %>
			<% } %>
			    </div>
				<p align="center" style="font-weight:900; font-size:20px"><%= pi.getRepCurrentPage() %>page</p>
				<div class="myReportBottom">
					
					<% if(!list.isEmpty()){ %>
						<% if(pi.getRepCurrentPage() != 1){ %>
							<a href="<%= contextPath %>/groupPurchaseList.gp.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= pi.getRepCurrentPage() -1 %>" class="btn btn-warning" style="color:white;">&lt;&nbsp;&nbsp;PREV</a>				
						<% } %>
						
						<% for(int i = pi.getRepStartPage(); i<=pi.getRepEndPage(); i++){ %>
							<a href="<%= contextPath %>/groupPurchaseList.gp.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= i %>" class="btn btn-secondary btn-sm" style="color:white;"><%= i %></a>
						<% } %>
							
						<% if(pi.getRepCurrentPage() != pi.getRepMaxPage()){ %>
							<a href="<%= contextPath %>/groupPurchaseList.gp.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=<%= pi.getRepCurrentPage() +1 %>" class="btn btn-warning" style="color:white;">NEXT&nbsp;&nbsp;&gt;</a>																			
						<% } %>
					<% } %>
				</div>
			</div>
		</div>
	</div>

		<!-- footerbar -->
		<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>