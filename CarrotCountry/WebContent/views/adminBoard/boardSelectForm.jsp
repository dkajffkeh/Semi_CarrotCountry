<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<link rel="stylesheet" href="resources/css/adminBoard/adminBoardStyle.css">

</head>
<body>

	<!-- nav 영역 -->
	<%@ include file="../common/commonNavbar.jsp" %>
	
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
                    <h3>게시글 조회</h3>
                </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="" class="form-inline my-2 my-lg-0" id="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 게시글 리스트 -->
                    <div id="board">
                        <form action="">
                            <table class="table table-sm table-hover" align="center">
                                <thead class="thead">
                                    <tr class="d-flax">
                                        <th width="100">게시글번호</th>
                                        <th width="100">게시글종류</th>
                                        <th width="100">카테고리</th>
                                        <th width="100">게시글명</th>
                                        <th width="100">작성자</th>
                                        <th width="100">작성일</th>
                                        <th width="100">조회수</th>
                                        <th width="150">블라인드Y/N</th>
                                        <th width="100">블라인드</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>중고거래</td>
                                        <td>의류</td>
                                        <td >청바지</td>
                                        <td>USER02</td>
                                        <td>20-10-01</td>
                                        <td>4</td>
                                        <td>N</td>
                                        <!-- 블라인드 Y/N이 Y일 경우 안보임 -->
                                        <td>
                                            <!-- 클릭시 게시물 블라인드 => 알림 -->
                                            <a href="" class="btn btn-outline-danger btn-sm">등록</a>
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