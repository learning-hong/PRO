<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">게시글 수정</h2>
			<form action="boardUpdate.do" method="post" enctype="multipart/form-data"> 
				<input type="hidden" name="pageNum" value="${pageNum}">
				<table class="table table-bordered">
					<tr>
						<td>게시글 번호</td>
						<td><input type="number" name="bid" readonly="readonly" value="${board.bid}" ></td>
					</tr>
					<tr>
						<td>수정할 제목</td>
						<td><input type="text" name="title" required="required" value="${board.title}" ></td>
					</tr>
					<tr> 
						<td>수정할 내용</td>
						<td><input type="text" name="content" required="required" value="${board.content }"></td>
					</tr>
					

					<tr> 
						<td>수정할 사진</td>
						<td><input type="file" name="file"><img alt="" src="resources/images/${board.fileName }"></td>
					</tr>
					
					
					<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						class="btn btn-success"></td>
					</tr>
					

				</table>
			</form>
			<a href="boardList.do" class="btn btn-info">게시글 목록</a>
			
	</div>
</body>
</html>