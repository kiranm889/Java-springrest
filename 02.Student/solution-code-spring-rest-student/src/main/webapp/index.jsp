<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Rest Demo</title>
</head>
<body>

<h1>Spring Rest Demo</h1>
<hr>
<a href="${pageContext.request.contextPath }/test/hello">hello</a>

<hr>

<a href="${pageContext.request.contextPath }/api/students">Students</a>
</body>
</html>