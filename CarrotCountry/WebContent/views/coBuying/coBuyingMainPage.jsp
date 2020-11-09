<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="java.util.ArrayList
			   , com.javachip.carrotcountry.coBuying.model.vo.*
			   , com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.*
			   ,  com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*"
 %>    

<%
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<CategoryHY> cList = (ArrayList<CategoryHY>)request.getAttribute("cList");
	PostBoard pb = (PostBoard)request.getAttribute("pb");	
	String alertMsg = (String)session.getAttribute("alertMsg");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<style>

.wrap{width:1200px;height:1250px;margin:auto; font-family: 'Nanum Gothic', sans-serif;  }

/* 전반적인 큰 틀 (3개의 영역) */
#header{height:20%;}
#content{height:70%;}
.paginationArea{height:10%}

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
#proName:hover{cursor:pointer;}
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
    font-family: 'Nanum Gothic', sans-serif;
}

/* 정렬 */
#array a{
    text-decoration: none;
    color: black;
}


#emptyDiv{
	height:500px;
	padding:100px
}
#emptyDiv>h4{color:orange; font-weight:800;}


</style>

</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>



	<% if(alertMsg != null){ %>
		<script>
			alert("<%= alertMsg %>");	
		</script>
		
		<%
			session.removeAttribute("alertMsg");
		%>
	<%} %>




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
                        <button class="btn btn-warning btn-sm"><i class="fas fa-carrot"></i></button>
                    </form>
                </div>
               
                <div id="header2_3"></div>
     
            </div>
            <div id="header3">
            
            
                <div id="createPro">
                    <button id="enrollPro"  type="button" class="btn btn-warning">새 공동구매 만들기</button>
                </div>
                
                
                <script>
                
                $("#enrollPro").click(function(){
                	<%if(loginMember == null){%>
	        			var result = confirm("로그인 한 회원만 이용할 수 있는 서비스 입니다. 로그인하시겠습니까?");
	        			if(result){
	        				location.href = "<%= contextPath %>/loginPage.me.ng";
	        			}else{
	        				location.href = "<%= contextPath %>/mainpage.co.jy?currentPage=1";
	        			}
                	<%}else{%>
                		location.href = "<%= contextPath %>/enroll.pro.jy";
                	<%}%>
                	
                	
                });
                </script>
                
                
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
                
                
                <% if(pList.isEmpty()){ %>
                	<div id="emptyDiv" align="center"><h4>진행중인 공동구매가 없습니다 !</h4></div>
                <%}else{ %>
	                  <% for(Product pd : pList) {%>
	                    <div id="proName">
	                    	<input type="hidden" value="<%= pd.getPostNo() %>">
	                        <div id="proImg">
	                            <a href=""><img src="<%= contextPath %>/<%= pd.getThumbnailLoadpath() %>" width="100" height="100"></a>
	                        </div>
	                        <div id="proText">
	                            <div id="proText-title">
	                                <a href=""><h4><%= pd.getPostName() %></h4></a>
	                            </div>
	                            <div id="proText-like">
	                                <h6><%= pd.getGpPeople() %> | ♡ (<%= pd.getPostLikes() %>)</h6> 
	                            </div>
	                        </div>
	                        <div id="proPrice">
	                            <h6 id="realPrice"><s><%= pd.getGpPrice() %></s></h6>
	                            <span id="discount">공구할인률<%= pd.getGpDRate() %>%</span>
	                            <span id="discountPrice"><%= pd.getGpDPrice() %>원</span>
	                        </div>
	                    </div>
	                    <%} %>
		           <%} %>    
                
		        <script>
		        	$(function(){
		        		$("#proName").click(function(){
		        			
		        		 	<%if(loginMember == null){%>
		        			var result = confirm("로그인 한 회원만 열람 가능합니다. 로그인하시겠습니까?");
		        			if(result){
		        				location.href = "<%= contextPath %>/loginPage.me.ng";
		        			}else{
		        				location.href = "<%= contextPath %>/mainpage.co.jy?currentPage=1";
		        			}
	                	<%}else{%>
	                		location.href = "<%= contextPath %>/buyerdetail.pro.jy?bno=" + $(this).children().eq(0).val();
	                	<%}%>
		        			
		        		})
		        	});
		        	
		        </script>
		                    

                </div>

            </div>
        </div>

		 <div class="paginationArea" align="center">

				<% if(pi.getCurrentPage() != 1){ %>
		          		 <a href="<%= contextPath %>/mainpage.co.jy?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
		           <% } %>
				<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
		           	
		           	<a href="<%= contextPath %>/mainpage.co.jy?currentPage=<%= p %>"><%= p %></a>
	           
	            <% } %>
	           
	            <%if(pi.getCurrentPage() != pi.getMaxPage()){ %>
	          		 <a href="<%= contextPath %>/mainpage.co.jy?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt; </a>
	            <% } %>
     		</div>
                


    </div>
    
<%@ include file="../common/footerbar.jsp" %>


</body>
</html>