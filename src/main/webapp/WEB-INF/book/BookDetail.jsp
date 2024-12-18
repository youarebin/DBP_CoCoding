<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>책 정보 상세 페이지</title>
    <link rel="stylesheet" href="">
</head>
<body>
<nav class="header">
	<a>">Main</a>
	<a>">Book</a>
	<a>">SignUp</a>
	<a>">Login</a>
	<a>">MyPage</a>
</nav>
<header>
    <h2>책 정보 상세 페이지</h2>
</header>

<div class="book-detail">
    <div class="book-image">
        <img src="${book.image}" alt="책 사진" />
    </div>
    <div class="book-info">
        <h2>${book.title}</h2>
        <p>출판사: ${book.publisher}</p>
        <p>사용기간: ${book.usagePeriod}</p>
        <p>카테고리: ${book.category}</p>
    </div>
</div>

<hr>

<div class="trade-info">
    <label for="location">거래희망 장소:</label>
    <input type="text" id="location" name="location" /><br />

    <label for="price">희망 가격:</label>
    <input type="text" id="price" name="price" /><br />

    <label for="notes">기타내용:</label>
    <textarea id="notes" name="notes"></textarea><br />
</div>

<div class="apply-button" style="text-align: center;">
    <form action="BookApplyForm.jsp" method="post">
        <input type="submit" value="신청하기" />
    </form>
</div>

</body>
</html>
