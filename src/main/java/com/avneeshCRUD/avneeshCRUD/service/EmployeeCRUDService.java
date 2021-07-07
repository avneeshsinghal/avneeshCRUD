package com.avneeshCRUD.avneeshCRUD.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avneeshCRUD.avneeshCRUD.custom.exception.BusinessException;
import com.avneeshCRUD.avneeshCRUD.entity.Employee;
import com.avneeshCRUD.avneeshCRUD.repos.EmployeeCRUDRepo;

@Service
public class EmployeeCRUDService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeCRUDRepo crudRepo;
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> empList;
		try {
		empList = crudRepo.findAll();
		}catch (Exception e) {
			throw new BusinessException("605", "Something went wrong, service layer, all employees"+e.getMessage());
		}
		if(empList.isEmpty()) 
		{
			throw new BusinessException("604", "Empty List , nothing to return.");
		}
		return empList;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, noRollbackFor = EntityNotFoundException.class)
	public Employee addEmployee(Employee employee) {
		
		if(employee.getName().isEmpty() || employee.getName().length()==0) {
			throw new BusinessException("601", "Empty Name.");
		}
		try {
		Employee savedEmployee = crudRepo.save(employee) ;
		return savedEmployee;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Employee Name empty."+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603", "employee service layer error."+e.getMessage());
		}
		
		
	}

	@Override
	public Employee getEmployeeById(Long empidL) {
		try {
		
		return crudRepo.findById(empidL).get();
		}
		catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Invalid ID"+e.getMessage());
		}catch (NoSuchElementException e) {
			throw new BusinessException("607", "Employee doesnt exist"+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("608", "employee service layer error."+e.getMessage());
		}
	}

	@Override
	public void deleteEmployeeById(Long empidL) {
		crudRepo.deleteById(empidL);
		
	}
}
