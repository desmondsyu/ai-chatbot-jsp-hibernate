package com.chatbot.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversations")
public class Conversation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String userQuery;
	private String chatbotResponse;
	private Timestamp timestamp;

	public Conversation() {
	}

	public Conversation(String userQuery, String chatbotResponse, Timestamp timestamp) {
		this.userQuery = userQuery;
		this.chatbotResponse = chatbotResponse;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}

	public String getChatbotResponse() {
		return chatbotResponse;
	}

	public void setChatbotResponse(String chatbotResponse) {
		this.chatbotResponse = chatbotResponse;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
