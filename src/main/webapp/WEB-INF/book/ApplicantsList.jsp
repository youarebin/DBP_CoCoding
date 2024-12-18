<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>신청자 리스트</title>
    <link rel="stylesheet" href="style.css">
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
    <h2>신청자 리스트</h2>
</header>
<table>
    <thead>
        <tr>
            <th> </th>
            <th>이름</th>
            <th>이메일</th>
            <th>거래희망장소</th>
            <th>희망가격</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="applicant" items="${applicants}">
            <tr>
                <td>${loop.index + 1}</td>
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
