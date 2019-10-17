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
	<br>
	<br>
	<!-- content -->
	<div class="container marketing">
		<!-- 등록창, 상세뷰 -->
		<!-- Body -->
		<!-- login -->
		<c:choose>
			<c:when test="${result != 1}">
				<%@ include file="helpLog.jsp"%>
			</c:when>
			<c:when test="${help == null && admin == 2}">
				<%@ include file="helpWrite.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="helpGet.jsp"%>
			</c:otherwise>
		</c:choose>
		<br>

		<!-- table -->
		<div class="table-responsive">
			<h2>상담 내역</h2>
			<br>
			<c:if test="${helpList != null }">
				<table class="table">
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
								<td><a href="helpUpdateView?num=${helpList.num}"><button
											type="button" class="btn btn-xs btn-default">수정</button></a>
									&nbsp; &nbsp; <a href="helpDelete?num=${helpList.num}"><button
											type="button" class="btn btn-xs btn-danger">삭제</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
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
						href="help?pageNum=${pageNum}">${pageNum}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next}">
					<li><a
						href="help?pageNum=${pageMake.endPage+1}"
						aria-label="Next">[Next] </a></li>
				</c:if>
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