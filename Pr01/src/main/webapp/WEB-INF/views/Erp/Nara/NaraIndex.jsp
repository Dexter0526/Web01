<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<%@ include file = "../ErpHeaderBar.jsp" %>
	</header>

	<div class="container-fluid">
		<div class="row">
			<!-- nav -->
			<%@ include file = "../ErpNav.jsp" %>
			
			<!-- body -->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">개찰결과 조회 </h1>

				<!-- body head -->
<!-- 				<div class="row placeholders" align="left"> -->
					<form class="form-inline" name="frm" action="Nara">
					<input type="hidden" value = "1" name = "formClick">
					  <div class="form-group">
					    <label for="exampleInputName2">조회구분</label>
					    <select class="form-control" name="inqryDiv">
						  <option value="1">1.입력일시</option>
						  <option value="2">2.공고일시</option>
						  <option value="3">3.개찰일시</option>
						  <option value="4">4.입찰공고번호</option>
						</select>
					  </div><br><br>
					  <div class="form-group">
					    <label for="exampleInputName2">조회시작일시</label>
					    <input type="text" class="form-control" id="" name ="inqryBgnDt" placeholder="201911031159">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputName2">조회종료일시</label>
					    <input type="text" class="form-control" id="" name ="inqryEndDt" placeholder="201911041159">
					  </div><br><br>
					  <div class="form-group">
					    <label for="exampleInputEmail2">입찰공고번호</label>
					    <input type="text" class="form-control" id="" name = "bidNtceNo" placeholder="20160329825">
					  </div>
					  <br><br>
					  <button type="submit" class="btn btn-default">Send invitation</button>
					</form>
<!-- 				</div> -->

				<h2 class="sub-header">개찰 결과 리스트</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>입찰공고번호</th>
								<th>입찰공고명</th>
								<th>개찰일시</th>
								<th>참가업체수</th>
								<th>공고기관명</th>
								<th>수요기관명</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var = "nara" items = "${nara }">
							<tr>
								<td>${nara.bidNtceNo }</td>
								<td>${nara.bidNtceNm }</td>
								<td>${nara.opengDt }</td>
								<td>${nara.prtcptCnum }</td>
								<td>${nara.ntceInsttNm }</td>
								<td>${nara.dminsttNm }</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>

				<nav>
					<ul class="pager">
						<c:if test="${pageMaker.prev}">
							<li class="disabled"><a
								href="Nara?pageNo=${pageMake.startPage-1}&numOfRows=${g2bDto.numOfRows}&inqryDiv=${g2bDto.inqryDiv }&inqryBgnDt=${g2bDto.inqryBgnDt }&inqryEndDt=${g2bDto.inqryEndDt }"
								aria-label="Previous">[Prev] </a></li>
						</c:if>
						<c:forEach var="pageNum" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="${pageMaker.cri.pageNum == num ? 'active' : ''}">
								<a href="Nara?pageNo=${pageNum}&numOfRows=${g2bDto.numOfRows}&inqryDiv=${g2bDto.inqryDiv }&inqryBgnDt=${g2bDto.inqryBgnDt }&inqryEndDt=${g2bDto.inqryEndDt }">${pageNum}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li><a
								href="Nara?pageNo=${pageMake.endPage+1}&numOfRows=${g2bDto.numOfRows}&inqryDiv=${g2bDto.inqryDiv }&inqryBgnDt=${g2bDto.inqryBgnDt }&inqryEndDt=${g2bDto.inqryEndDt }"
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