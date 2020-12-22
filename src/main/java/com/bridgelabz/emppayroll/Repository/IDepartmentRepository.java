package com.bridgelabz.emppayroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.emppayroll.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
