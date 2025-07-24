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
	<h1>관리자 페이지</h1>
	<h2>관리자가 사용자 정보 수정하는 페이지</h2>
	
	<form action="/admin/modifyUser" method="post">
	
		<input type="hidden" name="id" value="${user.id}">
		아이디 : <input type="text" value="${user.id}" disabled><br>
		<!-- disabled를 쓰면 post 했을 때 안넘어가기 때문에.. -->
		
		<%-- 아이디 : <input type="text" name="id" value="${user.id}" readonly><br> --%>
		<!-- readonly는 같이 넘어감~ -->
		
		비번 : <input type="password" name="pw" value="${user.pw}"><br>
		이름 : <input type="text" name="name" value="${user.name}"><br>
		
		사용자 계정 타입 구분
		<br>
		<label>고객(사용자)<input type="radio" name="userType" value="CUS" <c:if test="${user.userType == 'CUS'}">checked</c:if>></label>
		<label>관리자<input type="radio" name="userType" value="ADM" <c:if test="${user.userType == 'ADM'}">checked</c:if>></label>
		<br>
		<button type="submit">수정하기</button>
		<button type="button" onClick="location.href='/admin/user/${user.id}'">취소</button>
	</form>
</body>
</html>