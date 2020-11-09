<%@page import="com.javachip.carrotcountry.userinfoBoard.model.vo.ShippingLocation"%>
<%@page import="com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard"%>
<%@page import="com.javachip.carrotcountry.coBuying.model.vo.Account"%>
<%@page import="com.javachip.carrotcountry.coBuying.model.vo.Option"%>
<%@page import="com.javachip.carrotcountry.coBuying.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int optionNo = (Integer)request.getAttribute("optionNo");
	Product p = (Product)request.getAttribute("p");
	PostBoard pb = (PostBoard)request.getAttribute("pb");
	ArrayList<Option> optionList = (ArrayList<Option>)request.getAttribute("optionList");
	ArrayList<Account> accountList = (ArrayList<Account>)request.getAttribute("accountList");
	ArrayList<ShippingLocation> shippingList = (ArrayList<ShippingLocation>)request.getAttribute("shippingList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.wrap{width:1200px;height:1500px;margin:auto;}
#content{height: 100%;}
#footer{height:100%; margin:10px 0px;}

/* 컨텐트바의 전반적인 틀 */
#content>div{width: 100%; float: left;}
#content1{height: 8%; padding: 20px;}
#content2{height: 42%;}
#content3{height: 20%;}
#content4{height: 30%;}

/* 컨텐츠의 세부요소 */
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

/* 배송정보 */
#deliveryInfo td{padding: 25px;}
#deliveryInfo td span{font-weight: 600;} 
#deliveryInfo td input{
    border: 1px solid lightgray;
    display: inline-block;
    margin: 10px;
} 

/* 상품정보 */
#proInfo th{
    height: 80px;
    background: lightgray;
    text-align: center;
}
#proInfo th>span{
    font-size: 13px;
    font-weight: 900;
    display: inline-block;
    padding: 23px;
}
#proInfo td{
    padding: 20px;
}
#proInfo td>p{
    font-size: 20px;
    font-weight: 600;
}
.price{
    text-align: center;
    font-weight: 600;
}

/* 결제정보 */
#purchaseInfo td{padding: 25px;}
#purchaseInfo td span{font-weight: 600;} 
#purchaseInfo td input{
    border: 1px solid lightgray;
    display: inline-block;
    margin: 10px;
} 
#purchaseBtn{
    display: inline-block;
    margin: 30px;
}

</style>

</head>
<body>

	<%@ include file="../common/commonNavbar.jsp"%>
	
    <div class="wrap">
        <div id="content">
            <div id="content1">
                <div id="title">
                    <h5 align="center">주문/결제</h5>
                </div>
            </div>
            <h4>배송정보</h4>
            <hr style="border-bottom: 2px solid grey; border-top: none;">
			<form action="<%= contextPath %>/purchaseInfo.pro.jy?&bno=<%= p.getPostNo() %>" method="POST">
			<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
	            <div id="content2">
	
	                <table id="deliveryInfo">
	                    <tr>
	                        <td align="right"><span>주문자 : </span></td>
	                        <td><input type="text"></td>
	                    </tr>
	                    <tr>
	                        <td align="right"><span>배송지 선택 : </span></td>
	                        <td>
	                        	<button type="button" class="btn btn-secondary btn-sm" onclick="defaultShipping();">기본 배송지</button>
	                            <div class="btn-group" role="group">
	                            <button type="button" class="btn btn-secondary btn-sm dropdown-toggle" id="shippingList" onclick="shippingList();" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">배송지 목록</button>
		                            <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
			                            <% for (int i = 0; i < shippingList.size(); i++) { %>
			                            	<a class="dropdown-item" onclick="address(<%= shippingList.get(i).getShippingNo() %>);"><%= shippingList.get(i).getShippingAddress() %></a>
			                            <% } %>		                            
		                            </div>
	                            </div>
	                            <button type="button" class="btn btn-secondary btn-sm">신규 배송지</button>
	                            
	                        </td>
	                    </tr>
	                    <tr>
	                        <td align="right"><span>이름 : </span></td>
	                        <td><input type="text" value="<%= loginMember.getMemName() %>" required></td>
	                    </tr>
	                    <tr>
	                        <td align="right"><span>연락처 : </span></td>
	                        <td><input type="tel" name="buyerPhone" placeholder="(- 포함해서 입력)" value="<%= loginMember.getMemPhone() %>" required></td>
	                    </tr>
	                    <tr>
	                        <td align="right"><span>주소 : </span></td>
	                        <td>
	                        	<input type="text">
	                            <button type="button" id="buyerAddress" class="btn btn-secondary btn-sm">우편번호찾기</button> <br>
	                            <input type="hidden" id="shippingNo"  name="shippingNo">
	                            <input type="text" id="address"> &nbsp; <input type="text" id="detailAddress" placeholder="상세주소 입력">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td align="right"><span>배송시 요청사항 : </span></td>
	                        <td>
	                        	<select id="selbox" name="selbox">
		                            <option value="1">부재시 경비실에 맡겨주세요</option>
		                            <option value="2">배송 전 연락주세요</option>
		                            <option value="direct">직접입력</option>
	                        	</select>
	                        
	                        	<input type="text" id="selboxDirect" name="requests"/>
	                    	</td>
	                    </tr>
	                </table>
	            </div>
	            <script>
			        $(function(){
			            $("#selboxDirect").hide();
			            
			            $("#selbox").change(function() {
			            
			                    if($("#selbox").val() == "direct") {
			                        $("#selboxDirect").show();
			                    }  else {
			                        $("#selboxDirect").hide();
			                    }
			                }) 
			        });
			                        
	            	function defaultShipping() {
	            		
	            		var address = document.getElementById("address");
	            		var shippingNo = document.getElementById("shippingNo");
	            		
	            		<% for (ShippingLocation list : shippingList) {%>
	            			<% if ("Y".equals(list.getShippingDefault())) { %>
	            				shippingNo.value = "<%= list.getShippingNo() %>";
	            				address.value = "<%= list.getShippingAddress() %>";
	            			<% } %>
	            		<% } %>
	            	}
	            	
	            	function address(index) {

	            		var address = document.getElementById("address");
	            		var shippingNo = document.getElementById("shippingNo");
	            		
	            				console.log(index);
	            		<% for (ShippingLocation list : shippingList) {%>
	            			if (index == <%= list.getShippingNo() %>) {
	            				shippingNo.value = "<%= list.getShippingNo() %>";
	            				address.value = "<%= list.getShippingAddress() %>";
	            			}
            			<% } %>
	            		
	            	}
	            </script>
	
	            <h4>상품정보</h4>
	            <hr style="border-bottom: 2px solid grey; border-top: none;">
	            <div id="content3">
	                <table id="proInfo" border="1">
	                    <tr>
	                        <th colspan="2" width=700><span>상품정보/수량</span></th>
	                        <th width=125><span>상품금액</span> </th>
	                        <th width=125><span>할인금액</span></th>
	                        <th width=125><span>할인적용금액</span></th>
	                        <th width=125><span>배송비</span></th>
	                    </tr>
	                    <tr>
	                        <td rowspan="2" width="200" height="200">
	                            <img src="<%= contextPath %>/<%= pb.getThumbnailLoadPath() %> + <%= pb.getThumbnailFilename() %>" width="100%" height="100%" onerror="this.src='https://cdn.pixabay.com/photo/2016/10/18/19/24/carrot-1751148_960_720.png'">
	                        </td>
	                        <td><p><%= pb.getPostName() %></p></td>
	                        <td rowspan="3" class="price"><%= p.getGpPrice() %>원</td>
	                        <td rowspan="3" class="price"><%= p.getGpDPrice() %>원</td>
	                        <td rowspan="3" class="price"><%= p.getGpDPrice()%>원</td>
	                        <input type="hidden" name="purchasePrice" value="<%= p.getGpDPrice()%>">
	                    </tr>
	                    <tr>
	                        <td>
	                            <select name="optionNo" id="option">
	                            	<% for (int i = 0; i < optionList.size(); i++) { %>
	                            		<% if (optionNo == optionList.get(i).getOptionNo()) { %>
			                                <option value="<%= optionList.get(i).getOptionNo() %>" selected><%= optionList.get(i).getOptionName() %></option>                            			
	                            		<% } else { %>
		                                	<option value="<%= optionList.get(i).getOptionNo() %>"><%= optionList.get(i).getOptionName() %></option>
										<% } %>
	                            	<% } %>
	                            </select>
	                        </td>
	                    </tr>
	                </table>
	            </div>
	
	            <h4>결제정보</h4>
	            <hr style="border-bottom: 2px solid grey; border-top: none;">
	            <div id="content4">
	                            
	                <table id="purchaseInfo">
	                    <tr>
	                        <td>입금자명 :</td>
	                        <td><input type="text" name="depositor" value="<%= loginMember.getMemName() %>" required></td>
	                    </tr>
	                    <tr>
	                        <td>입금계좌 :</td>
	                        <td>
	                            <select name="account" id="account">
	                                <option>:: 입금하실 계좌를 선택해주세요 ::</option>
	                                <% for (int i = 0; i < accountList.size(); i++) { %>
		                                <option value="<%= accountList.get(i).getAccount() %>"><%= accountList.get(i).getBank() %> <%= accountList.get(i).getAccount() %></option>
	                                <% } %>
	                            </select>
	                        </td>
	                    </tr>
	                </table>
	
	                <b>* 입금정보 확인 후 일치할시, 발송됩니다. </b>
	                
	                <br><br>
	                <button type="submit" id="purchaseBtn" class="btn btn-dark">주문하기</button>
	            </div>
			</form>
        </div>
        

    </div>
    <%@ include file ="../common/footerbar.jsp" %>
</body>
</html>