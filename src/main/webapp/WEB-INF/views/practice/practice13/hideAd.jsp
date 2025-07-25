<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ad-display-hide {
		display : none;
	}
</style>
</head>
<body>
	<h1>hideAd</h1>

	<!-- HTML 주석 -->
	<%-- JSP 서버 주석 --%>

	<c:if test="${check == null}">
		<form action="/practice13/hideAd" method="post" id="adForm">
			<h2>광고</h2>
			<label>24시간 보지 않기<input type="checkbox" name="check" id="chk_hide"></label>
			<button type="submit">닫기</button>
		</form>
	</c:if>

	<h2>해당 페이지 표시 내용 X광고아님X</h2>

	<script>
		const adForm = document.getElementById("adForm");
		const chkHide = document.getElementById("chk_hide");
		
		adForm.addEventListener("submit", (e)=>{
			e.preventDefault();
			
			//checkbox 체크 O -> form 요청 -> 서버 Post
			//checkbox 체크 X -> 일시적으로 안보이게 -> displa:none;
			
			if(chkHide.checked){ // check O
				adForm.submit();
			} else { // check X
				//adForm.style.display = 'none';
				adForm.classList.add('ad-display-hide');
			}
		});
		
	</script>

</body>
</html>