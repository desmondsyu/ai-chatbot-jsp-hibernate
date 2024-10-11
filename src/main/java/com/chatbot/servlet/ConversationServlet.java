package com.chatbot.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.chatbot.model.Conversation;
import com.chatbot.services.ConversationService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConversationServlet
 */
public class ConversationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConversationService conversationService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConversationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		conversationService = new ConversationService();
		getServletContext().log("ConversationService initialized.");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestType = request.getMethod();
		String requestUrl = request.getRequestURL().toString();

		getServletContext().log("Incoming request: " + requestType + " " + requestUrl);

		super.service(request, response);
	}

	@Override
	public void destroy() {
		getServletContext().log("The servlet is being terminated.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userQuery = request.getParameter("question");
		String chatbotResponse = conversationService.matchKeyWord(userQuery);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Conversation conversation = new Conversation(userQuery, chatbotResponse, timestamp);
		conversationService.saveConversation(conversation);

		List<Conversation> allCon = conversationService.getAllConversations();

		request.setAttribute("allCon", allCon);

		request.getRequestDispatcher("/chatbot.jsp").forward(request, response);
	}

}
