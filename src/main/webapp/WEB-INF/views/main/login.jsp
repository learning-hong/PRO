<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<c:if test="${result >0 }">
	<script type="text/javascript">
		alert("로그인 성공");
		location.href='main.do';
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("암호를 잘못 입력 하였습니다");
		history.go(-1);
	</script>
</c:if>
<c:if test="${result ==-1 }">
	<script type="text/javascript">
		alert("없는 아이디입니다");
		history.go(-1);
	</script>
</c:if>

</body>
</html>