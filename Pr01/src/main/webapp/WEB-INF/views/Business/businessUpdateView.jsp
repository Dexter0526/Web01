<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" action="besinessUpdate" method="post">
		<h2 class="form-signin-heading">사업실적 수정</h2>
		번호<input type="text" name="num" id="inputNum" value = "${business.num}"
			class="form-control" readonly>
		<br>
		사업명<input type="text" name="title" id="inputTitle" value = "${business.title}"
			class="form-control" placeholder="title" required autofocus>
		<br> 사업 설명
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" required>${business.content}</textarea>
		<br> 사업 분야<input type="text" name="field" id="inputField" value = "${business.field}"
			class="form-control" placeholder="field"> <br>
		<button class="btn btn-lg btn-primary" type="reset">취소</button>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="submit">등록</button>
	</form>
</body>
</html>