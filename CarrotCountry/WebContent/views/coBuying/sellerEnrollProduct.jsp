<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
.textOrange{
	color:orange;
	font-weight:800;	
}
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
#min-count{width: 150px;}
#gpDRate{width: 150px;}
#gpDeadline{width: 300px;}
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
        <form name="form" id="insertForm" action="<%= contextPath %>/insert.pro.jy" method="post" class="GPForm" enctype="multipart/form-data">
        
         <%if(loginMember != null){ %>
		<input type="hidden" name="memNo"   value="<%=loginMember.getMemNo()%>">
        <input type="hidden" name="memNick" value="<%=loginMember.getMemNickname()%>">
            <%} %>	<!-- 이거 나중에 지우기 어짜피 로그인된 유저임 -->
        
            <table id="enrollTable">

                <tr>
                    <td class="textOrange" width="150"> <br> 대표 이미지 등록 <br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ( 0 / 6 )</td>
                    <td width="400"> <br>
                        <img id="titleImg" width="100" height="100">
                        <img id="contentImg1" width="100" height="100">
                        <img id="contentImg2" width="100" height="100">
                        <img id="contentImg3" width="100" height="100">
                        <img id="contentImg4" width="100" height="100">
                        <img id="contentImg5" width="100" height="100">
                    </td>
                    <td></td>
                </tr>

                <div id="fileArea">
                    <input type="file" name="file1" id="file1" onchange="loadImg(this, 1)">
                    <input type="file" name="file2" id="file2" onchange="loadImg(this, 2)">
                    <input type="file" name="file3" id="file3" onchange="loadImg(this, 3)">
                    <input type="file" name="file4" id="file4" onchange="loadImg(this, 4)">
                    <input type="file" name="file5" id="file5" onchange="loadImg(this, 5)">
                    <input type="file" name="file6" id="file6" onchange="loadImg(this, 6)">
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
                        $("#contentImg3").click(function(){
                            $("#file4").click();
                        });
                        $("#contentImg4").click(function(){
                            $("#file5").click();
                        });
                        $("#contentImg5").click(function(){
                            $("#file6").click();
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
                                    case 4 : $("#contentImg3").attr("src", e.target.result); break;
                                    case 5 : $("#contentImg4").attr("src", e.target.result); break;
                                    case 6 : $("#contentImg5").attr("src", e.target.result); break;
                                }
                            };
    
                        }else{ 
                            // 현재 선택된 file이 사라졌을 경우 => 미리보기 해제
                            switch(num){
                                case 1 : $("#titleImg").attr("src", null); break;
                                case 2 : $("#contentImg1").attr("src", null); break;
                                case 3 : $("#contentImg2").attr("src", null); break;
                                case 4 : $("#contentImg3").attr("src", null); break;
                                case 5 : $("#contentImg4").attr("src", null); break;
                                case 6 : $("#contentImg5").attr("src", null); break;
                            }
    
                        }
    
    
                    }
                </script>
               
                <tr>
                    <td class="textOrange">상품명</td>
                    <td><input type="text" name="postName" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">모집기간</td>
                    <td><input type="date" name="gpDeadline" id="gpDeadline" class="form-control"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">최소 인원</td>
                    <td><input type="number" name="gpMinPeople" class="form-control" id="min-count" min="0"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">가격</td>
                    <td><input type="number" name="gpPrice" class="form-control" min="0" placeholder="원 단위로 입력해주세요"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">할인율</td>
                    <td><input type="number" name="gpDRate" id="gpDRate" class="form-control" min="0" max="100" placeholder="% 단위"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">할인된 가격(판매가)</td>
                    <td><input type="number" name="gpDPrice" class="form-control" min="0" placeholder="원 단위로 입력해주세요"></td>
                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange">옵션</td>
                    <td>
                        <input type="text" name="option" class="form-control" id="option-add">
                        <select name="selectArea1" id="selectArea1" style="width: 300px;"> 
                        </select>
                    </td>
                    <td>
                        <button type="button" id="add1" class="btn btn-warning btn-sm">추가</button>
                    </td>
                </tr>

                <script>

                    $(function(){

                        $("#add1").click(function(){

                            // 사용자가 입력한 값
                            var optAdd = $("#option-add").val();

                            if(optAdd != ""){
                                // hidden타입으로 input생성하고 입력값 담기
                                var a = document.createElement("input");
                                a.setAttribute("value", optAdd);
                                a.setAttribute("type", "hidden");
                                a.setAttribute("name", "option");

                                // select안에 value없는 option들 추가하기 (단지 시각용)
                                $("#selectArea1").append("<option>" + optAdd + "</option>");
                                
                                $("#insertForm").append(a);
                            }else{
                                alert("아무것도 입력하지 않았습니다. 다시 입력해주세요");
                            }
                        });

                    });
                </script>


                <tr>
                    <td class="textOrange"> <br> 주소입력</td>
                    <td> <br>
                   	     서울특별시 &nbsp; &nbsp;
                        
                        <select name="gu" id="gu">

                            <option value="">구 선택</option>

                            <option name="gu" value="gs">강서구</option>

                            <option name="gu" value="sp">송파구</option>

                        </select>

                        <select name="dong" id="dong">
                            <option value="">동 선택</option>
                        </select>

                        <script type="text/javascript">

                            $(function() {

                                $('#gu').change(function() {

                                    var gs = ["화곡동", "목동"];

                                    var sp = ["오류동", "오금동", "상일동"];

                                    var changeItem;

                                	if (this.value == "gs") {

                                        changeItem = gs;

                                    } else if (this.value == "sp") {

                                        changeItem = sp;
                                    }

                                    $('#dong').empty();

                                    for (var count = 0; count < changeItem.length; count++) {

                                        var option = $("<option name='dong'>" + changeItem[count] + "</option>");

                                        $('#dong').append(option);



                                    }

                                });

                            });

                        </script>


                    <td></td>
                </tr>
                <tr>
                    <td class="textOrange"> <br> 카테고리 선택</td>
                    <td> <br>
                        <select id="category" name="category">
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
                    <td class="textOrange"><br> 상세 설명 첨부</td>
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
                    <td class="textOrange"><br> 입금계좌</td>
                    <td>
                        <input type="text" class="form-control" id="account-add" >
                        <select name="selectArea2" id="selectArea2" style="width: 300px;">
                            
                        </select>
                    </td>
                    <td><button type="button" id="add2" class="btn btn-warning btn-sm">추가</button>
                    </td>
                 
                </tr>

                <script>

                    $(function(){

                        $("#add2").click(function(){

                            // 사용자가 입력한 값
                            var accAdd = $("#account-add").val();
                            if(accAdd != ""){
                                // hidden타입으로 input생성하고 입력값 담기
                                var a = document.createElement("input");
                                a.setAttribute("value", accAdd);
                                a.setAttribute("type", "hidden");
                                a.setAttribute("name", "account");

                                // select안에 value없는 option들 추가하기 (단지 시각용)
                                $("#selectArea2").append("<option>" + accAdd + "</option>");
                                
                                $("#insertForm").append(a);
                            }else{
                                alert("아무것도 입력하지 않았습니다. 다시 입력해주세요")
                            }
                        });

                    });

                </script>



                
                </tr>

                <tr>
                    <td class="textOrange"><br> 교환 및 환불 방법</td>
                    <td><br><textarea class="form-control" cols="5" rows="5" id="comment" name="refund" style="resize: none;"></textarea></td>
                    <td></td>
                </tr>
            </table>

            <br><br><br><br>
            <div align="center">
                <button id="backbtn" type="button" class="btn btn-secondary btn-sm">뒤로가기</button>
                <button type="submit" class="btn btn-warning btn-sm">등록하기</button>
                <button type="reset" class="btn btn-danger btn-sm">초기화하기</button>
            </div>
            
            
            <script type="text/javascript">
				
				$(document).ready(function(){
				
					$("#backbtn").click(function(){
						window.history.back();
					});
				});

			</script>
			

        </form>

    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br>
    
    
    <%@ include file ="../common/footerbar.jsp" %>
</body>
</html>