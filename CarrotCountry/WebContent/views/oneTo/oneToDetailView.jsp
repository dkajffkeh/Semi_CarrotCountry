<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="outer">
      <h5>상세보기</h5>
      <hr>

      
      <div class="d-flex p-3">
        <div class="p-2">제목 : </div>
        <div class="p-2"><input type="text" value=""></div>
        <div class="p-2">카테고리 : </div>
        <div class="p-2"><p>운영</p></div>
      </div>
      <div class="p-2">답변상태 : N</div>

      
      <br>
      <div class="form-group">
        <p style="height:200px" class="border border-warning">내용</p>
      </div>

      
      <div class="d-flex p-3">
        <div class="p-2">답변자 :</div>
        <div class="p-2">XXX</div>
      </div>
      <p style="height:200px" class="border border-warning">내용</p>
      <div align="center">
        <input type="submit" value="수정하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <!-- 관리자 -->
        <input type="submit" value="수정하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <!-- 사용자 -->
        <input type="submit" value="삭제하기" class="btn btn-warning btn-sm">&nbsp;&nbsp;
        <input type="button" value="뒤로가기" class="btn btn-warning btn-sm">
      </div>
      
  </div>
</body>
</html>