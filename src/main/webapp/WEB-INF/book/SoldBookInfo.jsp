<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>판매한 책 정보</title>
    <link rel="stylesheet" href="bookInfo.css">
</head>
<body>

<nav class="header">
    <a href="main.jsp">Main</a>
    <a href="PurchasedBookList.jsp">Book</a>
    <a href="JoinForm.jsp">SignUp</a>
    <a href="loginForm.jsp">Login</a>
    <a href="myPage.jsp">MyPage</a>
</nav>

<header>
    <h2>판매한 책 정보</h2>
</header>

<div class="book-info">
    <img src="${book.image}" alt="책 사진" />
    <div class="book-details">
        <p><strong>저자:</strong> ${book.author}</p>
        <p><strong>출판사:</strong> ${book.publisher}</p>
        <p><strong>가격:</strong> ${book.price}</p>
        <c:if test="${not empty book.isSold}">
            <a href="ApplicantsList.jsp" class="button">신청자 리스트</a> 
        </c:if>
    </div>
</div>

<div class="navigation">
    <a href="SoldBookList.jsp" class="button">뒤로 가기</a>
</div>

</body>
</html>
