<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li><a href="Analytics" target="_blank">Analytics</a></li>
			<li><a href="http://data.g2b.go.kr:8275/pt/pubdata/moveGnrlzBidPblancPop.do" target="_blank">
			통합 입찰공고 내역</a></li>
		</ul>
		<ul class="nav nav-sidebar">
			<li><a href="contract">계약관리</a></li>
			<li><a href="#">현장관리</a></li>
			<li><a href="#">도급/기성관리</a></li>
			<li><a href="#">작업일보</a></li>
			<li><a href="#">전도금/미지급관리</a></li>
		</ul>
		<ul class="nav nav-sidebar">
			<li><a href="#">노무장비관리</a></li>
			<li><a href="#">마감정산관리</a></li>
			<li><a href="#">노무신고</a></li>
			<li><a href="#">외주기성관리</a></li>
			<li><a href="#">자재재고관리</a></li>
			<li><a href="#">원가손익관리</a></li>
		</ul>
		<ul class="nav nav-sidebar">
		<c:if test="${admin == 0}">
			<li><a href="memberView">회원 관리</a></li></c:if>
			
		<c:if test="${admin != 2}">
			<li><a href="help">상담 관리</a></li>
		</c:if>
		</ul>
	</div>
</body>
</html>