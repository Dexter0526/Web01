<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/signin.css" rel="stylesheet">
<script type="text/javascript" src="./resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="./resources/js/ajax.js"></script>

<title>Insert title here</title>
<style>
.form-signin input[type="email"] {
	margin-bottom: 10px;
	margin-top: 5px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	margin-top: 5px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.form-signin input[type="text"] {
	margin-bottom: 10px;
	margin-top: 5px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>

	<div class="container">

		<form class="form-signin" name="frm" action="join" method="post"
			id="frm">
			<h2 class="form-signin-heading">Please sign up</h2>

			이름<input type="text" name="name" id="inputName" class="form-control"
				placeholder="Name" required autofocus> 이메일<input
				type="email" name="email" id="inputEmail" class="form-control"
				placeholder="Email address" required>
			<div class="check_font" id="email_check"></div>

			비밀번호<input type="password" name="pwd" id="inputPassword"
				class="form-control" placeholder="Password" required> 폰 번호<input
				type="text" name="phone" id="inputPhone" class="form-control"
				placeholder="Phone Number">

			<c:if test="${admin==0 }">
			
			</c:if>
			
			<c:choose>
				<c:when test="${admin==0 }">
					등급 : &nbsp;
					<input type="radio" name="admin" value="0"> 마스터
					&nbsp;&nbsp;
					<input type="radio" name="admin" value="1" checked="checked"> 직원
				</c:when>
				<c:otherwise>
					<input type="hidden" name="admin" value="2">
				</c:otherwise>
			</c:choose>
			
			<br> <br>

			<button class="btn btn-lg btn-primary btn-block" type="submit"
				id="frm_submit">Sign up</button>
		</form>

	</div>
	<!-- /container -->



	<script type="text/javascript">
// $(document).ready(function(){
	
// 	$("#inputEmail").blur(function(){
// 		var email = $('#inputEmail').val();
// 		idCheck(email);
// 	});
	
// });
</script>

<script>
// ajax 파일 분리 전
$("#inputEmail").blur(function(){
	var email = $('#inputEmail').val();
	$.ajax({
		url : '${pageContext.request.contextPath}/emailCheck?email='+ email,
		type : 'get',
		dataType : "json",
		success : function(data) {						
			console.log("data : " + data);
			if (data == 1) {
				// 1 : 아이디가 중복되는 문구
				$("#email_check").text("사용중인 아이디입니다. ");
				$("#email_check").css("color", "red");
				$("#frm_submit").attr("disabled", true);
			} else {
	
				if(email == ""){
	
					$('#email_check').text('아이디를 입력해주세요 :)');
					$('#email_check').css('color', 'red');
					$("#frm_submit").attr("disabled", true);				
	
				}else{
					$("#email_check").text("사용가능 아이디입니다.");
					$("#email_check").css("color", "blue");
					$("#frm_submit").attr("disabled", false);
				}
	
			}
		}, error : function() {
			console.log("실패");
			}
		});
});
</script>
</body>
</html>