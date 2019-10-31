<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="panel panel-default">
		  <div class="panel-heading">${news.title}</div>
		  <div class="panel-body" style="height: 300px;">
		    <pre style="background-color: white; border: 0;">${news.content}</pre>
		  </div>
		</div>
</body>
</html>