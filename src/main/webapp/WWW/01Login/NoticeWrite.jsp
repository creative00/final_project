<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">    
	<script type="text/javascript">
	function validateForm(form) {  // 폼 내용 검증
	    if (form.name.value == "") {
	        alert("작성자를 입력하세요.");
	        form.name.focus();
	        return false;
	    }
	
	    if (form.title.value == "") {
	        alert("제목을 입력하세요.");
	        form.title.focus();
	        return false;
	    }
	    if (form.content.value == "") {
	        alert("내용을 입력하세요.");
	        form.content.focus();
	        return false;
	    }
	    
	    if (form.pass.value == "") {
	        alert("비밀번호를 입력하세요.");
	        form.content.focus();
	        return false;
	    }
	}
	</script>

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
			width: 180px;
		}
		.nav-item3 {
			width: 220px;
		}
		.nav-item4 {
			width: 220px;
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
					<a class="nav-link" onclick="location.href='AboutBi.jsp';" style="font-size: 35px;" href="#">About</a>
				</li>
				<li class="nav-item3">
					<a class="nav-link" style="font-size: 35px;" onclick="location.href='.../Location.jsp';"  href="#">Location</a>
				</li>
				<li class="nav-item4">
				 	<a class="nav-link active" onclick="location.href='./www.noticeboard/list.do';"style="font-size: 35px;" href="#">Notice</a>
		    </ul>
	  	</div>
	</nav>
	<div id="nav">
	</div>
	<table border="0" >
		
		</a>
		<div id="section">
			
		</div>
	</table>
	<!-- 
 파일 첨부를 위한 작성폼은 아래 2가지 조건이 지켜져야 한다.
 1.전송방식(method)sms post여야 한다.
 2. 인코딩 방식(enctype)은 multipart/form-data로 지정해야 한다.
 이와 같이 <form>태그를 구성 후 전송(submit)하면 request객체로는 폼값을 받을 수 없다. 
 cos.jar 확장라이브러리가 제공하는 MultipartRequest객체를 사용해 폼값을 받아야한다.
 -->

<h2>파일 첨부형 게시판 - 글쓰기(Write)</h2>

<!--
파일첨부를 위한 작성폼은 아래 2가지가 만족되어야 한다.
1. method 
-->
	<form name="writeFrm" method="post" enctype="multipart/form-data" 
		
		action="../www.noticeboard/write.do" onsubmit="return validateForm(this);">
	    
	    <table style="border-bottom: solid 1px rgba(165, 165, 165, 165);" border="1" width="60%" align="center" padding="100px" margin="20px">
	        <tr>
	            <td> 작성자</td>
	            <td>
	                <input type="text" name="name" style="width: 150px;" />
	            </td>
	        </tr>
	        
	        <tr>
	            <td> 제목</td>
	            <td>
	                <input type="text" name="title" style="width: 90%;" />
	            </td>
	        </tr>
	        <tr>
	            <td> 내용</td>
	            <td>
	                <textarea name="content" style="width: 90%; height: 100px;"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td> 첨부 파일</td>
	            <td>
	                <input type="file" name="ofile" />
	            </td>
	        </tr>
	        <tr>
	            <td>비밀 번호</td>
	            <td>
	                <input type="password" name="pass" style="width:100px;" />
	            </td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" align="center">
	                <button type="submit">작성 완료</button>
	                <button type="reset">RESET</button>
	                <button type="button" onclick="location.href='./list.do';">
	                    목록 바로 보기</button>
	                <!-- <button type="button" onclick="location.href='./www.noticeboard/list.do';">
	                    목록 바로 보기</button> -->
	            </td>
	        </tr>
	    </table>
	    <br /><br /><br />
	</form>	
		
    <div id="nav">
		<%@ include file="../00Main/inc/link.jsp" %>
	</div>
   	
    <div id="footer">
		<%@ include file="../00Main/inc/footer.jsp" %>
		
	</div>
</body>

</html>
