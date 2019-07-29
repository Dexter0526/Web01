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
<link href="./resources/css/carousel.css" rel="stylesheet">
<link href="./resources/css/signin.css" rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<form class="form-signin" name = "frm" action = "login" method = "post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return loginCheck()">Sign
				in</button>
			<br>
			<div class="position_a" align="center">
				<div class="find_info">
					<a target="_blank" id="idinquiry" href="">아이디 찾기</a>
					<span class="bar" aria-hidden="true">|</span>
					<a target="_blank" id="pwinquiry" href="">비밀번호 찾기</a>
					<span class="bar" aria-hidden="true">|</span>
					<a target="_blank" id="join" href="join">회원가입</a>
				</div>
			</div>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>