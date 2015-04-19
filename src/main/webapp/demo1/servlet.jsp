<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><%= request.getAttribute("title") %></title>
</head>
<body>
<h1>Demo1 Servlet</h1>
<h2><%= request.getAttribute("body") %></h2>
</body>
</html>
