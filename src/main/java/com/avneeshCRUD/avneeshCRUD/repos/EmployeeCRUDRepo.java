package com.avneeshCRUD.avneeshCRUD.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.avneeshCRUD.avneeshCRUD.entity.Employee;

@Repository
public interface EmployeeCRUDRepo extends JpaRepository<Employee,Long> {
	
	

	
	
}
