<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/carousel.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/signin.css"
	rel="stylesheet">

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/css/bootstrap.css"></script>

<style>
.featurette-heading {
	font-weight: 200;
	line-height: 1;
	letter-spacing: -1px;
}

.form-signin input[type="text"] {
	margin-bottom: 10px;
	margin-top: 5px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<!-- header -->
	<header>
		<%@ include file="../headerBar.jsp"%>
	</header>
	<br>
	<br>
	<!-- content -->
	<div class="container marketing">
	
	
	<form name="frm" action="helpUpdate" method="post">
		<h2 class="form-signin-heading">상담 수정</h2>
		<input type = "hidden" name = "num" value = "${help.num }">
		상담명
		<input type="text" name="title" id="inputTitle"
			class="form-control" placeholder="title" value="${help.title }" required autofocus>
		<br> 
		상담 내용
		<textarea cols="70" rows="15" name="content" class="form-control"
			placeholder="content" required>${help.content }</textarea>
		<br> 
		이메일
		<input type="email" name="email" id="inputEmail" value="${mdto.email}"
			class="form-control" placeholder="email" required> <br>
		<button class="btn btn-lg btn-primary" type="submit">수정</button>
		&nbsp; &nbsp;
		<button class="btn btn-lg btn-primary" type="button"
		 onclick = "location.href = 'help' ">목록</button>
	</form>
	
			<hr class="featurette-divider">
		<!-- FOOTER -->
		<footer>
			<p><%@ include file="../footer.jsp"%></p>
		</footer>
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>