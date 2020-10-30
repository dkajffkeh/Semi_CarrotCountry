<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/common/mainMenu.css">
    <title>CarrotCountry</title>
</head>
<body>
  <%@ include file="views/common/commonNavbar.jsp" %>
  
   <!-- =============================== 인기 게시물 썸내일 사진 display  ======================= -->
    <div class="banner_Wrapper">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="" alt="First slide" >
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div id="carouselExampleControls1" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="" alt="First slide" >
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls1" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls1" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
    </div>
    <!-- <i class="fas fa-ellipsis-h"></i> -->
    <!-- =============================== 인기 게시물 썸내일 사진 display  ======================= -->

    <!-- =============================== 중고게시판 공동구매 게시판 버튼  ======================= -->

    <div class="board_button_wrapper">
    <button type="button" class="btn btn-outline-warning" id="townMarket_button">동네마켓</button>
    <script>
    
    let town_btn0 = document.getElementById("townMarket_button");
    
    town_btn0.addEventListener('click',toTown);
  
    function toTown(){
    	
    	
        location.href="<%=contextPath%>/shMarketBoardMain.sh";
	
    }
    </script>
    <button type="button" class="btn btn-outline-success">공구마켓</button>
    </div>
    

    <!-- =============================== 중고게시판 공동구매 게시판 버튼  ======================= -->
    <hr>
    <h2 align="center" style="margin-top: 15px; font-weight: bold;">인기 매물</h2>

    <!-- =============================== 인기 게시글 섹션  ======================= -->

    <div id="top8_board_wrapper" style="margin-bottom:100px;">
        <div class="top8_board_floor">
          <div class="product_display_wrapper">
             <div class="img_wraper"><img src="" alt="" style="width:100%; height:100%; border-radius: 10px;" ></div>
             <div class="product_title"><h5 class="popular_board_title">제목</h5></div>
             <div class="location_area">서울시 송파구</div>
             <div class="ratring_counter">
                 <p>조회수:xx 찜:xx</p>
             </div>
             <div class="price_display">30000</div>
          </div>
       
        </div>
        <div class="top8_board_floor">
                <div class="product_display_wrapper">
             <div class="img_wraper"><img src="" alt="" style="width:100%; height:100%; border-radius: 10px;" ></div>
             <div class="product_title"><h5 class="popular_board_title">제목</h5></div>
             <div class="location_area">서울시 송파구</div>
             <div class="ratring_counter">
                 <p>조회수:xx 찜:xx</p>
             </div>
             <div class="price_display">30000</div>
            </div>
        </div>
        <div  align="center"><a class="bottom_font" style="cursor:pointer;" id="townMarket_button1">매물 더 보기</a></div>
        <script>
        let town_btn1 = document.getElementById("townMarket_button1");
        town_btn1.addEventListener('click',toTown1);
     
        function toTown1(){
  
            location.href="<%=contextPath%>/shMarketBoardMain.sh";
        }
        </script>
          

        
</div>
  <%@ include file="views/common/footerbar.jsp" %>
  
</body>
</html>