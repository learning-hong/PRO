<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
	<div>
	<a href="admin_main.do" class="btn btn-default">관리자 메인으로</a>
	<a href="${path}/loginForm.do" class="btn btn-success">로그인으로 돌아가기</a>
	</div>
	<form action="memberList.jsp">
		<table class="table table-borderd">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일</th>
				<th>가입일</th>
				<th>탈퇴여부</th>
				<th>프로필 사진</th>
				<th>강퇴</th>
			</tr>

			<c:if test="${empty memberList }">
				<tr>
					<td colspan="7">검색결과가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${not empty memberList }">
				<c:forEach var="member" items="${memberList}">
					<tr>
						<td><a class="btn btn-success"
							href="memberSelect.do?id=${member.id}">${member.name }</a></td>
						<td>${member.id}</td>
						<td>${member.email}</td>
						<td>${member.regdate}</td>
						<td>${member.del}</td>
						<td><img src="${path}/resources/images/${member.memberPhoto}"
							height="100"></td>
						<td><input type="button" value="강제탈퇴"
							onclick="location.href='memberDelete.do?id=${member.id}'"></td>
					<!-- onclick="location.href='memberDelete.do?id=${member.id}'" -->
					</tr>
				</c:forEach>
			</c:if>
		</table>

	</form>
</body>
</html>
</body>
</html>