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

	<h1>jstl1</h1>
	<p>${msg}</p>
	<p><c:out value="${msg}" /></p>
	
	<p>${product.id}</p>
	<p>${product.name}</p>
	
	<p>${productList[0].id} ${productList[0].name} ${productList[0].price}</p>
	<p>${productList[1].id} ${productList[1].name} ${productList[1].price}</p>
	
	<hr>
	<hr>
	
	<!-- for(int i=1; i<=5; i++) -->
	
	<!-- jstl에서의 반복문 -->
	<c:forEach var="i" begin="1" end="5" step="1">
		<p>forEach 반복 ${i}</p>
		<p>${productList[i-1].id}</p>
	</c:forEach>
	
	<!-- for(Product p : productList) -->
	<c:forEach var="p" items="${productList}">
		<div class="box">
			<p>${p.id} ${p.name} ${p.price}</p>
		</div>  <!-- 박스 단위로 반복 -->
	</c:forEach>
	
	<!-- if문st -->
	<c:choose>
		<c:when test="${drinkType == 'coffee'}">
			<p>커피를 선택하셨군요</p>
		</c:when>
		<c:when test="${drinkType == 'juice'}">
			<p>주스를 선택하셨군요</p>
		</c:when>
		<c:otherwise>
			<p>물드세여</p>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${score >= 800 && score <= 1000}">
			<p>xxxx등급</p>
		</c:when>
	</c:choose>
	
	<p>환영합니다~</p> <!-- 전체에게 보여지는 -->
	
	<c:if test="${userType == 'admin'}">
		<button>상품관리연결</button>
	</c:if> <!-- 관리자에게만 보여주는 -->
	
	<c:if test="${isLogin == true}">
		<button>로그아웃</button>
	</c:if>
	
	<c:if test="${isLogin == false}">	<!-- else 사용 못해서 반대케이스를 직접 넣어줘야함 -->
		<button>로그인</button>
	</c:if>
</body>
</html>










