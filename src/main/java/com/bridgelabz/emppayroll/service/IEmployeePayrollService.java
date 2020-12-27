package com.bridgelabz.emppayroll.service;

import java.util.List;

import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.emppayroll.exception.EmployeePayrollException;
import com.bridgelabz.emppayroll.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayroll(EmployeePayrollDTO empDTO);
	
	Employee updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollData) throws EmployeePayrollException;

	void deleteEmployeePayrollData(int empId) throws EmployeePayrollException;

	List<Employee> getEmployeeList() throws EmployeePayrollException;

	EmployeePayrollDTO getEmployee(int id) throws EmployeePayrollException;
}
