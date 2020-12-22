package com.bridgelabz.emppayroll.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_payroll")
@Getter
@Setter
@AllArgsConstructor
@ToString
public @Data class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int salary;
	private String gender;
	private String profile;
	private String startdate;
	private String notes;
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Department> department = new ArrayList<>();

	public Employee() {
	}

}
