<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Demo2 Servlet</title>
</head>
<body>
<h1>Demo2 Servlet</h1>
<h2><%= request.getAttribute("body") %></h2>
<form method="post" action="<%= request.getContextPath() %>/demo2/servlet">
名前:<input name="name" type="text"/><br/><br/>
<input type="submit" value="OK" />
</form>
</body>
</html>
