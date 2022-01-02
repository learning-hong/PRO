<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<Script type="text/javascript">
	$(function(){
		$('#boardDisp').load("boardList.do","pageNum=${pageNum}");
		
	});
</Script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">게시글 상세 내역</h2>
			<table class="table table-striped">
				<!-- 사진 추가 기능을 구현 -->

				<!-- 글 번호 -->
				<tr>
				<td>글 번호</td>
				<td colspan="3">${board.bid }</td>
				</tr>

				<!-- 제목 -->
				<tr>
				<td>제목</td>
				<td colspan="3">${board.title }</td>
				
				<!-- 조회수와 작성일 -->
				<tr>
				<td>작성일</td>
				<td>${board.regdate }</td>
				
				<!-- 구현 필요 -->
				<%-- <td>조회수</td>
				<td>${board.readcount }</td> --%>
				</tr>
				
				<!-- 내용 -->
				<tr>
				<td>내용</td>
				<td colspan="3"><pre>${board.content }</pre></td>
				</tr>
				
				<!-- 사진 -->
				
				
				<tr>
				<td>사진</td>
				<td><img src="resources/images/${board.fileName }"></td>
				</tr>
				
				
			
				<tr>
				<td colspan="2">
				<c:forEach var="fileName" items="${boar }">
						<img alt="" src="resources/upload/${fileName }" width="200">
				</c:forEach></td>
				</tr>
				
				
				<!-- 수정, 삭제 기능  -->
				<tr>
				<td colspan="4" align="center">
				<a href="boardList.do?pageNum=${pageNum }" class="btn btn-info">게시글 목록</a>
				<a href="updateBoardForm.do?bid=${board.bid}&pageNum=${pageNum }" class="btn btn-warning">수정</a> <!-- 	회원 게시글일 경우에는 deleteForm없이 삭제 확인후에 바로 삭제 -->
				<a href="deleteBoard.do?bid=${board.bid}&pageNum=${pageNum }" class="btn btn-danger">삭제</a>
				<%-- <a href="insertForm.do?num=${board.num}&pageNum=${pageNum }"class="btn btn-success">답글</a> --%>
				</td>
			</tr>
			
			
			</table>
	
		<!-- 밑에 자료 -->
		<div id="boardDisp"></div>
	</div>
	
</body>
</html>