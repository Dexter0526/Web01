<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/dashboard.css"
	rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
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
		<%@ include file="../ErpHeaderBar.jsp"%>
	</header>

	<div class="container-fluid">
		<div class="row">
			<!-- nav -->
			<%@ include file="../ErpNav.jsp"%>

			<!-- body -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">상담 내역 관리</h1>

				<!-- body head -->
				<div class="row placeholders">
					<!-- 상단 4개 항목(통계 예정) -->
				</div>

				<h2 class="sub-header">List</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>이메일</th>
								<th>날짜</th>
								<th>옵션</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="helpList" items="${helpList}">
								<tr>
									<td>${helpList.num}</td>
									<td><a href="helpGet?num=${helpList.num}">${helpList.title}</a></td>
									<td>${helpList.email}</td>
									<td>${helpList.reg_date }</td>
									<td><a href="helpDelete?num=${helpList.num}"><button
												type="button" class="btn btn-xs btn-danger">삭제</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<nav>
					<ul class="pager">
						<c:if test="${pageMaker.prev}">
							<li class="disabled"><a
								href="help?pageNum=${pageMake.startPage-1}"
								aria-label="Previous">[Prev] </a></li>
						</c:if>

						<c:forEach var="pageNum" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="${pageMaker.cri.pageNum == num ? 'active' : ''}"><a
								href="help?pageNum=${pageNum}">${pageNum}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li><a href="help?pageNum=${pageMake.endPage+1}"
								aria-label="Next">[Next] </a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<script src="../../assets/js/docs.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>