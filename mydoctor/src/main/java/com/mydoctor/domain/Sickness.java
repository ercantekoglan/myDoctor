package com.mydoctor.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sickness {
	
	private Long id;
	private String illnessTitle;
	private String illnessSemptoms;
	private String illnessAdvices;
	
	private List<User> users;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(length = 50)
	public String getIllnessTitle() {
		return illnessTitle;
	}

	public void setIllnessTitle(String illnessTitle) {
		this.illnessTitle = illnessTitle;
	}
	@Column(length = 250)
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
	@ManyToMany(mappedBy = "sicknesses")
	public List<User> getPatients() {
		return users;
	}

	public void setPatients(List<User> patients) {
		this.users = patients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Sickness)) {
			return false;
		}
		Sickness other = (Sickness) obj;
		return Objects.equals(id, other.id);
	}

	
}
