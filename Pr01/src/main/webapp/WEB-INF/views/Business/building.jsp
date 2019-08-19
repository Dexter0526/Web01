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

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/css/bootstrap.css"></script>
<title>Insert title here</title>
</head>
<body>

	<header>
		<%@ include file="../headerBar.jsp"%>
	</header>

	<!-- content -->
	<div class="container marketing">

		<!-- Body -->
		<hr class="featurette-divider">
		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">고층 빌딩</h2>
				<p class="lead">Donec ullamcorper nulla non metus auctor
					fringilla. Vestibulum id ligula porta felis euismod semper.
					Praesent commodo cursus magna, vel scelerisque nisl consectetur.
					Fusce dapibus, tellus ac cursus commodo.</p>
				<p>
					<c:choose>
						<c:when test="${result == 1 && admin != 2}">
							<a href="businessTable"><button type="button"
									class="btn btn-primary">주요 실적</button></a>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#skyscraper">주요 실적</button>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="col-md-5">
				<img
					src="${pageContext.request.contextPath}/resources/image/architecture-2256489_640.jpg"
					class="featurette-image img-responsive center-block"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">
		<div class="row featurette">
			<div class="col-md-7 col-md-push-5">
				<h2 class="featurette-heading">
					<span class="text-muted">주택</span>
				</h2>
				<p class="lead">Donec ullamcorper nulla non metus auctor
					fringilla. Vestibulum id ligula porta felis euismod semper.
					Praesent commodo cursus magna, vel scelerisque nisl consectetur.
					Fusce dapibus, tellus ac cursus commodo.</p>
				<p>
					<c:choose>
						<c:when test="${result == 1 && admin != 2}">
							<a href="businessTable">
								<button type="button" class="btn btn-primary">주요 실적</button>
							</a>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#housing">주요 실적</button>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="col-md-5 col-md-pull-7">
				<img
					src="${pageContext.request.contextPath}/resources/image/old-farmhouse-2535919_640.jpg"
					class="featurette-image img-responsive center-block"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">
		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">상업 시설</h2>
				<p class="lead">Donec ullamcorper nulla non metus auctor
					fringilla. Vestibulum id ligula porta felis euismod semper.
					Praesent commodo cursus magna, vel scelerisque nisl consectetur.
					Fusce dapibus, tellus ac cursus commodo.</p>
				<p>
					<c:choose>

						<c:when test="${result == 1 && admin != 2}">
							<a href="businessTable">
								<button type="button" class="btn btn-primary">주요 실적</button>
							</a>
						</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#commercialFacility">주요 실적</button>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="col-md-5">
				<img
					src="${pageContext.request.contextPath}/resources/image/building-1989816_640.jpg"
					class="featurette-image img-responsive center-block"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<footer>
			<p><%@ include file="../footer.jsp"%></p>
		</footer>

	</div>

	<%--모달 DB 테이블 --%>
	<%@ include file="buildingTable.jsp"%>


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