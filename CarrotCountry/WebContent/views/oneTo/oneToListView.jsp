<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.jmboard.oneTo.model.vo.*, java.util.ArrayList,com.javachip.carrotcountry.jmboard.notice.model.vo.PageInfo" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<OneTo> list = (ArrayList<OneTo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        width:800px;
        height:500px;
        margin:auto;
        margin-top:50px;
    }
    .list-area{
        border:1px solid orange;
        text-align:center;
    }
    .list-area tbody>tr:hover{
        background:darkgray;
        cursor:pointer;
    }
</style>
</head>
<body>
	<%@ include file="../common/commonNavbar.jsp"%>
    <div class="outer">

        <br>
        <h2 align="center">1:1문의</h2>
        <br>
        <div align="right" style="width:700px;">
            <button>글작성</button>
            <br><br>
        </div>

        <table class="list-area" align="center">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th width="300">제목</th>
                    <th width="100">작성자</th>
                    <th>답변상황</th>
                    <th width="100">작성일</th>
                    <th width="100">카테고리</th>
                </tr>
            </thead>
            <tbody>
	        <% if(list.isEmpty()) { %>
	        <tr>
	            <td colspan="6">문의사항이 없습니다.</td>
	        </tr>
	        <% } else { %>
	
	        <!--1_2. 공지사항이 있을경우(뭐라도 조회됏을경우)-->
	        	<% for(OneTo o : list) { %>
			        <tr>
			            <td><%=o.getOneToNo() %></td>
			            <td><%=o.getOneToName() %></td>
			            <td><%=o.getWriterNo() %></td>
			            <td><%=o.getAnswerState() %></td>
			            <td><%=o.getAnswerDate() %></td>
			            <td><%=o.getOneToType() %></td>
			        </tr>
	                <% } %>
               <% } %>
                </tr>

            </tbody>
        </table>
        
        
        
        <script>
			$(function(){
				$(".list-area>tbody>tr").click(function(){
					location.href = "<%=contextPath%>/detail.no.jm?nno=" + $(this).children().eq(0).text();
				});
			});
		</script>
        
        
        <div class="paging-area" align="center">
			
			<% if(pi.getCurrentPage() != 1){ %>			
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%=pi.getCurrentPage()-1%>">&lt; 이전 </a>
			<% } %>

			<% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
			
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%= p %>"><%= p %></a>
            	
            <% } %>

			<% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
            	<a href="<%=contextPath%>/list.on.jm?currentPage=<%=pi.getCurrentPage()+1%>">다음 &gt;</a>
			<% } %>
        </div>

        <br><br><br>
    </div>
</body>
</html>