<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="CS_content">
        <div class="content_1">
            <table class="table table-bordered center list-area"  align="center">

                <tbody>
                    <tr>
                        <td>운영정책</td>
                        <td>계정/인증</td>
                        <td>중고구매/판매</td>
                    </tr>
                    <tr>
                        <td>거래품목</td>
                        <td>신고관련</td>
                        <td>공동구매/판매</td>
                    </tr>
                    <tr>
                        <td>이용 제재</td>
                        <td>블랙리스트관련</td>
                        <td >공구문의</td>
                    </tr>
                </tbody>
            </table>
        </div>
       <div class="CS_content_2">
        <center><b>사용자들이 자주 묻는 질문을 확인해보세요!</b></center>
        <br>
       </div>
       <div class="content_3">
        <ul class="list-group" id="myList">
            <li class="list-group-item">공지사항</li>
            <li class="list-group-item">Second item</li>
            <li class="list-group-item">Third item</li>
            <li class="list-group-item">Fourth</li>
          </ul>  
          <br><br><br>
        <input class="form-control" id="myInput" type="text" placeholder="Search..">

       </div>
       <div class="content_4">
        <div class="container">
            <div class="jumbotron" align="center">
            <h6>안녕하세요</h1>      
            <a href="">1:1문의<a>
            </div>
        </div>
       </div>
       <div class="content_5">
        <center><a href="">이용약관</a></center>
        <br>
        <center><a href="">개인정보이용방침</a></center>
        <br><br>
       </div>

       <script>
        $(document).ready(function(){
          $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myList li").filter(function() {
              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
          });
        });
        </script>

    </div>
</body>
</html>