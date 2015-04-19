package jp.game.server.demo5;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo5/ws")
public class GameServerWebSocket {
	private String name = "";

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("Message:" + message);
		String[] data = message.split(",");

		switch (data[0]) {
		case "enter":
			name = data[1];
			broadcast(name + "が入室しました。", session);
			Dao.addLoginLog(name);
			break;
		case "talk":
			String chatMessage = data[1];
			broadcast(name + ":" + chatMessage, session);
			Dao.addChatLog(name, chatMessage);
			break;
		default:
			break;
		}
	}

	private void broadcast(String message, Session session) {
		for (Session s : session.getOpenSessions()) {
			s.getAsyncRemote().sendText(message);
		}
	}
}
