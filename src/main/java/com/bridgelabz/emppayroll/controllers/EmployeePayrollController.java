package com.bridgelabz.emppayroll.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.emppayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.emppayroll.dto.ResponseDTO;
import com.bridgelabz.emppayroll.exception.EmployeePayrollException;
import com.bridgelabz.emppayroll.exception.GlobalExceptionHandler;
import com.bridgelabz.emppayroll.model.Employee;
import com.bridgelabz.emppayroll.service.IEmployeePayrollService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService empPayrollService;
	
	@ApiOperation(value = "This api is used for demo purpose only.", notes = "Enter empId in int form", response = Employee.class)
	@GetMapping
	public String demo() {
		return "hello";
	}
	
	/**
	 * This api is used to get the list of employees from database.
	 * @param 
	 * @return ResponseEntity
	 * @throws EmployeePayrollException 
	 */
	@GetMapping(value = {"/employees-list"})
	public ResponseEntity<List<Employee>> getEmployeeList() throws EmployeePayrollException {
		return new ResponseEntity<List<Employee>>(empPayrollService.getEmployeeList() , HttpStatus.OK) ;
	}
	
	/**
	 * This api is used to find an employee from database.
	 * @param id
	 * @return ResponseEntity
	 * @throws EmployeePayrollException 
	 */
	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<EmployeePayrollDTO> getEmployeeById(@PathVariable int id) throws EmployeePayrollException {
		return new ResponseEntity<EmployeePayrollDTO>(empPayrollService.getEmployee(id), HttpStatus.OK);
	}
	
	/**
	 * This api is used to add new Employee to db.
	 * @param empDto
	 * @return
	 */
	@PostMapping(value = "/register-employee")
	public ResponseEntity<ResponseDTO> addEmployeeEntity(@Valid @RequestBody EmployeePayrollDTO empDto) {
		empPayrollService.addEmployeePayroll(empDto);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added emp payroll data"), HttpStatus.CREATED);
	}
	
	/**
	 * this api is used to update data
	 * @param empId
	 * @param empPayrollData
	 * @return
	 * @throws EmployeePayrollException 
	 */
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("id") int empId, @RequestBody EmployeePayrollDTO empPayrollData) throws EmployeePayrollException{
		empPayrollService.updateEmployeePayrollData(empId, empPayrollData); 
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Updated emp payroll data"), HttpStatus.OK);
	}

	/**
	 * @param empId
	 * @return
	 * @throws GlobalExceptionHandler
	 */
	@DeleteMapping("/remove-employee/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("id") int empId) throws EmployeePayrollException{
		empPayrollService.deleteEmployeePayrollData(empId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deleted data successfully"),HttpStatus.OK);
	}
}
