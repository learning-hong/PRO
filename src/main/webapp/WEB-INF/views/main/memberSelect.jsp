<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
</head>
<body>
	<!--WRAP-->
	<section id="wrap">
		<!--HGROUP-->
		
		<!--/HGROUP-->
		<table class="table table-bordered">
			<caption class="text-primary">
				<h2>회원상세정보</h2>
			</caption>
			<tr>
				<th>아이디</th>
				<td>${member.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email }</td>
			</tr>
			<tr>
				<th>프로필 사진</th>
				<td><img src="${path}/resources/images/${member.memberPhoto }"
					height="300"></td>
			</tr>
		</table>
	</section>
</body>
</html>