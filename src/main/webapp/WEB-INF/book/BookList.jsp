<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>책 리스트 페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/bookList.css' />" type="text/css">
</head>
<body>
<header>
	<nav>
		<ul class="header">
			<div class="left">
				<li><a href="index.html">Main</a></li>
				<li><a href="itemlist.html">BookList</a></li>
            </div>
			<div class="right">
				<li><a href="signup.html">SignUp</a></li>
				<li><a href="login.html">Login</a></li>
				<li><a href="login.html">MyPage</a></li>
				
			</div>
		</ul>
	</nav>
</header>
<!-- 책 리스트 출력 -->
<div class="book-list-wrapper">
<c:forEach var="book" items="${bookList}">
	<div class="book-item">
		<img src="${book.bookImg}" alt="${book.bookTitle}" />
		<p>제목: ${book.bookTitle }</p>
		<p>출판사: ${book.publisher }</p>
		<p>카테고리: ${book.category }</p>
	</div>
</c:forEach>
</div>
</body>
</html>