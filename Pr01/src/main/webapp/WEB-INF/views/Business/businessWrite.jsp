<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="besinessRegistration" method="post">
		<h2 class="form-signin-heading">사업실적 등록</h2>

		사업명<input type="text" name="title" id="inputTitle"
			class="form-control" placeholder="title" required autofocus>
		<br> 사업 설명
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" required></textarea>
		<br> 사업 분야<input type="text" name="field" id="inputField"
			class="form-control" placeholder="field" required> <br>
		<button class="btn btn-lg btn-primary" type="reset">취소</button>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="submit">등록</button>
	</form>
</body>
</html>