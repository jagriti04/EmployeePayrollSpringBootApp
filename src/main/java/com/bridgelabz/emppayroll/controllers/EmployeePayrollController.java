package com.bridgelabz.emppayroll.controllers;

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
import com.bridgelabz.emppayroll.model.Employee;
import com.bridgelabz.emppayroll.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService empPayrollService;
	
	@GetMapping
	public String demo() {
		return "hello";
	}
	
	@GetMapping("/get")
	public ResponseEntity getEmployeeDetails() {
		return null;
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<String> addEmployeeEntity(@RequestBody EmployeePayrollDTO empDto) {
		empPayrollService.addEmployeePayroll(empDto);
		return new ResponseEntity<String>("Added emp payroll data", HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody Employee empPayrollData){
	 return null;
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity deleteEmployeePayrollData(@PathVariable("empId") int empId){
		return null;
	}
}
