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
	<h1>count</h1>
	
	<!-- jstl 방법 -->
	<c:choose>
		<c:when test="${empty loginId || loginId == '' }">
			<p>익명의 사용자 환영합니다</p>
			<p>로그인한 사용자가 없습니다</p>
		</c:when>
		<c:otherwise>
			<p>${loginId}</p>
		</c:otherwise>
	</c:choose>
	
	
	<!-- controller 자체에서 처리 -->
	<p>${loginId}</p>
	<p>접속횟수 : ${count}</p>
	
</body>
</html>