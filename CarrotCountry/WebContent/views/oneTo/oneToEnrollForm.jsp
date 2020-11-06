<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="outer" align="center">
        <!-- 개인정보 수집 및 이용동의칸 남겨둠 -->
        <h4>1:1문의</h4>
        <hr>
        <form action="<%= contextPath %>/insert.on.jm" method="post">
        <input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
            <ul>
                <li>
                    <label for="">유형분류*</label>&nbsp;
                    <div class="form-check-inline">
                        <label class="form-check-label" for="radio1">
                          <input type="radio" class="form-check-input" id="radio1" name="oneToType" value="option1" checked>사이트이용
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label" for="radio2">
                          <input type="radio" class="form-check-input" id="radio2" name="oneToType" value="option2">중고구매
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio3" name="oneToType" value="option3">공동구매
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="option4">기타
                        </label>
                      </div>
                </li>

                <li>
                    <label for="">제목*</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="oneToTitle">
                </li>

                <li>
                    <label for="">글작성*</label><br>
                    <textarea name="oneTo_content" id="" cols="60" rows="10" placeholder="내용을 입력하세요" name="oneToContent" style="resize: none;"></textarea>
                </li>

            </ul>
            <div align="center">
                <input type="submit" class="btn btn-warning btn-sm">
                <input type="reset" class="btn btn-warning btn-sm">
            </div>

        </form>
    </div>
</body>
</html>