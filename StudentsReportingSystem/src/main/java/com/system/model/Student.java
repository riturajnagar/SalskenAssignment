package com.system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "student")
public class Student {

	@Id
	private Integer rollNum;
	private String name;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer semester;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer rollNum, String name, Integer english, Integer maths, Integer science, Integer semester) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.semester = semester;
	}

	public Integer getRollNum() {
		return rollNum;
	}

	public void setRollNum(Integer rollNum) {
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + ", english=" + english + ", maths=" + maths
				+ ", science=" + science + ", semester=" + semester + "]";
	}

}
