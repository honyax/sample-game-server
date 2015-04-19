package jp.game.server.demo3;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo3/ws")
public class GameServerWebSocket {
	@OnMessage
	public String onMessage(String message) {
		System.out.println(message);
		return message;
	}
}
