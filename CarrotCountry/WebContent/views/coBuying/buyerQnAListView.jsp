<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="java.util.ArrayList, com.javachip.carrotcountry.coBuying.model.vo.*,com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*"
 %>    

<%
	ArrayList<QnA> list = (ArrayList<QnA>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String alertMsg = (String)session.getAttribute("alertMsg");
	PostBoard pb = (PostBoard)request.getAttribute("pb");
	int bno = (int)request.getAttribute("bno");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

/* 전반적인 큰 틀 */
.wrap{width:1200px;height:800px;margin:auto;}
#content{height: 100%;}

#content>div{width: 100%; float: left;}
#content1{height: 15%; padding: 20px;}
#content2{height: 85%;}


/* 컨텐츠의 틀 */
#content2>div{width: 100%; float: left;}
#qList{height: 70%;}
#paginationArea{height: 30%;}

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
    padding-bottom: 0px;
    color: gray;
}
/* 질문리스트 */
#content2{
    display: inline-block;
    margin-top: 100px;
}
table{
    text-align: center;
}
thead{
    background: lightgray;
    text-align: center;
    font-weight: 600;
    height: 50px;
}

tbody td:hover{cursor: pointer;}

#writeBtn{
    display: inline-block;
    margin: 100px;
}


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
        <div id="content">
            <div id="content1">
                <div id="title">
                    <h5 align="center">Q & A</h5>
                </div>
            </div>
            <div id="content2" align="center">
                <div id="qList">
                    <table id="list-area" width="1000" class="table-hover">
                        <thead>
                            <tr>
                                <th width="100"><span>No.</span></th>
                                <th width="300"><span>아이디</span></th>
                                <th width="500"><span>질문</span></th>
                                <th width="100"><span>조회수</span></th>
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
		                            	<input type="hidden" name="postNo" value="<%= qa.getPostNo() %>">
		                                <td><%= qa.getGqNo() %></td>		<!-- 질문글번호 -->
		                                <td><%= qa.getMemNo() %></td>		<!-- 유저아이디 -->
		                                <td><%= qa.getGqTitle() %></td>		<!-- 질문제목 -->
		                                <td><%= qa.getGqViews() %></td>		<!-- 조회수 -->
		                                <input type="hidden" name="qnaEnrollDate" value="<%= qa.getGqEnrollDate() %>">
		                            </tr>
		                         <%} %>
                            <%} %>
                        </tbody>
                    </table>
                    
                    
                    
					<script>
						$(function(){
							$("#list-area>tbody>tr").click(function(){
								
								// 클릭했을 때의 행에 존재하는 글번호
								var qno = $(this).children().eq(1).text();
								
								
								// 쿼리스트링으로 만들어서 요청시 값 전달
								location.href = "<%=contextPath%>/detail.qna.jy?qno=" + qno +"&bno="+"<%=bno%>";
								
							});
						});
					</script>
                    
                    <!-- 현재 로그인한 회원일경우에만 보여지는 버튼 -->
                    <% if(loginMember != null){ %>
                    <a href="<%= contextPath %>/buyerenroll.qna.jy?bno=<%=bno%>" id="writeBtn" class="btn btn-secondary" style="float: right;">글 작성하기</a>
                	<%} %>

                </div>

                
                
	         <!-- 페이징 처리 -->
	         <div class="paginationArea" align="center">
	
				<% if(pi.getCurrentPage() != 1){ %>
	           		 <a href="<%= contextPath %>/buyerlist.qna.jy?currentPage=<%= pi.getCurrentPage() - 1 %>">&lt; 이전</a>
	            <% } %>
				<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
	            	
	            	<a href="<%= contextPath %>/buyerlist.qna.jy?currentPage=<%= p %>"><%= p %></a>
	            
	            <% } %>
	            
	            <%if(pi.getCurrentPage() != pi.getMaxPage()){ %>
	           		 <a href="<%= contextPath %>/buyerlist.qna.jy?currentPage=<%= pi.getCurrentPage() + 1 %>">다음 &gt; </a>
	            <% } %>
	        </div>
                
                
                
               
            </div>
            
        </div>

    </div>



<%@ include file="../common/footerbar.jsp"%>


</body>
</html>