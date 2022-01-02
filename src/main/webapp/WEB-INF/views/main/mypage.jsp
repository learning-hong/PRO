<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

	<div class="container" align="center">
		<h1 class="text-primary">마이페이지</h1>
		<br>
		<!--/HGROUP-->
		<table class="table table-striped">

			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>이메일</td>

				<td>프로필사진</td>


			</tr>


			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td><img alt=""
					src="${path }/resources/images/${member.memberPhoto}" height="300">
				</td>
			</tr>
			
		</table>
			<div align="center">
				<%-- <td><input type="button" value="수정하기"
					onclick="location.href='${path }/updateForm.do?id=${member.id}'"></td>
				<td><input type="button" value="탈퇴하기"
					onclick="location.href='memberDelete.do?id=${member.id}'"></td> --%>
				<td><a class="btn btn-default" href="main.do">메인으로 돌아가기</a></td>
				
				</div>
	</div>

</body>
</html>