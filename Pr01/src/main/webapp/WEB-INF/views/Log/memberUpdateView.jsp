<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

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

		<form class="form-signin" name="frm" action="memberUpdate" method="post">
			<input type = "hidden" name = "email" value = "${member.email}">
			<h2 class="form-signin-heading">회원 수정</h2>
			
			이름<input type="text" name = "name" id="inputName" value = "${member.name}" readonly class="form-control"
				placeholder="Name" required autofocus> 
			
			이메일<input type="email" name = "email" id="inputEmail" value = "${member.email}" readonly class="form-control"
				placeholder="Email address" required>
			<div class="check_font" id="email_check"></div>
			
			비밀번호<input type="password" name = "pwd" value = "${member.pwd}" id="inputPassword" class="form-control"
				placeholder="Password" required>
			
			폰 번호<input type="text" name = "phone" id="inputPhone" value = "${member.phone}" class="form-control"
				placeholder="Phone Number" required> 
			
			등급 : &nbsp;
			<input type="radio" name = "admin" id="inputAdmin" value = "0"> 마스터
			&nbsp;&nbsp;
			<input type="radio" name = "admin" id="inputAdmin" value = "1" checked="checked"> 직원
			&nbsp;&nbsp;
			<input type="radio" name = "admin" id="inputAdmin" value = "2"> 일반 사용자
						
			<br><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">수정</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>