<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Modal -->
	<%-- #skyscraper --%>
	<div class="modal fade" id="skyscraper" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">초고층 빌딩 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'skyscraper'}">
									<tr>
										<th>${businessDto.title}</th>
										<th>${businessDto.content}</th>
									</tr>
								</c:if>
							</table>
						</c:forEach>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<%-- #housing --%>
	<div class="modal fade" id="housing" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">주택 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'housing'}">
									<tr>
										<th>${businessDto.title}</th>
										<th>${businessDto.content}</th>
									</tr>
								</c:if>
							</table>
						</c:forEach>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<%-- #commercialFacility --%>
	<div class="modal fade" id="commercialFacility" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">상업시설 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'commercialFacility'}">
									<tr>
										<th>${businessDto.title}</th>
										<th>${businessDto.content}</th>
									</tr>
								</c:if>
							</table>
						</c:forEach>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>