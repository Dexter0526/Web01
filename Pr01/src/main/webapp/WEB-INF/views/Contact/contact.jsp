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
<link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">

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
body{
	background-color: #white;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<header>
		<%@ include file="../headerBar.jsp"%>
	</header>
	<br><br>
	<!-- content -->
	<div class="container marketing">
	<!-- 상담 내역 신청 -->
		
		<br>
		<!-- Body -->

			<div class="table-responsive">
				<h2>상담내역 리스트</h2>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>번호</th>
							<th>사업명</th>
							<th>사업 설명</th>
							<th>사업 분야</th>
							<th>옵션</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="businessList" items="${businessList}">
							<tr>
								<td>${businessList.num}</td>
								<td>${businessList.title}</td>
								<td><a href = "businessUpdateView?num=${businessList.num}">${businessList.content}</a></td>
								<td>${businessList.field}</td>
								<td><a
									href="businessUpdateView?num=${businessList.num}"><button
											type="button" class="btn btn-xs btn-default">수정</button></a>
									&nbsp; &nbsp; <a
									href="businessDelete?num=${businessList.num}"><button
											type="button" class="btn btn-xs btn-danger">삭제</button></a></td>
							</tr>
						</c:forEach>
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