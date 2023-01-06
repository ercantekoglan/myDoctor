package com.app.mydoctor.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Sickness {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String illnessTitle;
	private String illnessSemptoms;
	private String illnessAdvices;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "user_sick",
	           joinColumns = @JoinColumn(name = "sick_id"), 
	           inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new LinkedList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIllnessTitle() {
		return illnessTitle;
	}


	public void setIllnessTitle(String illnessTitle) {
		this.illnessTitle = illnessTitle;
	}


	public String getIllnessSemptoms() {
		return illnessSemptoms;
	}


	public void setIllnessSemptoms(String illnessSemptoms) {
		this.illnessSemptoms = illnessSemptoms;
	}


	public String getIllnessAdvices() {
		return illnessAdvices;
	}


	public void setIllnessAdvices(String illnessAdvices) {
		this.illnessAdvices = illnessAdvices;
	}

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sickness other = (Sickness) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
