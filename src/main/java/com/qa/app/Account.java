package com.qa.app;

import javax.persistence.*;

@Entity
public class Account 
{
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column  (name = "first_name")
	private String firstName;
	@Column
	private String surname;
	@Column (name = "account_number")
	private Integer accountNumber;
	
	public Account()
	{}
	

}
