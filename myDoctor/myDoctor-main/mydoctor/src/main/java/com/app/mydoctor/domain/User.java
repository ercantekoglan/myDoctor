package com.app.mydoctor.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userIdd;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private LocalDate birthDate;
	private String gender;
	
	@OneToOne(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "auth_id"))
	private Set<Authority> authorities = new HashSet<>();
	
	@ManyToMany(mappedBy = "users")
	private List<Sickness> sickness = new LinkedList<>();
	
	@ManyToMany(mappedBy = "users")
	private List<Education> education = new LinkedList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Messages> messages = new LinkedList<>();
	

	public Long getUserIdd() {
		return userIdd;
	}
	public void setUserIdd(Long userIdd) {
		this.userIdd = userIdd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	public void setSickness(List<Sickness> sickness) {
		this.sickness = sickness;
	}
	public List<Education> getEducation() {
		return education;
	}
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userIdd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userIdd, other.userIdd);
	}
	
	
	
}
