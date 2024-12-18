<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>마이 페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/MyPg.css" rel="stylesheet">
</head>
<body>
	<nav class="header">
		<a href="#">Main</a> 
		<a href="#">Book</a>
	</nav>
	<hr>
	<div class="allInfo">
		<div class="profileInfo">
			<% 
				String userId = "123"; 
            	String nickname = "nickname";
            	String name = "realname";
            	String birthdate = "0000/00/00";
            	String phone = "000-000-000";
            	String email = "aaaa@email";
            	String address = "aaaa";

            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb", "dbp2024", "TIGER");
                 PreparedStatement pstmt = conn.prepareStatement("SELECT nickname, name, birthdate, phone, email, address FROM users WHERE id = ?")) {
                pstmt.setString(1, userId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        nickname = rs.getString("nickname");
                        name = rs.getString("name");
                        birthdate = rs.getString("birthdate");
                        phone = rs.getString("phone");
                        email = rs.getString("email");
                        address = rs.getString("address");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            %>
			<div class="nickName"><%= nickname %></div>
			<div class="realName"><%= name %></div>
			<div class="birthDate"><%= birthdate %></div>
		</div>

		<div class="info">
			<div class="infoBtn">
				<a href="#" class="bookmarkBtn">나의 북마크</a> 
				<a href="#" class="purchaseBtn">구매내역 조회</a>
			</div>
			<div class="infoTable">
				<table>
					<tr>
						<td class="infoTitle">전화번호</td>
						<td><%= phone %></td>
					</tr>
					<tr>
						<td class="infoTitle">이메일</td>
						<td><%= email %></td>
					</tr>
					<tr>
						<td class="infoTitle">주소지</td>
						<td><%= address %></td>
					</tr>
				</table>
			</div>

			<a href="MyPageEdit.jsp" class="editBtn">정보 수정</a>
		</div>
	</div>
</body>
</html>
