<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/MyPgEdit.css" rel="stylesheet">
<script>
let modified = false;

document.addEventListener('DOMContentLoaded', () => {
    const inputs = document.querySelectorAll('input');
    inputs.forEach(input => {
        input.addEventListener('input', () => {
            modified = true;
        });
    });

    window.addEventListener('beforeunload', (event) => {
        if (modified) {
            event.preventDefault();
            event.returnValue = '';
        }
    });
});
    
    </script>
</head>

<body>
	<nav class="header">
		<a href="#">Main</a> 
        <a href="#">Book</a>
	</nav>
	<hr>
	<div class="allInfo">
		<div class="profileInfo">
			<div class="editText">
				<input type="text" class="nickName" value="<%= request.getParameter("nickname") %>"> 
				<input type="text" class="realName" value="<%= request.getParameter("name") %>"> 
				<input type="text" class="birthDate" value="<%= request.getParameter("birthdate") %>">
			</div>
		</div>

		<div class="info">
			<div class="infoTable">
				<table>
					<tr>
						<td class="infoTitle">전화번호</td>
						<td><input type="text" value="<%= request.getParameter("phone") %>"></td>
					</tr>
					<tr>
						<td class="infoTitle">이메일</td>
						<td><input type="text" value="<%= request.getParameter("email") %>"></td>
					</tr>
					<tr>
						<td class="infoTitle">주소지</td>
						<td><input type="text" value="<%= request.getParameter("address") %>"></td>
					</tr>
				</table>
			</div>

			<a href="MyPage.html" class="saveBtn">저장하기</a>
		</div>
		<% 
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String userId = "123"; 
            String nickname = request.getParameter("nickname");
            String name = request.getParameter("name");
            String birthdate = request.getParameter("birthdate");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "password");
                 PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE users SET nickname = ?, name = ?, birthdate = ?, phone = ?, email = ?, address = ? WHERE id = ?")) {
                pstmt.setString(1, nickname);
                pstmt.setString(2, name);
                pstmt.setString(3, birthdate);
                pstmt.setString(4, phone);
                pstmt.setString(5, email);
                pstmt.setString(6, address);
                pstmt.setString(7, userId);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    %>
	</div>
</body>
</html>