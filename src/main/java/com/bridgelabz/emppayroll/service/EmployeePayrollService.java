package com.bridgelabz.emppayroll.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.emppayroll.Repository.IDepartmentRepository;
import com.bridgelabz.emppayroll.Repository.IEmployeePayrollRepository;
import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.emppayroll.exception.EmployeePayrollException;
import com.bridgelabz.emppayroll.model.Employee;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	private IEmployeePayrollRepository empPayrollRepo;

	@Autowired
	private IDepartmentRepository deptRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Employee addEmployeePayroll(EmployeePayrollDTO empDTO) {
		Employee employee = modelMapper.map(empDTO, Employee.class);
		return empPayrollRepo.save(employee);
	}

	@Override
	public Employee updateEmployeePayrollData(int id, EmployeePayrollDTO empData) throws EmployeePayrollException {
		System.out.println("Update method ---- " + empData);
		Employee emp = empPayrollRepo.findById(id)
				.orElseThrow(() -> new EmployeePayrollException("No data with given id"));
		modelMapper.map(empData, emp);
		System.out.println("in update method----" + emp);
		return empPayrollRepo.save(emp);
	}

	@Override
	public void deleteEmployeePayrollData(int id) throws EmployeePayrollException {
		Employee emp = empPayrollRepo.findById(id)
				.orElseThrow(() -> new EmployeePayrollException("No data with given id"));
		empPayrollRepo.deleteById(id);
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeePayrollException {
		List<Employee> listOfEmployees = empPayrollRepo.findAll();
		if (listOfEmployees == null || listOfEmployees.isEmpty()) {
			throw new EmployeePayrollException("No Data Found");
		}
		return listOfEmployees;
	}

	@Override
	public EmployeePayrollDTO getEmployee(int id) throws EmployeePayrollException {
		Employee employee = empPayrollRepo.findById(id)
				.orElseThrow(() -> new EmployeePayrollException("No data found for given id"));
		EmployeePayrollDTO empDTO = modelMapper.map(employee, EmployeePayrollDTO.class);
		return empDTO;
	}

}
