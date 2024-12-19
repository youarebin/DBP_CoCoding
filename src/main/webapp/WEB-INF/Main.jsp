<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>메인 페이지</title>
    <link rel="stylesheet" href="css/mainPage.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="Main.jsp">홈</a></li>
                <li><a href="BookList.jsp">책 목록</a></li>
                <li><a href="LoginForm.jsp">로그인</a></li>
            </ul>
        </nav>
    </header>
    <h1>${user.nickname}님 환영합니다!</h1>
    <form action="/search" method="get">
        <input type="text" name="search" placeholder="책 제목을 검색하세요">
        <button type="submit">검색</button>
    </form>
    <div>
        <h2>추천 책 목록</h2>
        <!-- 책 리스트 동적 출력 -->
        <c:forEach var="book" items="${bookList}">
            <div>
                <h3>${book.title}</h3>
                <p>${book.author}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>