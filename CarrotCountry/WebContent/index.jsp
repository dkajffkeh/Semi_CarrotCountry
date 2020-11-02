<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/common/mainMenu.css">
    <title>CarrotCountry</title>
    <style>
#top8_board_wrapper {
    width:1200px;
    height:750px;
    margin:auto;
    margin-top: 15px;
    margin-bottom: 15px;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}
#top8_board_wrapper > .product_display_wrapper{
    width:23%;
    height:50%;
    float: left;
    box-sizing: border-box; 
}
.product_display_wrapper > div {margin-bottom: 5px;}
    </style>
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
    	
    	<%if(loginMember!=null){%>
        location.href="<%=contextPath%>/shMarketBoardMain.sh?currentPage=1";
		<%} else {%>
		location.href="<%=contextPath%>/shMarketBoardMain.sh";
		<%}%>
    }
    </script>
    <button type="button" class="btn btn-outline-success" id="coBuying_button">공구마켓</button>
    
       
    <script>
    
    let coBuying_btn0 = document.getElementById("coBuying_button");
    
    coBuying_btn0.addEventListener('click',toCoBuying);
  
    function toCoBuying(){
 
        location.href="<%=contextPath%>/mainpage.co.jy";
	
    }
    </script>

    </div>
    

    <!-- =============================== 중고게시판 공동구매 게시판 버튼  ======================= -->
    <hr>
    <h2 align="center" style="margin-top: 15px; font-weight: bold;">인기 매물</h2>

    <!-- =============================== 인기 게시글 섹션  ======================= -->
      <div id="top8_board_wrapper">
            <div class="product_display_wrapper"
                 style="width:23%;
                        height:50%;
                        float: left;">
             <div class="img_wraper" 
             style="width:100%; 
             height:60%;">
             <img src="../Common/images/1.jpg" alt="" style="border-radius: 5px;" >
            </div>
             <div class="product_title"
                  style="font-size: 1.3rem;">XXX</div>
             <div class="location_area">XXX XXX</div>
             <div class="ratring_counter">
                 <p style="font-size: small; color:darkgray">조회수:xx 찜:xx</p>
             </div>
             <div class="price_display" style="float:right; color:orange; font-size: 1.5rem;">30000</div>
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