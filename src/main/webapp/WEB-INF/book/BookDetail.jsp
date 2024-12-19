<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.domain.Book" %>
<%@page import="model.dao.BookDAO" %>
<%
    String bookIdStr = request.getParameter("id");
    int bookId = Integer.parseInt(bookIdStr);

    BookDAO bookDAO = new BookDAO();
    Book book = bookDAO.getBookInfo(bookId); 
%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>책 정보 상세 페이지</title>
    <link rel="stylesheet" href="bookDetail.css">
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
    <h2>책 정보 상세 페이지</h2>
</header>

<div class="container">
    <div class="book-detail">
        <div class="book-image">
            <img src="${book.bookImg}" alt="책 사진" />
        </div>
        <div class="book-info">
            <h2>${book.bookTitle}</h2>
            <p>출판사: ${book.publisher}</p>
            <p>저자: ${book.author}</p>
            <p>카테고리: ${book.category}</p>
            <p>사용 기간: ${book.usagePeriod}</p>
            <p>출판일: ${book.publishedDate}</p>
        </div>
    </div>

    <hr>

    <div class="trade-info">
        <label for="location">거래희망 장소:</label>
        <input type="text" id="location" name="location" />

        <label for="price">희망 가격:</label>
        <input type="text" id="price" name="price" />

        <label for="notes">기타내용:</label>
        <textarea id="notes" name="notes"></textarea>
    </div>

    <div class="apply-button">
        <form action="BookApplyForm.jsp" method="post">
            <input type="submit" value="신청하기" />
        </form>
    </div>
</div>
</body>
</html>
