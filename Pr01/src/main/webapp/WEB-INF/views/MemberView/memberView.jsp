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
		<%@ include file="memberHeaderBar.jsp"%>
	</header>

	<div class="container-fluid">
		<div class="row">
			<!-- nav -->
			<%@ include file="memberNav.jsp"%>

			<!-- body -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">임직원 관리</h1>

				<!-- body head -->
				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>총 인원</h4><br>
						<span class="text-muted">20명</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>직원</h4><br>
						<span class="text-muted">10명</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>일반 사용자</h4><br>
						<span class="text-muted">8명</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>계정 추가</h4><br>
						<span class="text-muted">
							<a href = "signup"><button type="button" class="btn-sm btn-success">Account</button></a>
						</span>
					</div>
				</div>

				<h2 class="sub-header">User List</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>name</th>
								<th>email</th>
								<th>phone</th>
								<th>admin</th>
								<th>setting</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="memberList" items="${memberList}">
								<tr>
									<td>${memberList.name}</td>
									<td>${memberList.email}</td>
									<td>${memberList.phone}</td>
									<td>${memberList.admin}</td>
									<td><a href = "memberUpdateView?email=${memberList.email}"><button type="button" class="btn btn-xs btn-default">수정</button></a>
										<a href = "memberDelete?email=${memberList.email}"><button type="button" class="btn btn-xs btn-danger">삭제</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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