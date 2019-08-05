<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index">DexterWeb</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="about">회사소개</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">사업분야
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">건축</a></li>
									<li><a href="#">토목</a></li>
									<li><a href="#">플랜트</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false">기술분야
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">시공</a></li>
									<li><a href="#">환경</a></li>
									<li><a href="#">미래 기술</a></li>
									<li class="divider"></li>
									<li class="dropdown-header">연구 실적</li>
									<li><a href="#">특허</a></li>
									<li><a href="#">포트폴리오</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<c:choose>
								<c:when test="${result != 1}">
									<li><a href="log">Sign in</a></li>
									<li><a href="#">Help</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="memberIndexView">Member</a>
									<li><a href="logout">Log out</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>

</body>
</html>