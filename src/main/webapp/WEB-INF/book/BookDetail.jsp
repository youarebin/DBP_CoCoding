<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.domain.Book" %>
<%@page import="model.dao.BookDAO" %>
<html lang="ko">
<head>
    <title>책 정보 상세 페이지</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel=stylesheet href="<c:url value='/css/bookDetail.css' />" type="text/css">
</head>
<body>
<header>
	<nav>
		<ul class="header">
			<div class="left">
				<li><a href="<c:url value='/user/main'></c:url>">Main</a></li>
				<li><a href="<c:url value='/book/list'></c:url>">BookList</a></li>
            </div>
			<div class="right">
				<!-- 회원가입 & 로그인 안했을 시  -->
				<% if(session.getAttribute("customerId") == null) { %>
					<li><a href="<c:url value='/user/signup'></c:url>">SignUp</a></li>
					<li><a href="<c:url value='/user/login'></c:url>">Login</a></li>
				<% } else { %> 
					<li><a href="<c:url value='/user/logout'></c:url>">Logout</a></li>
				<%} %>
					<li><a href="<c:url value='/user/myPage'></c:url>">MyPage</a></li>
				
			</div>
		</ul>
	</nav>
</header>
<h2>책 정보 상세 페이지</h2>
<div class="container">
    <div class="book-detail">
        <div class="book-image">
            <img src="${bookDetail.bookImg}" alt="책 사진" />
        </div>
        <div class="book-info">
            <h2>${bookDetail.bookTitle}</h2>
            <p><span class="bold">출판사:</span> ${bookDetail.publisher}</p>
            <p><span class="bold">저자:</span> ${bookDetail.author}</p>
            <p><span class="bold">카테고리:</span> ${bookDetail.category}</p>
            <p><span class="bold">사용 기간:</span> ${bookDetail.usagePeriod}</p>
            <p><span class="bold">출판일:</span> ${bookDetail.publishedDate}</p>
        </div>
    </div>
    
    <hr>

    <div class="trade-info">
        <div><span class="bold">거래 희망 장소:</span> ${bookDetail.desiredLocation}</div>
        <div><span class="bold">가격:</span> ${bookDetail.desiredPrice}</div>
    </div>

    <div class="apply-button">
        <form action="${pageContext.request.contextPath}/book/apply/form" method="get">
            <input type="submit" value="신청하기" />
        </form>
    </div>
</div>
</body>
</html>
