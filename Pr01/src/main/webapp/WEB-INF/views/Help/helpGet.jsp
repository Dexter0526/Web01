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
		<h3>상담 상세 내역</h3>
		<div class="panel panel-default">
		  <div class="panel-heading">제목 : ${help.title}</div>
		  <div class="panel-body" style="height: 300px;">
		   <pre style="background-color: white; border: 0;">${help.content}</pre>
		  </div>
		  <div class="panel-footer">작성자 : ${help.email}</div>
		</div>
		
</body>
</html>