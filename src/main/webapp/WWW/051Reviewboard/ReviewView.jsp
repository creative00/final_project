<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일 첨부형 게시판 상세보기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">  

	<style>
	
		* {	
			font-family: Verdana;
		    margin: 100;
		    padding: 1000;
		    
		}
		#header {
			/*  background-color:lightgrey; */
			 height:170px;
			 width:1920px;
		}
		#nav {
			 
			 height:100px;
			 /* float: left; */
		}
		#section {
			align:center;
			height:600;
			text-align: left;
			float: right;
			background-color:red;
			
		}
		#footer {
			/* background-color: green; */
			height:120px;
			clear:both;
		}
		#header,#nav, #footer, #section { text-align:center; }
		#section {line-height : 240px;}
		.nav-item1 {
			width: 200px;
		}
		.nav-item2 {
			width: 270px;
		}
		.nav-item3 {
			width: 200px;
		}
		.nav-item4 {
			width: 250px;
		}
	</style>
</head>

<body>
	<div id="header">
	<%@ include file="../00Main/inc/top.jsp" %>
	</div>
	
	<nav class="navbar navbar-expand-sm bg-white navbar-light">
		<div class="container-fluid">
		    <ul class="navbar-nav">
		    	<li class="nav-item1">
		    	</li>
		    	<li class="nav-item2">
					<a class="nav-link" onclick="location.href='CommunityMain.jsp';" style="font-size: 35px;" href="#">Community</a>
				</li>
		    	<li class="nav-item3">
					<a class="nav-link" onclick="location.href='QandA.jsp';" style="font-size: 35px;" href="#">QandA</a>
				</li>
				<li class="nav-item4">
				 	<a class="nav-link active" onclick="location.href='./www.reviewboard/list.do';"style="font-size: 35px;" href="#">Review</a>    	
	  	</div>
	</nav>
	<!--  <h2>파일 첨부형 게시판 - 상세 보기(View)</h2> -->
	
	<table border="1" width="50%" align="center">
	    <colgroup>
	        <col width="15%"/> <col width="35%"/>
	        <col width="15%"/> <col width="*"/>
	    </colgroup> 
	    <tr>
	        <td>번호</td> <td>${ dto.r_idx }</td>
	        <td>작성자</td> <td>${ dto.user_id }</td>
	    </tr>
	    <tr>
	        <td>작성일</td> <td>${ dto.r_postdate }</td>
	        <td>조회수</td> <td>${ dto.r_visitcount }</td>
	    </tr>
	    <tr>
	        <td>제목</td>
	        <td colspan="3">${ dto.r_title }</td>
	    </tr>
	    <tr>
	        <td>내용</td>
	        <td colspan="3" height="100">${ dto.r_content }
	        	<c:if test="${ isImage eq true }">
	        		<p>
	        			<img src="../Uploads/${dto.r_sfile }" alt="" />
	        		</p>
	        	</c:if>
	        </td>
	    </tr> 
	    <tr>
	        <td>첨부파일</td>
	        <td>            
	        <!-- 첨부된 파일이 있는 경우에는 파일명과 다운로드 링크를 출력한다.
	        다운로드가 완료 후 다운로드 횟수를 1 증가시키기 위해 
	        게시물의 일련번호를 파라미터로 전달한다. -->
	        	<c:if test="${ not empty dto.r_ofile }">
				${ dto.r_ofile }
				<a href="../www.reviewboard/download.do?r_ofile=${ dto.r_ofile }&r_sfile=${ dto.r_sfile }&r_idx=${ dto.r_idx}">[다운로드]</a>        	
	        	</c:if>           
	        </td>
	         <td>다운로드수</td>
	        <td>${ dto.r_downcount }</td>
	    </tr> 
	    <tr>
	    	<!-- /WWW/01Login/www.reviewboard/pass.do	 -->		
	        <td colspan="4" align="center">
	            <button type="button" 
	            	onclick="location.href='../www.reviewboard/pass.do?mode=edit&r_idx=${ param.r_idx }';">
	                수정하기
	            </button>
	            <button type="button" onclick="location.href='../www.reviewboard/pass.do?mode=delete&r_idx=${ param.r_idx }';">
	                삭제하기
	            </button>
	            <button type="button" onclick="location.href='http://localhost:8585/Project_final/WWW/051Reviewboard/www.reviewboard/list.do';">
	                목록 바로가기
	            </button>
	        </td>
	    </tr>
	</table>
	<div id="link">
		<%@ include file="../00Main/inc/link.jsp" %>
	</div>
	<div id="footer">
		<%@ include file="../00Main/inc/footer.jsp" %>
	</div>
</body>
</html>