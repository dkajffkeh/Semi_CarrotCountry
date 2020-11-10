<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.javachip.carrotcountry.coBuying.model.vo.*"
 %>    

<%
	QnAHY qa = (QnAHY)request.getAttribute("qa");
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
#content1{height: 10%; padding: 20px;}
#content2{height: 80%;}
#tableArea{
    margin-top: 150px;
    margin-bottom: 100px;
}

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
    color: gray;
}

/* 질문 */
#questionDetail{margin: 30px;}
#questionDetail>thead{
    background: lightgray;
    text-align: center;
    font-weight: 600;
    height: 50px;
}

</style>

</head>
<body>
    
<%@ include file="../common/commonNavbar.jsp"%>




    <div class="wrap">
        <div id="content">
            <div id="content1">
                <div id="title">
                    <h5 align="center">질문 상세보기</h5>
                </div>
            </div>
            <form>
            <br><br><br>
            <div id="content2"  align="center">
                <div id="tableArea">
                      <table id="questionDetail" class="table-bordered">
                        <thead>
                          <tr>
                            <td colspan="4" width="800px">
                             	 문의내용
                            </td>
                         </tr>
                            <tr>
                              <td>제목</td>
                              <td colspan="3" style="background: white;" align="left">&nbsp;&nbsp;<%= qa.getGqTitle() %></td>
                            </tr>
                            <tr>
                              <td>작성자</td>
                              <td style="background: white;"><%= qa.getMemNo() %></td>
                              <td>작성일</td>
                              <td style="background: white;"><%= qa.getGqEnrollDate() %></td>
                            </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td colspan="4" style="height:100px">
                             	  <%= qa.getGqContent() %>
                            </td>
                          </tr>
                          <tr>
                          	<td colspan="4" width="800px" align="center" style="background-color:lightblue;">
                             	 답변내용
                            </td>
                          </tr>
                          <tr>
                          	<td colspan="4">
                          	<%= qa.getGqAnswer() %>
                          	</td>
                          </tr>
                        </tbody>
                      </table>
                </div>
            </div>


            <!-- 현재 로그인한 사용자가 해당 게시글을 작성한 본인일 경우 -->
            
            <div align="center">
            <% if(loginMember != null && loginMember.getMemName().equals(qa.getMemNo())){%>
                <a href="<%= contextPath %>/buyerupdateform.qna.jy?bno=<%= qa.getGqNo() %>" class="btn btn-secondary btn-sm">수정하기</a>
                &nbsp; &nbsp;
                <a href="<%= contextPath %>/buyerdelete.qna.jy?qno=<%=qa.getGqNo()%>&bno=<%=bno%>" class="btn btn-danger btn-sm">삭제하기</a>
            <%} %>
            </div>


            </form>
        </div>

    </div>
    
    
<%@ include file="../common/footerbar.jsp"%>
</body>
</html>