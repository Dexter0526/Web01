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

	<!-- header -->
	<header>
		<%@ include file="../headerBar.jsp"%>
	</header>

	<!-- content -->
	<div class="container marketing">
		<hr class="featurette-divider">
		<!-- Body -->
		<h1 class="page-header">뉴스</h1>

		<!-- body head -->
		<div class="row placeholders">
			<div class="col-xs-6 col-sm-3 placeholder">
				<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
					alt="Generic placeholder thumbnail">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
					alt="Generic placeholder thumbnail">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<img data-src="holder.js/200x200/auto/sky" class="img-responsive"
					alt="Generic placeholder thumbnail">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<img data-src="holder.js/200x200/auto/vine" class="img-responsive"
					alt="Generic placeholder thumbnail">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
		</div>


		<h3 class="sub-header">리스트</h3>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1,001</td>
						<td>Lorem</td>
						<td>ipsum</td>
					</tr>
					<tr>
						<td>1,002</td>
						<td>amet</td>
						<td>consectetur</td>
					</tr>
					<tr>
						<td>1,003</td>
						<td>Integer</td>
						<td>nec</td>
					</tr>
					<tr>
						<td>1,003</td>
						<td>libero</td>
						<td>Sed</td>
					</tr>
					<tr>
						<td>1,004</td>
						<td>dapibus</td>
						<td>diam</td>
					</tr>
					<tr>
						<td>1,005</td>
						<td>Nulla</td>
						<td>quis</td>
					</tr>
					<tr>
						<td>1,006</td>
						<td>nibh</td>
						<td>elementum</td>
					</tr>
					<tr>
						<td>1,007</td>
						<td>sagittis</td>
						<td>ipsum</td>
					</tr>
					<tr>
						<td>1,008</td>
						<td>Fusce</td>
						<td>nec</td>
					</tr>
					<tr>
						<td>1,009</td>
						<td>augue</td>
						<td>semper</td>
					</tr>
					<tr>
						<td>1,010</td>
						<td>massa</td>
						<td>Vestibulum</td>
					</tr>
					<tr>
						<td>1,011</td>
						<td>eget</td>
						<td>nulla</td>
					</tr>
					<tr>
						<td>1,012</td>
						<td>taciti</td>
						<td>sociosqu</td>
					</tr>
					<tr>
						<td>1,013</td>
						<td>torquent</td>
						<td>per</td>
					</tr>
					<tr>
						<td>1,014</td>
						<td>per</td>
						<td>inceptos</td>
					</tr>
					<tr>
						<td>1,015</td>
						<td>sodales</td>
						<td>ligula</td>
					</tr>
				</tbody>
			</table>
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