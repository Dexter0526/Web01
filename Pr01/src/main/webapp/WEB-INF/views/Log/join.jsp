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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<form class="form-signin" name = "frm" action = "join" method = "post">
			<h2 class="form-signin-heading">Please Sign up</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Join</button>
			<br>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>