package com.example.demo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	Employee findById(int id);
	
	@Query("SELECT e FROM Employee e WHERE e.status = 'ACTIVE'")
	List<Employee> findActiveProfiles();
	
	@Query("SELECT MAX(e.salary) FROM Employee e WHERE e.department=?1")
	double findMaxSalaryByDepartment(String department);
	
	@Query("SELECT SUM(e.salary) FROM Employee e WHERE e.department=?1")
	double findSumSalaryByDepartment(String department);

	List<Employee> findBydepartment(String department);
	
	@Query("SELECT e FROM Employee e WHERE e.status = 'INACTIVE'")
	List<Employee> findInActiveProfiles();
	
	
	
}
