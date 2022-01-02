<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class=>게시글 입력</h2>
		<form action="boardInsert.do" method="post" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" : 여러개의 파일을등록 -->
			<table class="table table-bordered">

				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" required="required"></td>
				</tr>
				
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" required="required"></td>
				</tr>

				<tr>
					<td>내용</td>
					<td><input type="text" name="content" required="required">
					</td>
				</tr>
				
				<tr>
				<td>사진<Span class="glyphicon glyphicon-picture"></Span></td>
				<td><input type="file" name="file" required="required"  ></td>
				<tr>
				
				<!-- 멀티 기능 -->
				<!--  <tr>
				<td>사진<Span class="glyphicon glyphicon-picture"></Span></td>
				<td><input type="file" name="file" required="required" multiple="multiple"></td>
				<tr>  
				 -->

				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						class="btn btn-success"></td>
				</tr>
			</table>

		</form>




	</div>
</body>
</html>