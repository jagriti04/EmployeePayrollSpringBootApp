package com.bridgelabz.emppayroll.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String department;
	@JsonIgnore
	@ManyToMany(mappedBy = "department")
	List<Employee> employee = new ArrayList<>();

	public Department() {
		
	}
}
