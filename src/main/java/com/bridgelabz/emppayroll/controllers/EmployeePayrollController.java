package com.bridgelabz.emppayroll.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bridgelabz.emppayroll.exception.GlobalExceptionHandler;
import com.bridgelabz.emppayroll.model.Employee;
import com.bridgelabz.emppayroll.service.IEmployeePayrollService;

import io.swagger.annotations.ApiOperation;

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
	
	@GetMapping("/get")
	public ResponseEntity<String> getEmployeeDetails() {
		return new ResponseEntity<String>("Employee Data", HttpStatus.OK);
	}
	
	/**
	 * This api is used to add new Employee to db.
	 * @param empDto
	 * @return
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> addEmployeeEntity(@RequestBody @Valid EmployeePayrollDTO empDto) {
		Employee emp = empPayrollService.addEmployeePayroll(empDto);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Added emp payroll data"), HttpStatus.CREATED);
	}
	
	/**
	 * this api is used to update data
	 * @param empId
	 * @param empPayrollData
	 * @return
	 */
	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody Employee empPayrollData){
		Employee empData = null;
		empData = empPayrollService.updateEmployeePayrollData(empId, empPayrollData); 
		return new ResponseEntity<String>("Updated emp payroll data", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) throws GlobalExceptionHandler{
		empPayrollService.deleteEmployeePayrollData(empId);
		return new ResponseEntity<String>("Deleted data successfully",HttpStatus.OK);
	}
}
