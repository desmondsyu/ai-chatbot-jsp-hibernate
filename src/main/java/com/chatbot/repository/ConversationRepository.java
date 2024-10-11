package com.chatbot.repository;

import java.util.List;

import com.chatbot.model.Conversation;

public interface ConversationRepository {
	List<Conversation> getAllConversations();

	void saveConversation(Conversation conversation);
}
