<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  
<style type="text/css">
 
@import "https://fonts.googleapis.com/css?family=Baloo+Paaji";
html,
body {
  height: 100%;
  
}


body {
  font-family: "Baloo Paaji", cursive;
  background:rgb(255, 133, 34);
  display: flex;
  justify-content: center;
  align-items: center;
  animation-fill-mode: forwards;
  
}

.container {
  width: 800px;
  height: 620px;
  position: relative;
}

h1,
h2 {
  font-size: 75px;
  text-transform: uppercase;
}

h1 span, 
h2 span{
  width: 100%;
  float: left;
  color: rgb(255, 255, 255);
  -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  transform: translateY(-50px);
  opacity: 0;
  animation-name: titleAnimation;
  animation-timing-function: ease;
  animation-duration: 3s;
}

h3 span img{
  width: 100%;
  float: left;
  color: #ffffff;
  -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
  transform: translateY(-50px);
  opacity: 0;
  animation-name: titleAnimation;
  animation-timing-function: ease;
  animation-duration: 10s;
}



h1 span {
  animation-delay: 0.6s;
}
h1 span:first-child {
  animation-delay: 0.7s;
}
h1 span:last-child {
  color: #ffe221;
  animation-delay: 0.5s;
}

h2 {
  top: 0;
  position: absolute;
}
h2 span {
  animation-delay: 4.1s;
}
h2 span:first-child {
  animation-delay: 4.2s;
}
h2 span:last-child {
  color: #ffd900;
  animation-delay: 4s;
}

h3 span img {
  animation-delay: 7.1s;
}
h3{
  font-size: 30px;
  color: #fff;
  font-family: "Baloo Paaji", cursive;
  position: absolute;
  bottom: 100px;
  width: 100%;
  text-align: center;
  left: 0;
  margin: auto;
}
h3 a{
  text-decoration: none;
	color: #ffffff;
}
h3 a:hover{
  color:#ffd104;
  font-size: 32px;
}

.usechrome {
  font-size: 10px;
  color: #fff;
  font-family: helvetica, arial;
  position: absolute;
  bottom: 20px;
  width: 100%;
  text-align: center;
  left: 0;
}


@keyframes titleAnimation {
  0% {
    transform: translateY(-50px);
    opacity: 0;
    -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
    clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 80%);
    
    
  }
  20% {
    transform: translateY(0);
    opacity: 1;
    -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
    clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  80% {
    transform: translateY(0);
    opacity: 1;
    -webkit-clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
    clip-path: polygon(100% 0, 100% 100%, 0 100%, 0 15%);
  }
  100% {
    transform: translateY(50px);
    opacity: 0;
    -webkit-clip-path: polygon(100% 0, 100% 0%, 0 100%, 0 100%);
    clip-path: polygon(100% 0, 100% 0%, 0 100%, 0 100%);
  }
}


    
</style>
</head>
<body>

<section class="container">
  <h1 class="title">
    <span>Hi, </span>
    <span>neighbor</span>
    <span></span>
  </h1>
  
  <h2 class="title">
    <span>Welcome</span>
    <span>to</span>
    <span>Carrot Country</span>
  </h2>
  <h3>
    <span><img src="resources/images/coBuying/carrotlogo.png" alt=""> </span>
  </h3>
  
  
</section>

<h3>
  <a href="<%= contextPath %>/mainBoardTopEight.sh"> &nbsp;&nbsp;  Go To CarrotCountry &nbsp;&nbsp;</a>
</h3>
<span class="usechrome">Carrot Country Company</span>
</body>
</html>