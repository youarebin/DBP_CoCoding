<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
</head>
<body>
    <header>
        <nav>
            <ul class="header">
                <div class="left">
                    <li><a href="<%= request.getContextPath() %>/Main.jsp">Main</a></li>
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/book/BookList.jsp">BookList</a></li>
                </div>
                <div class="right">
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/user/LoginForm.jsp">Login</a></li>
                    <li><a href="<%= request.getContextPath() %>/WEB-INF/user/RegisterForm.jsp">SignUp</a></li>
                </div>
            </ul>
        </nav>
    </header>

    <main>
        <div class="form-container">
            <form class="login-form" action="<%= request.getContextPath() %>/user/login" method="post">
                <h1>로그인</h1>

                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" placeholder="이메일 입력" required>
                </div>

                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" placeholder="비밀번호 입력" required>
                </div>

                <div class="form-group">
                    <button type="submit">로그인</button>
                </div>

                <div class="link-group">
                    <a href="<%= request.getContextPath() %>/WEB-INF/user/Register.jsp">회원가입</a>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
