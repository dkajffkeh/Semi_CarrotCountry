<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.javachip.carrotcountry.coBuying.model.vo.QnA"%>
<%
	ArrayList<QnA> list = (ArrayList<QnA>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../resources/css/coBuyingcss/buyerQnAListView.css">
</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>
<div class="wrap">
        <div id="content">
            <div id="content1">
                <div id="title">
                    <h5 align="center">Q & A</h5>
                </div>
            </div>
        
            <div id="content2" align="center">
                <div id="qList">
                    <table width="1000" class="table-hover">
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
		                                <td><%= qa.getGqNo() %></td>		<!-- 질문글번호 -->
		                                <td><%= qa.getMemNo() %></td>		<!-- 유저아이디 -->
		                                <td><%= qa.getGqContent() %></td>	<!-- 질문내용 -->
		                                <td><%= qa.getGqViews() %></td>		<!-- 조회수 -->
		                                <input type="hidden" name="qnaEnrollDate" value="<%= qa.getGqEnrollDate() %>">
		                            </tr>
		                         <%} %>
                            <%} %>
                        </tbody>
                    </table>
                    
                    
                    
					<script>
						$(function(){
							$(".list-area>tbody>tr").click(function(){
								
								// 클릭했을 때의 행에 존재하는 글번호
								var qno = $(this).children().eq(0).text();
								
								
								// 쿼리스트링으로 만들어서 요청시 값 전달
								location.href = "<%=contextPath%>/detail.qna.jy?qno=" + qno;
								
							});
						});
					</script>
                    
                    <!-- 현재 로그인한 회원일경우에만 보여지는 버튼 -->
                    <% if(loginMember != null){ %>
                    <a href="<%= contextPath %>/buyerEnroll.qna.jy" id="writeBtn" class="btn btn-secondary" style="float: right;">글 작성하기</a>
                	<%} %>

                </div>

                <div id="paginationArea" align="center">
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