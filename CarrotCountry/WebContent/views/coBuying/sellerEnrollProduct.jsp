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
.GPForm table input{
    margin:10px;
    padding: 10px;
}
#min-count{
    width: 100;
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




* {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
    }
    
    a {
    text-decoration: none;
    }
    
    .navbar_Wrapper {
    background-color: orange;
    height: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    
    }
    
    .navbar_sizeWraper_1200px {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1200px;
    height: 100%;
    
    }
    
    .navbar_sizeWraper_1200px div {
    display: flex;
    justify-content: center;
    
    }
    
    .user_info_display_sectionWrapper {
    margin-left: 50px;
    }
    
    .user_info_display_sectionWrapper div {
    display: flex;
    align-items: center;
    }
    
    .MainLogo_Wrapper {
    display: flex;
    align-items: center;
    }
    
    .MainLogo_Wrapper>div i {
    font-size: 2rem;
    }
    
    .menu_bar {
    margin-right: 50px;
    }
    
    .menu_bar>table tr td a {
    color: white
    }
    
    .user_inter_font {
    font-size: 0.7rem;
    }
    
    .menu_bar table tr td {
    padding-left: 10px;
    
    
    }
</style>

</head>
<body>


<%@ include file="../common/commonNavbar.jsp"%>

    <div class="CS_content">
        <form action="" method="post" class="GPForm">
            <table>
                <tr>
                    <td width="150">대표 이미지 등록 0/4</td>
                    <td width="400">
                        <input type="image" name="" ><input type="image" name="">
                        <input type="image" name=""><input type="image" name="">
                    </td>
                    <td></td>
                </tr>




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
                    <td><input type="text" name="" class="form-control" id="min-count"></td>
                    <td></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="text" name="" class="form-control"></td>
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
                    <td>주소입력</td>
                    <td>
                        <select name="" class="" id="address1">
                            <option selected>Custom Select Menu</option>
                            <option value="volvo">Volvo</option>
                            <option value="fiat">Fiat</option>
                            <option value="audi">Audi</option>
                        </select> 
                        <select name="" class="" id="address2">
                            <option selected>Custom Select Menu</option>
                            <option value="volvo">Volvo</option>
                            <option value="fiat">Fiat</option>
                            <option value="audi">Audi</option>
                        </select>
                        
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>카테고리 선택</td>
                    <td>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">디지털/가전</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">가구/인테리어</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">유아동/유아도서</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">생활/가공식품</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">스포츠/레저</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">여성잡화</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">여성의류</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">남선패션/잡화</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">여성의류</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">남선패션/잡화</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">게임/취미</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">뷰티/미용</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">반려동물용품</label>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">도서/티켓/음반</label>
                        <br>
                        <input type="checkbox" id="" name="category" value="">
                        <label for="">기타물품</label>
                       
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>상세 설명 첨부</td>
                    <td><textarea name="content" id="editor" style="min-height: 500px;"></textarea></td>
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