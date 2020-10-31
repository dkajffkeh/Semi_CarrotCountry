<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.wrap{width:1200px;height:1250px;margin:auto; }

/* 전반적인 큰 틀 (3개의 영역) */
#header{height:20%;}
#content{height:80%;}
#footer{height:100%; margin:10px 0px;}

/* 헤더영역의 전반적인 틀 */
#header>div{width:100%;  float: left;}
#header1{height:30%;}
#header2{height:40%;}
#header3{height:30%;}

/* 헤더영역의 세부적인 틀 */
#header1>h1{padding: 10px;}
#header2>div{height: 100%; float: left;}
#header2_1{width: 30%;}
#header2_2{width: 40%;}
#searchForm{
    width:300px;
    height:30px;
    margin:auto; 
    margin-top: 60px;
    border: 1px solid lightgrey;
}
#header2_3{width: 30%;}
#createPro>button{
    float:right;
    margin:25px;
}

/* 검색창 추가적인 스타일 */
#searchForm>*{height:100%; float:left;}
#searchForm>input{width:80%;}
#searchForm>button{width:20%}

/* 콘텐트영역의 전반적인 틀 */
#content>div{height: 100%; float: left;}
#content1{width: 20%;}
#content2{width: 80%}


/* 콘텐트영역의 세부적인 틀 */
#content2>div{width: 100%;}
#array{
    height: 10%;
    text-align: right;
    padding-top: 40px;
}
#proTitle{height:10%}
#proContent{height: 70%;}
#paginationArea{height: 10%;}
#proTitle>div{height: 100%; float: left;}
#proTitle{padding: 20px;}
#regionText{width: 80%; padding-left: 20px;}
#regionButton{width: 20%;}

/* 페이징 */
#paginationArea>ul{
    padding-top: 50px;
    padding-left: 400px;

}
#proContent>*{width: 100%; float: left;}
#proName{height: 20%;}
#proName>div{
    height: 100%; 
    float: left;
    border-bottom: 1px solid black;
}
#proImg{
    width: 20%;
    padding: 5px;
    display: inline-block;
    padding-left: 50px;
}
#proText{width: 50%;}
#proPrice{width: 30%;}
#proText-title{padding: 15px; padding-bottom: 0px;}
#proText-like{padding: 15px;}
#proText-title>a{text-decoration: none; color: black;}
#proPrice{
    text-align: right;
    padding: 10px;
}
#realPrice{
    color: gray; 
    padding: 10px; 
}
#discount{
    color: red;
    font-size: 20px;
    font-weight: 700;
    padding: 10px;
}
#discountPrice{
    color: black;
    font-size: 20px;
    font-weight: 600;
}



/* 카테고리영역 */
#content1 ul{list-style: none;}
#content1 ul li{
    height: 58px;
    background: #3f3f3f;
    padding: 5px 10px;
    border-bottom: 1px solid black;
    text-align: center;
    padding-top: 15px;
}
#content1 ul li:hover{
    background: lightgray;

}
#content1 ul li a{
    text-decoration: none;
    color: white;
    margin: auto;
    margin-top: 10%;
}

/* 정렬 */
#array a{
    text-decoration: none;
    color: black;
}


/* 푸터바의 전반적인 틀 */
#footerbar {
    position: absolute;
    top: 100%;
    width: 100%;
    height: 270px;
    background-color: #00251a
}

.footerbar_totalWrapper {
    width: 1200px;
    height: 100%;
    border-bottom: 1px solid white;
    margin: auto;
}

.footer_upperWrapper {
    width: 100%;
    height: 52px;
    border-bottom: 1px solid white;
    display: flex;
    justify-content: center;
    align-items: center;
}

.footer_upperWrapper>button {
    margin-left: 40px;
}

.footer_belowWrapper {
    height: 200px;
    display: flex;
    justify-content: center;
    align-items: center;
}


</style>

</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>


    <div class="wrap">
        <div id="header">
            <div id="header1" align="center">
                    <h1><b>우리동네 공동구매</b></h1>
                    <hr style="border-bottom: 2px solid grey; border-top: none;">
            </div>
            <div id="header2">
                <div id="header2_1"></div>
                <div id="header2_2">
                    <form action="" id="searchForm">
                        <input type="search" name="keyword">
                        <button type="submit">검색</button>
                    </form>
                </div>
               
                <div id="header2_3"></div>
     
            </div>
            <div id="header3">
                <div id="createPro">
                    <button type="button" class="btn btn-secondary">새 공동구매 만들기</button>
                </div>
                <br><br>
                <hr style="border-bottom: 2px solid grey; border-top: none;">
            </div>
        </div>
        <div id="content">
            
            <!--카테고리-->
            <div id="content1">
                
                <ul>
                    <li><a href="">디지털/가전</a></li>
                    <li><a href="">가구/인테리어</a></li>
                    <li><a href="">유아동/유아도서</a></li>
                    <li><a href="">생활/가공식품</a></li>
                    <li><a href="">스포츠/레저</a></li>
                    <li><a href="">여성잡화</a></li>
                    <li><a href="">여성의류</a></li>
                    <li><a href="">남성패션/잡화</a></li>
                    <li><a href="">게임/취미</a></li>
                    <li><a href="">뷰티/미용</a></li>
                    <li><a href="">반려동물용품</a></li>
                    <li><a href="">도서/티켓/음반</a></li>
                    <li><a href="">기타물품</a></li>
                </ul>
                
               
            
            </div>
            <div id="content2">
                <div id="array">
                    <a href="">최신순 |</a>
                    <a href="">낮은가격 |</a>
                    <a href="">인기상품 |</a>
                    <a href="">조회순</a>
                </div>
                <hr style="border-bottom: 2px solid grey; border-top: none;">
                <div id="proTitle">
                    <div id="regionText">
                        <b>xx시 xx동의 공동구매</b>
                    </div>
                    <div id="regionButton">
                        <button type="button" class="btn btn-secondary btn-sm">지역선택</button>
                        <button type="button" class="btn btn-secondary btn-sm">동네선택</button>
                    </div>
                   
                </div>
                <div id="proContent">
                    <div id="proName">
                        <div id="proImg">
                            <a href=""><img src="../Common/images/무선청소기1.jpg" alt="" width="100" height="100"></a>
                        </div>
                        <div id="proText">
                            <div id="proText-title">
                                <a href=""><h4>[4차 공구] 우아우아앙무선청소기</h4></a>
                            </div>
                            <div id="proText-like">
                                <h6>현재 인원 11명 | ♡ (22)</h6> 
                            </div>
                        </div>
                        <div id="proPrice">
                            <h6 id="realPrice"><s>원래가격</s></h6>
                            <span id="discount">공구할인률 nn%</span>
                            <span id="discountPrice">100000원</span>
                        </div>
                    </div>

                    <div id="proName">
                        <div id="proImg">
                            <a href=""><img src="../Common/images/무선청소기1.jpg" alt="" width="100" height="100"></a>
                        </div>
                        <div id="proText">
                            <div id="proText-title">
                                <a href=""><h4>[4차 공구] 우아우아앙무선청소기</h4></a>
                            </div>
                            <div id="proText-like">
                                <h6>현재 인원 11명 | ♡ (22)</h6> 
                            </div>
                        </div>
                        <div id="proPrice">
                            <h6 id="realPrice"><s>원래가격</s></h6>
                            <span id="discount">공구할인률 nn%</span>
                            <span id="discountPrice">100000원</span>
                        </div>
                    </div>

                    <div id="proName">
                        <div id="proImg">
                            <a href=""><img src="../Common/images/무선청소기1.jpg" alt="" width="100" height="100"></a>
                        </div>
                        <div id="proText">
                            <div id="proText-title">
                                <a href=""><h4>[4차 공구] 우아우아앙무선청소기</h4></a>
                            </div>
                            <div id="proText-like">
                                <h6>현재 인원 11명 | ♡ (22)</h6> 
                            </div>
                        </div>
                        <div id="proPrice">
                            <h6 id="realPrice"><s>원래가격</s></h6>
                            <span id="discount">공구할인률 nn%</span>
                            <span id="discountPrice">100000원</span>
                        </div>
                    </div>

                    <div id="proName">
                        <div id="proImg">
                            <a href=""><img src="../Common/images/무선청소기1.jpg" alt="" width="100" height="100"></a>
                        </div>
                        <div id="proText">
                            <div id="proText-title">
                                <a href=""><h4>[4차 공구] 우아우아앙무선청소기</h4></a>
                            </div>
                            <div id="proText-like">
                                <h6>현재 인원 11명 | ♡ (22)</h6> 
                            </div>
                        </div>
                        <div id="proPrice">
                            <h6 id="realPrice"><s>원래가격</s></h6>
                            <span id="discount">공구할인률 nn%</span>
                            <span id="discountPrice">100000원</span>
                        </div>
                    </div>

                    <div id="paginationArea">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                          </ul>    
                    </div>
                   

                </div>

            </div>
        </div>

    </div>
    
    <footer id="footerbar">
        <div class=footerbar_totalWrapper>
            <div class="footer_upperWrapper">
                <button class="btn btn-secondary">공지사항</button>
                <button class="btn btn-secondary">고객센터</button>
                <button class="btn btn-secondary">개인정보 취급방침</button>
                <button class="btn btn-secondary">회사소개</button>
            </div>
            <div class="footer_belowWrapper">
                <p style="color:white">footer</p>
            </div>
        </div>

    </footer>


</body>
</html>