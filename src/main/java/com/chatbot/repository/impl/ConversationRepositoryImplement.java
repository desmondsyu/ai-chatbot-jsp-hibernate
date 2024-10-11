package com.chatbot.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chatbot.model.Conversation;
import com.chatbot.repository.ConversationRepository;

public class ConversationRepositoryImplement implements ConversationRepository {
	private SessionFactory sessionFactory;

	public ConversationRepositoryImplement() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Override
	public List<Conversation> getAllConversations() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Conversation> conversations = session.createQuery("FROM Conversation", Conversation.class).list();
		transaction.commit();
		session.close();
		return conversations;
	}

	@Override
	public void saveConversation(Conversation conversation) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(conversation);
		transaction.commit();
		session.close();
	}

}
