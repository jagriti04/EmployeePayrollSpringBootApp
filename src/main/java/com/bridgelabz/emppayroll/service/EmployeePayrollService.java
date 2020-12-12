package com.bridgelabz.emppayroll.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.emppayroll.Repository.IEmployeePayrollRepository;
import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.emppayroll.model.Employee;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository empPayrollRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Employee addEmployeePayroll(EmployeePayrollDTO empDTO) {
//		Employee employee = new Employee(empDTO);
		Employee employee = modelMapper.map(empDTO, Employee.class);
		return empPayrollRepo.save(employee);
	}

}
