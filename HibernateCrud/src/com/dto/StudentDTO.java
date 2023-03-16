package com.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "StduentData")
public class StudentDTO implements Serializable {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private String fName;
	private String lNAme;
	private Integer rollNo;
	private String language;
	private String frameWork;

	public StudentDTO() {
		super();
		System.out.println("Student Contructor Calling");
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlNAme() {
		return lNAme;
	}

	public void setlNAme(String lNAme) {
		this.lNAme = lNAme;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFrameWork() {
		return frameWork;
	}

	public void setFrameWork(String frameWork) {
		this.frameWork = frameWork;
	}

	@Override
	public String toString() {
		return "Id=" + Id + ", fName=" + fName + ", lNAme=" + lNAme + ", rollNo=" + rollNo + ", language=" + language
				+ ", frameWork=" + frameWork;
	}

}
