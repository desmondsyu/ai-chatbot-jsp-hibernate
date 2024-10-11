package com.chatbot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chatbot.model.Conversation;
import com.chatbot.repository.ConversationRepository;
import com.chatbot.repository.impl.ConversationRepositoryImplement;

public class ConversationService {
	private final ConversationRepository conversationRepository;

	public ConversationService() {
		this.conversationRepository = new ConversationRepositoryImplement();
	}

	public List<Conversation> getAllConversations() {
		return conversationRepository.getAllConversations();
	}

	public void saveConversation(Conversation conversation) {
		conversationRepository.saveConversation(conversation);
	}

	public String matchKeyWord(String query) {
		String response = "Sorry, I don't understand your question.";
		String processedQuery = query.toLowerCase();

		Map<String, String> keywordPairs = new HashMap<>();
		keywordPairs.put("chicken",
				"The chicken is a large and round short-winged bird, domesticated from the red junglefowl of Southeast Asia around 8,000 years ago.");
		keywordPairs.put("java",
				"Java is one of the Greater Sunda Islands in Indonesia. It is bordered by the Indian Ocean to the south and the Java Sea to the north.");
		keywordPairs.put("dinner", "I can't help you to cook, but here is a idea for today's dinner: pizza.");
		keywordPairs.put("homework", "Do your homework yourself.");
		keywordPairs.put("sad", "Sorry to hear that. Here is a song can make you happier.");

		for (Map.Entry<String, String> pair : keywordPairs.entrySet()) {
			if (processedQuery.contains(pair.getKey())) {
				response = pair.getValue();
				break;
			}
		}

		return response;
	}
}
