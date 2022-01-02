<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 게시글 리스트 -->
<title>Insert title here</title>
<script type="text/javascript">
		function del(bid){
			var cf = confirm("정말로 삭제 하시겠습니까?");
			if (cf) location.href = 'deleteBoard.do?bid='+bid;
			else alert("취소버튼을 누르셨습니다") ;
		}
		//like
		function likebt(bid) {
			$.post("likeupdate.do","ltbid="+bid, function(data) { // "ltbid="+bid : 좋아요글 게시물 == 글번호 일치 
				location.reload();
				// $("#tableList").html(data);
			});
		}
		
</script>
</head>
<body>

	<!-- 1. 전체 목록확인 -->
	<!-- 2. 글쓰기 -->
	<!-- 3. 내용 검색 -->
	<!-- 4. 작성자 검색 -->
	<div class="container" align="center">
		<h2 class="text-primary">게시글 목록</h2>
		<div id="tableList">
			<table class="table table-striped">
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<!-- <td>내용</td> -->
					<td>등록일</td>
					<!-- 옮겨야 함 -->
					<td>좋아요</td>
					<!-- <td>수정</td>
	<td>삭제</td> -->

				</tr>
				<c:if test="${empty boardList }">
					<tr>
						<th colspan="5">부서정보가 없습니다</th>
					</tr>
				</c:if>
				<c:if test="${not empty boardList }">
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td>${board.bid }</td>
							<!-- 제목 -->


							<td><a
								href="boardDetail.do?bid=${board.bid }&pageNum=${pb.currentPage}"
								class="btn btn-info btn-sm">${board.title }</a></td>




							<!-- 작성자 -->
							<td>${board.writer }</td>
							<%-- <td>${board.content }</td> --%>
							<!-- 등록일 -->
							<td>${board.regdate }</td>
							<!-- 좋아요 수 -->
							<%-- <td>${board.hit }</td> --%>
							<%-- <td id="like"><c:choose>
									<c:when test="${board.ltlike_stat ==1}">
										<button type="button" class="btn btn-success"
											onclick="likebt(${board.bid})">좋아요</button>
									</c:when>
									<c:when test="${board.ltlike_stat ==0}">
										<button type="button" class="btn btn-danger"
											onclick="likebt(${board.bid})">좋아요</button>
									</c:when>
								</c:choose> <span>${board.ltlike_count}</span></td>
 --%>

							<td id="like">
							<c:choose>
									<c:when test="${board.ltlike_stat ==1}">
										<button type="button" class="btn btn-light"
											onclick="likebt(${board.bid},${pb.currentPage})">
											<img src="https://img.icons8.com/ios/30/000000/like--v1.png" />
										</button>
									</c:when>
									<c:when test="${board.ltlike_stat ==0}">
										<button type="button" class="btn btn-light"
											onclick="likebt(${board.bid},${pb.currentPage})">
											<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
												width="30" height="30" viewBox="0 0 172 172"
												style="fill: #000000;">
												<g fill="none" fill-rule="nonzero" stroke="none"
													stroke-width="1" stroke-linecap="butt"
													stroke-linejoin="miter" stroke-miterlimit="10"
													stroke-dasharray="" stroke-dashoffset="0"
													font-family="none" font-weight="none" font-size="none"
													text-anchor="none" style="mix-blend-mode: normal">
												<path d="M0,172v-172h172v172z" fill="none"></path>
												<g fill="#e74c3c">
												<path
													d="M86,162.71469l-2.20375,-1.8275c-4.17906,-3.49375 -9.83625,-7.28312 -16.39375,-11.66375c-25.54469,-17.10594 -60.5225,-40.51406 -60.5225,-80.42344c0,-24.65781 20.06219,-44.72 44.72,-44.72c13.39719,0 25.94781,5.96625 34.4,16.16531c8.45219,-10.19906 21.00281,-16.16531 34.4,-16.16531c24.65781,0 44.72,20.06219 44.72,44.72c0,39.90938 -34.97781,63.3175 -60.5225,80.42344c-6.5575,4.38063 -12.21469,8.17 -16.39375,11.66375z"></path></g></g></svg>
										</button>

									</c:when>
								</c:choose> <span>${board.ltlike_count}</span></td>



						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<!--  글 번호 기능 구현 -->
		<div align="center">
			<ul class="pagination">
				<!-- 시작페이지가 pagePerBlock(10)보다 크면 앞에 보여줄 페이지가 있다 -->
				<c:if test="${pb.startPage > pb.pagePerBlock }"> // 1 ~ 10  
			<li><a href="boardList.do?pageNum=1"> <span
							class="glyphicon glyphicon-backward"></span></a></li>
					<li><a href="boardList.do?pageNum=${pb.startPage-1 }"> <span
							class="glyphicon glyphicon-triangle-left"></span></a></li>
				</c:if>
				<!--  i : 번호 -->
				<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
					<!-- pb.currentPage == i : i 번호이면 -->
					<c:if test="${pb.currentPage == i }">
						<li class="active">
							<!-- 활성화  --> <!-- 누른글번호 페이지만 파란색 , 나머지는 흰색 예) 1,2,3 번중 내가 3번을 누르면 1,2은 흰색으로 표기 3번만 파랑색-->
							<a href="boardList.do?pageNum=${i}">${i}</a>
						</li>
					</c:if>
					<!-- pb.currentPage == i : i 번호가 아니면 -->
					<c:if test="${pb.currentPage != i }">
						<li>
							<!--  비활성 --> <a href="boardList.do?pageNum=${i}">${i}</a>
						</li>
					</c:if>
				</c:forEach>

				<!-- 보여줄 것이 남아있는 경우는 다음 endpgae보다 totalPage가 클경우 -->
				<c:if test="${pb.endPage < pb.totalPage}">
					<li><a href="boardList.do?pageNum=${pb.endPage+1 }"> <span
							class="glyphicon glyphicon-triangle-right"></span></a></li>
					<li><a href="boardList.do?pageNum=${pb.totalPage}"> <span
							class="glyphicon glyphicon-forward"></span></a></li>
				</c:if>
			</ul>
		</div>
		<!-- 검색 기능을 구현 -->
		<!-- ch09자료 참고(model.Board,BoardController참고("list"- 부분),service,serviceImpl,Dao,DaoImpl구현,=> *board.xml*) -->

	</div>
	<div align="center">
		<a class="btn btn-info" href="boardInsertForm.do">게시글 입력</a> <a
			class="btn btn-default" href="main.do">메인으로 돌아가기</a>
	</div>



</body>
</html>