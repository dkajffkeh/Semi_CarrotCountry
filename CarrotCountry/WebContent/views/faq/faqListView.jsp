<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.javachip.carrotcountry.jmboard.faq.model.vo.Faq" %>
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String loginFail = (String)request.getAttribute("loginFail");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/faq/faqListView.css">
<style>
#log>table{
	margin:auto;
}


</style>
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
        	<center>
        	<table class="table table-bordered center list-area"  >
                <tbody>
                    <tr>
                        <td onclick='location.href="<%=contextPath%>/search.fa.jm?type=11"'>운영정책</td>
                        <td onclick='location.href="<%=contextPath%>/search.fa.jm?type=22"'>계정/인증</td>
                        <td onclick='location.href="<%=contextPath%>/search.fa.jm?type=33"'>중고구매/판매</td>
                        <td onclick='location.href="<%=contextPath%>/list.fa.jm"'>전채보기</td>
                    </tr>
                </tbody>
            </table>
        	</center>

            
        </div>
       <div class="CS_content_2">
        <center><b>사용자들이 자주 묻는 질문을 확인해보세요!</b></center>
        <br>
       </div>
       <%if(loginMember != null && loginMember.getManagerCheck().equals("Y")){ %>
	        <div align="right" style="width:800px;">
	            <a href="<%= contextPath %>/enrollForm.fa.jm" class="btn btn-secondary btn-sm">글작성</a>
	            <br><br>
	        </div>
	   <%} %>     
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
		<br><br>
       <div class="content_4">
        <div class="container">
            <div class="jumbotron" align="center">
            <h6>안녕하세요</h1>      
            <%if(loginMember == null){ %>
            	  <a data-toggle="modal" data-target="#myModal">1:1문의</a>
            <%}else{ %>
            	<a href="<%=contextPath%>/enrollForm.on.jm">1:1문의<a>
            <%} %>
            
            </div>
        </div>
       </div>
       <div class="content_5" >
        <center><a href="">이용약관</a></center>
        <br>
        <center><a href="">개인정보이용방침</a></center>
        <br><br>
        
        
        
        
        
        <!-- The Modal -->
		  <div class="modal" id="myModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">로그인해야 사용가능한 서비스입니다.</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        
		        
		        
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        
		        
		        
		        <form action="<%= contextPath %>/login.me.ng" method="post" id="log">
		        <table>
                <tr>
                	<td>아이디 </td>
                    <td colspan="2"><input type="text" class="border border-warning" name="userId" id="userId" placeholder="" required></td>
                </tr>
                <tr>
                	<td>비밀번호 </td>
                    <td colspan="2"><input type="password" class="border border-warning" name="userPwd" id="userPwd" placeholder="" required></td>
                </tr>
                </table>
                <tr>
                    <td colspan="2">
                        <!-- 로그인 오류시 출력문구 입력 -->
                    	<% if(loginFail != null){ %>
                    		<label id="p"><%= loginFail %><label>
                    	<% } %>
                    </td>
                </tr>
                
                <div align="right">
                	<input type="submit" id="loginSubmit" class="btn btn-warning" value="로그인">
                </div>
                    
                    
                
	            </form>
		        </div>
		        
		        
		        
		      </div>
		    </div>
		  </div>
       </div>















       <script>
	   	$(function(){
			$(".list-group>tbody>tr").click(function(){
				
				// 클릭했을 때의 행에 존재하는 글번호
				var nno = $(this).children().eq(0).text();
				
				location.href = "<%=contextPath%>/detail.fa.jm?fno=" + fno;       			
				
			});
		});
	   	<!--------------------------------------------->
	   	$(document).ready(function(){
	   	  $('[data-toggle="popover"]').popover();   
	   	});
       
	   	<!--------------------------------------------->
       
        $(document).ready(function(){
          $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myList li").filter(function() {
              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
          });
        });
        
        <!---->
        </script>

    </div>
</body>
</html>