<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>책 정보</title>
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
    <h2>책 정보</h2>
</header>

<div class="book-info">
    <div class="book-image">
        <img src="${book.image}" alt="책 사진" />
    </div>
    <div class="details">
        <h2>${book.title}</h2>
        <p>출판사: ${book.publisher}</p>
        <c:if test="${user.id == book.sellerId}">
            <form action="ApplicantsList.jsp" method="get">
                <input type="submit" value="신청자리스트" />
            </form>
        </c:if>
    </div>
</div>

</body>
</html>
