package com.avneeshCRUD.avneeshCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.avneeshCRUD.avneeshCRUD.entity.Employee;
import com.avneeshCRUD.avneeshCRUD.repos.EmployeeCRUDRepo;

@Service
public class EmployeeCRUDService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeCRUDRepo crudRepo;
	
	@Override
	public List<Employee> getAllEmployees(){
		 return crudRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = crudRepo.save(employee) ;
		return savedEmployee;
		
	}

	@Override
	public Employee getEmployeeById(Long empidL) {
		
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmployeeById(Long empidL) {
		crudRepo.deleteById(empidL);
		
	}
}
