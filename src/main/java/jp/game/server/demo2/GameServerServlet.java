package jp.game.server.demo2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo2/servlet")
public class GameServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("body", "チャットルームに入室します");
		request.getRequestDispatcher("/demo2/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		name = new String(name.getBytes("ISO8859_1"), "UTF-8");
		request.setAttribute("name", name);
		request.getRequestDispatcher("/demo2/chat.jsp").forward(request, response);
	}
}
