<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="form-inlaine" name="frm" action="helpLog" method="post">
		<div class="form-group">
			<label for="exampleInputEmail">Email</label> <input type="email"
				class="form-control" id="" name="email"
				placeholder="jane.doe@example.com">
		</div>
		<div class="form-group">
			<label for="exampleInputPwd">Password</label> <input type="password"
				class="form-control" id="" name="pwd" placeholder="Password">
		</div>
		<button type="submit" class="btn-sm btn-primary"
			onclick="return loginCheck()">Sign in</button>
		<a href="signup">
			<button type="button" class="btn-sm btn-success">Sign Up</button>
		</a>
	</form>
</body>
</html>