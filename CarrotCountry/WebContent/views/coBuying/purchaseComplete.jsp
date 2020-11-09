<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

<style>
/* 전반적인 큰 틀 */
.wrap{width:1200px;height:600px;margin:auto;}
.wrap>div{width: 100%; float: left;}
#content{height: 80%;}
#buttonbar{height: 20%;}
#complete{
    margin: auto;  
    width: 700px;
    height: 400px;
    margin-top: 50px;
}
#icon{margin-top: 100px;}
#complete>h5{margin-top: 50px; font-family: 'Nanum Gothic', sans-serif;}

</style>


</head>
<body>

<%@ include file="../common/commonNavbar.jsp"%>
    <div class="wrap">
       <div id="content" align="center">
           <div id="complete">
               <i id="icon" class='far fa-check-circle' style='font-size:136px'></i>
               <h5>고객님의 결제가 성공적으로 완료되었습니다!</h5>
            </div>
       </div>
       <div id="buttonbar" align="center">
            <button id="gotoMain" class="btn btn-warning btn-sm">메인으로</button>
            
            
            
             <script>
		        	$(function(){
		        		$("#gotoMain").click(function(){
		        			
		        				location.href = "<%= contextPath %>/";
		        			
		        		})
		        	});
		        	
		        	
		        </script>
		                    

       </div>
    </div>
    
    
    <%@ include file="../common/footerbar.jsp" %>
</body>
</html>