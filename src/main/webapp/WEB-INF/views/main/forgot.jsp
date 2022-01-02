<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function IDChk2(){
			if(!frm.id.value){
				alert("아이디를 입력하지 않았다");
				frm.id.focus();
				return false;
			}
			//ajax
			
			 $.post('IDChk2.do','id='+frm.id.value, function(data){
				// #IDChk2 이곳에 data = 메세지 출력
				$('#IDChk2').html(data);
			}); 
		}






</script>




</head>
<body>
<div class="container" align="center">
	<h2 class="text-primary">회원 정보 찾기</h2>
	<form action="forgotPassWord.do" name="frm">
	<table>
		<tr>
		<td>아이디 찾기 <span class="glyphicon glyphicon-user"></span>
		<input type="text" name="id" required="required" autofocus="autofocus">
		<!-- <input type="text" name="password" required="required" autofocus="autofocus"> -->
		
							<!-- 구현해야 할부분 1 -->
		<input type="button" onclick="IDChk2()" class="btn btn-info btn-sm" value="아이디존재 여부확인">
		 <div id="IDChk2" class="err"></div> 
		</td>
		</tr>
		
		
		
		<td colspan="2" align="center"><input type="submit" value="비밀번호 찾기"
						class="btn btn-defualt"></td>
		
		</table>
	
		<a href="loginForm.do" class="btn btn-success">홈으로 돌아가기</a>
	</form>
</div>
</body>
</html>