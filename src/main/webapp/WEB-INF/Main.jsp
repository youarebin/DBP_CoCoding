<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main Page</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/mainPage.css">
</head>
<body>
    <header>
        <nav>
            <ul class="header">
                <div class="left">
                    <li><a href="<%= request.getContextPath() %>/Main.jsp">Main</a></li>
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/book/BookList.jsp">ItemList</a></li>
                </div>
                <div class="right">
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/user/LoginForm.jsp">Login</a></li>
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/user/Register.jsp">SignUp</a></li>
                </div>
            </ul>
        </nav>
    </header>

    <main>
        <section class="welcome">
            <h1>OOO님 환영합니다!</h1>
        </section>

        <section class="search">
            <h2>찾는 책을 검색하세요</h2>
            <form action="<%= request.getContextPath() %>/book/search" method="get" class="search-form">
                <input type="text" name="query" placeholder="책 제목" required>
                <button type="submit">검색</button>
            </form>
        </section>

        <section class="popular-books">
            <h2>추천 도서</h2>
            <div class="book-list">
                <div class="book-item">책 1</div>
                <div class="book-item">책 2</div>
                <div class="book-item">책 3</div>
                <div class="book-item">책 4</div>
            </div>
        </section>
    </main>
</body>
</html>
