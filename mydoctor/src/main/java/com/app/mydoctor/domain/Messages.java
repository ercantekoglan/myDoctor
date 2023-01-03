package com.app.mydoctor.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Messages {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	private String messageTitle;
	private String messageDecription;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageDecription() {
		return messageDecription;
	}

	public void setMessageDecription(String messageDecription) {
		this.messageDecription = messageDecription;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(messageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messages other = (Messages) obj;
		return Objects.equals(messageId, other.messageId);
	}
	
	
	
	
}
