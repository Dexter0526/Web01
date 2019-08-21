<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="newsUpdate" method="post">
		<h3 class="form-signin-heading">수정</h3>
		번호<input type="text" name="num" id="inputNum" value = "${news.num}"
			class="form-control" readonly>
		<br>
		제목<input type="text" name="title" id="inputTitle" value="${news.title}"
			class="form-control" placeholder="title">
		<br> 설명
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content">${news.content}</textarea>
		<br>
		<a href = "newsDelete?num=${news.num}"><button class="btn btn-lg btn-primary" type="button">삭제</button></a>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="submit">등록</button>
	</form>
</body>
</html>