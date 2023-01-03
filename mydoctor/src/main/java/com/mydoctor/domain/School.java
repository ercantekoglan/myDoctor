package com.mydoctor.domain;

import java.util.Date;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {

	private Long schoolId;
	private String schoolName;
	private String field;
	private String minorArea;
	private Date graduationDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return schoolId;
	}

	public void setId(Long id) {
		this.schoolId = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getFiled() {
		return field;
	}

	public void setFiled(String filed) {
		this.field = filed;
	}

	public String getMinorArea() {
		return minorArea;
	}

	public void setMinorArea(String minorArea) {
		this.minorArea = minorArea;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(schoolId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof School)) {
			return false;
		}
		School other = (School) obj;
		return Objects.equals(schoolId, other.schoolId);
	}

}
