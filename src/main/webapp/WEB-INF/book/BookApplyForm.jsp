<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>책 등록 폼</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/bookApply.css' />" type="text/css">
<script>
let inputCount = 0; // 글자 수 저장 변수

// 글자수 계산 함수
const onInputHandler = (e) => {
    inputCount = e.target.value.length;
    document.getElementById("charCount").textContent = inputCount + "/200"; // 글자 수 업데이트
};

function bookApply() {
	if(form.name.value == "") {
		alert("이름을 입력하세요");
		form.name.focus();
		return false;
	}
	if(form.email.value == "") {
		alert("이메일을 입력해주세요");
		form.email.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	if(form.desiredLocaiton.value == "") {
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
	
	form.submit();
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
<form name="form" method="POST" action="<c:url value='/book/apply' />">
	<h2>책 신청 폼</h2>
	 <!-- bookId를 hidden 필드로 추가 -->
	<input type="hidden" name="bookId" value="<%= request.getAttribute("bookId") %>" />
	
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
			<td>거래 희망 장소</td>
			<td>
				<input type="text" name="desiredLocaiton"/>
			</td>
		</tr>
		<tr>
			<td>제시 가격</td>
			<td>
				<div class="price-input">
					<input type="text" name="desiredPrice"/>
					<span>원</span>
				</div>
			</td>
		</tr>
		<tr>
			<td>기타</td>
			<td>
				<textarea 
				name="description" 
				rows="4" 
				cols="50" 
				maxlength="200"
				oninput="onInputHandler(event)">
				</textarea>
				<div id="charCount">0/200</div>
			</td>
		</tr>
	</table>
	<div class="buttonWrapper">
		<input type="button" value="취소" onClick="cancleForm()" />
		<input type="button" value="신청" onClick="bookApply()" />
	</div>
</form>
</body>
</html>