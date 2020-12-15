package com.bridgelabz.emppayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmpPayrollAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpPayrollAppApplication.class, args);
	}

}
