<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope2</h1>
	<p>${requestMsg}</p>
	<p>${requestScope.requestMsg}</p>
	
	<p>${sessionMsg}</p>
	<p>${sessionScope.sessionMsg}</p>

	<!-- 이름이 혹시 겹치면 requestScope.xxx , sessionScope.xxx 로 구분해주면 됨 
	이렇게 안쓰면 가까운거로 인식함 request부터.. 
	영역 크기 : request < session < application -->
	
	<p>${applicationMsg}</p>
	<p>${applicationScope.applicationMsg}</p>
</body>
</html>