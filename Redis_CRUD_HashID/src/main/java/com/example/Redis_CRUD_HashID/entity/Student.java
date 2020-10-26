package com.example.Redis_CRUD_HashID.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;

@RedisHash(value = "students")
public class Student {
	
	private Long id;
	private String name;
	private String grade;
	
	
	public Student() {
		super();
	}


	public Student(Long id, String name, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
	

}
