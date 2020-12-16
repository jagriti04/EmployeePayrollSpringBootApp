package com.bridgelabz.emppayroll.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeePayrollDTO {

	@Size(max = 25, min = 2, message = "Name length should be between 3-25")
	public String name;
	@Min(value = 2, message = "Salary digit should be greater than 1")
	public int salary;
	private char gender;
	private Date start;

}
