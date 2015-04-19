<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Demo3 WebSocket</title>
<script src="../js/jquery.min.js"></script>

<script type="text/javascript">

var url = 'ws://' + location.host + '<%= request.getContextPath() %>/demo3/ws';
var ws  = new WebSocket(url);

ws.onopen = function() {
	ws.send('Hello WebSocket GameServer');
};

</script>
</head>
<body>
<h1>Demo3 WebSocket</h1>

</body>
</html>
