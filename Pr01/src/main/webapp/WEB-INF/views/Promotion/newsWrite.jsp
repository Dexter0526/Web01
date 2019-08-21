<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="newsRegistration" method="post">
		<h3 class="form-signin-heading">등록</h3>

		제목<input type="text" name="title" id="inputTitle"
			class="form-control" placeholder="title" required autofocus>
		<br> 설명
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" required></textarea>
		<br> 
		<button class="btn btn-lg btn-primary" type="reset">취소</button>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="submit">등록</button>
	</form>
</body>
</html>