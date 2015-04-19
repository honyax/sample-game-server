<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Demo4 Chat</title>
<script src="../js/jquery.min.js"></script>

<script type="text/javascript">

var url = 'ws://' + location.host + '<%= request.getContextPath() %>/demo4/ws';
var ws  = new WebSocket(url);

ws.onmessage = function(receive) {
	$('#message').html(receive.data + "<br/>" + $('#message').html());
};

ws.onopen = function() {
	ws.send('enter,<%= request.getAttribute("name") %>');
};

function send() {
	ws.send('talk,' + $('#inputText')[0].value);
}

</script>
</head>
<body>
<h1>Demo4 Chat</h1>
<span id="message"></span>
<br/>

<input id="inputText" type="text" placeholder="メッセージ" value=""/>
<input type="button" value="送信" onclick="send();"/>

</body>
</html>
