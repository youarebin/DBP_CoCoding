<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/myPgEdit.css' />" type="text/css">
<script>
function updateInfo() {
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	
	form.submit();
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
<h2>정보 수정 페이지</h2>
<form name="form" method="POST" action="<c:url value='/user/updateUser' />">
	<h2>정보 수정 폼</h2>
	<table>
		<tr>
			<td>프로필 사진</td>
			<td>
				<input type="file" name="profileImage" value="${user.profileImage }"/>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="userId" value="${user.userId }" />
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" value="${user.password }" />
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="${user.name }"/>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="email" name="email" value="${user.email }" />
			</td>
		</tr>
		<tr>
			<td>닉네임</td>
			<td>
				<input type=text name="nickName" value="${user.nickName }"/>
			</td>
		</tr>
		<tr>
			<td>계좌번호</td>
			<td>
				<input type="text" name="account" value="${user.account }"/>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="text" name="phoneNumber" value="${user.phoneNumber }"/>
			</td>
		</tr>
	</table>
	<div class="buttonWrapper">
		<input type="button" value="취소" onClick="cancleForm()" />
		<input type="button" value="수정" onClick="updateInfo()" />
	</div>
</form>
</body>
</html>