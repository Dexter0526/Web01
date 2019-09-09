<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<!-- content -->
	<div class="container marketing">
		<!-- Body -->
		<h1 class="page-header">뉴스</h1>

		<!-- body head -->
		<c:choose>
			<c:when test="${nresult==1}">
				<jsp:include page="newsUpdateView.jsp" />
			</c:when>
			<c:when test="${nresult==0}">
				<jsp:include page="newsGet.jsp" />
			</c:when>
			<c:when test="${admin==0||admin==1}">
				<jsp:include page="newsWrite.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="newsHead.jsp" />
			</c:otherwise>
		</c:choose>

		<h3 class="sub-header">리스트</h3>
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="newsList" items="${newsList}">
						<tr>
							<td>${newsList.num}</td>
							<td><a href="getNews?num=${newsList.num}">${newsList.title}</a></td>
							<td>${newsList.regDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!-- pagination -->
		<nav style=align:center;>
			<ul class="pager">
				<li class="disabled"><a href="#" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="active"><a href="news?pageNum=1">1</a></li>
				<li><a href="news?pageNum=2">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>

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