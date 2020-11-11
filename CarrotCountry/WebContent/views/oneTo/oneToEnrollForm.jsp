<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .outer{
        width:700px;
        height:550px;
        margin:auto;
        margin-top:50px;
    }
</style>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="outer">
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
                          <input type="radio" class="form-check-input" id="radio1" name="oneToType" value="11" checked>운영정책
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label" for="radio2">
                          <input type="radio" class="form-check-input" id="radio2" name="oneToType" value="22">계정/인증
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio3" name="oneToType" value="33">중고구매/판매
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="44">거래품목
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="55">신고관련
                        </label>
                      </div>
                      <br>
                      <div class="form-check-inline">
                      
                        <label class="form-check-label">
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="66">공동구매/판매
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="77">이용제재
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="88">블랙리스트관련
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="99">공구문의
                        </label>
                      </div>
                      <div class="form-check-inline">
                        <label class="form-check-label">
                          <input type="radio" class="form-check-input" id="radio4" name="oneToType" value="100">기타문의
                        </label>
                      </div>
                      
                </li>

                <li>
                    <label for="">제목*</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" name="oneToTitle" class="border border-warning" required>
                </li>

                <li>
                    <label for="">글작성*</label><br>
                    <textarea class="border border-warning" cols="100" rows="20" placeholder="내용을 입력하세요" name="oneToContent" style="resize: none;" maxlength="20" required></textarea>
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