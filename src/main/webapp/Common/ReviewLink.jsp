<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="90%"> 
    <tr>
        <td align="center">
        <!-- 로그인 여부에 따른 메뉴 변화 -->
        <% if (session.getAttribute("UserId") == null) { %>
            <a href="../WWW/01Login/LoginMain.jsp">로그인</a>
        <% } else { %>
            <a href="../WWW/01Login/Logout.jsp">로그아웃</a>
        <% } %>
            <!-- 8장과 9장의 회원제 게시판 프로젝트에서 사용할 링크 -->
            &nbsp;&nbsp;&nbsp; 
            <a href="../WWW/051ReviewBoard/ReviewList.jsp">Review게시판(페이징O)</a>
            &nbsp;&nbsp;&nbsp; 
            <a href="../WWW/01Login/NoticeMain.jsp">Notice게시판(페이징O)</a>
        </td>
    </tr>
</table>

	

</body>
</html>