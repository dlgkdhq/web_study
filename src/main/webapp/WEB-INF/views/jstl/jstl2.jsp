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

	하나 &nbsp;&nbsp;&nbsp;&nbsp; 둘
	<!-- &nbsp; 띄어쓰기 -->
	<br> 
	${msg1}
	<br> 
	${msg2}
	<br> 
	<%-- ${msgXml} --%>
	<br>
	
	<c:out value="${msgXml}" escapeXml="true"/> <!-- Xml을 탈출한다! false로 하면 그냥 쓰는거랑 다를게 없음 -->
	<br>
	<c:out value="${msg1}" escapeXml="true"/>
	<br>
	<c:out value="${msg2}" escapeXml="true"/>
	
	<br>
	<a href="/jstl1">jstl1 페이지로 이동</a>
	
	<button id="btn">jstl1 페이지로</button> <!-- js script 방식 -->
	
	<c:url var="jstl1Url" value="/jstl1"></c:url> <!-- jstl 방식 -->
	<br>
	<a href="${jstl1Url}">jstl url</a>
	
	<%-- <c:redirect url="http://www.naver.com"></c:redirect> --%> <!-- url에 써있는 사이트로 가게 하는게 redirect, 사용빈도 낮음-->

	<script>
		document.getElementById('btn').addEventListener('click', ()=>{
			location.href="/jstl1";
			//location.href="http://coupang.com"; /* redirect랑 같은 방식 */
		})
	</script>
	
</body>
</html>