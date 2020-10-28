<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                <div id="pageName"> <h3>회원조회</h3> </div>
                <div id="pageContent">
                    <!-- search -->
                    <form action="" class="form-inline my-2 my-lg-0" id="search">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <!-- 회원조회 리스트 -->
                    <div id="board">
                        <form action="">
                            <table class="table table-sm table-hover">
                                <thead class="thead">
                                    <tr class="d-flax">
                                        <th width="80">회원번호</th>
                                        <th width="100">아이디</th>
                                        <th width="80">이름</th>
                                        <th width="150">연락처</th>
                                        <th width="150">이메일</th>
                                        <th width="100">생년월일</th>
                                        <th width="100">가입일</th>
                                        <th width="80">블랙 Y/N</th>
                                        <th width="100">블랙리스트</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>admin</td>
                                        <td>관리자</td>
                                        <td>010-1234-1234</td>
                                        <td>asdf@gmail.com</td>
                                        <td>1990-01-01</td>
                                        <td>2020-10-10</td>
                                        <td>N</td>
                                        <!-- 블랙 Y/N이 Y일 경우 안보임 -->
                                        <td>
                                            <!-- 클릭 시 블랙리스트 등록  -->
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