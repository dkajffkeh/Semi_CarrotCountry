<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.*
			   , com.javachip.carrotcountry.coBuying.model.vo.*"
 %>    

<%
	PostBoard pb = (PostBoard)request.getAttribute("pb");
	QnA qa = (QnA)request.getAttribute("qa");
%>     
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<style>

/* 전반적인 큰 틀*/
.wrap{width:1200px;height:800px;margin:auto;}
#content{height:80%;}
#footer{height:20%; margin:10px 0px;}

 /* 콘텐트영역의 전반적인 틀 */
#content>div{width: 100%; float: left;}
#content1{height: 10%; padding: 20px;}
#content2{height: 40%;}
#content3{height: 50%;}
#content1>div{height: 100%; float:left}
#content2>div{height: 100%; float:left}

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

/* 사용자 질문글 */
#question{margin: 30px;}
#question>thead{
    background: lightgray;
    text-align: center;
    font-weight: 600;
    height: 50px;
}

/* 답변 에디터 */
#editorTable{margin: 30px;}
#editorTable>thead{
    background: lightgray;
    text-align: center;
    font-weight: 600;
    height: 50px;
}
#writeBtn{
    display: inline-block;
    margin: 85px;
}


</style>

</head>
<body>

<%@ include file="../common/commonNavbar.jsp"%>

    <div class="wrap">
        <div id="content1">
            <div id="title">
                <h5 align="center">Q & A 답변하기</h5>
            </div>
        </div>
        <form id="answerEnrollForm" action="<%= contextPath %>/sellerinsert.qna.jy">
         <br><br><br>
          <div id="btnArea">
              <button id="writeBtn" class="btn btn-secondary" style="float: right;">등록하기</button>
          </div>
        <div id="content2" align="center">
            <table id="question" width="1000" class="table-bordered">
                <thead>
                    <tr>
                        <td colspan="4">질문글</td>
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
                        <td colspan="4" height="200"><%= qa.getGqContent() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div id="content3" align="center">

            <!-- 에디터 -->
            <table id="editorTable" width="1000" class="table-bordered">
                <thead>
                    <tr>
                        <td>답변입력</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <textarea name="content" id="editor" style="min-height: 500px;"></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>
		</form>
    </div>

    <script>
        ClassicEditor
            .create( document.querySelector( '#editor' ) , {
               
                removePlugins: ['ImageUpload']
            } )  
            .catch( error => {
                console.error( error );
            } );

        </script>


<%@ include file="../common/footerbar.jsp"%>

</body>
</html>