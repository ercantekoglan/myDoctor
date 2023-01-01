package com.mydoctor.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class School {

	private Long schoolId;
	private String schoolName;
	private String field;
	private String minorArea;
	private Date graduationDate;

	private List<Doctor> doctors = new LinkedList<>();

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

	@ManyToMany(mappedBy = "schools")
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
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
