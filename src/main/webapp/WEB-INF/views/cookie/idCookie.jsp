<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>idCookie</h1>
	
<!-- 	<form action="/idCookie" method="post">  그냥 경로만 쓰면 내가 가장 최근에 접속했던 경로 -->
	<form action="" method="post">	<!-- action 안쓰면 현재 경로에.. -->
	
		아이디 : <input type="text" name="id" value="${remember}"> <br>
		비번 : <input type="password" name="pw"> <br>
		아이디 기억 <input type="checkbox" name="remember" value="true" 
			<c:if test="${remember != null}">checked</c:if>
		> <br>
		
		<button type="submit">로그인</button>
	</form>
	
</body>
</html>