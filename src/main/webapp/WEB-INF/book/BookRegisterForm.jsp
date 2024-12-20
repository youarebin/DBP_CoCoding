<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>책 등록 폼</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/bookRegister.css' />" type="text/css">
<script>
function bookCreate() {
	if(form.bookImg.value == "") {
		alert("이미지를 등록하세요");
		form.bookImg.focus();
		return false;
	}
	if(form.bookTitle.value == "") {
		alert("책 제목을 입력해주세요");
		form.bookTitle.focus();
		return false;
	}
	if(form.author.value == "") {
		alert("저자를 입력해주세요");
		form.author.focus();
		return false;
	}
	if(form.publisher.value == "") {
		alert("출판사를 입력해주세요");
		form.publisher.focus();
		return false;
	}
	if(form.publishedDate.value == "") {
		alert("출판일을 입력해주세요");
		form.publishedDate.focus();
		return false;
	}
	if(form.usagePeriod.value == "") {
		alert("사용기간을 입력해주세요");
		form.usagePeriod.focus();
		return false;
	}
	if(form.category.value == "") {
		alert("카테고리를 선택해주세요");
		form.category.focus();
		return false;
	}
	if(form.desiredLocation.value == "") {
		alert("거래 희망 장소를 입력해주세요");
		form.desiredLocation.focus();
		return false;
	}
	if(form.desiredPrice.value == "") {
		alert("희망 가격을 입력해주세요");
		form.desiredPrice.focus();
		return false;
	} else if (isNaN(form.desiredPrice.value)) {
	    alert("희망 가격은 숫자로 입력해주세요");
	    form.desiredPrice.focus();
	    return false;
	}
	
	return true;
}

function cancelForm() {
    // 마이페이지로 리다이렉트
    window.location.href = '/user/myPage';
}
</script>
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
					<li><a href="<c:url value='/user/register'></c:url>">SignUp</a></li>
					<li><a href="<c:url value='/login'></c:url>">Login</a></li>
				<% } else { %> 
					<li><a href="<c:url value='/user/logout'></c:url>">Logout</a></li>
					<li><a href="<c:url value='/user/myPage'></c:url>">MyPage</a></li>
				<%} %>
			</div>
		</ul>
	</nav>
</header>
<form name="form" method="POST" action="<c:url value='/book/register' />" enctype="multipart/form-data">
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
				<div class="price-input">
					<input type="text" name="desiredPrice"/>
					<span>원</span>
				</div>
			</td>
		</tr>
	</table>
	<div class="buttonWrapper">
		<input type="button" value="취소" onClick="cancleForm()" />
		<input type="submit" value="등록" onClick="return bookCreate()" />
	</div>
</form>
</body>
</html>