package com.bridgelabz.emppayroll.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.bridgelabz.emppayroll.model.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmployeePayrollDTO {

	@Size(max = 25, min = 2, message = "Name length should be between 3-25")
	public String name;
	@Min(value = 2, message = "Salary digit should be greater than 1")
	public int salary;
	public String gender;
	public String profile;
	public String startdate;
	public String notes;
	public List<Department> department;
		
	public EmployeePayrollDTO() {
		
	}
	
	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + ", gender=" + gender + ", profile=" + profile
				+ ", startdate=" + startdate + ", notes=" + notes + ", department=" + department + "]";
	}
	
}
