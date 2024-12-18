<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <title>판매한 책 리스트</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h2>판매한 책 리스트</h2>
</header>

<div class="sold-books">
    <c:forEach var="book" items="${soldBooks}">
        <div class="book-item">
            <a href="BookInfo.jsp?bookId=${book.id}">
                <img src="${book.image}" alt="책 사진" />
                <p>${book.title}</p>
            </a>
        </div>
    </c:forEach>
</div>

</body>
</html>
