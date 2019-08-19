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
	<%-- #gas --%>
	<div class="modal fade" id="gas" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">가스처리 시설 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'gas'}">
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

	<%-- #power --%>
	<div class="modal fade" id="power" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">전력 시설 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'power'}">
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

	<%-- #oil --%>
	<div class="modal fade" id="oil" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">석유정제 시설 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'oil'}">
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