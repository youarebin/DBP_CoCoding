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
				<li><a href="<c:url value='/user/main'></c:url>">Main</a></li>
				<li><a href="<c:url value='/book/list'></c:url>">BookList</a></li>
            </div>
			<div class="right">
				<!-- 회원가입 & 로그인 안했을 시  -->
				<% if(session.getAttribute("customerId") == null) { %>
					<li><a href="<c:url value='/user/register'></c:url>">SignUp</a></li>
					<li><a href="<c:url value='/user/login'></c:url>">Login</a></li>
				<% } else { %> 
					<li><a href="<c:url value='/user/logout'></c:url>">Logout</a></li>
				<%} %>
					<li><a href="<c:url value='/user/myPage'></c:url>">MyPage</a></li>
				
			</div>
		</ul>
	</nav>
</header>
<h2>책 리스트 페이지</h2>
<!-- 책 리스트 출력 -->
<div class="book-list-wrapper">
	<c:forEach var="book" items="${bookList}">
		<a href="<c:url value='/book/detail'><c:param name='id' value='${book.bookId}'/></c:url>">
			<div class="book-item">
				<img src="/upload/${book.bookImg}" alt="${book.bookTitle}" />
				<div class="item-content">
					<div><span class="book-info-bold">제목:</span> ${book.bookTitle }</div>
					<div><span class="book-info-bold">출판사:</span> ${book.publisher }</div>
					<div><span class="book-info-bold">카테고리:</span> ${book.category }</div>	
					<div><span class="book-info-bold">가격:</span> ${book.desiredPrice }₩</div>	
				</div>
			</div>	
		</a>
	</c:forEach>
</div>
</body>
</html>