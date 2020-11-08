<%@page import="oracle.net.aso.a"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.javachip.carrotcountry.coBuying.model.vo.*
				, com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*
				, java.util.ArrayList
				, com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.* "
 %>    

<%
	Product pd = (Product)request.getAttribute("pd");
 	Account ac = (Account)request.getAttribute("ac");
	PostBoard pb = (PostBoard)request.getAttribute("pb");
	ArrayList<Option> oList = (ArrayList<Option>)request.getAttribute("oList");
	ArrayList<Account> aList = (ArrayList<Account>)request.getAttribute("aList");
	ArrayList<Photo> ptList = (ArrayList<Photo>)request.getAttribute("ptList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

        /* 전체 틀 */
       .wrap{width:1200px;height:2000px;margin:auto;}
       #content{height: 100%;}

       /* 콘텐트바의 전반적인 틀 */
       #content>div{width: 100%;}
       #content1{height: 5%;}
       #content2{height: 20%;}
       #content3{height: 75%;}

       /* 콘텐트바의 세부적인 틀 */
       #content1>h3{margin-top: 50px; padding: 20px;}
       #content2>*{height: 100%; float: left;}
       #content2_1{
           width: 40%; 
           padding: 30px;
           padding-top: 0px;
           padding-bottom: 50px;
           
        }
       #demo{width: 100%; height: 100%;}
       #demo>div{width: 100%; height: 100%;}
       .carousel-inner>img{width: 100%; height: 100%; margin: auto;} 
       #content2_2{
           width: 60%;
           display: inline-block;
           padding-left: 50px;
        }
       #content2_2>*{
           width: 100%;
           float: left;
        }
       #content2_2_1{
           height: 80%;
           display: inline-block;
           padding-left: 50px;
           padding-bottom: 10px;
        }
       #content2_2_2{height: 20%;}
       #content2_2_1 span{
            display: inline-block;
            padding-bottom: 10px;
            font-weight: 900;
            color: rgba(255, 123, 0, 0.986);
       }
       .progress{width: 300px;}

       #content2_2_2>div{
           height: 100%;
           width: 33.3%;
           float: left;
           padding-bottom: 10px;
       }
      /* #content2_2_2>div>button{
           width: 100px;
           display: block;
           margin: auto;
       }*/
       #content2_2_2>div>button:hover{
            background: rgb(139, 139, 139);
        }

       #content3>div{width: 100%; float: left;}
       #content3_1{height: 10%;}
       #content3_2{height: 90%;}
       #content3_1>div{
            height: 100%; 
            width: 25%; 
            float: left;
            display:block;
        }
         #showContent{
            padding-left:100px;
        }
        #content3_1>div>a{
        	color:white;
            width: 90%;
            display: block;
            margin: auto;
            border-radius: 15px;
            border-bottom-right-radius: 0px;
            border-bottom-left-radius: 0px;
        }
        #content3_1>div>a:hover{
            background: rgb(139, 139, 139);
        }
        
    
</style>

</head>
<body>

<%@ include file="../common/commonNavbar.jsp"%>
    <div class="wrap">
        <div id="content">
            <div id="content1">
                <h3><b><%= pb.getPostName() %></b></h3>
            </div>
            <div id="content2">
                <div id="content2_1">
                    <div id="demo" class="carousel slide" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators">
                          <li data-target="#demo" data-slide-to="0" class="active"></li>
                          <li data-target="#demo" data-slide-to="1"></li>
                          <li data-target="#demo" data-slide-to="2"></li>
                          <li data-target="#demo" data-slide-to="3"></li>
                          <li data-target="#demo" data-slide-to="4"></li>
                          <li data-target="#demo" data-slide-to="5"></li>
                        </ul>
                      
                        <!-- The slideshow -->
                        <div class="carousel-inner">
                          <div class="carousel-item active">
                            <img src="<%=contextPath%>/<%=pb.getThumbnailPath() + pb.getThumbnailFilename() %>" alt="" width="100%">
                          </div>
                          <%for(int i=0; i < ptList.size(); i++){ %>
                          <div class="carousel-item">
                            <img src="<%=contextPath%>/<%= ptList.get(i).getPhotoPath() + ptList.get(i).getPhotoFileName() %>" alt="">
                          </div>
                          <%} %>
                        </div>
                      
                        <!-- Left and right controls -->
                        <a class="carousel-control-prev" href="#demo" data-slide="prev">
                          <span class="carousel-control-prev-icon"></span>
                        </a>
                        <a class="carousel-control-next" href="#demo" data-slide="next">
                          <span class="carousel-control-next-icon"></span>
                        </a>
                      
                      </div>
                      
                </div>
                
                    <form action="<%= contextPath %>/buyerPurchase.pro.jy?memNo=<%= loginMember.getMemNo() %>&bno=<%= pb.getPostNo() %>" method="post" >
                    
                       <div id="content2_2">
               
                        <div id="content2_2_1">
                        	<input type="hidden" name="bno" value="<%= pb.getPostNo() %>">
                            <span>모집 기간 :</span> <%= pd.getPostEnrollDate() %> ~ <%= pd.getGpDeadline() %> <br>
                            <span>최소 인원 :</span> <%= pd.getGpMinPeople() %> <br>
                            <span>현재 인원 :</span>
                              <div class="progress" style="width: 100%">
                                <div class="progress-bar bg-success" style="width:<%= pd.getGpPeople() %> %"> <%= pd.getGpPeople() %>명 </div>
                              </div> <br>
                            <span>가격 :</span> <%= pd.getGpDPrice() %> <br>
                            <span>옵션 : </span>
                           		 <select name="option" id="product">
	                            	<% if(oList.isEmpty()){ %>
						                <!-- 조회된 옵션이 없을 경우-->
						                	<option>옵션이 없습니다.</option>
						                
									<%}else{ %>
						                	<!-- 조회된 옵션이 있을 경우-->
							            <% for(Option o : oList){ %>	
							                <option><%= o.getOptionName() %></option>
							             <%} %>
					                <%} %>
					                </select>
                            
                           
                        </div>
                       
                        

                        <div id="content2_2_2">
                            <div id="interst">
                                <button href="찜하기목록이랑연결" class="btn btn-secondary btn-sm">찜하기</button>
                            </div>
                            <div id="buy">
                                <button type="submit" class="btn btn-secondary btn-sm">구매하기</button>
                            </div>
                            <div id="report">
                                <button href="신고하기페이지로연결" class="btn btn-secondary btn-sm">신고하기</button>
                            </div>
                            
                        </div>
                   
               		 </div>
                  </form>
                   
            </div>
            <div id="content3">
              
                     <div id="content3_1">
                        <div id="content3_1_1">
                            <a type="button" onclick="showExplan();" class="btn btn-dark">상세설명</a>
                        </div>
                        <div id="content3_1_2">
                            <a type="button" onclick="showAccount();" class="btn btn-dark">입금방법</a>
                        </div>
                        <div id="content3_1_3">
                            <a href="<%= contextPath %>/buyerlist.qna.jy?currentPage=1&bno=<%= pb.getPostNo() %>" type="button" class="btn btn-dark">Q&A</a>
                        </div>
                        <div id="content3_1_4">
                            <a type="button" onclick="showRefund();" class="btn btn-dark">교환 및 환불</a>
                        </div>
                        
                        
                    </div>
                    <div id="content3_2">
                        <div id="showContent"><%= pb.getPostContent() %></div>
                    </div>

					

                    <script>
                        function showExplan(){
	                        var showArea = document.getElementById("showContent");
	                        showArea.innerHTML = "<%= pb.getPostContent() %>";
                        }
                        

                        function showAccount(){
                            var showArea = document.getElementById("showContent");
                            <%for(Account account : aList){ %>	
							    showArea.innerHTML = '입금 가능 계좌 : ' + "<%= account.getAccount() %>";
							 <% } %>
                        }
                
                        function showRefund(){
                            var showArea = document.getElementById("showContent");
                            showArea.innerHTML = "<%= pd.getGpRefund() %>";
                        }
                    </script>

                    


                    
        </div>

    </div>

	<%@ include file="../common/footerbar.jsp"%>

</body>
</html>