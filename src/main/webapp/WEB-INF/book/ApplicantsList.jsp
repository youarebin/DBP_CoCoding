<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>신청자 리스트</title>
    <link rel="stylesheet" href="applicantsList.css">
</head>
<body>
<header>
    <nav>
        <ul class="header">
            <div class="left">
                <li><a href="main.jsp">Main</a></li>
                <li><a href="bookList.jsp">Book</a></li>
            </div>
            <div class="right">
                <li><a href="JoinForm.jsp">SignUp</a></li>
                <li><a href="loginForm.jsp">Login</a></li>
                <li><a href="myPage.jsp">MyPage</a></li>
            </div>
        </ul>
    </nav>
</header>
<div class="container">
    <h2>신청자 리스트</h2>
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
                    <td>${status.index + 1}</td>
                    <td>${applicant.name}</td>
                    <td>${applicant.email}</td>
                    <td>${applicant.location}</td>
                    <td>${applicant.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
