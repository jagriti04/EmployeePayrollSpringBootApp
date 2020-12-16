package com.bridgelabz.emppayroll.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_payroll")
@Getter
@Setter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private int salary;
	@Column(name = "gender")
	private char gender;
	@Column(name = "start")
	private Date start;

	public int getId() {
		return id;
	}

	public void setId(int empId) {
		this.id = empId;
	}
}
