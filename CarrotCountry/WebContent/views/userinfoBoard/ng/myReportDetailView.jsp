<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	   height:780px;
	}
	.outer>span{
	    font-size:20px;
	}
	.myReportBottom{
		text-align:center;
		width:100%;
		height:10%;
		padding:12px;
		

		
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
		       	<h1>신고 내역</h1>
		        <hr color="gray">
		        
		        <br><br><br><br><br>
				
				
				
				<div class=""></div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th width="80px">신고번호</th>
							<th>게시글 명</th>
							<th>신고유형</th>
							<th>신고사유</th>
							<th>신고받은사람</th>
							<th>신고일</th>
							<th>상태</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>컴퓨터 팔아요@@</td>
							<td>중고 거래</td>
							<td>사기</td>
							<td>난사기꾼임</td>
							<td>2020.01.01</td>
							<td>완료</td>
						</tr>	
						<tr>
							<td>1</td>
							<td>노트북팔아요@</td>
							<td>중고 거래</td>
							<td>사기</td>
							<td>노트북사기꾼</td>
							<td>2020.01.01</td>
							<td>완료</td>
						</tr>	
					</tbody>
				</table>
			</div>
				<div class="myReportBottom">
					<button type="button" class="btn btn-warning">&lt;&nbsp;&nbsp;PREV</button>
					<a href="">1</a>
					<a href="">2</a>
					<a href="">3</a>
					<a href="">4</a>
					<a href="">5</a>																				
					<button type="button" class="btn btn-warning">NEXT&nbsp;&nbsp;&gt;</button>
				</div>
		</div>
	</div>

		<!-- footerbar -->
		<%@ include file="../../common/footerbar.jsp" %>
</body>
</html>