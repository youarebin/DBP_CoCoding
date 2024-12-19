<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.List" %>
<%@page import="model.domain.Book" %>
<%@page import="model.dao.BookDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <title>판매한 책 리스트</title>
    <link rel="stylesheet" href="soldbookList.css">
</head>
<body>
<nav class="header">
    <a href="main.jsp">Main</a>
    <a href="bookList.jsp">Book</a>
    <a href="JoinForm.jsp">SignUp</a>
    <a href="loginForm.jsp">Login</a>
    <a href="myPage.jsp">MyPage</a>
</nav>
<header>
    <h2>판매한 책 리스트</h2>
</header>

<div class="sold-books">
    <c:forEach var="book" items="${soldBooks}">
        <div class="book-item">
            <a href="BookInfoController?bookId=${book.id}">
                <img src="${book.image}" alt="책 사진" />
                <p>${book.title}</p>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
