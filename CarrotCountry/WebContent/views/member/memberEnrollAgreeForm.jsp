<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	  	#footerbar {
            position:static !important;
        }
        .img{
            margin:auto;
            margin-top:50px;
            width:400px;
            height:80px;
        }
        .img>div{
            height:100%;
            width:20%;
            float:left;
        }
        .imgB{
            margin:20px 0px 0px 20px;
            width:50%;
            height:50%;
        }
        .imgA{
            width:100%;
            height:100%;
        }
        .wrap{
            border:5px solid darkgray;
            width:400px;
            height:750px;
            margin:auto;
            padding:20px;
            margin-bottom:100px;
        }


        .wrap>h1{
            color:gray;
            text-align:center;
            font-size:30px;
            font-weight:900;
        }
        .check{
            margin-top:30px;
            width:15px;
            height:15px;
        }

        .checkLabel{
            font-weight:900;
        }
        .agree{
            width:100%;
            height:120px;
            resize:none;
            border:1px solid gray;
        }
        .button1, .button2{
            margin-top:50px;
            height:35px;
            width:80%;
        }

        .button2{
            color:white;
        }
</style>
</head>
<body>

	<%@ include file = "../common/commonNavbar.jsp" %>

    <div class="img">
        <div><img src="<%= contextPath %>/resources/images/member/checkPage.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/write.png" class="imgA"></div>
        <div><img src="<%= contextPath %>/resources/images/member/right.png" class="imgB"></div>
        <div><img src="<%= contextPath %>/resources/images/member/user.png" class="imgA"></div>
    </div>
    <div class="wrap">

        <h1>약관 동의</h1>

        <table border="1px" width="100%">
            <form action="<%= contextPath %>/enrollInput.me.ng" method="get">
                <tr>
                    <td colspan="2"><input type="checkbox" class="check" id="agree1" required><label class="checkLabel" for="agree1">당근나라 이용약관 동의 (필수)</label></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea class="agree" readonly>
[당근나라 이용약관]

제1조 (목적)
•	①본 약관은 '(주)당근나라 '(이하 '회사'라 함)이 운영하는 인터넷 사이트 및 모바일 애플리케이션(이하 '당근나라'이라 함)에서 제공하는 전자상거래 관련 서비스 및 기타 서비스(이하 '서비스'라 함)를 이용하는 자 간의 권리·의무 및 책임사항을 규정함을 목적으로 합니다.
•	②(주)당근나라는 통신판매중개자로서 거래당사자가 아니며, 판매자가 등록한 상품정보 및 거래에 대해 (주)당근나라는 일체 책임을 지지 않습니다.
                            
    생략...
                    </textarea>
                </td>
                <tr>
                    <td colspan="2"><input type="checkbox" class="check" id="agree2" required><label class="checkLabel" for="agree2">개인정보 수집 및 이용 동의 (필수)</label></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea class="agree" readonly>
[개인정보처리방침]

1. 개인정보 수집 및 이용에 대한 고지
(주)당근나라'(이하 '회사'라 함)이 운영하는 인터넷사이트 및 모바일 애플리케이션(이하 '당근나라'이라 함)에서 제공하는 전자상거래 관련 서비스 및 기타 서비스(이하 '서비스'라 함)는 통신비밀보호법, 전기통신사업법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등                                 
    
    생략...
                    </textarea>
                </td>
                <tr>
                    <td colspan="2"><input type="checkbox" class="check" id="agree3" required><label class="checkLabel" for="agree3">위치정보 이용약관 동의 (필수)</label></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea class="agree" readonly>
[위치기반서비스 이용약관]

제1장 총칙
제1조 (목적)
본 약관은 '(주)당근나라'(이하 '회사'라 함)이 운영하는 '당근나라'에서 제공하는 위치기반서비스(이하 '서비스'라 함)를 이용함에 있어 '회사'와 '고객' 및 개인위치정보주체의 권리/의무 및 책임사항에 따른 이용조건 및 절차 등 기본적인 사항을 규정함을 목적으로 합니다.
                                    
     생략...
                        </textarea>
                    </td>
                </tr>
                <tr align="center" >
                    <td><a href="" class="button1 btn btn-outline-secondary">뒤로가기</a></td>
                    <td><button type="submit" class="button2 btn btn-warning">회원가입</button></td>
                </tr>
            </form>
        </table>


    </div>
    
    <%@ include file = "../common/footerbar.jsp" %>
    
</body>
</html>