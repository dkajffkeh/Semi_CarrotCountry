<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY" %>
<!DOCTYPE html>
<%
ArrayList<CategoryHY> list = (ArrayList)request.getAttribute("list");

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
    <style type="text/css">
        a {
            text-decoration: none
        }

        a:link {
            color: black;
            text-decoration: none;
        }

        a:visited {
            color: black;
            text-decoration: none;
        }

        a:hover {
            color: black;
            text-decoration: none;
        }
    </style>
<style>
body {min-height: 100%;}
#page_total_wrapper {
    width:850px;
    height:100%;
    border:1px solid rgb(252, 255, 72);
    border-radius: 15px;
    padding-left: 15px;
    padding-top:15px;
    margin:auto;
    margin-top:20px;
    margin-bottom:20px;
    box-shadow: 3px 3px 2px 2px rgb(255, 189, 35);
}
input[name="Title"] {
    width:500px;
}
input[name="price"]{
    width:250px;
}
input[name="Title"]:hover {
    box-shadow: 0.5px 0.5px 2px 2px rgb(216, 216, 216);
}
select[class="form-control"] {
    width:150px;
    margin-right: 10px;
}
#form1>h5{
    margin-bottom: 10px;
    margin-top: 20px;
    font-weight: bold;
}
input[type="radio"]{
    margin-right: 6px;
}
#preview_frame {
    width:99%;
    height:200px;
    background-color: lightgray;
    display: flex;
    border-radius: 10px;
    padding:0px 5px 0px 10px;
    
}
#preview_frame>div{
    width:23%;
    height:100%;
    margin-right: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    cursor: pointer;
    border:2px solid orange;   
}
#preview_frame>.image_wrapper:hover{
border:2px solid green;
}

.image_wrapper>img {
    width:100%;
    height:100%;
    border-radius: 10px;
   
}
.submit_button_wrapper {
    width:96.5%;
    display: flex;
    justify-content: space-between;
}
.image_wrapper>i {
    position: relative;
    font-size: 1.5rem;
    right:32px;
    top:70px;
    cursor: pointer;
    color:white;
}
</style>
</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>

<div id="page_total_wrapper">
        <form action="shBoardEnrollForm.sh.hy" id="form1" enctype="multipart/form-data" method="post">
        <input type="hidden" value="<%=loginMember.getMemNo()%>">
        <input type="hidden" value="<%=loginMember.getMemNickname()%>">
            <h5>물품등록</h5>
            <hr>
            <div class="product_info_input" style="display: flex;">
                <input type="text" name="Title" class="form-control" placeholder="상품명을 입력해주세요"
                    style="margin-right: 5px;">
                <select name="Category" id="" class="form-control" style="color:gray">
                   		<% for(int i =0 ; i<list.size(); i++){ %>
						<option value="<%=10+10*i%>"><%=list.get(i).getCategoryName() %></option>
						<% } %>
                </select>
            </div>
            <h5>가격입력</h5>
            <div class="price_info_input" style="display: flex;">
                <input type="text" class="form-control" name="price" placeholder="가격을 넣어주세요" style="margin-right: 10px;">
                <h4 style="line-height: 180%;">원</h4>
            </div>
            <h5>상품상태</h5>
            <div class="product_condition_radio">
                <input type="radio" name="p_condition" value="미개봉" id="Pradio_1">
                <label for="Pradio_1">미개봉</label>
                <input type="radio" name="p_condition" value="거의 새것" id="Pradio_2">
                <label for="Pradio_2">거의 새것</label>
                <input type="radio" name="p_condition" value="사용감 있음" id="Pradio_3"> 
                <label for="Pradio_3">사용감
                    있음</label>
            </div>
            <h5>주소입력</h5>
            <div class="location_input" style="display: flex;">
                <select name="province" class="form-control">
                    <option value="서울특별시">서울특별시</option>
                </select>
                <select name="district" class="form-control">
                    <option value="송파구">송파구</option>
                    <option value="강서구">강서구</option>
                </select>
                <select name="town" class="form-control">
                    <option value="오금동">오금동</option>
                    <option value="오류동">오류동</option>
                    <option value="상일동">상일동</option>
                    <option value="화곡동">화곡동</option>
                    <option value="목동">목동</option>
                </select>
            </div>
            <h5>판매자 정보</h5>
            <div class="user_info" style="display: flex; margin-bottom: 30px; ">
                <h4 style="line-height: 100%; margin:2px; margin-right: 15px;">XXXX  XXXX</h4>
                <button type="button" class="btn btn-success btn-sm">본인인증</button>
            </div>
            <div id="preview_frame">
                <div class="image_wrapper">
                  <img src="" alt="" title="썸네일 업로드">
                </div>
                <div class="image_wrapper">
                    <img src="" alt="">
                </div>
                <div class="image_wrapper">
                  <img src="" alt="">
                </div>
                <div class="image_wrapper">
                  <img src="" alt="">
                </div>
                <div class="image_wrapper">
                  <img src="" alt="">
                </div>    
            </div>
            <div class="image_upload" style="margin-top:15px ;">
                    <input type="file" name="pictures1" id="thumnail_input" onchange="loadImg(this,1);" accept="image/*" required>
                    <input type="file" name="pictures2" id="file_input1" onchange="loadImg(this,2);" accept="image/*">
                    <input type="file" name="pictures3" id="file_input2" onchange="loadImg(this,3);" accept="image/*">
                    <input type="file" name="pictures4" id="file_input3" onchange="loadImg(this,4);" accept="image/*">
                    <input type="file" name="pictures5" id="file_input4" onchange="loadImg(this,5);" accept="image/*">
            </div>
            <div class="textarea_wrapper" style="margin: 30px 30px 10px 30px;">
            <textarea name="content" id="editor"></textarea>
        </div>
            <div class="submit_button_wrapper">
                <div></div>
                <button type="submit" form="form1" class="btn btn-success" style="margin-bottom:10px">게시글 올리기</button>
            </div>
        </form>
    </div>
    <script>
        ClassicEditor
            .create(document.querySelector( '#editor' ) , {
               
                removePlugins: ['ImageUpload']
            } )  
            .catch( error => {
                console.error( error );
            } );
    </script>
    <script>
            let pFrame = document.getElementById("preview_frame");
            
        for(let i = 1 ; i<=4; i++){
        $("#preview_frame").children().eq(i).css('display','none');
        }

        function loadImg(inputFile,num){
            if(inputFile.files.length==1){
               
               if(num<5){
                pFrame.children[num].style.display="flex";
               } else {
                pFrame.children[num-1].style.display="flex";   
               }
               
               let reader = new FileReader();

               reader.readAsDataURL(inputFile.files[0]);
               reader.onload = function(e){
                   switch(num){
                      case 1: pFrame.children[num-1].children[0].setAttribute('src',e.target.result); break;
                      case 2: pFrame.children[num-1].children[0].setAttribute('src',e.target.result); break; 
                      case 3: pFrame.children[num-1].children[0].setAttribute('src',e.target.result); break;
                      case 4: pFrame.children[num-1].children[0].setAttribute('src',e.target.result); break;
                      case 5: pFrame.children[num-1].children[0].setAttribute('src',e.target.result); break;  
                   }
               }
   	
            } else {
            	 switch(num){
                 case 1: pFrame.children[num-1].children[0].setAttribute('src',null); break;
                 case 2: pFrame.children[num-1].children[0].setAttribute('src',null); break; 
                 case 3: pFrame.children[num-1].children[0].setAttribute('src',null); break;
                 case 4: pFrame.children[num-1].children[0].setAttribute('src',null); break;
                 case 5: pFrame.children[num-1].children[0].setAttribute('src',null); break;  
              }
            } 
        }
        $(function(){
        	$(".image_upload").hide();
        	
            $("#preview_frame").children().eq(0).click(function(){
                $("#thumnail_input").click();     
            })
            $("#preview_frame").children().eq(1).click(function(){
                $("#file_input1").click();            
            })
            $("#preview_frame").children().eq(2).click(function(){
                $("#file_input2").click();
            })
            $("#preview_frame").children().eq(3).click(function(){
                $("#file_input3").click();
            })
            $("#preview_frame").children().eq(4).click(function(){
                $("#file_input4").click();
            })
        })

    </script>  
<%@ include file="../common/footerbar.jsp"%>
</body>
</html>