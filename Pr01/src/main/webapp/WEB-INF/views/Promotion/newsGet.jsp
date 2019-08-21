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
		<h3 class="form-signin-heading">상세</h3>

		제목<input type="text" name="title" id="inputTitle" value="${news.title}"
			class="form-control" placeholder="title" readonly>
		<br> 설명
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" readonly>${news.content}</textarea>
		<br>
		<a href = "news"><button class="btn btn-lg btn-primary" type="button">목록</button></a>
	</form>
</body>
</html>