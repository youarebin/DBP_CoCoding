<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>책 등록 폼</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/bookApply.css' />" type="text/css">
</head>
<body>
<nav class="header">
	<a>">Main</a>
	<a>">Book</a>
	<a>">SignUp</a>
	<a>">Login</a>
	<a>">MyPage</a>
</nav>
<form name="form" method="POST" action="<c:url value='/book/apply' />">
	<h2>책 신청 폼</h2>
	<table>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" />
			</td>
		</tr>
		<tr>
			<td>제시 가격</td>
			<td>
				<input type="text" name="desiredPrice" />
			</td>
		</tr>
		<tr>
			<td>거래 희망 장소</td>
			<td>
				<input type="text" name="desiredLocaiton"/>
			</td>
		</tr>
		<tr>
			<td>기타</td>
			<td>
				<textarea name="description" rows="4" cols="50" maxlength="200"></textarea>
			</td>
		</tr>
	</table>
	<div>
		<input type="button" value="취소" />
		<input type="button" value="신청" />
	</div>
</form>
</body>
</html>