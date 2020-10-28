<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/shMarketBoardcss/shTownMarketBoardMain.css">
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
</head>
<body>

<%@ include file="../common/commonNavbar.jsp"%>

<!-- 제목 -->
    <h1 align="center" style="margin-top: 25px; font-weight: bold;">우리동네 마켓</h1>
    <hr style="border-bottom: 2px solid grey;">

    <!-- 검색 구간 -->
    <section class="search-sec">
        <div class="container">
            <form action="#" method="post" novalidate="novalidate">

                <div class="col-lg-12">
                    <div class="row">
                        <div class="section_contatiner">
                            <input type="text" class="form-control search-slt" placeholder="제목 또는 제품명을 검색해주세요"
                                style="width: 400px; margin-right: 6px;">

                            <select class="form-control search-slt" style="width:150px; margin-right: 6px;">
                                <option selected value="서울시">서울시</option>
                                <option>Example one</option>
                            </select>
                            <select class="form-control search-slt" style="width:150px; margin-right: 6px;">
                                <option selected value="송파구">송파구</option>
                                <option>Example one</option>
                            </select>
                            <select class="form-control search-slt" style="width:150px; margin-right: 6px;">
                                <option selected value="생활 가전">생활 가전</option>
                                <option>Example one</option>
                            </select>
                            <button type="button" class="btn btn-warning wrn-btn"><i class="fas fa-carrot"></i></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <!-- 검색 구간 -->

    <!-- 정렬 구현 구간 -->
    <div id="sorter_wrapper">
        <div class="sorter_row">
            <p>최신순 </p>
            <p>낮은가격 </p>
            <p>인기상품 </p>
            <p>조회수</p>
        </div>
    </div>

    <hr style="border-bottom: 2px solid grey; margin-top: 2px;">

    <!-- 정렬 구현 구간 -->

    <!-- main 아티클 구간 -->

    <div class="location_display">XX구 XX동</div>


    <div id="mainArticle_wrapper">

        <div class="mainArticle_sidebar">
            <div>
                <div class="side_bar font">
                    XXXX
                </div>
            </div>
       
        </div>

        <div class="mainArticle_article">
            <div class="article_frame">
                <div class="img_frame"><img src="../Common/images/20190220_194753.jpg" alt=""></div>
                <div class="product_title">
                    <h6 class="popular_board_title">똠양꿈 팝니다!!</h6>
                </div>
                <div class="location_area">XXX XXX</div>
                <div class="ratring_counter">
                    <p>조회수:xx 찜:xx</p>
                </div>
                <div class="price_display">1,400,000</div>
            </div>
          
        </div>
        
     </div>
    
     <div class="page_display" style="margin-bottom:25px; margin-top: 10px;">
        <div style="width:100px"><!-- 간격 유지용 div --></div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                  <span class="sr-only">Previous</span>
                </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
             
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                  <span class="sr-only">Next</span>
                </a>
              </li>
            </ul>
          </nav>
          <button type="button" class="btn btn-warning">게시글 올리기</button>
     </div>
      <!-- main 아티클 구간 -->


<%@ include file="../common/footerbar.jsp"%>

</body>
</html>