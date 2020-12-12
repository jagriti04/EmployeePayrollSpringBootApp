package com.bridgelabz.emppayroll.service;

import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.emppayroll.model.Employee;

public interface IEmployeePayrollService {
	
	Employee addEmployeePayroll(EmployeePayrollDTO empDTO);
}
