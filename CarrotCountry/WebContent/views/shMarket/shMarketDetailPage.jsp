<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
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
.user_info_display_sectionWrapper {margin-left: 50px;}
.user_info_display_sectionWrapper div {
    display: flex;
    align-items: center;
}
.MainLogo_Wrapper {
    display: flex;
    align-items: center;
}
.MainLogo_Wrapper>div i {font-size: 2rem;}
.menu_bar {margin-right: 50px;}
.menu_bar>table tr td a {color: white}
.user_inter_font {font-size: 0.7rem;}
.menu_bar table tr td {padding-left: 10px;}
.outer {
    width: 800px;
    margin:auto;
    border:2px solid rgb(255, 166, 0);
    border-radius: 15px;
    box-shadow: 3px 3px 0.5px 0.5px rgb(255, 189, 35);
    background-color: whitesmoke;
}
.carousel-item.active > img {
    border-radius: 10px;
}
.userInfo_display {
    height:75px;
    width:100%;
    background-color: aliceblue;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding:0px 30px 0px 30px;
}
/* like 버튼 CSS */
.like_button{
   cursor: pointer;
   background-color: green;
}
.like_button:active {
    background-color:red;
}
.like_button > i {
    color:orange;
    font-size: larger;
}
.like_button:active , i:active {
    font-size:1.5rem;
    color:white;
}
.userContent {
    text-align: center;
    min-height: 200px;
}
/* Comment CSS 구간. */
.comment_display {
    width:750px;
    
    margin: auto;
    display: flex;
    padding-left: 26px;
    margin-top: 10px;
}
.comment_content {
    min-height: 100px;
    width:81.8%;
    background-color: white;
    padding:0px 10px 0px 10px;
}
.comment_control_button {
    display:flex;
    justify-content: space-between;
}
.left_date {
    font-size: 1rem;
    color:darkgray;
}
.comment_user_info {margin:0px;}
.right_icons > i {
    font-size: 1.5rem;
    margin-left: 15px;
}
.comment_condition {
    display: flex;
    align-items: center;
}
.comment_condition > i {
    font-size:1.5rem;
    margin-left: 10px;
}

.comment_textarea {min-height: 50px;}
.navbar.navbar-8 .navbar-toggler-icon {background-image: url('https://mdbootstrap.com/img/svg/hamburger4.svg?color=1729B0');}
.nav-item {
    border-radius: 5px;
    background-color: whitesmoke;
}
.nav-link {color:black;}
</style>
</head>
<body>
  <!-- ↓ 토글버튼. + 신고버튼 부모 div ↓ -->
  
  <%@ include file="../common/commonNavbar.jsp"%>
  
    <div class="button_wrapper" 
         style="width:1000px;
                max-height: 0px;
                margin:auto;            
                " >
        <nav class="navbar navbar-light navbar-8 white"
             style="display: inline-flex;
                    position: relative;
                    top:26px;
                    left:888px;
                    z-index: 1;">

            <button class="navbar-toggler" 
                    type="button" 
                    data-toggle="collapse" 
                    data-target="#navbarSupportedContent15"
                    aria-controls="navbarSupportedContent15" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation"
                    style="border:2px solid orange;">
            <span class="navbar-toggler-icon"></span></button>
          
           
            <div class="collapse navbar-collapse" id="navbarSupportedContent15"  >
 
              <ul class="navbar-nav mr-auto" >
                <li class="nav-item active" style="background-color: orange;">
                  <a class="nav-link" href="#">게시글 수정 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item" style="background-color: rgb(219, 91, 91);">
                  <a class="nav-link" href="#">게시글 삭제</a>
                </li>
                <li class="nav-item" style="background-color:lightskyblue;">
                  <a class="nav-link" href="#">판매완료</a>
                </li>
                <li class="nav-item" style="background-color: lightgray; ">
                    <a class="nav-link" href="#">끌어올리기</a>
                  </li>
              </ul>
            </div>
          </nav>
          <!-- 신고버튼 -->
         
    </div>
    <div class="outer">
        <i  
        class="fas fa-exclamation-triangle" 
        data-toggle="modal" 
        data-target="#myModal"
        style="position: relative;
        left:750px;
        top:40px;
        z-index: 3;
        font-size: 2rem;
        color:rgb(255, 55, 55);
       ">
     </i>
        <!-- ↓ 사진 코드. ↓ -->
     <div class="image_section" style="width:100%; ">
         <div id="carouselExampleIndicators" 
              class="carousel slide" 
              data-ride="carousel" 
              style="height: 600px; 
                   width:100%;
                   margin:auto;
                   ">
             <ol class="carousel-indicators">
                 <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                 <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                 <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
             </ol>
             <div class="carousel-inner">
                 <div class="carousel-item active">
                     <img class="d-block w-100" src="../Common/images/20190220_205501.jpg">
                 </div>
             </div>
             <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                 <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                 <span class="sr-only">Previous</span>
             </a>
             <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                 <span class="carousel-control-next-icon" aria-hidden="true"></span>
                 <span class="sr-only">Next</span>
             </a>
         </div>
     </div>

     <!-- ↓ 유저 정보및 가격 ↓ -->
     <div class="userInfo_display">
         <div class="left_section" 
            style="width:30%; 
            height:80%;display: flex; 
            align-content: center;">
             <div class="user_icon" ><i class="fas fa-user" style="font-size: 3.5rem; margin-right: 15px;"></i></div>
             <div class="user_info_text">
                <h4 style="margin-bottom: 0px; margin-top: 5px;">판매자XX</h4>
                <p style="margin-top: 0px;">주소XXX</p>
             </div>
         </div>
         <div class="right_price" 
              style="font-size: 1.5rem; 
              font-weight: bold;">가격:15000</div>
     </div>
     
     <!-- ↓ 본문 제목 ↓ -->
     <div class="title_section">
         <h4 align="center">
             XXXX제목XXXX
         </h4>
         <p align="center" style="font-size:small;">XXX카테고리XXXX</p>
         <hr style="border-bottom: 2px solid gray;"> 
     </div>
     
     <!-- ↓ 본문 내용 ↓ -->  
     <div class="userContent">He as compliment unreserved projecting. Between had observe pretend delight for
          believe. Do newspaper questions consulted sweetness do. Our sportsman his unwilling fulfilled departure law.
          Now world own total saved above her cause table. Wicket myself her square remark the should far secure sex.
          Smiling cousins warrant law explain for whether.

          No depending be convinced in unfeeling he. Excellence she unaffected and too sentiments her. Rooms he doors
          there ye aware in by shall. Education remainder in so cordially. His remainder and own dejection daughters
          sportsmen. Is easy took he shed to kind.
          </div>
    
          <!-- ↓ 조회수 + 찜버튼 ↓ -->   
     <div class="view_counter_wrapper" style="display: flex; 
          justify-content: space-between; 
          align-items: center;
          padding:0px 30px 0px 30px;">
         <div class="view_counter_display" style="color:darkgray">
             조회:xx 찜:xx
         </div>
    
         <div class="like_button" style="width:40px; 
                     height:40px; 
                     display: flex; 
                     justify-content: center; 
                     align-items: center;
                     border-radius: 5px;
                     "
                     >
             <i class="fas fa-heart">      
             </i>
         </div>
     </div>
     <hr style="border-bottom: 2px solid gray;"> 
     <!-- ↓ 댓글 입력 구간↓ --> 
     <div class="comment_area" style="width:100%;">
         <form action="#" style="display:flex; 
                                 justify-content: center;">
            <input type="text" 
                   class="form-control" 
                   name="userComment" 
                   id="exampleInputPassword1" 
                   placeholder="댓글을 입력해주세요"
                   style="width:500px;
                          ">
            <button type="button" 
                    class="btn btn-warning" 
                    id="insert_comment"
                    style="font-weight: bold;
                    ">댓글입력</button>
                    <div class="comment_check_wrapper" style="
                    height:40px; 
                    width:40px; 
                    margin-left: 10px; 
                    ">
                    <p style="font-size: 0.4rem; 
                              margin:3px 0px 0px 0px;
                              font-weight: bold;"> 비공개</p>
                    <input type="checkbox" name="comment_condition" style="margin-left: 10px;" value="Y">
                    </div>
         </form>

          <!-- ↓ 댓글 출력 구간↓ -->
         <div id="comment_display_outer">
         <div class="comment_display">
             <div class="comment_icon"><i class="fas fa-user" style="font-size: 2rem;"></i></div>
             <div class="comment_content">
                 <p class="comment_user_info">[작성자닉네임][주소] </p>
                 <div class="comment_textarea"></div>
                 <!-- ↓ 코멘트 버튼  div if 문 달아야함 나중에 ↓ -->
                 <div class="comment_control_button">
                     <div class="left_date">업로드 날짜</div>
                     <div class="right_icons">
                         <i class="fas fa-pen" title="댓글 수정"></i>
                         <i class="fas fa-trash" title="댓글 삭제"></i>
                         <i class="fas fa-exclamation" title="댓글 신고"></i>
                     </div>
                 </div>
             </div>
             <div class="comment_condition"><i class="fas fa-lock"></i></div>
         </div>   
        </div>            
     </div>
     <br>
     </div>
     <!-- 신고 버튼 모달 -->

       <!-- The Modal -->
       
       <div class="modal" id="myModal">
           
        <div class="modal-dialog">
          <div class="modal-content">
            <form action="">
            <!-- Modal Header -->
            <div class="modal-header">
              <h4 class="modal-title">유저신고</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
      
            <!-- Modal body -->
            <div class="modal-body">
              <label for="">신고유형:</label>
              <select name="report_type" id="" style="border:1px solid black; border-radius: 3px;">
                  <option value="사기">사기</option>
              </select>
              <br><br>
              <label for="">신고 사유</label>
              <br><textarea name="" id="" cols="64" rows="10" style="resize: none; border:1px solid black; border-radius: 3px;"></textarea>
            </div>
      
            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="button" class="btn btn-danger" data-dismiss="modal">신고하기</button>
            </div>
            </form>
          </div>
        </div>
    
      </div>
<%@ include file="../common/footerbar.jsp"%>
</body>
</html>