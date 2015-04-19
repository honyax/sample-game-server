package jp.game.server.demo6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String url = "jdbc:mysql://localhost:3306/sample_game_server";
	private static String userName = "sampleuser";
	private static String userPass = "samplepass";

	private static final String INSERT_LOGIN_LOG =
			"INSERT INTO login_log (name, created_at) VALUES (?, NOW())";

	public static void addLoginLog(String name) {
		try (
				Connection conn = DriverManager.getConnection(url, userName, userPass);
				PreparedStatement stmt = conn.prepareStatement(INSERT_LOGIN_LOG);
				) {

			stmt.setString(1, name);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_CHAT_LOG =
			"INSERT INTO chat_log (name, message, created_at) VALUES (?, ?, NOW())";

	public static void addChatLog(String name, String chatMessage) {
		try (
				Connection conn = DriverManager.getConnection(url, userName, userPass);
				PreparedStatement stmt = conn.prepareStatement(INSERT_CHAT_LOG);
				) {

			stmt.setString(1, name);
			stmt.setString(2, chatMessage);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
