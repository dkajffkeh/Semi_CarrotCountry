<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<link rel="stylesheet"
	href="resources/css/adminBoard/adminBoardStyle.css">

</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp"%>

	<!-- content 영역 -->
	<div class="wrap">
		<div id="content">
			<div id="content1">
				<!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp" %>
			</div>
			<div id="content2">
				<!-- 페이지 제목 -->
				<div id="pageName">
					<h3>신고조회</h3>
				</div>
				<div id="pageContent">
					<!-- search -->
					<form action="" class="form-inline my-2 my-lg-0" id="search">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-secondary my-2 my-sm-0"
							type="submit">Search</button>
					</form>
					<!-- 신고자 리스트 -->
					<div id="board">
						<form action="">
							<table class="table table-sm table-hover">
								<thead class="thead">
									<tr class="d-flax">
										<th width="70">신고번호</th>
										<th width="100">신고일</th>
										<th width="100">게시글유형</th>
										<th width="200">신고사유</th>
										<th width="100">작성자</th>
										<th width="100">신고자</th>
										<th width="50">비고</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>20-10-02</td>
										<td>게시글</td>
										<td>욕설/비방</td>
										<td>USER01</td>
										<td>USER02</td>
										<td></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
					<!-- 페이지 번호 -->
					<div id="boardNum" align="center">
						<a href="">&lt; 이전</a> <a href="">1</a> <a href="">2</a> <a
							href="">3</a> <a href="">4</a> <a href="">다음 &gt;</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer 영역 -->
    <%@ include file="../common/footerbar.jsp" %>

</body>
</html>