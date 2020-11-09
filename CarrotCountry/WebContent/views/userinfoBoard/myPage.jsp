<%@page import="java.util.ArrayList"%>
<%@ page import="com.javachip.carrotcountry.userinfoBoard.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	ArrayList<ShippingLocation> list = (ArrayList<ShippingLocation>)request.getAttribute("list");
	Location lo = (Location)request.getAttribute("lo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/userinfoBoard/myPage.css">


</head>
<body>
	<!--  headerNavbar -->
	<%@ include file= "../common/commonNavbar.jsp"%>
	
	<!-- 회원정보 -->
	<%
	String userId = loginMember.getMemUserId();
	String memName = loginMember.getMemName();
	
	String gender = (loginMember.getMemGender() == null) ? "" : loginMember.getMemGender();
	String birthday = (loginMember.getMemBirthday() == null) ? "" : loginMember.getMemBirthday();
	String nickName = (loginMember.getMemNickname() == null) ? "" : loginMember.getMemNickname();
	String phone = (loginMember.getMemPhone() == null) ? "" : loginMember.getMemPhone();
	String email = (loginMember.getMemEmail() == null) ? "" : loginMember.getMemEmail();
	int memNo = loginMember.getMemNo();
	int localNo = loginMember.getLocalNo();
	
	String localSi = (lo.getLocalSi() == null) ? "" : lo.getLocalSi();
	String localGu = (lo.getLocalGu() == null) ? "" : lo.getLocalGu();
	String localDong = (lo.getLocalDong() == null) ? "" : lo.getLocalDong();
	%>
	
	<div class="myPageWrapper">
	
	<!--  mypageMenubar -->
	<%@ include file= "./mypageMenubar.jsp" %>
	
	<div class="myPageWrapper_content">
	<div class="outer">
    <br>
    <h2>회원 정보</h2>
     <hr color="gray">
     <br><br>
     <!-- content영역의 윗부분 -->
    <form action="<%= contextPath %>/myPage.me.jw" method="post" id="myPage">
    	 <input type="hidden" value="<%= memNo %>" name="memNo">
    	 <input type="hidden" value="<%= localNo %>" name="localNo">
    	 
    
     <div id="content_top">
         <!-- 프로필 사진 -->
        <div id="content_top1">
                <div id="fileArea">
                <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);" required>
                </div>
                <img id="profileImg" width="150" height="150" style="border-radius:1500px; border:1px solid lightgray;">
                <br>
                <label for="file1">프로필변경</label>
        </div>


		<!-- 프로필 사진 미리보기, 변경 -->
        <script>
            $(function(){
                $("#fileArea").hide();
                $("#profileImg").click(function(){
                    $("#file1").click();
                });
            });
            function loadImg(inputFile, num){
                if(inputFile.files.length == 1){
                    var reader = new FileReader();
                    
                    reader.readAsDataURL(inputFile.files[0]);
                    reader.onload = function(e){
                    	
                        switch(num){
                            case 1: $("#profileImg").attr("src", e.target.result); break;
                        }
                    };
                }else{ 
                    switch(num){
                        case 1: $("#profileImg").attr("src", null); break;
                    }
                }
            }
        </script>




        <!-- 3가지 건수 노출부분 -->
        <div id="content_top2">
            <span align="center"><h4>지역거래</h4><a href="<%= contextPathUserinfo %>/onSale.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>&currentPage=1">2</a> 건</span>
            <span align="center"><h4>공동구매</h4><a href="<%= contextPathUserinfo %>/groupPurchaseList.gp.ng?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=1">3</a> 건</span>
            <span align="center"><h4>문의</h4><a href="<%= contextPathUserinfo %>/myList.on.jm?memNo=<%= loginMemberUserinfo.getMemNo() %>&repCurrentPage=1">1</a>건</span>    
        </div>
        <!-- 버튼 2개 부분 -->
       <div id="content_top3">
        <button type="button"class="btn btn-secondary" onclick="location.href='<%= contextPath%>/updateForm.me.jw?memNo=<%= loginMemberUserinfo.getMemNo() %>'">회원 정보 수정</button><br><br>
        <button type="button" class="btn btn-secondary" onclick="location.href='<%= contextPath%>/pwdUpdatePage.me.ng'">비밀번호 변경</button>
       </div>
	    </div>
	    <br><br><br><br>
	    <!-- content영역의 아랫부분 (회원정보, 배송지정보) -->
	    <div id="content_bottom">
	            <!--회원정보 -->
	     <div id="content_bottom1">
	     
        <table>
            <tr>
                <td>아이디</td>
                <td><%= userId %></td>
            </tr>
            <tr>
                <td>성함</td>
                <td><%= memName %></td>
            </tr>
            <tr>
                <td>성별</td>
                <td><%= gender %></td>
            </tr>
            <tr>
                <td>생년월일</td>
                <td><%= birthday %></td>
            </tr>
            <tr>
                <td>닉네임</td>
                <td><%= nickName %></td>
            </tr>
            <tr>
                <td>연락처</td>
                <td><%= phone %></td>
            </tr>
            <tr>
                <td>지역</td>
                <td>
           			<%= localSi %>
           			<%= localGu  %>
           			<%= localDong %>
                </td>
            </tr>
            <tr>
                <td>E-Mail</td>
                <td><%= email %></td>
            </tr>
        </table>
        </div>
        <!-- 배송지 정보  -->
        <div id="content_bottom2">
            <h3  align="center" ><b>배송지 등록 정보</b></h3> 
            <br>
            
           
            <div id = "content_bottom2_1">
                <button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#addAdressForm">등록</button>
                <button type="button" class="btn btn-secondary btn-sm"  data-toggle="modal" data-target="#deleteAddress">삭제</button>    
            </div>
            
       <br><br>
            <div id="content_bottom2_2">
            	<input type="hidden" name="memNo" value="<%= memNo %>">
   			<% for (ShippingLocation sl : list)  { %>
   
            
            <!-- 체크박스 선택 시 value값 -->
            <!-- 
            <script>
        		function deleteAddress() {
        			var insertSl = document.getElementById("insertSl");
        			
        			if(document.insertSl.delete_address.checked){	
        				
        				document.insertSl.delete_address.value = 'Y';
        			}else{
        				document.insertSl.delete_address.value = 'N';
        			}
        		}
         	 </script>
             -->
            
            
            
            
            
            <input type="checkbox" style="height:24px; width:24px;" onclick="deleteAddress()" name="delete_address" value="<%= sl.getShippingNo() %>">
            &nbsp;&nbsp;배송지<%=list.indexOf(sl)+1%>)


            
            
            <!----------------------기본배송지 설정 시 보여질 문구---------------------->

					<% if(sl.getShippingDefault().equals("Y")) { %>
					
					
		            <div id="content_bottom2_3">
		                <p style="color:blue;">기본배송지</p>
		            </div>
		 
		            
		            <% } %>
            <!------------------------------------------------------------------------>

			            <br>
			       <%= sl.getShippingAddress() %>
			       		<br><br>
			       		
	
			       		
			       		
			       		
			       		
			 		  <%} %><!-- for (ShippingLocation sl : list)  -->
			 
			 
			 
<!-------------------------------- 배송지 등록 버튼 클릭시 보여질 modal------------------>
	   
   
			<!--  x -->

<!------------------------------------------------------------------------------- -->
			 
			 
			   </div><!-- content bottom2_2 -->
	
<!-------------------------------- 배송지 등록 버튼 클릭시 보여질 modal------------------>
	   
   			<!-- x -->
<!------------------------------------------------------------------------------- -->
	
	
	
	</div><!-- content bottom2 -->
			
<!-------------------------------- 배송지 등록 버튼 클릭시 보여질 modal------------------>
	   
   				<!--  x -->

<!------------------------------------------------------------------------------- -->
			
			
			
			
			
			
	</div> <!-- content-bottom -->
			    
			  
			
			    <div id="updateButton" align="center">
			        
			        <button type="submit" class="btn btn-primary">변경하기</button>
			       
			    </div>
		</form>	    
	</div>
  
    


<!-------------------------------- 배송지 등록 버튼 클릭시 보여질 modal------------------>
	   
		<!-- x -->	    
 
  
<!------------------------------------------------------------------------------- -->

<!----------------------삭제버튼 클릭시 보여질 modal---------------------------------------->


				
				</div>
				</div>
				
<!------------------------------------------------------------------------------- -->

		<!-- footerbar -->
		<%@ include file="../common/footerbar.jsp" %>
		
		
<!-------------------------------- 배송지 등록 버튼 클릭시 보여질 modal------------------>
	   <script>
        		function defaultCheck() {
        			var insertSl = document.getElementById("insertSl");
        			if(document.insertSl.defaultAddress.checked){
        				document.insertSl.defaultAddress.value = 'Y';
        			}else{
        				document.insertSl.defaultAdress.value = 'N';
        			}
        		}
       </script>
   
<div class="modal fade" id="addAdressForm">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">배송지 추가</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <% if ( list.size() < 3)  {%>
        <!-- Modal body -->
        <div class="modal-body" align="center">
          <form action="<%= contextPath %>/insert.lo.jw" method="post" name="insertSl">
                <input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>" >
                <input type="hidden" name="userName" value="<%= loginMember.getMemName() %>" >
                <input type="hidden" name="phone" value="<%= loginMember.getMemPhone() %>" >
                <input type="hidden" name="defaultAddress" value="">
                배송지를 입력하세요 <br><br>
                <input type="text" name="address" size="40" style="border: 3px solid orange;">
              <br><br><br><br>
              <!-- Modal footer -->
          <div class="modal-footer">
             
         
         <% Boolean flag = false;  %>
         
         <% for (ShippingLocation sl : list)  {%>
            
		  <% if("Y".equals(sl.getShippingDefault())) { 
          		flag = true;} %>
          <%} %>
         
         <!-- 이미 기본배송지 있을 때 -->
			<% if(flag){ %>
          
              <p style="color:gray;">기본 배송지로 설정하려면 기존의 기본배송지를 삭제하세요.</p>			
              <button type="submit" class="btn btn-primary">등록</button>
          	
          <!--  기본배송지 없을 때 --> 
          <% }else {%>
              
              
              <input type="checkbox" name="defaultAddress"  onclick="defaultCheck()" value="">&nbsp;
              <label for="default">기본 배송지로 등록</label>
              <button type="submit" class="btn btn-primary">등록</button>
          
          
          <%} %>
          
          </div>
     		<%}else { %> <!--  배송지가 3개 이상일때 -->
          	
          	<div class="modal-body" align="center">
      			
          		배송지를 삭제 후 등록해주세요.
          	</div>
          <%} %>
              <br>
          
          
            <!--  (ShippingLocation sl : list)   -->
          
          
  



          </form>
        </div>
        
      </div>
    </div>
  </div>


<!--------------------------------------------------------------------------------->
		
			<!----------------------삭제버튼 클릭시 보여질 modal---------------------------------------->
		
		<% for (ShippingLocation sl : list)  {%>
		
					 <div class="modal" id="deleteAddress">
					    <div class="modal-dialog">
					    <div class="modal-content"> 
					    
					        <!-- Modal body -->
					        <div class="modal-body" align="center">
					           삭제하시겠습니까?
					           <br><br>
					            <form action="<%= contextPath %>/delete.shippingLocation.jw" id = "deleteSl" method="post">
								<input type="hidden" name="memNo" value="<%= loginMember.getMemNo() %>">
								<input type="hidden" name="sno" value="<%= sl.getShippingNo() %>">
					           <button type="submit" class="btn btn-primary">확인</button>
					           </form>
					        </div>
					        
					    </div>
					    </div>
					</div>
						
			<%} %>
			
		<!------------------------------------------------------------------------------- -->
		


</body>
</html>