<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<Script type="text/javascript">
	/* function idChk(){
		if(!frm.id.value){
			alert("아이디를 입력한 후에 체크 하시오");
			frm.id.focus();
			return false;
		}
		
		
		// id를 입력했던 jquery의 ajax를 사용해보자.
		// data는 controller에서 보내준 데이터
		// data는 컨트롤러에서 보내준 msg에 들어있는 문자를 받아서 저장
		$.post('idChk.do','id='+frm.id.value, function(data) {
			$('#idChk').html(data);
		});
	} */
	function IDChk(){ // frm 안에는 id,password, password2 , email, name, file 등이 들어있다.
		if(!frm.id.value){
			alert("아이디를 이력하지 않았다");
			frm.id.focus();
			return false; // false : 실행하지 마라
		}
		// ajax 
		// $.post('IDChk.do 에서 id = +frm.id.value'를 확인하여 function(data) (매개변수로 data를 받아)을 실행)
		$.post('IDChk.do','id='+frm.id.value, function(data) {
			$('#IDChk').html(data); // msg 결과를 출력
		});
	
	}
	
	
	function chk(){
		if(frm.password.value != frm.password2.value){
			alert("암호와 암호확인이 다릅니다");
			frm.password.focus(); //커서
			frm.password.value=""; //password에 있는 데이터를 지우기
			return false; // action : 실행하지마라
		}
		// 정규식
		var reg_pw = 
			 /^.*(?=.{4,8})(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@!#$*()_&]).*$/;
		
		/* if(!reg_pw.test(frm.password.value)){
			alert("4~8자 영문 대 소문자, 숫자, 특수문자를 사용하세요."); 
			frm.password.focus();
			return false;
		} */
		return true;
	}

</Script>


</head><body>
<div class="container" align="center">
		<h2 class="text-primary">회원 가입</h2>
		<form action="join.do" method="post" enctype="multipart/form-data"
			name="frm" onsubmit="return chk()">
			<table class="table table-bordered table-hover">
				<tr>
					<td>아이디 <span class="glyphicon glyphicon-user"></span></td>
					<td><input type="text" name="id" required="required"
						autofocus="autofocus">
						<input type="button" onclick="IDChk()" class="btn btn-info btn-sm" value="중복체크">
						<!-- 여기에 데이터를 뿌린다 (#idChk) -->
						<div id="IDChk" class="err"></div></td>
				</tr>
				
				<tr>
					<td>암호 <span class="glyphicon glyphicon-lock"></span></td>
					<td><input type="password" name="password" required="required">
					* 4~8자의 영문, 숫자, 특수문자( ! # $ * ( ) _ = |) 조합</td>
				</tr>
				
				<tr>
					<td>암호확인 <span class="glyphicon glyphicon-lock"></span></td>
					<td><input type="password" name="password2"
						required="required"></td>
				</tr>
				<tr>
					<td>이름 <span class="glyphicon glyphicon-user"></span></td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td>이메일 <span class="glyphicon glyphicon-envelope"></span></td>
					<td><input type="email" name="email" required="required"></td>
				</tr>
				<tr>
					<td>프로필 사진 <span class="glyphicon glyphicon-picture"></span></td>
					<td><input type="file" name="file" required="required" multiple="multiple"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						class="btn btn-danger"></td>
				</tr>
			</table>
				<a href="loginForm.do" class="btn btn-success">로그인</a>
						
		</form>
	</div>
	
</body>
</html>