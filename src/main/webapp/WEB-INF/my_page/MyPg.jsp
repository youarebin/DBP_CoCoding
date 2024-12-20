<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>마이 페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/myPg.css' />" type="text/css">
</head>
<body>
<header>
	<nav>
		<ul class="header">
			<div class="left">
				<li><a href="<c:url value='/user/main'></c:url>">Main</a></li>
				<li><a href="<c:url value='/book/list'></c:url>">BookList</a></li>
            </div>
			<div class="right">
				<!-- 회원가입 & 로그인 안했을 시  -->
				<% if(session.getAttribute("customerId") == null) { %>
					<li><a href="<c:url value='/user/register'></c:url>">SignUp</a></li>
					<li><a href="<c:url value='/login'></c:url>">Login</a></li>
				<% } else { %> 
					<li><a href="<c:url value='/user/logout'></c:url>">Logout</a></li>
					<li><a href="<c:url value='/user/myPage'></c:url>">MyPage</a></li>
				<%} %>
			</div>
		</ul>
	</nav>
</header>
<h2>마이 페이지</h2>
<div id="container">
	<div class="btnWrapper">
		<form action="${pageContext.request.contextPath}/book/register/form" method="GET">
			<input type="submit" value="책 등록" class="btn1" />
		</form>
		<form action="${pageContext.request.contextPath}/user/updateUser" method="GET">
			<input type="submit" value="정보 수정" class="btn1" />
		</form>
	</div>
	
	<hr>
	
	<div class="content">
		<div class="transactionTitle">거래 내역</div>
		<div class="btnWrapper2">
			<form action="${pageContext.request.contextPath}/book/sold/list" method="GET">
				<input type="submit" value="거래한 책 리스트" class="btn2" />
			</form>
			<form action="${pageContext.request.contextPath}/book/purchased/list" method="GET">
				<input type="submit" value="신청한 책 리스트" class="btn2" />
			</form>
		</div>
	</div>
</div>
</body>
</html>
