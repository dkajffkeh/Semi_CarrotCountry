<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/76c88d06f7.js" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<style>
.CS_content>div{
    width:100%;
    margin:auto;
    padding:100px;
    
    
}

.GPForm table{margin:auto;}
.GPForm table img:hover{cursor: pointer;}
.GPForm table input{
    margin:10px;
    padding: 10px;
}
#min-count{
    width: 150px;
}
input[type="text" i] {
    padding: 1px 2px;
    width: 300px;
}
input[type=date].form-control, input[type=datetime-local].form-control, input[type=month].form-control, input[type=time].form-control {
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    width: 150px;
}
select {
    word-wrap: normal;
    width: 100px;
}


</style>

</head>
<body>


<%@ include file="../common/commonNavbar.jsp"%>




    <div class="CS_content">
        <form action="" method="post" class="GPForm">
            <table>
                <tr>
                    <td width="150">대표 이미지 등록 0/3</td>
                    <td width="400">
                        <img id="titleImg" width="100" height="100">
                        <img id="contentImg1" width="100" height="100">
                        <img id="contentImg2" width="100" height="100">
                    </td>
                    <td></td>
                </tr>

                <div id="fileArea">
                    <input type="file" name="file1" id="file1" onchange="loadImg(this, 1)" required>
                    <input type="file" name="file2" id="file2" onchange="loadImg(this, 2)">
                    <input type="file" name="file3" id="file3" onchange="loadImg(this, 3)">
                </div>
    
                <script>
                    $(function(){
                        $("#fileArea").hide();
    
                        $("#titleImg").click(function(){
                            $("#file1").click();
                        });
                        $("#contentImg1").click(function(){
                            $("#file2").click();
                        });
                        $("#contentImg2").click(function(){
                            $("#file3").click();
                        });
                    });
    
                    function loadImg(inputFile, num){
    
                        if(inputFile.files.length == 1){
                            var reader = new FileReader();
    
                            // 파일을 읽어들이는 메소드 호출
                            // --> 해당 파일을 읽어들이는 순간 해당 그 파일만의 고유한 url 주어짐
                            reader.readAsDataURL(inputFile.files[0]); 
    
                            // 파일 읽어들이기가 다 완료가 되었을 때 실행할 함수를 정의
                            reader.onload = function(e){
                                // 각 영역에 맞춰서 이미지 미리보기
                                switch(num){
                                    case 1 : $("#titleImg").attr("src", e.target.result); break;
                                    case 2 : $("#contentImg1").attr("src", e.target.result); break;
                                    case 3 : $("#contentImg2").attr("src", e.target.result); break;
                                }
                            };
    
                        }else{ 
                            // 현재 선택된 file이 사라졌을 경우 => 미리보기 해제
                            switch(num){
                                case 1 : $("#titleImg").attr("src", null); break;
                                case 2 : $("#contentImg1").attr("src", null); break;
                                case 3 : $("#contentImg2").attr("src", null); break;
                            }
    
                        }
    
    
                    }
                </script>



                <tr>
                    <td>상품명</td>
                    <td><input type="text" name="POST_NAME" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>모집기간</td>
                    <td><input type="date" name="" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>최소 인원</td>
                    <td><input type="number" name="" class="form-control" id="min-count" min="0"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="number" name="" class="form-control" min="0" placeholder="원 단위로 입력해주세요"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>옵션</td>
                    <td>
                        <input type="text" class="form-control" id="option-add">
                        <select name="" id="option"> 
                        </select>
                    </td>
                    <td>
                        <button onclick="add1()" class="btn btn-warning btn-sm">추가</button>
                    </td>
                </tr>


                <tr>
                    <td> <br> 주소입력</td>
                    <td> <br>
                        서울특별시
                        <select id="local_gu">
                            <option value="gn">강남구</option>
                            <option value="gs">강서구</option>
                            <option value="sp">송파구</option>
                        </select> 
                        <select id="local_dong">
                            <option value="1">오금동</option>
                            <option value="2">오류동</option>
                            <option value="3">상일동</option>
                            <option value="4">화곡동</option>
                            <option value="5">목동</option>
                            <option value="6">오금동</option>
                            <option value="7">상일동</option>
                            <option value="8">화곡동</option>
                            <option value="9">상일동</option>
                            <option value="10">화곡동</option>
                        </select>
                        
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td> <br> 카테고리 선택</td>
                    <td> <br>
                        <select id="categoty" name="category">
                            <option value="20">디지털/가전</option>
                            <option value="30">가구/인테리어</option>
                            <option value="40">유아동/유아도서</option>
                            <option value="50">생활/가공식품</option>
                            <option value="60">스포츠/레저</option>
                            <option value="70">여성잡화</option>
                            <option value="80">여성의류</option>
                            <option value="90">남성패션/잡화</option>
                            <option value="100">게임/취미</option>
                            <option value="110">뷰티/미용</option>
                            <option value="120">반려동물용품</option>
                            <option value="130">도서/티켓/음반</option>
                            <option value="140">기타물품</option>
                        </select>

                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td><br> 상세 설명 첨부</td>
                    <td><br> <textarea name="content" id="editor" style="min-height: 500px;"></textarea></td>
                    <td></td>
                </tr>


                <script>
                    ClassicEditor
                        .create( document.querySelector( '#editor' ) , {
                           
                            removePlugins: ['ImageUpload']
                        } )  
                        .catch( error => {
                            console.error( error );
                        } );
            
                    </script>




                <tr>
                    <td>입금계좌</td>
                    <td>
                        <input type="text" class="form-control" id="account-add" >
                        <select name="" id="account">
                            
                        </select>
                    </td>
                    <td><button onclick="add2()" class="btn btn-warning btn-sm">추가</button></td>
                </tr>

                <script>
                    var valOption = 0;
                    var valAccount = 0;
                    function add1(){

                        $("#option").append("<option value=" + (valOption ++ ) +">" + $("#option-add").val() + "</option>");

                        $("#option-add").val(" ");
                    }
                    
                    function add2(){
                        $("#account").append("<option value=" + (valAccount ++ ) +">" + $("#account-add").val() + "</option>");
                    }

                </script>
                <tr>
                    <td>교환 및 환불 방법</td>
                    <td><textarea class="form-control" cols="5" rows="5" id="comment" name="text" style="resize: none;"></textarea></td>
                    <td></td>
                </tr>
            </table>
            <br><br><br><br>
            <div align="center">
                <button type="submit" class="btn btn-warning btn-sm">등록하기</button>
                <button type="button" class="btn btn-warning btn-sm">뒤로가기</button>
            </div>

        </form>

        
    

    </div>


    <br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>