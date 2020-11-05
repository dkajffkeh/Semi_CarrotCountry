<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.javachip.carrotcountry.jmboard.faq.model.vo.Faq" %>
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/faq/faqListView.css">
</head>
<body>

	<!-- 상단바 -->
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

    <div class="CS_content">
        <div class="content_1">
            <table class="table table-bordered center list-area"  align="center">

                <tbody>
                    <tr>
                        <td>운영정책</td>
                        <td>계정/인증</td>
                        <td>중고구매/판매</td>
                    </tr>
                    <tr>
                        <td>거래품목</td>
                        <td>신고관련</td>
                        <td>공동구매/판매</td>
                    </tr>
                    <tr>
                        <td>이용 제재</td>
                        <td>블랙리스트관련</td>
                        <td >공구문의</td>
                    </tr>
                </tbody>
            </table>
        </div>
       <div class="CS_content_2">
        <center><b>사용자들이 자주 묻는 질문을 확인해보세요!</b></center>
        <br>
       </div>
	        <div align="right" style="width:700px;">
	            <a href="<%= contextPath %>/enrollForm.fa.jm" class="btn btn-secondary btn-sm">글작성</a>
	            <br><br>
	        </div>
       <div class="content_3">
	        <ul class="list-group" id="myList">
	           <% if(list.isEmpty()){ %>
	                <!-- 공지사항이 없을경우 -->
	                <li class="list-group-item">공지사항이 없습니다.</li>
                <% }else{ %>
	                <!-- 공지사항이 있을경우 -->
	                <% for(Faq f : list){ %>
						<li class="list-group-item faq" onclick='location.href="<%=contextPath%>/detail.fa.jm?fno=<%=f.getFaqNo() %>"'><%=f.getFaqTitle() %></li>
	                <% } %>
                <% } %>
        	</ul>  
          <br><br><br>
        <input class="form-control" id="myInput" type="text" placeholder="Search..">

       </div>
       <div class="content_4">
        <div class="container">
            <div class="jumbotron" align="center">
            <h6>안녕하세요</h1>      
            <a href="">1:1문의<a>
            </div>
        </div>
       </div>
       <div class="content_5" >
        <center><a href="">이용약관</a></center>
        <br>
        <center><a href="">개인정보이용방침</a></center>
        <br><br>
       </div>

       <script>
	   	$(function(){
			$(".list-group>tbody>tr").click(function(){
				
				// 클릭했을 때의 행에 존재하는 글번호
				var nno = $(this).children().eq(0).text();
				
				location.href = "<%=contextPath%>/detail.fa.jm?fno=" + fno;       			
				
			});
		});
       
       
       
        $(document).ready(function(){
          $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myList li").filter(function() {
              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
          });
        });
        </script>

    </div>
</body>
</html>