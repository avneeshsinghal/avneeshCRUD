package com.avneeshCRUD.avneeshCRUD.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.avneeshCRUD.avneeshCRUD.entity.Employee;

public interface EmployeeServiceInterface {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long empidL);

	void deleteEmployeeById(Long empidL);

}
