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
	<%-- #bridges --%>
	<div class="modal fade" id="bridges" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">교량 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'bridges'}">
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
					<button type="button" class="btn btn-primary" name="field"
						value="bridges">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<%-- #road --%>
	<div class="modal fade" id="road" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">도로 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'road'}">
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
					<button type="button" class="btn btn-primary" name="field"
						value="road">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<%-- #railroad --%>
	<div class="modal fade" id="railroad" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">철도 사업 실적</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<c:forEach var="businessDto" items="${businessList}">
							<table class="table table-bordered">
								<c:if test="${businessDto.field eq 'railroad'}">
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
					<button type="button" class="btn btn-primary" name="field"
						value=railroad>Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>