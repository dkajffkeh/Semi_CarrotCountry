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
                <div id="pageName">
                    <h3>블랙리스트 관리</h3>
                </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="" class="form-inline my-2 my-lg-0" id="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 블랙리스트회원 리스트 조회 -->
                    <div id="board">
                        <form action="">
                            <table class="table table-sm table-hover">
                                <thead class="thead">
                                    <tr class="d-flax">
                                        <th width="50">번호</th>
                                        <th width="100">아이디</th>
                                        <th width="80">이름</th>
                                        <th width="150">연락처</th>
                                        <th width="200">이메일</th>
                                        <th width="100">신고횟수</th>
                                        <th width="200">사유</th>
                                        <th width="100">블랙</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>USER02</td>
                                        <td>user02</td>
                                        <td>010-1234-1234</td>
                                        <td>asdf@naver.com</td>
                                        <td>7</td>
                                        <td>욕설/비방에 따른 제재</td>
                                        <td>
                                            <!-- 클릭시 블랙리스트 해제 => 알림 -->
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