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
<body style="background-color: #eee;">

	<div class="container">

		<form class="form-signin" name="frm" action="patentUpdate"
			method="post">
			<input type = "hidden" name = "num" value = "${patent.num}">
			<h2 class="form-signin-heading">특허 수정</h2>

			특허 번호<input type="text" name="patentNum" id="patentNum" value = "${patent.patentNum}"
				class="form-control" placeholder="patent number" required autofocus>

			특허명<input type="text" name="title" value = "${patent.title}" id="title" class="form-control"
				placeholder="patent title" required> 
			설명
			<textarea cols="70" rows="15" name="content" class="form-control"
				placeholder="content" required>${patent.content}</textarea>

			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">등록</button>
		</form>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>