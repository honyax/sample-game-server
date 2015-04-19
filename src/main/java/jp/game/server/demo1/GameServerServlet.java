package jp.game.server.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo1/servlet")
public class GameServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "ゲームサーバサンプル");
		request.setAttribute("body", "ゲームサーバを作るぜ！");
		request.getRequestDispatcher("/demo1/servlet.jsp").forward(request, response);
	}
}
