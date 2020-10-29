<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페잊</title>

<link rel="stylesheet" href="resources/css/adminBoard/adminBoardStyle.css">

</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp" %>
	
	<!-- content영역 -->
    <div class="wrap">
        <div id="content">
            <div id="content1">
                <!-- 관리페이지 메뉴 리스트 -->
				<%@ include file="./adminMenubar.jsp" %>
            </div>
            <div id="content2">
                <!-- 페이지 제목 -->
                <div id="pageName">
                    <h3>블라인드 게시글 관리</h3>
                </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="" class="form-inline my-2 my-lg-0" id="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 블라인드 게시글 리스트 -->
                    <div id="board">
                        <form action="">
                            <table class="table table-sm table-hover">
                                <thead class="thead">
                                    <tr class="d-flax">
                                        <th width="100">번호</th>
                                        <th width="100">게시글종류</th>
                                        <th width="100">카테고리</th>
                                        <th width="150">게시글명</th>
                                        <th width="80">조회수</th>
                                        <th width="100">작성자</th>
                                        <th width="100">작성일</th>
                                        <th width="100">신고횟수</th>
                                        <th width="100"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>중고거래</td>
                                        <td>카테고리</td>
                                        <td>자전거</td>
                                        <td>4</td>
                                        <td>USER02</td>
                                        <td>20-10-01</td>
                                        <td>6</td>
                                        <td>
                                            <!-- 클릭시 블라인드 해제 -->
                                            <a href="" class="btn btn-outline-danger btn-sm">해제</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                        </form>
                    </div>
                    <!-- 페이지 번호 -->
                    <div id="boardNum" align="center">
                        <a href="">&lt; 이전</a>

                        <a href="">1</a>
                        <a href="">2</a>
                        <a href="">3</a>
                        <a href="">4</a>

                        <a href="">다음 &gt;</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- footer 영역 -->
    <%@ include file="../common/footerbar.jsp" %>
	
</body>
</html>