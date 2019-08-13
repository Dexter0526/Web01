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
		<hr class="featurette-divider">

		<div class="row featurette" style="background-color: #eee;">
			<div class="col-md-7">
				<h2 class="featurette-heading">비선형 구조물</h2>
				<p class="lead">Donec ullamcorper nulla non metus auctor
					fringilla. Vestibulum id ligula porta felis euismod semper.
					Praesent commodo cursus magna, vel scelerisque nisl consectetur.
					Fusce dapibus, tellus ac cursus commodo.</p>
			</div>
			<div class="col-md-5">
				<img
					src="${pageContext.request.contextPath}/resources/image/railway-station-2255902_1920.jpg"
					class="featurette-image img-responsive center-block"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>
		<hr class="featurette-divider">

		<div class="row">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<c:choose>
							<c:when test="${result == 1 && admin != 2}">
								<tr>
									<td colspan="5" style="border: white; text-align: right"><a
										href="patentWrite">등록</a></td>
								</tr>

								<tr>
									<th>번호</th>
									<th>특허 번호</th>
									<th>특허명</th>
									<th>설명</th>
									<th>옵션</th>
								</tr>

							</c:when>

							<c:otherwise>
								<tr>
									<th>번호</th>
									<th>특허 번호</th>
									<th>특허명</th>
									<th>설명</th>
								</tr>
							</c:otherwise>
						</c:choose>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${result == 1 && admin != 2}">
								<c:forEach var="patentList" items="${patentList}">
									<tr>
										<td>${patentList.num-1}</td>
										<td>${patentList.patentNum}</td>
										<td>${patentList.title}</td>
										<td>${patentList.content}</td>
										<td><a href="patentUpdateView?patentNum=${patentList.patentNum}"><button
													type="button" class="btn btn-xs btn-default">수정</button></a>
											&nbsp; &nbsp; <a
											href="patentDelete?patentNum=${patentList.patentNum}"><button
													type="button" class="btn btn-xs btn-danger">삭제</button></a></td>
									</tr>
								</c:forEach>
							</c:when>

							<c:otherwise>
								<c:forEach var="patentList" items="${patentList}">
									<tr>
										<td>${patentList.num-1}</td>
										<td>${patentList.patentNum}</td>
										<td>${patentList.title}</td>
										<td>${patentList.content}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>
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