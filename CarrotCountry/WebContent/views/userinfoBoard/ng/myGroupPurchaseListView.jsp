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
        width:260px;
        height:305px;
        border:5px solid rgb(228, 183, 87);
        box-shadow:5px 5px 10px 5px rgb(247, 233, 205);
        margin: 20px;
        float: left;
        border-radius:0px 0px 10px 10px;
    }
    .gp>img{
        width:100%;
        height:150px;
    }

    .gp td{
        font-size:15px;
        font-weight:900;
    }
    .gp:hover{
        background:rgba(175, 175, 175, 0.3);
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
			        <img src="<%= contextPath %>/<%= m.getThumbnailLoadpath() %>">
			            <table>
			                <tr>
			                    <td colspan="2">상품명</td><td colspan="2"><%= m.getPostName() %></td>
			                </tr>
			                <tr>
			                    <td colspan="2">진행자</td><td colspan="2"><%= m.getMemNickname() %></td>
			                </tr>
			                <tr>
			                    <td colspan="2">최소인원/현재인원</td><td colspan="2"><%= m.getGpMinpeople() %>/<%= m.getGpPeople() %></td>
			                </tr>
			                <tr>
			                    <td colspan="2">마감일</td><td colspan="2"><%= m.getGpDeadLine() %></td>
			                </tr>
			                <tr>
			                	<td colspan="2">상태</td><td colspan="2"><%= m.getGpStatus() %></td>
			                </tr>
			                <tr>
			                	<td><a href="" class="btn btn-warning btn-sm" style="color:white; margin-left:1.8px;">상품조회</a></td>
			                	<td><a href="" class="btn btn-warning btn-sm" style="color:white;">구매정보</a></td>
			                	<td><a href="" class="btn btn-warning btn-sm" style="color:white;">문의하기</a></td>
			                    <td><a href="" class="btn btn-warning btn-sm" style="color:white;">배송조회</a></td>
			                </tr>
			            </table>
			
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