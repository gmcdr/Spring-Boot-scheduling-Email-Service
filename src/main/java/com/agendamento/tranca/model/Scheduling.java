package com.agendamento.tranca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.agendamento.tranca.enums.BraidSize;
import com.agendamento.tranca.enums.BraidType;


@Entity
public class Scheduling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "Name", nullable = false)
	@Size(min = 3, max = 50)
	private String name;
	@Column(name = "Age", nullable = false)
	@Size(min = 1, max = 3)
	private String age;
	@Column(name = "Phone", nullable = false)
	@Size(max = 15)
	private String phone;
	@Column(name= "Date", nullable = false)
	@Size(max = 12)
	/*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
	private String data;
	@Column(name = "Hour", nullable = false)
	@Size(max = 10)
	private String hour;
	@Column(name = "BraidType", nullable = false)
	@Enumerated(EnumType.STRING)
	private BraidType braidType;
	@Column(name = "BraidSize", nullable = false)
	@Enumerated(EnumType.STRING)
	private BraidSize braidSize;
	@Column(name = "Email", nullable = false)
	@Size(min = 8, max = 50)
	private String email;
	
	
	@Column(name = "Mes")
	private String mes;
	
	public Scheduling() {
		
	}



	public Scheduling(Integer id, @Size(min = 3, max = 50) String name, @Size(min = 1, max = 3) String age,
			@Size(max = 15) String phone, @Size(max = 12) String data, @Size(max = 10) String hour, BraidType braidType,
			BraidSize braidSize, @Size(min = 8, max = 50) String email, String mes) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.data = data;
		this.hour = hour;
		this.braidType = braidType;
		this.braidSize = braidSize;
		this.email = email;
		this.mes = mes;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes =mes;

	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
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



	public String getAge() {
		return age;
	}


	public void setAge(String age) {
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


	@Override
	public String toString() {
		return "Dados do Agendamento | Nome: " + name + ", Idade: " + age + ", Telefone: " + phone + ", Data: " + data
				+ ", Hora: " + hour + ", Tipo de trança: " + braidType + ", Tamanho da trança: " + braidSize + ", Email: " + email + "";
	}

	
}
