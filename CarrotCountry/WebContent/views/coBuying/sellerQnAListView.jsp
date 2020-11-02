<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@
	page import="java.util.ArrayList, com.javachip.carrotcountry.coBuying.model.vo.*"
 %>    

<%
	ArrayList<QnA> list = (ArrayList<QnA>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String alertMsg = (String)session.getAttribute("alertMsg");
	Product pd = (Product)request.getAttribute("pd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 전반적인 큰 틀 */
.wrap{width:1200px;height:800px;margin:auto;}

 /* 콘텐트영역의 전반적인 틀 */
#content>div{width: 100%; float: left;}
#content1{height: 10%; padding: 20px;}
#content2{height: 20%;  padding: 20px;}
#content3{height: 70%;}
#content1>div{height: 100%; float:left}
#content2>div{height: 100%; float:left;}
#content2_1{width: 30%;}
#content2_2{width: 70%;}
#content3>div{width: 100%; float: left;}
#qList{height: 80%;}
#paginationArea{height: 20%;}

/* 타이틀 (content1) */
#title{
    width: 200px;
    height: 40px;
    padding: 5px;
    background: lightgray;
    border-radius: 20px;
    margin-top: 20px;
}
#title>h5{font-weight: 900;}
#content>h4{
    display: inline-block;
    padding: 30px;
    color: gray;
}

/* 콘텐트영역의 세부적인 틀 */
#content2_1{padding:10px;}
#content2_2>span{
    font-size: 25px;
    font-weight: 600;
    display: inline-block;
    padding-top: 30px;
}

/* 질문리스트 */
#qListTable{
    text-align: center; margin: 100px;
}
#qListTable>thead{
    background: lightgray;
    text-align: center;
    font-weight: 600;
    height: 50px;
}

#qListTable>tbody td:hover{cursor: pointer;}
#writeBtn{
    display: inline-block;
    margin: 100px;
}


</style>

</head>
<body>


<%@ include file="../common/commonNavbar.jsp"%>

	<!-- 성공적으로 삭제되었습니다 alert -->
	<% if(alertMsg != null){ %>
		<script>
			alert("<%= alertMsg %>");	
		</script>
		
		<%
			session.removeAttribute("alertMsg");
		%>
	<%} %>


    
    <div class="wrap">

        <div id="content1">
            <div id="title">
                <h5 align="center">Q & A</h5>
            </div>
        </div>

        <div id="content2">
        
            <div id="content2_1" align="center">
                <img src="<%= contextPath %>/<%= pd.getThumbnailLoadpath() %>" id="proImg" alt="" width="150" height="150">
            </div>
            <div id="content2_2">
                <span><%= pd.getPostName() %></span>
            </div>
        </div>

        <div id="content3">
            <div id="qList">
                <table id="qListTable" width="1000" class="table-hover">
                    <thead>
                        <tr>
                            <th width="100"><span>No.</span></th>
                            <th width="300"><span>아이디</span></th>
                            <th width="500"><span>질문</span></th>
                            <th width="100"><span>조회수</span></th>
                            <th width="100"><span>답변하기</span></th>
                        </tr>
                    </thead>
                    <tbody>
                    <!-- 1_1. 작성된 질문이 없을 경우 (list가 비어있을 경우) -->
                   	<% if(list.isEmpty()){ %>
	                   	<tr>
	                   		<td colspan="4">존재하는 게시글이 없습니다. </td>
	                   	</tr>
                   	<!-- 1_2. 작성된 질문이 있을 경우 (list가 비어있지 않을 경우) -->
                   	<%}else{%>
                    	<%for(QnA qa : list){ %>
	                        <tr>
	                            <td><%= qa.getGqNo() %></td>
	                            <td><%= qa.getMemNo() %></td>
	                            <td><%= qa.getGqTitle() %></td>
	                            <td><%= qa.getGqViews() %></td>
	                            <td><button class="btn btn-secondary btn-sm">답변하기</button></td>
	                        </tr>
                          <%} %>
                       <%} %>
                    </tbody>
                </table>
                
                
                   
				<script>
					$(function(){
						$("#qListTable>tbody>tr>td>button").click(function(){
							
							// 클릭했을 때의 행에 존재하는 글번호
							var bno = $(this).children().eq(0).text();
							
							
							// 쿼리스트링으로 만들어서 요청시 값 전달
							location.href = "<%=contextPath%>/판매자답변하기서블릿.qna.jy?bno=" + bno;
							
						});
					});
				</script>
                    
                
                 <a href="<%= contextPath %>/sellerenroll.qna.jy" id="writeBtn" class="btn btn-secondary" style="float: right;">답변하기</a>
                
                
            </div>



			
           <!-- 페이징 처리 -->
	        <div class="paginationArea" align="center">
	
				<% if(pi.getCurrentPage() != 1){ %>
	           		 <a href="<%= contextPath %>/sellerlist.qna.jy?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
	            <% } %>
				<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
	            	
	            	<a href="<%= contextPath %>/sellerlist.qna.jy?currentPage=<%= p %>"><%= p %></a>
	            
	            <% } %>
	            
	            <%if(pi.getCurrentPage() != pi.getMaxPage()){ %>
	           		 <a href="<%= contextPath %>/sellerlist.qna.jy?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt; </a>
	            <% } %>
	        </div>
                



        </div>

    </div>



</body>
</html>