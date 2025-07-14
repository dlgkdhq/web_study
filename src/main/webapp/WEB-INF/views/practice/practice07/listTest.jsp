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

	<c:if test="${type == 'str'}">
		<c:forEach var="i" begin="1" end="10" step="1">
			<!-- <p>스트링 리스트입니다</p> -->
			<p>${msg}</p>
		</c:forEach>
	</c:if>
	
	<c:if test="${type == 'member'}">
		<c:forEach var="m" items="${memberList}">
			<p>${m.id} ${m.pw} ${m.name}</p>
		</c:forEach>
	</c:if>
	
</body>
</html>