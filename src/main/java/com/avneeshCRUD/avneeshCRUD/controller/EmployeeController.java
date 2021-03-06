package com.avneeshCRUD.avneeshCRUD.controller;

import java.util.List;

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

import com.avneeshCRUD.avneeshCRUD.custom.exception.BusinessException;
import com.avneeshCRUD.avneeshCRUD.custom.exception.ControllerException;
import com.avneeshCRUD.avneeshCRUD.entity.Employee;
import com.avneeshCRUD.avneeshCRUD.service.EmployeeServiceInterface;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listAllEmployees = employeeServiceInterface.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(listAllEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") Long empidL){
		
		Employee empRetrieved = employeeServiceInterface.getEmployeeById(empidL);
		
		return new ResponseEntity<Employee>(empRetrieved,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try { Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException("611","service error"+e.getMessage());
			return new ResponseEntity<ControllerException> (ce,HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			ControllerException ce = new ControllerException("612","Controller error"+e.getMessage()); 
			return new ResponseEntity<ControllerException> (ce, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{empid}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empid") Long empidL){
			
			employeeServiceInterface.deleteEmployeeById(empidL);
			
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		
	}
	
}
