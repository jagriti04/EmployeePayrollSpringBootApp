package com.bridgelabz.emppayroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.emppayroll.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Integer> {
//	Employee findByEmailId(String email);
}
