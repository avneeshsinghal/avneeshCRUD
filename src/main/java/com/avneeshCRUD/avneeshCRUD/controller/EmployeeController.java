package com.avneeshCRUD.avneeshCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avneeshCRUD.avneeshCRUD.entity.Employee;
import com.avneeshCRUD.avneeshCRUD.repos.EmployeeCRUDRepo;


@RestController
@RequestMapping("/getEmployees")
public class EmployeeController {
	
	@Autowired
	EmployeeCRUDRepo empCrud;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		System.out.println("getting all employees");
		
		return empCrud.findAll();
	}
}
