<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="consultingInsert" method="post">
		<h2 class="form-signin-heading">답변 등록</h2>

		번호
		<input type="text" name="num" id="inputnum" value="${help.num}"
			class="form-control" placeholder="num" readonly="readonly">
		답변명
		<input type="text" name="title" id="inputTitle"
			class="form-control" placeholder="title" required autofocus>
		<br> 
		답변 내용
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" required></textarea>
		<br> 
		이메일
		<input type="email" name="email" id="inputEmail" value="${mdto.email}"
			class="form-control" placeholder="email" required> <br>
		<input type="hidden" name="sendEmail" value="${help.email}">
		<button class="btn btn-lg btn-primary" type="reset">취소</button>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="submit">등록</button>
	</form>
</body>
</html>