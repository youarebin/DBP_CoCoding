<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.List" %>
<%@page import="model.domain.Book" %>
<%@page import="model.dao.BookDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>판매한 책 리스트</title>
    <link rel="stylesheet" href="soldbookList.css">
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
					<li><a href="<c:url value='/user/signup'></c:url>">SignUp</a></li>
					<li><a href="<c:url value='/user/login'></c:url>">Login</a></li>
				<% } else { %> 
					<li><a href="<c:url value='/user/logout'></c:url>">Logout</a></li>
				<%} %>
					<li><a href="<c:url value='/user/myPage'></c:url>">MyPage</a></li>
				
			</div>
		</ul>
	</nav>
</header>
<h2>판매한 책 리스트</h2>
<div class="sold-books">
    <c:forEach var="book" items="${soldBookList}">
        <div class="book-item">
            <a href="BookInfoController?bookId=${book.bookId}">
                <img src="${book.bookImg}" alt="책 사진" />
                <p>${book.bookTitle}</p>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
