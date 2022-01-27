package com.agendamento.tranca.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.agendamento.tranca.enums.BraidSize;
import com.agendamento.tranca.enums.BraidType;


@Entity
public class Scheduling {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Age")
	private Integer age;
	@Column(name = "Phone")
	private String phone;
	@Column(name= "Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	@Column(name = "BraidType")
	@Enumerated(EnumType.STRING)
	private BraidType braidType;
	@Column(name = "BraidSize")
	@Enumerated(EnumType.STRING)
	private BraidSize braidSize;
	
	public Scheduling() {
		
	}

	public Scheduling(Integer id, String name, Integer age, String phone, Date data, BraidType braidType,
			BraidSize braidSize) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.data = data;
		this.braidType = braidType;
		this.braidSize = braidSize;
	}


	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BraidType getBraidType() {
		return braidType;
	}

	public void setBraidType(BraidType braidType) {
		this.braidType = braidType;
	}

	public BraidSize getBraidSize() {
		return braidSize;
	}

	public void setBraidSize(BraidSize braidSize) {
		this.braidSize = braidSize;
	}

	
}
