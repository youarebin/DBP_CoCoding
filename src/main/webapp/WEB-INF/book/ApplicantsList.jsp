<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>신청자 리스트</title>
    <link rel="stylesheet" href="style.css">
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
    <h2>신청자 리스트</h2>
</header>
<table>
    <thead>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>이메일</th>
            <th>거래 희망 장소</th>
            <th>희망 가격</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="applicant" items="${applicants}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td> <!-- loop.index 대신 status.index 사용 -->
                <td>${applicant.name}</td>
                <td>${applicant.email}</td>
                <td>${applicant.location}</td>
                <td>${applicant.price}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
