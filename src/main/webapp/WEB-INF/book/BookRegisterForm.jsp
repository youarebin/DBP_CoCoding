<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>책 등록 폼</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/bookRegister.css' />" type="text/css">
</head>
<body>
<nav class="header">
	<a>">Main</a>
	<a>">Book</a>
	<a>">SignUp</a>
	<a>">Login</a>
	<a>">MyPage</a>
</nav>
<form name="form" method="POST" action="<c:url value='/book/register' />">
	<h2>책 등록 폼</h2>
	<table>
		<tr>
			<td>책 사진</td>
			<td>
				<input type="file" name="bookImg" />
			</td>
		</tr>
		<tr>
			<td>책 제목</td>
			<td>
				<input type="text" name="bookTitle" />
			</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>
				<input type="text" name="author" />
			</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>
				<input type="text" name="publisher"/>
			</td>
		</tr>
		<tr>
			<td>출판일</td>
			<td>
				<input type="date" name="publishedDate"/>
			</td>
		</tr>
		<tr>
			<td>사용기간</td>
			<td>
				<input type="text" name="usagePeriod"/>
			</td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td>
			<select name="category">
				<option value="철학">철학</option>
				<option value="종교">종교</option>
				<option value="사회과학">사회과학</option>
				<option value="순수과학">순수과학</option>
				<option value="기술과학">기술과학</option>
				<option value="예술">예술</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>거래 희망 장소</td>
			<td>
				<input type="text" name="desiredLocation"/>
			</td>
		</tr>
		<tr>
			<td>희망 가격</td>
			<td>
				<input type="text" name="desiredPrice"/>
			</td>
		</tr>
	</table>
	<div>
		<input type="button" value="취소" />
		<input type="button" value="등록" />
	</div>
</form>
</body>
</html>